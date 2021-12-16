package com.alibaba.fastjson.support.spring.messaging;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.util.MimeType;
/* loaded from: classes9.dex */
public class MappingFastJsonMessageConverter extends AbstractMessageConverter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FastJsonConfig fastJsonConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MappingFastJsonMessageConverter() {
        super(new MimeType("application", "json", Charset.forName("UTF-8")));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((MimeType) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fastJsonConfig = new FastJsonConfig();
    }

    public boolean canConvertFrom(Message<?> message, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, message, cls)) == null) ? supports(cls) : invokeLL.booleanValue;
    }

    public boolean canConvertTo(Object obj, MessageHeaders messageHeaders) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, messageHeaders)) == null) ? supports(obj.getClass()) : invokeLL.booleanValue;
    }

    public Object convertFromInternal(Message<?> message, Class<?> cls, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, message, cls, obj)) == null) {
            Object payload = message.getPayload();
            if (payload instanceof byte[]) {
                return JSON.parseObject((byte[]) payload, this.fastJsonConfig.getCharset(), cls, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
            }
            if (payload instanceof String) {
                return JSON.parseObject((String) payload, cls, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    public Object convertToInternal(Object obj, MessageHeaders messageHeaders, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, obj, messageHeaders, obj2)) == null) {
            if (byte[].class != getSerializedPayloadClass()) {
                return ((obj instanceof String) && JSON.isValid((String) obj)) ? obj : JSON.toJSONString(obj, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (JSON.isValid(str)) {
                    return str.getBytes(this.fastJsonConfig.getCharset());
                }
            }
            return JSON.toJSONBytesWithFastJsonConfig(this.fastJsonConfig.getCharset(), obj, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
        }
        return invokeLLL.objValue;
    }

    public FastJsonConfig getFastJsonConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.fastJsonConfig : (FastJsonConfig) invokeV.objValue;
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fastJsonConfig) == null) {
            this.fastJsonConfig = fastJsonConfig;
        }
    }

    public boolean supports(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cls)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }
}
