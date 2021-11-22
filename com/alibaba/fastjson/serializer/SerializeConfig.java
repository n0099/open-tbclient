package com.alibaba.fastjson.serializer;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.spi.Module;
import com.alibaba.fastjson.support.moneta.MonetaCodec;
import com.alibaba.fastjson.support.springfox.SwaggerJsonSerializer;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
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
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.w3c.dom.Node;
/* loaded from: classes6.dex */
public class SerializeConfig {
    public static /* synthetic */ Interceptable $ic;
    public static boolean awtError;
    public static final SerializeConfig globalInstance;
    public static boolean guavaError;
    public static boolean jdk8Error;
    public static boolean jodaError;
    public static boolean oracleJdbcError;
    public static boolean springfoxError;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean asm;
    public ASMSerializerFactory asmFactory;
    public long[] denyClasses;
    public final boolean fieldBased;
    public final IdentityHashMap<Type, IdentityHashMap<Type, ObjectSerializer>> mixInSerializers;
    public List<Module> modules;
    public PropertyNamingStrategy propertyNamingStrategy;
    public final IdentityHashMap<Type, ObjectSerializer> serializers;
    public String typeKey;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-112628264, "Lcom/alibaba/fastjson/serializer/SerializeConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-112628264, "Lcom/alibaba/fastjson/serializer/SerializeConfig;");
                return;
            }
        }
        globalInstance = new SerializeConfig();
        awtError = false;
        jdk8Error = false;
        oracleJdbcError = false;
        springfoxError = false;
        guavaError = false;
        jodaError = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerializeConfig() {
        this(8192);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private final JavaBeanSerializer createASMSerializer(SerializeBeanInfo serializeBeanInfo) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, serializeBeanInfo)) != null) {
            return (JavaBeanSerializer) invokeL.objValue;
        }
        JavaBeanSerializer createJavaBeanSerializer = this.asmFactory.createJavaBeanSerializer(serializeBeanInfo);
        int i2 = 0;
        while (true) {
            FieldSerializer[] fieldSerializerArr = createJavaBeanSerializer.sortedGetters;
            if (i2 >= fieldSerializerArr.length) {
                return createJavaBeanSerializer;
            }
            Class<?> cls = fieldSerializerArr[i2].fieldInfo.fieldClass;
            if (cls.isEnum() && !(getObjectWriter(cls) instanceof EnumSerializer)) {
                createJavaBeanSerializer.writeDirect = false;
            }
            i2++;
        }
    }

    public static Member getEnumValueField(Class cls) {
        InterceptResult invokeL;
        Method[] methods;
        Field[] fields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, cls)) == null) {
            Method method = null;
            for (Method method2 : cls.getMethods()) {
                if (method2.getReturnType() != Void.class && ((JSONField) method2.getAnnotation(JSONField.class)) != null) {
                    if (method != null) {
                        return null;
                    }
                    method = method2;
                }
            }
            for (Field field : cls.getFields()) {
                if (((JSONField) field.getAnnotation(JSONField.class)) != null) {
                    if (method != null) {
                        return null;
                    }
                    method = field;
                }
            }
            return method;
        }
        return (Member) invokeL.objValue;
    }

    public static SerializeConfig getGlobalInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? globalInstance : (SerializeConfig) invokeV.objValue;
    }

    private void initSerializers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
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
    }

    public void addFilter(Class<?> cls, SerializeFilter serializeFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cls, serializeFilter) == null) {
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
    }

    public void clearSerializers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.serializers.clear();
            initSerializers();
        }
    }

    public void config(Class<?> cls, SerializerFeature serializerFeature, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, cls, serializerFeature, z) == null) {
            ObjectSerializer objectWriter = getObjectWriter(cls, false);
            if (objectWriter == null) {
                SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, null, this.propertyNamingStrategy);
                if (z) {
                    buildBeanInfo.features = serializerFeature.mask | buildBeanInfo.features;
                } else {
                    buildBeanInfo.features = (~serializerFeature.mask) & buildBeanInfo.features;
                }
                put((Type) cls, createJavaBeanSerializer(buildBeanInfo));
            } else if (objectWriter instanceof JavaBeanSerializer) {
                SerializeBeanInfo serializeBeanInfo = ((JavaBeanSerializer) objectWriter).beanInfo;
                int i2 = serializeBeanInfo.features;
                if (z) {
                    serializeBeanInfo.features = serializerFeature.mask | i2;
                } else {
                    serializeBeanInfo.features = (~serializerFeature.mask) & i2;
                }
                if (i2 == serializeBeanInfo.features || objectWriter.getClass() == JavaBeanSerializer.class) {
                    return;
                }
                put((Type) cls, createJavaBeanSerializer(serializeBeanInfo));
            }
        }
    }

    public void configEnumAsJavaBean(Class<? extends Enum>... clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, clsArr) == null) {
            for (Class<? extends Enum> cls : clsArr) {
                put((Type) cls, createJavaBeanSerializer(cls));
            }
        }
    }

    public final ObjectSerializer createJavaBeanSerializer(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            String name = cls.getName();
            if (Arrays.binarySearch(this.denyClasses, TypeUtils.fnv1a_64(name)) < 0) {
                SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, null, this.propertyNamingStrategy, this.fieldBased);
                if (buildBeanInfo.fields.length == 0 && Iterable.class.isAssignableFrom(cls)) {
                    return MiscCodec.instance;
                }
                return createJavaBeanSerializer(buildBeanInfo);
            }
            throw new JSONException("not support class : " + name);
        }
        return (ObjectSerializer) invokeL.objValue;
    }

    public final ObjectSerializer get(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, type)) == null) {
            Type mixInAnnotations = JSON.getMixInAnnotations(type);
            if (mixInAnnotations == null) {
                return this.serializers.get(type);
            }
            IdentityHashMap<Type, ObjectSerializer> identityHashMap = this.mixInSerializers.get(type);
            if (identityHashMap == null) {
                return null;
            }
            return identityHashMap.get(mixInAnnotations);
        }
        return (ObjectSerializer) invokeL.objValue;
    }

    public ObjectSerializer getEnumSerializer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? EnumSerializer.instance : (ObjectSerializer) invokeV.objValue;
    }

    public ObjectSerializer getObjectWriter(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) ? getObjectWriter(cls, true) : (ObjectSerializer) invokeL.objValue;
    }

    public String getTypeKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.typeKey : (String) invokeV.objValue;
    }

    public boolean isAsmEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.asm : invokeV.booleanValue;
    }

    public boolean put(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, obj, obj2)) == null) ? put((Type) obj, (ObjectSerializer) obj2) : invokeLL.booleanValue;
    }

    public void register(Module module) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, module) == null) {
            this.modules.add(module);
        }
    }

    public void setAsmEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || ASMUtils.IS_ANDROID) {
            return;
        }
        this.asm = z;
    }

    public void setPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, propertyNamingStrategy) == null) {
            this.propertyNamingStrategy = propertyNamingStrategy;
        }
    }

    public void setTypeKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.typeKey = str;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerializeConfig(boolean z) {
        this(8192, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:277:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:334:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ObjectSerializer getObjectWriter(Class<?> cls, boolean z) {
        InterceptResult invokeLZ;
        ObjectSerializer objectSerializer;
        JSONType jSONType;
        ClassLoader classLoader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(1048585, this, cls, z)) != null) {
            return (ObjectSerializer) invokeLZ.objValue;
        }
        ObjectSerializer objectSerializer2 = get(cls);
        if (objectSerializer2 != null) {
            return objectSerializer2;
        }
        try {
            for (Object obj : ServiceLoader.load(AutowiredObjectSerializer.class, Thread.currentThread().getContextClassLoader())) {
                if (obj instanceof AutowiredObjectSerializer) {
                    AutowiredObjectSerializer autowiredObjectSerializer = (AutowiredObjectSerializer) obj;
                    for (Type type : autowiredObjectSerializer.getAutowiredFor()) {
                        put(type, (ObjectSerializer) autowiredObjectSerializer);
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        ObjectSerializer objectSerializer3 = get(cls);
        if (objectSerializer3 == null && (classLoader = JSON.class.getClassLoader()) != Thread.currentThread().getContextClassLoader()) {
            try {
                for (Object obj2 : ServiceLoader.load(AutowiredObjectSerializer.class, classLoader)) {
                    if (obj2 instanceof AutowiredObjectSerializer) {
                        AutowiredObjectSerializer autowiredObjectSerializer2 = (AutowiredObjectSerializer) obj2;
                        for (Type type2 : autowiredObjectSerializer2.getAutowiredFor()) {
                            put(type2, (ObjectSerializer) autowiredObjectSerializer2);
                        }
                    }
                }
            } catch (ClassCastException unused2) {
            }
            objectSerializer3 = get(cls);
        }
        for (Module module : this.modules) {
            objectSerializer3 = module.createSerializer(this, cls);
            if (objectSerializer3 != null) {
                put((Type) cls, objectSerializer3);
                return objectSerializer3;
            }
        }
        if (objectSerializer3 != null) {
            return objectSerializer3;
        }
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
        } else {
            Class<?> cls2 = null;
            r6 = null;
            r6 = null;
            Member enumValueField = null;
            if (cls.isEnum()) {
                Class cls3 = (Class) JSON.getMixInAnnotations(cls);
                if (cls3 != null) {
                    jSONType = (JSONType) TypeUtils.getAnnotation(cls3, JSONType.class);
                } else {
                    jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
                }
                if (jSONType == null || !jSONType.serializeEnumAsJavaBean()) {
                    if (cls3 != null) {
                        Member enumValueField2 = getEnumValueField(cls3);
                        if (enumValueField2 != null) {
                            try {
                                if (enumValueField2 instanceof Method) {
                                    Method method = (Method) enumValueField2;
                                    enumValueField = cls.getMethod(method.getName(), method.getParameterTypes());
                                }
                            } catch (Exception unused3) {
                            }
                        }
                    } else {
                        enumValueField = getEnumValueField(cls);
                    }
                    if (enumValueField != null) {
                        objectSerializer = new EnumSerializer(enumValueField);
                        put((Type) cls, objectSerializer);
                    } else {
                        objectSerializer = getEnumSerializer();
                        put((Type) cls, objectSerializer);
                    }
                } else {
                    objectSerializer = createJavaBeanSerializer(cls);
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
                        objectSerializer = getEnumSerializer();
                        put((Type) cls, objectSerializer);
                    }
                } else {
                    if (cls.isArray()) {
                        Class<?> componentType = cls.getComponentType();
                        objectSerializer3 = new ArraySerializer(componentType, getObjectWriter(componentType));
                        put((Type) cls, objectSerializer3);
                    } else if (Throwable.class.isAssignableFrom(cls)) {
                        SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, null, this.propertyNamingStrategy);
                        buildBeanInfo.features |= SerializerFeature.WriteClassName.mask;
                        ObjectSerializer javaBeanSerializer = new JavaBeanSerializer(buildBeanInfo);
                        put((Type) cls, javaBeanSerializer);
                        objectSerializer3 = javaBeanSerializer;
                    } else if (!TimeZone.class.isAssignableFrom(cls) && !Map.Entry.class.isAssignableFrom(cls)) {
                        if (Appendable.class.isAssignableFrom(cls)) {
                            objectSerializer = AppendableSerializer.instance;
                            put((Type) cls, objectSerializer);
                        } else if (Charset.class.isAssignableFrom(cls)) {
                            objectSerializer = ToStringSerializer.instance;
                            put((Type) cls, objectSerializer);
                        } else if (Enumeration.class.isAssignableFrom(cls)) {
                            objectSerializer = EnumerationSerializer.instance;
                            put((Type) cls, objectSerializer);
                        } else if (!Calendar.class.isAssignableFrom(cls) && !XMLGregorianCalendar.class.isAssignableFrom(cls)) {
                            if (TypeUtils.isClob(cls)) {
                                objectSerializer = ClobSeriliazer.instance;
                                put((Type) cls, objectSerializer);
                            } else if (TypeUtils.isPath(cls)) {
                                objectSerializer = ToStringSerializer.instance;
                                put((Type) cls, objectSerializer);
                            } else if (Iterator.class.isAssignableFrom(cls)) {
                                objectSerializer = MiscCodec.instance;
                                put((Type) cls, objectSerializer);
                            } else if (Node.class.isAssignableFrom(cls)) {
                                objectSerializer = MiscCodec.instance;
                                put((Type) cls, objectSerializer);
                            } else {
                                int i2 = 0;
                                if (name.startsWith("java.awt.") && AwtCodec.support(cls) && !awtError) {
                                    try {
                                        String[] strArr = {"java.awt.Color", "java.awt.Font", "java.awt.Point", "java.awt.Rectangle"};
                                        for (int i3 = 0; i3 < 4; i3++) {
                                            String str = strArr[i3];
                                            if (str.equals(name)) {
                                                Type cls4 = Class.forName(str);
                                                objectSerializer3 = AwtCodec.instance;
                                                put(cls4, objectSerializer3);
                                                return objectSerializer3;
                                            }
                                        }
                                    } catch (Throwable unused4) {
                                        awtError = true;
                                    }
                                }
                                if (!jdk8Error && (name.startsWith("java.time.") || name.startsWith("java.util.Optional") || name.equals("java.util.concurrent.atomic.LongAdder") || name.equals("java.util.concurrent.atomic.DoubleAdder"))) {
                                    try {
                                        String[] strArr2 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.Period", "java.time.Duration", "java.time.Instant"};
                                        for (int i4 = 0; i4 < 11; i4++) {
                                            String str2 = strArr2[i4];
                                            if (str2.equals(name)) {
                                                Type cls5 = Class.forName(str2);
                                                ObjectSerializer objectSerializer4 = Jdk8DateCodec.instance;
                                                put(cls5, objectSerializer4);
                                                return objectSerializer4;
                                            }
                                        }
                                        String[] strArr3 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};
                                        for (int i5 = 0; i5 < 4; i5++) {
                                            String str3 = strArr3[i5];
                                            if (str3.equals(name)) {
                                                Type cls6 = Class.forName(str3);
                                                ObjectSerializer objectSerializer5 = OptionalCodec.instance;
                                                put(cls6, objectSerializer5);
                                                return objectSerializer5;
                                            }
                                        }
                                        String[] strArr4 = {"java.util.concurrent.atomic.LongAdder", "java.util.concurrent.atomic.DoubleAdder"};
                                        for (int i6 = 0; i6 < 2; i6++) {
                                            String str4 = strArr4[i6];
                                            if (str4.equals(name)) {
                                                Type cls7 = Class.forName(str4);
                                                ObjectSerializer objectSerializer6 = AdderSerializer.instance;
                                                put(cls7, objectSerializer6);
                                                return objectSerializer6;
                                            }
                                        }
                                    } catch (Throwable unused5) {
                                        jdk8Error = true;
                                    }
                                }
                                if (!oracleJdbcError && name.startsWith("oracle.sql.")) {
                                    try {
                                        String[] strArr5 = {"oracle.sql.DATE", "oracle.sql.TIMESTAMP"};
                                        for (int i7 = 0; i7 < 2; i7++) {
                                            String str5 = strArr5[i7];
                                            if (str5.equals(name)) {
                                                Type cls8 = Class.forName(str5);
                                                objectSerializer3 = DateCodec.instance;
                                                put(cls8, objectSerializer3);
                                                return objectSerializer3;
                                            }
                                        }
                                    } catch (Throwable unused6) {
                                        oracleJdbcError = true;
                                    }
                                }
                                if (!springfoxError && name.equals("springfox.documentation.spring.web.json.Json")) {
                                    try {
                                        Type cls9 = Class.forName("springfox.documentation.spring.web.json.Json");
                                        objectSerializer3 = SwaggerJsonSerializer.instance;
                                        put(cls9, objectSerializer3);
                                        return objectSerializer3;
                                    } catch (ClassNotFoundException unused7) {
                                        springfoxError = true;
                                    }
                                }
                                if (!guavaError && name.startsWith("com.google.common.collect.")) {
                                    try {
                                        String[] strArr6 = {"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.LinkedHashMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"};
                                        for (int i8 = 0; i8 < 5; i8++) {
                                            String str6 = strArr6[i8];
                                            if (str6.equals(name)) {
                                                Type cls10 = Class.forName(str6);
                                                objectSerializer3 = GuavaCodec.instance;
                                                put(cls10, objectSerializer3);
                                                return objectSerializer3;
                                            }
                                        }
                                    } catch (ClassNotFoundException unused8) {
                                        guavaError = true;
                                    }
                                }
                                if (name.equals("net.sf.json.JSONNull")) {
                                    ObjectSerializer objectSerializer7 = MiscCodec.instance;
                                    put((Type) cls, objectSerializer7);
                                    return objectSerializer7;
                                } else if (name.equals("org.json.JSONObject")) {
                                    ObjectSerializer objectSerializer8 = JSONObjectCodec.instance;
                                    put((Type) cls, objectSerializer8);
                                    return objectSerializer8;
                                } else {
                                    if (!jodaError && name.startsWith("org.joda.")) {
                                        try {
                                            String[] strArr7 = {"org.joda.time.LocalDate", "org.joda.time.LocalDateTime", "org.joda.time.LocalTime", "org.joda.time.Instant", "org.joda.time.DateTime", "org.joda.time.Period", "org.joda.time.Duration", "org.joda.time.DateTimeZone", "org.joda.time.UTCDateTimeZone", "org.joda.time.tz.CachedDateTimeZone", "org.joda.time.tz.FixedDateTimeZone"};
                                            for (int i9 = 0; i9 < 11; i9++) {
                                                String str7 = strArr7[i9];
                                                if (str7.equals(name)) {
                                                    Type cls11 = Class.forName(str7);
                                                    objectSerializer3 = JodaCodec.instance;
                                                    put(cls11, objectSerializer3);
                                                    return objectSerializer3;
                                                }
                                            }
                                        } catch (ClassNotFoundException unused9) {
                                            jodaError = true;
                                        }
                                    }
                                    if ("java.nio.HeapByteBuffer".equals(name)) {
                                        ObjectSerializer objectSerializer9 = ByteBufferCodec.instance;
                                        put((Type) cls, objectSerializer9);
                                        return objectSerializer9;
                                    } else if ("org.javamoney.moneta.Money".equals(name)) {
                                        ObjectSerializer objectSerializer10 = MonetaCodec.instance;
                                        put((Type) cls, objectSerializer10);
                                        return objectSerializer10;
                                    } else if ("com.google.protobuf.Descriptors$FieldDescriptor".equals(name)) {
                                        ObjectSerializer objectSerializer11 = ToStringSerializer.instance;
                                        put((Type) cls, objectSerializer11);
                                        return objectSerializer11;
                                    } else {
                                        Class<?>[] interfaces = cls.getInterfaces();
                                        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
                                            put((Type) cls, AnnotationSerializer.instance);
                                            return AnnotationSerializer.instance;
                                        } else if (TypeUtils.isProxy(cls)) {
                                            ObjectSerializer objectWriter = getObjectWriter(cls.getSuperclass());
                                            put((Type) cls, objectWriter);
                                            return objectWriter;
                                        } else {
                                            if (Proxy.isProxyClass(cls)) {
                                                if (interfaces.length == 2) {
                                                    cls2 = interfaces[1];
                                                } else {
                                                    int length = interfaces.length;
                                                    Class<?> cls12 = null;
                                                    while (true) {
                                                        if (i2 >= length) {
                                                            cls2 = cls12;
                                                            break;
                                                        }
                                                        Class<?> cls13 = interfaces[i2];
                                                        if (!cls13.getName().startsWith("org.springframework.aop.")) {
                                                            if (cls12 != null) {
                                                                break;
                                                            }
                                                            cls12 = cls13;
                                                        }
                                                        i2++;
                                                    }
                                                }
                                                if (cls2 != null) {
                                                    ObjectSerializer objectWriter2 = getObjectWriter(cls2);
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
                                }
                            }
                        } else {
                            objectSerializer = CalendarCodec.instance;
                            put((Type) cls, objectSerializer);
                        }
                    } else {
                        objectSerializer = MiscCodec.instance;
                        put((Type) cls, objectSerializer);
                    }
                    return objectSerializer3 != null ? get(cls) : objectSerializer3;
                }
            }
        }
        objectSerializer3 = objectSerializer;
        if (objectSerializer3 != null) {
        }
    }

    public boolean put(Type type, ObjectSerializer objectSerializer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, type, objectSerializer)) == null) {
            Type mixInAnnotations = JSON.getMixInAnnotations(type);
            if (mixInAnnotations != null) {
                IdentityHashMap<Type, ObjectSerializer> identityHashMap = this.mixInSerializers.get(type);
                if (identityHashMap == null) {
                    identityHashMap = new IdentityHashMap<>(4);
                    this.mixInSerializers.put(type, identityHashMap);
                }
                return identityHashMap.put(mixInAnnotations, objectSerializer);
            }
            return this.serializers.put(type, objectSerializer);
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SerializeConfig(int i2) {
        this(i2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public SerializeConfig(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.asm = !ASMUtils.IS_ANDROID;
        this.typeKey = JSON.DEFAULT_TYPE_KEY;
        this.denyClasses = new long[]{4165360493669296979L, 4446674157046724083L};
        this.modules = new ArrayList();
        this.fieldBased = z;
        this.serializers = new IdentityHashMap<>(i2);
        this.mixInSerializers = new IdentityHashMap<>(16);
        try {
            if (this.asm) {
                this.asmFactory = new ASMSerializerFactory();
            }
        } catch (Throwable unused) {
            this.asm = false;
        }
        initSerializers();
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x0165, code lost:
        r0 = createASMSerializer(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0169, code lost:
        if (r0 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x016b, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x016c, code lost:
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0183, code lost:
        throw new com.alibaba.fastjson.JSONException("create asm serializer error, verson 1.2.75, class " + r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0184, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0190, code lost:
        if (r0.getMessage().indexOf("Metaspace") != (-1)) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0193, code lost:
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ObjectSerializer createJavaBeanSerializer(SerializeBeanInfo serializeBeanInfo) {
        InterceptResult invokeL;
        FieldInfo[] fieldInfoArr;
        Method method;
        SerializerFeature[] serialzeFeatures;
        SerializerFeature[] serialzeFeatures2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, serializeBeanInfo)) == null) {
            JSONType jSONType = serializeBeanInfo.jsonType;
            boolean z = false;
            boolean z2 = this.asm && !this.fieldBased;
            if (jSONType != null) {
                Class<?> serializer = jSONType.serializer();
                if (serializer != Void.class) {
                    try {
                        Object newInstance = serializer.newInstance();
                        if (newInstance instanceof ObjectSerializer) {
                            return (ObjectSerializer) newInstance;
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!jSONType.asm()) {
                    z2 = false;
                }
                if (z2) {
                    for (SerializerFeature serializerFeature : jSONType.serialzeFeatures()) {
                        if (SerializerFeature.WriteNonStringValueAsString == serializerFeature || SerializerFeature.WriteEnumUsingToString == serializerFeature || SerializerFeature.NotWriteDefaultValue == serializerFeature || SerializerFeature.BrowserCompatible == serializerFeature) {
                            z2 = false;
                            break;
                        }
                    }
                }
                if (z2 && jSONType.serialzeFilters().length != 0) {
                    z2 = false;
                }
            }
            Class<?> cls = serializeBeanInfo.beanType;
            if (!Modifier.isPublic(cls.getModifiers())) {
                return new JavaBeanSerializer(serializeBeanInfo);
            }
            if ((z2 && this.asmFactory.classLoader.isExternalClass(cls)) || cls == Serializable.class || cls == Object.class) {
                z2 = false;
            }
            if (z2 && !ASMUtils.checkName(cls.getSimpleName())) {
                z2 = false;
            }
            if (z2 && serializeBeanInfo.beanType.isInterface()) {
                z2 = false;
            }
            if (z2) {
                for (FieldInfo fieldInfo : serializeBeanInfo.fields) {
                    Field field = fieldInfo.field;
                    if ((field != null && !field.getType().equals(fieldInfo.fieldClass)) || (((method = fieldInfo.method) != null && !method.getReturnType().equals(fieldInfo.fieldClass)) || (fieldInfo.fieldClass.isEnum() && get(fieldInfo.fieldClass) != EnumSerializer.instance))) {
                        break;
                    }
                    JSONField annotation = fieldInfo.getAnnotation();
                    if (annotation != null) {
                        String format = annotation.format();
                        if ((format.length() != 0 && (fieldInfo.fieldClass != String.class || !"trim".equals(format))) || !ASMUtils.checkName(annotation.name()) || annotation.jsonDirect() || annotation.serializeUsing() != Void.class || annotation.unwrapped()) {
                            break;
                        }
                        for (SerializerFeature serializerFeature2 : annotation.serialzeFeatures()) {
                            if (SerializerFeature.WriteNonStringValueAsString == serializerFeature2 || SerializerFeature.WriteEnumUsingToString == serializerFeature2 || SerializerFeature.NotWriteDefaultValue == serializerFeature2 || SerializerFeature.BrowserCompatible == serializerFeature2 || SerializerFeature.WriteClassName == serializerFeature2) {
                                z2 = false;
                                break;
                            }
                        }
                        if (TypeUtils.isAnnotationPresentOneToMany(method)) {
                            break;
                        } else if (TypeUtils.isAnnotationPresentManyToMany(method)) {
                            break;
                        } else if (annotation.defaultValue() != null && !"".equals(annotation.defaultValue())) {
                            break;
                        }
                    }
                }
            }
            z = z2;
            return new JavaBeanSerializer(serializeBeanInfo);
        }
        return (ObjectSerializer) invokeL.objValue;
    }
}
