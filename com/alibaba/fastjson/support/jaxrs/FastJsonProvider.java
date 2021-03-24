package com.alibaba.fastjson.support.jaxrs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
@Produces({"*/*"})
@Provider
@Consumes({"*/*"})
/* loaded from: classes.dex */
public class FastJsonProvider implements MessageBodyReader<Object>, MessageBodyWriter<Object> {
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

    public FastJsonProvider() {
        this.charset = Charset.forName("UTF-8");
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.fastJsonConfig = new FastJsonConfig();
        this.clazzes = null;
    }

    @Deprecated
    public Charset getCharset() {
        return this.fastJsonConfig.getCharset();
    }

    @Deprecated
    public String getDateFormat() {
        return this.fastJsonConfig.getDateFormat();
    }

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    @Deprecated
    public SerializerFeature[] getFeatures() {
        return this.fastJsonConfig.getSerializerFeatures();
    }

    @Deprecated
    public SerializeFilter[] getFilters() {
        return this.fastJsonConfig.getSerializeFilters();
    }

    public long getSize(Object obj, Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        return -1L;
    }

    public boolean hasMatchingMediaType(MediaType mediaType) {
        if (mediaType != null) {
            String subtype = mediaType.getSubtype();
            return "json".equalsIgnoreCase(subtype) || subtype.endsWith("+json") || "javascript".equals(subtype) || "x-javascript".equals(subtype) || "x-json".equals(subtype) || "x-www-form-urlencoded".equalsIgnoreCase(subtype) || subtype.endsWith("x-www-form-urlencoded");
        }
        return true;
    }

    public boolean isReadable(Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        if (hasMatchingMediaType(mediaType)) {
            return isValidType(cls, annotationArr);
        }
        return false;
    }

    public boolean isValidType(Class<?> cls, Annotation[] annotationArr) {
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

    public boolean isWriteable(Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        if (hasMatchingMediaType(mediaType)) {
            return isValidType(cls, annotationArr);
        }
        return false;
    }

    public FastJsonConfig locateConfigProvider(Class<?> cls, MediaType mediaType) {
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

    public Object readFrom(Class<Object> cls, Type type, Annotation[] annotationArr, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
        try {
            FastJsonConfig locateConfigProvider = locateConfigProvider(cls, mediaType);
            return JSON.parseObject(inputStream, locateConfigProvider.getCharset(), type, locateConfigProvider.getFeatures());
        } catch (JSONException e2) {
            throw new WebApplicationException("JSON parse error: " + e2.getMessage(), e2);
        }
    }

    @Deprecated
    public void setCharset(Charset charset) {
        this.fastJsonConfig.setCharset(charset);
    }

    @Deprecated
    public void setDateFormat(String str) {
        this.fastJsonConfig.setDateFormat(str);
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        this.fastJsonConfig = fastJsonConfig;
    }

    @Deprecated
    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
    }

    @Deprecated
    public void setFilters(SerializeFilter... serializeFilterArr) {
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    public FastJsonProvider setPretty(boolean z) {
        this.pretty = z;
        return this;
    }

    public void writeTo(Object obj, Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        SerializerFeature[] serializerFeatureArr;
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
            JSON.writeJSONString(outputStream, locateConfigProvider.getCharset(), obj, locateConfigProvider.getSerializeConfig(), locateConfigProvider.getSerializeFilters(), locateConfigProvider.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, locateConfigProvider.getSerializerFeatures());
            outputStream.flush();
        } catch (JSONException e2) {
            throw new WebApplicationException("Could not write JSON: " + e2.getMessage(), e2);
        }
    }

    public FastJsonProvider(Class<?>[] clsArr) {
        this.charset = Charset.forName("UTF-8");
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.fastJsonConfig = new FastJsonConfig();
        this.clazzes = null;
        this.clazzes = clsArr;
    }

    @Deprecated
    public FastJsonProvider(String str) {
        this.charset = Charset.forName("UTF-8");
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        this.fastJsonConfig = fastJsonConfig;
        this.clazzes = null;
        fastJsonConfig.setCharset(Charset.forName(str));
    }
}
