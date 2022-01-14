package com.alibaba.fastjson.util;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.PushClientConstants;
import java.io.InputStream;
import java.io.Reader;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class TypeUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern NUMBER_WITH_TRAILING_ZEROS_PATTERN;
    public static volatile boolean classXmlAccessorType_error;
    public static volatile Class class_Clob;
    public static volatile boolean class_Clob_error;
    public static Class<? extends Annotation> class_JacksonCreator;
    public static boolean class_JacksonCreator_error;
    public static Class<? extends Annotation> class_ManyToMany;
    public static boolean class_ManyToMany_error;
    public static Class<? extends Annotation> class_OneToMany;
    public static boolean class_OneToMany_error;
    public static volatile Class class_XmlAccessType;
    public static volatile Class class_XmlAccessorType;
    public static Class class_deque;
    public static boolean compatibleWithFieldName;
    public static boolean compatibleWithJavaBean;
    public static volatile Field field_XmlAccessType_FIELD;
    public static volatile Object field_XmlAccessType_FIELD_VALUE;
    public static volatile Map<Class, String[]> kotlinIgnores;
    public static volatile boolean kotlinIgnores_error;
    public static volatile boolean kotlin_class_klass_error;
    public static volatile boolean kotlin_error;
    public static volatile Constructor kotlin_kclass_constructor;
    public static volatile Method kotlin_kclass_getConstructors;
    public static volatile Method kotlin_kfunction_getParameters;
    public static volatile Method kotlin_kparameter_getName;
    public static volatile Class kotlin_metadata;
    public static volatile boolean kotlin_metadata_error;
    public static ConcurrentMap<String, Class<?>> mappings;
    public static Method method_HibernateIsInitialized;
    public static boolean method_HibernateIsInitialized_error;
    public static volatile Method method_XmlAccessorType_value;
    public static Class<?> optionalClass;
    public static boolean optionalClassInited;
    public static Method oracleDateMethod;
    public static boolean oracleDateMethodInited;
    public static Method oracleTimestampMethod;
    public static boolean oracleTimestampMethodInited;
    public static Class<?> pathClass;
    public static boolean pathClass_error;
    public static boolean setAccessibleEnable;
    public static Class<? extends Annotation> transientClass;
    public static boolean transientClassInited;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1794557299, "Lcom/alibaba/fastjson/util/TypeUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1794557299, "Lcom/alibaba/fastjson/util/TypeUtils;");
                return;
            }
        }
        NUMBER_WITH_TRAILING_ZEROS_PATTERN = Pattern.compile("\\.0*$");
        compatibleWithJavaBean = false;
        compatibleWithFieldName = false;
        setAccessibleEnable = true;
        oracleTimestampMethodInited = false;
        oracleDateMethodInited = false;
        optionalClassInited = false;
        transientClassInited = false;
        class_OneToMany = null;
        class_OneToMany_error = false;
        class_ManyToMany = null;
        class_ManyToMany_error = false;
        method_HibernateIsInitialized = null;
        method_HibernateIsInitialized_error = false;
        mappings = new ConcurrentHashMap(256, 0.75f, 1);
        pathClass_error = false;
        class_JacksonCreator = null;
        class_JacksonCreator_error = false;
        class_Clob = null;
        class_Clob_error = false;
        class_XmlAccessType = null;
        class_XmlAccessorType = null;
        classXmlAccessorType_error = false;
        method_XmlAccessorType_value = null;
        field_XmlAccessType_FIELD = null;
        field_XmlAccessType_FIELD_VALUE = null;
        class_deque = null;
        try {
            compatibleWithJavaBean = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHJAVABEAN));
            compatibleWithFieldName = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHFIELDNAME));
        } catch (Throwable unused) {
        }
        try {
            class_deque = Class.forName("java.util.Deque");
        } catch (Throwable unused2) {
        }
        addBaseClassMappings();
    }

    public TypeUtils() {
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

    public static void addBaseClassMappings() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            mappings.put("byte", Byte.TYPE);
            mappings.put("short", Short.TYPE);
            mappings.put("int", Integer.TYPE);
            mappings.put("long", Long.TYPE);
            mappings.put(ShaderParams.VALUE_TYPE_FLOAT, Float.TYPE);
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
            Class<?>[] clsArr = {Object.class, Cloneable.class, loadClass("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, Hashtable.class, TreeMap.class, java.util.IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, ArrayList.class, TimeUnit.class, ConcurrentHashMap.class, AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Number.class, String.class, BigDecimal.class, BigInteger.class, BitSet.class, Calendar.class, Date.class, Locale.class, UUID.class, Time.class, java.sql.Date.class, Timestamp.class, SimpleDateFormat.class, JSONObject.class, JSONPObject.class, JSONArray.class};
            for (int i2 = 0; i2 < 71; i2++) {
                Class<?> cls = clsArr[i2];
                if (cls != null) {
                    mappings.put(cls.getName(), cls);
                }
            }
        }
    }

    public static void addMapping(String str, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, cls) == null) {
            mappings.put(str, cls);
        }
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, map, propertyNamingStrategy)) == null) ? buildBeanInfo(cls, map, propertyNamingStrategy, false) : (SerializeBeanInfo) invokeLLL.objValue;
    }

    public static byte byteValue(BigDecimal bigDecimal) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bigDecimal)) == null) {
            if (bigDecimal == null) {
                return (byte) 0;
            }
            int scale = bigDecimal.scale();
            if (scale >= -100 && scale <= 100) {
                return bigDecimal.byteValue();
            }
            return bigDecimal.byteValueExact();
        }
        return invokeL.byteValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        InterceptResult invokeLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, obj, cls, parserConfig)) == null) {
            int i2 = 0;
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
            } else if (cls != null) {
                if (cls == obj.getClass()) {
                    return obj;
                }
                if (obj instanceof Map) {
                    if (cls == Map.class) {
                        return obj;
                    }
                    Map map = (Map) obj;
                    return (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) ? (T) castToJavaBean(map, cls, parserConfig) : obj;
                }
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        T t2 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object obj2 : collection) {
                            Array.set(t2, i2, cast(obj2, (Class<Object>) cls.getComponentType(), parserConfig));
                            i2++;
                        }
                        return t2;
                    } else if (cls == byte[].class) {
                        return (T) castToBytes(obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return obj;
                }
                if (cls != Boolean.TYPE && cls != Boolean.class) {
                    if (cls != Byte.TYPE && cls != Byte.class) {
                        if (cls != Character.TYPE && cls != Character.class) {
                            if (cls != Short.TYPE && cls != Short.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Float.TYPE && cls != Float.class) {
                                            if (cls != Double.TYPE && cls != Double.class) {
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
                                                if (cls == Time.class) {
                                                    return (T) castToSqlTime(obj);
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
                                                        t = (T) Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                                                    } else {
                                                        try {
                                                            t = (T) ((Calendar) cls.newInstance());
                                                        } catch (Exception e2) {
                                                            throw new JSONException("can not cast to : " + cls.getName(), e2);
                                                        }
                                                    }
                                                    ((Calendar) t).setTime(castToDate);
                                                    return t;
                                                }
                                                String name = cls.getName();
                                                if (name.equals("javax.xml.datatype.XMLGregorianCalendar")) {
                                                    Date castToDate2 = castToDate(obj);
                                                    Calendar calendar = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                                                    calendar.setTime(castToDate2);
                                                    return (T) CalendarCodec.instance.createXMLGregorianCalendar(calendar);
                                                }
                                                if (obj instanceof String) {
                                                    String str = (String) obj;
                                                    if (str.length() == 0 || StringUtil.NULL_STRING.equals(str) || "NULL".equals(str)) {
                                                        return null;
                                                    }
                                                    if (cls == Currency.class) {
                                                        return (T) Currency.getInstance(str);
                                                    }
                                                    if (cls == Locale.class) {
                                                        return (T) toLocale(str);
                                                    }
                                                    if (name.startsWith("java.time.")) {
                                                        return (T) JSON.parseObject(JSON.toJSONString(str), cls);
                                                    }
                                                }
                                                if (parserConfig.get(cls) != null) {
                                                    return (T) JSON.parseObject(JSON.toJSONString(obj), cls);
                                                }
                                                throw new JSONException("can not cast to : " + cls.getName());
                                            }
                                            return (T) castToDouble(obj);
                                        }
                                        return (T) castToFloat(obj);
                                    }
                                    return (T) castToLong(obj);
                                }
                                return (T) castToInt(obj);
                            }
                            return (T) castToShort(obj);
                        }
                        return (T) castToChar(obj);
                    }
                    return (T) castToByte(obj);
                }
                return (T) castToBoolean(obj);
            } else {
                throw new IllegalArgumentException("clazz is null");
            }
        }
        return (T) invokeLLL.objValue;
    }

    public static BigDecimal castToBigDecimal(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Float) {
                Float f2 = (Float) obj;
                if (Float.isNaN(f2.floatValue()) || Float.isInfinite(f2.floatValue())) {
                    return null;
                }
            } else if (obj instanceof Double) {
                Double d2 = (Double) obj;
                if (Double.isNaN(d2.doubleValue()) || Double.isInfinite(d2.doubleValue())) {
                    return null;
                }
            } else if (obj instanceof BigDecimal) {
                return (BigDecimal) obj;
            } else {
                if (obj instanceof BigInteger) {
                    return new BigDecimal((BigInteger) obj);
                }
                if ((obj instanceof Map) && ((Map) obj).size() == 0) {
                    return null;
                }
            }
            String obj2 = obj.toString();
            if (obj2.length() == 0 || obj2.equalsIgnoreCase(StringUtil.NULL_STRING)) {
                return null;
            }
            if (obj2.length() <= 65535) {
                return new BigDecimal(obj2);
            }
            throw new JSONException("decimal overflow");
        }
        return (BigDecimal) invokeL.objValue;
    }

    public static BigInteger castToBigInteger(Object obj) {
        InterceptResult invokeL;
        BigDecimal bigDecimal;
        int scale;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Float) {
                Float f2 = (Float) obj;
                if (Float.isNaN(f2.floatValue()) || Float.isInfinite(f2.floatValue())) {
                    return null;
                }
                return BigInteger.valueOf(f2.longValue());
            } else if (obj instanceof Double) {
                Double d2 = (Double) obj;
                if (Double.isNaN(d2.doubleValue()) || Double.isInfinite(d2.doubleValue())) {
                    return null;
                }
                return BigInteger.valueOf(d2.longValue());
            } else if (obj instanceof BigInteger) {
                return (BigInteger) obj;
            } else {
                if ((obj instanceof BigDecimal) && (scale = (bigDecimal = (BigDecimal) obj).scale()) > -1000 && scale < 1000) {
                    return bigDecimal.toBigInteger();
                }
                String obj2 = obj.toString();
                if (obj2.length() == 0 || obj2.equalsIgnoreCase(StringUtil.NULL_STRING)) {
                    return null;
                }
                if (obj2.length() <= 65535) {
                    return new BigInteger(obj2);
                }
                throw new JSONException("decimal overflow");
            }
        }
        return (BigInteger) invokeL.objValue;
    }

    public static Boolean castToBoolean(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            if (obj instanceof BigDecimal) {
                return Boolean.valueOf(intValue((BigDecimal) obj) == 1);
            } else if (obj instanceof Number) {
                return Boolean.valueOf(((Number) obj).intValue() == 1);
            } else {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() == 0 || StringUtil.NULL_STRING.equals(str) || "NULL".equals(str)) {
                        return null;
                    }
                    if (!"true".equalsIgnoreCase(str) && !"1".equals(str)) {
                        if (!"false".equalsIgnoreCase(str) && !"0".equals(str)) {
                            if (!"Y".equalsIgnoreCase(str) && !"T".equals(str)) {
                                if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                                    return Boolean.FALSE;
                                }
                            } else {
                                return Boolean.TRUE;
                            }
                        } else {
                            return Boolean.FALSE;
                        }
                    } else {
                        return Boolean.TRUE;
                    }
                }
                throw new JSONException("can not cast to boolean, value : " + obj);
            }
        }
        return (Boolean) invokeL.objValue;
    }

    public static Byte castToByte(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof BigDecimal) {
                return Byte.valueOf(byteValue((BigDecimal) obj));
            }
            if (obj instanceof Number) {
                return Byte.valueOf(((Number) obj).byteValue());
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || StringUtil.NULL_STRING.equals(str) || "NULL".equals(str)) {
                    return null;
                }
                return Byte.valueOf(Byte.parseByte(str));
            } else if (obj instanceof Boolean) {
                return Byte.valueOf(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
            } else {
                throw new JSONException("can not cast to byte, value : " + obj);
            }
        }
        return (Byte) invokeL.objValue;
    }

    public static byte[] castToBytes(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, obj)) == null) {
            if (obj instanceof byte[]) {
                return (byte[]) obj;
            }
            if (obj instanceof String) {
                return IOUtils.decodeBase64((String) obj);
            }
            throw new JSONException("can not cast to byte[], value : " + obj);
        }
        return (byte[]) invokeL.objValue;
    }

    public static Character castToChar(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, obj)) == null) {
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
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                throw new JSONException("can not cast to char, value : " + obj);
            }
            throw new JSONException("can not cast to char, value : " + obj);
        }
        return (Character) invokeL.objValue;
    }

    public static Date castToDate(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, obj)) == null) ? castToDate(obj, null) : (Date) invokeL.objValue;
    }

    public static Double castToDouble(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Number) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
            if (obj instanceof String) {
                String obj2 = obj.toString();
                if (obj2.length() == 0 || StringUtil.NULL_STRING.equals(obj2) || "NULL".equals(obj2)) {
                    return null;
                }
                if (obj2.indexOf(44) != -1) {
                    obj2 = obj2.replaceAll(",", "");
                }
                return Double.valueOf(Double.parseDouble(obj2));
            } else if (obj instanceof Boolean) {
                return Double.valueOf(((Boolean) obj).booleanValue() ? 1.0d : 0.0d);
            } else {
                throw new JSONException("can not cast to double, value : " + obj);
            }
        }
        return (Double) invokeL.objValue;
    }

    public static <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, obj, cls, parserConfig)) == null) {
            try {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() == 0) {
                        return null;
                    }
                    if (parserConfig == null) {
                        parserConfig = ParserConfig.getGlobalInstance();
                    }
                    ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
                    if (deserializer instanceof EnumDeserializer) {
                        return (T) ((EnumDeserializer) deserializer).getEnumByHashCode(fnv1a_64(str));
                    }
                    return (T) Enum.valueOf(cls, str);
                }
                if (obj instanceof BigDecimal) {
                    int intValue = intValue((BigDecimal) obj);
                    T[] enumConstants = cls.getEnumConstants();
                    if (intValue < enumConstants.length) {
                        return enumConstants[intValue];
                    }
                }
                if (obj instanceof Number) {
                    int intValue2 = ((Number) obj).intValue();
                    T[] enumConstants2 = cls.getEnumConstants();
                    if (intValue2 < enumConstants2.length) {
                        return enumConstants2[intValue2];
                    }
                }
                throw new JSONException("can not cast to : " + cls.getName());
            } catch (Exception e2) {
                throw new JSONException("can not cast to : " + cls.getName(), e2);
            }
        }
        return (T) invokeLLL.objValue;
    }

    public static Float castToFloat(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Number) {
                return Float.valueOf(((Number) obj).floatValue());
            }
            if (obj instanceof String) {
                String obj2 = obj.toString();
                if (obj2.length() == 0 || StringUtil.NULL_STRING.equals(obj2) || "NULL".equals(obj2)) {
                    return null;
                }
                if (obj2.indexOf(44) != -1) {
                    obj2 = obj2.replaceAll(",", "");
                }
                return Float.valueOf(Float.parseFloat(obj2));
            } else if (obj instanceof Boolean) {
                return Float.valueOf(((Boolean) obj).booleanValue() ? 1.0f : 0.0f);
            } else {
                throw new JSONException("can not cast to float, value : " + obj);
            }
        }
        return (Float) invokeL.objValue;
    }

    public static Integer castToInt(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            if (obj instanceof BigDecimal) {
                return Integer.valueOf(intValue((BigDecimal) obj));
            }
            if (obj instanceof Number) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || StringUtil.NULL_STRING.equals(str) || "NULL".equals(str)) {
                    return null;
                }
                if (str.indexOf(44) != -1) {
                    str = str.replaceAll(",", "");
                }
                Matcher matcher = NUMBER_WITH_TRAILING_ZEROS_PATTERN.matcher(str);
                if (matcher.find()) {
                    str = matcher.replaceAll("");
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
        return (Integer) invokeL.objValue;
    }

    public static <T> T castToJavaBean(Object obj, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, obj, cls)) == null) ? (T) cast(obj, (Class<Object>) cls, ParserConfig.getGlobalInstance()) : (T) invokeLL.objValue;
    }

    public static Long castToLong(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof BigDecimal) {
                return Long.valueOf(longValue((BigDecimal) obj));
            }
            if (obj instanceof Number) {
                return Long.valueOf(((Number) obj).longValue());
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || StringUtil.NULL_STRING.equals(str) || "NULL".equals(str)) {
                    return null;
                }
                if (str.indexOf(44) != -1) {
                    str = str.replaceAll(",", "");
                }
                try {
                    return Long.valueOf(Long.parseLong(str));
                } catch (NumberFormatException unused) {
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
            if (obj instanceof Boolean) {
                return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
            }
            throw new JSONException("can not cast to long, value : " + obj);
        }
        return (Long) invokeL.objValue;
    }

    public static Short castToShort(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof BigDecimal) {
                return Short.valueOf(shortValue((BigDecimal) obj));
            }
            if (obj instanceof Number) {
                return Short.valueOf(((Number) obj).shortValue());
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || StringUtil.NULL_STRING.equals(str) || "NULL".equals(str)) {
                    return null;
                }
                return Short.valueOf(Short.parseShort(str));
            } else if (obj instanceof Boolean) {
                return Short.valueOf(((Boolean) obj).booleanValue() ? (short) 1 : (short) 0);
            } else {
                throw new JSONException("can not cast to short, value : " + obj);
            }
        }
        return (Short) invokeL.objValue;
    }

    public static java.sql.Date castToSqlDate(Object obj) {
        InterceptResult invokeL;
        long longValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, obj)) == null) {
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
            if (obj instanceof BigDecimal) {
                longValue = longValue((BigDecimal) obj);
            } else {
                longValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || StringUtil.NULL_STRING.equals(str) || "NULL".equals(str)) {
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
            if (longValue > 0) {
                return new java.sql.Date(longValue);
            }
            throw new JSONException("can not cast to Date, value : " + obj);
        }
        return (java.sql.Date) invokeL.objValue;
    }

    public static Time castToSqlTime(Object obj) {
        InterceptResult invokeL;
        long longValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Time) {
                return (Time) obj;
            }
            if (obj instanceof Date) {
                return new Time(((Date) obj).getTime());
            }
            if (obj instanceof Calendar) {
                return new Time(((Calendar) obj).getTimeInMillis());
            }
            if (obj instanceof BigDecimal) {
                longValue = longValue((BigDecimal) obj);
            } else {
                longValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || StringUtil.NULL_STRING.equalsIgnoreCase(str)) {
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
            if (longValue > 0) {
                return new Time(longValue);
            }
            throw new JSONException("can not cast to Date, value : " + obj);
        }
        return (Time) invokeL.objValue;
    }

    public static String castToString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public static Timestamp castToTimestamp(Object obj) {
        InterceptResult invokeL;
        long longValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, obj)) == null) {
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
            if (obj instanceof BigDecimal) {
                longValue = longValue((BigDecimal) obj);
            } else {
                longValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0 || StringUtil.NULL_STRING.equals(str) || "NULL".equals(str)) {
                    return null;
                }
                if (str.endsWith(".000000000")) {
                    str = str.substring(0, str.length() - 10);
                } else if (str.endsWith(".000000")) {
                    str = str.substring(0, str.length() - 7);
                }
                if (str.length() == 29 && str.charAt(4) == '-' && str.charAt(7) == '-' && str.charAt(10) == ' ' && str.charAt(13) == ':' && str.charAt(16) == ':' && str.charAt(19) == '.') {
                    return new Timestamp(num(str.charAt(0), str.charAt(1), str.charAt(2), str.charAt(3)) - 1900, num(str.charAt(5), str.charAt(6)) - 1, num(str.charAt(8), str.charAt(9)), num(str.charAt(11), str.charAt(12)), num(str.charAt(14), str.charAt(15)), num(str.charAt(17), str.charAt(18)), num(str.charAt(20), str.charAt(21), str.charAt(22), str.charAt(23), str.charAt(24), str.charAt(25), str.charAt(26), str.charAt(27), str.charAt(28)));
                } else if (isNumber(str)) {
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
            if (longValue >= 0) {
                return new Timestamp(longValue);
            }
            throw new JSONException("can not cast to Timestamp, value : " + obj);
        }
        return (Timestamp) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0102 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0030 */
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, genericArrayType)) == null) {
            Type genericComponentType = genericArrayType.getGenericComponentType();
            String str = PreferencesUtil.LEFT_MOUNT;
            while (genericComponentType instanceof GenericArrayType) {
                genericComponentType = ((GenericArrayType) genericComponentType).getGenericComponentType();
                str = str + str;
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
                            genericArrayType = Class.forName(str + "S");
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
                    } catch (ClassNotFoundException unused) {
                    }
                }
            }
            return genericArrayType;
        }
        return (Type) invokeL.objValue;
    }

    public static void clearClassMapping() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, null) == null) {
            mappings.clear();
            addBaseClassMappings();
        }
    }

    public static void computeFields(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, Map<String, FieldInfo> map2, Field[] fieldArr) {
        String str;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65568, null, cls, map, propertyNamingStrategy, map2, fieldArr) == null) {
            for (Field field : fieldArr) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    JSONField jSONField = (JSONField) getAnnotation(field, JSONField.class);
                    String name = field.getName();
                    if (jSONField == null) {
                        str = null;
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                    } else if (jSONField.serialize()) {
                        int ordinal = jSONField.ordinal();
                        int of = SerializerFeature.of(jSONField.serialzeFeatures());
                        int of2 = Feature.of(jSONField.parseFeatures());
                        if (jSONField.name().length() != 0) {
                            name = jSONField.name();
                        }
                        str = jSONField.label().length() != 0 ? jSONField.label() : null;
                        i2 = ordinal;
                        i3 = of;
                        i4 = of2;
                    }
                    if (map == null || (name = map.get(name)) != null) {
                        if (propertyNamingStrategy != null) {
                            name = propertyNamingStrategy.translate(name);
                        }
                        String str2 = name;
                        if (!map2.containsKey(str2)) {
                            map2.put(str2, new FieldInfo(str2, null, field, cls, null, i2, i3, i4, null, jSONField, str));
                        }
                    }
                }
            }
        }
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, cls, map)) == null) ? computeGetters(cls, map, true) : (List) invokeLL.objValue;
    }

    public static List<FieldInfo> computeGettersWithFieldBase(Class<?> cls, Map<String, String> map, boolean z, PropertyNamingStrategy propertyNamingStrategy) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65572, null, new Object[]{cls, map, Boolean.valueOf(z), propertyNamingStrategy})) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                computeFields(cls2, map, propertyNamingStrategy, linkedHashMap, cls2.getDeclaredFields());
            }
            return getFieldInfos(cls, z, linkedHashMap);
        }
        return (List) invokeCommon.objValue;
    }

    public static Map<TypeVariable, Type> createActualTypeMap(TypeVariable[] typeVariableArr, Type[] typeArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, typeVariableArr, typeArr)) == null) {
            int length = typeVariableArr.length;
            HashMap hashMap = new HashMap(length);
            for (int i2 = 0; i2 < length; i2++) {
                hashMap.put(typeVariableArr[i2], typeArr[i2]);
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static Collection createCollection(Type type) {
        InterceptResult invokeL;
        Class<?> cls;
        Type type2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, type)) == null) {
            Class<?> rawClass = getRawClass(type);
            if (rawClass != AbstractCollection.class && rawClass != Collection.class) {
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
                } else if (!rawClass.isAssignableFrom(Queue.class) && ((cls = class_deque) == null || !rawClass.isAssignableFrom(cls))) {
                    try {
                        return (Collection) rawClass.newInstance();
                    } catch (Exception unused) {
                        throw new JSONException("create instance error, class " + rawClass.getName());
                    }
                } else {
                    return new LinkedList();
                }
            }
            return new ArrayList();
        }
        return (Collection) invokeL.objValue;
    }

    public static String decapitalize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return str;
            }
            if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
                return str;
            }
            char[] charArray = str.toCharArray();
            charArray[0] = Character.toLowerCase(charArray[0]);
            return new String(charArray);
        }
        return (String) invokeL.objValue;
    }

    public static long fnv1a_64(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, str)) == null) {
            long j2 = -3750763034362895579L;
            for (int i2 = 0; i2 < str.length(); i2++) {
                j2 = (j2 ^ str.charAt(i2)) * 1099511628211L;
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public static long fnv1a_64_extract(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, str)) == null) {
            long j2 = -3750763034362895579L;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt != '_' && charAt != '-') {
                    if (charAt >= 'A' && charAt <= 'Z') {
                        charAt = (char) (charAt + ' ');
                    }
                    j2 = (j2 ^ charAt) * 1099511628211L;
                }
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public static long fnv1a_64_lower(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            long j2 = -3750763034362895579L;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt >= 'A' && charAt <= 'Z') {
                    charAt = (char) (charAt + ' ');
                }
                j2 = (j2 ^ charAt) * 1099511628211L;
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public static Type getActualType(Type type, Map<TypeVariable, Type> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65579, null, type, map)) == null) {
            if (type instanceof TypeVariable) {
                return map.get(type);
            }
            if (type instanceof ParameterizedType) {
                return makeParameterizedType(getRawClass(type), ((ParameterizedType) type).getActualTypeArguments(), map);
            }
            return type instanceof GenericArrayType ? new GenericArrayTypeImpl(getActualType(((GenericArrayType) type).getGenericComponentType(), map)) : type;
        }
        return (Type) invokeLL.objValue;
    }

    public static <A extends Annotation> A getAnnotation(Class<?> cls, Class<A> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65580, null, cls, cls2)) == null) {
            A a = (A) cls.getAnnotation(cls2);
            Type mixInAnnotations = JSON.getMixInAnnotations(cls);
            Class cls3 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
            if (cls3 != null) {
                A a2 = (A) cls3.getAnnotation(cls2);
                Annotation[] annotations = cls3.getAnnotations();
                if (a2 == null && annotations.length > 0) {
                    for (Annotation annotation : annotations) {
                        a2 = (A) annotation.annotationType().getAnnotation(cls2);
                        if (a2 != null) {
                            break;
                        }
                    }
                }
                if (a2 != null) {
                    return a2;
                }
            }
            Annotation[] annotations2 = cls.getAnnotations();
            if (a == null && annotations2.length > 0) {
                for (Annotation annotation2 : annotations2) {
                    a = (A) annotation2.annotationType().getAnnotation(cls2);
                    if (a != null) {
                        break;
                    }
                }
            }
            return a;
        }
        return (A) invokeLL.objValue;
    }

    public static Class<?> getClass(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, type)) == null) {
            if (type.getClass() == Class.class) {
                return (Class) type;
            }
            if (type instanceof ParameterizedType) {
                return getClass(((ParameterizedType) type).getRawType());
            }
            if (type instanceof TypeVariable) {
                Type type2 = ((TypeVariable) type).getBounds()[0];
                if (type2 instanceof Class) {
                    return (Class) type2;
                }
                return getClass(type2);
            } else if (type instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type).getUpperBounds();
                if (upperBounds.length == 1) {
                    return getClass(upperBounds[0]);
                }
                return Object.class;
            } else {
                return Object.class;
            }
        }
        return (Class) invokeL.objValue;
    }

    public static Class<?> getClassFromMapping(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65584, null, str)) == null) ? mappings.get(str) : (Class) invokeL.objValue;
    }

    public static Class<?> getCollectionItemClass(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, type)) == null) {
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof WildcardType) {
                    Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                    if (upperBounds.length == 1) {
                        type2 = upperBounds[0];
                    }
                }
                if (type2 instanceof Class) {
                    Class<?> cls = (Class) type2;
                    if (Modifier.isPublic(cls.getModifiers())) {
                        return cls;
                    }
                    throw new JSONException("can not create ASMParser");
                }
                throw new JSONException("can not create ASMParser");
            }
            return Object.class;
        }
        return (Class) invokeL.objValue;
    }

    public static Type getCollectionItemType(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, type)) == null) {
            if (type instanceof ParameterizedType) {
                return getCollectionItemType((ParameterizedType) type);
            }
            if (type instanceof Class) {
                return getCollectionItemType((Class<?>) type);
            }
            return Object.class;
        }
        return (Type) invokeL.objValue;
    }

    public static Type getCollectionSuperType(Class<?> cls) {
        InterceptResult invokeL;
        Type[] genericInterfaces;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, cls)) == null) {
            Type type = null;
            for (Type type2 : cls.getGenericInterfaces()) {
                Class<?> rawClass = getRawClass(type2);
                if (rawClass == Collection.class) {
                    return type2;
                }
                if (Collection.class.isAssignableFrom(rawClass)) {
                    type = type2;
                }
            }
            return type == null ? cls.getGenericSuperclass() : type;
        }
        return (Type) invokeL.objValue;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        InterceptResult invokeLLL;
        char charAt;
        char charAt2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65590, null, cls, str, fieldArr)) == null) {
            for (Field field : fieldArr) {
                String name = field.getName();
                if (str.equals(name)) {
                    return field;
                }
                if (str.length() > 2 && (charAt = str.charAt(0)) >= 'a' && charAt <= 'z' && (charAt2 = str.charAt(1)) >= 'A' && charAt2 <= 'Z' && str.equalsIgnoreCase(name)) {
                    return field;
                }
            }
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass == null || superclass == Object.class) {
                return null;
            }
            return getField(superclass, str, superclass.getDeclaredFields());
        }
        return (Field) invokeLLL.objValue;
    }

    public static List<FieldInfo> getFieldInfos(Class<?> cls, boolean z, Map<String, FieldInfo> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65591, null, new Object[]{cls, Boolean.valueOf(z), map})) == null) {
            ArrayList arrayList = new ArrayList();
            JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
            String[] orders = jSONType != null ? jSONType.orders() : null;
            if (orders != null && orders.length > 0) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(arrayList.size());
                for (FieldInfo fieldInfo : map.values()) {
                    linkedHashMap.put(fieldInfo.name, fieldInfo);
                }
                for (String str : orders) {
                    FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                    if (fieldInfo2 != null) {
                        arrayList.add(fieldInfo2);
                        linkedHashMap.remove(str);
                    }
                }
                arrayList.addAll(linkedHashMap.values());
            } else {
                arrayList.addAll(map.values());
                if (z) {
                    Collections.sort(arrayList);
                }
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static Type getGenericParamType(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65592, null, type)) == null) ? (!(type instanceof ParameterizedType) && (type instanceof Class)) ? getGenericParamType(((Class) type).getGenericSuperclass()) : type : (Type) invokeL.objValue;
    }

    public static String[] getKoltinConstructorParameters(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, cls)) == null) {
            if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
                try {
                    kotlin_kclass_constructor = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getConstructor(Class.class);
                } catch (Throwable unused) {
                    kotlin_class_klass_error = true;
                }
            }
            if (kotlin_kclass_constructor == null) {
                return null;
            }
            if (kotlin_kclass_getConstructors == null && !kotlin_class_klass_error) {
                try {
                    kotlin_kclass_getConstructors = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getMethod("getConstructors", new Class[0]);
                } catch (Throwable unused2) {
                    kotlin_class_klass_error = true;
                }
            }
            if (kotlin_kfunction_getParameters == null && !kotlin_class_klass_error) {
                try {
                    kotlin_kfunction_getParameters = Class.forName("kotlin.reflect.KFunction").getMethod("getParameters", new Class[0]);
                } catch (Throwable unused3) {
                    kotlin_class_klass_error = true;
                }
            }
            if (kotlin_kparameter_getName == null && !kotlin_class_klass_error) {
                try {
                    kotlin_kparameter_getName = Class.forName("kotlin.reflect.KParameter").getMethod("getName", new Class[0]);
                } catch (Throwable unused4) {
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
                    List list = (List) kotlin_kfunction_getParameters.invoke(next, new Object[0]);
                    if (obj == null || list.size() != 0) {
                        obj = next;
                    }
                    it.hasNext();
                }
                if (obj == null) {
                    return null;
                }
                List list2 = (List) kotlin_kfunction_getParameters.invoke(obj, new Object[0]);
                String[] strArr = new String[list2.size()];
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    strArr[i2] = (String) kotlin_kparameter_getName.invoke(list2.get(i2), new Object[0]);
                }
                return strArr;
            } catch (Throwable th) {
                th.printStackTrace();
                kotlin_error = true;
                return null;
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static Constructor getKotlinConstructor(Constructor[] constructorArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65594, null, constructorArr)) == null) ? getKotlinConstructor(constructorArr, null) : (Constructor) invokeL.objValue;
    }

    public static Annotation[][] getParameterAnnotations(Method method) {
        InterceptResult invokeL;
        Annotation[][] parameterAnnotations;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, method)) == null) {
            Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
            Type mixInAnnotations = JSON.getMixInAnnotations(method.getDeclaringClass());
            Method method2 = null;
            Class cls = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
            if (cls != null) {
                String name = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                while (cls != null && cls != Object.class) {
                    try {
                        method2 = cls.getDeclaredMethod(name, parameterTypes);
                        break;
                    } catch (NoSuchMethodException unused) {
                        cls = cls.getSuperclass();
                    }
                }
                if (method2 != null && (parameterAnnotations = method2.getParameterAnnotations()) != null) {
                    return parameterAnnotations;
                }
            }
            return parameterAnnotations2;
        }
        return (Annotation[][]) invokeL.objValue;
    }

    public static int getParserFeatures(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, null, cls)) == null) {
            JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
            if (jSONType == null) {
                return 0;
            }
            return Feature.of(jSONType.parseFeatures());
        }
        return invokeL.intValue;
    }

    public static String getPropertyNameByCompatibleFieldName(Map<String, Field> map, String str, String str2, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65599, null, map, str, str2, i2)) == null) {
            if (!compatibleWithFieldName || map.containsKey(str2)) {
                return str2;
            }
            String substring = str.substring(i2);
            return map.containsKey(substring) ? substring : str2;
        }
        return (String) invokeLLLI.objValue;
    }

    public static String getPropertyNameByMethodName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, str)) == null) {
            return Character.toLowerCase(str.charAt(3)) + str.substring(4);
        }
        return (String) invokeL.objValue;
    }

    public static Class<?> getRawClass(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65601, null, type)) == null) {
            if (type instanceof Class) {
                return (Class) type;
            }
            if (type instanceof ParameterizedType) {
                return getRawClass(((ParameterizedType) type).getRawType());
            }
            if (type instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type).getUpperBounds();
                if (upperBounds.length == 1) {
                    return getRawClass(upperBounds[0]);
                }
                throw new JSONException("TODO");
            }
            throw new JSONException("TODO");
        }
        return (Class) invokeL.objValue;
    }

    public static int getSerializeFeatures(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, null, cls)) == null) {
            JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
            if (jSONType == null) {
                return 0;
            }
            return SerializerFeature.of(jSONType.serialzeFeatures());
        }
        return invokeL.intValue;
    }

    public static JSONField getSuperMethodAnnotation(Class<?> cls, Method method) {
        InterceptResult invokeLL;
        Method[] methods;
        boolean z;
        JSONField jSONField;
        Method[] methods2;
        boolean z2;
        JSONField jSONField2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65603, null, cls, method)) == null) {
            Class<?>[] interfaces = cls.getInterfaces();
            if (interfaces.length > 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (Class<?> cls2 : interfaces) {
                    for (Method method2 : cls2.getMethods()) {
                        Class<?>[] parameterTypes2 = method2.getParameterTypes();
                        if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= parameterTypes.length) {
                                    z2 = true;
                                    break;
                                } else if (!parameterTypes2[i2].equals(parameterTypes[i2])) {
                                    z2 = false;
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            if (z2 && (jSONField2 = (JSONField) getAnnotation(method2, JSONField.class)) != null) {
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
                        int i3 = 0;
                        while (true) {
                            if (i3 >= parameterTypes3.length) {
                                z = true;
                                break;
                            } else if (!parameterTypes4[i3].equals(parameterTypes3[i3])) {
                                z = false;
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (z && (jSONField = (JSONField) getAnnotation(method3, JSONField.class)) != null) {
                            return jSONField;
                        }
                    }
                }
            }
            return null;
        }
        return (JSONField) invokeLL.objValue;
    }

    public static Type getWildcardTypeUpperBounds(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65604, null, type)) == null) {
            if (type instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type).getUpperBounds();
                return upperBounds.length > 0 ? upperBounds[0] : Object.class;
            }
            return type;
        }
        return (Type) invokeL.objValue;
    }

    public static Annotation getXmlAccessorType(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65605, null, cls)) == null) {
            if (class_XmlAccessorType == null && !classXmlAccessorType_error) {
                try {
                    class_XmlAccessorType = Class.forName("javax.xml.bind.annotation.XmlAccessorType");
                } catch (Throwable unused) {
                    classXmlAccessorType_error = true;
                }
            }
            if (class_XmlAccessorType == null) {
                return null;
            }
            return getAnnotation(cls, class_XmlAccessorType);
        }
        return (Annotation) invokeL.objValue;
    }

    public static int intValue(BigDecimal bigDecimal) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, null, bigDecimal)) == null) {
            if (bigDecimal == null) {
                return 0;
            }
            int scale = bigDecimal.scale();
            if (scale >= -100 && scale <= 100) {
                return bigDecimal.intValue();
            }
            return bigDecimal.intValueExact();
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Type inference failed for r1v9. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends java.lang.annotation.Annotation> */
    public static boolean isAnnotationPresentManyToMany(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65607, null, method)) == null) {
            if (method == null) {
                return false;
            }
            if (class_ManyToMany == null && !class_ManyToMany_error) {
                try {
                    class_ManyToMany = Class.forName("javax.persistence.ManyToMany");
                } catch (Throwable unused) {
                    class_ManyToMany_error = true;
                }
            }
            if (class_ManyToMany != null) {
                return method.isAnnotationPresent(class_OneToMany) || method.isAnnotationPresent(class_ManyToMany);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Type inference failed for r1v6. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends java.lang.annotation.Annotation> */
    public static boolean isAnnotationPresentOneToMany(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65608, null, method)) == null) {
            if (method == null) {
                return false;
            }
            if (class_OneToMany == null && !class_OneToMany_error) {
                try {
                    class_OneToMany = Class.forName("javax.persistence.OneToMany");
                } catch (Throwable unused) {
                    class_OneToMany_error = true;
                }
            }
            Class<? extends Annotation> cls = class_OneToMany;
            return cls != null && method.isAnnotationPresent(cls);
        }
        return invokeL.booleanValue;
    }

    public static boolean isClob(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, null, cls)) == null) {
            if (class_Clob == null && !class_Clob_error) {
                try {
                    class_Clob = Class.forName("java.sql.Clob");
                } catch (Throwable unused) {
                    class_Clob_error = true;
                }
            }
            if (class_Clob == null) {
                return false;
            }
            return class_Clob.isAssignableFrom(cls);
        }
        return invokeL.booleanValue;
    }

    public static boolean isGenericParamType(Type type) {
        InterceptResult invokeL;
        Type genericSuperclass;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65610, null, type)) == null) {
            if (type instanceof ParameterizedType) {
                return true;
            }
            return (type instanceof Class) && (genericSuperclass = ((Class) type).getGenericSuperclass()) != Object.class && isGenericParamType(genericSuperclass);
        }
        return invokeL.booleanValue;
    }

    public static boolean isHibernateInitialized(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65611, null, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (method_HibernateIsInitialized == null && !method_HibernateIsInitialized_error) {
                try {
                    method_HibernateIsInitialized = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", Object.class);
                } catch (Throwable unused) {
                    method_HibernateIsInitialized_error = true;
                }
            }
            Method method = method_HibernateIsInitialized;
            if (method != null) {
                try {
                    return ((Boolean) method.invoke(null, obj)).booleanValue();
                } catch (Throwable unused2) {
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isJSONTypeIgnore(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65612, null, cls, str)) == null) {
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
                for (String str3 : jSONType.ignores()) {
                    if (str.equals(str3)) {
                        return true;
                    }
                }
            }
            if (cls.getSuperclass() == Object.class || cls.getSuperclass() == null) {
                return false;
            }
            return isJSONTypeIgnore(cls.getSuperclass(), str);
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Type inference failed for r1v6. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends java.lang.annotation.Annotation> */
    public static boolean isJacksonCreator(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65613, null, method)) == null) {
            if (method == null) {
                return false;
            }
            if (class_JacksonCreator == null && !class_JacksonCreator_error) {
                try {
                    class_JacksonCreator = Class.forName("com.fasterxml.jackson.annotation.JsonCreator");
                } catch (Throwable unused) {
                    class_JacksonCreator_error = true;
                }
            }
            Class<? extends Annotation> cls = class_JacksonCreator;
            return cls != null && method.isAnnotationPresent(cls);
        }
        return invokeL.booleanValue;
    }

    public static boolean isKotlin(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65614, null, cls)) == null) {
            if (kotlin_metadata == null && !kotlin_metadata_error) {
                try {
                    kotlin_metadata = Class.forName("kotlin.Metadata");
                } catch (Throwable unused) {
                    kotlin_metadata_error = true;
                }
            }
            return kotlin_metadata != null && cls.isAnnotationPresent(kotlin_metadata);
        }
        return invokeL.booleanValue;
    }

    public static boolean isKotlinIgnore(Class cls, String str) {
        InterceptResult invokeLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65615, null, cls, str)) == null) {
            if (kotlinIgnores == null && !kotlinIgnores_error) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Class.forName("kotlin.ranges.CharRange"), new String[]{"getEndInclusive", "isEmpty"});
                    hashMap.put(Class.forName("kotlin.ranges.IntRange"), new String[]{"getEndInclusive", "isEmpty"});
                    hashMap.put(Class.forName("kotlin.ranges.LongRange"), new String[]{"getEndInclusive", "isEmpty"});
                    hashMap.put(Class.forName("kotlin.ranges.ClosedFloatRange"), new String[]{"getEndInclusive", "isEmpty"});
                    hashMap.put(Class.forName("kotlin.ranges.ClosedDoubleRange"), new String[]{"getEndInclusive", "isEmpty"});
                    kotlinIgnores = hashMap;
                } catch (Throwable unused) {
                    kotlinIgnores_error = true;
                }
            }
            return (kotlinIgnores == null || (strArr = kotlinIgnores.get(cls)) == null || Arrays.binarySearch(strArr, str) < 0) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, null, str)) == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt == '+' || charAt == '-') {
                    if (i2 != 0) {
                        return false;
                    }
                } else if (charAt < '0' || charAt > '9') {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isPath(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65617, null, cls)) == null) {
            if (pathClass == null && !pathClass_error) {
                try {
                    pathClass = Class.forName("java.nio.file.Path");
                } catch (Throwable unused) {
                    pathClass_error = true;
                }
            }
            Class<?> cls2 = pathClass;
            if (cls2 != null) {
                return cls2.isAssignableFrom(cls);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isProxy(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65618, null, cls)) == null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                String name = cls2.getName();
                if (name.equals("net.sf.cglib.proxy.Factory") || name.equals("org.springframework.cglib.proxy.Factory") || name.equals("javassist.util.proxy.ProxyObject") || name.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject") || name.equals("org.hibernate.proxy.HibernateProxy") || name.equals("org.springframework.context.annotation.ConfigurationClassEnhancer$EnhancedConfiguration")) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends java.lang.annotation.Annotation> */
    public static boolean isTransient(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65619, null, method)) == null) {
            if (method == null) {
                return false;
            }
            if (!transientClassInited) {
                try {
                    transientClass = Class.forName("java.beans.Transient");
                } catch (Exception unused) {
                } catch (Throwable th) {
                    transientClassInited = true;
                    throw th;
                }
                transientClassInited = true;
            }
            Class<? extends Annotation> cls = transientClass;
            return (cls == null || getAnnotation(method, (Class<Annotation>) cls) == null) ? false : true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isXmlField(Class cls) {
        InterceptResult invokeL;
        Annotation annotation;
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65620, null, cls)) != null) {
            return invokeL.booleanValue;
        }
        if (class_XmlAccessorType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessorType = Class.forName("javax.xml.bind.annotation.XmlAccessorType");
            } catch (Throwable unused) {
                classXmlAccessorType_error = true;
            }
        }
        if (class_XmlAccessorType == null || (annotation = getAnnotation(cls, class_XmlAccessorType)) == null) {
            return false;
        }
        if (method_XmlAccessorType_value == null && !classXmlAccessorType_error) {
            try {
                method_XmlAccessorType_value = class_XmlAccessorType.getMethod("value", new Class[0]);
            } catch (Throwable unused2) {
                classXmlAccessorType_error = true;
            }
        }
        if (method_XmlAccessorType_value == null) {
            return false;
        }
        if (!classXmlAccessorType_error) {
            try {
                invoke = method_XmlAccessorType_value.invoke(annotation, new Object[0]);
            } catch (Throwable unused3) {
                classXmlAccessorType_error = true;
            }
            if (invoke != null) {
                return false;
            }
            if (class_XmlAccessType == null && !classXmlAccessorType_error) {
                try {
                    class_XmlAccessType = Class.forName("javax.xml.bind.annotation.XmlAccessType");
                    field_XmlAccessType_FIELD = class_XmlAccessType.getField("FIELD");
                    field_XmlAccessType_FIELD_VALUE = field_XmlAccessType_FIELD.get(null);
                } catch (Throwable unused4) {
                    classXmlAccessorType_error = true;
                }
            }
            return invoke == field_XmlAccessType_FIELD_VALUE;
        }
        invoke = null;
        if (invoke != null) {
        }
    }

    public static Class<?> loadClass(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65621, null, str)) == null) ? loadClass(str, null) : (Class) invokeL.objValue;
    }

    public static long longExtractValue(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65624, null, number)) == null) {
            if (number instanceof BigDecimal) {
                return ((BigDecimal) number).longValueExact();
            }
            return number.longValue();
        }
        return invokeL.longValue;
    }

    public static long longValue(BigDecimal bigDecimal) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65625, null, bigDecimal)) == null) {
            if (bigDecimal == null) {
                return 0L;
            }
            int scale = bigDecimal.scale();
            if (scale >= -100 && scale <= 100) {
                return bigDecimal.longValue();
            }
            return bigDecimal.longValueExact();
        }
        return invokeL.longValue;
    }

    public static ParameterizedType makeParameterizedType(Class<?> cls, Type[] typeArr, Map<TypeVariable, Type> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65626, null, cls, typeArr, map)) == null) {
            int length = typeArr.length;
            Type[] typeArr2 = new Type[length];
            for (int i2 = 0; i2 < length; i2++) {
                typeArr2[i2] = getActualType(typeArr[i2], map);
            }
            return new ParameterizedTypeImpl(typeArr2, null, cls);
        }
        return (ParameterizedType) invokeLLL.objValue;
    }

    public static int num(char c2, char c3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65627, null, new Object[]{Character.valueOf(c2), Character.valueOf(c3)})) == null) {
            if (c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9') {
                return -1;
            }
            return ((c2 - '0') * 10) + (c3 - '0');
        }
        return invokeCommon.intValue;
    }

    public static int num(char c2, char c3, char c4, char c5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65628, null, new Object[]{Character.valueOf(c2), Character.valueOf(c3), Character.valueOf(c4), Character.valueOf(c5)})) == null) {
            if (c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9' || c5 < '0' || c5 > '9') {
                return -1;
            }
            return ((c2 - '0') * 1000) + ((c3 - '0') * 100) + ((c4 - '0') * 10) + (c5 - '0');
        }
        return invokeCommon.intValue;
    }

    public static int num(char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9, char c10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65629, null, new Object[]{Character.valueOf(c2), Character.valueOf(c3), Character.valueOf(c4), Character.valueOf(c5), Character.valueOf(c6), Character.valueOf(c7), Character.valueOf(c8), Character.valueOf(c9), Character.valueOf(c10)})) == null) {
            if (c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9' || c5 < '0' || c5 > '9' || c6 < '0' || c6 > '9' || c7 < '0' || c7 > '9' || c8 < '0' || c8 > '9' || c9 < '0' || c9 > '9' || c10 < '0' || c10 > '9') {
                return -1;
            }
            return ((c2 - '0') * 100000000) + ((c3 - '0') * 10000000) + ((c4 - '0') * 1000000) + ((c5 - '0') * 100000) + ((c6 - '0') * 10000) + ((c7 - '0') * 1000) + ((c8 - '0') * 100) + ((c9 - '0') * 10) + (c10 - '0');
        }
        return invokeCommon.intValue;
    }

    public static double parseDouble(String str) {
        InterceptResult invokeL;
        double d2;
        double d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65630, null, str)) == null) {
            int length = str.length();
            if (length > 10) {
                return Double.parseDouble(str);
            }
            long j2 = 0;
            boolean z = false;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (charAt == '-' && i3 == 0) {
                    z = true;
                } else if (charAt == '.') {
                    if (i2 != 0) {
                        return Double.parseDouble(str);
                    }
                    i2 = (length - i3) - 1;
                } else if (charAt < '0' || charAt > '9') {
                    return Double.parseDouble(str);
                } else {
                    j2 = (j2 * 10) + (charAt - '0');
                }
            }
            if (z) {
                j2 = -j2;
            }
            switch (i2) {
                case 0:
                    return j2;
                case 1:
                    d2 = j2;
                    d3 = 10.0d;
                    break;
                case 2:
                    d2 = j2;
                    d3 = 100.0d;
                    break;
                case 3:
                    d2 = j2;
                    d3 = 1000.0d;
                    break;
                case 4:
                    d2 = j2;
                    d3 = 10000.0d;
                    break;
                case 5:
                    d2 = j2;
                    d3 = 100000.0d;
                    break;
                case 6:
                    d2 = j2;
                    d3 = 1000000.0d;
                    break;
                case 7:
                    d2 = j2;
                    d3 = 1.0E7d;
                    break;
                case 8:
                    d2 = j2;
                    d3 = 1.0E8d;
                    break;
                case 9:
                    d2 = j2;
                    d3 = 1.0E9d;
                    break;
                default:
                    return Double.parseDouble(str);
            }
            return d2 / d3;
        }
        return invokeL.doubleValue;
    }

    public static float parseFloat(String str) {
        InterceptResult invokeL;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65631, null, str)) == null) {
            int length = str.length();
            if (length >= 10) {
                return Float.parseFloat(str);
            }
            long j2 = 0;
            boolean z = false;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (charAt == '-' && i3 == 0) {
                    z = true;
                } else if (charAt == '.') {
                    if (i2 != 0) {
                        return Float.parseFloat(str);
                    }
                    i2 = (length - i3) - 1;
                } else if (charAt < '0' || charAt > '9') {
                    return Float.parseFloat(str);
                } else {
                    j2 = (j2 * 10) + (charAt - '0');
                }
            }
            if (z) {
                j2 = -j2;
            }
            switch (i2) {
                case 0:
                    return (float) j2;
                case 1:
                    f2 = (float) j2;
                    f3 = 10.0f;
                    break;
                case 2:
                    f2 = (float) j2;
                    f3 = 100.0f;
                    break;
                case 3:
                    f2 = (float) j2;
                    f3 = 1000.0f;
                    break;
                case 4:
                    f2 = (float) j2;
                    f3 = 10000.0f;
                    break;
                case 5:
                    f2 = (float) j2;
                    f3 = 100000.0f;
                    break;
                case 6:
                    f2 = (float) j2;
                    f3 = 1000000.0f;
                    break;
                case 7:
                    f2 = (float) j2;
                    f3 = 1.0E7f;
                    break;
                case 8:
                    f2 = (float) j2;
                    f3 = 1.0E8f;
                    break;
                case 9:
                    f2 = (float) j2;
                    f3 = 1.0E9f;
                    break;
                default:
                    return Float.parseFloat(str);
            }
            return f2 / f3;
        }
        return invokeL.floatValue;
    }

    public static void setAccessible(AccessibleObject accessibleObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65632, null, accessibleObject) == null) && setAccessibleEnable && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
    }

    public static short shortValue(BigDecimal bigDecimal) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65633, null, bigDecimal)) == null) {
            if (bigDecimal == null) {
                return (short) 0;
            }
            int scale = bigDecimal.scale();
            if (scale >= -100 && scale <= 100) {
                return bigDecimal.shortValue();
            }
            return bigDecimal.shortValueExact();
        }
        return invokeL.shortValue;
    }

    public static Locale toLocale(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65634, null, str)) == null) {
            String[] split = str.split("_");
            if (split.length == 1) {
                return new Locale(split[0]);
            }
            if (split.length == 2) {
                return new Locale(split[0], split[1]);
            }
            return new Locale(split[0], split[1], split[2]);
        }
        return (Locale) invokeL.objValue;
    }

    public static Type unwrapOptional(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65635, null, type)) == null) {
            if (!optionalClassInited) {
                try {
                    optionalClass = Class.forName("java.util.Optional");
                } catch (Exception unused) {
                } catch (Throwable th) {
                    optionalClassInited = true;
                    throw th;
                }
                optionalClassInited = true;
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                return parameterizedType.getRawType() == optionalClass ? parameterizedType.getActualTypeArguments()[0] : type;
            }
            return type;
        }
        return (Type) invokeL.objValue;
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, boolean z) {
        InterceptResult invokeCommon;
        PropertyNamingStrategy propertyNamingStrategy2;
        String[] strArr;
        String str;
        String str2;
        int i2;
        List<FieldInfo> computeGetters;
        List<FieldInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{cls, map, propertyNamingStrategy, Boolean.valueOf(z)})) == null) {
            JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
            String str3 = null;
            if (jSONType != null) {
                String[] orders = jSONType.orders();
                String typeName = jSONType.typeName();
                if (typeName.length() == 0) {
                    typeName = null;
                }
                PropertyNamingStrategy naming = jSONType.naming();
                if (naming == PropertyNamingStrategy.CamelCase) {
                    naming = propertyNamingStrategy;
                }
                int of = SerializerFeature.of(jSONType.serialzeFeatures());
                String str4 = null;
                for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                    JSONType jSONType2 = (JSONType) getAnnotation(superclass, JSONType.class);
                    if (jSONType2 == null) {
                        break;
                    }
                    str4 = jSONType2.typeKey();
                    if (str4.length() != 0) {
                        break;
                    }
                }
                for (Class<?> cls2 : cls.getInterfaces()) {
                    JSONType jSONType3 = (JSONType) getAnnotation(cls2, JSONType.class);
                    if (jSONType3 != null) {
                        str4 = jSONType3.typeKey();
                        if (str4.length() != 0) {
                            break;
                        }
                    }
                }
                if (str4 == null || str4.length() != 0) {
                    str3 = str4;
                }
                str2 = str3;
                strArr = orders;
                str = typeName;
                propertyNamingStrategy2 = naming;
                i2 = of;
            } else {
                propertyNamingStrategy2 = propertyNamingStrategy;
                strArr = null;
                str = null;
                str2 = null;
                i2 = 0;
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
            if (strArr == null || strArr.length == 0) {
                ArrayList arrayList = new ArrayList(computeGetters);
                Collections.sort(arrayList);
                list = arrayList;
            } else if (z) {
                list = computeGettersWithFieldBase(cls, map, true, propertyNamingStrategy2);
            } else {
                list = computeGetters(cls, jSONType, map, hashMap, true, propertyNamingStrategy2);
            }
            FieldInfo[] fieldInfoArr2 = new FieldInfo[list.size()];
            list.toArray(fieldInfoArr2);
            return new SerializeBeanInfo(cls, jSONType, str, str2, i2, fieldInfoArr, Arrays.equals(fieldInfoArr2, fieldInfoArr) ? fieldInfoArr : fieldInfoArr2);
        }
        return (SerializeBeanInfo) invokeCommon.objValue;
    }

    public static Date castToDate(Object obj, String str) {
        InterceptResult invokeLL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, obj, str)) == null) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Date) {
                return (Date) obj;
            }
            if (obj instanceof Calendar) {
                return ((Calendar) obj).getTime();
            }
            if (obj instanceof BigDecimal) {
                return new Date(longValue((BigDecimal) obj));
            }
            if (obj instanceof Number) {
                long longValue = ((Number) obj).longValue();
                if ("unixtime".equals(str)) {
                    longValue *= 1000;
                }
                return new Date(longValue);
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
                    if (str2.indexOf(45) <= 0 && str2.indexOf(43) <= 0 && str == null) {
                        if (str2.length() == 0) {
                            return null;
                        }
                        j2 = Long.parseLong(str2);
                    } else {
                        if (str == null) {
                            int length = str2.length();
                            if (length == JSON.DEFFAULT_DATE_FORMAT.length() || (length == 22 && JSON.DEFFAULT_DATE_FORMAT.equals("yyyyMMddHHmmssSSSZ"))) {
                                str = JSON.DEFFAULT_DATE_FORMAT;
                            } else if (length == 10) {
                                str = "yyyy-MM-dd";
                            } else if (length == 19) {
                                str = "yyyy-MM-dd HH:mm:ss";
                            } else if (length == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') {
                                str = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
                            } else {
                                str = (length == 23 && str2.charAt(19) == ',') ? "yyyy-MM-dd HH:mm:ss,SSS" : "yyyy-MM-dd HH:mm:ss.SSS";
                            }
                        }
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                        simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                        try {
                            return simpleDateFormat.parse(str2);
                        } catch (ParseException unused) {
                            throw new JSONException("can not cast to Date, value : " + str2);
                        }
                    }
                } finally {
                    jSONScanner.close();
                }
            } else {
                j2 = -1;
            }
            if (j2 == -1) {
                Class<?> cls = obj.getClass();
                if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
                    if (oracleTimestampMethod == null && !oracleTimestampMethodInited) {
                        try {
                            oracleTimestampMethod = cls.getMethod("toJdbc", new Class[0]);
                        } catch (NoSuchMethodException unused2) {
                        } catch (Throwable th) {
                            oracleTimestampMethodInited = true;
                            throw th;
                        }
                        oracleTimestampMethodInited = true;
                    }
                    try {
                        return (Date) oracleTimestampMethod.invoke(obj, new Object[0]);
                    } catch (Exception e2) {
                        throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e2);
                    }
                } else if ("oracle.sql.DATE".equals(cls.getName())) {
                    if (oracleDateMethod == null && !oracleDateMethodInited) {
                        try {
                            oracleDateMethod = cls.getMethod("toJdbc", new Class[0]);
                        } catch (NoSuchMethodException unused3) {
                        } catch (Throwable th2) {
                            oracleDateMethodInited = true;
                            throw th2;
                        }
                        oracleDateMethodInited = true;
                    }
                    try {
                        return (Date) oracleDateMethod.invoke(obj, new Object[0]);
                    } catch (Exception e3) {
                        throw new JSONException("can not cast oracle.sql.DATE to Date", e3);
                    }
                } else {
                    throw new JSONException("can not cast to Date, value : " + obj);
                }
            }
            return new Date(j2);
        }
        return (Date) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<java.lang.String, java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        InterceptResult invokeLLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, map, cls, parserConfig)) == null) {
            int i2 = 0;
            try {
                if (cls == StackTraceElement.class) {
                    String str = (String) map.get(PushClientConstants.TAG_CLASS_NAME);
                    String str2 = (String) map.get("methodName");
                    String str3 = (String) map.get("fileName");
                    Number number = (Number) map.get("lineNumber");
                    if (number != null) {
                        if (number instanceof BigDecimal) {
                            i2 = ((BigDecimal) number).intValueExact();
                        } else {
                            i2 = number.intValue();
                        }
                    }
                    return (T) new StackTraceElement(str, str2, str3, i2);
                }
                Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
                if (obj instanceof String) {
                    String str4 = (String) obj;
                    if (parserConfig == null) {
                        parserConfig = ParserConfig.global;
                    }
                    Class<?> checkAutoType = parserConfig.checkAutoType(str4, null);
                    if (checkAutoType != null) {
                        if (!checkAutoType.equals(cls)) {
                            return (T) castToJavaBean(map, checkAutoType, parserConfig);
                        }
                    } else {
                        throw new ClassNotFoundException(str4 + " not found");
                    }
                }
                if (cls.isInterface()) {
                    if (map instanceof JSONObject) {
                        jSONObject = (JSONObject) map;
                    } else {
                        jSONObject = new JSONObject(map);
                    }
                    if (parserConfig == null) {
                        parserConfig = ParserConfig.getGlobalInstance();
                    }
                    return parserConfig.get(cls) != null ? (T) JSON.parseObject(JSON.toJSONString(jSONObject), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
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
                if (cls == JSON.class && (map instanceof JSONObject)) {
                    return map;
                }
                if (cls == LinkedHashMap.class && (map instanceof JSONObject)) {
                    T t = (T) ((JSONObject) map).getInnerMap();
                    if (t instanceof LinkedHashMap) {
                        return t;
                    }
                }
                if (cls.isInstance(map)) {
                    return map;
                }
                if (cls == JSONObject.class) {
                    return (T) new JSONObject(map);
                }
                if (parserConfig == null) {
                    parserConfig = ParserConfig.getGlobalInstance();
                }
                ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
                JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
                if (javaBeanDeserializer != null) {
                    return (T) javaBeanDeserializer.createInstance(map, parserConfig);
                }
                throw new JSONException("can not get javaBeanDeserializer. " + cls.getName());
            } catch (Exception e2) {
                throw new JSONException(e2.getMessage(), e2);
            }
        }
        return (T) invokeLLL.objValue;
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65571, null, cls, map, z)) == null) {
            HashMap hashMap = new HashMap();
            ParserConfig.parserAllFieldToCache(cls, hashMap);
            return computeGetters(cls, (JSONType) getAnnotation(cls, JSONType.class), map, hashMap, z, PropertyNamingStrategy.CamelCase);
        }
        return (List) invokeLLZ.objValue;
    }

    public static Constructor getKotlinConstructor(Constructor[] constructorArr, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65595, null, constructorArr, strArr)) == null) {
            Constructor constructor = null;
            for (Constructor constructor2 : constructorArr) {
                Class<?>[] parameterTypes = constructor2.getParameterTypes();
                if ((strArr == null || parameterTypes.length == strArr.length) && ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("kotlin.jvm.internal.DefaultConstructorMarker")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length))) {
                    constructor = constructor2;
                }
            }
            return constructor;
        }
        return (Constructor) invokeLL.objValue;
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65622, null, str, classLoader)) == null) ? loadClass(str, classLoader, false) : (Class) invokeLL.objValue;
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65623, null, str, classLoader, z)) == null) {
            if (str == null || str.length() == 0) {
                return null;
            }
            if (str.length() <= 198) {
                Class<?> cls = mappings.get(str);
                if (cls != null) {
                    return cls;
                }
                if (str.charAt(0) == '[') {
                    return Array.newInstance(loadClass(str.substring(1), classLoader), 0).getClass();
                }
                if (str.startsWith("L") && str.endsWith(";")) {
                    return loadClass(str.substring(1, str.length() - 1), classLoader);
                }
                if (classLoader != null) {
                    try {
                        cls = classLoader.loadClass(str);
                        if (z) {
                            mappings.put(str, cls);
                        }
                        return cls;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                try {
                    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                    if (contextClassLoader != null && contextClassLoader != classLoader) {
                        Class<?> loadClass = contextClassLoader.loadClass(str);
                        if (z) {
                            try {
                                mappings.put(str, loadClass);
                            } catch (Throwable unused) {
                                cls = loadClass;
                            }
                        }
                        return loadClass;
                    }
                } catch (Throwable unused2) {
                }
                try {
                    cls = Class.forName(str);
                    if (z) {
                        mappings.put(str, cls);
                    }
                } catch (Throwable unused3) {
                }
                return cls;
            }
            throw new JSONException("illegal className : " + str);
        }
        return (Class) invokeLLZ.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x02a3, code lost:
        if (r2 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0332, code lost:
        if (r11 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0450, code lost:
        if (r3 == null) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x04aa, code lost:
        if (r1 == null) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
        if (r4.getName().equals("groovy.lang.MetaClass") != false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x045e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<FieldInfo> computeGetters(Class<?> cls, JSONType jSONType, Map<String, String> map, Map<String, Field> map2, boolean z, PropertyNamingStrategy propertyNamingStrategy) {
        InterceptResult invokeCommon;
        String[] strArr;
        Class<?> cls2;
        int i2;
        Constructor<?>[] constructorArr;
        short[] sArr;
        Annotation[][] annotationArr;
        JSONField jSONField;
        int i3;
        Method[] methodArr;
        LinkedHashMap linkedHashMap;
        int i4;
        int i5;
        int i6;
        String str;
        LinkedHashMap linkedHashMap2;
        Class<?> cls3;
        int i7;
        Method method;
        LinkedHashMap linkedHashMap3;
        String substring;
        Field fieldFromCache;
        int i8;
        int i9;
        int i10;
        JSONField jSONField2;
        String propertyNameByMethodName;
        String propertyNameByCompatibleFieldName;
        Field field;
        int i11;
        JSONField jSONField3;
        String str2;
        Boolean bool;
        int i12;
        int i13;
        String str3;
        Boolean bool2;
        char charAt;
        Field fieldFromCache2;
        String[] strArr2;
        short[] sArr2;
        Annotation[][] annotationArr2;
        Field fieldFromCache3;
        Constructor kotlinConstructor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65569, null, new Object[]{cls, jSONType, map, map2, Boolean.valueOf(z), propertyNamingStrategy})) == null) {
            Class<?> cls4 = cls;
            Map<String, String> map3 = map;
            Map<String, Field> map4 = map2;
            PropertyNamingStrategy propertyNamingStrategy2 = propertyNamingStrategy;
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            boolean isKotlin = isKotlin(cls);
            Method[] methods = cls.getMethods();
            int length = methods.length;
            Constructor<?>[] constructorArr2 = null;
            String[] strArr3 = null;
            short[] sArr3 = null;
            Annotation[][] annotationArr3 = null;
            int i14 = 0;
            while (i14 < length) {
                Method method2 = methods[i14];
                String name = method2.getName();
                if (!Modifier.isStatic(method2.getModifiers())) {
                    Class<?> returnType = method2.getReturnType();
                    if (!returnType.equals(Void.TYPE) && method2.getParameterTypes().length == 0 && returnType != ClassLoader.class && returnType != InputStream.class && returnType != Reader.class) {
                        if (name.equals("getMetaClass")) {
                            strArr = strArr3;
                        } else {
                            strArr = strArr3;
                        }
                        if ((!name.equals("getSuppressed") || method2.getDeclaringClass() != Throwable.class) && (!isKotlin || !isKotlinIgnore(cls4, name))) {
                            Boolean bool3 = Boolean.FALSE;
                            JSONField jSONField4 = (JSONField) getAnnotation(method2, JSONField.class);
                            if (jSONField4 == null) {
                                jSONField4 = getSuperMethodAnnotation(cls4, method2);
                            }
                            LinkedHashMap linkedHashMap5 = linkedHashMap4;
                            if (jSONField4 == null && isKotlin) {
                                if (constructorArr2 == null && (kotlinConstructor = getKotlinConstructor((constructorArr2 = cls.getDeclaredConstructors()))) != null) {
                                    annotationArr3 = getParameterAnnotations(kotlinConstructor);
                                    strArr2 = getKoltinConstructorParameters(cls);
                                    if (strArr2 != null) {
                                        String[] strArr4 = new String[strArr2.length];
                                        System.arraycopy(strArr2, 0, strArr4, 0, strArr2.length);
                                        Arrays.sort(strArr4);
                                        short[] sArr4 = new short[strArr2.length];
                                        cls2 = returnType;
                                        for (short s = 0; s < strArr2.length; s = (short) (s + 1)) {
                                            sArr4[Arrays.binarySearch(strArr4, strArr2[s])] = s;
                                        }
                                        strArr2 = strArr4;
                                        annotationArr3 = annotationArr3;
                                        sArr3 = sArr4;
                                        constructorArr2 = constructorArr2;
                                    } else {
                                        cls2 = returnType;
                                    }
                                    if (strArr2 == null && sArr3 != null && name.startsWith("get")) {
                                        String decapitalize = decapitalize(name.substring(3));
                                        int binarySearch = Arrays.binarySearch(strArr2, decapitalize);
                                        constructorArr = constructorArr2;
                                        i2 = i14;
                                        if (binarySearch < 0) {
                                            int i15 = 0;
                                            while (true) {
                                                if (i15 >= strArr2.length) {
                                                    break;
                                                } else if (decapitalize.equalsIgnoreCase(strArr2[i15])) {
                                                    binarySearch = i15;
                                                    break;
                                                } else {
                                                    i15++;
                                                }
                                            }
                                        }
                                        if (binarySearch >= 0) {
                                            Annotation[] annotationArr4 = annotationArr3[sArr3[binarySearch]];
                                            if (annotationArr4 != null) {
                                                int length2 = annotationArr4.length;
                                                sArr2 = sArr3;
                                                int i16 = 0;
                                                while (true) {
                                                    annotationArr2 = annotationArr3;
                                                    if (i16 >= length2) {
                                                        break;
                                                    }
                                                    Annotation annotation = annotationArr4[i16];
                                                    Annotation[] annotationArr5 = annotationArr4;
                                                    if (annotation instanceof JSONField) {
                                                        jSONField4 = (JSONField) annotation;
                                                        break;
                                                    }
                                                    i16++;
                                                    annotationArr3 = annotationArr2;
                                                    annotationArr4 = annotationArr5;
                                                }
                                            } else {
                                                sArr2 = sArr3;
                                                annotationArr2 = annotationArr3;
                                            }
                                            if (jSONField4 == null && (fieldFromCache3 = ParserConfig.getFieldFromCache(decapitalize, map4)) != null) {
                                                jSONField = (JSONField) getAnnotation(fieldFromCache3, JSONField.class);
                                                annotationArr = annotationArr2;
                                                sArr = sArr2;
                                                strArr = strArr2;
                                            }
                                        } else {
                                            sArr2 = sArr3;
                                            annotationArr2 = annotationArr3;
                                        }
                                    } else {
                                        constructorArr = constructorArr2;
                                        sArr2 = sArr3;
                                        annotationArr2 = annotationArr3;
                                        i2 = i14;
                                    }
                                    jSONField = jSONField4;
                                    annotationArr = annotationArr2;
                                    sArr = sArr2;
                                    strArr = strArr2;
                                }
                                cls2 = returnType;
                                strArr2 = strArr;
                                if (strArr2 == null) {
                                }
                                constructorArr = constructorArr2;
                                sArr2 = sArr3;
                                annotationArr2 = annotationArr3;
                                i2 = i14;
                                jSONField = jSONField4;
                                annotationArr = annotationArr2;
                                sArr = sArr2;
                                strArr = strArr2;
                            } else {
                                cls2 = returnType;
                                i2 = i14;
                                constructorArr = constructorArr2;
                                sArr = sArr3;
                                annotationArr = annotationArr3;
                                jSONField = jSONField4;
                            }
                            if (jSONField != null) {
                                if (jSONField.serialize()) {
                                    int ordinal = jSONField.ordinal();
                                    int of = SerializerFeature.of(jSONField.serialzeFeatures());
                                    i6 = Feature.of(jSONField.parseFeatures());
                                    if (jSONField.name().length() != 0) {
                                        String name2 = jSONField.name();
                                        if (map3 == null || (name2 = map3.get(name2)) != null) {
                                            String str4 = name2;
                                            i3 = length;
                                            methodArr = methods;
                                            linkedHashMap = linkedHashMap5;
                                            linkedHashMap.put(str4, new FieldInfo(str4, method2, null, cls, null, ordinal, of, i6, jSONField, null, null));
                                            linkedHashMap3 = linkedHashMap;
                                            propertyNamingStrategy2 = propertyNamingStrategy;
                                            constructorArr2 = constructorArr;
                                            sArr3 = sArr;
                                            annotationArr3 = annotationArr;
                                            i14 = i2 + 1;
                                            map4 = map2;
                                            linkedHashMap4 = linkedHashMap3;
                                            strArr3 = strArr;
                                            length = i3;
                                            methods = methodArr;
                                        }
                                    } else {
                                        i3 = length;
                                        methodArr = methods;
                                        linkedHashMap = linkedHashMap5;
                                        r18 = jSONField.label().length() != 0 ? jSONField.label() : null;
                                        i4 = of;
                                        i5 = ordinal;
                                    }
                                }
                                i3 = length;
                                methodArr = methods;
                                linkedHashMap3 = linkedHashMap5;
                                constructorArr2 = constructorArr;
                                sArr3 = sArr;
                                annotationArr3 = annotationArr;
                                i14 = i2 + 1;
                                map4 = map2;
                                linkedHashMap4 = linkedHashMap3;
                                strArr3 = strArr;
                                length = i3;
                                methods = methodArr;
                            } else {
                                i3 = length;
                                methodArr = methods;
                                linkedHashMap = linkedHashMap5;
                                i4 = 0;
                                i5 = 0;
                                i6 = 0;
                            }
                            if (name.startsWith("get")) {
                                if (name.length() >= 4 && !name.equals("getClass") && (!name.equals("getDeclaringClass") || !cls.isEnum())) {
                                    char charAt2 = name.charAt(3);
                                    if (Character.isUpperCase(charAt2) || charAt2 > 512) {
                                        if (compatibleWithJavaBean) {
                                            propertyNameByMethodName = decapitalize(name.substring(3));
                                        } else {
                                            propertyNameByMethodName = getPropertyNameByMethodName(name);
                                        }
                                        propertyNameByCompatibleFieldName = getPropertyNameByCompatibleFieldName(map4, name, propertyNameByMethodName, 3);
                                    } else {
                                        if (charAt2 == '_') {
                                            propertyNameByCompatibleFieldName = name.substring(3);
                                            field = map4.get(propertyNameByCompatibleFieldName);
                                            if (field == null) {
                                                String substring2 = name.substring(4);
                                                fieldFromCache2 = ParserConfig.getFieldFromCache(substring2, map4);
                                                if (fieldFromCache2 != null) {
                                                    propertyNameByCompatibleFieldName = substring2;
                                                }
                                            }
                                            if (!isJSONTypeIgnore(cls4, propertyNameByCompatibleFieldName)) {
                                                if (field == null) {
                                                    field = ParserConfig.getFieldFromCache(propertyNameByCompatibleFieldName, map4);
                                                }
                                                if (field == null && propertyNameByCompatibleFieldName.length() > 1 && (charAt = propertyNameByCompatibleFieldName.charAt(1)) >= 'A' && charAt <= 'Z') {
                                                    field = ParserConfig.getFieldFromCache(decapitalize(name.substring(3)), map4);
                                                }
                                                Field field2 = field;
                                                if (field2 != null) {
                                                    JSONField jSONField5 = (JSONField) getAnnotation(field2, JSONField.class);
                                                    if (jSONField5 == null) {
                                                        i11 = i6;
                                                        str2 = r18;
                                                        i12 = i4;
                                                        jSONField3 = jSONField5;
                                                        bool = bool3;
                                                    } else if (jSONField5.serialize()) {
                                                        int ordinal2 = jSONField5.ordinal();
                                                        int of2 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                                        int of3 = Feature.of(jSONField5.parseFeatures());
                                                        if (jSONField5.name().length() != 0) {
                                                            bool2 = Boolean.TRUE;
                                                            str3 = jSONField5.name();
                                                            if (map3 != null) {
                                                                str3 = map3.get(str3);
                                                            }
                                                        } else {
                                                            str3 = propertyNameByCompatibleFieldName;
                                                            bool2 = bool3;
                                                        }
                                                        if (jSONField5.label().length() != 0) {
                                                            r18 = jSONField5.label();
                                                        }
                                                        i13 = ordinal2;
                                                        i11 = of3;
                                                        str2 = r18;
                                                        i12 = of2;
                                                        String str5 = str3;
                                                        jSONField3 = jSONField5;
                                                        bool = bool2;
                                                        propertyNameByCompatibleFieldName = str5;
                                                        if (map3 != null || (propertyNameByCompatibleFieldName = map3.get(propertyNameByCompatibleFieldName)) != null) {
                                                            LinkedHashMap linkedHashMap6 = linkedHashMap;
                                                            if (propertyNamingStrategy != null && !bool.booleanValue()) {
                                                                propertyNameByCompatibleFieldName = propertyNamingStrategy.translate(propertyNameByCompatibleFieldName);
                                                            }
                                                            cls3 = cls2;
                                                            str = name;
                                                            method = method2;
                                                            i7 = 3;
                                                            linkedHashMap2 = linkedHashMap6;
                                                            linkedHashMap2.put(propertyNameByCompatibleFieldName, new FieldInfo(propertyNameByCompatibleFieldName, method2, field2, cls, null, i13, i12, i11, jSONField, jSONField3, str2));
                                                            i4 = i12;
                                                            i5 = i13;
                                                            i6 = i11;
                                                            r18 = str2;
                                                        }
                                                    }
                                                } else {
                                                    i11 = i6;
                                                    jSONField3 = null;
                                                    str2 = r18;
                                                    bool = bool3;
                                                    i12 = i4;
                                                }
                                                i13 = i5;
                                                if (map3 != null) {
                                                }
                                                LinkedHashMap linkedHashMap62 = linkedHashMap;
                                                if (propertyNamingStrategy != null) {
                                                    propertyNameByCompatibleFieldName = propertyNamingStrategy.translate(propertyNameByCompatibleFieldName);
                                                }
                                                cls3 = cls2;
                                                str = name;
                                                method = method2;
                                                i7 = 3;
                                                linkedHashMap2 = linkedHashMap62;
                                                linkedHashMap2.put(propertyNameByCompatibleFieldName, new FieldInfo(propertyNameByCompatibleFieldName, method2, field2, cls, null, i13, i12, i11, jSONField, jSONField3, str2));
                                                i4 = i12;
                                                i5 = i13;
                                                i6 = i11;
                                                r18 = str2;
                                            }
                                        } else if (charAt2 == 'f') {
                                            propertyNameByCompatibleFieldName = name.substring(3);
                                        } else if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                                            propertyNameByCompatibleFieldName = decapitalize(name.substring(3));
                                        } else {
                                            propertyNameByCompatibleFieldName = name.substring(3);
                                            fieldFromCache2 = ParserConfig.getFieldFromCache(propertyNameByCompatibleFieldName, map4);
                                        }
                                        field = fieldFromCache2;
                                        if (!isJSONTypeIgnore(cls4, propertyNameByCompatibleFieldName)) {
                                        }
                                    }
                                    field = null;
                                    if (!isJSONTypeIgnore(cls4, propertyNameByCompatibleFieldName)) {
                                    }
                                }
                                linkedHashMap3 = linkedHashMap;
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                constructorArr2 = constructorArr;
                                sArr3 = sArr;
                                annotationArr3 = annotationArr;
                                i14 = i2 + 1;
                                map4 = map2;
                                linkedHashMap4 = linkedHashMap3;
                                strArr3 = strArr;
                                length = i3;
                                methods = methodArr;
                            } else {
                                str = name;
                                linkedHashMap2 = linkedHashMap;
                                cls3 = cls2;
                                i7 = 3;
                                method = method2;
                            }
                            if (str.startsWith("is") && str.length() >= i7 && (cls3 == Boolean.TYPE || cls3 == Boolean.class)) {
                                char charAt3 = str.charAt(2);
                                if (Character.isUpperCase(charAt3)) {
                                    substring = getPropertyNameByCompatibleFieldName(map4, str, compatibleWithJavaBean ? decapitalize(str.substring(2)) : Character.toLowerCase(str.charAt(2)) + str.substring(i7), 2);
                                } else {
                                    if (charAt3 == '_') {
                                        String substring3 = str.substring(i7);
                                        fieldFromCache = map4.get(substring3);
                                        if (fieldFromCache == null) {
                                            substring = str.substring(2);
                                            fieldFromCache = ParserConfig.getFieldFromCache(substring, map4);
                                            if (fieldFromCache == null) {
                                                substring = substring3;
                                            }
                                        } else {
                                            cls4 = cls;
                                            substring = substring3;
                                            if (!isJSONTypeIgnore(cls4, substring)) {
                                                if (fieldFromCache == null) {
                                                    fieldFromCache = ParserConfig.getFieldFromCache(substring, map4);
                                                }
                                                if (fieldFromCache == null) {
                                                    fieldFromCache = ParserConfig.getFieldFromCache(str, map4);
                                                }
                                                if (fieldFromCache != null) {
                                                    JSONField jSONField6 = (JSONField) getAnnotation(fieldFromCache, JSONField.class);
                                                    if (jSONField6 == null) {
                                                        map3 = map;
                                                        i8 = i4;
                                                        i9 = i5;
                                                        i10 = i6;
                                                        jSONField2 = jSONField6;
                                                    } else if (jSONField6.serialize()) {
                                                        int ordinal3 = jSONField6.ordinal();
                                                        int of4 = SerializerFeature.of(jSONField6.serialzeFeatures());
                                                        int of5 = Feature.of(jSONField6.parseFeatures());
                                                        if (jSONField6.name().length() != 0) {
                                                            substring = jSONField6.name();
                                                            map3 = map;
                                                            if (map3 != null) {
                                                                substring = map3.get(substring);
                                                            }
                                                        } else {
                                                            map3 = map;
                                                        }
                                                        if (jSONField6.label().length() != 0) {
                                                            jSONField2 = jSONField6;
                                                            i8 = of4;
                                                            i10 = of5;
                                                            r18 = jSONField6.label();
                                                            i9 = ordinal3;
                                                        } else {
                                                            i9 = ordinal3;
                                                            jSONField2 = jSONField6;
                                                            i8 = of4;
                                                            i10 = of5;
                                                        }
                                                    }
                                                } else {
                                                    map3 = map;
                                                    i8 = i4;
                                                    i9 = i5;
                                                    i10 = i6;
                                                    jSONField2 = null;
                                                }
                                                if (map3 == null || (substring = map3.get(substring)) != null) {
                                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                                    if (propertyNamingStrategy2 != null) {
                                                        substring = propertyNamingStrategy2.translate(substring);
                                                    }
                                                    String str6 = substring;
                                                    if (!linkedHashMap2.containsKey(str6)) {
                                                        linkedHashMap3 = linkedHashMap2;
                                                        linkedHashMap3.put(str6, new FieldInfo(str6, method, fieldFromCache, cls, null, i9, i8, i10, jSONField, jSONField2, r18));
                                                        constructorArr2 = constructorArr;
                                                        sArr3 = sArr;
                                                        annotationArr3 = annotationArr;
                                                        i14 = i2 + 1;
                                                        map4 = map2;
                                                        linkedHashMap4 = linkedHashMap3;
                                                        strArr3 = strArr;
                                                        length = i3;
                                                        methods = methodArr;
                                                    }
                                                    linkedHashMap3 = linkedHashMap2;
                                                    constructorArr2 = constructorArr;
                                                    sArr3 = sArr;
                                                    annotationArr3 = annotationArr;
                                                    i14 = i2 + 1;
                                                    map4 = map2;
                                                    linkedHashMap4 = linkedHashMap3;
                                                    strArr3 = strArr;
                                                    length = i3;
                                                    methods = methodArr;
                                                }
                                                propertyNamingStrategy2 = propertyNamingStrategy;
                                                linkedHashMap3 = linkedHashMap2;
                                                constructorArr2 = constructorArr;
                                                sArr3 = sArr;
                                                annotationArr3 = annotationArr;
                                                i14 = i2 + 1;
                                                map4 = map2;
                                                linkedHashMap4 = linkedHashMap3;
                                                strArr3 = strArr;
                                                length = i3;
                                                methods = methodArr;
                                            }
                                            map3 = map;
                                            propertyNamingStrategy2 = propertyNamingStrategy;
                                            linkedHashMap3 = linkedHashMap2;
                                            constructorArr2 = constructorArr;
                                            sArr3 = sArr;
                                            annotationArr3 = annotationArr;
                                            i14 = i2 + 1;
                                            map4 = map2;
                                            linkedHashMap4 = linkedHashMap3;
                                            strArr3 = strArr;
                                            length = i3;
                                            methods = methodArr;
                                        }
                                    } else if (charAt3 == 'f') {
                                        substring = str.substring(2);
                                    } else {
                                        substring = str.substring(2);
                                        fieldFromCache = ParserConfig.getFieldFromCache(substring, map4);
                                    }
                                    cls4 = cls;
                                    if (!isJSONTypeIgnore(cls4, substring)) {
                                    }
                                    map3 = map;
                                    propertyNamingStrategy2 = propertyNamingStrategy;
                                    linkedHashMap3 = linkedHashMap2;
                                    constructorArr2 = constructorArr;
                                    sArr3 = sArr;
                                    annotationArr3 = annotationArr;
                                    i14 = i2 + 1;
                                    map4 = map2;
                                    linkedHashMap4 = linkedHashMap3;
                                    strArr3 = strArr;
                                    length = i3;
                                    methods = methodArr;
                                }
                                cls4 = cls;
                                fieldFromCache = null;
                                if (!isJSONTypeIgnore(cls4, substring)) {
                                }
                                map3 = map;
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                linkedHashMap3 = linkedHashMap2;
                                constructorArr2 = constructorArr;
                                sArr3 = sArr;
                                annotationArr3 = annotationArr;
                                i14 = i2 + 1;
                                map4 = map2;
                                linkedHashMap4 = linkedHashMap3;
                                strArr3 = strArr;
                                length = i3;
                                methods = methodArr;
                            }
                            cls4 = cls;
                            map3 = map;
                            propertyNamingStrategy2 = propertyNamingStrategy;
                            linkedHashMap3 = linkedHashMap2;
                            constructorArr2 = constructorArr;
                            sArr3 = sArr;
                            annotationArr3 = annotationArr;
                            i14 = i2 + 1;
                            map4 = map2;
                            linkedHashMap4 = linkedHashMap3;
                            strArr3 = strArr;
                            length = i3;
                            methods = methodArr;
                        }
                        i2 = i14;
                        i3 = length;
                        methodArr = methods;
                        linkedHashMap3 = linkedHashMap4;
                        i14 = i2 + 1;
                        map4 = map2;
                        linkedHashMap4 = linkedHashMap3;
                        strArr3 = strArr;
                        length = i3;
                        methods = methodArr;
                    }
                }
                strArr = strArr3;
                i2 = i14;
                i3 = length;
                methodArr = methods;
                linkedHashMap3 = linkedHashMap4;
                i14 = i2 + 1;
                map4 = map2;
                linkedHashMap4 = linkedHashMap3;
                strArr3 = strArr;
                length = i3;
                methods = methodArr;
            }
            LinkedHashMap linkedHashMap7 = linkedHashMap4;
            computeFields(cls4, map3, propertyNamingStrategy2, linkedHashMap7, cls.getFields());
            return getFieldInfos(cls4, z, linkedHashMap7);
        }
        return (List) invokeCommon.objValue;
    }

    public static Type getCollectionItemType(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65586, null, cls)) == null) ? cls.getName().startsWith("java.") ? Object.class : getCollectionItemType(getCollectionSuperType(cls)) : (Type) invokeL.objValue;
    }

    public static Type getCollectionItemType(ParameterizedType parameterizedType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, parameterizedType)) == null) {
            Type rawType = parameterizedType.getRawType();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (rawType == Collection.class) {
                return getWildcardTypeUpperBounds(actualTypeArguments[0]);
            }
            Class cls = (Class) rawType;
            Map<TypeVariable, Type> createActualTypeMap = createActualTypeMap(cls.getTypeParameters(), actualTypeArguments);
            Type collectionSuperType = getCollectionSuperType(cls);
            if (collectionSuperType instanceof ParameterizedType) {
                Class<?> rawClass = getRawClass(collectionSuperType);
                Type[] actualTypeArguments2 = ((ParameterizedType) collectionSuperType).getActualTypeArguments();
                if (actualTypeArguments2.length > 0) {
                    return getCollectionItemType(makeParameterizedType(rawClass, actualTypeArguments2, createActualTypeMap));
                }
                return getCollectionItemType(rawClass);
            }
            return getCollectionItemType((Class<?>) collectionSuperType);
        }
        return (Type) invokeL.objValue;
    }

    public static Annotation[][] getParameterAnnotations(Constructor constructor) {
        InterceptResult invokeL;
        Annotation[][] parameterAnnotations;
        Constructor declaredConstructor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, null, constructor)) == null) {
            Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
            Type mixInAnnotations = JSON.getMixInAnnotations(constructor.getDeclaringClass());
            Constructor constructor2 = null;
            Class cls = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
            if (cls != null) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                ArrayList arrayList = new ArrayList(2);
                for (Class<?> enclosingClass = cls.getEnclosingClass(); enclosingClass != null; enclosingClass = enclosingClass.getEnclosingClass()) {
                    arrayList.add(enclosingClass);
                }
                int size = arrayList.size();
                Class cls2 = cls;
                while (true) {
                    if (cls2 == null || cls2 == Object.class) {
                        break;
                    }
                    try {
                        if (size != 0) {
                            Class<?>[] clsArr = new Class[parameterTypes.length + size];
                            System.arraycopy(parameterTypes, 0, clsArr, size, parameterTypes.length);
                            for (int i2 = size; i2 > 0; i2--) {
                                int i3 = i2 - 1;
                                clsArr[i3] = (Class) arrayList.get(i3);
                            }
                            declaredConstructor = cls.getDeclaredConstructor(clsArr);
                        } else {
                            declaredConstructor = cls.getDeclaredConstructor(parameterTypes);
                        }
                        constructor2 = declaredConstructor;
                    } catch (NoSuchMethodException unused) {
                        size--;
                        cls2 = cls2.getSuperclass();
                    }
                }
                if (constructor2 != null && (parameterAnnotations = constructor2.getParameterAnnotations()) != null) {
                    return parameterAnnotations;
                }
            }
            return parameterAnnotations2;
        }
        return (Annotation[][]) invokeL.objValue;
    }

    public static <A extends Annotation> A getAnnotation(Field field, Class<A> cls) {
        InterceptResult invokeLL;
        A a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65581, null, field, cls)) == null) {
            A a2 = (A) field.getAnnotation(cls);
            Type mixInAnnotations = JSON.getMixInAnnotations(field.getDeclaringClass());
            Field field2 = null;
            Class cls2 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
            if (cls2 != null) {
                String name = field.getName();
                while (cls2 != null && cls2 != Object.class) {
                    try {
                        field2 = cls2.getDeclaredField(name);
                        break;
                    } catch (NoSuchFieldException unused) {
                        cls2 = cls2.getSuperclass();
                    }
                }
                if (field2 != null && (a = (A) field2.getAnnotation(cls)) != null) {
                    return a;
                }
            }
            return a2;
        }
        return (A) invokeLL.objValue;
    }

    public static <A extends Annotation> A getAnnotation(Method method, Class<A> cls) {
        InterceptResult invokeLL;
        A a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65582, null, method, cls)) == null) {
            A a2 = (A) method.getAnnotation(cls);
            Type mixInAnnotations = JSON.getMixInAnnotations(method.getDeclaringClass());
            Method method2 = null;
            Class cls2 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
            if (cls2 != null) {
                String name = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                while (cls2 != null && cls2 != Object.class) {
                    try {
                        method2 = cls2.getDeclaredMethod(name, parameterTypes);
                        break;
                    } catch (NoSuchMethodException unused) {
                        cls2 = cls2.getSuperclass();
                    }
                }
                if (method2 != null && (a = (A) method2.getAnnotation(cls)) != null) {
                    return a;
                }
            }
            return a2;
        }
        return (A) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, obj, type, parserConfig)) == null) {
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
                if (str.length() == 0 || StringUtil.NULL_STRING.equals(str) || "NULL".equals(str)) {
                    return null;
                }
            }
            if (type instanceof TypeVariable) {
                return obj;
            }
            throw new JSONException("can not cast to : " + type);
        }
        return (T) invokeLLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v13, types: [java.util.Map$Entry, T] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List, T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v9, types: [T, java.util.Map, java.util.HashMap] */
    public static <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        InterceptResult invokeLLL;
        Object cast;
        T t;
        Object cast2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, obj, parameterizedType, parserConfig)) == null) {
            Type rawType = parameterizedType.getRawType();
            if (rawType == List.class || rawType == ArrayList.class) {
                Type type = parameterizedType.getActualTypeArguments()[0];
                if (obj instanceof List) {
                    List list = (List) obj;
                    ?? r7 = (T) new ArrayList(list.size());
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        Object obj2 = list.get(i2);
                        if (type instanceof Class) {
                            if (obj2 != null && obj2.getClass() == JSONObject.class) {
                                cast = ((JSONObject) obj2).toJavaObject((Class) type, parserConfig, 0);
                            } else {
                                cast = cast(obj2, (Class<Object>) type, parserConfig);
                            }
                        } else {
                            cast = cast(obj2, type, parserConfig);
                        }
                        r7.add(cast);
                    }
                    return r7;
                }
            }
            if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == Collection.class || rawType == List.class || rawType == ArrayList.class) {
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                if (obj instanceof Iterable) {
                    if (rawType != Set.class && rawType != HashSet.class) {
                        if (rawType == TreeSet.class) {
                            t = (T) new TreeSet();
                        } else {
                            t = (T) new ArrayList();
                        }
                    } else {
                        t = (T) new HashSet();
                    }
                    for (T t2 : (Iterable) obj) {
                        if (type2 instanceof Class) {
                            if (t2 != null && t2.getClass() == JSONObject.class) {
                                cast2 = ((JSONObject) t2).toJavaObject((Class) type2, parserConfig, 0);
                            } else {
                                cast2 = cast((Object) t2, (Class<Object>) type2, parserConfig);
                            }
                        } else {
                            cast2 = cast(t2, type2, parserConfig);
                        }
                        ((Collection) t).add(cast2);
                    }
                    return t;
                }
            }
            if (rawType == Map.class || rawType == HashMap.class) {
                Type type3 = parameterizedType.getActualTypeArguments()[0];
                Type type4 = parameterizedType.getActualTypeArguments()[1];
                if (obj instanceof Map) {
                    ?? r72 = (T) new HashMap();
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        r72.put(cast(entry.getKey(), type3, parserConfig), cast(entry.getValue(), type4, parserConfig));
                    }
                    return r72;
                }
            }
            if ((obj instanceof String) && ((String) obj).length() == 0) {
                return null;
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
                return (T) cast(obj, rawType, parserConfig);
            }
            if (rawType == Map.Entry.class && (obj instanceof Map)) {
                Map map = (Map) obj;
                if (map.size() == 1) {
                    ?? r6 = (T) ((Map.Entry) map.entrySet().iterator().next());
                    Object value = r6.getValue();
                    if (actualTypeArguments.length == 2 && (value instanceof Map)) {
                        r6.setValue(cast(value, actualTypeArguments[1], parserConfig));
                    }
                    return r6;
                }
            }
            if (rawType instanceof Class) {
                if (parserConfig == null) {
                    parserConfig = ParserConfig.global;
                }
                ObjectDeserializer deserializer = parserConfig.getDeserializer(rawType);
                if (deserializer != null) {
                    return (T) deserializer.deserialze(new DefaultJSONParser(JSON.toJSONString(obj), parserConfig), parameterizedType, null);
                }
            }
            throw new JSONException("can not cast to : " + parameterizedType);
        }
        return (T) invokeLLL.objValue;
    }
}
