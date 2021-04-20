package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
/* loaded from: classes.dex */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    public FastJsonConfig fastJsonConfig = new FastJsonConfig();
    public Class<T> type;

    public FastJsonRedisSerializer(Class<T> cls) {
        this.type = cls;
    }

    public T deserialize(byte[] bArr) throws SerializationException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return (T) JSON.parseObject(bArr, this.fastJsonConfig.getCharset(), this.type, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
        } catch (Exception e2) {
            throw new SerializationException("Could not deserialize: " + e2.getMessage(), e2);
        }
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        try {
            return JSON.toJSONBytesWithFastJsonConfig(this.fastJsonConfig.getCharset(), t, this.fastJsonConfig.getSerializeConfig(), this.fastJsonConfig.getSerializeFilters(), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
        } catch (Exception e2) {
            throw new SerializationException("Could not serialize: " + e2.getMessage(), e2);
        }
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        this.fastJsonConfig = fastJsonConfig;
    }
}
