package com.alibaba.fastjson;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes4.dex */
public abstract class JSON implements JSONStreamAware, JSONAware {
    public static /* synthetic */ Interceptable $ic = null;
    public static int DEFAULT_GENERATE_FEATURE = 0;
    public static int DEFAULT_PARSER_FEATURE = 0;
    public static String DEFAULT_TYPE_KEY = null;
    public static String DEFFAULT_DATE_FORMAT = null;
    public static final String VERSION = "1.2.75";
    public static final ThreadLocal<byte[]> bytesLocal;
    public static final ThreadLocal<char[]> charsLocal;
    public static Locale defaultLocale;
    public static TimeZone defaultTimeZone;
    public static final SerializeFilter[] emptyFilters;
    public static final ConcurrentHashMap<Type, Type> mixInsMapper;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1997638261, "Lcom/alibaba/fastjson/JSON;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1997638261, "Lcom/alibaba/fastjson/JSON;");
                return;
            }
        }
        defaultTimeZone = TimeZone.getDefault();
        defaultLocale = Locale.getDefault();
        DEFAULT_TYPE_KEY = "@type";
        emptyFilters = new SerializeFilter[0];
        DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        mixInsMapper = new ConcurrentHashMap<>(16);
        DEFAULT_PARSER_FEATURE = Feature.AutoCloseSource.getMask() | 0 | Feature.InternFieldNames.getMask() | Feature.UseBigDecimal.getMask() | Feature.AllowUnQuotedFieldNames.getMask() | Feature.AllowSingleQuotes.getMask() | Feature.AllowArbitraryCommas.getMask() | Feature.SortFeidFastMatch.getMask() | Feature.IgnoreNotMatch.getMask();
        DEFAULT_GENERATE_FEATURE = 0 | SerializerFeature.QuoteFieldNames.getMask() | SerializerFeature.SkipTransientField.getMask() | SerializerFeature.WriteEnumUsingName.getMask() | SerializerFeature.SortField.getMask();
        config(IOUtils.DEFAULT_PROPERTIES);
        bytesLocal = new ThreadLocal<>();
        charsLocal = new ThreadLocal<>();
    }

    public JSON() {
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

    public static void addMixInAnnotations(Type type, Type type2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, type, type2) == null) || type == null || type2 == null) {
            return;
        }
        mixInsMapper.put(type, type2);
    }

    public static byte[] allocateBytes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
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
        return (byte[]) invokeI.objValue;
    }

    public static char[] allocateChars(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
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
        return (char[]) invokeI.objValue;
    }

    public static void clearMixInAnnotations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            mixInsMapper.clear();
        }
    }

    public static void config(Properties properties) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, properties) == null) {
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
    }

    public static Type getMixInAnnotations(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, type)) == null) {
            if (type != null) {
                return mixInsMapper.get(type);
            }
            return null;
        }
        return (Type) invokeL.objValue;
    }

    public static <T> void handleResovleTask(DefaultJSONParser defaultJSONParser, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, defaultJSONParser, t) == null) {
            defaultJSONParser.handleResovleTask(t);
        }
    }

    public static boolean isValid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean isValidArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean isValidObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
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
        return invokeL.booleanValue;
    }

    public static Object parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? parse(str, DEFAULT_PARSER_FEATURE) : invokeL.objValue;
    }

    public static JSONArray parseArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) ? parseArray(str, ParserConfig.global) : (JSONArray) invokeL.objValue;
    }

    public static JSONObject parseObject(String str, Feature... featureArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, str, featureArr)) == null) ? (JSONObject) parse(str, featureArr) : (JSONObject) invokeLL.objValue;
    }

    public static void removeMixInAnnotations(Type type) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65585, null, type) == null) || type == null) {
            return;
        }
        mixInsMapper.remove(type);
    }

    public static void setDefaultTypeKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65586, null, str) == null) {
            DEFAULT_TYPE_KEY = str;
            ParserConfig.global.symbolTable.addSymbol(str, 0, str.length(), str.hashCode(), true);
        }
    }

    public static Object toJSON(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65587, null, obj)) == null) ? toJSON(obj, SerializeConfig.globalInstance) : invokeL.objValue;
    }

    public static byte[] toJSONBytes(Object obj, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65598, null, obj, serializerFeatureArr)) == null) ? toJSONBytes(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : (byte[]) invokeLL.objValue;
    }

    public static byte[] toJSONBytesWithFastJsonConfig(Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i2, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65600, null, new Object[]{charset, obj, serializeConfig, serializeFilterArr, str, Integer.valueOf(i2), serializerFeatureArr})) == null) {
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
        return (byte[]) invokeCommon.objValue;
    }

    public static String toJSONString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65601, null, obj)) == null) ? toJSONString(obj, emptyFilters, new SerializerFeature[0]) : (String) invokeL.objValue;
    }

    public static String toJSONStringWithDateFormat(Object obj, String str, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65611, null, obj, str, serializerFeatureArr)) == null) ? toJSONString(obj, SerializeConfig.globalInstance, null, str, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : (String) invokeLLL.objValue;
    }

    public static String toJSONStringZ(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65612, null, obj, serializeConfig, serializerFeatureArr)) == null) ? toJSONString(obj, serializeConfig, emptyFilters, null, 0, serializerFeatureArr) : (String) invokeLLL.objValue;
    }

    public static <T> T toJavaObject(JSON json, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65613, null, json, cls)) == null) ? (T) TypeUtils.cast((Object) json, (Class<Object>) cls, ParserConfig.getGlobalInstance()) : (T) invokeLL.objValue;
    }

    public static void writeJSONString(Writer writer, Object obj, SerializerFeature... serializerFeatureArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65619, null, writer, obj, serializerFeatureArr) == null) {
            writeJSONString(writer, obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        }
    }

    public static void writeJSONStringTo(Object obj, Writer writer, SerializerFeature... serializerFeatureArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65620, null, obj, writer, serializerFeatureArr) == null) {
            writeJSONString(writer, obj, serializerFeatureArr);
        }
    }

    public static final int writeJSONStringWithFastJsonConfig(OutputStream outputStream, Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i2, SerializerFeature... serializerFeatureArr) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65621, null, new Object[]{outputStream, charset, obj, serializeConfig, serializeFilterArr, str, Integer.valueOf(i2), serializerFeatureArr})) == null) {
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
        return invokeCommon.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? toJSONString() : (String) invokeV.objValue;
    }

    public static Object parse(String str, ParserConfig parserConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, parserConfig)) == null) ? parse(str, parserConfig, DEFAULT_PARSER_FEATURE) : invokeLL.objValue;
    }

    public static JSONArray parseArray(String str, ParserConfig parserConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, str, parserConfig)) == null) {
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
        return (JSONArray) invokeLL.objValue;
    }

    public static JSONObject parseObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
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
        return (JSONObject) invokeL.objValue;
    }

    public static Object toJSON(Object obj, ParserConfig parserConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65588, null, obj, parserConfig)) == null) ? toJSON(obj, SerializeConfig.globalInstance) : invokeLL.objValue;
    }

    public static byte[] toJSONBytes(Object obj, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65596, null, obj, serializeFilter, serializerFeatureArr)) == null) ? toJSONBytes(obj, SerializeConfig.globalInstance, new SerializeFilter[]{serializeFilter}, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : (byte[]) invokeLLL.objValue;
    }

    public static String toJSONString(Object obj, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65610, null, obj, serializerFeatureArr)) == null) ? toJSONString(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : (String) invokeLL.objValue;
    }

    public static void writeJSONString(Writer writer, Object obj, int i2, SerializerFeature... serializerFeatureArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65618, null, writer, obj, i2, serializerFeatureArr) == null) {
            SerializeWriter serializeWriter = new SerializeWriter(writer, i2, serializerFeatureArr);
            try {
                new JSONSerializer(serializeWriter).write(obj);
            } finally {
                serializeWriter.close();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.alibaba.fastjson.JSON */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T toJavaObject(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls)) == null) ? (cls == JSONArray.class || cls == JSON.class || cls == Collection.class || cls == List.class) ? this : (T) TypeUtils.cast((Object) this, (Class<Object>) cls, ParserConfig.getGlobalInstance()) : (T) invokeL.objValue;
    }

    public String toString(SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, serializerFeatureArr)) == null) {
            SerializeWriter serializeWriter = new SerializeWriter(null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
            try {
                new JSONSerializer(serializeWriter).write(this);
                return serializeWriter.toString();
            } finally {
                serializeWriter.close();
            }
        }
        return (String) invokeL.objValue;
    }

    public static Object parse(String str, ParserConfig parserConfig, Feature... featureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, str, parserConfig, featureArr)) == null) {
            int i2 = DEFAULT_PARSER_FEATURE;
            for (Feature feature : featureArr) {
                i2 = Feature.config(i2, feature, true);
            }
            return parse(str, parserConfig, i2);
        }
        return invokeLLL.objValue;
    }

    public static Object toJSON(Object obj, SerializeConfig serializeConfig) {
        InterceptResult invokeLL;
        Map hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65589, null, obj, serializeConfig)) == null) {
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
        return invokeLL.objValue;
    }

    public static byte[] toJSONBytes(Object obj, int i2, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65590, null, obj, i2, serializerFeatureArr)) == null) ? toJSONBytes(obj, SerializeConfig.globalInstance, i2, serializerFeatureArr) : (byte[]) invokeLIL.objValue;
    }

    public static String toJSONString(Object obj, int i2, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65602, null, obj, i2, serializerFeatureArr)) == null) {
            SerializeWriter serializeWriter = new SerializeWriter(null, i2, serializerFeatureArr);
            try {
                new JSONSerializer(serializeWriter).write(obj);
                return serializeWriter.toString();
            } finally {
                serializeWriter.close();
            }
        }
        return (String) invokeLIL.objValue;
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65595, null, obj, serializeConfig, serializerFeatureArr)) == null) ? toJSONBytes(obj, serializeConfig, emptyFilters, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : (byte[]) invokeLLL.objValue;
    }

    public <T> T toJavaObject(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, type)) == null) ? (T) TypeUtils.cast(this, type, ParserConfig.getGlobalInstance()) : (T) invokeL.objValue;
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, int i2, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65591, null, obj, serializeConfig, i2, serializerFeatureArr)) == null) ? toJSONBytes(obj, serializeConfig, emptyFilters, i2, serializerFeatureArr) : (byte[]) invokeLLIL.objValue;
    }

    public <T> T toJavaObject(TypeReference typeReference) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, typeReference)) == null) {
            return (T) TypeUtils.cast(this, typeReference != null ? typeReference.getType() : null, ParserConfig.getGlobalInstance());
        }
        return (T) invokeL.objValue;
    }

    public static byte[] toJSONBytes(Object obj, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65597, null, obj, serializeFilterArr, serializerFeatureArr)) == null) ? toJSONBytes(obj, SerializeConfig.globalInstance, serializeFilterArr, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : (byte[]) invokeLLL.objValue;
    }

    public static Object parse(String str, ParserConfig parserConfig, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65551, null, str, parserConfig, i2)) == null) {
            if (str == null) {
                return null;
            }
            DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i2);
            Object parse = defaultJSONParser.parse();
            defaultJSONParser.handleResovleTask(parse);
            defaultJSONParser.close();
            return parse;
        }
        return invokeLLI.objValue;
    }

    public static <T> T parseObject(String str, TypeReference<T> typeReference, Feature... featureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65569, null, str, typeReference, featureArr)) == null) ? (T) parseObject(str, typeReference.type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr) : (T) invokeLLL.objValue;
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65592, null, obj, serializeConfig, serializeFilter, serializerFeatureArr)) == null) ? toJSONBytes(obj, serializeConfig, new SerializeFilter[]{serializeFilter}, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : (byte[]) invokeLLLL.objValue;
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, SerializerFeature... serializerFeatureArr) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65615, null, outputStream, obj, serializerFeatureArr)) == null) ? writeJSONString(outputStream, obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : invokeLLL.intValue;
    }

    public static <T> T parseObject(String str, Class<T> cls, Feature... featureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65572, null, str, cls, featureArr)) == null) ? (T) parseObject(str, cls, ParserConfig.global, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr) : (T) invokeLLL.objValue;
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, int i2, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65593, null, new Object[]{obj, serializeConfig, serializeFilterArr, Integer.valueOf(i2), serializerFeatureArr})) == null) ? toJSONBytes(obj, serializeConfig, serializeFilterArr, null, i2, serializerFeatureArr) : (byte[]) invokeCommon.objValue;
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, int i2, SerializerFeature... serializerFeatureArr) throws IOException {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65614, null, outputStream, obj, i2, serializerFeatureArr)) == null) ? writeJSONString(outputStream, IOUtils.UTF8, obj, SerializeConfig.globalInstance, null, null, i2, serializerFeatureArr) : invokeLLIL.intValue;
    }

    public static <T> T parseObject(String str, Class<T> cls, ParseProcess parseProcess, Feature... featureArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65571, null, str, cls, parseProcess, featureArr)) == null) ? (T) parseObject(str, cls, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr) : (T) invokeLLLL.objValue;
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i2, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65594, null, new Object[]{obj, serializeConfig, serializeFilterArr, str, Integer.valueOf(i2), serializerFeatureArr})) == null) ? toJSONBytes(IOUtils.UTF8, obj, serializeConfig, serializeFilterArr, str, i2, serializerFeatureArr) : (byte[]) invokeCommon.objValue;
    }

    public static String toJSONString(Object obj, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65607, null, obj, serializeFilter, serializerFeatureArr)) == null) ? toJSONString(obj, SerializeConfig.globalInstance, new SerializeFilter[]{serializeFilter}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : (String) invokeLLL.objValue;
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, SerializerFeature... serializerFeatureArr) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65617, null, outputStream, charset, obj, serializerFeatureArr)) == null) ? writeJSONString(outputStream, charset, obj, SerializeConfig.globalInstance, null, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : invokeLLLL.intValue;
    }

    public static <T> T parseObject(String str, Type type, Feature... featureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65578, null, str, type, featureArr)) == null) ? (T) parseObject(str, type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr) : (T) invokeLLL.objValue;
    }

    public static byte[] toJSONBytes(Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i2, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65599, null, new Object[]{charset, obj, serializeConfig, serializeFilterArr, str, Integer.valueOf(i2), serializerFeatureArr})) == null) {
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
        return (byte[]) invokeCommon.objValue;
    }

    public static String toJSONString(Object obj, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65609, null, obj, serializeFilterArr, serializerFeatureArr)) == null) ? toJSONString(obj, SerializeConfig.globalInstance, serializeFilterArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : (String) invokeLLL.objValue;
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i2, SerializerFeature... serializerFeatureArr) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65616, null, new Object[]{outputStream, charset, obj, serializeConfig, serializeFilterArr, str, Integer.valueOf(i2), serializerFeatureArr})) == null) {
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
        return invokeCommon.intValue;
    }

    public static Object parse(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, str, i2)) == null) ? parse(str, ParserConfig.getGlobalInstance(), i2) : invokeLI.objValue;
    }

    public static <T> List<T> parseArray(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, str, cls)) == null) ? parseArray(str, cls, ParserConfig.global) : (List) invokeLL.objValue;
    }

    public static <T> T parseObject(String str, Type type, ParseProcess parseProcess, Feature... featureArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65577, null, str, type, parseProcess, featureArr)) == null) ? (T) parseObject(str, type, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr) : (T) invokeLLLL.objValue;
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65606, null, obj, serializeConfig, serializerFeatureArr)) == null) ? toJSONString(obj, serializeConfig, (SerializeFilter) null, serializerFeatureArr) : (String) invokeLLL.objValue;
    }

    public static Object parse(byte[] bArr, Feature... featureArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, bArr, featureArr)) == null) {
            char[] allocateChars = allocateChars(bArr.length);
            int decodeUTF8 = IOUtils.decodeUTF8(bArr, 0, bArr.length, allocateChars);
            if (decodeUTF8 < 0) {
                return null;
            }
            return parse(new String(allocateChars, 0, decodeUTF8), featureArr);
        }
        return invokeLL.objValue;
    }

    public static <T> List<T> parseArray(String str, Class<T> cls, ParserConfig parserConfig) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65560, null, str, cls, parserConfig)) == null) {
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
        return (List) invokeLLL.objValue;
    }

    public static <T> T parseObject(String str, Type type, int i2, Feature... featureArr) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65573, null, str, type, i2, featureArr)) == null) {
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
        return (T) invokeLLIL.objValue;
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65603, null, obj, serializeConfig, serializeFilter, serializerFeatureArr)) == null) ? toJSONString(obj, serializeConfig, new SerializeFilter[]{serializeFilter}, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : (String) invokeLLLL.objValue;
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65605, null, obj, serializeConfig, serializeFilterArr, serializerFeatureArr)) == null) ? toJSONString(obj, serializeConfig, serializeFilterArr, null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr) : (String) invokeLLLL.objValue;
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i2, SerializerFeature... serializerFeatureArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65604, null, new Object[]{obj, serializeConfig, serializeFilterArr, str, Integer.valueOf(i2), serializerFeatureArr})) == null) {
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
        return (String) invokeCommon.objValue;
    }

    public static Object parse(byte[] bArr, int i2, int i3, CharsetDecoder charsetDecoder, Feature... featureArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), charsetDecoder, featureArr})) == null) {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            int i4 = DEFAULT_PARSER_FEATURE;
            for (Feature feature : featureArr) {
                i4 = Feature.config(i4, feature, true);
            }
            return parse(bArr, i2, i3, charsetDecoder, i4);
        }
        return invokeCommon.objValue;
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, Feature... featureArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65576, null, str, type, parserConfig, featureArr)) == null) ? (T) parseObject(str, type, parserConfig, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr) : (T) invokeLLLL.objValue;
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, int i2, Feature... featureArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65574, null, new Object[]{str, type, parserConfig, Integer.valueOf(i2), featureArr})) == null) ? (T) parseObject(str, type, parserConfig, (ParseProcess) null, i2, featureArr) : (T) invokeCommon.objValue;
    }

    public static Object parse(byte[] bArr, int i2, int i3, CharsetDecoder charsetDecoder, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), charsetDecoder, Integer.valueOf(i4)})) == null) {
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
        return invokeCommon.objValue;
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i2, Feature... featureArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65575, null, new Object[]{str, type, parserConfig, parseProcess, Integer.valueOf(i2), featureArr})) == null) {
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
        return (T) invokeCommon.objValue;
    }

    public static List<Object> parseArray(String str, Type[] typeArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, typeArr)) == null) ? parseArray(str, typeArr, ParserConfig.global) : (List) invokeLL.objValue;
    }

    @Override // com.alibaba.fastjson.JSONStreamAware
    public void writeJSONString(Appendable appendable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, appendable) == null) {
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
    }

    public static List<Object> parseArray(String str, Type[] typeArr, ParserConfig parserConfig) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65562, null, str, typeArr, parserConfig)) == null) {
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
        return (List) invokeLLL.objValue;
    }

    public static String toJSONString(Object obj, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65608, null, obj, z)) == null) ? !z ? toJSONString(obj) : toJSONString(obj, SerializerFeature.PrettyFormat) : (String) invokeLZ.objValue;
    }

    @Override // com.alibaba.fastjson.JSONAware
    public String toJSONString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SerializeWriter serializeWriter = new SerializeWriter();
            try {
                new JSONSerializer(serializeWriter).write(this);
                return serializeWriter.toString();
            } finally {
                serializeWriter.close();
            }
        }
        return (String) invokeV.objValue;
    }

    public static Object parse(String str, Feature... featureArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, str, featureArr)) == null) {
            int i2 = DEFAULT_PARSER_FEATURE;
            for (Feature feature : featureArr) {
                i2 = Feature.config(i2, feature, true);
            }
            return parse(str, i2);
        }
        return invokeLL.objValue;
    }

    public static <T> T parseObject(byte[] bArr, Type type, Feature... featureArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65582, null, bArr, type, featureArr)) == null) ? (T) parseObject(bArr, 0, bArr.length, IOUtils.UTF8, type, featureArr) : (T) invokeLLL.objValue;
    }

    public static <T> T parseObject(byte[] bArr, int i2, int i3, Charset charset, Type type, Feature... featureArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65580, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), charset, type, featureArr})) == null) ? (T) parseObject(bArr, i2, i3, charset, type, ParserConfig.global, null, DEFAULT_PARSER_FEATURE, featureArr) : (T) invokeCommon.objValue;
    }

    public static <T> T parseObject(byte[] bArr, Charset charset, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i2, Feature... featureArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65583, null, new Object[]{bArr, charset, type, parserConfig, parseProcess, Integer.valueOf(i2), featureArr})) == null) ? (T) parseObject(bArr, 0, bArr.length, charset, type, parserConfig, parseProcess, i2, featureArr) : (T) invokeCommon.objValue;
    }

    public static <T> T parseObject(byte[] bArr, int i2, int i3, Charset charset, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i4, Feature... featureArr) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65579, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), charset, type, parserConfig, parseProcess, Integer.valueOf(i4), featureArr})) == null) {
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
        return (T) invokeCommon.objValue;
    }

    public static <T> T parseObject(byte[] bArr, int i2, int i3, CharsetDecoder charsetDecoder, Type type, Feature... featureArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65581, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), charsetDecoder, type, featureArr})) == null) {
            charsetDecoder.reset();
            char[] allocateChars = allocateChars((int) (i3 * charsetDecoder.maxCharsPerByte()));
            ByteBuffer wrap = ByteBuffer.wrap(bArr, i2, i3);
            CharBuffer wrap2 = CharBuffer.wrap(allocateChars);
            IOUtils.decode(charsetDecoder, wrap, wrap2);
            return (T) parseObject(allocateChars, wrap2.position(), type, featureArr);
        }
        return (T) invokeCommon.objValue;
    }

    public static <T> T parseObject(char[] cArr, int i2, Type type, Feature... featureArr) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65584, null, cArr, i2, type, featureArr)) == null) {
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
        return (T) invokeLILL.objValue;
    }

    public static <T> T parseObject(InputStream inputStream, Type type, Feature... featureArr) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65565, null, inputStream, type, featureArr)) == null) ? (T) parseObject(inputStream, IOUtils.UTF8, type, featureArr) : (T) invokeLLL.objValue;
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, Feature... featureArr) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65568, null, inputStream, charset, type, featureArr)) == null) ? (T) parseObject(inputStream, charset, type, ParserConfig.global, featureArr) : (T) invokeLLLL.objValue;
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, ParserConfig parserConfig, Feature... featureArr) throws IOException {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65567, null, inputStream, charset, type, parserConfig, featureArr)) == null) ? (T) parseObject(inputStream, charset, type, parserConfig, (ParseProcess) null, DEFAULT_PARSER_FEATURE, featureArr) : (T) invokeLLLLL.objValue;
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i2, Feature... featureArr) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{inputStream, charset, type, parserConfig, parseProcess, Integer.valueOf(i2), featureArr})) != null) {
            return (T) invokeCommon.objValue;
        }
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
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, str, cls)) == null) ? (T) parseObject(str, (Class<Object>) cls, new Feature[0]) : (T) invokeLL.objValue;
    }
}
