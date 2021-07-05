package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
/* loaded from: classes.dex */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FastJsonConfig fastJsonConfig;
    public Class<T> type;

    public FastJsonRedisSerializer(Class<T> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fastJsonConfig = new FastJsonConfig();
        this.type = cls;
    }

    public T deserialize(byte[] bArr) throws SerializationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            try {
                return (T) JSON.parseObject(bArr, this.fastJsonConfig.getCharset(), this.type, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
            } catch (Exception e2) {
                throw new SerializationException("Could not deserialize: " + e2.getMessage(), e2);
            }
        }
        return (T) invokeL.objValue;
    }

    public FastJsonConfig getFastJsonConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fastJsonConfig : (FastJsonConfig) invokeV.objValue;
    }

    public byte[] serialize(T t) throws SerializationException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            if (t == null) {
                return new byte[0];
            }
            try {
                return JSON.toJSONBytesWithFastJsonConfig(this.fastJsonConfig.getCharset(), t, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
            } catch (Exception e2) {
                throw new SerializationException("Could not serialize: " + e2.getMessage(), e2);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fastJsonConfig) == null) {
            this.fastJsonConfig = fastJsonConfig;
        }
    }
}
