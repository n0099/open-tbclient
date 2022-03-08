package com.alibaba.fastjson.support.spring;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StringUtils;
/* loaded from: classes3.dex */
public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> implements GenericHttpMessageConverter<Object> {
    public static /* synthetic */ Interceptable $ic;
    public static final MediaType APPLICATION_JAVASCRIPT;
    public transient /* synthetic */ FieldHolder $fh;
    @Deprecated
    public String dateFormat;
    public FastJsonConfig fastJsonConfig;
    @Deprecated
    public SerializerFeature[] features;
    @Deprecated
    public SerializeFilter[] filters;

    /* loaded from: classes3.dex */
    public static class Spring4TypeResolvableHelper {
        public static /* synthetic */ Interceptable $ic;
        public static boolean hasClazzResolvableType;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1419170516, "Lcom/alibaba/fastjson/support/spring/FastJsonHttpMessageConverter$Spring4TypeResolvableHelper;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1419170516, "Lcom/alibaba/fastjson/support/spring/FastJsonHttpMessageConverter$Spring4TypeResolvableHelper;");
                    return;
                }
            }
            try {
                Class.forName("org.springframework.core.ResolvableType");
                hasClazzResolvableType = true;
            } catch (ClassNotFoundException unused) {
                hasClazzResolvableType = false;
            }
        }

        public Spring4TypeResolvableHelper() {
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

        public static Type getType(Type type, Class<?> cls) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, type, cls)) == null) {
                if (cls != null) {
                    ResolvableType forType = ResolvableType.forType(type);
                    if (type instanceof TypeVariable) {
                        ResolvableType resolveVariable = resolveVariable((TypeVariable) type, ResolvableType.forClass(cls));
                        return resolveVariable != ResolvableType.NONE ? resolveVariable.resolve() : type;
                    } else if ((type instanceof ParameterizedType) && forType.hasUnresolvableGenerics()) {
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        Class[] clsArr = new Class[parameterizedType.getActualTypeArguments().length];
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                            Type type2 = actualTypeArguments[i2];
                            if (type2 instanceof TypeVariable) {
                                ResolvableType resolveVariable2 = resolveVariable((TypeVariable) type2, ResolvableType.forClass(cls));
                                if (resolveVariable2 != ResolvableType.NONE) {
                                    clsArr[i2] = resolveVariable2.resolve();
                                } else {
                                    clsArr[i2] = ResolvableType.forType(type2).resolve();
                                }
                            } else {
                                clsArr[i2] = ResolvableType.forType(type2).resolve();
                            }
                        }
                        return ResolvableType.forClassWithGenerics(forType.getRawClass(), clsArr).getType();
                    } else {
                        return type;
                    }
                }
                return type;
            }
            return (Type) invokeLL.objValue;
        }

        public static boolean isSupport() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? hasClazzResolvableType : invokeV.booleanValue;
        }

        public static ResolvableType resolveVariable(TypeVariable<?> typeVariable, ResolvableType resolvableType) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, typeVariable, resolvableType)) == null) {
                if (resolvableType.hasGenerics()) {
                    ResolvableType forType = ResolvableType.forType(typeVariable, resolvableType);
                    if (forType.resolve() != null) {
                        return forType;
                    }
                }
                ResolvableType superType = resolvableType.getSuperType();
                if (superType != ResolvableType.NONE) {
                    ResolvableType resolveVariable = resolveVariable(typeVariable, superType);
                    if (resolveVariable.resolve() != null) {
                        return resolveVariable;
                    }
                }
                for (ResolvableType resolvableType2 : resolvableType.getInterfaces()) {
                    ResolvableType resolveVariable2 = resolveVariable(typeVariable, resolvableType2);
                    if (resolveVariable2.resolve() != null) {
                        return resolveVariable2;
                    }
                }
                return ResolvableType.NONE;
            }
            return (ResolvableType) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1604915858, "Lcom/alibaba/fastjson/support/spring/FastJsonHttpMessageConverter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1604915858, "Lcom/alibaba/fastjson/support/spring/FastJsonHttpMessageConverter;");
                return;
            }
        }
        APPLICATION_JAVASCRIPT = new MediaType(MimeTypes.BASE_TYPE_APPLICATION, "javascript");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastJsonHttpMessageConverter() {
        super(MediaType.ALL);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((MediaType) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.fastJsonConfig = new FastJsonConfig();
    }

    private Object readType(Type type, HttpInputMessage httpInputMessage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, type, httpInputMessage)) == null) {
            try {
                return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
            } catch (JSONException e2) {
                throw new HttpMessageNotReadableException("JSON parse error: " + e2.getMessage(), e2);
            } catch (IOException e3) {
                throw new HttpMessageNotReadableException("I/O error while reading input message", e3);
            }
        }
        return invokeLL.objValue;
    }

    private Object strangeCodeForJackson(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, obj)) == null) ? (obj == null || !"com.fasterxml.jackson.databind.node.ObjectNode".equals(obj.getClass().getName())) ? obj : obj.toString() : invokeL.objValue;
    }

    @Deprecated
    public void addSerializeFilter(SerializeFilter serializeFilter) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, serializeFilter) == null) || serializeFilter == null) {
            return;
        }
        int length = this.fastJsonConfig.getSerializeFilters().length;
        int i2 = length + 1;
        SerializeFilter[] serializeFilterArr = new SerializeFilter[i2];
        System.arraycopy(this.fastJsonConfig.getSerializeFilters(), 0, serializeFilterArr, 0, length);
        serializeFilterArr[i2 - 1] = serializeFilter;
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    public boolean canRead(Type type, Class<?> cls, MediaType mediaType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type, cls, mediaType)) == null) ? super.canRead(cls, mediaType) : invokeLLL.booleanValue;
    }

    public boolean canWrite(Type type, Class<?> cls, MediaType mediaType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, type, cls, mediaType)) == null) ? super.canWrite(cls, mediaType) : invokeLLL.booleanValue;
    }

    @Deprecated
    public Charset getCharset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.fastJsonConfig.getCharset() : (Charset) invokeV.objValue;
    }

    @Deprecated
    public String getDateFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.fastJsonConfig.getDateFormat() : (String) invokeV.objValue;
    }

    public FastJsonConfig getFastJsonConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.fastJsonConfig : (FastJsonConfig) invokeV.objValue;
    }

    @Deprecated
    public SerializerFeature[] getFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.fastJsonConfig.getSerializerFeatures() : (SerializerFeature[]) invokeV.objValue;
    }

    @Deprecated
    public SerializeFilter[] getFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.fastJsonConfig.getSerializeFilters() : (SerializeFilter[]) invokeV.objValue;
    }

    public Type getType(Type type, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, type, cls)) == null) ? Spring4TypeResolvableHelper.isSupport() ? Spring4TypeResolvableHelper.getType(type, cls) : type : (Type) invokeLL.objValue;
    }

    public Object read(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, type, cls, httpInputMessage)) == null) ? readType(getType(type, cls), httpInputMessage) : invokeLLL.objValue;
    }

    public Object readInternal(Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cls, httpInputMessage)) == null) ? readType(getType(cls, null), httpInputMessage) : invokeLL.objValue;
    }

    @Deprecated
    public void setCharset(Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, charset) == null) {
            this.fastJsonConfig.setCharset(charset);
        }
    }

    @Deprecated
    public void setDateFormat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.fastJsonConfig.setDateFormat(str);
        }
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, fastJsonConfig) == null) {
            this.fastJsonConfig = fastJsonConfig;
        }
    }

    @Deprecated
    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, serializerFeatureArr) == null) {
            this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
        }
    }

    @Deprecated
    public void setFilters(SerializeFilter... serializeFilterArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, serializeFilterArr) == null) {
            this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
        }
    }

    public boolean supports(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, cls)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void write(Object obj, Type type, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048593, this, obj, type, mediaType, httpOutputMessage) == null) {
            super.write(obj, mediaType, httpOutputMessage);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
        if ((r2 instanceof com.alibaba.fastjson.JSONPObject) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeInternal(Object obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, obj, httpOutputMessage) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    HttpHeaders headers = httpOutputMessage.getHeaders();
                    ArrayList arrayList = new ArrayList(Arrays.asList(this.fastJsonConfig.getSerializeFilters()));
                    Object strangeCodeForJackson = strangeCodeForJackson(obj);
                    if (strangeCodeForJackson instanceof FastJsonContainer) {
                        FastJsonContainer fastJsonContainer = (FastJsonContainer) strangeCodeForJackson;
                        arrayList.addAll(fastJsonContainer.getFilters().getFilters());
                        strangeCodeForJackson = fastJsonContainer.getValue();
                    }
                    Object obj2 = strangeCodeForJackson;
                    if (obj2 instanceof MappingFastJsonValue) {
                        z = StringUtils.isEmpty(((MappingFastJsonValue) obj2).getJsonpFunction()) ? false : true;
                    }
                    int writeJSONStringWithFastJsonConfig = JSON.writeJSONStringWithFastJsonConfig(byteArrayOutputStream, this.fastJsonConfig.getCharset(), obj2, this.fastJsonConfig.getSerializeConfig(), (SerializeFilter[]) arrayList.toArray(new SerializeFilter[arrayList.size()]), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
                    if (z) {
                        headers.setContentType(APPLICATION_JAVASCRIPT);
                    }
                    if (this.fastJsonConfig.isWriteContentLength()) {
                        headers.setContentLength(writeJSONStringWithFastJsonConfig);
                    }
                    byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
                } catch (JSONException e2) {
                    throw new HttpMessageNotWritableException("Could not write JSON: " + e2.getMessage(), e2);
                }
            } finally {
                byteArrayOutputStream.close();
            }
        }
    }
}
