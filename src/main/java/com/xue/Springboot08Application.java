package com.xue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.xue.util.filter.CustomFilter;
import com.xue.util.listener.CustomListener;
import com.xue.util.servlet.CustomServlet;

@SpringBootApplication
public class Springboot08Application {
	
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new CustomServlet(), "/roncoo");
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		return new FilterRegistrationBean(new CustomFilter(), servletRegistrationBean());
	}

	@Bean
	public ServletListenerRegistrationBean<CustomListener> servletListenerRegistrationBean() {
		return new ServletListenerRegistrationBean<CustomListener>(new CustomListener());
	}
	public static void main(String[] args) {
		SpringApplication.run(Springboot08Application.class, args);
	}
}
