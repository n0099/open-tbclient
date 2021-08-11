package com.alibaba.fastjson.support.retrofit;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
/* loaded from: classes4.dex */
public class Retrofit2ConverterFactory extends Converter.Factory {
    public static /* synthetic */ Interceptable $ic;
    @Deprecated
    public static final Feature[] EMPTY_SERIALIZER_FEATURES;
    public static final MediaType MEDIA_TYPE;
    public transient /* synthetic */ FieldHolder $fh;
    public FastJsonConfig fastJsonConfig;
    @Deprecated
    public int featureValues;
    @Deprecated
    public Feature[] features;
    @Deprecated
    public ParserConfig parserConfig;
    @Deprecated
    public SerializeConfig serializeConfig;
    @Deprecated
    public SerializerFeature[] serializerFeatures;

    /* loaded from: classes4.dex */
    public final class RequestBodyConverter<T> implements Converter<T, RequestBody> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Retrofit2ConverterFactory this$0;

        public RequestBodyConverter(Retrofit2ConverterFactory retrofit2ConverterFactory) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {retrofit2ConverterFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = retrofit2ConverterFactory;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public /* bridge */ /* synthetic */ Object convert(Object obj) throws IOException {
            return m6convert((RequestBodyConverter<T>) obj);
        }

        /* renamed from: convert  reason: collision with other method in class */
        public RequestBody m6convert(T t) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
                try {
                    return RequestBody.create(Retrofit2ConverterFactory.MEDIA_TYPE, JSON.toJSONBytesWithFastJsonConfig(this.this$0.fastJsonConfig.getCharset(), t, this.this$0.fastJsonConfig.getSerializeConfig(), this.this$0.fastJsonConfig.getSerializeFilters(), this.this$0.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.this$0.fastJsonConfig.getSerializerFeatures()));
                } catch (Exception e2) {
                    throw new IOException("Could not write JSON: " + e2.getMessage(), e2);
                }
            }
            return (RequestBody) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public final class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Retrofit2ConverterFactory this$0;
        public Type type;

        public ResponseBodyConverter(Retrofit2ConverterFactory retrofit2ConverterFactory, Type type) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {retrofit2ConverterFactory, type};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = retrofit2ConverterFactory;
            this.type = type;
        }

        /* JADX DEBUG: Method merged with bridge method */
        public T convert(ResponseBody responseBody) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseBody)) == null) {
                try {
                    try {
                        return (T) JSON.parseObject(responseBody.bytes(), this.this$0.fastJsonConfig.getCharset(), this.type, this.this$0.fastJsonConfig.getParserConfig(), this.this$0.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.this$0.fastJsonConfig.getFeatures());
                    } catch (Exception e2) {
                        throw new IOException("JSON parse error: " + e2.getMessage(), e2);
                    }
                } finally {
                    responseBody.close();
                }
            }
            return (T) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1803738992, "Lcom/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1803738992, "Lcom/alibaba/fastjson/support/retrofit/Retrofit2ConverterFactory;");
                return;
            }
        }
        MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
        EMPTY_SERIALIZER_FEATURES = new Feature[0];
    }

    public Retrofit2ConverterFactory() {
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
        this.parserConfig = ParserConfig.getGlobalInstance();
        this.featureValues = JSON.DEFAULT_PARSER_FEATURE;
        this.fastJsonConfig = new FastJsonConfig();
    }

    public static Retrofit2ConverterFactory create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? create(new FastJsonConfig()) : (Retrofit2ConverterFactory) invokeV.objValue;
    }

    public FastJsonConfig getFastJsonConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.fastJsonConfig : (FastJsonConfig) invokeV.objValue;
    }

    @Deprecated
    public ParserConfig getParserConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fastJsonConfig.getParserConfig() : (ParserConfig) invokeV.objValue;
    }

    @Deprecated
    public int getParserFeatureValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? JSON.DEFAULT_PARSER_FEATURE : invokeV.intValue;
    }

    @Deprecated
    public Feature[] getParserFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.fastJsonConfig.getFeatures() : (Feature[]) invokeV.objValue;
    }

    @Deprecated
    public SerializeConfig getSerializeConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.fastJsonConfig.getSerializeConfig() : (SerializeConfig) invokeV.objValue;
    }

    @Deprecated
    public SerializerFeature[] getSerializerFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.fastJsonConfig.getSerializerFeatures() : (SerializerFeature[]) invokeV.objValue;
    }

    public Converter<Object, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, type, annotationArr, annotationArr2, retrofit)) == null) ? new RequestBodyConverter(this) : (Converter) invokeLLLL.objValue;
    }

    public Converter<ResponseBody, Object> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, type, annotationArr, retrofit)) == null) ? new ResponseBodyConverter(this, type) : (Converter) invokeLLL.objValue;
    }

    public Retrofit2ConverterFactory setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fastJsonConfig)) == null) {
            this.fastJsonConfig = fastJsonConfig;
            return this;
        }
        return (Retrofit2ConverterFactory) invokeL.objValue;
    }

    @Deprecated
    public Retrofit2ConverterFactory setParserConfig(ParserConfig parserConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, parserConfig)) == null) {
            this.fastJsonConfig.setParserConfig(parserConfig);
            return this;
        }
        return (Retrofit2ConverterFactory) invokeL.objValue;
    }

    @Deprecated
    public Retrofit2ConverterFactory setParserFeatureValues(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this : (Retrofit2ConverterFactory) invokeI.objValue;
    }

    @Deprecated
    public Retrofit2ConverterFactory setParserFeatures(Feature[] featureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, featureArr)) == null) {
            this.fastJsonConfig.setFeatures(featureArr);
            return this;
        }
        return (Retrofit2ConverterFactory) invokeL.objValue;
    }

    @Deprecated
    public Retrofit2ConverterFactory setSerializeConfig(SerializeConfig serializeConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, serializeConfig)) == null) {
            this.fastJsonConfig.setSerializeConfig(serializeConfig);
            return this;
        }
        return (Retrofit2ConverterFactory) invokeL.objValue;
    }

    @Deprecated
    public Retrofit2ConverterFactory setSerializerFeatures(SerializerFeature[] serializerFeatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, serializerFeatureArr)) == null) {
            this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
            return this;
        }
        return (Retrofit2ConverterFactory) invokeL.objValue;
    }

    public static Retrofit2ConverterFactory create(FastJsonConfig fastJsonConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, fastJsonConfig)) == null) {
            if (fastJsonConfig != null) {
                return new Retrofit2ConverterFactory(fastJsonConfig);
            }
            throw new NullPointerException("fastJsonConfig == null");
        }
        return (Retrofit2ConverterFactory) invokeL.objValue;
    }

    public Retrofit2ConverterFactory(FastJsonConfig fastJsonConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fastJsonConfig};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.parserConfig = ParserConfig.getGlobalInstance();
        this.featureValues = JSON.DEFAULT_PARSER_FEATURE;
        this.fastJsonConfig = fastJsonConfig;
    }
}
