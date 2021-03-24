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
import com.baidu.android.common.others.IStringUtil;
import com.baidu.webkit.sdk.LoadErrorCode;
import java.io.Closeable;
import java.io.File;
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
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
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
/* loaded from: classes.dex */
public class ParserConfig {
    public static final String AUTOTYPE_ACCEPT = "fastjson.parser.autoTypeAccept";
    public static final String[] AUTO_TYPE_ACCEPT_LIST;
    public static boolean awtError;
    public static ParserConfig global;
    public static boolean jdk8Error;
    public String[] acceptList;
    public boolean asmEnable;
    public ASMDeserializerFactory asmFactory;
    public boolean autoTypeSupport;
    public boolean compatibleWithJavaBean;
    public ClassLoader defaultClassLoader;
    public String[] denyList;
    public final IdentityHashMap<Type, ObjectDeserializer> deserializers;
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

    public ParserConfig() {
        this(false);
    }

    private void addItemsToAccept(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            addAccept(str);
        }
    }

    private void addItemsToDeny(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            addDeny(str);
        }
    }

    public static Field getFieldFromCache(String str, Map<String, Field> map) {
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

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    public static boolean isPrimitive2(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == Date.class || cls == java.sql.Date.class || cls == Time.class || cls == Timestamp.class || cls.isEnum();
    }

    public static void parserAllFieldToCache(Class<?> cls, Map<String, Field> map) {
        Field[] declaredFields;
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

    public static String[] splitItemsFormProperty(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(",");
    }

    public void addAccept(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        for (String str2 : this.acceptList) {
            if (str.equals(str2)) {
                return;
            }
        }
        String[] strArr = this.acceptList;
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        this.acceptList = strArr2;
    }

    public void addDeny(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        for (String str2 : this.denyList) {
            if (str.equals(str2)) {
                return;
            }
        }
        String[] strArr = this.denyList;
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        this.denyList = strArr2;
    }

    public Class<?> checkAutoType(String str, Class<?> cls) {
        return checkAutoType(str, cls, JSON.DEFAULT_PARSER_FEATURE);
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

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, FieldInfo fieldInfo) {
        Class<?> deserializeUsing;
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

    public ObjectDeserializer createJavaBeanDeserializer(Class<?> cls, Type type) {
        FieldInfo[] fieldInfoArr;
        JSONField annotation;
        Method method;
        ASMDeserializerFactory aSMDeserializerFactory;
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
                z = jSONType.asm();
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
            JavaBeanInfo build = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy);
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
                    if (Modifier.isPublic(cls2.getModifiers()) && ((!cls2.isMemberClass() || Modifier.isStatic(cls2.getModifiers())) && ((fieldInfo.getMember() == null || ASMUtils.checkName(fieldInfo.getMember().getName())) && (((annotation = fieldInfo.getAnnotation()) == null || (ASMUtils.checkName(annotation.name()) && annotation.format().length() == 0 && annotation.deserializeUsing() == Void.class && !annotation.unwrapped())) && (((method = fieldInfo.method) == null || method.getParameterTypes().length <= 1) && (!cls2.isEnum() || (getDeserializer(cls2) instanceof EnumDeserializer))))))) {
                    }
                }
                z = false;
                break;
            }
        }
        if (!z || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
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

    public ClassLoader getDefaultClassLoader() {
        return this.defaultClassLoader;
    }

    public ObjectDeserializer getDeserializer(Type type) {
        ObjectDeserializer objectDeserializer = this.deserializers.get(type);
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

    public IdentityHashMap<Type, ObjectDeserializer> getDeserializers() {
        return this.deserializers;
    }

    public void initJavaBeanDeserializers(Class<?>... clsArr) {
        if (clsArr == null) {
            return;
        }
        for (Class<?> cls : clsArr) {
            if (cls != null) {
                putDeserializer(cls, createJavaBeanDeserializer(cls, cls));
            }
        }
    }

    public boolean isAsmEnable() {
        return this.asmEnable;
    }

    public boolean isAutoTypeSupport() {
        return this.autoTypeSupport;
    }

    public boolean isPrimitive(Class<?> cls) {
        return isPrimitive2(cls);
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        this.deserializers.put(type, objectDeserializer);
    }

    public void setAsmEnable(boolean z) {
        this.asmEnable = z;
    }

    public void setAutoTypeSupport(boolean z) {
        this.autoTypeSupport = z;
    }

    public void setDefaultClassLoader(ClassLoader classLoader) {
        this.defaultClassLoader = classLoader;
    }

    public ParserConfig(boolean z) {
        this(null, null, z);
    }

    public Class<?> checkAutoType(String str, Class<?> cls, int i) {
        Class<?> cls2 = null;
        if (str == null) {
            return null;
        }
        if (str.length() < 128) {
            String replace = str.replace('$', IStringUtil.EXTENSION_SEPARATOR);
            boolean z = false;
            if (this.autoTypeSupport || cls != null) {
                int i2 = 0;
                while (true) {
                    String[] strArr = this.acceptList;
                    if (i2 >= strArr.length) {
                        int i3 = 0;
                        while (true) {
                            String[] strArr2 = this.denyList;
                            if (i3 >= strArr2.length) {
                                break;
                            } else if (replace.startsWith(strArr2[i3]) && TypeUtils.getClassFromMapping(str) == null) {
                                throw new JSONException("autoType is not support. " + str);
                            } else {
                                i3++;
                            }
                        }
                    } else if (replace.startsWith(strArr[i2]) && (cls2 = TypeUtils.loadClass(str, this.defaultClassLoader, false)) != null) {
                        return cls2;
                    } else {
                        i2++;
                    }
                }
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
                throw new JSONException("type not match. " + str + LoadErrorCode.TOKEN_NEXT + cls.getName());
            }
            if (!this.autoTypeSupport) {
                int i4 = 0;
                while (true) {
                    String[] strArr3 = this.denyList;
                    if (i4 >= strArr3.length) {
                        int i5 = 0;
                        while (true) {
                            String[] strArr4 = this.acceptList;
                            if (i5 >= strArr4.length) {
                                break;
                            } else if (replace.startsWith(strArr4[i5])) {
                                if (cls2 == null) {
                                    cls2 = TypeUtils.loadClass(str, this.defaultClassLoader, false);
                                }
                                if (cls == null || !cls.isAssignableFrom(cls2)) {
                                    return cls2;
                                }
                                throw new JSONException("type not match. " + str + LoadErrorCode.TOKEN_NEXT + cls.getName());
                            } else {
                                i5++;
                            }
                        }
                    } else if (replace.startsWith(strArr3[i4])) {
                        throw new JSONException("autoType is not support. " + str);
                    } else {
                        i4++;
                    }
                }
            }
            if (cls2 == null) {
                cls2 = TypeUtils.loadClass(str, this.defaultClassLoader, false);
            }
            if (cls2 != null) {
                if (TypeUtils.getAnnotation(cls2, JSONType.class) != null) {
                    return cls2;
                }
                if (ClassLoader.class.isAssignableFrom(cls2) || DataSource.class.isAssignableFrom(cls2)) {
                    throw new JSONException("autoType is not support. " + str);
                } else if (cls != null) {
                    if (cls.isAssignableFrom(cls2)) {
                        return cls2;
                    }
                    throw new JSONException("type not match. " + str + LoadErrorCode.TOKEN_NEXT + cls.getName());
                } else if (JavaBeanInfo.build(cls2, cls2, this.propertyNamingStrategy).creatorConstructor != null && this.autoTypeSupport) {
                    throw new JSONException("autoType is not support. " + str);
                }
            }
            int i6 = Feature.SupportAutoType.mask;
            if ((!this.autoTypeSupport && (i & i6) == 0 && (i6 & JSON.DEFAULT_PARSER_FEATURE) == 0) ? true : true) {
                return cls2;
            }
            throw new JSONException("autoType is not support. " + str);
        }
        throw new JSONException("autoType is not support. " + str);
    }

    public ParserConfig(ClassLoader classLoader) {
        this(null, classLoader, false);
    }

    public ParserConfig(ASMDeserializerFactory aSMDeserializerFactory) {
        this(aSMDeserializerFactory, null, false);
    }

    public ParserConfig(ASMDeserializerFactory aSMDeserializerFactory, ClassLoader classLoader, boolean z) {
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
        this.deserializers.put(SimpleDateFormat.class, MiscCodec.instance);
        this.deserializers.put(Timestamp.class, SqlDateDeserializer.instance_timestamp);
        this.deserializers.put(java.sql.Date.class, SqlDateDeserializer.instance);
        this.deserializers.put(Time.class, TimeDeserializer.instance);
        this.deserializers.put(Date.class, DateCodec.instance);
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

    public ObjectDeserializer getDeserializer(Class<?> cls, Type type) {
        ObjectDeserializer objectDeserializer;
        Class<?> mappingTo;
        Type type2 = type;
        ObjectDeserializer objectDeserializer2 = this.deserializers.get(type2);
        if (objectDeserializer2 != null) {
            return objectDeserializer2;
        }
        if (type2 == null) {
            type2 = cls;
        }
        ObjectDeserializer objectDeserializer3 = this.deserializers.get(type2);
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
        if (jSONType != null && (mappingTo = jSONType.mappingTo()) != Void.class) {
            return getDeserializer(mappingTo, mappingTo);
        }
        if ((type2 instanceof WildcardType) || (type2 instanceof TypeVariable) || (type2 instanceof ParameterizedType)) {
            objectDeserializer3 = this.deserializers.get(cls);
        }
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        String replace = cls.getName().replace('$', IStringUtil.EXTENSION_SEPARATOR);
        int i = 0;
        if (replace.startsWith("java.awt.") && AwtCodec.support(cls) && !awtError) {
            String[] strArr = {"java.awt.Point", "java.awt.Font", "java.awt.Rectangle", "java.awt.Color"};
            for (int i2 = 0; i2 < 4; i2++) {
                try {
                    String str = strArr[i2];
                    if (str.equals(replace)) {
                        IdentityHashMap<Type, ObjectDeserializer> identityHashMap = this.deserializers;
                        Class<?> cls2 = Class.forName(str);
                        AwtCodec awtCodec = AwtCodec.instance;
                        identityHashMap.put(cls2, awtCodec);
                        return awtCodec;
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
                    while (i < 12) {
                        String str2 = strArr2[i];
                        if (str2.equals(replace)) {
                            IdentityHashMap<Type, ObjectDeserializer> identityHashMap2 = this.deserializers;
                            Class<?> cls3 = Class.forName(str2);
                            Jdk8DateCodec jdk8DateCodec = Jdk8DateCodec.instance;
                            identityHashMap2.put(cls3, jdk8DateCodec);
                            return jdk8DateCodec;
                        }
                        i++;
                    }
                } else if (replace.startsWith("java.util.Optional")) {
                    String[] strArr3 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};
                    while (i < 4) {
                        String str3 = strArr3[i];
                        if (str3.equals(replace)) {
                            IdentityHashMap<Type, ObjectDeserializer> identityHashMap3 = this.deserializers;
                            Class<?> cls4 = Class.forName(str3);
                            OptionalCodec optionalCodec = OptionalCodec.instance;
                            identityHashMap3.put(cls4, optionalCodec);
                            return optionalCodec;
                        }
                        i++;
                    }
                }
            } catch (Throwable unused2) {
                jdk8Error = true;
            }
        }
        if (replace.equals("java.nio.file.Path")) {
            IdentityHashMap<Type, ObjectDeserializer> identityHashMap4 = this.deserializers;
            objectDeserializer3 = MiscCodec.instance;
            identityHashMap4.put(cls, objectDeserializer3);
        }
        if (cls == Map.Entry.class) {
            IdentityHashMap<Type, ObjectDeserializer> identityHashMap5 = this.deserializers;
            objectDeserializer3 = MiscCodec.instance;
            identityHashMap5.put(cls, objectDeserializer3);
        }
        try {
            for (AutowiredObjectDeserializer autowiredObjectDeserializer : ServiceLoader.load(AutowiredObjectDeserializer.class, Thread.currentThread().getContextClassLoader())) {
                for (Type type3 : autowiredObjectDeserializer.getAutowiredFor()) {
                    this.deserializers.put(type3, autowiredObjectDeserializer);
                }
            }
        } catch (Exception unused3) {
        }
        if (objectDeserializer3 == null) {
            objectDeserializer3 = this.deserializers.get(type2);
        }
        if (objectDeserializer3 != null) {
            return objectDeserializer3;
        }
        if (cls.isEnum()) {
            JSONType jSONType2 = (JSONType) cls.getAnnotation(JSONType.class);
            if (jSONType2 != null) {
                try {
                    ObjectDeserializer objectDeserializer4 = (ObjectDeserializer) jSONType2.deserializer().newInstance();
                    this.deserializers.put(cls, objectDeserializer4);
                    return objectDeserializer4;
                } catch (Throwable unused4) {
                }
            }
            objectDeserializer = new EnumDeserializer(cls);
        } else if (cls.isArray()) {
            objectDeserializer = ObjectArrayCodec.instance;
        } else if (cls != Set.class && cls != HashSet.class && cls != Collection.class && cls != List.class && cls != ArrayList.class) {
            if (Collection.class.isAssignableFrom(cls)) {
                objectDeserializer = CollectionCodec.instance;
            } else if (Map.class.isAssignableFrom(cls)) {
                objectDeserializer = MapDeserializer.instance;
            } else if (Throwable.class.isAssignableFrom(cls)) {
                objectDeserializer = new ThrowableDeserializer(this, cls);
            } else if (PropertyProcessable.class.isAssignableFrom(cls)) {
                objectDeserializer = new PropertyProcessableDeserializer(cls);
            } else {
                objectDeserializer = createJavaBeanDeserializer(cls, type2);
            }
        } else {
            objectDeserializer = CollectionCodec.instance;
        }
        putDeserializer(type2, objectDeserializer);
        return objectDeserializer;
    }

    public ObjectDeserializer getDeserializer(FieldInfo fieldInfo) {
        return getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
    }
}
