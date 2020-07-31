package com.alibaba.fastjson.util;

import android.support.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.vivo.push.PushClientConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public class TypeUtils {
    public static boolean compatibleWithFieldName;
    public static boolean compatibleWithJavaBean;
    private static volatile Map<Class, String[]> kotlinIgnores;
    private static volatile boolean kotlinIgnores_error;
    private static volatile boolean kotlin_class_klass_error;
    private static volatile boolean kotlin_error;
    private static volatile Constructor kotlin_kclass_constructor;
    private static volatile Method kotlin_kclass_getConstructors;
    private static volatile Method kotlin_kfunction_getParameters;
    private static volatile Method kotlin_kparameter_getName;
    private static volatile Class kotlin_metadata;
    private static volatile boolean kotlin_metadata_error;
    private static Class<?> optionalClass;
    private static Method oracleDateMethod;
    private static Method oracleTimestampMethod;
    private static Class<?> pathClass;
    private static Class<? extends Annotation> transientClass;
    private static boolean setAccessibleEnable = true;
    private static boolean oracleTimestampMethodInited = false;
    private static boolean oracleDateMethodInited = false;
    private static boolean optionalClassInited = false;
    private static boolean transientClassInited = false;
    private static Class<? extends Annotation> class_OneToMany = null;
    private static boolean class_OneToMany_error = false;
    private static Class<? extends Annotation> class_ManyToMany = null;
    private static boolean class_ManyToMany_error = false;
    private static Method method_HibernateIsInitialized = null;
    private static boolean method_HibernateIsInitialized_error = false;
    private static ConcurrentMap<String, Class<?>> mappings = new ConcurrentHashMap(16, 0.75f, 1);
    private static boolean pathClass_error = false;

    static {
        compatibleWithJavaBean = false;
        compatibleWithFieldName = false;
        try {
            compatibleWithJavaBean = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHJAVABEAN));
            compatibleWithFieldName = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHFIELDNAME));
        } catch (Throwable th) {
        }
        addBaseClassMappings();
    }

    public static String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Byte castToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() != 1) {
                throw new JSONException("can not cast to char, value : " + obj);
            }
            return Character.valueOf(str.charAt(0));
        }
        throw new JSONException("can not cast to char, value : " + obj);
    }

    public static Short castToShort(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        throw new JSONException("can not cast to short, value : " + obj);
    }

    public static BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return null;
        }
        if ((obj instanceof Map) && ((Map) obj).size() == 0) {
            return null;
        }
        return new BigDecimal(obj2);
    }

    public static BigInteger castToBigInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static Float castToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            if (obj2.indexOf(44) != 0) {
                obj2 = obj2.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        throw new JSONException("can not cast to float, value : " + obj);
    }

    public static Double castToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || "null".equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            if (obj2.indexOf(44) != 0) {
                obj2 = obj2.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        throw new JSONException("can not cast to double, value : " + obj);
    }

    public static Date castToDate(Object obj) {
        String str;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        long j = -1;
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            JSONScanner jSONScanner = new JSONScanner(str2);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    return jSONScanner.getCalendar().getTime();
                }
                jSONScanner.close();
                if (str2.startsWith("/Date(") && str2.endsWith(")/")) {
                    str2 = str2.substring(6, str2.length() - 2);
                }
                if (str2.indexOf(45) != -1) {
                    if (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length() || (str2.length() == 22 && JSON.DEFFAULT_DATE_FORMAT.equals("yyyyMMddHHmmssSSSZ"))) {
                        str = JSON.DEFFAULT_DATE_FORMAT;
                    } else if (str2.length() == 10) {
                        str = ControlShowManager.DAY_TIME_FORMAT;
                    } else if (str2.length() == "yyyy-MM-dd HH:mm:ss".length()) {
                        str = "yyyy-MM-dd HH:mm:ss";
                    } else if (str2.length() == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') {
                        str = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
                    } else {
                        str = "yyyy-MM-dd HH:mm:ss.SSS";
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                    simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                    try {
                        return simpleDateFormat.parse(str2);
                    } catch (ParseException e) {
                        throw new JSONException("can not cast to Date, value : " + str2);
                    }
                } else if (str2.length() == 0) {
                    return null;
                } else {
                    j = Long.parseLong(str2);
                }
            } finally {
                jSONScanner.close();
            }
        }
        if (j < 0) {
            Class<?> cls = obj.getClass();
            if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
                if (oracleTimestampMethod == null && !oracleTimestampMethodInited) {
                    try {
                        oracleTimestampMethod = cls.getMethod("toJdbc", new Class[0]);
                    } catch (NoSuchMethodException e2) {
                    } finally {
                        oracleTimestampMethodInited = true;
                    }
                }
                try {
                    return (Date) oracleTimestampMethod.invoke(obj, new Object[0]);
                } catch (Exception e3) {
                    throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e3);
                }
            } else if ("oracle.sql.DATE".equals(cls.getName())) {
                if (oracleDateMethod == null && !oracleDateMethodInited) {
                    try {
                        oracleDateMethod = cls.getMethod("toJdbc", new Class[0]);
                    } catch (NoSuchMethodException e4) {
                    } finally {
                        oracleDateMethodInited = true;
                    }
                }
                try {
                    return (Date) oracleDateMethod.invoke(obj, new Object[0]);
                } catch (Exception e5) {
                    throw new JSONException("can not cast oracle.sql.DATE to Date", e5);
                }
            } else {
                throw new JSONException("can not cast to Date, value : " + obj);
            }
        }
        return new Date(j);
    }

    public static java.sql.Date castToSqlDate(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.sql.Date) {
            return (java.sql.Date) obj;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new java.sql.Date(((Calendar) obj).getTimeInMillis());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (isNumber(str)) {
                longValue = Long.parseLong(str);
            } else {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    longValue = jSONScanner.getCalendar().getTime().getTime();
                } else {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
            }
        }
        if (longValue <= 0) {
            throw new JSONException("can not cast to Date, value : " + obj);
        }
        return new java.sql.Date(longValue);
    }

    public static Timestamp castToTimestamp(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new Timestamp(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof Date) {
            return new Timestamp(((Date) obj).getTime());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.endsWith(".000000000")) {
                str = str.substring(0, str.length() - 10);
            } else if (str.endsWith(".000000")) {
                str = str.substring(0, str.length() - 7);
            }
            if (isNumber(str)) {
                longValue = Long.parseLong(str);
            } else {
                JSONScanner jSONScanner = new JSONScanner(str);
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    longValue = jSONScanner.getCalendar().getTime().getTime();
                } else {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
            }
        }
        if (longValue <= 0) {
            throw new JSONException("can not cast to Timestamp, value : " + obj);
        }
        return new Timestamp(longValue);
    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '+' || charAt == '-') {
                if (i != 0) {
                    return false;
                }
            } else if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static Long castToLong(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != 0) {
                str = str.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException e) {
                JSONScanner jSONScanner = new JSONScanner(str);
                Calendar calendar = jSONScanner.scanISO8601DateIfMatch(false) ? jSONScanner.getCalendar() : null;
                jSONScanner.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return castToLong(it.next());
            }
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static Integer castToInt(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != 0) {
                str = str.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
            }
            return Integer.valueOf(Integer.parseInt(str));
        } else if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                    Iterator it = map.values().iterator();
                    it.next();
                    return castToInt(it.next());
                }
            }
            throw new JSONException("can not cast to int, value : " + obj);
        }
    }

    public static byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return IOUtils.decodeBase64((String) obj);
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("Y".equalsIgnoreCase(str) || ExifInterface.GPS_DIRECTION_TRUE.equals(str)) {
                return Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException("can not cast to boolean, value : " + obj);
    }

    public static <T> T castToJavaBean(Object obj, Class<T> cls) {
        return (T) cast(obj, (Class<Object>) cls, ParserConfig.getGlobalInstance());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        Calendar calendar;
        int i = 0;
        if (obj == 0) {
            if (cls == Integer.TYPE) {
                return (T) 0;
            }
            if (cls == Long.TYPE) {
                return (T) 0L;
            }
            if (cls == Short.TYPE) {
                return (T) (short) 0;
            }
            if (cls == Byte.TYPE) {
                return (T) (byte) 0;
            }
            if (cls == Float.TYPE) {
                return (T) Float.valueOf(0.0f);
            }
            if (cls == Double.TYPE) {
                return (T) Double.valueOf(0.0d);
            }
            if (cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            return null;
        } else if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else {
            if (cls != obj.getClass()) {
                if (obj instanceof Map) {
                    if (cls != Map.class) {
                        Map map = (Map) obj;
                        if (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) {
                            return (T) castToJavaBean((Map) obj, cls, parserConfig);
                        }
                        return obj;
                    }
                    return obj;
                }
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        T t = (T) Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object obj2 : collection) {
                            Array.set(t, i, cast(obj2, (Class<Object>) cls.getComponentType(), parserConfig));
                            i++;
                        }
                        return t;
                    } else if (cls == byte[].class) {
                        return (T) castToBytes(obj);
                    }
                }
                if (!cls.isAssignableFrom(obj.getClass())) {
                    if (cls == Boolean.TYPE || cls == Boolean.class) {
                        return (T) castToBoolean(obj);
                    }
                    if (cls == Byte.TYPE || cls == Byte.class) {
                        return (T) castToByte(obj);
                    }
                    if (cls == Character.TYPE || cls == Character.class) {
                        return (T) castToChar(obj);
                    }
                    if (cls == Short.TYPE || cls == Short.class) {
                        return (T) castToShort(obj);
                    }
                    if (cls == Integer.TYPE || cls == Integer.class) {
                        return (T) castToInt(obj);
                    }
                    if (cls == Long.TYPE || cls == Long.class) {
                        return (T) castToLong(obj);
                    }
                    if (cls == Float.TYPE || cls == Float.class) {
                        return (T) castToFloat(obj);
                    }
                    if (cls == Double.TYPE || cls == Double.class) {
                        return (T) castToDouble(obj);
                    }
                    if (cls == String.class) {
                        return (T) castToString(obj);
                    }
                    if (cls == BigDecimal.class) {
                        return (T) castToBigDecimal(obj);
                    }
                    if (cls == BigInteger.class) {
                        return (T) castToBigInteger(obj);
                    }
                    if (cls == Date.class) {
                        return (T) castToDate(obj);
                    }
                    if (cls == java.sql.Date.class) {
                        return (T) castToSqlDate(obj);
                    }
                    if (cls == Timestamp.class) {
                        return (T) castToTimestamp(obj);
                    }
                    if (cls.isEnum()) {
                        return (T) castToEnum(obj, cls, parserConfig);
                    }
                    if (Calendar.class.isAssignableFrom(cls)) {
                        Date castToDate = castToDate(obj);
                        if (cls == Calendar.class) {
                            calendar = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                        } else {
                            try {
                                calendar = (Calendar) cls.newInstance();
                            } catch (Exception e) {
                                throw new JSONException("can not cast to : " + cls.getName(), e);
                            }
                        }
                        calendar.setTime(castToDate);
                        return (T) calendar;
                    } else if (cls.getName().equals("javax.xml.datatype.XMLGregorianCalendar")) {
                        Date castToDate2 = castToDate(obj);
                        Calendar calendar2 = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                        calendar2.setTime(castToDate2);
                        return (T) CalendarCodec.instance.createXMLGregorianCalendar(calendar2);
                    } else {
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                                return null;
                            }
                            if (cls == Currency.class) {
                                return (T) Currency.getInstance(str);
                            }
                            if (cls == Locale.class) {
                                return (T) toLocale(str);
                            }
                        }
                        throw new JSONException("can not cast to : " + cls.getName());
                    }
                }
                return obj;
            }
            return obj;
        }
    }

    public static Locale toLocale(String str) {
        String[] split = str.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        if (split.length == 1) {
            return new Locale(split[0]);
        }
        if (split.length == 2) {
            return new Locale(split[0], split[1]);
        }
        return new Locale(split[0], split[1], split[2]);
    }

    public static <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e) {
            throw new JSONException("can not cast to : " + cls.getName(), e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) cast(obj, (Class<Object>) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return (T) cast(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.util.Map, java.util.HashMap] */
    public static <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        T t;
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType == Set.class || rawType == HashSet.class) {
                    t = (T) new HashSet();
                } else if (rawType == TreeSet.class) {
                    t = (T) new TreeSet();
                } else {
                    t = (T) new ArrayList();
                }
                for (T t2 : (Iterable) obj) {
                    ((Collection) t).add(cast(t2, type, parserConfig));
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r1 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r1.put(cast(entry.getKey(), type2, parserConfig), cast(entry.getValue(), type3, parserConfig));
                }
                return r1;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        if (rawType == Map.Entry.class && (obj instanceof Map) && ((Map) obj).size() == 1) {
            return (T) ((Map.Entry) ((Map) obj).entrySet().iterator().next());
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }

    public static <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        ParserConfig parserConfig2;
        JSONObject jSONObject;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get(PushClientConstants.TAG_CLASS_NAME);
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                return (T) new StackTraceElement(str, str2, str3, number != null ? number.intValue() : 0);
            }
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            if (obj instanceof String) {
                String str4 = (String) obj;
                parserConfig2 = parserConfig == null ? ParserConfig.global : parserConfig;
                Class<?> checkAutoType = parserConfig2.checkAutoType(str4, null);
                if (checkAutoType == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!checkAutoType.equals(cls)) {
                    return (T) castToJavaBean(map, checkAutoType, parserConfig2);
                }
            } else {
                parserConfig2 = parserConfig;
            }
            if (cls.isInterface()) {
                if (map instanceof JSONObject) {
                    jSONObject = (JSONObject) map;
                } else {
                    jSONObject = new JSONObject(map);
                }
                if (parserConfig2 == null) {
                    parserConfig2 = ParserConfig.getGlobalInstance();
                }
                return parserConfig2.getDeserializers().get(cls) != null ? (T) JSON.parseObject(JSON.toJSONString(jSONObject), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            }
            if (cls == Locale.class) {
                Object obj2 = map.get("language");
                Object obj3 = map.get("country");
                if (obj2 instanceof String) {
                    String str5 = (String) obj2;
                    if (obj3 instanceof String) {
                        return (T) new Locale(str5, (String) obj3);
                    }
                    if (obj3 == null) {
                        return (T) new Locale(str5);
                    }
                }
            }
            if (cls == String.class && (map instanceof JSONObject)) {
                return (T) map.toString();
            }
            if (cls == LinkedHashMap.class && (map instanceof JSONObject)) {
                T t = (T) ((JSONObject) map).getInnerMap();
                if (!(t instanceof LinkedHashMap)) {
                    new LinkedHashMap().putAll(t);
                } else {
                    return t;
                }
            }
            ParserConfig globalInstance = parserConfig2 == null ? ParserConfig.getGlobalInstance() : parserConfig2;
            ObjectDeserializer deserializer = globalInstance.getDeserializer(cls);
            JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
            if (javaBeanDeserializer == null) {
                throw new JSONException("can not get javaBeanDeserializer. " + cls.getName());
            }
            return (T) javaBeanDeserializer.createInstance(map, globalInstance);
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    private static void addBaseClassMappings() {
        Class<?>[] clsArr;
        mappings.put("byte", Byte.TYPE);
        mappings.put("short", Short.TYPE);
        mappings.put("int", Integer.TYPE);
        mappings.put("long", Long.TYPE);
        mappings.put("float", Float.TYPE);
        mappings.put("double", Double.TYPE);
        mappings.put("boolean", Boolean.TYPE);
        mappings.put("char", Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put("[B", byte[].class);
        mappings.put("[S", short[].class);
        mappings.put("[I", int[].class);
        mappings.put("[J", long[].class);
        mappings.put("[F", float[].class);
        mappings.put("[D", double[].class);
        mappings.put("[C", char[].class);
        mappings.put("[Z", boolean[].class);
        for (Class<?> cls : new Class[]{Object.class, Cloneable.class, loadClass("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, Hashtable.class, TreeMap.class, java.util.IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, TimeUnit.class, ConcurrentHashMap.class, loadClass("java.util.concurrent.ConcurrentSkipListMap"), loadClass("java.util.concurrent.ConcurrentSkipListSet"), AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), BitSet.class, Calendar.class, Date.class, Locale.class, UUID.class, Time.class, java.sql.Date.class, Timestamp.class, SimpleDateFormat.class, JSONObject.class}) {
            if (cls != null) {
                mappings.put(cls.getName(), cls);
            }
        }
        for (String str : new String[]{"java.awt.Rectangle", "java.awt.Point", "java.awt.Font", "java.awt.Color"}) {
            Class<?> loadClass = loadClass(str);
            if (loadClass == null) {
                break;
            }
            mappings.put(loadClass.getName(), loadClass);
        }
        for (String str2 : new String[]{"org.springframework.util.LinkedMultiValueMap", "org.springframework.util.LinkedCaseInsensitiveMap", "org.springframework.remoting.support.RemoteInvocation", "org.springframework.remoting.support.RemoteInvocationResult", "org.springframework.security.web.savedrequest.DefaultSavedRequest", "org.springframework.security.web.savedrequest.SavedCookie", "org.springframework.security.web.csrf.DefaultCsrfToken", "org.springframework.security.web.authentication.WebAuthenticationDetails", "org.springframework.security.core.context.SecurityContextImpl", "org.springframework.security.authentication.UsernamePasswordAuthenticationToken", "org.springframework.security.core.authority.SimpleGrantedAuthority", "org.springframework.security.core.userdetails.User"}) {
            Class<?> loadClass2 = loadClass(str2);
            if (loadClass2 != null) {
                mappings.put(loadClass2.getName(), loadClass2);
            } else {
                return;
            }
        }
    }

    public static void clearClassMapping() {
        mappings.clear();
        addBaseClassMappings();
    }

    public static Class<?> loadClass(String str) {
        return loadClass(str, null);
    }

    public static boolean isPath(Class<?> cls) {
        if (pathClass == null && !pathClass_error) {
            try {
                pathClass = Class.forName("java.nio.file.Path");
            } catch (Throwable th) {
                pathClass_error = true;
            }
        }
        if (pathClass != null) {
            return pathClass.isAssignableFrom(cls);
        }
        return false;
    }

    public static Class<?> getClassFromMapping(String str) {
        return mappings.get(str);
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        return loadClass(str, classLoader, true);
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader, boolean z) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Class<?> cls = mappings.get(str);
        if (cls == null) {
            if (str.charAt(0) == '[') {
                return Array.newInstance(loadClass(str.substring(1), classLoader), 0).getClass();
            }
            if (str.startsWith("L") && str.endsWith(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
                return loadClass(str.substring(1, str.length() - 1), classLoader);
            }
            if (classLoader != null) {
                try {
                    cls = classLoader.loadClass(str);
                    if (z) {
                        mappings.put(str, cls);
                        return cls;
                    }
                    return cls;
                } catch (Throwable th) {
                    th.printStackTrace();
                    cls = cls;
                }
            }
            try {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null && contextClassLoader != classLoader) {
                    cls = contextClassLoader.loadClass(str);
                    if (z) {
                        mappings.put(str, cls);
                        return cls;
                    }
                    return cls;
                }
            } catch (Throwable th2) {
            }
            try {
                cls = Class.forName(str);
                mappings.put(str, cls);
                return cls;
            } catch (Throwable th3) {
                return cls;
            }
        }
        return cls;
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy) {
        return buildBeanInfo(cls, map, propertyNamingStrategy, false);
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, boolean z) {
        int i;
        String str;
        String[] strArr;
        PropertyNamingStrategy propertyNamingStrategy2;
        List<FieldInfo> computeGetters;
        List<FieldInfo> list;
        String str2;
        String str3;
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        String str4 = null;
        if (jSONType != null) {
            String[] orders = jSONType.orders();
            String typeName = jSONType.typeName();
            String str5 = typeName.length() == 0 ? null : typeName;
            PropertyNamingStrategy naming = jSONType.naming();
            if (naming != null && naming != PropertyNamingStrategy.CamelCase) {
                propertyNamingStrategy = naming;
            }
            i = SerializerFeature.of(jSONType.serialzeFeatures());
            Class<? super Object> superclass = cls.getSuperclass();
            String str6 = null;
            while (superclass != null && superclass != Object.class) {
                JSONType jSONType2 = (JSONType) getAnnotation(superclass, JSONType.class);
                if (jSONType2 != null) {
                    str2 = jSONType2.typeKey();
                    if (str2.length() != 0) {
                        break;
                    }
                    superclass = superclass.getSuperclass();
                    str6 = str2;
                } else {
                    str2 = str6;
                    break;
                }
            }
            str2 = str6;
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            int i2 = 0;
            String str7 = str2;
            while (true) {
                if (i2 >= length) {
                    str3 = str7;
                    break;
                }
                JSONType jSONType3 = (JSONType) getAnnotation(interfaces[i2], JSONType.class);
                if (jSONType3 != null) {
                    str3 = jSONType3.typeKey();
                    if (str3.length() != 0) {
                        break;
                    }
                } else {
                    str3 = str7;
                }
                i2++;
                str7 = str3;
            }
            if (str3 != null && str3.length() == 0) {
                str3 = null;
            }
            str4 = str3;
            str = str5;
            strArr = orders;
            propertyNamingStrategy2 = propertyNamingStrategy;
        } else {
            i = 0;
            str = null;
            strArr = null;
            propertyNamingStrategy2 = propertyNamingStrategy;
        }
        HashMap hashMap = new HashMap();
        ParserConfig.parserAllFieldToCache(cls, hashMap);
        if (z) {
            computeGetters = computeGettersWithFieldBase(cls, map, false, propertyNamingStrategy2);
        } else {
            computeGetters = computeGetters(cls, jSONType, map, hashMap, false, propertyNamingStrategy2);
        }
        FieldInfo[] fieldInfoArr = new FieldInfo[computeGetters.size()];
        computeGetters.toArray(fieldInfoArr);
        if (strArr != null && strArr.length != 0) {
            if (z) {
                list = computeGettersWithFieldBase(cls, map, true, propertyNamingStrategy2);
            } else {
                list = computeGetters(cls, jSONType, map, hashMap, true, propertyNamingStrategy2);
            }
        } else {
            ArrayList arrayList = new ArrayList(computeGetters);
            Collections.sort(arrayList);
            list = arrayList;
        }
        FieldInfo[] fieldInfoArr2 = new FieldInfo[list.size()];
        list.toArray(fieldInfoArr2);
        if (Arrays.equals(fieldInfoArr2, fieldInfoArr)) {
            fieldInfoArr2 = fieldInfoArr;
        }
        return new SerializeBeanInfo(cls, jSONType, str, str4, i, fieldInfoArr, fieldInfoArr2);
    }

    public static List<FieldInfo> computeGettersWithFieldBase(Class<?> cls, Map<String, String> map, boolean z, PropertyNamingStrategy propertyNamingStrategy) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            computeFields(cls2, map, propertyNamingStrategy, linkedHashMap, cls2.getDeclaredFields());
        }
        return getFieldInfos(cls, z, linkedHashMap);
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map) {
        return computeGetters(cls, map, true);
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map, boolean z) {
        HashMap hashMap = new HashMap();
        ParserConfig.parserAllFieldToCache(cls, hashMap);
        return computeGetters(cls, (JSONType) getAnnotation(cls, JSONType.class), map, hashMap, z, PropertyNamingStrategy.CamelCase);
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<FieldInfo> computeGetters(Class<?> cls, JSONType jSONType, Map<String, String> map, Map<String, Field> map2, boolean z, PropertyNamingStrategy propertyNamingStrategy) {
        short[] sArr;
        String[] strArr;
        Annotation[][] annotationArr;
        Constructor<?>[] constructorArr;
        JSONField jSONField;
        String substring;
        JSONField jSONField2;
        short[] sArr2;
        String[] strArr2;
        Annotation[][] annotationArr2;
        Constructor<?>[] constructorArr2;
        String str;
        String str2;
        String propertyNameByCompatibleFieldName;
        JSONField jSONField3;
        Boolean bool;
        String str3;
        char charAt;
        int i;
        Field fieldFromCache;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean isKotlin = isKotlin(cls);
        Constructor<?>[] constructorArr3 = null;
        String[] strArr3 = null;
        short[] sArr3 = null;
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i2 = 0;
        Annotation[][] annotationArr3 = null;
        while (i2 < length) {
            Method method = methods[i2];
            String name = method.getName();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            String str4 = null;
            if (Modifier.isStatic(method.getModifiers())) {
                sArr2 = sArr3;
                strArr2 = strArr3;
                annotationArr2 = annotationArr3;
                constructorArr2 = constructorArr3;
            } else if (method.getReturnType().equals(Void.TYPE)) {
                sArr2 = sArr3;
                strArr2 = strArr3;
                annotationArr2 = annotationArr3;
                constructorArr2 = constructorArr3;
            } else if (method.getParameterTypes().length != 0) {
                sArr2 = sArr3;
                strArr2 = strArr3;
                annotationArr2 = annotationArr3;
                constructorArr2 = constructorArr3;
            } else if (method.getReturnType() == ClassLoader.class) {
                sArr2 = sArr3;
                strArr2 = strArr3;
                annotationArr2 = annotationArr3;
                constructorArr2 = constructorArr3;
            } else if (name.equals("getMetaClass") && method.getReturnType().getName().equals("groovy.lang.MetaClass")) {
                sArr2 = sArr3;
                strArr2 = strArr3;
                annotationArr2 = annotationArr3;
                constructorArr2 = constructorArr3;
            } else if (name.equals("getSuppressed") && method.getDeclaringClass() == Throwable.class) {
                sArr2 = sArr3;
                strArr2 = strArr3;
                annotationArr2 = annotationArr3;
                constructorArr2 = constructorArr3;
            } else if (isKotlin && isKotlinIgnore(cls, name)) {
                sArr2 = sArr3;
                strArr2 = strArr3;
                annotationArr2 = annotationArr3;
                constructorArr2 = constructorArr3;
            } else {
                Boolean bool2 = false;
                JSONField jSONField4 = (JSONField) method.getAnnotation(JSONField.class);
                JSONField superMethodAnnotation = jSONField4 == null ? getSuperMethodAnnotation(cls, method) : jSONField4;
                if (superMethodAnnotation == null && isKotlin) {
                    if (constructorArr3 == null) {
                        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
                        Constructor koltinConstructor = getKoltinConstructor(declaredConstructors);
                        if (koltinConstructor != null) {
                            Annotation[][] parameterAnnotations = koltinConstructor.getParameterAnnotations();
                            String[] koltinConstructorParameters = getKoltinConstructorParameters(cls);
                            if (koltinConstructorParameters != null) {
                                strArr3 = new String[koltinConstructorParameters.length];
                                System.arraycopy(koltinConstructorParameters, 0, strArr3, 0, koltinConstructorParameters.length);
                                Arrays.sort(strArr3);
                                sArr3 = new short[koltinConstructorParameters.length];
                                for (short s = 0; s < koltinConstructorParameters.length; s = (short) (s + 1)) {
                                    sArr3[Arrays.binarySearch(strArr3, koltinConstructorParameters[s])] = s;
                                }
                                annotationArr3 = parameterAnnotations;
                                constructorArr3 = declaredConstructors;
                            } else {
                                strArr3 = koltinConstructorParameters;
                                annotationArr3 = parameterAnnotations;
                                constructorArr3 = declaredConstructors;
                            }
                        } else {
                            constructorArr3 = declaredConstructors;
                        }
                    }
                    if (strArr3 != null && sArr3 != null && name.startsWith("get")) {
                        String decapitalize = decapitalize(name.substring(3));
                        int binarySearch = Arrays.binarySearch(strArr3, decapitalize);
                        if (binarySearch < 0) {
                            i = 0;
                            while (i < strArr3.length) {
                                if (decapitalize.equalsIgnoreCase(strArr3[i])) {
                                    break;
                                }
                                i++;
                            }
                        }
                        i = binarySearch;
                        if (i >= 0) {
                            Annotation[] annotationArr4 = annotationArr3[sArr3[i]];
                            if (annotationArr4 != null) {
                                int length2 = annotationArr4.length;
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6;
                                    if (i7 >= length2) {
                                        break;
                                    }
                                    Annotation annotation = annotationArr4[i7];
                                    if (!(annotation instanceof JSONField)) {
                                        i6 = i7 + 1;
                                    } else {
                                        superMethodAnnotation = (JSONField) annotation;
                                        break;
                                    }
                                }
                            }
                            if (superMethodAnnotation == null && (fieldFromCache = ParserConfig.getFieldFromCache(decapitalize, map2)) != null) {
                                sArr = sArr3;
                                strArr = strArr3;
                                annotationArr = annotationArr3;
                                constructorArr = constructorArr3;
                                jSONField = (JSONField) fieldFromCache.getAnnotation(JSONField.class);
                                if (jSONField != null) {
                                    if (jSONField.serialize()) {
                                        i3 = jSONField.ordinal();
                                        i4 = SerializerFeature.of(jSONField.serialzeFeatures());
                                        i5 = Feature.of(jSONField.parseFeatures());
                                        if (jSONField.name().length() != 0) {
                                            String name2 = jSONField.name();
                                            if (map != null) {
                                                String str5 = map.get(name2);
                                                if (str5 == null) {
                                                    sArr2 = sArr;
                                                    strArr2 = strArr;
                                                    annotationArr2 = annotationArr;
                                                    constructorArr2 = constructorArr;
                                                } else {
                                                    name2 = str5;
                                                }
                                            }
                                            linkedHashMap.put(name2, new FieldInfo(name2, method, null, cls, null, i3, i4, i5, jSONField, null, null));
                                            sArr2 = sArr;
                                            strArr2 = strArr;
                                            annotationArr2 = annotationArr;
                                            constructorArr2 = constructorArr;
                                        } else if (jSONField.label().length() == 0) {
                                            bool2 = true;
                                        } else {
                                            str4 = jSONField.label();
                                            bool2 = true;
                                        }
                                    } else {
                                        sArr2 = sArr;
                                        strArr2 = strArr;
                                        annotationArr2 = annotationArr;
                                        constructorArr2 = constructorArr;
                                    }
                                }
                                if (name.startsWith("get")) {
                                    if (name.length() < 4) {
                                        sArr2 = sArr;
                                        strArr2 = strArr;
                                        annotationArr2 = annotationArr;
                                        constructorArr2 = constructorArr;
                                    } else if (name.equals("getClass")) {
                                        sArr2 = sArr;
                                        strArr2 = strArr;
                                        annotationArr2 = annotationArr;
                                        constructorArr2 = constructorArr;
                                    } else if (name.equals("getDeclaringClass") && cls.isEnum()) {
                                        sArr2 = sArr;
                                        strArr2 = strArr;
                                        annotationArr2 = annotationArr;
                                        constructorArr2 = constructorArr;
                                    } else {
                                        char charAt2 = name.charAt(3);
                                        if (Character.isUpperCase(charAt2) || charAt2 > 512) {
                                            if (compatibleWithJavaBean) {
                                                str2 = decapitalize(name.substring(3));
                                            } else {
                                                str2 = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                                            }
                                            propertyNameByCompatibleFieldName = getPropertyNameByCompatibleFieldName(map2, name, str2, 3);
                                        } else if (charAt2 == '_') {
                                            propertyNameByCompatibleFieldName = name.substring(4);
                                        } else if (charAt2 == 'f') {
                                            propertyNameByCompatibleFieldName = name.substring(3);
                                        } else {
                                            if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                                                propertyNameByCompatibleFieldName = decapitalize(name.substring(3));
                                            }
                                            sArr2 = sArr;
                                            strArr2 = strArr;
                                            annotationArr2 = annotationArr;
                                            constructorArr2 = constructorArr;
                                        }
                                        if (isJSONTypeIgnore(cls, propertyNameByCompatibleFieldName)) {
                                            sArr2 = sArr;
                                            strArr2 = strArr;
                                            annotationArr2 = annotationArr;
                                            constructorArr2 = constructorArr;
                                        } else {
                                            Field fieldFromCache2 = ParserConfig.getFieldFromCache(propertyNameByCompatibleFieldName, map2);
                                            if (fieldFromCache2 == null && propertyNameByCompatibleFieldName.length() > 1 && (charAt = propertyNameByCompatibleFieldName.charAt(1)) >= 'A' && charAt <= 'Z') {
                                                fieldFromCache2 = ParserConfig.getFieldFromCache(decapitalize(name.substring(3)), map2);
                                            }
                                            if (fieldFromCache2 == null) {
                                                jSONField3 = null;
                                                String str6 = propertyNameByCompatibleFieldName;
                                                bool = bool2;
                                                str3 = str6;
                                            } else {
                                                JSONField jSONField5 = (JSONField) fieldFromCache2.getAnnotation(JSONField.class);
                                                if (jSONField5 == null) {
                                                    jSONField3 = jSONField5;
                                                    String str7 = propertyNameByCompatibleFieldName;
                                                    bool = bool2;
                                                    str3 = str7;
                                                } else if (jSONField5.serialize()) {
                                                    i3 = jSONField5.ordinal();
                                                    i4 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                                    i5 = Feature.of(jSONField5.parseFeatures());
                                                    if (jSONField5.name().length() != 0) {
                                                        str3 = jSONField5.name();
                                                        if (map != null && (str3 = map.get(str3)) == null) {
                                                            sArr2 = sArr;
                                                            strArr2 = strArr;
                                                            annotationArr2 = annotationArr;
                                                            constructorArr2 = constructorArr;
                                                        }
                                                    } else {
                                                        str3 = propertyNameByCompatibleFieldName;
                                                    }
                                                    if (jSONField5.label().length() == 0) {
                                                        jSONField3 = jSONField5;
                                                        bool = true;
                                                    } else {
                                                        str4 = jSONField5.label();
                                                        jSONField3 = jSONField5;
                                                        bool = true;
                                                    }
                                                } else {
                                                    sArr2 = sArr;
                                                    strArr2 = strArr;
                                                    annotationArr2 = annotationArr;
                                                    constructorArr2 = constructorArr;
                                                }
                                            }
                                            if (map != null) {
                                                String str8 = map.get(str3);
                                                if (str8 == null) {
                                                    sArr2 = sArr;
                                                    strArr2 = strArr;
                                                    annotationArr2 = annotationArr;
                                                    constructorArr2 = constructorArr;
                                                } else {
                                                    str3 = str8;
                                                }
                                            }
                                            if (propertyNamingStrategy != null && !bool.booleanValue()) {
                                                str3 = propertyNamingStrategy.translate(str3);
                                            }
                                            linkedHashMap.put(str3, new FieldInfo(str3, method, fieldFromCache2, cls, null, i3, i4, i5, jSONField, jSONField3, str4));
                                        }
                                    }
                                }
                                if (name.startsWith("is")) {
                                    if (name.length() < 3) {
                                        sArr2 = sArr;
                                        strArr2 = strArr;
                                        annotationArr2 = annotationArr;
                                        constructorArr2 = constructorArr;
                                    } else if (method.getReturnType() == Boolean.TYPE || method.getReturnType() == Boolean.class) {
                                        char charAt3 = name.charAt(2);
                                        if (Character.isUpperCase(charAt3)) {
                                            if (compatibleWithJavaBean) {
                                                str = decapitalize(name.substring(2));
                                            } else {
                                                str = Character.toLowerCase(name.charAt(2)) + name.substring(3);
                                            }
                                            substring = getPropertyNameByCompatibleFieldName(map2, name, str, 2);
                                        } else if (charAt3 == '_') {
                                            substring = name.substring(3);
                                        } else if (charAt3 == 'f') {
                                            substring = name.substring(2);
                                        }
                                        if (isJSONTypeIgnore(cls, substring)) {
                                            sArr2 = sArr;
                                            strArr2 = strArr;
                                            annotationArr2 = annotationArr;
                                            constructorArr2 = constructorArr;
                                        } else {
                                            Field fieldFromCache3 = ParserConfig.getFieldFromCache(substring, map2);
                                            if (fieldFromCache3 == null) {
                                                fieldFromCache3 = ParserConfig.getFieldFromCache(name, map2);
                                            }
                                            if (fieldFromCache3 == null) {
                                                jSONField2 = null;
                                            } else {
                                                JSONField jSONField6 = (JSONField) fieldFromCache3.getAnnotation(JSONField.class);
                                                if (jSONField6 != null) {
                                                    if (jSONField6.serialize()) {
                                                        i3 = jSONField6.ordinal();
                                                        i4 = SerializerFeature.of(jSONField6.serialzeFeatures());
                                                        i5 = Feature.of(jSONField6.parseFeatures());
                                                        if (jSONField6.name().length() != 0) {
                                                            substring = jSONField6.name();
                                                            if (map != null && (substring = map.get(substring)) == null) {
                                                                sArr2 = sArr;
                                                                strArr2 = strArr;
                                                                annotationArr2 = annotationArr;
                                                                constructorArr2 = constructorArr;
                                                            }
                                                        }
                                                        if (jSONField6.label().length() != 0) {
                                                            str4 = jSONField6.label();
                                                            jSONField2 = jSONField6;
                                                        }
                                                    } else {
                                                        sArr2 = sArr;
                                                        strArr2 = strArr;
                                                        annotationArr2 = annotationArr;
                                                        constructorArr2 = constructorArr;
                                                    }
                                                }
                                                jSONField2 = jSONField6;
                                            }
                                            if (map != null) {
                                                String str9 = map.get(substring);
                                                if (str9 == null) {
                                                    sArr2 = sArr;
                                                    strArr2 = strArr;
                                                    annotationArr2 = annotationArr;
                                                    constructorArr2 = constructorArr;
                                                } else {
                                                    substring = str9;
                                                }
                                            }
                                            if (propertyNamingStrategy != null) {
                                                substring = propertyNamingStrategy.translate(substring);
                                            }
                                            if (linkedHashMap.containsKey(substring)) {
                                                sArr2 = sArr;
                                                strArr2 = strArr;
                                                annotationArr2 = annotationArr;
                                                constructorArr2 = constructorArr;
                                            } else {
                                                linkedHashMap.put(substring, new FieldInfo(substring, method, fieldFromCache3, cls, null, i3, i4, i5, jSONField, jSONField2, str4));
                                            }
                                        }
                                    } else {
                                        sArr2 = sArr;
                                        strArr2 = strArr;
                                        annotationArr2 = annotationArr;
                                        constructorArr2 = constructorArr;
                                    }
                                }
                                sArr2 = sArr;
                                strArr2 = strArr;
                                annotationArr2 = annotationArr;
                                constructorArr2 = constructorArr;
                            }
                        }
                    }
                }
                sArr = sArr3;
                strArr = strArr3;
                annotationArr = annotationArr3;
                constructorArr = constructorArr3;
                jSONField = superMethodAnnotation;
                if (jSONField != null) {
                }
                if (name.startsWith("get")) {
                }
                if (name.startsWith("is")) {
                }
                sArr2 = sArr;
                strArr2 = strArr;
                annotationArr2 = annotationArr;
                constructorArr2 = constructorArr;
            }
            i2++;
            annotationArr3 = annotationArr2;
            constructorArr3 = constructorArr2;
            sArr3 = sArr2;
            strArr3 = strArr2;
        }
        computeFields(cls, map, propertyNamingStrategy, linkedHashMap, cls.getFields());
        return getFieldInfos(cls, z, linkedHashMap);
    }

    private static List<FieldInfo> getFieldInfos(Class<?> cls, boolean z, Map<String, FieldInfo> map) {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType == null) {
            strArr = null;
        } else {
            strArr = jSONType.orders();
        }
        if (strArr != null && strArr.length > 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(arrayList.size());
            for (FieldInfo fieldInfo : map.values()) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            for (String str : strArr) {
                FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    arrayList.add(fieldInfo2);
                    linkedHashMap.remove(str);
                }
            }
            for (FieldInfo fieldInfo3 : linkedHashMap.values()) {
                arrayList.add(fieldInfo3);
            }
        } else {
            for (FieldInfo fieldInfo4 : map.values()) {
                arrayList.add(fieldInfo4);
            }
            if (z) {
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0013 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void computeFields(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, Map<String, FieldInfo> map2, Field[] fieldArr) {
        String str;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                JSONField jSONField = (JSONField) field.getAnnotation(JSONField.class);
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                String name = field.getName();
                String str2 = null;
                if (jSONField != null) {
                    if (jSONField.serialize()) {
                        i = jSONField.ordinal();
                        i2 = SerializerFeature.of(jSONField.serialzeFeatures());
                        i3 = Feature.of(jSONField.parseFeatures());
                        if (jSONField.name().length() != 0) {
                            name = jSONField.name();
                        }
                        if (jSONField.label().length() != 0) {
                            str2 = jSONField.label();
                            str = name;
                            if (map != null) {
                                String str3 = map.get(str);
                                if (str3 != null) {
                                    str = str3;
                                }
                            }
                            if (propertyNamingStrategy != null) {
                                str = propertyNamingStrategy.translate(str);
                            }
                            if (map2.containsKey(str)) {
                                map2.put(str, new FieldInfo(str, null, field, cls, null, i, i2, i3, null, jSONField, str2));
                            }
                        }
                    }
                }
                str = name;
                if (map != null) {
                }
                if (propertyNamingStrategy != null) {
                }
                if (map2.containsKey(str)) {
                }
            }
        }
    }

    private static String getPropertyNameByCompatibleFieldName(Map<String, Field> map, String str, String str2, int i) {
        if (compatibleWithFieldName && !map.containsKey(str2)) {
            String substring = str.substring(i);
            return map.containsKey(substring) ? substring : str2;
        }
        return str2;
    }

    public static JSONField getSuperMethodAnnotation(Class<?> cls, Method method) {
        Method[] methods;
        boolean z;
        JSONField jSONField;
        Method[] methods2;
        boolean z2;
        JSONField jSONField2;
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> cls2 : interfaces) {
                for (Method method2 : cls2.getMethods()) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i = 0;
                        while (true) {
                            if (i >= parameterTypes.length) {
                                z2 = true;
                                break;
                            } else if (parameterTypes2[i].equals(parameterTypes[i])) {
                                i++;
                            } else {
                                z2 = false;
                                break;
                            }
                        }
                        if (z2 && (jSONField2 = (JSONField) method2.getAnnotation(JSONField.class)) != null) {
                            return jSONField2;
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= parameterTypes3.length) {
                            z = true;
                            break;
                        } else if (parameterTypes4[i2].equals(parameterTypes3[i2])) {
                            i2++;
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z && (jSONField = (JSONField) method3.getAnnotation(JSONField.class)) != null) {
                        return jSONField;
                    }
                }
            }
        }
        return null;
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, String str) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType != null) {
            String[] includes = jSONType.includes();
            if (includes.length > 0) {
                for (String str2 : includes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            String[] ignores = jSONType.ignores();
            for (String str3 : ignores) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        return (cls.getSuperclass() == Object.class || cls.getSuperclass() == null || !isJSONTypeIgnore(cls.getSuperclass(), str)) ? false : true;
    }

    public static boolean isGenericParamType(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class) || (genericSuperclass = ((Class) type).getGenericSuperclass()) == Object.class) {
            return false;
        }
        return isGenericParamType(genericSuperclass);
    }

    public static Type getGenericParamType(Type type) {
        if (!(type instanceof ParameterizedType) && (type instanceof Class)) {
            return getGenericParamType(((Class) type).getGenericSuperclass());
        }
        return type;
    }

    public static Type unwrapOptional(Type type) {
        if (!optionalClassInited) {
            try {
                optionalClass = Class.forName("java.util.Optional");
            } catch (Exception e) {
            } finally {
                optionalClassInited = true;
            }
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType.getRawType() == optionalClass) {
                return parameterizedType.getActualTypeArguments()[0];
            }
            return type;
        }
        return type;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            return (Class) ((TypeVariable) type).getBounds()[0];
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getClass(upperBounds[0]);
            }
        }
        return Object.class;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        char charAt;
        char charAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (!str.equals(name)) {
                if (str.length() > 2 && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z' && (charAt2 = str.charAt(1)) >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                    return field;
                }
            } else {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && superclass != Object.class) {
            return getField(superclass, str, superclass.getDeclaredFields());
        }
        return null;
    }

    public static int getSerializeFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return SerializerFeature.of(jSONType.serialzeFeatures());
    }

    public static int getParserFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return Feature.of(jSONType.parseFeatures());
    }

    public static String decapitalize(String str) {
        if (str != null && str.length() != 0) {
            if (str.length() <= 1 || !Character.isUpperCase(str.charAt(1)) || !Character.isUpperCase(str.charAt(0))) {
                char[] charArray = str.toCharArray();
                charArray[0] = Character.toLowerCase(charArray[0]);
                return new String(charArray);
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setAccessible(AccessibleObject accessibleObject) {
        if (setAccessibleEnable && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException e) {
                setAccessibleEnable = false;
            }
        }
    }

    public static Type getCollectionItemType(Type type) {
        Type type2 = null;
        if (type instanceof ParameterizedType) {
            Type type3 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type3 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type3).getUpperBounds();
                if (upperBounds.length == 1) {
                    type3 = upperBounds[0];
                }
            }
            type2 = type3;
        } else if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.getName().startsWith("java.")) {
                type2 = getCollectionItemType(cls.getGenericSuperclass());
            }
        }
        if (type2 == null) {
            return Object.class;
        }
        return type2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Class<?> getCollectionItemClass(Type type) {
        Type type2;
        if (type instanceof ParameterizedType) {
            Type type3 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type3 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type3).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                    if (!(type2 instanceof Class)) {
                        Class<?> cls = (Class) type2;
                        if (Modifier.isPublic(cls.getModifiers())) {
                            return cls;
                        }
                        throw new JSONException("can not create ASMParser");
                    }
                    throw new JSONException("can not create ASMParser");
                }
            }
            type2 = type3;
            if (!(type2 instanceof Class)) {
            }
        } else {
            return Object.class;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x011f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Class] */
    public static Type checkPrimitiveArray(GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        String str = "[";
        while (genericComponentType instanceof GenericArrayType) {
            str = str + str;
            genericComponentType = ((GenericArrayType) genericComponentType).getGenericComponentType();
        }
        if (genericComponentType instanceof Class) {
            Class cls = (Class) genericComponentType;
            if (cls.isPrimitive()) {
                try {
                    if (cls == Boolean.TYPE) {
                        genericArrayType = Class.forName(str + "Z");
                    } else if (cls == Character.TYPE) {
                        genericArrayType = Class.forName(str + "C");
                    } else if (cls == Byte.TYPE) {
                        genericArrayType = Class.forName(str + "B");
                    } else if (cls == Short.TYPE) {
                        genericArrayType = Class.forName(str + ExifInterface.LATITUDE_SOUTH);
                    } else if (cls == Integer.TYPE) {
                        genericArrayType = Class.forName(str + "I");
                    } else if (cls == Long.TYPE) {
                        genericArrayType = Class.forName(str + "J");
                    } else if (cls == Float.TYPE) {
                        genericArrayType = Class.forName(str + "F");
                    } else {
                        genericArrayType = genericArrayType;
                        if (cls == Double.TYPE) {
                            genericArrayType = Class.forName(str + "D");
                        }
                    }
                } catch (ClassNotFoundException e) {
                }
            }
        }
        return genericArrayType;
    }

    public static Collection createCollection(Type type) {
        Type type2;
        Class<?> rawClass = getRawClass(type);
        if (rawClass == AbstractCollection.class || rawClass == Collection.class) {
            return new ArrayList();
        }
        if (rawClass.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (rawClass.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (rawClass.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (rawClass.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (rawClass.isAssignableFrom(EnumSet.class)) {
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                type2 = Object.class;
            }
            return EnumSet.noneOf(type2);
        }
        try {
            return (Collection) rawClass.newInstance();
        } catch (Exception e) {
            throw new JSONException("create instance error, class " + rawClass.getName());
        }
    }

    public static Class<?> getRawClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getRawClass(((ParameterizedType) type).getRawType());
        }
        throw new JSONException("TODO");
    }

    public static boolean isProxy(Class<?> cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            String name = cls2.getName();
            if (name.equals("net.sf.cglib.proxy.Factory") || name.equals("org.springframework.cglib.proxy.Factory") || name.equals("javassist.util.proxy.ProxyObject") || name.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject")) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends java.lang.annotation.Annotation> */
    public static boolean isTransient(Method method) {
        if (method == null) {
            return false;
        }
        if (!transientClassInited) {
            try {
                transientClass = Class.forName("java.beans.Transient");
            } catch (Exception e) {
            } finally {
                transientClassInited = true;
            }
        }
        if (transientClass != null) {
            return method.getAnnotation(transientClass) != null;
        }
        return false;
    }

    /* JADX DEBUG: Type inference failed for r1v6. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends java.lang.annotation.Annotation> */
    public static boolean isAnnotationPresentOneToMany(Method method) {
        if (method == null) {
            return false;
        }
        if (class_OneToMany == null && !class_OneToMany_error) {
            try {
                class_OneToMany = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable th) {
                class_OneToMany_error = true;
            }
        }
        if (class_OneToMany != null) {
            return method.isAnnotationPresent(class_OneToMany);
        }
        return false;
    }

    /* JADX DEBUG: Type inference failed for r2v9. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends java.lang.annotation.Annotation> */
    public static boolean isAnnotationPresentManyToMany(Method method) {
        if (method == null) {
            return false;
        }
        if (class_ManyToMany == null && !class_ManyToMany_error) {
            try {
                class_ManyToMany = Class.forName("javax.persistence.ManyToMany");
            } catch (Throwable th) {
                class_ManyToMany_error = true;
            }
        }
        if (class_ManyToMany != null) {
            return method.isAnnotationPresent(class_OneToMany) || method.isAnnotationPresent(class_ManyToMany);
        }
        return false;
    }

    public static boolean isHibernateInitialized(Object obj) {
        if (obj == null) {
            return false;
        }
        if (method_HibernateIsInitialized == null && !method_HibernateIsInitialized_error) {
            try {
                method_HibernateIsInitialized = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", Object.class);
            } catch (Throwable th) {
                method_HibernateIsInitialized_error = true;
            }
        }
        if (method_HibernateIsInitialized != null) {
            try {
                return ((Boolean) method_HibernateIsInitialized.invoke(null, obj)).booleanValue();
            } catch (Throwable th2) {
            }
        }
        return true;
    }

    public static long fnv1a_64_lower(String str) {
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != '_' && charAt != '-') {
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + ' ');
                }
                j = (j ^ charAt) * 1099511628211L;
            }
        }
        return j;
    }

    public static long fnv1a_64(String str) {
        long j = -3750763034362895579L;
        for (int i = 0; i < str.length(); i++) {
            j = (j ^ str.charAt(i)) * 1099511628211L;
        }
        return j;
    }

    public static boolean isKotlin(Class cls) {
        if (kotlin_metadata == null && !kotlin_metadata_error) {
            try {
                kotlin_metadata = Class.forName("kotlin.h");
            } catch (Throwable th) {
                kotlin_metadata_error = true;
            }
        }
        if (kotlin_metadata == null) {
            return false;
        }
        return cls.isAnnotationPresent(kotlin_metadata);
    }

    public static Constructor getKoltinConstructor(Constructor[] constructorArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("kotlin.jvm.internal.DefaultConstructorMarker")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length)) {
                constructor = constructor2;
            }
        }
        return constructor;
    }

    public static String[] getKoltinConstructorParameters(Class cls) {
        int i = 0;
        if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
            try {
                kotlin_kclass_constructor = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getConstructor(Class.class);
            } catch (Throwable th) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kclass_constructor == null) {
            return null;
        }
        if (kotlin_kclass_getConstructors == null && !kotlin_class_klass_error) {
            try {
                kotlin_kclass_getConstructors = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getMethod("getConstructors", new Class[0]);
            } catch (Throwable th2) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kfunction_getParameters == null && !kotlin_class_klass_error) {
            try {
                kotlin_kfunction_getParameters = Class.forName("kotlin.reflect.e").getMethod("getParameters", new Class[0]);
            } catch (Throwable th3) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kparameter_getName == null && !kotlin_class_klass_error) {
            try {
                kotlin_kparameter_getName = Class.forName("kotlin.reflect.KParameter").getMethod("getName", new Class[0]);
            } catch (Throwable th4) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_error) {
            return null;
        }
        try {
            Iterator it = ((Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(cls), new Object[0])).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                Object obj2 = (obj == null || ((List) kotlin_kfunction_getParameters.invoke(next, new Object[0])).size() != 0) ? next : obj;
                it.hasNext();
                obj = obj2;
            }
            List list = (List) kotlin_kfunction_getParameters.invoke(obj, new Object[0]);
            String[] strArr = new String[list.size()];
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    return strArr;
                }
                strArr[i2] = (String) kotlin_kparameter_getName.invoke(list.get(i2), new Object[0]);
                i = i2 + 1;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            kotlin_error = true;
            return null;
        }
    }

    private static boolean isKotlinIgnore(Class cls, String str) {
        String[] strArr;
        if (kotlinIgnores == null && !kotlinIgnores_error) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(Class.forName("kotlin.b.c"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.b.h"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.b.k"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.b.e"), new String[]{"getEndInclusive", "isEmpty"});
                hashMap.put(Class.forName("kotlin.b.d"), new String[]{"getEndInclusive", "isEmpty"});
                kotlinIgnores = hashMap;
            } catch (Throwable th) {
                kotlinIgnores_error = true;
            }
        }
        if (kotlinIgnores == null || (strArr = kotlinIgnores.get(cls)) == null) {
            return false;
        }
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static <A extends Annotation> A getAnnotation(Class<?> cls, Class<A> cls2) {
        A a = (A) cls.getAnnotation(cls2);
        if (a == null) {
            if (cls.getAnnotations().length > 0) {
                for (Annotation annotation : cls.getAnnotations()) {
                    A a2 = (A) annotation.annotationType().getAnnotation(cls2);
                    if (a2 != null) {
                        return a2;
                    }
                }
            }
            return null;
        }
        return a;
    }
}
