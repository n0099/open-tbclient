package com.alibaba.fastjson.support.spring;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@ControllerAdvice
@Deprecated
@Order(Integer.MIN_VALUE)
/* loaded from: classes7.dex */
public class FastJsonpResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern CALLBACK_PARAM_PATTERN;
    public static final String[] DEFAULT_JSONP_QUERY_PARAM_NAMES;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] jsonpQueryParamNames;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(243858776, "Lcom/alibaba/fastjson/support/spring/FastJsonpResponseBodyAdvice;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(243858776, "Lcom/alibaba/fastjson/support/spring/FastJsonpResponseBodyAdvice;");
                return;
            }
        }
        CALLBACK_PARAM_PATTERN = Pattern.compile("[0-9A-Za-z_\\.]*");
        DEFAULT_JSONP_QUERY_PARAM_NAMES = new String[]{"callback", "jsonp"};
    }

    public FastJsonpResponseBodyAdvice() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.jsonpQueryParamNames = DEFAULT_JSONP_QUERY_PARAM_NAMES;
    }

    public Object beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> cls, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{obj, methodParameter, mediaType, cls, serverHttpRequest, serverHttpResponse})) == null) {
            MappingFastJsonValue orCreateContainer = getOrCreateContainer(obj);
            beforeBodyWriteInternal(orCreateContainer, mediaType, methodParameter, serverHttpRequest, serverHttpResponse);
            return orCreateContainer;
        }
        return invokeCommon.objValue;
    }

    public void beforeBodyWriteInternal(MappingFastJsonValue mappingFastJsonValue, MediaType mediaType, MethodParameter methodParameter, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mappingFastJsonValue, mediaType, methodParameter, serverHttpRequest, serverHttpResponse) == null) {
            HttpServletRequest servletRequest = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();
            for (String str : this.jsonpQueryParamNames) {
                String parameter = servletRequest.getParameter(str);
                if (parameter != null && isValidJsonpQueryParam(parameter)) {
                    mappingFastJsonValue.setJsonpFunction(parameter);
                    return;
                }
            }
        }
    }

    public MediaType getContentType(MediaType mediaType, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mediaType, serverHttpRequest, serverHttpResponse)) == null) ? new MediaType("application", "javascript") : (MediaType) invokeLLL.objValue;
    }

    public MappingFastJsonValue getOrCreateContainer(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? obj instanceof MappingFastJsonValue ? (MappingFastJsonValue) obj : new MappingFastJsonValue(obj) : (MappingFastJsonValue) invokeL.objValue;
    }

    public boolean isValidJsonpQueryParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? CALLBACK_PARAM_PATTERN.matcher(str).matches() : invokeL.booleanValue;
    }

    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, methodParameter, cls)) == null) ? FastJsonHttpMessageConverter.class.isAssignableFrom(cls) : invokeLL.booleanValue;
    }

    public FastJsonpResponseBodyAdvice(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Assert.isTrue(!ObjectUtils.isEmpty(strArr), "At least one query param name is required");
        this.jsonpQueryParamNames = strArr;
    }
}
