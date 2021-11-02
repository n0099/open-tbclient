package com.alibaba.fastjson.support.jaxrs;

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
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
@Produces({"*/*"})
@Provider
@Consumes({"*/*"})
/* loaded from: classes6.dex */
public class FastJsonProvider implements MessageBodyReader<Object>, MessageBodyWriter<Object> {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?>[] DEFAULT_UNREADABLES;
    public static final Class<?>[] DEFAULT_UNWRITABLES;
    public transient /* synthetic */ FieldHolder $fh;
    @Deprecated
    public Charset charset;
    public Class<?>[] clazzes;
    @Deprecated
    public String dateFormat;
    public FastJsonConfig fastJsonConfig;
    @Deprecated
    public SerializerFeature[] features;
    @Deprecated
    public SerializeFilter[] filters;
    public boolean pretty;
    @Context
    public Providers providers;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-740382213, "Lcom/alibaba/fastjson/support/jaxrs/FastJsonProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-740382213, "Lcom/alibaba/fastjson/support/jaxrs/FastJsonProvider;");
                return;
            }
        }
        DEFAULT_UNREADABLES = new Class[]{InputStream.class, Reader.class};
        DEFAULT_UNWRITABLES = new Class[]{InputStream.class, OutputStream.class, Writer.class, StreamingOutput.class, Response.class};
    }

    public FastJsonProvider() {
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
        this.charset = Charset.forName("UTF-8");
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.fastJsonConfig = new FastJsonConfig();
        this.clazzes = null;
    }

    @Deprecated
    public Charset getCharset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.fastJsonConfig.getCharset() : (Charset) invokeV.objValue;
    }

    @Deprecated
    public String getDateFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fastJsonConfig.getDateFormat() : (String) invokeV.objValue;
    }

    public FastJsonConfig getFastJsonConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fastJsonConfig : (FastJsonConfig) invokeV.objValue;
    }

    @Deprecated
    public SerializerFeature[] getFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.fastJsonConfig.getSerializerFeatures() : (SerializerFeature[]) invokeV.objValue;
    }

    @Deprecated
    public SerializeFilter[] getFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.fastJsonConfig.getSerializeFilters() : (SerializeFilter[]) invokeV.objValue;
    }

    public long getSize(Object obj, Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, obj, cls, type, annotationArr, mediaType)) == null) {
            return -1L;
        }
        return invokeLLLLL.longValue;
    }

    public boolean hasMatchingMediaType(MediaType mediaType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mediaType)) == null) {
            if (mediaType != null) {
                String subtype = mediaType.getSubtype();
                return "json".equalsIgnoreCase(subtype) || subtype.endsWith("+json") || "javascript".equals(subtype) || "x-javascript".equals(subtype) || "x-json".equals(subtype) || "x-www-form-urlencoded".equalsIgnoreCase(subtype) || subtype.endsWith("x-www-form-urlencoded");
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean isAssignableFrom(Class<?> cls, Class<?>[] clsArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, cls, clsArr)) == null) {
            if (cls == null) {
                return false;
            }
            for (Class<?> cls2 : clsArr) {
                if (cls2.isAssignableFrom(cls)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean isReadable(Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, type, annotationArr, mediaType)) == null) {
            if (hasMatchingMediaType(mediaType) && isAssignableFrom(cls, DEFAULT_UNREADABLES)) {
                return isValidType(cls, annotationArr);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean isValidType(Class<?> cls, Annotation[] annotationArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, cls, annotationArr)) == null) {
            if (cls == null) {
                return false;
            }
            Class<?>[] clsArr = this.clazzes;
            if (clsArr != null) {
                for (Class<?> cls2 : clsArr) {
                    if (cls2 == cls) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean isWriteable(Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, cls, type, annotationArr, mediaType)) == null) {
            if (hasMatchingMediaType(mediaType) && isAssignableFrom(cls, DEFAULT_UNWRITABLES)) {
                return isValidType(cls, annotationArr);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public FastJsonConfig locateConfigProvider(Class<?> cls, MediaType mediaType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, cls, mediaType)) == null) {
            Providers providers = this.providers;
            if (providers != null) {
                ContextResolver contextResolver = providers.getContextResolver(FastJsonConfig.class, mediaType);
                if (contextResolver == null) {
                    contextResolver = this.providers.getContextResolver(FastJsonConfig.class, (MediaType) null);
                }
                if (contextResolver != null) {
                    return (FastJsonConfig) contextResolver.getContext(cls);
                }
            }
            return this.fastJsonConfig;
        }
        return (FastJsonConfig) invokeLL.objValue;
    }

    public Object readFrom(Class<Object> cls, Type type, Annotation[] annotationArr, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{cls, type, annotationArr, mediaType, multivaluedMap, inputStream})) == null) {
            try {
                FastJsonConfig locateConfigProvider = locateConfigProvider(cls, mediaType);
                return JSON.parseObject(inputStream, locateConfigProvider.getCharset(), type, locateConfigProvider.getParserConfig(), locateConfigProvider.getParseProcess(), JSON.DEFAULT_PARSER_FEATURE, locateConfigProvider.getFeatures());
            } catch (JSONException e2) {
                throw new WebApplicationException(e2);
            }
        }
        return invokeCommon.objValue;
    }

    @Deprecated
    public void setCharset(Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, charset) == null) {
            this.fastJsonConfig.setCharset(charset);
        }
    }

    @Deprecated
    public void setDateFormat(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.fastJsonConfig.setDateFormat(str);
        }
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fastJsonConfig) == null) {
            this.fastJsonConfig = fastJsonConfig;
        }
    }

    @Deprecated
    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, serializerFeatureArr) == null) {
            this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
        }
    }

    @Deprecated
    public void setFilters(SerializeFilter... serializeFilterArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, serializeFilterArr) == null) {
            this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
        }
    }

    public FastJsonProvider setPretty(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.pretty = z;
            return this;
        }
        return (FastJsonProvider) invokeZ.objValue;
    }

    public void writeTo(Object obj, Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        SerializerFeature[] serializerFeatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{obj, cls, type, annotationArr, mediaType, multivaluedMap, outputStream}) == null) {
            FastJsonConfig locateConfigProvider = locateConfigProvider(cls, mediaType);
            SerializerFeature[] serializerFeatures = locateConfigProvider.getSerializerFeatures();
            if (this.pretty) {
                if (serializerFeatures == null) {
                    serializerFeatureArr = new SerializerFeature[]{SerializerFeature.PrettyFormat};
                } else {
                    ArrayList arrayList = new ArrayList(Arrays.asList(serializerFeatures));
                    arrayList.add(SerializerFeature.PrettyFormat);
                    serializerFeatureArr = (SerializerFeature[]) arrayList.toArray(serializerFeatures);
                }
                locateConfigProvider.setSerializerFeatures(serializerFeatureArr);
            }
            try {
                JSON.writeJSONStringWithFastJsonConfig(outputStream, locateConfigProvider.getCharset(), obj, locateConfigProvider.getSerializeConfig(), locateConfigProvider.getSerializeFilters(), locateConfigProvider.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, locateConfigProvider.getSerializerFeatures());
                outputStream.flush();
            } catch (JSONException e2) {
                throw new WebApplicationException(e2);
            }
        }
    }

    public FastJsonProvider(Class<?>[] clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {clsArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.charset = Charset.forName("UTF-8");
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.fastJsonConfig = new FastJsonConfig();
        this.clazzes = null;
        this.clazzes = clsArr;
    }

    @Deprecated
    public FastJsonProvider(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.charset = Charset.forName("UTF-8");
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        this.fastJsonConfig = fastJsonConfig;
        this.clazzes = null;
        fastJsonConfig.setCharset(Charset.forName(str));
    }
}
