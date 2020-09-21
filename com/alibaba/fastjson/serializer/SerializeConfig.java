package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.support.springfox.SwaggerJsonSerializer;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;
/* loaded from: classes10.dex */
public class SerializeConfig {
    private boolean asm;
    private ASMSerializerFactory asmFactory;
    private final boolean fieldBased;
    public PropertyNamingStrategy propertyNamingStrategy;
    private final IdentityHashMap<Type, ObjectSerializer> serializers;
    protected String typeKey;
    public static final SerializeConfig globalInstance = new SerializeConfig();
    private static boolean awtError = false;
    private static boolean jdk8Error = false;
    private static boolean oracleJdbcError = false;
    private static boolean springfoxError = false;
    private static boolean guavaError = false;
    private static boolean jsonnullError = false;

    public String getTypeKey() {
        return this.typeKey;
    }

    public void setTypeKey(String str) {
        this.typeKey = str;
    }

    private final JavaBeanSerializer createASMSerializer(SerializeBeanInfo serializeBeanInfo) throws Exception {
        JavaBeanSerializer createJavaBeanSerializer = this.asmFactory.createJavaBeanSerializer(serializeBeanInfo);
        for (int i = 0; i < createJavaBeanSerializer.sortedGetters.length; i++) {
            Class<?> cls = createJavaBeanSerializer.sortedGetters[i].fieldInfo.fieldClass;
            if (cls.isEnum() && !(getObjectWriter(cls) instanceof EnumSerializer)) {
                createJavaBeanSerializer.writeDirect = false;
            }
        }
        return createJavaBeanSerializer;
    }

    public final ObjectSerializer createJavaBeanSerializer(Class<?> cls) {
        SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, null, this.propertyNamingStrategy, this.fieldBased);
        return (buildBeanInfo.fields.length == 0 && Iterable.class.isAssignableFrom(cls)) ? MiscCodec.instance : createJavaBeanSerializer(buildBeanInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        r0 = createASMSerializer(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a7, code lost:
        if (r0 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x012e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0148, code lost:
        throw new com.alibaba.fastjson.JSONException("create asm serializer error, class " + r5, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ObjectSerializer createJavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        boolean z;
        FieldInfo[] fieldInfoArr;
        Method method;
        SerializerFeature[] serialzeFeatures;
        SerializerFeature[] serialzeFeatures2;
        boolean z2 = false;
        JSONType jSONType = serializeBeanInfo.jsonType;
        boolean z3 = this.asm && !this.fieldBased;
        if (jSONType != null) {
            Class<?> serializer = jSONType.serializer();
            if (serializer != Void.class) {
                try {
                    Object newInstance = serializer.newInstance();
                    if (newInstance instanceof ObjectSerializer) {
                        return (ObjectSerializer) newInstance;
                    }
                } catch (Throwable th) {
                }
            }
            z = !jSONType.asm() ? false : z3;
            for (SerializerFeature serializerFeature : jSONType.serialzeFeatures()) {
                if (SerializerFeature.WriteNonStringValueAsString == serializerFeature || SerializerFeature.WriteEnumUsingToString == serializerFeature || SerializerFeature.NotWriteDefaultValue == serializerFeature) {
                    z = false;
                    break;
                }
            }
        } else {
            z = z3;
        }
        Class<?> cls = serializeBeanInfo.beanType;
        if (!Modifier.isPublic(serializeBeanInfo.beanType.getModifiers())) {
            return new JavaBeanSerializer(serializeBeanInfo);
        }
        if ((z && this.asmFactory.classLoader.isExternalClass(cls)) || cls == Serializable.class || cls == Object.class) {
            z = false;
        }
        if (z && !ASMUtils.checkName(cls.getSimpleName())) {
            z = false;
        }
        if (z && serializeBeanInfo.beanType.isInterface()) {
            z = false;
        }
        if (z) {
            for (FieldInfo fieldInfo : serializeBeanInfo.fields) {
                Field field = fieldInfo.field;
                if ((field != null && !field.getType().equals(fieldInfo.fieldClass)) || ((method = fieldInfo.method) != null && !method.getReturnType().equals(fieldInfo.fieldClass))) {
                    break;
                }
                JSONField annotation = fieldInfo.getAnnotation();
                if (annotation != null) {
                    String format = annotation.format();
                    if ((format.length() != 0 && (fieldInfo.fieldClass != String.class || !"trim".equals(format))) || !ASMUtils.checkName(annotation.name()) || annotation.jsonDirect() || annotation.serializeUsing() != Void.class || annotation.unwrapped()) {
                        break;
                    }
                    for (SerializerFeature serializerFeature2 : annotation.serialzeFeatures()) {
                        if (SerializerFeature.WriteNonStringValueAsString == serializerFeature2 || SerializerFeature.WriteEnumUsingToString == serializerFeature2 || SerializerFeature.NotWriteDefaultValue == serializerFeature2 || SerializerFeature.WriteClassName == serializerFeature2) {
                            z = false;
                            break;
                        }
                    }
                    if (TypeUtils.isAnnotationPresentOneToMany(method) || TypeUtils.isAnnotationPresentManyToMany(method)) {
                        z2 = true;
                        break;
                    }
                }
            }
        }
        z2 = z;
        return new JavaBeanSerializer(serializeBeanInfo);
    }

    public boolean isAsmEnable() {
        return this.asm;
    }

    public void setAsmEnable(boolean z) {
        if (!ASMUtils.IS_ANDROID) {
            this.asm = z;
        }
    }

    public static SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    public SerializeConfig() {
        this(8192);
    }

    public SerializeConfig(boolean z) {
        this(8192, z);
    }

    public SerializeConfig(int i) {
        this(i, false);
    }

    public SerializeConfig(int i, boolean z) {
        this.asm = !ASMUtils.IS_ANDROID;
        this.typeKey = JSON.DEFAULT_TYPE_KEY;
        this.fieldBased = z;
        this.serializers = new IdentityHashMap<>(i);
        try {
            if (this.asm) {
                this.asmFactory = new ASMSerializerFactory();
            }
        } catch (Throwable th) {
            this.asm = false;
        }
        put(Boolean.class, (ObjectSerializer) BooleanCodec.instance);
        put(Character.class, (ObjectSerializer) CharacterCodec.instance);
        put(Byte.class, (ObjectSerializer) IntegerCodec.instance);
        put(Short.class, (ObjectSerializer) IntegerCodec.instance);
        put(Integer.class, (ObjectSerializer) IntegerCodec.instance);
        put(Long.class, (ObjectSerializer) LongCodec.instance);
        put(Float.class, (ObjectSerializer) FloatCodec.instance);
        put(Double.class, (ObjectSerializer) DoubleSerializer.instance);
        put(BigDecimal.class, (ObjectSerializer) BigDecimalCodec.instance);
        put(BigInteger.class, (ObjectSerializer) BigIntegerCodec.instance);
        put(String.class, (ObjectSerializer) StringCodec.instance);
        put(byte[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(short[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(int[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(long[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(float[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(double[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(boolean[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(char[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put(Object[].class, (ObjectSerializer) ObjectArrayCodec.instance);
        put(Class.class, (ObjectSerializer) MiscCodec.instance);
        put(SimpleDateFormat.class, (ObjectSerializer) MiscCodec.instance);
        put(Currency.class, (ObjectSerializer) new MiscCodec());
        put(TimeZone.class, (ObjectSerializer) MiscCodec.instance);
        put(InetAddress.class, (ObjectSerializer) MiscCodec.instance);
        put(Inet4Address.class, (ObjectSerializer) MiscCodec.instance);
        put(Inet6Address.class, (ObjectSerializer) MiscCodec.instance);
        put(InetSocketAddress.class, (ObjectSerializer) MiscCodec.instance);
        put(File.class, (ObjectSerializer) MiscCodec.instance);
        put(Appendable.class, (ObjectSerializer) AppendableSerializer.instance);
        put(StringBuffer.class, (ObjectSerializer) AppendableSerializer.instance);
        put(StringBuilder.class, (ObjectSerializer) AppendableSerializer.instance);
        put(Charset.class, (ObjectSerializer) ToStringSerializer.instance);
        put(Pattern.class, (ObjectSerializer) ToStringSerializer.instance);
        put(Locale.class, (ObjectSerializer) ToStringSerializer.instance);
        put(URI.class, (ObjectSerializer) ToStringSerializer.instance);
        put(URL.class, (ObjectSerializer) ToStringSerializer.instance);
        put(UUID.class, (ObjectSerializer) ToStringSerializer.instance);
        put(AtomicBoolean.class, (ObjectSerializer) AtomicCodec.instance);
        put(AtomicInteger.class, (ObjectSerializer) AtomicCodec.instance);
        put(AtomicLong.class, (ObjectSerializer) AtomicCodec.instance);
        put(AtomicReference.class, (ObjectSerializer) ReferenceCodec.instance);
        put(AtomicIntegerArray.class, (ObjectSerializer) AtomicCodec.instance);
        put(AtomicLongArray.class, (ObjectSerializer) AtomicCodec.instance);
        put(WeakReference.class, (ObjectSerializer) ReferenceCodec.instance);
        put(SoftReference.class, (ObjectSerializer) ReferenceCodec.instance);
        put(LinkedList.class, (ObjectSerializer) CollectionCodec.instance);
    }

    public void addFilter(Class<?> cls, SerializeFilter serializeFilter) {
        ObjectSerializer objectWriter = getObjectWriter(cls);
        if (objectWriter instanceof SerializeFilterable) {
            SerializeFilterable serializeFilterable = (SerializeFilterable) objectWriter;
            if (this != globalInstance && serializeFilterable == MapSerializer.instance) {
                MapSerializer mapSerializer = new MapSerializer();
                put((Type) cls, (ObjectSerializer) mapSerializer);
                mapSerializer.addFilter(serializeFilter);
                return;
            }
            serializeFilterable.addFilter(serializeFilter);
        }
    }

    public void config(Class<?> cls, SerializerFeature serializerFeature, boolean z) {
        ObjectSerializer objectWriter = getObjectWriter(cls, false);
        if (objectWriter == null) {
            SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, null, this.propertyNamingStrategy);
            if (z) {
                buildBeanInfo.features |= serializerFeature.mask;
            } else {
                buildBeanInfo.features &= serializerFeature.mask ^ (-1);
            }
            put((Type) cls, createJavaBeanSerializer(buildBeanInfo));
        } else if (objectWriter instanceof JavaBeanSerializer) {
            SerializeBeanInfo serializeBeanInfo = ((JavaBeanSerializer) objectWriter).beanInfo;
            int i = serializeBeanInfo.features;
            if (z) {
                serializeBeanInfo.features |= serializerFeature.mask;
            } else {
                serializeBeanInfo.features &= serializerFeature.mask ^ (-1);
            }
            if (i != serializeBeanInfo.features && objectWriter.getClass() != JavaBeanSerializer.class) {
                put((Type) cls, createJavaBeanSerializer(serializeBeanInfo));
            }
        }
    }

    public ObjectSerializer getObjectWriter(Class<?> cls) {
        return getObjectWriter(cls, true);
    }

    private ObjectSerializer getObjectWriter(Class<?> cls, boolean z) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        String[] strArr6;
        ClassLoader classLoader;
        ObjectSerializer objectSerializer = this.serializers.get(cls);
        if (objectSerializer == null) {
            try {
                for (Object obj : ServiceLoader.load(AutowiredObjectSerializer.class, Thread.currentThread().getContextClassLoader())) {
                    if (obj instanceof AutowiredObjectSerializer) {
                        AutowiredObjectSerializer autowiredObjectSerializer = (AutowiredObjectSerializer) obj;
                        for (Type type : autowiredObjectSerializer.getAutowiredFor()) {
                            put(type, (ObjectSerializer) autowiredObjectSerializer);
                        }
                    }
                }
            } catch (ClassCastException e) {
            }
            objectSerializer = this.serializers.get(cls);
        }
        if (objectSerializer == null && (classLoader = JSON.class.getClassLoader()) != Thread.currentThread().getContextClassLoader()) {
            try {
                for (Object obj2 : ServiceLoader.load(AutowiredObjectSerializer.class, classLoader)) {
                    if (obj2 instanceof AutowiredObjectSerializer) {
                        AutowiredObjectSerializer autowiredObjectSerializer2 = (AutowiredObjectSerializer) obj2;
                        for (Type type2 : autowiredObjectSerializer2.getAutowiredFor()) {
                            put(type2, (ObjectSerializer) autowiredObjectSerializer2);
                        }
                    }
                }
            } catch (ClassCastException e2) {
            }
            objectSerializer = this.serializers.get(cls);
        }
        if (objectSerializer == null) {
            String name = cls.getName();
            if (Map.class.isAssignableFrom(cls)) {
                objectSerializer = MapSerializer.instance;
                put((Type) cls, objectSerializer);
            } else if (List.class.isAssignableFrom(cls)) {
                objectSerializer = ListSerializer.instance;
                put((Type) cls, objectSerializer);
            } else if (Collection.class.isAssignableFrom(cls)) {
                objectSerializer = CollectionCodec.instance;
                put((Type) cls, objectSerializer);
            } else if (Date.class.isAssignableFrom(cls)) {
                objectSerializer = DateCodec.instance;
                put((Type) cls, objectSerializer);
            } else if (JSONAware.class.isAssignableFrom(cls)) {
                objectSerializer = JSONAwareSerializer.instance;
                put((Type) cls, objectSerializer);
            } else if (JSONSerializable.class.isAssignableFrom(cls)) {
                objectSerializer = JSONSerializableSerializer.instance;
                put((Type) cls, objectSerializer);
            } else if (JSONStreamAware.class.isAssignableFrom(cls)) {
                objectSerializer = MiscCodec.instance;
                put((Type) cls, objectSerializer);
            } else if (cls.isEnum()) {
                JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
                if (jSONType != null && jSONType.serializeEnumAsJavaBean()) {
                    objectSerializer = createJavaBeanSerializer(cls);
                    put((Type) cls, objectSerializer);
                } else {
                    objectSerializer = EnumSerializer.instance;
                    put((Type) cls, objectSerializer);
                }
            } else {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass != null && superclass.isEnum()) {
                    JSONType jSONType2 = (JSONType) TypeUtils.getAnnotation(superclass, JSONType.class);
                    if (jSONType2 != null && jSONType2.serializeEnumAsJavaBean()) {
                        objectSerializer = createJavaBeanSerializer(cls);
                        put((Type) cls, objectSerializer);
                    } else {
                        objectSerializer = EnumSerializer.instance;
                        put((Type) cls, objectSerializer);
                    }
                } else if (cls.isArray()) {
                    Class<?> componentType = cls.getComponentType();
                    objectSerializer = new ArraySerializer(componentType, getObjectWriter(componentType));
                    put((Type) cls, objectSerializer);
                } else if (Throwable.class.isAssignableFrom(cls)) {
                    SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, null, this.propertyNamingStrategy);
                    buildBeanInfo.features |= SerializerFeature.WriteClassName.mask;
                    objectSerializer = new JavaBeanSerializer(buildBeanInfo);
                    put((Type) cls, objectSerializer);
                } else if (TimeZone.class.isAssignableFrom(cls) || Map.Entry.class.isAssignableFrom(cls)) {
                    objectSerializer = MiscCodec.instance;
                    put((Type) cls, objectSerializer);
                } else if (Appendable.class.isAssignableFrom(cls)) {
                    objectSerializer = AppendableSerializer.instance;
                    put((Type) cls, objectSerializer);
                } else if (Charset.class.isAssignableFrom(cls)) {
                    objectSerializer = ToStringSerializer.instance;
                    put((Type) cls, objectSerializer);
                } else if (Enumeration.class.isAssignableFrom(cls)) {
                    objectSerializer = EnumerationSerializer.instance;
                    put((Type) cls, objectSerializer);
                } else if (Calendar.class.isAssignableFrom(cls) || XMLGregorianCalendar.class.isAssignableFrom(cls)) {
                    objectSerializer = CalendarCodec.instance;
                    put((Type) cls, objectSerializer);
                } else if (Clob.class.isAssignableFrom(cls)) {
                    objectSerializer = ClobSeriliazer.instance;
                    put((Type) cls, objectSerializer);
                } else if (TypeUtils.isPath(cls)) {
                    objectSerializer = ToStringSerializer.instance;
                    put((Type) cls, objectSerializer);
                } else if (Iterator.class.isAssignableFrom(cls)) {
                    objectSerializer = MiscCodec.instance;
                    put((Type) cls, objectSerializer);
                } else {
                    if (name.startsWith("java.awt.") && AwtCodec.support(cls) && !awtError) {
                        try {
                            for (String str : new String[]{"java.awt.Color", "java.awt.Font", "java.awt.Point", "java.awt.Rectangle"}) {
                                if (str.equals(name)) {
                                    Type cls2 = Class.forName(str);
                                    objectSerializer = AwtCodec.instance;
                                    put(cls2, objectSerializer);
                                    return objectSerializer;
                                }
                            }
                        } catch (Throwable th) {
                            awtError = true;
                        }
                    }
                    if (!jdk8Error && (name.startsWith("java.time.") || name.startsWith("java.util.Optional") || name.equals("java.util.concurrent.atomic.LongAdder") || name.equals("java.util.concurrent.atomic.DoubleAdder"))) {
                        try {
                            for (String str2 : new String[]{"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.Period", "java.time.Duration", "java.time.Instant"}) {
                                if (str2.equals(name)) {
                                    Type cls3 = Class.forName(str2);
                                    ObjectSerializer objectSerializer2 = Jdk8DateCodec.instance;
                                    put(cls3, objectSerializer2);
                                    return objectSerializer2;
                                }
                            }
                            for (String str3 : new String[]{"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"}) {
                                if (str3.equals(name)) {
                                    Type cls4 = Class.forName(str3);
                                    ObjectSerializer objectSerializer3 = OptionalCodec.instance;
                                    put(cls4, objectSerializer3);
                                    return objectSerializer3;
                                }
                            }
                            for (String str4 : new String[]{"java.util.concurrent.atomic.LongAdder", "java.util.concurrent.atomic.DoubleAdder"}) {
                                if (str4.equals(name)) {
                                    Type cls5 = Class.forName(str4);
                                    ObjectSerializer objectSerializer4 = AdderSerializer.instance;
                                    put(cls5, objectSerializer4);
                                    return objectSerializer4;
                                }
                            }
                        } catch (Throwable th2) {
                            jdk8Error = true;
                        }
                    }
                    if (!oracleJdbcError && name.startsWith("oracle.sql.")) {
                        try {
                            for (String str5 : new String[]{"oracle.sql.DATE", "oracle.sql.TIMESTAMP"}) {
                                if (str5.equals(name)) {
                                    Type cls6 = Class.forName(str5);
                                    objectSerializer = DateCodec.instance;
                                    put(cls6, objectSerializer);
                                    return objectSerializer;
                                }
                            }
                        } catch (Throwable th3) {
                            oracleJdbcError = true;
                        }
                    }
                    if (!springfoxError && name.equals("springfox.documentation.spring.web.json.Json")) {
                        try {
                            Type cls7 = Class.forName("springfox.documentation.spring.web.json.Json");
                            objectSerializer = SwaggerJsonSerializer.instance;
                            put(cls7, objectSerializer);
                            return objectSerializer;
                        } catch (ClassNotFoundException e3) {
                            springfoxError = true;
                        }
                    }
                    if (!guavaError && name.startsWith("com.google.common.collect.")) {
                        try {
                            for (String str6 : new String[]{"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"}) {
                                if (str6.equals(name)) {
                                    Type cls8 = Class.forName(str6);
                                    objectSerializer = GuavaCodec.instance;
                                    put(cls8, objectSerializer);
                                    return objectSerializer;
                                }
                            }
                        } catch (ClassNotFoundException e4) {
                            guavaError = true;
                        }
                    }
                    if (!jsonnullError && name.equals("net.sf.json.JSONNull")) {
                        try {
                            Type cls9 = Class.forName("net.sf.json.JSONNull");
                            objectSerializer = MiscCodec.instance;
                            put(cls9, objectSerializer);
                            return objectSerializer;
                        } catch (ClassNotFoundException e5) {
                            jsonnullError = true;
                        }
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
                        return AnnotationSerializer.instance;
                    }
                    if (TypeUtils.isProxy(cls)) {
                        ObjectSerializer objectWriter = getObjectWriter(cls.getSuperclass());
                        put((Type) cls, objectWriter);
                        return objectWriter;
                    }
                    if (Proxy.isProxyClass(cls)) {
                        Class<?> cls10 = null;
                        if (interfaces.length == 2) {
                            cls10 = interfaces[1];
                        } else {
                            int length = interfaces.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    break;
                                }
                                Class<?> cls11 = interfaces[i];
                                if (!cls11.getName().startsWith("org.springframework.aop.")) {
                                    if (cls10 != null) {
                                        cls10 = null;
                                        break;
                                    }
                                    cls10 = cls11;
                                }
                                i++;
                            }
                        }
                        if (cls10 != null) {
                            ObjectSerializer objectWriter2 = getObjectWriter(cls10);
                            put((Type) cls, objectWriter2);
                            return objectWriter2;
                        }
                    }
                    if (z) {
                        objectSerializer = createJavaBeanSerializer(cls);
                        put((Type) cls, objectSerializer);
                    }
                }
            }
            if (objectSerializer == null) {
                return this.serializers.get(cls);
            }
            return objectSerializer;
        }
        return objectSerializer;
    }

    public final ObjectSerializer get(Type type) {
        return this.serializers.get(type);
    }

    public boolean put(Object obj, Object obj2) {
        return put((Type) obj, (ObjectSerializer) obj2);
    }

    public boolean put(Type type, ObjectSerializer objectSerializer) {
        return this.serializers.put(type, objectSerializer);
    }

    public void configEnumAsJavaBean(Class<? extends Enum>... clsArr) {
        for (Class<? extends Enum> cls : clsArr) {
            put((Type) cls, createJavaBeanSerializer(cls));
        }
    }

    public void setPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy) {
        this.propertyNamingStrategy = propertyNamingStrategy;
    }
}
