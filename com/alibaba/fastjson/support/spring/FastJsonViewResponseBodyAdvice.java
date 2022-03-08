package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@ControllerAdvice
@Order
/* loaded from: classes3.dex */
public class FastJsonViewResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FastJsonViewResponseBodyAdvice() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private FastJsonContainer getOrCreateContainer(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, obj)) == null) ? obj instanceof FastJsonContainer ? (FastJsonContainer) obj : new FastJsonContainer(obj) : (FastJsonContainer) invokeL.objValue;
    }

    /* renamed from: beforeBodyWrite  reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m7beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class cls, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return beforeBodyWrite(obj, methodParameter, mediaType, (Class<? extends HttpMessageConverter<?>>) cls, serverHttpRequest, serverHttpResponse);
    }

    public void beforeBodyWriteInternal(FastJsonContainer fastJsonContainer, MediaType mediaType, MethodParameter methodParameter, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, fastJsonContainer, mediaType, methodParameter, serverHttpRequest, serverHttpResponse) == null) {
            FastJsonView fastJsonView = (FastJsonView) methodParameter.getMethodAnnotation(FastJsonView.class);
            FastJsonFilter[] include = fastJsonView.include();
            FastJsonFilter[] exclude = fastJsonView.exclude();
            PropertyPreFilters propertyPreFilters = new PropertyPreFilters();
            for (FastJsonFilter fastJsonFilter : include) {
                propertyPreFilters.addFilter(fastJsonFilter.clazz(), fastJsonFilter.props());
            }
            for (FastJsonFilter fastJsonFilter2 : exclude) {
                propertyPreFilters.addFilter(fastJsonFilter2.clazz(), new String[0]).addExcludes(fastJsonFilter2.props());
            }
            fastJsonContainer.setFilters(propertyPreFilters);
        }
    }

    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, methodParameter, cls)) == null) ? FastJsonHttpMessageConverter.class.isAssignableFrom(cls) && methodParameter.hasMethodAnnotation(FastJsonView.class) : invokeLL.booleanValue;
    }

    public FastJsonContainer beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> cls, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{obj, methodParameter, mediaType, cls, serverHttpRequest, serverHttpResponse})) == null) {
            FastJsonContainer orCreateContainer = getOrCreateContainer(obj);
            beforeBodyWriteInternal(orCreateContainer, mediaType, methodParameter, serverHttpRequest, serverHttpResponse);
            return orCreateContainer;
        }
        return (FastJsonContainer) invokeCommon.objValue;
    }
}
