package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
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
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.sql.DataSource;
import javax.xml.datatype.XMLGregorianCalendar;
/* loaded from: classes3.dex */
public class ParserConfig {
    public static final String AUTOTYPE_ACCEPT = "fastjson.parser.autoTypeAccept";
    private static final String[] AUTO_TYPE_ACCEPT_LIST;
    private static boolean awtError;
    public static ParserConfig global;
    private static boolean jdk8Error;
    private String[] acceptList;
    private boolean asmEnable;
    protected ASMDeserializerFactory asmFactory;
    private boolean autoTypeSupport;
    public boolean compatibleWithJavaBean;
    protected ClassLoader defaultClassLoader;
    private String[] denyList;
    private final IdentityHashMap<Type, ObjectDeserializer> deserializers;
    public final boolean fieldBased;
    public PropertyNamingStrategy propertyNamingStrategy;
    public final SymbolTable symbolTable;
    public static final String DENY_PROPERTY = "fastjson.parser.deny";
    public static final String[] DENYS = splitItemsFormProperty(IOUtils.getStringProperty(DENY_PROPERTY));
    public static final String AUTOTYPE_SUPPORT_PROPERTY = "fastjson.parser.autoTypeSupport";
    public static final boolean AUTO_SUPPORT = "true".equals(IOUtils.getStringProperty(AUTOTYPE_SUPPORT_PROPERTY));

    static {
        String[] splitItemsFormProperty = splitItemsFormProperty(IOUtils.getStringProperty(AUTOTYPE_ACCEPT));
        if (splitItemsFormProperty == null) {
            splitItemsFormProperty = new String[0];
        }
        AUTO_TYPE_ACCEPT_LIST = splitItemsFormProperty;
        global = new ParserConfig();
        awtError = false;
        jdk8Error = false;
    }

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    public ParserConfig() {
        this(false);
    }

    public ParserConfig(boolean z) {
        this(null, null, z);
    }

    public ParserConfig(ClassLoader classLoader) {
        this(null, classLoader, false);
    }

    public ParserConfig(ASMDeserializerFactory aSMDeserializerFactory) {
        this(aSMDeserializerFactory, null, false);
    }

    private ParserConfig(ASMDeserializerFactory aSMDeserializerFactory, ClassLoader classLoader, boolean z) {
        ASMDeserializerFactory aSMDeserializerFactory2;
        this.deserializers = new IdentityHashMap<>();
        this.asmEnable = !ASMUtils.IS_ANDROID;
        this.symbolTable = new SymbolTable(4096);
        this.autoTypeSupport = AUTO_SUPPORT;
        this.denyList = "bsh,com.mchange,com.sun.,java.lang.Thread,java.net.Socket,java.rmi,javax.xml,org.apache.bcel,org.apache.commons.beanutils,org.apache.commons.collections.Transformer,org.apache.commons.collections.functors,org.apache.commons.collections4.comparators,org.apache.commons.fileupload,org.apache.myfaces.context.servlet,org.apache.tomcat,org.apache.wicket.util,org.apache.xalan,org.codehaus.groovy.runtime,org.hibernate,org.jboss,org.mozilla.javascript,org.python.core,org.springframework".split(",");
        this.acceptList = AUTO_TYPE_ACCEPT_LIST;
        this.compatibleWithJavaBean = TypeUtils.compatibleWithJavaBean;
        this.fieldBased = z;
        if (aSMDeserializerFactory == null && !ASMUtils.IS_ANDROID) {
            try {
                if (classLoader == null) {
                    aSMDeserializerFactory2 = new ASMDeserializerFactory(new ASMClassLoader());
                } else {
                    aSMDeserializerFactory2 = new ASMDeserializerFactory(classLoader);
                }
                aSMDeserializerFactory = aSMDeserializerFactory2;
            } catch (ExceptionInInitializerError e) {
            } catch (NoClassDefFoundError e2) {
            } catch (AccessControlException e3) {
            }
        }
        this.asmFactory = aSMDeserializerFactory;
        if (aSMDeserializerFactory == null) {
            this.asmEnable = false;
        }
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
        this.deserializers.put(InetAddress.class, MiscCodec.instance);
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
        addItemsToDeny(DENYS);
        addItemsToAccept(AUTO_TYPE_ACCEPT_LIST);
    }

    private static String[] splitItemsFormProperty(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(",");
    }

    public void configFromPropety(Properties properties) {
        addItemsToDeny(splitItemsFormProperty(properties.getProperty(DENY_PROPERTY)));
        addItemsToAccept(splitItemsFormProperty(properties.getProperty(AUTOTYPE_ACCEPT)));
        String property = properties.getProperty(AUTOTYPE_SUPPORT_PROPERTY);
        if ("true".equals(property)) {
            this.autoTypeSupport = true;
        } else if ("false".equals(property)) {
            this.autoTypeSupport = false;
        }
    }

    private void addItemsToDeny(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                addDeny(str);
            }
        }
    }

    private void addItemsToAccept(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                addAccept(str);
            }
        }
    }

    public boolean isAutoTypeSupport() {
        return this.autoTypeSupport;
    }

    public void setAutoTypeSupport(boolean z) {
        this.autoTypeSupport = z;
    }

    public boolean isAsmEnable() {
        return this.asmEnable;
    }

    public void setAsmEnable(boolean z) {
        this.asmEnable = z;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDeserializers() {
        return this.deserializers;
    }

    public ObjectDeserializer getDeserializer(Type type) {
        ObjectDeserializer objectDeserializer = this.deserializers.get(type);
        if (objectDeserializer == null) {
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
        return objectDeserializer;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:119:0x0139 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:122:0x00a1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:134:0x0115 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:65:0x0169 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:68:0x0174 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.util.Iterator */
    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: java.lang.String */
    /* JADX WARN: Can't wrap try/catch for region: R(17:21|(6:27|28|29|(2:31|(3:34|35|37)(1:33))|38|39)|42|(5:111|112|(3:114|(2:116|(2:119|120)(1:118))|121)(2:122|(3:124|(2:126|(2:129|130)(1:128))|131))|102|103)|44|(1:46)|47|(1:49)(1:110)|50|51|52|(4:55|(2:58|56)|59|53)|60|(1:62)(1:107)|(3:64|(3:66|(3:68|69|70)|73)(2:75|(1:77)(2:78|(1:101)(2:88|(1:90)(2:91|(1:93)(2:94|(1:96)(2:97|(1:99)(1:100)))))))|74)(0)|102|103) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.Iterator] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0113 -> B:50:0x0115). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ObjectDeserializer getDeserializer(Class<?> cls, Type type) {
        String[] strArr;
        String[] strArr2;
        ObjectDeserializer objectDeserializer;
        String[] strArr3;
        Class<?> mappingTo;
        ObjectDeserializer objectDeserializer2 = this.deserializers.get(type);
        if (objectDeserializer2 == null) {
            if (type == null) {
                type = cls;
            }
            ObjectDeserializer objectDeserializer3 = this.deserializers.get(type);
            if (objectDeserializer3 == null) {
                JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
                if (jSONType != null && (mappingTo = jSONType.mappingTo()) != Void.class) {
                    return getDeserializer(mappingTo, mappingTo);
                }
                if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
                    objectDeserializer3 = this.deserializers.get(cls);
                }
                if (objectDeserializer3 == null) {
                    String replace = cls.getName().replace('$', '.');
                    if (replace.startsWith("java.awt.") && AwtCodec.support(cls) && !awtError) {
                        try {
                            for (String str : new String[]{"java.awt.Point", "java.awt.Font", "java.awt.Rectangle", "java.awt.Color"}) {
                                if (str.equals(replace)) {
                                    IdentityHashMap<Type, ObjectDeserializer> identityHashMap = this.deserializers;
                                    Class<?> cls2 = Class.forName(str);
                                    AwtCodec awtCodec = AwtCodec.instance;
                                    identityHashMap.put(cls2, awtCodec);
                                    return awtCodec;
                                }
                            }
                        } catch (Throwable th) {
                            awtError = true;
                        }
                        objectDeserializer3 = AwtCodec.instance;
                    }
                    if (!jdk8Error) {
                        try {
                            if (!replace.startsWith("java.time.")) {
                                if (replace.startsWith("java.util.Optional")) {
                                    for (String str2 : new String[]{"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"}) {
                                        if (str2.equals(replace)) {
                                            IdentityHashMap<Type, ObjectDeserializer> identityHashMap2 = this.deserializers;
                                            Class<?> cls3 = Class.forName(str2);
                                            objectDeserializer3 = OptionalCodec.instance;
                                            identityHashMap2.put(cls3, objectDeserializer3);
                                            break;
                                        }
                                    }
                                }
                            } else {
                                for (String str3 : new String[]{"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.ZoneId", "java.time.Period", "java.time.Duration", "java.time.Instant"}) {
                                    if (str3.equals(replace)) {
                                        IdentityHashMap<Type, ObjectDeserializer> identityHashMap3 = this.deserializers;
                                        Class<?> cls4 = Class.forName(str3);
                                        objectDeserializer3 = Jdk8DateCodec.instance;
                                        identityHashMap3.put(cls4, objectDeserializer3);
                                        break;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            jdk8Error = true;
                        }
                        return objectDeserializer3;
                    }
                    if (replace.equals("java.nio.file.Path")) {
                        IdentityHashMap<Type, ObjectDeserializer> identityHashMap4 = this.deserializers;
                        objectDeserializer3 = MiscCodec.instance;
                        identityHashMap4.put(cls, objectDeserializer3);
                    }
                    if (cls == Map.Entry.class) {
                        IdentityHashMap<Type, ObjectDeserializer> identityHashMap5 = this.deserializers;
                        ObjectDeserializer objectDeserializer4 = MiscCodec.instance;
                        identityHashMap5.put(cls, objectDeserializer4);
                        objectDeserializer = objectDeserializer4;
                    } else {
                        objectDeserializer = objectDeserializer3;
                    }
                    replace = ServiceLoader.load(AutowiredObjectDeserializer.class, Thread.currentThread().getContextClassLoader()).iterator();
                    while (replace.hasNext()) {
                        AutowiredObjectDeserializer autowiredObjectDeserializer = (AutowiredObjectDeserializer) replace.next();
                        for (Type type2 : autowiredObjectDeserializer.getAutowiredFor()) {
                            this.deserializers.put(type2, autowiredObjectDeserializer);
                        }
                    }
                    objectDeserializer3 = objectDeserializer == null ? this.deserializers.get(type) : objectDeserializer;
                    if (objectDeserializer3 == null) {
                        if (cls.isEnum()) {
                            JSONType jSONType2 = (JSONType) cls.getAnnotation(JSONType.class);
                            if (jSONType2 != null) {
                                try {
                                    objectDeserializer3 = (ObjectDeserializer) jSONType2.deserializer().newInstance();
                                    this.deserializers.put(cls, objectDeserializer3);
                                } catch (Throwable th3) {
                                }
                            }
                            objectDeserializer3 = new EnumDeserializer(cls);
                        } else if (cls.isArray()) {
                            objectDeserializer3 = ObjectArrayCodec.instance;
                        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class) {
                            objectDeserializer3 = CollectionCodec.instance;
                        } else if (Collection.class.isAssignableFrom(cls)) {
                            objectDeserializer3 = CollectionCodec.instance;
                        } else if (Map.class.isAssignableFrom(cls)) {
                            objectDeserializer3 = MapDeserializer.instance;
                        } else if (Throwable.class.isAssignableFrom(cls)) {
                            objectDeserializer3 = new ThrowableDeserializer(this, cls);
                        } else if (PropertyProcessable.class.isAssignableFrom(cls)) {
                            objectDeserializer3 = new PropertyProcessableDeserializer(cls);
                        } else {
                            objectDeserializer3 = createJavaBeanDeserializer(cls, type);
                        }
                        putDeserializer(type, objectDeserializer3);
                    }
                    return objectDeserializer3;
                }
                return objectDeserializer3;
            }
            return objectDeserializer3;
        }
        return objectDeserializer2;
    }

    public void initJavaBeanDeserializers(Class<?>... clsArr) {
        if (clsArr != null) {
            for (Class<?> cls : clsArr) {
                if (cls != null) {
                    putDeserializer(cls, createJavaBeanDeserializer(cls, cls));
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ObjectDeserializer createJavaBeanDeserializer(Class<?> cls, Type type) {
        boolean z;
        boolean z2 = false;
        boolean z3 = this.asmEnable & (!this.fieldBased);
        if (z3) {
            JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
            if (jSONType != null) {
                Class<?> deserializer = jSONType.deserializer();
                if (deserializer != Void.class) {
                    try {
                        Object newInstance = deserializer.newInstance();
                        if (newInstance instanceof ObjectDeserializer) {
                            return (ObjectDeserializer) newInstance;
                        }
                    } catch (Throwable th) {
                    }
                }
                z3 = jSONType.asm();
            }
            if (z3) {
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
                    if (builderClass == Object.class) {
                        break;
                    } else if (builderClass == null) {
                        z = z3;
                        break;
                    }
                }
                if (cls.getTypeParameters().length != 0) {
                    z = false;
                }
                if (z && this.asmFactory != null && this.asmFactory.classLoader.isExternalClass(cls)) {
                    z = false;
                }
                if (z) {
                    z = ASMUtils.checkName(cls.getSimpleName());
                }
                if (z) {
                    if (cls.isInterface()) {
                        z = false;
                    }
                    JavaBeanInfo build = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy);
                    if (z && build.fields.length > 200) {
                        z = false;
                    }
                    Constructor<?> constructor = build.defaultConstructor;
                    if (z && constructor == null && !cls.isInterface()) {
                        z = false;
                    }
                    FieldInfo[] fieldInfoArr = build.fields;
                    int length = fieldInfoArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        FieldInfo fieldInfo = fieldInfoArr[i];
                        if (!fieldInfo.getOnly) {
                            Class<?> cls2 = fieldInfo.fieldClass;
                            if (!Modifier.isPublic(cls2.getModifiers())) {
                                z = false;
                                break;
                            } else if (cls2.isMemberClass() && !Modifier.isStatic(cls2.getModifiers())) {
                                z = false;
                                break;
                            } else if (fieldInfo.getMember() != null && !ASMUtils.checkName(fieldInfo.getMember().getName())) {
                                z = false;
                                break;
                            } else {
                                JSONField annotation = fieldInfo.getAnnotation();
                                if ((annotation == null || (ASMUtils.checkName(annotation.name()) && annotation.format().length() == 0 && annotation.deserializeUsing() == Void.class && !annotation.unwrapped())) && (fieldInfo.method == null || fieldInfo.method.getParameterTypes().length <= 1)) {
                                    if (cls2.isEnum() && !(getDeserializer(cls2) instanceof EnumDeserializer)) {
                                        z = false;
                                        break;
                                    }
                                    i++;
                                }
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                }
                if (z || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
                    z2 = z;
                }
                if (z2) {
                    return new JavaBeanDeserializer(this, cls, type);
                }
                JavaBeanInfo build2 = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy);
                try {
                    return this.asmFactory.createJavaBeanDeserializer(this, build2);
                } catch (JSONException e) {
                    return new JavaBeanDeserializer(this, build2);
                } catch (NoSuchMethodException e2) {
                    return new JavaBeanDeserializer(this, cls, type);
                } catch (Exception e3) {
                    throw new JSONException("create asm deserializer error, " + cls.getName(), e3);
                }
            }
        }
        z = z3;
        if (cls.getTypeParameters().length != 0) {
        }
        if (z) {
            z = false;
        }
        if (z) {
        }
        if (z) {
        }
        if (z) {
        }
        z2 = z;
        if (z2) {
        }
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, FieldInfo fieldInfo) {
        Class<?> deserializeUsing;
        Class<?> cls = null;
        Class<?> cls2 = javaBeanInfo.clazz;
        Class<?> cls3 = fieldInfo.fieldClass;
        JSONField annotation = fieldInfo.getAnnotation();
        if (annotation != null && (deserializeUsing = annotation.deserializeUsing()) != Void.class) {
            cls = deserializeUsing;
        }
        return (cls == null && (cls3 == List.class || cls3 == ArrayList.class)) ? new ArrayListTypeFieldDeserializer(parserConfig, cls2, fieldInfo) : new DefaultFieldDeserializer(parserConfig, cls2, fieldInfo);
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        this.deserializers.put(type, objectDeserializer);
    }

    public ObjectDeserializer getDeserializer(FieldInfo fieldInfo) {
        return getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
    }

    public boolean isPrimitive(Class<?> cls) {
        return isPrimitive2(cls);
    }

    public static boolean isPrimitive2(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls == Date.class || cls == Time.class || cls == Timestamp.class || cls.isEnum();
    }

    public static void parserAllFieldToCache(Class<?> cls, Map<String, Field> map) {
        Field[] declaredFields;
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() != null && cls.getSuperclass() != Object.class) {
            parserAllFieldToCache(cls.getSuperclass(), map);
        }
    }

    public static Field getFieldFromCache(String str, Map<String, Field> map) {
        Field field;
        Field field2 = map.get(str);
        if (field2 == null) {
            field2 = map.get(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str);
        }
        if (field2 == null) {
            field2 = map.get("m_" + str);
        }
        if (field2 == null) {
            char charAt = str.charAt(0);
            if (charAt < 'a' || charAt > 'z') {
                field = field2;
            } else {
                char[] charArray = str.toCharArray();
                charArray[0] = (char) (charArray[0] - ' ');
                field = map.get(new String(charArray));
            }
            if (str.length() > 2) {
                char charAt2 = str.charAt(1);
                if (str.length() > 2 && charAt >= 'a' && charAt <= 'z' && charAt2 >= 'A' && charAt2 <= 'Z') {
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
        return field2;
    }

    public ClassLoader getDefaultClassLoader() {
        return this.defaultClassLoader;
    }

    public void setDefaultClassLoader(ClassLoader classLoader) {
        this.defaultClassLoader = classLoader;
    }

    public void addDeny(String str) {
        if (str != null && str.length() != 0) {
            for (String str2 : this.denyList) {
                if (str.equals(str2)) {
                    return;
                }
            }
            String[] strArr = new String[this.denyList.length + 1];
            System.arraycopy(this.denyList, 0, strArr, 0, this.denyList.length);
            strArr[strArr.length - 1] = str;
            this.denyList = strArr;
        }
    }

    public void addAccept(String str) {
        if (str != null && str.length() != 0) {
            for (String str2 : this.acceptList) {
                if (str.equals(str2)) {
                    return;
                }
            }
            String[] strArr = new String[this.acceptList.length + 1];
            System.arraycopy(this.acceptList, 0, strArr, 0, this.acceptList.length);
            strArr[strArr.length - 1] = str;
            this.acceptList = strArr;
        }
    }

    public Class<?> checkAutoType(String str, Class<?> cls) {
        return checkAutoType(str, cls, JSON.DEFAULT_PARSER_FEATURE);
    }

    public Class<?> checkAutoType(String str, Class<?> cls, int i) {
        Class<?> cls2;
        Class<?> cls3 = null;
        boolean z = false;
        if (str == null) {
            return null;
        }
        if (str.length() >= 128) {
            throw new JSONException("autoType is not support. " + str);
        }
        String replace = str.replace('$', '.');
        if (this.autoTypeSupport || cls != null) {
            for (int i2 = 0; i2 < this.acceptList.length; i2++) {
                if (replace.startsWith(this.acceptList[i2]) && (cls3 = TypeUtils.loadClass(str, this.defaultClassLoader, false)) != null) {
                    return cls3;
                }
            }
            for (int i3 = 0; i3 < this.denyList.length; i3++) {
                if (replace.startsWith(this.denyList[i3]) && TypeUtils.getClassFromMapping(str) == null) {
                    throw new JSONException("autoType is not support. " + str);
                }
            }
            cls2 = cls3;
        } else {
            cls2 = null;
        }
        if (cls2 == null) {
            cls2 = TypeUtils.getClassFromMapping(str);
        }
        if (cls2 == null) {
            cls2 = this.deserializers.findClass(str);
        }
        if (cls2 != null) {
            if (cls == null || cls2 == HashMap.class || cls.isAssignableFrom(cls2)) {
                return cls2;
            }
            throw new JSONException("type not match. " + str + " -> " + cls.getName());
        }
        if (!this.autoTypeSupport) {
            for (int i4 = 0; i4 < this.denyList.length; i4++) {
                if (replace.startsWith(this.denyList[i4])) {
                    throw new JSONException("autoType is not support. " + str);
                }
            }
            for (int i5 = 0; i5 < this.acceptList.length; i5++) {
                if (replace.startsWith(this.acceptList[i5])) {
                    Class<?> loadClass = cls2 == null ? TypeUtils.loadClass(str, this.defaultClassLoader, false) : cls2;
                    if (cls != null && cls.isAssignableFrom(loadClass)) {
                        throw new JSONException("type not match. " + str + " -> " + cls.getName());
                    }
                    return loadClass;
                }
            }
        }
        Class<?> loadClass2 = cls2 == null ? TypeUtils.loadClass(str, this.defaultClassLoader, false) : cls2;
        if (loadClass2 != null) {
            if (TypeUtils.getAnnotation(loadClass2, JSONType.class) == null) {
                if (ClassLoader.class.isAssignableFrom(loadClass2) || DataSource.class.isAssignableFrom(loadClass2)) {
                    throw new JSONException("autoType is not support. " + str);
                }
                if (cls != null) {
                    if (!cls.isAssignableFrom(loadClass2)) {
                        throw new JSONException("type not match. " + str + " -> " + cls.getName());
                    }
                    return loadClass2;
                } else if (JavaBeanInfo.build(loadClass2, loadClass2, this.propertyNamingStrategy).creatorConstructor != null && this.autoTypeSupport) {
                    throw new JSONException("autoType is not support. " + str);
                }
            } else {
                return loadClass2;
            }
        }
        int i6 = Feature.SupportAutoType.mask;
        if (!((!this.autoTypeSupport && (i & i6) == 0 && (i6 & JSON.DEFAULT_PARSER_FEATURE) == 0) ? true : true)) {
            throw new JSONException("autoType is not support. " + str);
        }
        return loadClass2;
    }
}
