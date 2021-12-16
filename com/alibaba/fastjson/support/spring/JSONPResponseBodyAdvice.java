package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.alibaba.fastjson.util.IOUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@ControllerAdvice
@Order(Integer.MIN_VALUE)
/* loaded from: classes9.dex */
public class JSONPResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Log logger;

    public JSONPResponseBodyAdvice() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.logger = LogFactory.getLog(JSONPResponseBodyAdvice.class);
    }

    public Object beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> cls, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{obj, methodParameter, mediaType, cls, serverHttpRequest, serverHttpResponse})) == null) {
            ResponseJSONP responseJSONP = (ResponseJSONP) methodParameter.getMethodAnnotation(ResponseJSONP.class);
            if (responseJSONP == null) {
                responseJSONP = (ResponseJSONP) methodParameter.getContainingClass().getAnnotation(ResponseJSONP.class);
            }
            String parameter = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getParameter(responseJSONP.callback());
            if (!IOUtils.isValidJsonpQueryParam(parameter)) {
                if (this.logger.isDebugEnabled()) {
                    Log log = this.logger;
                    log.debug("Invalid jsonp parameter value:" + parameter);
                }
                parameter = null;
            }
            JSONPObject jSONPObject = new JSONPObject(parameter);
            jSONPObject.addParameter(obj);
            beforeBodyWriteInternal(jSONPObject, mediaType, methodParameter, serverHttpRequest, serverHttpResponse);
            return jSONPObject;
        }
        return invokeCommon.objValue;
    }

    public void beforeBodyWriteInternal(JSONPObject jSONPObject, MediaType mediaType, MethodParameter methodParameter, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONPObject, mediaType, methodParameter, serverHttpRequest, serverHttpResponse) == null) {
        }
    }

    public MediaType getContentType(MediaType mediaType, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mediaType, serverHttpRequest, serverHttpResponse)) == null) ? FastJsonHttpMessageConverter.APPLICATION_JAVASCRIPT : (MediaType) invokeLLL.objValue;
    }

    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, methodParameter, cls)) == null) ? FastJsonHttpMessageConverter.class.isAssignableFrom(cls) && (methodParameter.getContainingClass().isAnnotationPresent(ResponseJSONP.class) || methodParameter.hasMethodAnnotation(ResponseJSONP.class)) : invokeLL.booleanValue;
    }
}
