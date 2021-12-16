package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
/* loaded from: classes9.dex */
public class GenericFastJsonRedisSerializer implements RedisSerializer<Object> {
    public static /* synthetic */ Interceptable $ic;
    public static final ParserConfig defaultRedisConfig;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1168595749, "Lcom/alibaba/fastjson/support/spring/GenericFastJsonRedisSerializer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1168595749, "Lcom/alibaba/fastjson/support/spring/GenericFastJsonRedisSerializer;");
                return;
            }
        }
        ParserConfig parserConfig = new ParserConfig();
        defaultRedisConfig = parserConfig;
        parserConfig.setAutoTypeSupport(true);
    }

    public GenericFastJsonRedisSerializer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public Object deserialize(byte[] bArr) throws SerializationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                return JSON.parseObject(new String(bArr, IOUtils.UTF8), Object.class, defaultRedisConfig, new Feature[0]);
            } catch (Exception e2) {
                throw new SerializationException("Could not deserialize: " + e2.getMessage(), e2);
            }
        }
        return invokeL.objValue;
    }

    public byte[] serialize(Object obj) throws SerializationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == null) {
                return new byte[0];
            }
            try {
                return JSON.toJSONBytes(obj, SerializerFeature.WriteClassName);
            } catch (Exception e2) {
                throw new SerializationException("Could not serialize: " + e2.getMessage(), e2);
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
