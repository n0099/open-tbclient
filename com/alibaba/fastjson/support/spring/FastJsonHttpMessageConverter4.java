package com.alibaba.fastjson.support.spring;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Type;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
@Deprecated
/* loaded from: classes6.dex */
public class FastJsonHttpMessageConverter4 extends FastJsonHttpMessageConverter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public FastJsonHttpMessageConverter4() {
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

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public boolean canRead(Type type, Class<?> cls, MediaType mediaType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, type, cls, mediaType)) == null) ? super.canRead(type, cls, mediaType) : invokeLLL.booleanValue;
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public boolean canWrite(Type type, Class<?> cls, MediaType mediaType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type, cls, mediaType)) == null) ? super.canWrite(type, cls, mediaType) : invokeLLL.booleanValue;
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public Object read(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, type, cls, httpInputMessage)) == null) ? super.read(type, cls, httpInputMessage) : invokeLLL.objValue;
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public Object readInternal(Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, httpInputMessage)) == null) ? super.readInternal(cls, httpInputMessage) : invokeLL.objValue;
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public boolean supports(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) ? super.supports(cls) : invokeL.booleanValue;
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public void write(Object obj, Type type, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, obj, type, mediaType, httpOutputMessage) == null) {
            super.write(obj, type, mediaType, httpOutputMessage);
        }
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public void writeInternal(Object obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, obj, httpOutputMessage) == null) {
            super.writeInternal(obj, httpOutputMessage);
        }
    }
}
