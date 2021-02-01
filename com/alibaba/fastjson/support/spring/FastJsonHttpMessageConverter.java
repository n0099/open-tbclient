package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
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
/* loaded from: classes4.dex */
public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> implements GenericHttpMessageConverter<Object> {
    public static final MediaType APPLICATION_JAVASCRIPT = new MediaType("application", "javascript");
    private Charset charset;
    @Deprecated
    protected String dateFormat;
    private FastJsonConfig fastJsonConfig;
    @Deprecated
    protected SerializerFeature[] features;
    @Deprecated
    protected SerializeFilter[] filters;

    public FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public void setFastJsonConfig(FastJsonConfig fastJsonConfig) {
        this.fastJsonConfig = fastJsonConfig;
    }

    public FastJsonHttpMessageConverter() {
        super(MediaType.ALL);
        this.charset = Charset.forName("UTF-8");
        this.features = new SerializerFeature[0];
        this.filters = new SerializeFilter[0];
        this.fastJsonConfig = new FastJsonConfig();
    }

    @Deprecated
    public Charset getCharset() {
        return this.fastJsonConfig.getCharset();
    }

    @Deprecated
    public void setCharset(Charset charset) {
        this.fastJsonConfig.setCharset(charset);
    }

    @Deprecated
    public String getDateFormat() {
        return this.fastJsonConfig.getDateFormat();
    }

    @Deprecated
    public void setDateFormat(String str) {
        this.fastJsonConfig.setDateFormat(str);
    }

    @Deprecated
    public SerializerFeature[] getFeatures() {
        return this.fastJsonConfig.getSerializerFeatures();
    }

    @Deprecated
    public void setFeatures(SerializerFeature... serializerFeatureArr) {
        this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
    }

    @Deprecated
    public SerializeFilter[] getFilters() {
        return this.fastJsonConfig.getSerializeFilters();
    }

    @Deprecated
    public void setFilters(SerializeFilter... serializeFilterArr) {
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    @Deprecated
    public void addSerializeFilter(SerializeFilter serializeFilter) {
        if (serializeFilter != null) {
            int length = this.fastJsonConfig.getSerializeFilters().length;
            SerializeFilter[] serializeFilterArr = new SerializeFilter[length + 1];
            System.arraycopy(this.fastJsonConfig.getSerializeFilters(), 0, serializeFilterArr, 0, length);
            serializeFilterArr[serializeFilterArr.length - 1] = serializeFilter;
            this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean supports(Class<?> cls) {
        return true;
    }

    public boolean canRead(Type type, Class<?> cls, MediaType mediaType) {
        return super.canRead(cls, mediaType);
    }

    public boolean canWrite(Type type, Class<?> cls, MediaType mediaType) {
        return super.canWrite(cls, mediaType);
    }

    public Object read(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readType(getType(type, cls), httpInputMessage);
    }

    public void write(Object obj, Type type, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        super.write(obj, mediaType, httpOutputMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object readInternal(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readType(getType(cls, null), httpInputMessage);
    }

    private Object readType(Type type, HttpInputMessage httpInputMessage) throws IOException {
        try {
            return JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getFeatures());
        } catch (JSONException e) {
            throw new HttpMessageNotReadableException("JSON parse error: " + e.getMessage(), e);
        } catch (IOException e2) {
            throw new HttpMessageNotReadableException("I/O error while reading input message", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072 A[Catch: JSONException -> 0x0094, all -> 0x00b3, TryCatch #1 {JSONException -> 0x0094, blocks: (B:3:0x0006, B:5:0x0022, B:6:0x0033, B:8:0x0037, B:11:0x0046, B:13:0x0072, B:14:0x0077, B:16:0x007f, B:17:0x0083, B:20:0x008e), top: B:31:0x0006, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007f A[Catch: JSONException -> 0x0094, all -> 0x00b3, TryCatch #1 {JSONException -> 0x0094, blocks: (B:3:0x0006, B:5:0x0022, B:6:0x0033, B:8:0x0037, B:11:0x0046, B:13:0x0072, B:14:0x0077, B:16:0x007f, B:17:0x0083, B:20:0x008e), top: B:31:0x0006, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeInternal(Object obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        Object obj2;
        boolean z;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                HttpHeaders headers = httpOutputMessage.getHeaders();
                ArrayList arrayList = new ArrayList(Arrays.asList(this.fastJsonConfig.getSerializeFilters()));
                Object strangeCodeForJackson = strangeCodeForJackson(obj);
                if (strangeCodeForJackson instanceof FastJsonContainer) {
                    FastJsonContainer fastJsonContainer = (FastJsonContainer) strangeCodeForJackson;
                    arrayList.addAll(fastJsonContainer.getFilters().getFilters());
                    obj2 = fastJsonContainer.getValue();
                } else {
                    obj2 = strangeCodeForJackson;
                }
                if (obj2 instanceof MappingFastJsonValue) {
                    if (!StringUtils.isEmpty(((MappingFastJsonValue) obj2).getJsonpFunction())) {
                        z = true;
                        int writeJSONString = JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), obj2, this.fastJsonConfig.getSerializeConfig(), (SerializeFilter[]) arrayList.toArray(new SerializeFilter[arrayList.size()]), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
                        if (z) {
                            headers.setContentType(APPLICATION_JAVASCRIPT);
                        }
                        if (this.fastJsonConfig.isWriteContentLength()) {
                            headers.setContentLength(writeJSONString);
                        }
                        byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
                    }
                    z = false;
                    int writeJSONString2 = JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), obj2, this.fastJsonConfig.getSerializeConfig(), (SerializeFilter[]) arrayList.toArray(new SerializeFilter[arrayList.size()]), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
                    if (z) {
                    }
                    if (this.fastJsonConfig.isWriteContentLength()) {
                    }
                    byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
                }
                if (obj2 instanceof JSONPObject) {
                    z = true;
                    int writeJSONString22 = JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), obj2, this.fastJsonConfig.getSerializeConfig(), (SerializeFilter[]) arrayList.toArray(new SerializeFilter[arrayList.size()]), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
                    if (z) {
                    }
                    if (this.fastJsonConfig.isWriteContentLength()) {
                    }
                    byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
                }
                z = false;
                int writeJSONString222 = JSON.writeJSONString(byteArrayOutputStream, this.fastJsonConfig.getCharset(), obj2, this.fastJsonConfig.getSerializeConfig(), (SerializeFilter[]) arrayList.toArray(new SerializeFilter[arrayList.size()]), this.fastJsonConfig.getDateFormat(), JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
                if (z) {
                }
                if (this.fastJsonConfig.isWriteContentLength()) {
                }
                byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
            } catch (JSONException e) {
                throw new HttpMessageNotWritableException("Could not write JSON: " + e.getMessage(), e);
            }
        } finally {
            byteArrayOutputStream.close();
        }
    }

    private Object strangeCodeForJackson(Object obj) {
        if (obj != null && "com.fasterxml.jackson.databind.node.ObjectNode".equals(obj.getClass().getName())) {
            return obj.toString();
        }
        return obj;
    }

    protected Type getType(Type type, Class<?> cls) {
        if (!Spring4TypeResolvableHelper.isSupport()) {
            return type;
        }
        return Spring4TypeResolvableHelper.getType(type, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class Spring4TypeResolvableHelper {
        private static boolean hasClazzResolvableType;

        private Spring4TypeResolvableHelper() {
        }

        static {
            try {
                Class.forName("org.springframework.core.ResolvableType");
                hasClazzResolvableType = true;
            } catch (ClassNotFoundException e) {
                hasClazzResolvableType = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isSupport() {
            return hasClazzResolvableType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Type getType(Type type, Class<?> cls) {
            if (cls != null) {
                ResolvableType forType = ResolvableType.forType(type);
                if (type instanceof TypeVariable) {
                    ResolvableType resolveVariable = resolveVariable((TypeVariable) type, ResolvableType.forClass(cls));
                    if (resolveVariable != ResolvableType.NONE) {
                        return resolveVariable.resolve();
                    }
                    return type;
                } else if ((type instanceof ParameterizedType) && forType.hasUnresolvableGenerics()) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Class[] clsArr = new Class[parameterizedType.getActualTypeArguments().length];
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < actualTypeArguments.length) {
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
                            i = i2 + 1;
                        } else {
                            return ResolvableType.forClassWithGenerics(forType.getRawClass(), clsArr).getType();
                        }
                    }
                } else {
                    return type;
                }
            } else {
                return type;
            }
        }

        private static ResolvableType resolveVariable(TypeVariable<?> typeVariable, ResolvableType resolvableType) {
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
    }
}
