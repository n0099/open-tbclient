package com.alibaba.fastjson.parser;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ClassReader;
import com.alibaba.fastjson.asm.TypeCollector;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumCreatorDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONPDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessable;
import com.alibaba.fastjson.parser.deserializer.PropertyProcessableDeserializer;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.AwtCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.ByteBufferCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.GuavaCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.JodaCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.spi.Module;
import com.alibaba.fastjson.support.moneta.MonetaCodec;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.alibaba.fastjson.util.ServiceLoader;
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
import com.baidu.webkit.sdk.LoadErrorCode;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.sql.DataSource;
import javax.sql.RowSet;
import javax.xml.datatype.XMLGregorianCalendar;
/* loaded from: classes4.dex */
public class ParserConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTOTYPE_ACCEPT = "fastjson.parser.autoTypeAccept";
    public static final String AUTOTYPE_SUPPORT_PROPERTY = "fastjson.parser.autoTypeSupport";
    public static final boolean AUTO_SUPPORT;
    public static final String[] AUTO_TYPE_ACCEPT_LIST;
    public static final String[] DENYS;
    public static final String[] DENYS_INTERNAL;
    public static final String DENY_PROPERTY = "fastjson.parser.deny";
    public static final String DENY_PROPERTY_INTERNAL = "fastjson.parser.deny.internal";
    public static final long[] INTERNAL_WHITELIST_HASHCODES;
    public static final boolean SAFE_MODE;
    public static final String SAFE_MODE_PROPERTY = "fastjson.parser.safeMode";
    public static boolean awtError;
    public static ParserConfig global;
    public static boolean guavaError;
    public static boolean jdk8Error;
    public static boolean jodaError;
    public transient /* synthetic */ FieldHolder $fh;
    public long[] acceptHashCodes;
    public boolean asmEnable;
    public ASMDeserializerFactory asmFactory;
    public volatile List<AutoTypeCheckHandler> autoTypeCheckHandlers;
    public boolean autoTypeSupport;
    public boolean compatibleWithJavaBean;
    public ClassLoader defaultClassLoader;
    public long[] denyHashCodes;
    public final IdentityHashMap<Type, ObjectDeserializer> deserializers;
    public final boolean fieldBased;
    public long[] internalDenyHashCodes;
    public boolean jacksonCompatible;
    public final IdentityHashMap<Type, IdentityHashMap<Type, ObjectDeserializer>> mixInDeserializers;
    public List<Module> modules;
    public PropertyNamingStrategy propertyNamingStrategy;
    public boolean safeMode;
    public final SymbolTable symbolTable;
    public final ConcurrentMap<String, Class<?>> typeMapping;

    /* loaded from: classes4.dex */
    public interface AutoTypeCheckHandler {
        Class<?> handler(String str, Class<?> cls, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1601444952, "Lcom/alibaba/fastjson/parser/ParserConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1601444952, "Lcom/alibaba/fastjson/parser/ParserConfig;");
                return;
            }
        }
        DENYS_INTERNAL = splitItemsFormProperty(IOUtils.getStringProperty(DENY_PROPERTY_INTERNAL));
        DENYS = splitItemsFormProperty(IOUtils.getStringProperty(DENY_PROPERTY));
        AUTO_SUPPORT = "true".equals(IOUtils.getStringProperty(AUTOTYPE_SUPPORT_PROPERTY));
        SAFE_MODE = "true".equals(IOUtils.getStringProperty(SAFE_MODE_PROPERTY));
        String[] splitItemsFormProperty = splitItemsFormProperty(IOUtils.getStringProperty(AUTOTYPE_ACCEPT));
        if (splitItemsFormProperty == null) {
            splitItemsFormProperty = new String[0];
        }
        AUTO_TYPE_ACCEPT_LIST = splitItemsFormProperty;
        INTERNAL_WHITELIST_HASHCODES = new long[]{-9013707057526259810L, -8773806119481270567L, -8421588593326113468L, -8070393259084821111L, -7858127399773263546L, -7043543676283957292L, -6976602508726000783L, -6293031534589903644L, -6081111809668363619L, -5779433778261875721L, -5399450433995651784L, -4540135604787511831L, -4207865850564917696L, -3950343444501679205L, -3714900953609113456L, -3393714734093696063L, -3378497329992063044L, -2631228350337215662L, -2551988546877734201L, -2473987886800209058L, -2265617974881722705L, -1759511109484434299L, -1477946458560579955L, -816725787720647462L, -520183782617964618L, 59775428743665658L, 484499585846206473L, 532945107123976213L, 711449177569584898L, 829148494126372070L, 956883420092542580L, 1233162291719202522L, 1696465274354442213L, 1863557081881630420L, 2238472697200138595L, 2380202963256720577L, 2643099543618286743L, 2793877891138577121L, 3804572268889088203L, 4567982875926242015L, 4784070066737926537L, 4960004821520561233L, 5348524593377618456L, 5454920836284873808L, 5695987590363189151L, 6073645722991901167L, 6114875255374330593L, 6137737446243999215L, 6160752908990493848L, 6939315124833099497L, 7048426940343117278L, 7267793227937552092L, 8331868837379820532L, 8357451534615459155L, 8890227807433646566L, 9166532985682478006L, 9215131087512669423L};
        global = new ParserConfig();
        awtError = false;
        jdk8Error = false;
        jodaError = false;
        guavaError = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ParserConfig() {
        this(false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void addItemsToAccept(String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, strArr) == null) || strArr == null) {
            return;
        }
        for (String str : strArr) {
            addAccept(str);
        }
    }

    private void addItemsToDeny(String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, strArr) == null) || strArr == null) {
            return;
        }
        for (String str : strArr) {
            addDeny(str);
        }
    }

    private void addItemsToDeny0(String[] strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, strArr) == null) || strArr == null) {
            return;
        }
        for (String str : strArr) {
            addDenyInternal(str);
        }
    }

    public static Method getEnumCreator(Class cls, Class cls2) {
        InterceptResult invokeLL;
        Method[] methods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, cls, cls2)) == null) {
            for (Method method : cls.getMethods()) {
                if (Modifier.isStatic(method.getModifiers()) && method.getReturnType() == cls2 && method.getParameterTypes().length == 1 && ((JSONCreator) method.getAnnotation(JSONCreator.class)) != null) {
                    return method;
                }
            }
            return null;
        }
        return (Method) invokeLL.objValue;
    }

    public static Field getFieldFromCache(String str, Map<String, Field> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, map)) == null) {
            Field field = map.get(str);
            if (field == null) {
                field = map.get("_" + str);
            }
            if (field == null) {
                field = map.get("m_" + str);
            }
            if (field == null) {
                char charAt = str.charAt(0);
                if (charAt >= 'a' && charAt <= 'z') {
                    char[] charArray = str.toCharArray();
                    charArray[0] = (char) (charArray[0] - ' ');
                    field = map.get(new String(charArray));
                }
                if (str.length() > 2) {
                    char charAt2 = str.charAt(1);
                    if (str.length() <= 2 || charAt < 'a' || charAt > 'z' || charAt2 < 'A' || charAt2 > 'Z') {
                        return field;
                    }
                    for (Map.Entry<String, Field> entry : map.entrySet()) {
                        if (str.equalsIgnoreCase(entry.getKey())) {
                            return entry.getValue();
                        }
                    }
                    return field;
                }
                return field;
            }
            return field;
        }
        return (Field) invokeLL.objValue;
    }

    public static ParserConfig getGlobalInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? global : (ParserConfig) invokeV.objValue;
    }

    private void initDeserializers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.deserializers.put(SimpleDateFormat.class, MiscCodec.instance);
            this.deserializers.put(Timestamp.class, SqlDateDeserializer.instance_timestamp);
            this.deserializers.put(Date.class, SqlDateDeserializer.instance);
            this.deserializers.put(Time.class, TimeDeserializer.instance);
            this.deserializers.put(java.util.Date.class, DateCodec.instance);
            this.deserializers.put(Calendar.class, CalendarCodec.instance);
            this.deserializers.put(XMLGregorianCalendar.class, CalendarCodec.instance);
            this.deserializers.put(JSONObject.class, MapDeserializer.instance);
            this.deserializers.put(JSONArray.class, CollectionCodec.instance);
            this.deserializers.put(Map.class, MapDeserializer.instance);
            this.deserializers.put(HashMap.class, MapDeserializer.instance);
            this.deserializers.put(LinkedHashMap.class, MapDeserializer.instance);
            this.deserializers.put(TreeMap.class, MapDeserializer.instance);
            this.deserializers.put(ConcurrentMap.class, MapDeserializer.instance);
            this.deserializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
            this.deserializers.put(Collection.class, CollectionCodec.instance);
            this.deserializers.put(List.class, CollectionCodec.instance);
            this.deserializers.put(ArrayList.class, CollectionCodec.instance);
            this.deserializers.put(Object.class, JavaObjectDeserializer.instance);
            this.deserializers.put(String.class, StringCodec.instance);
            this.deserializers.put(StringBuffer.class, StringCodec.instance);
            this.deserializers.put(StringBuilder.class, StringCodec.instance);
            this.deserializers.put(Character.TYPE, CharacterCodec.instance);
            this.deserializers.put(Character.class, CharacterCodec.instance);
            this.deserializers.put(Byte.TYPE, NumberDeserializer.instance);
            this.deserializers.put(Byte.class, NumberDeserializer.instance);
            this.deserializers.put(Short.TYPE, NumberDeserializer.instance);
            this.deserializers.put(Short.class, NumberDeserializer.instance);
            this.deserializers.put(Integer.TYPE, IntegerCodec.instance);
            this.deserializers.put(Integer.class, IntegerCodec.instance);
            this.deserializers.put(Long.TYPE, LongCodec.instance);
            this.deserializers.put(Long.class, LongCodec.instance);
            this.deserializers.put(BigInteger.class, BigIntegerCodec.instance);
            this.deserializers.put(BigDecimal.class, BigDecimalCodec.instance);
            this.deserializers.put(Float.TYPE, FloatCodec.instance);
            this.deserializers.put(Float.class, FloatCodec.instance);
            this.deserializers.put(Double.TYPE, NumberDeserializer.instance);
            this.deserializers.put(Double.class, NumberDeserializer.instance);
            this.deserializers.put(Boolean.TYPE, BooleanCodec.instance);
            this.deserializers.put(Boolean.class, BooleanCodec.instance);
            this.deserializers.put(Class.class, MiscCodec.instance);
            this.deserializers.put(char[].class, new CharArrayCodec());
            this.deserializers.put(AtomicBoolean.class, BooleanCodec.instance);
            this.deserializers.put(AtomicInteger.class, IntegerCodec.instance);
            this.deserializers.put(AtomicLong.class, LongCodec.instance);
            this.deserializers.put(AtomicReference.class, ReferenceCodec.instance);
            this.deserializers.put(WeakReference.class, ReferenceCodec.instance);
            this.deserializers.put(SoftReference.class, ReferenceCodec.instance);
            this.deserializers.put(UUID.class, MiscCodec.instance);
            this.deserializers.put(TimeZone.class, MiscCodec.instance);
            this.deserializers.put(Locale.class, MiscCodec.instance);
            this.deserializers.put(Currency.class, MiscCodec.instance);
            this.deserializers.put(Inet4Address.class, MiscCodec.instance);
            this.deserializers.put(Inet6Address.class, MiscCodec.instance);
            this.deserializers.put(InetSocketAddress.class, MiscCodec.instance);
            this.deserializers.put(File.class, MiscCodec.instance);
            this.deserializers.put(URI.class, MiscCodec.instance);
            this.deserializers.put(URL.class, MiscCodec.instance);
            this.deserializers.put(Pattern.class, MiscCodec.instance);
            this.deserializers.put(Charset.class, MiscCodec.instance);
            this.deserializers.put(JSONPath.class, MiscCodec.instance);
            this.deserializers.put(Number.class, NumberDeserializer.instance);
            this.deserializers.put(AtomicIntegerArray.class, AtomicCodec.instance);
            this.deserializers.put(AtomicLongArray.class, AtomicCodec.instance);
            this.deserializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
            this.deserializers.put(Serializable.class, JavaObjectDeserializer.instance);
            this.deserializers.put(Cloneable.class, JavaObjectDeserializer.instance);
            this.deserializers.put(Comparable.class, JavaObjectDeserializer.instance);
            this.deserializers.put(Closeable.class, JavaObjectDeserializer.instance);
            this.deserializers.put(JSONPObject.class, new JSONPDeserializer());
        }
    }

    public static boolean isPrimitive2(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, cls)) == null) ? cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls == Date.class || cls == Time.class || cls == Timestamp.class || cls.isEnum() : invokeL.booleanValue;
    }

    public static void parserAllFieldToCache(Class<?> cls, Map<String, Field> map) {
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, cls, map) == null) {
            for (Field field : cls.getDeclaredFields()) {
                String name = field.getName();
                if (!map.containsKey(name)) {
                    map.put(name, field);
                }
            }
            if (cls.getSuperclass() == null || cls.getSuperclass() == Object.class) {
                return;
            }
            parserAllFieldToCache(cls.getSuperclass(), map);
        }
    }

    public static String[] splitItemsFormProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (str == null || str.length() <= 0) {
                return null;
            }
            return str.split(",");
        }
        return (String[]) invokeL.objValue;
    }

    public void addAccept(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null || str.length() == 0) {
            return;
        }
        long fnv1a_64 = TypeUtils.fnv1a_64(str);
        if (Arrays.binarySearch(this.acceptHashCodes, fnv1a_64) >= 0) {
            return;
        }
        long[] jArr = this.acceptHashCodes;
        int length = jArr.length + 1;
        long[] jArr2 = new long[length];
        jArr2[length - 1] = fnv1a_64;
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Arrays.sort(jArr2);
        this.acceptHashCodes = jArr2;
    }

    public void addAutoTypeCheckHandler(AutoTypeCheckHandler autoTypeCheckHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, autoTypeCheckHandler) == null) {
            List list = this.autoTypeCheckHandlers;
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.autoTypeCheckHandlers = list;
            }
            list.add(autoTypeCheckHandler);
        }
    }

    public void addDeny(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == null || str.length() == 0) {
            return;
        }
        long fnv1a_64 = TypeUtils.fnv1a_64(str);
        if (Arrays.binarySearch(this.denyHashCodes, fnv1a_64) >= 0) {
            return;
        }
        long[] jArr = this.denyHashCodes;
        int length = jArr.length + 1;
        long[] jArr2 = new long[length];
        jArr2[length - 1] = fnv1a_64;
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Arrays.sort(jArr2);
        this.denyHashCodes = jArr2;
    }

    public void addDenyInternal(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || str == null || str.length() == 0) {
            return;
        }
        long fnv1a_64 = TypeUtils.fnv1a_64(str);
        long[] jArr = this.internalDenyHashCodes;
        if (jArr == null) {
            this.internalDenyHashCodes = new long[]{fnv1a_64};
        } else if (Arrays.binarySearch(jArr, fnv1a_64) >= 0) {
        } else {
            long[] jArr2 = this.internalDenyHashCodes;
            int length = jArr2.length + 1;
            long[] jArr3 = new long[length];
            jArr3[length - 1] = fnv1a_64;
            System.arraycopy(jArr2, 0, jArr3, 0, jArr2.length);
            Arrays.sort(jArr3);
            this.internalDenyHashCodes = jArr3;
        }
    }

    public Class<?> checkAutoType(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) ? get(cls) != null ? cls : checkAutoType(cls.getName(), null, JSON.DEFAULT_PARSER_FEATURE) : (Class) invokeL.objValue;
    }

    public void clearDeserializers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.deserializers.clear();
            initDeserializers();
        }
    }

    public void configFromPropety(Properties properties) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, properties) == null) {
            addItemsToDeny(splitItemsFormProperty(properties.getProperty(DENY_PROPERTY)));
            addItemsToAccept(splitItemsFormProperty(properties.getProperty(AUTOTYPE_ACCEPT)));
            String property = properties.getProperty(AUTOTYPE_SUPPORT_PROPERTY);
            if ("true".equals(property)) {
                this.autoTypeSupport = true;
            } else if ("false".equals(property)) {
                this.autoTypeSupport = false;
            }
        }
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, FieldInfo fieldInfo) {
        InterceptResult invokeLLL;
        Class<?> deserializeUsing;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, parserConfig, javaBeanInfo, fieldInfo)) == null) {
            Class<?> cls = javaBeanInfo.clazz;
            Class<?> cls2 = fieldInfo.fieldClass;
            JSONField annotation = fieldInfo.getAnnotation();
            Class<?> cls3 = null;
            if (annotation != null && (deserializeUsing = annotation.deserializeUsing()) != Void.class) {
                cls3 = deserializeUsing;
            }
            if (cls3 == null && (cls2 == List.class || cls2 == ArrayList.class)) {
                return new ArrayListTypeFieldDeserializer(parserConfig, cls, fieldInfo);
            }
            return new DefaultFieldDeserializer(parserConfig, cls, fieldInfo);
        }
        return (FieldDeserializer) invokeLLL.objValue;
    }

    public ObjectDeserializer createJavaBeanDeserializer(Class<?> cls, Type type) {
        InterceptResult invokeLL;
        FieldInfo[] fieldInfoArr;
        JSONField annotation;
        Method method;
        ASMDeserializerFactory aSMDeserializerFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, cls, type)) == null) {
            boolean z = this.asmEnable & (!this.fieldBased);
            boolean z2 = false;
            if (z) {
                JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
                if (jSONType != null) {
                    Class<?> deserializer = jSONType.deserializer();
                    if (deserializer != Void.class) {
                        try {
                            Object newInstance = deserializer.newInstance();
                            if (newInstance instanceof ObjectDeserializer) {
                                return (ObjectDeserializer) newInstance;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    z = jSONType.asm() && jSONType.parseFeatures().length == 0;
                }
                if (z) {
                    Class<?> builderClass = JavaBeanInfo.getBuilderClass(cls, jSONType);
                    if (builderClass == null) {
                        builderClass = cls;
                    }
                    while (true) {
                        if (!Modifier.isPublic(builderClass.getModifiers())) {
                            z = false;
                            break;
                        }
                        builderClass = builderClass.getSuperclass();
                        if (builderClass != Object.class) {
                            if (builderClass == null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            if (cls.getTypeParameters().length != 0) {
                z = false;
            }
            if (z && (aSMDeserializerFactory = this.asmFactory) != null && aSMDeserializerFactory.classLoader.isExternalClass(cls)) {
                z = false;
            }
            if (z) {
                z = ASMUtils.checkName(cls.getSimpleName());
            }
            if (z) {
                if (cls.isInterface()) {
                    z = false;
                }
                JavaBeanInfo build = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, this.jacksonCompatible);
                if (z && build.fields.length > 200) {
                    z = false;
                }
                Constructor<?> constructor = build.defaultConstructor;
                if (z && constructor == null && !cls.isInterface()) {
                    z = false;
                }
                for (FieldInfo fieldInfo : build.fields) {
                    if (!fieldInfo.getOnly) {
                        Class<?> cls2 = fieldInfo.fieldClass;
                        if (Modifier.isPublic(cls2.getModifiers()) && ((!cls2.isMemberClass() || Modifier.isStatic(cls2.getModifiers())) && ((fieldInfo.getMember() == null || ASMUtils.checkName(fieldInfo.getMember().getName())) && (((annotation = fieldInfo.getAnnotation()) == null || (ASMUtils.checkName(annotation.name()) && annotation.format().length() == 0 && annotation.deserializeUsing() == Void.class && annotation.parseFeatures().length == 0 && !annotation.unwrapped())) && (((method = fieldInfo.method) == null || method.getParameterTypes().length <= 1) && (!cls2.isEnum() || (getDeserializer(cls2) instanceof EnumDeserializer))))))) {
                        }
                    }
                    z = false;
                    break;
                }
            }
            if (z && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
                z = false;
            }
            if (!z || !TypeUtils.isXmlField(cls)) {
                z2 = z;
            }
            if (!z2) {
                return new JavaBeanDeserializer(this, cls, type);
            }
            JavaBeanInfo build2 = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy);
            try {
                return this.asmFactory.createJavaBeanDeserializer(this, build2);
            } catch (JSONException unused2) {
                return new JavaBeanDeserializer(this, build2);
            } catch (NoSuchMethodException unused3) {
                return new JavaBeanDeserializer(this, cls, type);
            } catch (Exception e2) {
                throw new JSONException("create asm deserializer error, " + cls.getName(), e2);
            }
        }
        return (ObjectDeserializer) invokeLL.objValue;
    }

    public ObjectDeserializer get(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, type)) == null) {
            Type mixInAnnotations = JSON.getMixInAnnotations(type);
            if (mixInAnnotations == null) {
                return this.deserializers.get(type);
            }
            IdentityHashMap<Type, ObjectDeserializer> identityHashMap = this.mixInDeserializers.get(type);
            if (identityHashMap == null) {
                return null;
            }
            return identityHashMap.get(mixInAnnotations);
        }
        return (ObjectDeserializer) invokeL.objValue;
    }

    public ClassLoader getDefaultClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.defaultClassLoader : (ClassLoader) invokeV.objValue;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDerializers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.deserializers : (IdentityHashMap) invokeV.objValue;
    }

    public ObjectDeserializer getDeserializer(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, type)) == null) {
            ObjectDeserializer objectDeserializer = get(type);
            if (objectDeserializer != null) {
                return objectDeserializer;
            }
            if (type instanceof Class) {
                return getDeserializer((Class) type, type);
            }
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType instanceof Class) {
                    return getDeserializer((Class) rawType, type);
                }
                return getDeserializer(rawType);
            }
            if (type instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type).getUpperBounds();
                if (upperBounds.length == 1) {
                    return getDeserializer(upperBounds[0]);
                }
            }
            return JavaObjectDeserializer.instance;
        }
        return (ObjectDeserializer) invokeL.objValue;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDeserializers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.deserializers : (IdentityHashMap) invokeV.objValue;
    }

    public ObjectDeserializer getEnumDeserializer(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, cls)) == null) ? new EnumDeserializer(cls) : (ObjectDeserializer) invokeL.objValue;
    }

    public void initJavaBeanDeserializers(Class<?>... clsArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, clsArr) == null) || clsArr == null) {
            return;
        }
        for (Class<?> cls : clsArr) {
            if (cls != null) {
                putDeserializer(cls, createJavaBeanDeserializer(cls, cls));
            }
        }
    }

    public boolean isAsmEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.asmEnable : invokeV.booleanValue;
    }

    public boolean isAutoTypeSupport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.autoTypeSupport : invokeV.booleanValue;
    }

    public boolean isJacksonCompatible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.jacksonCompatible : invokeV.booleanValue;
    }

    public boolean isPrimitive(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, cls)) == null) ? isPrimitive2(cls) : invokeL.booleanValue;
    }

    public boolean isSafeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.safeMode : invokeV.booleanValue;
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, type, objectDeserializer) == null) {
            Type mixInAnnotations = JSON.getMixInAnnotations(type);
            if (mixInAnnotations != null) {
                IdentityHashMap<Type, ObjectDeserializer> identityHashMap = this.mixInDeserializers.get(type);
                if (identityHashMap == null) {
                    identityHashMap = new IdentityHashMap<>(4);
                    this.mixInDeserializers.put(type, identityHashMap);
                }
                identityHashMap.put(mixInAnnotations, objectDeserializer);
                return;
            }
            this.deserializers.put(type, objectDeserializer);
        }
    }

    public void register(String str, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, str, cls) == null) {
            this.typeMapping.putIfAbsent(str, cls);
        }
    }

    public void setAsmEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.asmEnable = z;
        }
    }

    public void setAutoTypeSupport(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.autoTypeSupport = z;
        }
    }

    public void setDefaultClassLoader(ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, classLoader) == null) {
            this.defaultClassLoader = classLoader;
        }
    }

    public void setJacksonCompatible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.jacksonCompatible = z;
        }
    }

    public void setSafeMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.safeMode = z;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ParserConfig(boolean z) {
        this(null, null, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ASMDeserializerFactory) objArr2[0], (ClassLoader) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
    }

    public void register(Module module) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, module) == null) {
            this.modules.add(module);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ParserConfig(ClassLoader classLoader) {
        this(null, classLoader, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {classLoader};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ASMDeserializerFactory) objArr2[0], (ClassLoader) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    public Class<?> checkAutoType(String str, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, cls)) == null) ? checkAutoType(str, cls, JSON.DEFAULT_PARSER_FEATURE) : (Class) invokeLL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ParserConfig(ASMDeserializerFactory aSMDeserializerFactory) {
        this(aSMDeserializerFactory, null, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aSMDeserializerFactory};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ASMDeserializerFactory) objArr2[0], (ClassLoader) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0300 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0306 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Class<?> checkAutoType(String str, Class<?> cls, int i2) {
        InterceptResult invokeLLI;
        boolean z;
        long charAt;
        InputStream inputStream;
        InputStream inputStream2;
        boolean z2;
        boolean z3;
        InputStream resourceAsStream;
        Class<?> loadClass;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLI = interceptable.invokeLLI(1048582, this, str, cls, i2)) != null) {
            return (Class) invokeLLI.objValue;
        }
        if (str == null) {
            return null;
        }
        if (this.autoTypeCheckHandlers != null) {
            for (AutoTypeCheckHandler autoTypeCheckHandler : this.autoTypeCheckHandlers) {
                Class<?> handler = autoTypeCheckHandler.handler(str, cls, i2);
                if (handler != null) {
                    return handler;
                }
            }
        }
        int i3 = Feature.SafeMode.mask;
        if (!((!this.safeMode && (i2 & i3) == 0 && (i3 & JSON.DEFAULT_PARSER_FEATURE) == 0) ? false : true)) {
            if (str.length() < 192 && str.length() >= 3) {
                if (cls != null) {
                    long fnv1a_64 = TypeUtils.fnv1a_64(cls.getName());
                    if (fnv1a_64 != -8024746738719829346L && fnv1a_64 != 3247277300971823414L && fnv1a_64 != -5811778396720452501L && fnv1a_64 != -1368967840069965882L && fnv1a_64 != 2980334044947851925L && fnv1a_64 != 5183404141909004468L && fnv1a_64 != 7222019943667248779L && fnv1a_64 != -2027296626235911549L && fnv1a_64 != -2114196234051346931L && fnv1a_64 != -2939497380989775398L) {
                        z = true;
                        String replace = str.replace('$', '.');
                        charAt = (replace.charAt(0) ^ (-3750763034362895579L)) * 1099511628211L;
                        if (charAt == -5808493101479473382L) {
                            if ((replace.charAt(replace.length() - 1) ^ charAt) * 1099511628211L != 655701488918567152L) {
                                long charAt2 = (((((replace.charAt(0) ^ (-3750763034362895579L)) * 1099511628211L) ^ replace.charAt(1)) * 1099511628211L) ^ replace.charAt(2)) * 1099511628211L;
                                long fnv1a_642 = TypeUtils.fnv1a_64(replace);
                                boolean z4 = Arrays.binarySearch(INTERNAL_WHITELIST_HASHCODES, fnv1a_642) >= 0;
                                if (this.internalDenyHashCodes != null) {
                                    long j2 = charAt2;
                                    int i4 = 3;
                                    while (i4 < replace.length()) {
                                        long charAt3 = (j2 ^ replace.charAt(i4)) * 1099511628211L;
                                        if (Arrays.binarySearch(this.internalDenyHashCodes, charAt3) >= 0) {
                                            throw new JSONException("autoType is not support. " + str);
                                        }
                                        i4++;
                                        j2 = charAt3;
                                    }
                                }
                                if (!z4 && (this.autoTypeSupport || z)) {
                                    long j3 = charAt2;
                                    int i5 = 3;
                                    while (i5 < replace.length()) {
                                        long j4 = charAt2;
                                        j3 = (replace.charAt(i5) ^ j3) * 1099511628211L;
                                        if (Arrays.binarySearch(this.acceptHashCodes, j3) >= 0 && (loadClass = TypeUtils.loadClass(str, this.defaultClassLoader, true)) != null) {
                                            return loadClass;
                                        }
                                        if (Arrays.binarySearch(this.denyHashCodes, j3) >= 0 && TypeUtils.getClassFromMapping(str) == null && Arrays.binarySearch(this.acceptHashCodes, fnv1a_642) < 0) {
                                            throw new JSONException("autoType is not support. " + str);
                                        }
                                        i5++;
                                        charAt2 = j4;
                                    }
                                }
                                long j5 = charAt2;
                                Class<?> classFromMapping = TypeUtils.getClassFromMapping(str);
                                if (classFromMapping == null) {
                                    classFromMapping = this.deserializers.findClass(str);
                                }
                                if (classFromMapping == null) {
                                    classFromMapping = this.typeMapping.get(str);
                                }
                                if (z4) {
                                    classFromMapping = TypeUtils.loadClass(str, this.defaultClassLoader, true);
                                }
                                if (classFromMapping != null) {
                                    if (cls == null || classFromMapping == HashMap.class || cls.isAssignableFrom(classFromMapping)) {
                                        return classFromMapping;
                                    }
                                    throw new JSONException("type not match. " + str + LoadErrorCode.TOKEN_NEXT + cls.getName());
                                }
                                if (!this.autoTypeSupport) {
                                    int i6 = 3;
                                    while (i6 < replace.length()) {
                                        long charAt4 = (j5 ^ replace.charAt(i6)) * 1099511628211L;
                                        if (Arrays.binarySearch(this.denyHashCodes, charAt4) < 0) {
                                            if (Arrays.binarySearch(this.acceptHashCodes, charAt4) >= 0) {
                                                Class<?> loadClass2 = TypeUtils.loadClass(str, this.defaultClassLoader, true);
                                                if (loadClass2 == null) {
                                                    return cls;
                                                }
                                                if (cls == null || !cls.isAssignableFrom(loadClass2)) {
                                                    return loadClass2;
                                                }
                                                throw new JSONException("type not match. " + str + LoadErrorCode.TOKEN_NEXT + cls.getName());
                                            }
                                            i6++;
                                            j5 = charAt4;
                                        } else {
                                            throw new JSONException("autoType is not support. " + str);
                                        }
                                    }
                                }
                                try {
                                    String str2 = str.replace('.', '/') + ".class";
                                    if (this.defaultClassLoader != null) {
                                        resourceAsStream = this.defaultClassLoader.getResourceAsStream(str2);
                                    } else {
                                        resourceAsStream = ParserConfig.class.getClassLoader().getResourceAsStream(str2);
                                    }
                                    if (resourceAsStream != null) {
                                        try {
                                            try {
                                                ClassReader classReader = new ClassReader(resourceAsStream, true);
                                                try {
                                                    TypeCollector typeCollector = new TypeCollector("<clinit>", new Class[0]);
                                                    classReader.accept(typeCollector);
                                                    z2 = typeCollector.hasJsonType();
                                                } catch (Exception unused) {
                                                    inputStream2 = resourceAsStream;
                                                    IOUtils.close(inputStream2);
                                                    z2 = false;
                                                    int i7 = Feature.SupportAutoType.mask;
                                                    if (this.autoTypeSupport) {
                                                    }
                                                    if (!z3) {
                                                    }
                                                    classFromMapping = TypeUtils.loadClass(str, this.defaultClassLoader, !z3 || z2);
                                                    if (classFromMapping != null) {
                                                    }
                                                    if (z3) {
                                                    }
                                                }
                                            } catch (Exception unused2) {
                                                inputStream2 = resourceAsStream;
                                                IOUtils.close(inputStream2);
                                                z2 = false;
                                                int i72 = Feature.SupportAutoType.mask;
                                                if (this.autoTypeSupport) {
                                                }
                                                if (!z3) {
                                                }
                                                classFromMapping = TypeUtils.loadClass(str, this.defaultClassLoader, !z3 || z2);
                                                if (classFromMapping != null) {
                                                }
                                                if (z3) {
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStream = resourceAsStream;
                                            IOUtils.close(inputStream);
                                            throw th;
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                    IOUtils.close(resourceAsStream);
                                } catch (Exception unused3) {
                                    inputStream2 = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = null;
                                }
                                int i722 = Feature.SupportAutoType.mask;
                                z3 = (this.autoTypeSupport && (i2 & i722) == 0 && (JSON.DEFAULT_PARSER_FEATURE & i722) == 0) ? false : true;
                                if (!z3 || z2 || z) {
                                    classFromMapping = TypeUtils.loadClass(str, this.defaultClassLoader, !z3 || z2);
                                }
                                if (classFromMapping != null) {
                                    if (z2) {
                                        TypeUtils.addMapping(str, classFromMapping);
                                        return classFromMapping;
                                    } else if (ClassLoader.class.isAssignableFrom(classFromMapping) || DataSource.class.isAssignableFrom(classFromMapping) || RowSet.class.isAssignableFrom(classFromMapping)) {
                                        throw new JSONException("autoType is not support. " + str);
                                    } else if (cls != null) {
                                        if (cls.isAssignableFrom(classFromMapping)) {
                                            TypeUtils.addMapping(str, classFromMapping);
                                            return classFromMapping;
                                        }
                                        throw new JSONException("type not match. " + str + LoadErrorCode.TOKEN_NEXT + cls.getName());
                                    } else if (JavaBeanInfo.build(classFromMapping, classFromMapping, this.propertyNamingStrategy).creatorConstructor != null && z3) {
                                        throw new JSONException("autoType is not support. " + str);
                                    }
                                }
                                if (z3) {
                                    if (classFromMapping != null) {
                                        TypeUtils.addMapping(str, classFromMapping);
                                    }
                                    return classFromMapping;
                                }
                                throw new JSONException("autoType is not support. " + str);
                            }
                            throw new JSONException("autoType is not support. " + str);
                        }
                        throw new JSONException("autoType is not support. " + str);
                    }
                }
                z = false;
                String replace2 = str.replace('$', '.');
                charAt = (replace2.charAt(0) ^ (-3750763034362895579L)) * 1099511628211L;
                if (charAt == -5808493101479473382L) {
                }
            } else {
                throw new JSONException("autoType is not support. " + str);
            }
        } else {
            throw new JSONException("safeMode not support autoType : " + str);
        }
    }

    public ParserConfig(ASMDeserializerFactory aSMDeserializerFactory, ClassLoader classLoader, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aSMDeserializerFactory, classLoader, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.deserializers = new IdentityHashMap<>();
        this.mixInDeserializers = new IdentityHashMap<>(16);
        this.typeMapping = new ConcurrentHashMap(16, 0.75f, 1);
        this.asmEnable = !ASMUtils.IS_ANDROID;
        this.symbolTable = new SymbolTable(4096);
        this.autoTypeSupport = AUTO_SUPPORT;
        this.jacksonCompatible = false;
        this.compatibleWithJavaBean = TypeUtils.compatibleWithJavaBean;
        this.modules = new ArrayList();
        this.safeMode = SAFE_MODE;
        this.denyHashCodes = new long[]{-9164606388214699518L, -8720046426850100497L, -8649961213709896794L, -8165637398350707645L, -8109300701639721088L, -7966123100503199569L, -7921218830998286408L, -7775351613326101303L, -7768608037458185275L, -7766605818834748097L, -6835437086156813536L, -6316154655839304624L, -6179589609550493385L, -6149093380703242441L, -6025144546313590215L, -5939269048541779808L, -5885964883385605994L, -5764804792063216819L, -5472097725414717105L, -5194641081268104286L, -5076846148177416215L, -4837536971810737970L, -4703320437989596122L, -4608341446948126581L, -4537258998789938600L, -4438775680185074100L, -4314457471973557243L, -4150995715611818742L, -4082057040235125754L, -3975378478825053783L, -3935185854875733362L, -3319207949486691020L, -3077205613010077203L, -3053747177772160511L, -2995060141064716555L, -2825378362173150292L, -2533039401923731906L, -2439930098895578154L, -2378990704010641148L, -2364987994247679115L, -2262244760619952081L, -2192804397019347313L, -2095516571388852610L, -1872417015366588117L, -1650485814983027158L, -1589194880214235129L, -965955008570215305L, -905177026366752536L, -831789045734283466L, -582813228520337988L, -254670111376247151L, -219577392946377768L, -190281065685395680L, -26639035867733124L, -9822483067882491L, 4750336058574309L, 33238344207745342L, 156405680656087946L, 218512992947536312L, 313864100207897507L, 386461436234701831L, 823641066473609950L, 1073634739308289776L, 1153291637701043748L, 1203232727967308606L, 1214780596910349029L, 1459860845934817624L, 1502845958873959152L, 1534439610567445754L, 1698504441317515818L, 1818089308493370394L, 2078113382421334967L, 2164696723069287854L, 2622551729063269307L, 2653453629929770569L, 2660670623866180977L, 2731823439467737506L, 2836431254737891113L, 2930861374593775110L, 3085473968517218653L, 3089451460101527857L, 3114862868117605599L, 3129395579983849527L, 3256258368248066264L, 3452379460455804429L, 3547627781654598988L, 3637939656440441093L, 3688179072722109200L, 3718352661124136681L, 3730752432285826863L, 3794316665763266033L, 4000049462512838776L, 4046190361520671643L, 4147696707147271408L, 4193204392725694463L, 4241163808635564644L, 4254584350247334433L, 4814658433570175913L, 4841947709850912914L, 4904007817188630457L, 5100336081510080343L, 5274044858141538265L, 5347909877633654828L, 5450448828334921485L, 5474268165959054640L, 5545425291794704408L, 5596129856135573697L, 5688200883751798389L, 5751393439502795295L, 5944107969236155580L, 6007332606592876737L, 6280357960959217660L, 6456855723474196908L, 6511035576063254270L, 6534946468240507089L, 6584624952928234050L, 6734240326434096246L, 6742705432718011780L, 6854854816081053523L, 7045245923763966215L, 7123326897294507060L, 7179336928365889465L, 7240293012336844478L, 7347653049056829645L, 7375862386996623731L, 7442624256860549330L, 7617522210483516279L, 7658177784286215602L, 8055461369741094911L, 8389032537095247355L, 8409640769019589119L, 8488266005336625107L, 8537233257283452655L, 8838294710098435315L, 9140390920032557669L, 9140416208800006522L};
        long[] jArr = new long[AUTO_TYPE_ACCEPT_LIST.length];
        int i4 = 0;
        while (true) {
            String[] strArr = AUTO_TYPE_ACCEPT_LIST;
            if (i4 >= strArr.length) {
                break;
            }
            jArr[i4] = TypeUtils.fnv1a_64(strArr[i4]);
            i4++;
        }
        Arrays.sort(jArr);
        this.acceptHashCodes = jArr;
        this.fieldBased = z;
        if (aSMDeserializerFactory == null && !ASMUtils.IS_ANDROID) {
            try {
                if (classLoader == null) {
                    aSMDeserializerFactory = new ASMDeserializerFactory(new ASMClassLoader());
                } else {
                    aSMDeserializerFactory = new ASMDeserializerFactory(classLoader);
                }
            } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
            }
        }
        this.asmFactory = aSMDeserializerFactory;
        if (aSMDeserializerFactory == null) {
            this.asmEnable = false;
        }
        initDeserializers();
        addItemsToDeny(DENYS);
        addItemsToDeny0(DENYS_INTERNAL);
        addItemsToAccept(AUTO_TYPE_ACCEPT_LIST);
    }

    public ObjectDeserializer getDeserializer(Class<?> cls, Type type) {
        InterceptResult invokeLL;
        ObjectDeserializer objectDeserializer;
        ObjectDeserializer propertyProcessableDeserializer;
        Class<?> mappingTo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, cls, type)) == null) {
            Type type2 = type;
            ObjectDeserializer objectDeserializer2 = get(type2);
            if (objectDeserializer2 == null && (type2 instanceof ParameterizedTypeImpl)) {
                objectDeserializer2 = get(TypeReference.intern((ParameterizedTypeImpl) type2));
            }
            if (objectDeserializer2 != null) {
                return objectDeserializer2;
            }
            if (type2 == null) {
                type2 = cls;
            }
            ObjectDeserializer objectDeserializer3 = get(type2);
            if (objectDeserializer3 != null) {
                return objectDeserializer3;
            }
            JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
            if (jSONType != null && (mappingTo = jSONType.mappingTo()) != Void.class) {
                return getDeserializer(mappingTo, mappingTo);
            }
            if ((type2 instanceof WildcardType) || (type2 instanceof TypeVariable) || (type2 instanceof ParameterizedType)) {
                objectDeserializer3 = get(cls);
            }
            if (objectDeserializer3 != null) {
                return objectDeserializer3;
            }
            for (Module module : this.modules) {
                objectDeserializer3 = module.createDeserializer(this, cls);
                if (objectDeserializer3 != null) {
                    putDeserializer(type2, objectDeserializer3);
                    return objectDeserializer3;
                }
            }
            String replace = cls.getName().replace('$', '.');
            if (replace.startsWith("java.awt.") && AwtCodec.support(cls) && !awtError) {
                String[] strArr = {"java.awt.Point", "java.awt.Font", "java.awt.Rectangle", "java.awt.Color"};
                for (int i2 = 0; i2 < 4; i2++) {
                    try {
                        String str = strArr[i2];
                        if (str.equals(replace)) {
                            Type cls2 = Class.forName(str);
                            ObjectDeserializer objectDeserializer4 = AwtCodec.instance;
                            putDeserializer(cls2, objectDeserializer4);
                            return objectDeserializer4;
                        }
                    } catch (Throwable unused) {
                        awtError = true;
                    }
                }
                objectDeserializer3 = AwtCodec.instance;
            }
            if (!jdk8Error) {
                try {
                    if (replace.startsWith("java.time.")) {
                        String[] strArr2 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.ZoneId", "java.time.Period", "java.time.Duration", "java.time.Instant"};
                        for (int i3 = 0; i3 < 12; i3++) {
                            String str2 = strArr2[i3];
                            if (str2.equals(replace)) {
                                Type cls3 = Class.forName(str2);
                                ObjectDeserializer objectDeserializer5 = Jdk8DateCodec.instance;
                                putDeserializer(cls3, objectDeserializer5);
                                return objectDeserializer5;
                            }
                        }
                    } else if (replace.startsWith("java.util.Optional")) {
                        String[] strArr3 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};
                        for (int i4 = 0; i4 < 4; i4++) {
                            String str3 = strArr3[i4];
                            if (str3.equals(replace)) {
                                Type cls4 = Class.forName(str3);
                                ObjectDeserializer objectDeserializer6 = OptionalCodec.instance;
                                putDeserializer(cls4, objectDeserializer6);
                                return objectDeserializer6;
                            }
                        }
                    }
                } catch (Throwable unused2) {
                    jdk8Error = true;
                }
            }
            if (!jodaError) {
                try {
                    if (replace.startsWith("org.joda.time.")) {
                        String[] strArr4 = {"org.joda.time.DateTime", "org.joda.time.LocalDate", "org.joda.time.LocalDateTime", "org.joda.time.LocalTime", "org.joda.time.Instant", "org.joda.time.Period", "org.joda.time.Duration", "org.joda.time.DateTimeZone", "org.joda.time.format.DateTimeFormatter"};
                        for (int i5 = 0; i5 < 9; i5++) {
                            String str4 = strArr4[i5];
                            if (str4.equals(replace)) {
                                Type cls5 = Class.forName(str4);
                                objectDeserializer3 = JodaCodec.instance;
                                putDeserializer(cls5, objectDeserializer3);
                                return objectDeserializer3;
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    jodaError = true;
                }
            }
            if (!guavaError && replace.startsWith("com.google.common.collect.")) {
                try {
                    String[] strArr5 = {"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.LinkedHashMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"};
                    for (int i6 = 0; i6 < 5; i6++) {
                        String str5 = strArr5[i6];
                        if (str5.equals(replace)) {
                            Type cls6 = Class.forName(str5);
                            objectDeserializer3 = GuavaCodec.instance;
                            putDeserializer(cls6, objectDeserializer3);
                            return objectDeserializer3;
                        }
                    }
                } catch (ClassNotFoundException unused4) {
                    guavaError = true;
                }
            }
            if (replace.equals("java.nio.ByteBuffer")) {
                objectDeserializer3 = ByteBufferCodec.instance;
                putDeserializer(cls, objectDeserializer3);
            }
            if (replace.equals("java.nio.file.Path")) {
                objectDeserializer3 = MiscCodec.instance;
                putDeserializer(cls, objectDeserializer3);
            }
            if (cls == Map.Entry.class) {
                objectDeserializer3 = MiscCodec.instance;
                putDeserializer(cls, objectDeserializer3);
            }
            if (replace.equals("org.javamoney.moneta.Money")) {
                objectDeserializer3 = MonetaCodec.instance;
                putDeserializer(cls, objectDeserializer3);
            }
            try {
                for (AutowiredObjectDeserializer autowiredObjectDeserializer : ServiceLoader.load(AutowiredObjectDeserializer.class, Thread.currentThread().getContextClassLoader())) {
                    for (Type type3 : autowiredObjectDeserializer.getAutowiredFor()) {
                        putDeserializer(type3, autowiredObjectDeserializer);
                    }
                }
            } catch (Exception unused5) {
            }
            if (objectDeserializer3 == null) {
                objectDeserializer3 = get(type2);
            }
            if (objectDeserializer3 != null) {
                return objectDeserializer3;
            }
            if (cls.isEnum()) {
                if (this.jacksonCompatible) {
                    for (Method method : cls.getMethods()) {
                        if (TypeUtils.isJacksonCreator(method)) {
                            ObjectDeserializer createJavaBeanDeserializer = createJavaBeanDeserializer(cls, type2);
                            putDeserializer(type2, createJavaBeanDeserializer);
                            return createJavaBeanDeserializer;
                        }
                    }
                }
                Class<?> cls7 = (Class) JSON.getMixInAnnotations(cls);
                JSONType jSONType2 = (JSONType) TypeUtils.getAnnotation(cls7 != null ? cls7 : cls, JSONType.class);
                if (jSONType2 != null) {
                    try {
                        ObjectDeserializer objectDeserializer7 = (ObjectDeserializer) jSONType2.deserializer().newInstance();
                        putDeserializer(cls, objectDeserializer7);
                        return objectDeserializer7;
                    } catch (Throwable unused6) {
                    }
                }
                Method method2 = null;
                if (cls7 != null) {
                    Method enumCreator = getEnumCreator(cls7, cls);
                    if (enumCreator != null) {
                        try {
                            method2 = cls.getMethod(enumCreator.getName(), enumCreator.getParameterTypes());
                        } catch (Exception unused7) {
                        }
                    }
                } else {
                    method2 = getEnumCreator(cls, cls);
                }
                if (method2 != null) {
                    ObjectDeserializer enumCreatorDeserializer = new EnumCreatorDeserializer(method2);
                    putDeserializer(cls, enumCreatorDeserializer);
                    return enumCreatorDeserializer;
                }
                objectDeserializer = getEnumDeserializer(cls);
            } else if (cls.isArray()) {
                objectDeserializer = ObjectArrayCodec.instance;
            } else if (cls != Set.class && cls != HashSet.class && cls != Collection.class && cls != List.class && cls != ArrayList.class) {
                if (Collection.class.isAssignableFrom(cls)) {
                    objectDeserializer = CollectionCodec.instance;
                } else if (Map.class.isAssignableFrom(cls)) {
                    objectDeserializer = MapDeserializer.instance;
                } else {
                    if (Throwable.class.isAssignableFrom(cls)) {
                        propertyProcessableDeserializer = new ThrowableDeserializer(this, cls);
                    } else if (PropertyProcessable.class.isAssignableFrom(cls)) {
                        propertyProcessableDeserializer = new PropertyProcessableDeserializer(cls);
                    } else if (cls == InetAddress.class) {
                        objectDeserializer = MiscCodec.instance;
                    } else {
                        objectDeserializer = createJavaBeanDeserializer(cls, type2);
                    }
                    objectDeserializer = propertyProcessableDeserializer;
                }
            } else {
                objectDeserializer = CollectionCodec.instance;
            }
            putDeserializer(type2, objectDeserializer);
            return objectDeserializer;
        }
        return (ObjectDeserializer) invokeLL.objValue;
    }

    public ObjectDeserializer getDeserializer(FieldInfo fieldInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, fieldInfo)) == null) ? getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType) : (ObjectDeserializer) invokeL.objValue;
    }
}
