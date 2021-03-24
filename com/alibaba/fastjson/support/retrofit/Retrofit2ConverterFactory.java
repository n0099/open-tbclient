package com.alibaba.fastjson.support.retrofit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
/* loaded from: classes.dex */
public class Retrofit2ConverterFactory extends Converter.Factory {
    public Feature[] features;
    public SerializeConfig serializeConfig;
    public SerializerFeature[] serializerFeatures;
    public static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    public static final Feature[] EMPTY_SERIALIZER_FEATURES = new Feature[0];
    public ParserConfig parserConfig = ParserConfig.getGlobalInstance();
    public int featureValues = JSON.DEFAULT_PARSER_FEATURE;

    /* loaded from: classes.dex */
    public final class RequestBodyConverter<T> implements Converter<T, RequestBody> {
        public RequestBodyConverter() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ /* synthetic */ Object convert(Object obj) throws IOException {
            return m6convert((RequestBodyConverter<T>) obj);
        }

        /* renamed from: convert  reason: collision with other method in class */
        public RequestBody m6convert(T t) throws IOException {
            return RequestBody.create(Retrofit2ConverterFactory.MEDIA_TYPE, JSON.toJSONBytes(t, Retrofit2ConverterFactory.this.serializeConfig == null ? SerializeConfig.globalInstance : Retrofit2ConverterFactory.this.serializeConfig, Retrofit2ConverterFactory.this.serializerFeatures == null ? SerializerFeature.EMPTY : Retrofit2ConverterFactory.this.serializerFeatures));
        }
    }

    /* loaded from: classes.dex */
    public final class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {
        public Type type;

        public ResponseBodyConverter(Type type) {
            this.type = type;
        }

        /* JADX DEBUG: Method merged with bridge method */
        public T convert(ResponseBody responseBody) throws IOException {
            try {
                return (T) JSON.parseObject(responseBody.string(), this.type, Retrofit2ConverterFactory.this.parserConfig, Retrofit2ConverterFactory.this.featureValues, Retrofit2ConverterFactory.this.features != null ? Retrofit2ConverterFactory.this.features : Retrofit2ConverterFactory.EMPTY_SERIALIZER_FEATURES);
            } finally {
                responseBody.close();
            }
        }
    }

    public ParserConfig getParserConfig() {
        return this.parserConfig;
    }

    public int getParserFeatureValues() {
        return this.featureValues;
    }

    public Feature[] getParserFeatures() {
        return this.features;
    }

    public SerializeConfig getSerializeConfig() {
        return this.serializeConfig;
    }

    public SerializerFeature[] getSerializerFeatures() {
        return this.serializerFeatures;
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new RequestBodyConverter();
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new ResponseBodyConverter(type);
    }

    public Retrofit2ConverterFactory setParserConfig(ParserConfig parserConfig) {
        this.parserConfig = parserConfig;
        return this;
    }

    public Retrofit2ConverterFactory setParserFeatureValues(int i) {
        this.featureValues = i;
        return this;
    }

    public Retrofit2ConverterFactory setParserFeatures(Feature[] featureArr) {
        this.features = featureArr;
        return this;
    }

    public Retrofit2ConverterFactory setSerializeConfig(SerializeConfig serializeConfig) {
        this.serializeConfig = serializeConfig;
        return this;
    }

    public Retrofit2ConverterFactory setSerializerFeatures(SerializerFeature[] serializerFeatureArr) {
        this.serializerFeatures = serializerFeatureArr;
        return this;
    }
}
