package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONPOJOBuilder;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public class JavaBeanInfo {
    public final Method buildMethod;
    public final Class<?> builderClass;
    public final Class<?> clazz;
    public final Constructor<?> creatorConstructor;
    public Type[] creatorConstructorParameterTypes;
    public String[] creatorConstructorParameters;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;

    /* renamed from: kotlin  reason: collision with root package name */
    public boolean f1602kotlin;
    public Constructor<?> kotlinDefaultConstructor;
    public String[] orders;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final String typeKey;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, JSONType jSONType, List<FieldInfo> list) {
        JSONField jSONField;
        FieldInfo[] fieldInfoArr;
        String[] strArr;
        this.clazz = cls;
        this.builderClass = cls2;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.parserFeatures = TypeUtils.getParserFeatures(cls);
        this.buildMethod = method2;
        this.jsonType = jSONType;
        if (jSONType != null) {
            String typeName = jSONType.typeName();
            String typeKey = jSONType.typeKey();
            this.typeKey = typeKey.length() <= 0 ? null : typeKey;
            if (typeName.length() != 0) {
                this.typeName = typeName;
            } else {
                this.typeName = cls.getName();
            }
            String[] orders = jSONType.orders();
            this.orders = orders.length == 0 ? null : orders;
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            this.orders = null;
        }
        FieldInfo[] fieldInfoArr2 = new FieldInfo[list.size()];
        this.fields = fieldInfoArr2;
        list.toArray(fieldInfoArr2);
        FieldInfo[] fieldInfoArr3 = this.fields;
        FieldInfo[] fieldInfoArr4 = new FieldInfo[fieldInfoArr3.length];
        boolean z = false;
        if (this.orders != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (FieldInfo fieldInfo : this.fields) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            int i2 = 0;
            for (String str : this.orders) {
                FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    fieldInfoArr4[i2] = fieldInfo2;
                    linkedHashMap.remove(str);
                    i2++;
                }
            }
            for (FieldInfo fieldInfo3 : linkedHashMap.values()) {
                fieldInfoArr4[i2] = fieldInfo3;
                i2++;
            }
        } else {
            System.arraycopy(fieldInfoArr3, 0, fieldInfoArr4, 0, fieldInfoArr3.length);
            Arrays.sort(fieldInfoArr4);
        }
        this.sortedFields = Arrays.equals(this.fields, fieldInfoArr4) ? this.fields : fieldInfoArr4;
        if (constructor != null) {
            this.defaultConstructorParameterSize = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.defaultConstructorParameterSize = method.getParameterTypes().length;
        } else {
            this.defaultConstructorParameterSize = 0;
        }
        if (constructor2 != null) {
            this.creatorConstructorParameterTypes = constructor2.getParameterTypes();
            boolean isKotlin = TypeUtils.isKotlin(cls);
            this.f1602kotlin = isKotlin;
            if (isKotlin) {
                this.creatorConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                try {
                    this.kotlinDefaultConstructor = cls.getConstructor(new Class[0]);
                } catch (Throwable unused) {
                }
                Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor2);
                for (int i3 = 0; i3 < this.creatorConstructorParameters.length && i3 < parameterAnnotations.length; i3++) {
                    Annotation[] annotationArr = parameterAnnotations[i3];
                    int length = annotationArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            jSONField = null;
                            break;
                        }
                        Annotation annotation = annotationArr[i4];
                        if (annotation instanceof JSONField) {
                            jSONField = (JSONField) annotation;
                            break;
                        }
                        i4++;
                    }
                    if (jSONField != null) {
                        String name = jSONField.name();
                        if (name.length() > 0) {
                            this.creatorConstructorParameters[i3] = name;
                        }
                    }
                }
                return;
            }
            if (this.creatorConstructorParameterTypes.length == this.fields.length) {
                int i5 = 0;
                while (true) {
                    Type[] typeArr = this.creatorConstructorParameterTypes;
                    if (i5 >= typeArr.length) {
                        z = true;
                        break;
                    } else if (typeArr[i5] != this.fields[i5].fieldClass) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            if (z) {
                return;
            }
            this.creatorConstructorParameters = ASMUtils.lookupParameterNames(constructor2);
        }
    }

    public static boolean add(List<FieldInfo> list, FieldInfo fieldInfo) {
        for (int size = list.size() - 1; size >= 0; size--) {
            FieldInfo fieldInfo2 = list.get(size);
            if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
                    list.set(size, fieldInfo);
                    return true;
                } else if (fieldInfo2.compareTo(fieldInfo) < 0) {
                    list.set(size, fieldInfo);
                    return true;
                } else {
                    return false;
                }
            }
        }
        list.add(fieldInfo);
        return true;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy) {
        return build(cls, type, propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, false);
    }

    public static Map<TypeVariable, Type> buildGenericInfo(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = null;
        if (superclass == null) {
            return null;
        }
        while (true) {
            Class<? super Object> cls2 = superclass;
            Class<?> cls3 = cls;
            cls = cls2;
            if (cls == null || cls == Object.class) {
                break;
            }
            if (cls3.getGenericSuperclass() instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) cls3.getGenericSuperclass()).getActualTypeArguments();
                TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
                for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    if (hashMap.containsKey(actualTypeArguments[i2])) {
                        hashMap.put(typeParameters[i2], hashMap.get(actualTypeArguments[i2]));
                    } else {
                        hashMap.put(typeParameters[i2], actualTypeArguments[i2]);
                    }
                }
            }
            superclass = cls.getSuperclass();
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
        if ((java.util.Map.class.isAssignableFrom(r2) || java.util.Collection.class.isAssignableFrom(r2) || java.util.concurrent.atomic.AtomicLong.class.equals(r2) || java.util.concurrent.atomic.AtomicInteger.class.equals(r2) || java.util.concurrent.atomic.AtomicBoolean.class.equals(r2)) == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void computeFields(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, List<FieldInfo> list, Field[] fieldArr) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Map<TypeVariable, Type> buildGenericInfo = buildGenericInfo(cls);
        int length = fieldArr.length;
        int i7 = 0;
        while (i7 < length) {
            Field field = fieldArr[i7];
            int modifiers = field.getModifiers();
            if ((modifiers & 8) == 0) {
                boolean z = true;
                if ((modifiers & 16) != 0) {
                    Class<?> type2 = field.getType();
                }
                Iterator<FieldInfo> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next().name.equals(field.getName())) {
                        break;
                    }
                }
                if (!z) {
                    String name = field.getName();
                    JSONField jSONField = (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
                    if (jSONField == null) {
                        i2 = 0;
                        i3 = 0;
                        i4 = 0;
                    } else if (jSONField.deserialize()) {
                        int ordinal = jSONField.ordinal();
                        int of = SerializerFeature.of(jSONField.serialzeFeatures());
                        int of2 = Feature.of(jSONField.parseFeatures());
                        if (jSONField.name().length() != 0) {
                            name = jSONField.name();
                        }
                        i2 = ordinal;
                        i3 = of;
                        i4 = of2;
                    }
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    i5 = i7;
                    i6 = length;
                    add(list, new FieldInfo(name, null, field, cls, type, i2, i3, i4, null, jSONField, null, buildGenericInfo));
                    i7 = i5 + 1;
                    length = i6;
                }
            }
            i5 = i7;
            i6 = length;
            i7 = i5 + 1;
            length = i6;
        }
    }

    public static Class<?> getBuilderClass(JSONType jSONType) {
        return getBuilderClass(null, jSONType);
    }

    public static Constructor<?> getCreatorConstructor(Constructor[] constructorArr) {
        boolean z;
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            if (((JSONCreator) constructor2.getAnnotation(JSONCreator.class)) != null) {
                if (constructor != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor constructor3 : constructorArr) {
            Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor3);
            if (parameterAnnotations.length != 0) {
                int length = parameterAnnotations.length;
                int i2 = 0;
                while (true) {
                    z = true;
                    if (i2 >= length) {
                        break;
                    }
                    Annotation[] annotationArr = parameterAnnotations[i2];
                    int length2 = annotationArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            z = false;
                            break;
                        } else if (annotationArr[i3] instanceof JSONField) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z) {
                        z = false;
                        break;
                    }
                    i2++;
                }
                if (!z) {
                    continue;
                } else if (constructor != null) {
                    throw new JSONException("multi-JSONCreator");
                } else {
                    constructor = constructor3;
                }
            }
        }
        if (constructor != null) {
        }
        return constructor;
    }

    public static Constructor<?> getDefaultConstructor(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        int length = constructorArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            Constructor<?> constructor2 = constructorArr[i2];
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
            i2++;
        }
        if (constructor == null && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            for (Constructor<?> constructor3 : constructorArr) {
                Class<?>[] parameterTypes = constructor3.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                    return constructor3;
                }
            }
            return constructor;
        }
        return constructor;
    }

    public static Method getFactoryMethod(Class<?> cls, Method[] methodArr, boolean z) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((JSONCreator) TypeUtils.getAnnotation(method2, JSONCreator.class)) != null) {
                if (method != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                method = method2;
            }
        }
        if (method == null && z) {
            for (Method method3 : methodArr) {
                if (TypeUtils.isJacksonCreator(method3)) {
                    return method3;
                }
            }
            return method;
        }
        return method;
    }

    public static FieldInfo getField(List<FieldInfo> list, String str) {
        for (FieldInfo fieldInfo : list) {
            if (fieldInfo.name.equals(str)) {
                return fieldInfo;
            }
            Field field = fieldInfo.field;
            if (field != null && fieldInfo.getAnnotation() != null && field.getName().equals(str)) {
                return fieldInfo;
            }
        }
        return null;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2) {
        return build(cls, type, propertyNamingStrategy, z, z2, false);
    }

    public static Class<?> getBuilderClass(Class<?> cls, JSONType jSONType) {
        Class<?> builder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return TypeUtils.loadClass("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (jSONType == null || (builder = jSONType.builder()) == Void.class) {
            return null;
        }
        return builder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:400:0x0881, code lost:
        if (r3 == null) goto L266;
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x08c2  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x08f4  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x096f  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0982  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2, boolean z3) {
        Constructor<?> defaultConstructor;
        Constructor<?> constructor;
        ArrayList arrayList;
        Method[] methodArr;
        Class<?> cls2;
        Class<?> cls3;
        Field[] fieldArr;
        Constructor<?> constructor2;
        PropertyNamingStrategy propertyNamingStrategy2;
        String str;
        JSONType jSONType;
        Field[] fieldArr2;
        Class<String> cls4;
        Class<?> cls5;
        Class<?> cls6;
        ArrayList arrayList2;
        String str2;
        int i2;
        JSONField jSONField;
        String propertyNameByMethodName;
        Field[] fieldArr3;
        Field field;
        Field[] fieldArr4;
        int i3;
        String str3;
        int i4;
        Method[] methodArr2;
        PropertyNamingStrategy propertyNamingStrategy3;
        int i5;
        Class<?> cls7;
        Class<String> cls8;
        int i6;
        Class<?> cls9;
        int i7;
        ArrayList arrayList3;
        int i8;
        Class<?> cls10;
        Field[] fieldArr5;
        String propertyNameByMethodName2;
        Field field2;
        Field[] fieldArr6;
        String str4;
        Method[] methodArr3;
        PropertyNamingStrategy propertyNamingStrategy4;
        JSONField jSONField2;
        int i9;
        PropertyNamingStrategy propertyNamingStrategy5;
        PropertyNamingStrategy propertyNamingStrategy6;
        int i10;
        int i11;
        Method[] methodArr4;
        String str5;
        Class<?> cls11;
        String str6;
        JSONType jSONType2;
        Field[] fieldArr7;
        Class<?> cls12;
        ArrayList arrayList4;
        int i12;
        int i13;
        int i14;
        String str7;
        StringBuilder sb;
        String str8;
        String str9;
        Class<String> cls13;
        char charAt;
        ArrayList arrayList5;
        Constructor<?> constructor3;
        Class<?> cls14;
        Class<?> cls15;
        String[] strArr;
        String[] lookupParameterNames;
        String[] strArr2;
        JSONField jSONField3;
        int of;
        int i15;
        int i16;
        JSONField jSONField4;
        String str10;
        int i17;
        int i18;
        int i19;
        Annotation[][] annotationArr;
        JSONField jSONField5;
        Field field3;
        String str11;
        int i20;
        int i21;
        int i22;
        Field field4;
        Field field5;
        String[] strArr3;
        Constructor<?> creatorConstructor;
        PropertyNamingStrategy naming;
        Class<?> cls16 = cls;
        boolean z4 = z3;
        Class<String> cls17 = String.class;
        Class<?> cls18 = Object.class;
        JSONType jSONType3 = (JSONType) TypeUtils.getAnnotation(cls16, JSONType.class);
        PropertyNamingStrategy propertyNamingStrategy7 = (jSONType3 == null || (naming = jSONType3.naming()) == null || naming == PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : naming;
        Class<?> builderClass = getBuilderClass(cls16, jSONType3);
        Field[] declaredFields = cls.getDeclaredFields();
        Method[] methods = cls.getMethods();
        Map<TypeVariable, Type> buildGenericInfo = buildGenericInfo(cls);
        boolean isKotlin = TypeUtils.isKotlin(cls);
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (!isKotlin || declaredConstructors.length == 1) {
            if (builderClass == null) {
                defaultConstructor = getDefaultConstructor(cls16, declaredConstructors);
            } else {
                defaultConstructor = getDefaultConstructor(builderClass, builderClass.getDeclaredConstructors());
            }
            constructor = defaultConstructor;
        } else {
            constructor = null;
        }
        Method method = null;
        Method method2 = null;
        ArrayList arrayList6 = new ArrayList();
        if (z) {
            for (Class<?> cls19 = cls16; cls19 != null; cls19 = cls19.getSuperclass()) {
                computeFields(cls16, type, propertyNamingStrategy7, arrayList6, cls19.getDeclaredFields());
            }
            if (constructor != null) {
                TypeUtils.setAccessible(constructor);
            }
            return new JavaBeanInfo(cls, builderClass, constructor, null, null, null, jSONType3, arrayList6);
        }
        boolean z5 = cls.isInterface() || Modifier.isAbstract(cls.getModifiers());
        PropertyNamingStrategy propertyNamingStrategy8 = propertyNamingStrategy7;
        if ((constructor == null && builderClass == null) || z5) {
            Type mixInAnnotations = JSON.getMixInAnnotations(cls);
            if ((mixInAnnotations instanceof Class) && (creatorConstructor = getCreatorConstructor(((Class) mixInAnnotations).getConstructors())) != null) {
                try {
                    constructor3 = cls16.getConstructor(creatorConstructor.getParameterTypes());
                } catch (NoSuchMethodException unused) {
                }
                if (constructor3 == null) {
                    constructor3 = getCreatorConstructor(declaredConstructors);
                }
                constructor2 = constructor3;
                if (constructor2 == null && !z5) {
                    TypeUtils.setAccessible(constructor2);
                    Class<?>[] parameterTypes = constructor2.getParameterTypes();
                    if (parameterTypes.length > 0) {
                        Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations(constructor2);
                        String[] strArr4 = null;
                        int i23 = 0;
                        while (i23 < parameterTypes.length && i23 < parameterAnnotations.length) {
                            Annotation[] annotationArr2 = parameterAnnotations[i23];
                            int length = annotationArr2.length;
                            int i24 = 0;
                            while (true) {
                                annotationArr = parameterAnnotations;
                                if (i24 >= length) {
                                    jSONField5 = null;
                                    break;
                                }
                                Annotation annotation = annotationArr2[i24];
                                Annotation[] annotationArr3 = annotationArr2;
                                if (annotation instanceof JSONField) {
                                    jSONField5 = (JSONField) annotation;
                                    break;
                                }
                                i24++;
                                parameterAnnotations = annotationArr;
                                annotationArr2 = annotationArr3;
                            }
                            Class<?> cls20 = parameterTypes[i23];
                            Type type2 = constructor2.getGenericParameterTypes()[i23];
                            if (jSONField5 != null) {
                                field3 = TypeUtils.getField(cls16, jSONField5.name(), declaredFields);
                                i20 = jSONField5.ordinal();
                                i21 = SerializerFeature.of(jSONField5.serialzeFeatures());
                                i22 = Feature.of(jSONField5.parseFeatures());
                                str11 = jSONField5.name();
                            } else {
                                field3 = null;
                                str11 = null;
                                i20 = 0;
                                i21 = 0;
                                i22 = 0;
                            }
                            if (str11 == null || str11.length() == 0) {
                                if (strArr4 == null) {
                                    strArr4 = ASMUtils.lookupParameterNames(constructor2);
                                }
                                str11 = strArr4[i23];
                            }
                            if (field3 == null) {
                                if (strArr4 == null) {
                                    if (isKotlin) {
                                        strArr4 = TypeUtils.getKoltinConstructorParameters(cls);
                                    } else {
                                        strArr4 = ASMUtils.lookupParameterNames(constructor2);
                                    }
                                }
                                field4 = field3;
                                if (strArr4.length > i23) {
                                    strArr3 = strArr4;
                                    field5 = TypeUtils.getField(cls16, strArr4[i23], declaredFields);
                                    ArrayList arrayList7 = arrayList6;
                                    add(arrayList7, new FieldInfo(str11, cls, cls20, type2, field5, i20, i21, i22));
                                    i23++;
                                    arrayList6 = arrayList7;
                                    declaredFields = declaredFields;
                                    methods = methods;
                                    parameterAnnotations = annotationArr;
                                    cls18 = cls18;
                                    builderClass = builderClass;
                                    strArr4 = strArr3;
                                    parameterTypes = parameterTypes;
                                }
                            } else {
                                field4 = field3;
                            }
                            field5 = field4;
                            strArr3 = strArr4;
                            ArrayList arrayList72 = arrayList6;
                            add(arrayList72, new FieldInfo(str11, cls, cls20, type2, field5, i20, i21, i22));
                            i23++;
                            arrayList6 = arrayList72;
                            declaredFields = declaredFields;
                            methods = methods;
                            parameterAnnotations = annotationArr;
                            cls18 = cls18;
                            builderClass = builderClass;
                            strArr4 = strArr3;
                            parameterTypes = parameterTypes;
                        }
                    }
                    arrayList = arrayList6;
                    methodArr = methods;
                    cls2 = builderClass;
                    cls14 = cls18;
                    fieldArr = declaredFields;
                } else {
                    arrayList = arrayList6;
                    methodArr = methods;
                    cls2 = builderClass;
                    cls14 = cls18;
                    fieldArr = declaredFields;
                    method2 = getFactoryMethod(cls16, methodArr, z4);
                    if (method2 == null) {
                        TypeUtils.setAccessible(method2);
                        Class<?>[] parameterTypes2 = method2.getParameterTypes();
                        if (parameterTypes2.length > 0) {
                            Annotation[][] parameterAnnotations2 = TypeUtils.getParameterAnnotations(method2);
                            String[] strArr5 = null;
                            int i25 = 0;
                            while (i25 < parameterTypes2.length) {
                                Annotation[] annotationArr4 = parameterAnnotations2[i25];
                                int length2 = annotationArr4.length;
                                int i26 = 0;
                                while (true) {
                                    if (i26 >= length2) {
                                        jSONField4 = null;
                                        break;
                                    }
                                    Annotation annotation2 = annotationArr4[i26];
                                    if (annotation2 instanceof JSONField) {
                                        jSONField4 = (JSONField) annotation2;
                                        break;
                                    }
                                    i26++;
                                }
                                if (jSONField4 == null && (!z4 || !TypeUtils.isJacksonCreator(method2))) {
                                    throw new JSONException("illegal json creator");
                                }
                                if (jSONField4 != null) {
                                    str10 = jSONField4.name();
                                    i17 = jSONField4.ordinal();
                                    i18 = SerializerFeature.of(jSONField4.serialzeFeatures());
                                    i19 = Feature.of(jSONField4.parseFeatures());
                                } else {
                                    str10 = null;
                                    i17 = 0;
                                    i18 = 0;
                                    i19 = 0;
                                }
                                if (str10 == null || str10.length() == 0) {
                                    if (strArr5 == null) {
                                        strArr5 = ASMUtils.lookupParameterNames(method2);
                                    }
                                    str10 = strArr5[i25];
                                }
                                String[] strArr6 = strArr5;
                                add(arrayList, new FieldInfo(str10, cls, parameterTypes2[i25], method2.getGenericParameterTypes()[i25], TypeUtils.getField(cls16, str10, fieldArr), i17, i18, i19));
                                i25++;
                                z4 = z3;
                                strArr5 = strArr6;
                                parameterTypes2 = parameterTypes2;
                            }
                            return new JavaBeanInfo(cls, cls2, null, null, method2, null, jSONType3, arrayList);
                        }
                    } else if (!z5) {
                        String name = cls.getName();
                        if (isKotlin && declaredConstructors.length > 0) {
                            String[] koltinConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                            Constructor<?> kotlinConstructor = TypeUtils.getKotlinConstructor(declaredConstructors, koltinConstructorParameters);
                            TypeUtils.setAccessible(kotlinConstructor);
                            constructor2 = kotlinConstructor;
                            strArr = koltinConstructorParameters;
                        } else {
                            int length3 = declaredConstructors.length;
                            String[] strArr7 = null;
                            int i27 = 0;
                            while (i27 < length3) {
                                Constructor<?> constructor4 = declaredConstructors[i27];
                                Class<?>[] parameterTypes3 = constructor4.getParameterTypes();
                                if (name.equals("org.springframework.security.web.authentication.WebAuthenticationDetails")) {
                                    if (parameterTypes3.length == 2 && parameterTypes3[0] == cls17 && parameterTypes3[1] == cls17) {
                                        constructor4.setAccessible(true);
                                        strArr = ASMUtils.lookupParameterNames(constructor4);
                                        constructor2 = constructor4;
                                    }
                                } else if (name.equals("org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken")) {
                                    if (parameterTypes3.length == 3) {
                                        cls15 = cls14;
                                        if (parameterTypes3[0] == cls15 && parameterTypes3[1] == cls15 && parameterTypes3[2] == Collection.class) {
                                            constructor4.setAccessible(true);
                                            strArr2 = new String[]{"principal", "credentials", "authorities"};
                                            strArr = strArr2;
                                            constructor2 = constructor4;
                                            break;
                                        }
                                        i27++;
                                        cls14 = cls15;
                                    }
                                } else {
                                    cls15 = cls14;
                                    if (name.equals("org.springframework.security.core.authority.SimpleGrantedAuthority")) {
                                        if (parameterTypes3.length == 1 && parameterTypes3[0] == cls17) {
                                            strArr2 = new String[]{"authority"};
                                            strArr = strArr2;
                                            constructor2 = constructor4;
                                            break;
                                        }
                                    } else if (((constructor4.getModifiers() & 1) != 0) && (lookupParameterNames = ASMUtils.lookupParameterNames(constructor4)) != null && lookupParameterNames.length != 0 && (constructor2 == null || strArr7 == null || lookupParameterNames.length > strArr7.length)) {
                                        constructor2 = constructor4;
                                        strArr7 = lookupParameterNames;
                                    }
                                    i27++;
                                    cls14 = cls15;
                                }
                                cls15 = cls14;
                                i27++;
                                cls14 = cls15;
                            }
                            cls15 = cls14;
                            strArr = strArr7;
                            Class<?>[] parameterTypes4 = strArr == null ? constructor2.getParameterTypes() : null;
                            if (strArr == null && parameterTypes4.length == strArr.length) {
                                Annotation[][] parameterAnnotations3 = TypeUtils.getParameterAnnotations(constructor2);
                                int i28 = 0;
                                while (i28 < parameterTypes4.length) {
                                    Annotation[] annotationArr5 = parameterAnnotations3[i28];
                                    String str12 = strArr[i28];
                                    int length4 = annotationArr5.length;
                                    int i29 = 0;
                                    while (true) {
                                        if (i29 >= length4) {
                                            jSONField3 = null;
                                            break;
                                        }
                                        Annotation annotation3 = annotationArr5[i29];
                                        Annotation[] annotationArr6 = annotationArr5;
                                        if (annotation3 instanceof JSONField) {
                                            jSONField3 = (JSONField) annotation3;
                                            break;
                                        }
                                        i29++;
                                        annotationArr5 = annotationArr6;
                                    }
                                    Class<?> cls21 = parameterTypes4[i28];
                                    Type type3 = constructor2.getGenericParameterTypes()[i28];
                                    Field field6 = TypeUtils.getField(cls16, str12, fieldArr);
                                    if (field6 != null && jSONField3 == null) {
                                        jSONField3 = (JSONField) TypeUtils.getAnnotation(field6, JSONField.class);
                                    }
                                    if (jSONField3 == null) {
                                        if ("org.springframework.security.core.userdetails.User".equals(name) && "password".equals(str12)) {
                                            of = Feature.InitStringFieldAsEmpty.mask;
                                            i16 = 0;
                                            i15 = 0;
                                        } else {
                                            i16 = 0;
                                            i15 = 0;
                                            of = 0;
                                        }
                                    } else {
                                        String name2 = jSONField3.name();
                                        if (name2.length() != 0) {
                                            str12 = name2;
                                        }
                                        int ordinal = jSONField3.ordinal();
                                        int of2 = SerializerFeature.of(jSONField3.serialzeFeatures());
                                        of = Feature.of(jSONField3.parseFeatures());
                                        i15 = of2;
                                        i16 = ordinal;
                                    }
                                    add(arrayList, new FieldInfo(str12, cls, cls21, type3, field6, i16, i15, of));
                                    i28++;
                                    name = name;
                                    strArr = strArr;
                                    parameterTypes4 = parameterTypes4;
                                    cls15 = cls15;
                                }
                                cls3 = cls15;
                                if (!isKotlin && !cls.getName().equals("javax.servlet.http.Cookie")) {
                                    return new JavaBeanInfo(cls, cls2, null, constructor2, null, null, jSONType3, arrayList);
                                }
                            } else {
                                throw new JSONException("default constructor not found. " + cls16);
                            }
                        }
                        cls15 = cls14;
                        if (strArr == null) {
                        }
                        if (strArr == null) {
                        }
                        throw new JSONException("default constructor not found. " + cls16);
                    }
                }
                cls3 = cls14;
            }
            constructor3 = null;
            if (constructor3 == null) {
            }
            constructor2 = constructor3;
            if (constructor2 == null) {
            }
            arrayList = arrayList6;
            methodArr = methods;
            cls2 = builderClass;
            cls14 = cls18;
            fieldArr = declaredFields;
            method2 = getFactoryMethod(cls16, methodArr, z4);
            if (method2 == null) {
            }
            cls3 = cls14;
        } else {
            arrayList = arrayList6;
            methodArr = methods;
            cls2 = builderClass;
            cls3 = cls18;
            fieldArr = declaredFields;
            constructor2 = null;
        }
        if (constructor != null) {
            TypeUtils.setAccessible(constructor);
        }
        String str13 = "set";
        Class<?> cls22 = cls2;
        if (cls22 != null) {
            JSONPOJOBuilder jSONPOJOBuilder = (JSONPOJOBuilder) TypeUtils.getAnnotation(cls22, JSONPOJOBuilder.class);
            String withPrefix = jSONPOJOBuilder != null ? jSONPOJOBuilder.withPrefix() : null;
            if (withPrefix == null) {
                withPrefix = "with";
            }
            String str14 = withPrefix;
            Method[] methods2 = cls22.getMethods();
            int length5 = methods2.length;
            int i30 = 0;
            while (i30 < length5) {
                Method method3 = methods2[i30];
                if (!Modifier.isStatic(method3.getModifiers()) && method3.getReturnType().equals(cls22)) {
                    JSONField jSONField6 = (JSONField) TypeUtils.getAnnotation(method3, JSONField.class);
                    if (jSONField6 == null) {
                        jSONField6 = TypeUtils.getSuperMethodAnnotation(cls16, method3);
                    }
                    JSONField jSONField7 = jSONField6;
                    if (jSONField7 == null) {
                        propertyNamingStrategy6 = propertyNamingStrategy8;
                        i10 = i30;
                        i11 = length5;
                        methodArr4 = methods2;
                        str5 = str14;
                        cls11 = cls22;
                        str6 = str13;
                        jSONType2 = jSONType3;
                        fieldArr7 = fieldArr;
                        cls12 = cls3;
                        arrayList4 = arrayList;
                        i12 = 0;
                        i13 = 0;
                        i14 = 0;
                    } else if (jSONField7.deserialize()) {
                        int ordinal2 = jSONField7.ordinal();
                        int of3 = SerializerFeature.of(jSONField7.serialzeFeatures());
                        int of4 = Feature.of(jSONField7.parseFeatures());
                        if (jSONField7.name().length() != 0) {
                            i10 = i30;
                            i11 = length5;
                            methodArr4 = methods2;
                            cls11 = cls22;
                            propertyNamingStrategy6 = propertyNamingStrategy8;
                            jSONType2 = jSONType3;
                            fieldArr7 = fieldArr;
                            cls12 = cls3;
                            arrayList4 = arrayList;
                            add(arrayList4, new FieldInfo(jSONField7.name(), method3, null, cls, type, ordinal2, of3, of4, jSONField7, null, null, buildGenericInfo));
                            str8 = str14;
                            cls13 = cls17;
                            str9 = str13;
                            arrayList5 = arrayList4;
                            i30 = i10 + 1;
                            cls3 = cls12;
                            arrayList = arrayList5;
                            cls17 = cls13;
                            jSONType3 = jSONType2;
                            str14 = str8;
                            length5 = i11;
                            methods2 = methodArr4;
                            cls22 = cls11;
                            propertyNamingStrategy8 = propertyNamingStrategy6;
                            fieldArr = fieldArr7;
                            str13 = str9;
                            cls16 = cls;
                        } else {
                            propertyNamingStrategy6 = propertyNamingStrategy8;
                            i10 = i30;
                            i11 = length5;
                            methodArr4 = methods2;
                            str5 = str14;
                            cls11 = cls22;
                            str6 = str13;
                            jSONType2 = jSONType3;
                            fieldArr7 = fieldArr;
                            cls12 = cls3;
                            arrayList4 = arrayList;
                            i12 = ordinal2;
                            i13 = of3;
                            i14 = of4;
                        }
                    }
                    String name3 = method3.getName();
                    String str15 = str6;
                    if (name3.startsWith(str15) && name3.length() > 3) {
                        sb = new StringBuilder(name3.substring(3));
                        str7 = str5;
                        charAt = sb.charAt(0);
                        if (str7.length() != 0 || Character.isUpperCase(charAt)) {
                            sb.setCharAt(0, Character.toLowerCase(charAt));
                            str8 = str7;
                            str9 = str15;
                            cls13 = cls17;
                            arrayList5 = arrayList4;
                            add(arrayList5, new FieldInfo(sb.toString(), method3, null, cls, type, i12, i13, i14, jSONField7, null, null, buildGenericInfo));
                            i30 = i10 + 1;
                            cls3 = cls12;
                            arrayList = arrayList5;
                            cls17 = cls13;
                            jSONType3 = jSONType2;
                            str14 = str8;
                            length5 = i11;
                            methods2 = methodArr4;
                            cls22 = cls11;
                            propertyNamingStrategy8 = propertyNamingStrategy6;
                            fieldArr = fieldArr7;
                            str13 = str9;
                            cls16 = cls;
                        }
                        str8 = str7;
                        str9 = str15;
                        cls13 = cls17;
                        arrayList5 = arrayList4;
                        i30 = i10 + 1;
                        cls3 = cls12;
                        arrayList = arrayList5;
                        cls17 = cls13;
                        jSONType3 = jSONType2;
                        str14 = str8;
                        length5 = i11;
                        methods2 = methodArr4;
                        cls22 = cls11;
                        propertyNamingStrategy8 = propertyNamingStrategy6;
                        fieldArr = fieldArr7;
                        str13 = str9;
                        cls16 = cls;
                    }
                    if (str5.length() == 0) {
                        sb = new StringBuilder(name3);
                        str7 = str5;
                        charAt = sb.charAt(0);
                        if (str7.length() != 0) {
                        }
                        sb.setCharAt(0, Character.toLowerCase(charAt));
                        str8 = str7;
                        str9 = str15;
                        cls13 = cls17;
                        arrayList5 = arrayList4;
                        add(arrayList5, new FieldInfo(sb.toString(), method3, null, cls, type, i12, i13, i14, jSONField7, null, null, buildGenericInfo));
                        i30 = i10 + 1;
                        cls3 = cls12;
                        arrayList = arrayList5;
                        cls17 = cls13;
                        jSONType3 = jSONType2;
                        str14 = str8;
                        length5 = i11;
                        methods2 = methodArr4;
                        cls22 = cls11;
                        propertyNamingStrategy8 = propertyNamingStrategy6;
                        fieldArr = fieldArr7;
                        str13 = str9;
                        cls16 = cls;
                    } else {
                        str7 = str5;
                        if (name3.startsWith(str7) && name3.length() > str7.length()) {
                            sb = new StringBuilder(name3.substring(str7.length()));
                            charAt = sb.charAt(0);
                            if (str7.length() != 0) {
                            }
                            sb.setCharAt(0, Character.toLowerCase(charAt));
                            str8 = str7;
                            str9 = str15;
                            cls13 = cls17;
                            arrayList5 = arrayList4;
                            add(arrayList5, new FieldInfo(sb.toString(), method3, null, cls, type, i12, i13, i14, jSONField7, null, null, buildGenericInfo));
                            i30 = i10 + 1;
                            cls3 = cls12;
                            arrayList = arrayList5;
                            cls17 = cls13;
                            jSONType3 = jSONType2;
                            str14 = str8;
                            length5 = i11;
                            methods2 = methodArr4;
                            cls22 = cls11;
                            propertyNamingStrategy8 = propertyNamingStrategy6;
                            fieldArr = fieldArr7;
                            str13 = str9;
                            cls16 = cls;
                        }
                        str8 = str7;
                        str9 = str15;
                        cls13 = cls17;
                        arrayList5 = arrayList4;
                        i30 = i10 + 1;
                        cls3 = cls12;
                        arrayList = arrayList5;
                        cls17 = cls13;
                        jSONType3 = jSONType2;
                        str14 = str8;
                        length5 = i11;
                        methods2 = methodArr4;
                        cls22 = cls11;
                        propertyNamingStrategy8 = propertyNamingStrategy6;
                        fieldArr = fieldArr7;
                        str13 = str9;
                        cls16 = cls;
                    }
                }
                propertyNamingStrategy6 = propertyNamingStrategy8;
                i10 = i30;
                i11 = length5;
                methodArr4 = methods2;
                str8 = str14;
                cls11 = cls22;
                str9 = str13;
                jSONType2 = jSONType3;
                fieldArr7 = fieldArr;
                cls13 = cls17;
                cls12 = cls3;
                arrayList5 = arrayList;
                i30 = i10 + 1;
                cls3 = cls12;
                arrayList = arrayList5;
                cls17 = cls13;
                jSONType3 = jSONType2;
                str14 = str8;
                length5 = i11;
                methods2 = methodArr4;
                cls22 = cls11;
                propertyNamingStrategy8 = propertyNamingStrategy6;
                fieldArr = fieldArr7;
                str13 = str9;
                cls16 = cls;
            }
            propertyNamingStrategy2 = propertyNamingStrategy8;
            str = str13;
            jSONType = jSONType3;
            fieldArr2 = fieldArr;
            cls4 = cls17;
            cls5 = cls3;
            cls6 = cls22;
            arrayList2 = arrayList;
            if (cls6 != null) {
                JSONPOJOBuilder jSONPOJOBuilder2 = (JSONPOJOBuilder) TypeUtils.getAnnotation(cls6, JSONPOJOBuilder.class);
                String buildMethod = jSONPOJOBuilder2 != null ? jSONPOJOBuilder2.buildMethod() : null;
                try {
                    method = cls6.getMethod((buildMethod == null || buildMethod.length() == 0) ? "build" : "build", new Class[0]);
                } catch (NoSuchMethodException | SecurityException unused2) {
                }
                if (method == null) {
                    try {
                        method = cls6.getMethod("create", new Class[0]);
                    } catch (NoSuchMethodException | SecurityException unused3) {
                    }
                }
                if (method != null) {
                    TypeUtils.setAccessible(method);
                } else {
                    throw new JSONException("buildMethod not found.");
                }
            }
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy8;
            str = "set";
            jSONType = jSONType3;
            fieldArr2 = fieldArr;
            cls4 = cls17;
            cls5 = cls3;
            cls6 = cls22;
            arrayList2 = arrayList;
        }
        int length6 = methodArr.length;
        int i31 = 0;
        while (true) {
            str2 = "get";
            i2 = 4;
            if (i31 >= length6) {
                break;
            }
            Method method4 = methodArr[i31];
            int i32 = 0;
            int i33 = 0;
            int i34 = 0;
            String name4 = method4.getName();
            if (!Modifier.isStatic(method4.getModifiers())) {
                Class<?> returnType = method4.getReturnType();
                if ((returnType.equals(Void.TYPE) || returnType.equals(method4.getDeclaringClass())) && method4.getDeclaringClass() != cls5) {
                    Class<?>[] parameterTypes5 = method4.getParameterTypes();
                    if (parameterTypes5.length != 0 && parameterTypes5.length <= 2) {
                        JSONField jSONField8 = (JSONField) TypeUtils.getAnnotation(method4, JSONField.class);
                        if (jSONField8 == null || parameterTypes5.length != 2) {
                            i5 = i31;
                            cls7 = cls6;
                            cls8 = cls4;
                            i6 = length6;
                        } else {
                            Class<String> cls23 = cls4;
                            if (parameterTypes5[0] == cls23 && parameterTypes5[1] == cls5) {
                                cls8 = cls23;
                                i5 = i31;
                                i6 = length6;
                                cls7 = cls6;
                                add(arrayList2, new FieldInfo("", method4, null, cls, type, 0, 0, 0, jSONField8, null, null, buildGenericInfo));
                                cls9 = cls5;
                                methodArr3 = methodArr;
                                propertyNamingStrategy4 = propertyNamingStrategy2;
                                fieldArr6 = fieldArr2;
                                str4 = str;
                                i31 = i5 + 1;
                                propertyNamingStrategy2 = propertyNamingStrategy4;
                                length6 = i6;
                                cls6 = cls7;
                                cls4 = cls8;
                                cls5 = cls9;
                                methodArr = methodArr3;
                                str = str4;
                                fieldArr2 = fieldArr6;
                            } else {
                                cls8 = cls23;
                                i5 = i31;
                                i6 = length6;
                                cls7 = cls6;
                            }
                        }
                        if (parameterTypes5.length == 1) {
                            cls9 = cls5;
                            if (jSONField8 == null) {
                                jSONField8 = TypeUtils.getSuperMethodAnnotation(cls, method4);
                            }
                            if (jSONField8 != null || name4.length() >= 4) {
                                if (jSONField8 == null) {
                                    i7 = 1;
                                } else if (jSONField8.deserialize()) {
                                    i32 = jSONField8.ordinal();
                                    i33 = SerializerFeature.of(jSONField8.serialzeFeatures());
                                    int of5 = Feature.of(jSONField8.parseFeatures());
                                    if (jSONField8.name().length() != 0) {
                                        add(arrayList2, new FieldInfo(jSONField8.name(), method4, null, cls, type, i32, i33, of5, jSONField8, null, null, buildGenericInfo));
                                    } else {
                                        i7 = 1;
                                        i34 = of5;
                                    }
                                }
                                String str16 = str;
                                if ((jSONField8 != null || name4.startsWith(str16)) && cls7 == null) {
                                    char charAt2 = name4.charAt(3);
                                    if (isKotlin) {
                                        arrayList3 = new ArrayList();
                                        for (int i35 = 0; i35 < methodArr.length; i35++) {
                                            if (methodArr[i35].getName().startsWith("get")) {
                                                arrayList3.add(methodArr[i35].getName());
                                            }
                                        }
                                    } else {
                                        arrayList3 = null;
                                    }
                                    if (Character.isUpperCase(charAt2) || charAt2 > 512) {
                                        i8 = 1;
                                        cls10 = cls;
                                        fieldArr5 = fieldArr2;
                                        if (isKotlin) {
                                            propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName("g" + name4.substring(1));
                                        } else if (TypeUtils.compatibleWithJavaBean) {
                                            propertyNameByMethodName2 = TypeUtils.decapitalize(name4.substring(3));
                                        } else {
                                            propertyNameByMethodName2 = TypeUtils.getPropertyNameByMethodName(name4);
                                        }
                                    } else {
                                        if (charAt2 != '_') {
                                            i8 = 1;
                                            cls10 = cls;
                                            fieldArr5 = fieldArr2;
                                            if (charAt2 == 'f') {
                                                propertyNameByMethodName2 = name4.substring(3);
                                            } else if (name4.length() >= 5 && Character.isUpperCase(name4.charAt(4))) {
                                                propertyNameByMethodName2 = TypeUtils.decapitalize(name4.substring(3));
                                            } else {
                                                propertyNameByMethodName2 = name4.substring(3);
                                                field2 = TypeUtils.getField(cls10, propertyNameByMethodName2, fieldArr5);
                                            }
                                        } else if (isKotlin) {
                                            propertyNameByMethodName2 = arrayList3.contains("g" + name4.substring(i7)) ? name4.substring(3) : "is" + name4.substring(3);
                                            i8 = 1;
                                            cls10 = cls;
                                            fieldArr5 = fieldArr2;
                                            field2 = TypeUtils.getField(cls10, propertyNameByMethodName2, fieldArr5);
                                        } else {
                                            i8 = 1;
                                            cls10 = cls;
                                            fieldArr5 = fieldArr2;
                                            String substring = name4.substring(4);
                                            Field field7 = TypeUtils.getField(cls10, substring, fieldArr5);
                                            if (field7 != null || (field7 = TypeUtils.getField(cls10, (propertyNameByMethodName2 = name4.substring(3)), fieldArr5)) == null) {
                                                propertyNameByMethodName2 = substring;
                                            }
                                            field2 = field7;
                                        }
                                        if (field2 == null) {
                                            field2 = TypeUtils.getField(cls10, propertyNameByMethodName2, fieldArr5);
                                        }
                                        if (field2 == null && parameterTypes5[0] == Boolean.TYPE) {
                                            field2 = TypeUtils.getField(cls10, "is" + Character.toUpperCase(propertyNameByMethodName2.charAt(0)) + propertyNameByMethodName2.substring(i8), fieldArr5);
                                        }
                                        if (field2 == null) {
                                            JSONField jSONField9 = (JSONField) TypeUtils.getAnnotation(field2, JSONField.class);
                                            if (jSONField9 != null) {
                                                if (jSONField9.deserialize()) {
                                                    i32 = jSONField9.ordinal();
                                                    i33 = SerializerFeature.of(jSONField9.serialzeFeatures());
                                                    i9 = Feature.of(jSONField9.parseFeatures());
                                                    if (jSONField9.name().length() != 0) {
                                                        fieldArr6 = fieldArr5;
                                                        methodArr3 = methodArr;
                                                        str4 = str16;
                                                        add(arrayList2, new FieldInfo(jSONField9.name(), method4, field2, cls, type, i32, i33, i9, jSONField8, jSONField9, null, buildGenericInfo));
                                                        propertyNamingStrategy4 = propertyNamingStrategy2;
                                                        i31 = i5 + 1;
                                                        propertyNamingStrategy2 = propertyNamingStrategy4;
                                                        length6 = i6;
                                                        cls6 = cls7;
                                                        cls4 = cls8;
                                                        cls5 = cls9;
                                                        methodArr = methodArr3;
                                                        str = str4;
                                                        fieldArr2 = fieldArr6;
                                                    } else {
                                                        fieldArr6 = fieldArr5;
                                                        str4 = str16;
                                                        methodArr3 = methodArr;
                                                    }
                                                }
                                                fieldArr6 = fieldArr5;
                                                str4 = str16;
                                                methodArr3 = methodArr;
                                                propertyNamingStrategy4 = propertyNamingStrategy2;
                                            } else {
                                                fieldArr6 = fieldArr5;
                                                str4 = str16;
                                                methodArr3 = methodArr;
                                                i9 = i34;
                                            }
                                            jSONField2 = jSONField9;
                                        } else {
                                            fieldArr6 = fieldArr5;
                                            str4 = str16;
                                            methodArr3 = methodArr;
                                            jSONField2 = null;
                                            i9 = i34;
                                        }
                                        propertyNamingStrategy5 = propertyNamingStrategy2;
                                        if (propertyNamingStrategy5 != null) {
                                            propertyNameByMethodName2 = propertyNamingStrategy5.translate(propertyNameByMethodName2);
                                        }
                                        propertyNamingStrategy4 = propertyNamingStrategy5;
                                        add(arrayList2, new FieldInfo(propertyNameByMethodName2, method4, field2, cls, type, i32, i33, i9, jSONField8, jSONField2, null, buildGenericInfo));
                                        i31 = i5 + 1;
                                        propertyNamingStrategy2 = propertyNamingStrategy4;
                                        length6 = i6;
                                        cls6 = cls7;
                                        cls4 = cls8;
                                        cls5 = cls9;
                                        methodArr = methodArr3;
                                        str = str4;
                                        fieldArr2 = fieldArr6;
                                    }
                                    field2 = null;
                                    if (field2 == null) {
                                    }
                                    if (field2 == null) {
                                        field2 = TypeUtils.getField(cls10, "is" + Character.toUpperCase(propertyNameByMethodName2.charAt(0)) + propertyNameByMethodName2.substring(i8), fieldArr5);
                                    }
                                    if (field2 == null) {
                                    }
                                    propertyNamingStrategy5 = propertyNamingStrategy2;
                                    if (propertyNamingStrategy5 != null) {
                                    }
                                    propertyNamingStrategy4 = propertyNamingStrategy5;
                                    add(arrayList2, new FieldInfo(propertyNameByMethodName2, method4, field2, cls, type, i32, i33, i9, jSONField8, jSONField2, null, buildGenericInfo));
                                    i31 = i5 + 1;
                                    propertyNamingStrategy2 = propertyNamingStrategy4;
                                    length6 = i6;
                                    cls6 = cls7;
                                    cls4 = cls8;
                                    cls5 = cls9;
                                    methodArr = methodArr3;
                                    str = str4;
                                    fieldArr2 = fieldArr6;
                                } else {
                                    str4 = str16;
                                    methodArr3 = methodArr;
                                    propertyNamingStrategy4 = propertyNamingStrategy2;
                                    fieldArr6 = fieldArr2;
                                }
                                i31 = i5 + 1;
                                propertyNamingStrategy2 = propertyNamingStrategy4;
                                length6 = i6;
                                cls6 = cls7;
                                cls4 = cls8;
                                cls5 = cls9;
                                methodArr = methodArr3;
                                str = str4;
                                fieldArr2 = fieldArr6;
                            }
                            methodArr3 = methodArr;
                            propertyNamingStrategy4 = propertyNamingStrategy2;
                            fieldArr6 = fieldArr2;
                            str4 = str;
                            i31 = i5 + 1;
                            propertyNamingStrategy2 = propertyNamingStrategy4;
                            length6 = i6;
                            cls6 = cls7;
                            cls4 = cls8;
                            cls5 = cls9;
                            methodArr = methodArr3;
                            str = str4;
                            fieldArr2 = fieldArr6;
                        }
                        cls9 = cls5;
                        methodArr3 = methodArr;
                        propertyNamingStrategy4 = propertyNamingStrategy2;
                        fieldArr6 = fieldArr2;
                        str4 = str;
                        i31 = i5 + 1;
                        propertyNamingStrategy2 = propertyNamingStrategy4;
                        length6 = i6;
                        cls6 = cls7;
                        cls4 = cls8;
                        cls5 = cls9;
                        methodArr = methodArr3;
                        str = str4;
                        fieldArr2 = fieldArr6;
                    }
                }
            }
            i5 = i31;
            cls7 = cls6;
            cls9 = cls5;
            methodArr3 = methodArr;
            cls8 = cls4;
            propertyNamingStrategy4 = propertyNamingStrategy2;
            fieldArr6 = fieldArr2;
            str4 = str;
            i6 = length6;
            i31 = i5 + 1;
            propertyNamingStrategy2 = propertyNamingStrategy4;
            length6 = i6;
            cls6 = cls7;
            cls4 = cls8;
            cls5 = cls9;
            methodArr = methodArr3;
            str = str4;
            fieldArr2 = fieldArr6;
        }
        Class<?> cls24 = cls6;
        Field[] fieldArr8 = fieldArr2;
        PropertyNamingStrategy propertyNamingStrategy9 = propertyNamingStrategy2;
        Class<?> cls25 = cls;
        computeFields(cls25, type, propertyNamingStrategy9, arrayList2, cls.getFields());
        Method[] methods3 = cls.getMethods();
        int length7 = methods3.length;
        int i36 = 0;
        while (i36 < length7) {
            Method method5 = methods3[i36];
            String name5 = method5.getName();
            if (name5.length() >= i2 && !Modifier.isStatic(method5.getModifiers()) && cls24 == null && name5.startsWith(str2) && Character.isUpperCase(name5.charAt(3)) && method5.getParameterTypes().length == 0 && ((Collection.class.isAssignableFrom(method5.getReturnType()) || Map.class.isAssignableFrom(method5.getReturnType()) || AtomicBoolean.class == method5.getReturnType() || AtomicInteger.class == method5.getReturnType() || AtomicLong.class == method5.getReturnType()) && ((jSONField = (JSONField) TypeUtils.getAnnotation(method5, JSONField.class)) == null || !jSONField.deserialize()))) {
                if (jSONField != null && jSONField.name().length() > 0) {
                    propertyNameByMethodName = jSONField.name();
                    field = null;
                    fieldArr3 = fieldArr8;
                } else {
                    propertyNameByMethodName = TypeUtils.getPropertyNameByMethodName(name5);
                    fieldArr3 = fieldArr8;
                    Field field8 = TypeUtils.getField(cls25, propertyNameByMethodName, fieldArr3);
                    if (field8 != null) {
                        JSONField jSONField10 = (JSONField) TypeUtils.getAnnotation(field8, JSONField.class);
                        if (jSONField10 == null || jSONField10.deserialize()) {
                            if (Collection.class.isAssignableFrom(method5.getReturnType()) || Map.class.isAssignableFrom(method5.getReturnType())) {
                                field = field8;
                            }
                        }
                        fieldArr4 = fieldArr3;
                        i3 = i36;
                        str3 = str2;
                        i4 = length7;
                        methodArr2 = methods3;
                        propertyNamingStrategy3 = propertyNamingStrategy9;
                    }
                    field = null;
                }
                if (propertyNamingStrategy9 != null) {
                    propertyNameByMethodName = propertyNamingStrategy9.translate(propertyNameByMethodName);
                }
                String str17 = propertyNameByMethodName;
                if (getField(arrayList2, str17) == null) {
                    fieldArr4 = fieldArr3;
                    i3 = i36;
                    str3 = str2;
                    i4 = length7;
                    methodArr2 = methods3;
                    propertyNamingStrategy3 = propertyNamingStrategy9;
                    add(arrayList2, new FieldInfo(str17, method5, field, cls, type, 0, 0, 0, jSONField, null, null, buildGenericInfo));
                    i36 = i3 + 1;
                    propertyNamingStrategy9 = propertyNamingStrategy3;
                    length7 = i4;
                    str2 = str3;
                    methods3 = methodArr2;
                    fieldArr8 = fieldArr4;
                    i2 = 4;
                    cls25 = cls;
                }
                fieldArr4 = fieldArr3;
                i3 = i36;
                str3 = str2;
                i4 = length7;
                methodArr2 = methods3;
                propertyNamingStrategy3 = propertyNamingStrategy9;
            } else {
                i3 = i36;
                str3 = str2;
                i4 = length7;
                methodArr2 = methods3;
                propertyNamingStrategy3 = propertyNamingStrategy9;
                fieldArr4 = fieldArr8;
            }
            i36 = i3 + 1;
            propertyNamingStrategy9 = propertyNamingStrategy3;
            length7 = i4;
            str2 = str3;
            methods3 = methodArr2;
            fieldArr8 = fieldArr4;
            i2 = 4;
            cls25 = cls;
        }
        PropertyNamingStrategy propertyNamingStrategy10 = propertyNamingStrategy9;
        Field[] fieldArr9 = fieldArr8;
        if (arrayList2.size() == 0) {
            if (TypeUtils.isXmlField(cls) ? true : z) {
                for (Class<?> cls26 = cls; cls26 != null; cls26 = cls26.getSuperclass()) {
                    computeFields(cls, type, propertyNamingStrategy10, arrayList2, fieldArr9);
                }
            }
        }
        return new JavaBeanInfo(cls, cls24, constructor, constructor2, method2, method, jSONType, arrayList2);
    }
}
