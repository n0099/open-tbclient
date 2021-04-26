package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public abstract class JSON implements JSONStreamAware, JSONAware {
    public static final String VERSION = "1.2.75";
    public static final ThreadLocal<byte[]> bytesLocal;
    public static final ThreadLocal<char[]> charsLocal;
    public static TimeZone defaultTimeZone = TimeZone.getDefault();
    public static Locale defaultLocale = Locale.getDefault();
    public static String DEFAULT_TYPE_KEY = "@type";
    public static final SerializeFilter[] emptyFilters = new SerializeFilter[0];
    public static String DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final ConcurrentHashMap<Type, Type> mixInsMapper = new ConcurrentHashMap<>(16);
    public static int DEFAULT_PARSER_FEATURE = (((((((Feature.AutoCloseSource.getMask() | 0) | Feature.InternFieldNames.getMask()) | Feature.UseBigDecimal.getMask()) | Feature.AllowUnQuotedFieldNames.getMask()) | Feature.AllowSingleQuotes.getMask()) | Feature.AllowArbitraryCommas.getMask()) | Feature.SortFeidFastMatch.getMask()) | Feature.IgnoreNotMatch.getMask();
    public static int DEFAULT_GENERATE_FEATURE = (((0 | SerializerFeature.QuoteFieldNames.getMask()) | SerializerFeature.SkipTransientField.getMask()) | SerializerFeature.WriteEnumUsingName.getMask()) | SerializerFeature.SortField.getMask();

    static {
        config(IOUtils.DEFAULT_PROPERTIES);
        bytesLocal = new ThreadLocal<>();
        charsLocal = new ThreadLocal<>();
    }

    public static void addMixInAnnotations(Type type, Type type2) {
        if (type == null || type2 == null) {
            return;
        }
        mixInsMapper.put(type, type2);
    }

    public static byte[] allocateBytes(int i2) {
        byte[] bArr = bytesLocal.get();
        if (bArr != null) {
            return bArr.length < i2 ? new byte[i2] : bArr;
        } else if (i2 <= 65536) {
            byte[] bArr2 = new byte[65536];
            bytesLocal.set(bArr2);
            return bArr2;
        } else {
            return new byte[i2];
        }
    }

    public static char[] allocateChars(int i2) {
        char[] cArr = charsLocal.get();
        if (cArr != null) {
            return cArr.length < i2 ? new char[i2] : cArr;
        } else if (i2 <= 65536) {
            char[] cArr2 = new char[65536];
            charsLocal.set(cArr2);
            return cArr2;
        } else {
            return new char[i2];
        }
    }

    public static void clearMixInAnnotations() {
        mixInsMapper.clear();
    }

    public static void config(Properties properties) {
        String property = properties.getProperty("fastjson.serializerFeatures.MapSortField");
        int mask = SerializerFeature.MapSortField.getMask();
        if ("true".equals(property)) {
            DEFAULT_GENERATE_FEATURE |= mask;
        } else if ("false".equals(property)) {
            DEFAULT_GENERATE_FEATURE &= ~mask;
        }
        if ("true".equals(properties.getProperty("parser.features.NonStringKeyAsString"))) {
            DEFAULT_PARSER_FEATURE |= Feature.NonStringKeyAsString.getMask();
        }
        if ("true".equals(properties.getProperty("parser.features.ErrorOnEnumNotMatch")) || "true".equals(properties.getProperty("fastjson.parser.features.ErrorOnEnumNotMatch"))) {
            DEFAULT_PARSER_FEATURE |= Feature.ErrorOnEnumNotMatch.getMask();
        }
        if ("false".equals(properties.getProperty("fastjson.asmEnable"))) {
            ParserConfig.global.setAsmEnable(false);
            SerializeConfig.globalInstance.setAsmEnable(false);
        }
    }

    public static Type getMixInAnnotations(Type type) {
        if (type != null) {
            return mixInsMapper.get(type);
        }
        return null;
    }

    public static <T> void handleResovleTask(DefaultJSONParser defaultJSONParser, T t) {
        defaultJSONParser.handleResovleTask(t);
    }

    public static boolean isValid(String str) {
        if (str != null && str.length() != 0) {
            JSONScanner jSONScanner = new JSONScanner(str);
            try {
                jSONScanner.nextToken();
                int i2 = jSONScanner.token();
                if (i2 != 12) {
                    if (i2 != 14) {
                        switch (i2) {
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                jSONScanner.nextToken();
                                break;
                            default:
                                return false;
                        }
                    } else {
                        jSONScanner.skipArray(true);
                    }
                } else if (jSONScanner.getCurrent() == 26) {
                    return false;
                } else {
                    jSONScanner.skipObject(true);
                }
                return jSONScanner.token() == 20;
            } catch (Exception unused) {
            } finally {
                jSONScanner.close();
            }
        }
        return false;
    }

    public static boolean isValidArray(String str) {
        if (str != null && str.length() != 0) {
            JSONScanner jSONScanner = new JSONScanner(str);
            try {
                jSONScanner.nextToken();
                if (jSONScanner.token() == 14) {
                    jSONScanner.skipArray(true);
                    return jSONScanner.token() == 20;
                }
                return false;
            } catch (Exception unused) {
            } finally {
                jSONScanner.close();
            }
        }
        return false;
    }

    public static boolean isValidObject(String str) {
        if (str != null && str.length() != 0) {
            JSONScanner jSONScanner = new JSONScanner(str);
            try {
                jSONScanner.nextToken();
                if (jSONScanner.token() == 12) {
                    if (jSONScanner.getCurrent() == 26) {
                        return false;
                    }
                    jSONScanner.skipObject(true);
                    return jSONScanner.token() == 20;
                }
                return false;
            } catch (Exception unused) {
            } finally {
                jSONScanner.close();
            }
        }
        return false;
    }

    public static Object parse(String str) {
        return parse(str, DEFAULT_PARSER_FEATURE);
    }

    public static JSONArray parseArray(String str) {
        return parseArray(str, ParserConfig.global);
    }

    public static JSONObject parseObject(String str, Feature... featureArr) {
        return (JSONObject) parse(str, featureArr);
    }

    public static void removeMixInAnnotations(Type type) {
        if (type != null) {
            mixInsMapper.remove(type);
        }
    }

    public static void setDefaultTypeKey(String str) {
        DEFAULT_TYPE_KEY = str;
        ParserConfig.global.symbolTable.addSymbol(str, 0, str.length(), str.hashCode(), true);
    }

    public static Object toJSON(Object obj) {
        return toJSON(obj, SerializeConfig.globalInstance);
    }

    public static byte[] toJSONBytes(Object obj, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static byte[] toJSONBytesWithFastJsonConfig(Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i2, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(null, i2, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (str != null && str.length() != 0) {
                jSONSerializer.setFastJsonConfigDateFormatPattern(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (SerializeFilter serializeFilter : serializeFilterArr) {
                    jSONSerializer.addFilter(serializeFilter);
                }
            }
            jSONSerializer.write(obj);
            return serializeWriter.toBytes(charset);
        } finally {
            serializeWriter.close();
        }
    }

    public static String toJSONString(Object obj) {
        return toJSONString(obj, emptyFilters, new SerializerFeature[0]);
    }

    public static String toJSONStringWithDateFormat(Object obj, String str, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, null, str, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONStringZ(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, emptyFilters, null, 0, serializerFeatureArr);
    }

    public static <T> T toJavaObject(JSON json, Class<T> cls) {
        return (T) TypeUtils.cast((Object) json, (Class<Object>) cls, ParserConfig.getGlobalInstance());
    }

    public static void writeJSONString(Writer writer, Object obj, SerializerFeature... serializerFeatureArr) {
        writeJSONString(writer, obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static void writeJSONStringTo(Object obj, Writer writer, SerializerFeature... serializerFeatureArr) {
        writeJSONString(writer, obj, serializerFeatureArr);
    }

    public static final int writeJSONStringWithFastJsonConfig(OutputStream outputStream, Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i2, SerializerFeature... serializerFeatureArr) throws IOException {
        SerializeWriter serializeWriter = new SerializeWriter(null, i2, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (str != null && str.length() != 0) {
                jSONSerializer.setFastJsonConfigDateFormatPattern(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (SerializeFilter serializeFilter : serializeFilterArr) {
                    jSONSerializer.addFilter(serializeFilter);
                }
            }
            jSONSerializer.write(obj);
            return serializeWriter.writeToEx(outputStream, charset);
        } finally {
            serializeWriter.close();
        }
    }

    public String toString() {
        return toJSONString();
    }

    public static Object parse(String str, ParserConfig parserConfig) {
        return parse(str, parserConfig, DEFAULT_PARSER_FEATURE);
    }

    public static JSONArray parseArray(String str, ParserConfig parserConfig) {
        JSONArray jSONArray = null;
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig);
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
        } else if (jSONLexer.token() != 20) {
            jSONArray = new JSONArray();
            defaultJSONParser.parseArray(jSONArray);
            defaultJSONParser.handleResovleTask(jSONArray);
        }
        defaultJSONParser.close();
        return jSONArray;
    }

    public static JSONObject parseObject(String str) {
        Object parse = parse(str);
        if (parse instanceof JSONObject) {
            return (JSONObject) parse;
        }
        try {
            return (JSONObject) toJSON(parse);
        } catch (RuntimeException e2) {
            throw new JSONException("can not cast to JSONObject.", e2);
        }
    }

    public static Object toJSON(Object obj, ParserConfig parserConfig) {
        return toJSON(obj, SerializeConfig.globalInstance);
    }

    public static byte[] toJSONBytes(Object obj, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, SerializeConfig.globalInstance, new SerializeFilter[]{serializeFilter}, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static void writeJSONString(Writer writer, Object obj, int i2, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(writer, i2, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter).write(obj);
        } finally {
            serializeWriter.close();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.alibaba.fastjson.JSON */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T toJavaObject(Class<T> cls) {
        return (cls == JSONArray.class || cls == JSON.class || cls == Collection.class || cls == List.class) ? this : (T) TypeUtils.cast((Object) this, (Class<Object>) cls, ParserConfig.getGlobalInstance());
    }

    public String toString(SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter).write(this);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public static Object parse(String str, ParserConfig parserConfig, Feature... featureArr) {
        int i2 = DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            i2 = Feature.config(i2, feature, true);
        }
        return parse(str, parserConfig, i2);
    }

    public static Object toJSON(Object obj, SerializeConfig serializeConfig) {
        Map hashMap;
        if (obj == null) {
            return null;
        }
        if (obj instanceof JSON) {
            return obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            int size = map.size();
            if (map instanceof LinkedHashMap) {
                hashMap = new LinkedHashMap(size);
            } else if (map instanceof TreeMap) {
                hashMap = new TreeMap();
            } else {
                hashMap = new HashMap(size);
            }
            JSONObject jSONObject = new JSONObject(hashMap);
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put(TypeUtils.castToString(entry.getKey()), toJSON(entry.getValue(), serializeConfig));
            }
            return jSONObject;
        } else if (obj instanceof Collection) {
            Collection<Object> collection = (Collection) obj;
            JSONArray jSONArray = new JSONArray(collection.size());
            for (Object obj2 : collection) {
                jSONArray.add(toJSON(obj2, serializeConfig));
            }
            return jSONArray;
        } else if (obj instanceof JSONSerializable) {
            return parse(toJSONString(obj));
        } else {
            Class<?> cls = obj.getClass();
            if (cls.isEnum()) {
                return ((Enum) obj).name();
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray2 = new JSONArray(length);
                for (int i2 = 0; i2 < length; i2++) {
                    jSONArray2.add(toJSON(Array.get(obj, i2)));
                }
                return jSONArray2;
            } else if (ParserConfig.isPrimitive2(cls)) {
                return obj;
            } else {
                ObjectSerializer objectWriter = serializeConfig.getObjectWriter(cls);
                if (objectWriter instanceof JavaBeanSerializer) {
                    JavaBeanSerializer javaBeanSerializer = (JavaBeanSerializer) objectWriter;
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (Map.Entry<String, Object> entry2 : javaBeanSerializer.getFieldValuesMap(obj).entrySet()) {
                            jSONObject2.put(entry2.getKey(), toJSON(entry2.getValue(), serializeConfig));
                        }
                        return jSONObject2;
                    } catch (Exception e2) {
                        throw new JSONException("toJSON error", e2);
                    }
                }
                return parse(toJSONString(obj, serializeConfig, new SerializerFeature[0]));
            }
        }
    }

    public static byte[] toJSONBytes(Object obj, int i2, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, SerializeConfig.globalInstance, i2, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, int i2, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(null, i2, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter).write(obj);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, serializeConfig, emptyFilters, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public <T> T toJavaObject(Type type) {
        return (T) TypeUtils.cast(this, type, ParserConfig.getGlobalInstance());
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, int i2, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, serializeConfig, emptyFilters, i2, serializerFeatureArr);
    }

    public <T> T toJavaObject(TypeReference typeReference) {
        return (T) TypeUtils.cast(this, typeReference != null ? typeReference.getType() : null, ParserConfig.getGlobalInstance());
    }

    public static byte[] toJSONBytes(Object obj, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, SerializeConfig.globalInstance, serializeFilterArr, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static Object parse(String str, ParserConfig parserConfig, int i2) {
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i2);
        Object parse = defaultJSONParser.parse();
        defaultJSONParser.handleResovleTask(parse);
        defaultJSONParser.close();
        return parse;
    }

    public static <T> T parseObject(String str, TypeReference<T> typeReference, Feature... featureArr) {
        return (T) parseObject(str, typeReference.type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, serializeConfig, new SerializeFilter[]{serializeFilter}, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, Feature... featureArr) {
        return (T) parseObject(str, cls, ParserConfig.global, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, int i2, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, serializeConfig, serializeFilterArr, null, i2, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, int i2, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, IOUtils.UTF8, obj, SerializeConfig.globalInstance, null, null, i2, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, ParseProcess parseProcess, Feature... featureArr) {
        return (T) parseObject(str, cls, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i2, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(IOUtils.UTF8, obj, serializeConfig, serializeFilterArr, str, i2, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, new SerializeFilter[]{serializeFilter}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, charset, obj, SerializeConfig.globalInstance, null, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Type type, Feature... featureArr) {
        return (T) parseObject(str, type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static byte[] toJSONBytes(Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i2, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(null, i2, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (str != null && str.length() != 0) {
                jSONSerializer.setDateFormat(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (SerializeFilter serializeFilter : serializeFilterArr) {
                    jSONSerializer.addFilter(serializeFilter);
                }
            }
            jSONSerializer.write(obj);
            return serializeWriter.toBytes(charset);
        } finally {
            serializeWriter.close();
        }
    }

    public static String toJSONString(Object obj, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, serializeFilterArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i2, SerializerFeature... serializerFeatureArr) throws IOException {
        SerializeWriter serializeWriter = new SerializeWriter(null, i2, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (str != null && str.length() != 0) {
                jSONSerializer.setDateFormat(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (SerializeFilter serializeFilter : serializeFilterArr) {
                    jSONSerializer.addFilter(serializeFilter);
                }
            }
            jSONSerializer.write(obj);
            return serializeWriter.writeToEx(outputStream, charset);
        } finally {
            serializeWriter.close();
        }
    }

    public static Object parse(String str, int i2) {
        return parse(str, ParserConfig.getGlobalInstance(), i2);
    }

    public static <T> List<T> parseArray(String str, Class<T> cls) {
        return parseArray(str, cls, ParserConfig.global);
    }

    public static <T> T parseObject(String str, Type type, ParseProcess parseProcess, Feature... featureArr) {
        return (T) parseObject(str, type, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, (SerializeFilter) null, serializerFeatureArr);
    }

    public static Object parse(byte[] bArr, Feature... featureArr) {
        char[] allocateChars = allocateChars(bArr.length);
        int decodeUTF8 = IOUtils.decodeUTF8(bArr, 0, bArr.length, allocateChars);
        if (decodeUTF8 < 0) {
            return null;
        }
        return parse(new String(allocateChars, 0, decodeUTF8), featureArr);
    }

    public static <T> List<T> parseArray(String str, Class<T> cls, ParserConfig parserConfig) {
        ArrayList arrayList = null;
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig);
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i2 = jSONLexer.token();
        if (i2 == 8) {
            jSONLexer.nextToken();
        } else if (i2 != 20 || !jSONLexer.isBlankInput()) {
            arrayList = new ArrayList();
            defaultJSONParser.parseArray((Class<?>) cls, (Collection) arrayList);
            defaultJSONParser.handleResovleTask(arrayList);
        }
        defaultJSONParser.close();
        return arrayList;
    }

    public static <T> T parseObject(String str, Type type, int i2, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (Feature feature : featureArr) {
            i2 = Feature.config(i2, feature, true);
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.getGlobalInstance(), i2);
        T t = (T) defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(t);
        defaultJSONParser.close();
        return t;
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, new SerializeFilter[]{serializeFilter}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, serializeFilterArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i2, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(null, i2, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (str != null && str.length() != 0) {
                jSONSerializer.setDateFormat(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (SerializeFilter serializeFilter : serializeFilterArr) {
                    jSONSerializer.addFilter(serializeFilter);
                }
            }
            jSONSerializer.write(obj);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public static Object parse(byte[] bArr, int i2, int i3, CharsetDecoder charsetDecoder, Feature... featureArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i4 = DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            i4 = Feature.config(i4, feature, true);
        }
        return parse(bArr, i2, i3, charsetDecoder, i4);
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, Feature... featureArr) {
        return (T) parseObject(str, type, parserConfig, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, int i2, Feature... featureArr) {
        return (T) parseObject(str, type, parserConfig, (ParseProcess) null, i2, featureArr);
    }

    public static Object parse(byte[] bArr, int i2, int i3, CharsetDecoder charsetDecoder, int i4) {
        charsetDecoder.reset();
        char[] allocateChars = allocateChars((int) (i3 * charsetDecoder.maxCharsPerByte()));
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i2, i3);
        CharBuffer wrap2 = CharBuffer.wrap(allocateChars);
        IOUtils.decode(charsetDecoder, wrap, wrap2);
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(allocateChars, wrap2.position(), ParserConfig.getGlobalInstance(), i4);
        Object parse = defaultJSONParser.parse();
        defaultJSONParser.handleResovleTask(parse);
        defaultJSONParser.close();
        return parse;
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i2, Feature... featureArr) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (featureArr != null) {
            for (Feature feature : featureArr) {
                i2 |= feature.mask;
            }
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i2);
        if (parseProcess != null) {
            if (parseProcess instanceof ExtraTypeProvider) {
                defaultJSONParser.getExtraTypeProviders().add((ExtraTypeProvider) parseProcess);
            }
            if (parseProcess instanceof ExtraProcessor) {
                defaultJSONParser.getExtraProcessors().add((ExtraProcessor) parseProcess);
            }
            if (parseProcess instanceof FieldTypeResolver) {
                defaultJSONParser.setFieldTypeResolver((FieldTypeResolver) parseProcess);
            }
        }
        T t = (T) defaultJSONParser.parseObject(type, (Object) null);
        defaultJSONParser.handleResovleTask(t);
        defaultJSONParser.close();
        return t;
    }

    public static List<Object> parseArray(String str, Type[] typeArr) {
        return parseArray(str, typeArr, ParserConfig.global);
    }

    @Override // com.alibaba.fastjson.JSONStreamAware
    public void writeJSONString(Appendable appendable) {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            try {
                new JSONSerializer(serializeWriter).write(this);
                appendable.append(serializeWriter.toString());
            } catch (IOException e2) {
                throw new JSONException(e2.getMessage(), e2);
            }
        } finally {
            serializeWriter.close();
        }
    }

    public static List<Object> parseArray(String str, Type[] typeArr, ParserConfig parserConfig) {
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig);
        Object[] parseArray = defaultJSONParser.parseArray(typeArr);
        List<Object> asList = parseArray != null ? Arrays.asList(parseArray) : null;
        defaultJSONParser.handleResovleTask(asList);
        defaultJSONParser.close();
        return asList;
    }

    public static String toJSONString(Object obj, boolean z) {
        return !z ? toJSONString(obj) : toJSONString(obj, SerializerFeature.PrettyFormat);
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            new JSONSerializer(serializeWriter).write(this);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public static Object parse(String str, Feature... featureArr) {
        int i2 = DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            i2 = Feature.config(i2, feature, true);
        }
        return parse(str, i2);
    }

    public static <T> T parseObject(byte[] bArr, Type type, Feature... featureArr) {
        return (T) parseObject(bArr, 0, bArr.length, IOUtils.UTF8, type, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i2, int i3, Charset charset, Type type, Feature... featureArr) {
        return (T) parseObject(bArr, i2, i3, charset, type, ParserConfig.global, null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, Charset charset, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i2, Feature... featureArr) {
        return (T) parseObject(bArr, 0, bArr.length, charset, type, parserConfig, parseProcess, i2, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i2, int i3, Charset charset, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i4, Feature... featureArr) {
        String str;
        if (charset == null) {
            charset = IOUtils.UTF8;
        }
        if (charset == IOUtils.UTF8) {
            char[] allocateChars = allocateChars(bArr.length);
            int decodeUTF8 = IOUtils.decodeUTF8(bArr, i2, i3, allocateChars);
            if (decodeUTF8 < 0) {
                return null;
            }
            str = new String(allocateChars, 0, decodeUTF8);
        } else if (i3 < 0) {
            return null;
        } else {
            str = new String(bArr, i2, i3, charset);
        }
        return (T) parseObject(str, type, parserConfig, parseProcess, i4, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i2, int i3, CharsetDecoder charsetDecoder, Type type, Feature... featureArr) {
        charsetDecoder.reset();
        char[] allocateChars = allocateChars((int) (i3 * charsetDecoder.maxCharsPerByte()));
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i2, i3);
        CharBuffer wrap2 = CharBuffer.wrap(allocateChars);
        IOUtils.decode(charsetDecoder, wrap, wrap2);
        return (T) parseObject(allocateChars, wrap2.position(), type, featureArr);
    }

    public static <T> T parseObject(char[] cArr, int i2, Type type, Feature... featureArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        int i3 = DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            i3 = Feature.config(i3, feature, true);
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(cArr, i2, ParserConfig.getGlobalInstance(), i3);
        T t = (T) defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(t);
        defaultJSONParser.close();
        return t;
    }

    public static <T> T parseObject(InputStream inputStream, Type type, Feature... featureArr) throws IOException {
        return (T) parseObject(inputStream, IOUtils.UTF8, type, featureArr);
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, Feature... featureArr) throws IOException {
        return (T) parseObject(inputStream, charset, type, ParserConfig.global, featureArr);
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, ParserConfig parserConfig, Feature... featureArr) throws IOException {
        return (T) parseObject(inputStream, charset, type, parserConfig, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i2, Feature... featureArr) throws IOException {
        if (charset == null) {
            charset = IOUtils.UTF8;
        }
        Charset charset2 = charset;
        byte[] allocateBytes = allocateBytes(65536);
        int i3 = 0;
        while (true) {
            int read = inputStream.read(allocateBytes, i3, allocateBytes.length - i3);
            if (read == -1) {
                return (T) parseObject(allocateBytes, 0, i3, charset2, type, parserConfig, parseProcess, i2, featureArr);
            }
            i3 += read;
            if (i3 == allocateBytes.length) {
                byte[] bArr = new byte[(allocateBytes.length * 3) / 2];
                System.arraycopy(allocateBytes, 0, bArr, 0, allocateBytes.length);
                allocateBytes = bArr;
            }
        }
    }

    public static <T> T parseObject(String str, Class<T> cls) {
        return (T) parseObject(str, (Class<Object>) cls, new Feature[0]);
    }
}
