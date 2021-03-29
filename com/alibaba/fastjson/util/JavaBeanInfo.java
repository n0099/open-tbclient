package com.alibaba.fastjson.util;

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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
    public String[] orders;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final String typeKey;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, JSONType jSONType, List<FieldInfo> list) {
        boolean z;
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
        if (this.orders != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (FieldInfo fieldInfo : this.fields) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            int i = 0;
            for (String str : this.orders) {
                FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    fieldInfoArr4[i] = fieldInfo2;
                    linkedHashMap.remove(str);
                    i++;
                }
            }
            for (FieldInfo fieldInfo3 : linkedHashMap.values()) {
                fieldInfoArr4[i] = fieldInfo3;
                i++;
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
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            this.creatorConstructorParameterTypes = parameterTypes;
            if (parameterTypes.length == this.fields.length) {
                int i2 = 0;
                while (true) {
                    Type[] typeArr = this.creatorConstructorParameterTypes;
                    if (i2 >= typeArr.length) {
                        z = true;
                        break;
                    } else if (typeArr[i2] != this.fields[i2].fieldClass) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            z = false;
            if (z) {
                return;
            }
            if (TypeUtils.isKotlin(cls)) {
                this.creatorConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                Annotation[][] parameterAnnotations = constructor2.getParameterAnnotations();
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
            this.creatorConstructorParameters = ASMUtils.lookupParameterNames(constructor2);
        }
    }

    public static boolean add(List<FieldInfo> list, FieldInfo fieldInfo) {
        for (int size = list.size() - 1; size >= 0; size--) {
            FieldInfo fieldInfo2 = list.get(size);
            if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
                    list.remove(size);
                } else if (fieldInfo2.compareTo(fieldInfo) >= 0) {
                    return false;
                } else {
                    list.remove(size);
                }
                list.add(fieldInfo);
                return true;
            }
        }
        list.add(fieldInfo);
        return true;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy) {
        return build(cls, type, propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if ((java.util.Map.class.isAssignableFrom(r5) || java.util.Collection.class.isAssignableFrom(r5) || java.util.concurrent.atomic.AtomicLong.class.equals(r5) || java.util.concurrent.atomic.AtomicInteger.class.equals(r5) || java.util.concurrent.atomic.AtomicBoolean.class.equals(r5)) == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void computeFields(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, List<FieldInfo> list, Field[] fieldArr) {
        int i;
        int i2;
        int i3;
        for (Field field : fieldArr) {
            int modifiers = field.getModifiers();
            if ((modifiers & 8) == 0) {
                boolean z = true;
                if ((modifiers & 16) != 0) {
                    Class<?> type2 = field.getType();
                }
                Iterator<FieldInfo> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().name.equals(field.getName())) {
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    String name = field.getName();
                    JSONField jSONField = (JSONField) field.getAnnotation(JSONField.class);
                    if (jSONField == null) {
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                    } else if (jSONField.deserialize()) {
                        int ordinal = jSONField.ordinal();
                        int of = SerializerFeature.of(jSONField.serialzeFeatures());
                        int of2 = Feature.of(jSONField.parseFeatures());
                        if (jSONField.name().length() != 0) {
                            name = jSONField.name();
                        }
                        i = ordinal;
                        i2 = of;
                        i3 = of2;
                    }
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    add(list, new FieldInfo(name, null, field, cls, type, i, i2, i3, null, jSONField, null));
                }
            }
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
            Annotation[][] parameterAnnotations = constructor3.getParameterAnnotations();
            if (parameterAnnotations.length != 0) {
                int length = parameterAnnotations.length;
                int i = 0;
                while (true) {
                    z = true;
                    if (i >= length) {
                        break;
                    }
                    Annotation[] annotationArr = parameterAnnotations[i];
                    int length2 = annotationArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            z = false;
                            break;
                        } else if (annotationArr[i2] instanceof JSONField) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z) {
                        z = false;
                        break;
                    }
                    i++;
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
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Constructor<?> constructor2 = constructorArr[i];
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
            i++;
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

    public static Method getFactoryMethod(Class<?> cls, Method[] methodArr) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((JSONCreator) method2.getAnnotation(JSONCreator.class)) != null) {
                if (method != null) {
                    throw new JSONException("multi-JSONCreator");
                }
                method = method2;
            }
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

    /* JADX WARN: Code restructure failed: missing block: B:394:0x0928, code lost:
        if (r1.deserialize() == false) goto L254;
     */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x078a  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x07fc  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x080d  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0860  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0848 A[EDGE_INSN: B:419:0x0848->B:354:0x0848 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2) {
        Constructor<?> defaultConstructor;
        Constructor<?> constructor;
        ArrayList arrayList;
        PropertyNamingStrategy propertyNamingStrategy2;
        JSONType jSONType;
        Class<String> cls2;
        Class<?> cls3;
        Method[] methodArr;
        Field[] fieldArr;
        Constructor<?> constructor2;
        Method method;
        PropertyNamingStrategy propertyNamingStrategy3;
        Field[] fieldArr2;
        Method method2;
        Class<?> cls4;
        String str;
        char c2;
        int length;
        int i;
        int i2;
        int length2;
        int i3;
        JSONField jSONField;
        String str2;
        Field[] fieldArr3;
        Field[] fieldArr4;
        int i4;
        int i5;
        Method[] methodArr2;
        Class<?> cls5;
        int i6;
        int i7;
        Class<?> cls6;
        Method[] methodArr3;
        String str3;
        Class<String> cls7;
        String decapitalize;
        Field[] fieldArr5;
        Field field;
        Field[] fieldArr6;
        int i8;
        JSONField jSONField2;
        int i9;
        PropertyNamingStrategy propertyNamingStrategy4;
        PropertyNamingStrategy propertyNamingStrategy5;
        int i10;
        int i11;
        Method[] methodArr4;
        String str4;
        Class<?> cls8;
        String str5;
        Method method3;
        Field[] fieldArr7;
        int i12;
        int i13;
        int i14;
        String str6;
        StringBuilder sb;
        String str7;
        Field[] fieldArr8;
        String str8;
        Class<String> cls9;
        Class<?> cls10;
        Class<?> cls11;
        Class<String> cls12;
        String[] strArr;
        Constructor<?>[] constructorArr;
        int i15;
        String[] lookupParameterNames;
        JSONField jSONField3;
        int ordinal;
        int of;
        int of2;
        JSONField jSONField4;
        JSONField jSONField5;
        PropertyNamingStrategy naming;
        Class<String> cls13 = String.class;
        Class<?> cls14 = Object.class;
        JSONType jSONType2 = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
        PropertyNamingStrategy propertyNamingStrategy6 = (jSONType2 == null || (naming = jSONType2.naming()) == null || naming == PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : naming;
        Class<?> builderClass = getBuilderClass(cls, jSONType2);
        Field[] declaredFields = cls.getDeclaredFields();
        Method[] methods = cls.getMethods();
        boolean isKotlin = TypeUtils.isKotlin(cls);
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (!isKotlin || declaredConstructors.length == 1) {
            if (builderClass == null) {
                defaultConstructor = getDefaultConstructor(cls, declaredConstructors);
            } else {
                defaultConstructor = getDefaultConstructor(builderClass, builderClass.getDeclaredConstructors());
            }
            constructor = defaultConstructor;
        } else {
            constructor = null;
        }
        Method method4 = null;
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            for (Class<?> cls15 = cls; cls15 != null; cls15 = cls15.getSuperclass()) {
                computeFields(cls, type, propertyNamingStrategy6, arrayList2, cls15.getDeclaredFields());
            }
            return new JavaBeanInfo(cls, builderClass, constructor, null, null, null, jSONType2, arrayList2);
        }
        boolean z3 = cls.isInterface() || Modifier.isAbstract(cls.getModifiers());
        if ((constructor == null && builderClass == null) || z3) {
            constructor2 = getCreatorConstructor(declaredConstructors);
            propertyNamingStrategy2 = propertyNamingStrategy6;
            if (constructor2 != null && !z3) {
                TypeUtils.setAccessible(constructor2);
                Class<?>[] parameterTypes = constructor2.getParameterTypes();
                if (parameterTypes.length > 0) {
                    Annotation[][] parameterAnnotations = constructor2.getParameterAnnotations();
                    int i16 = 0;
                    while (i16 < parameterTypes.length) {
                        Annotation[] annotationArr = parameterAnnotations[i16];
                        int length3 = annotationArr.length;
                        int i17 = 0;
                        while (true) {
                            if (i17 >= length3) {
                                jSONField5 = null;
                                break;
                            }
                            Annotation annotation = annotationArr[i17];
                            Annotation[] annotationArr2 = annotationArr;
                            if (annotation instanceof JSONField) {
                                jSONField5 = (JSONField) annotation;
                                break;
                            }
                            i17++;
                            annotationArr = annotationArr2;
                        }
                        if (jSONField5 != null) {
                            ArrayList arrayList3 = arrayList2;
                            add(arrayList3, new FieldInfo(jSONField5.name(), cls, parameterTypes[i16], constructor2.getGenericParameterTypes()[i16], TypeUtils.getField(cls, jSONField5.name(), declaredFields), jSONField5.ordinal(), SerializerFeature.of(jSONField5.serialzeFeatures()), Feature.of(jSONField5.parseFeatures())));
                            i16++;
                            declaredFields = declaredFields;
                            arrayList2 = arrayList3;
                            methods = methods;
                            cls14 = cls14;
                            cls13 = cls13;
                            jSONType2 = jSONType2;
                            parameterTypes = parameterTypes;
                        } else {
                            throw new JSONException("illegal json creator");
                        }
                    }
                }
                arrayList = arrayList2;
                jSONType = jSONType2;
                cls9 = cls13;
                cls10 = cls14;
                methodArr = methods;
                fieldArr = declaredFields;
                method = null;
            } else {
                arrayList = arrayList2;
                jSONType = jSONType2;
                cls9 = cls13;
                cls10 = cls14;
                methodArr = methods;
                fieldArr = declaredFields;
                method = getFactoryMethod(cls, methodArr);
                if (method != null) {
                    TypeUtils.setAccessible(method);
                    Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes2.length > 0) {
                        Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
                        int i18 = 0;
                        while (i18 < parameterTypes2.length) {
                            Annotation[] annotationArr3 = parameterAnnotations2[i18];
                            int length4 = annotationArr3.length;
                            int i19 = 0;
                            while (true) {
                                if (i19 >= length4) {
                                    jSONField4 = null;
                                    break;
                                }
                                Annotation annotation2 = annotationArr3[i19];
                                if (annotation2 instanceof JSONField) {
                                    jSONField4 = (JSONField) annotation2;
                                    break;
                                }
                                i19++;
                            }
                            if (jSONField4 != null) {
                                add(arrayList, new FieldInfo(jSONField4.name(), cls, parameterTypes2[i18], method.getGenericParameterTypes()[i18], TypeUtils.getField(cls, jSONField4.name(), fieldArr), jSONField4.ordinal(), SerializerFeature.of(jSONField4.serialzeFeatures()), Feature.of(jSONField4.parseFeatures())));
                                i18++;
                                parameterAnnotations2 = parameterAnnotations2;
                                parameterTypes2 = parameterTypes2;
                            } else {
                                throw new JSONException("illegal json creator");
                            }
                        }
                        return new JavaBeanInfo(cls, builderClass, null, null, method, null, jSONType, arrayList);
                    }
                } else if (!z3) {
                    String name = cls.getName();
                    if (isKotlin && declaredConstructors.length > 0) {
                        String[] koltinConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                        Constructor<?> koltinConstructor = TypeUtils.getKoltinConstructor(declaredConstructors);
                        TypeUtils.setAccessible(koltinConstructor);
                        constructor2 = koltinConstructor;
                        strArr = koltinConstructorParameters;
                        cls11 = cls10;
                        cls12 = cls9;
                    } else {
                        int length5 = declaredConstructors.length;
                        String[] strArr2 = null;
                        int i20 = 0;
                        while (true) {
                            if (i20 >= length5) {
                                cls11 = cls10;
                                cls12 = cls9;
                                strArr = strArr2;
                                break;
                            }
                            Constructor<?> constructor3 = declaredConstructors[i20];
                            Class<?>[] parameterTypes3 = constructor3.getParameterTypes();
                            if (name.equals("org.springframework.security.web.authentication.WebAuthenticationDetails") && parameterTypes3.length == 2) {
                                cls12 = cls9;
                                if (parameterTypes3[0] == cls12 && parameterTypes3[1] == cls12) {
                                    constructor3.setAccessible(true);
                                    strArr = ASMUtils.lookupParameterNames(constructor3);
                                    constructor2 = constructor3;
                                    cls11 = cls10;
                                    break;
                                }
                            } else {
                                cls12 = cls9;
                            }
                            if (name.equals("org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken") && parameterTypes3.length == 3) {
                                cls11 = cls10;
                                constructorArr = declaredConstructors;
                                if (parameterTypes3[0] == cls11 && parameterTypes3[1] == cls11 && parameterTypes3[2] == Collection.class) {
                                    constructor3.setAccessible(true);
                                    strArr = new String[]{"principal", "credentials", "authorities"};
                                    constructor2 = constructor3;
                                    break;
                                }
                            } else {
                                cls11 = cls10;
                                constructorArr = declaredConstructors;
                            }
                            if (name.equals("org.springframework.security.core.authority.SimpleGrantedAuthority")) {
                                i15 = 1;
                                if (parameterTypes3.length == 1 && parameterTypes3[0] == cls12) {
                                    strArr = new String[]{"authority"};
                                    constructor2 = constructor3;
                                    break;
                                }
                            } else {
                                i15 = 1;
                            }
                            if (((constructor3.getModifiers() & i15) != 0) && (lookupParameterNames = ASMUtils.lookupParameterNames(constructor3)) != null && lookupParameterNames.length != 0 && (constructor2 == null || strArr2 == null || lookupParameterNames.length > strArr2.length)) {
                                strArr2 = lookupParameterNames;
                                constructor2 = constructor3;
                            }
                            i20++;
                            cls9 = cls12;
                            declaredConstructors = constructorArr;
                            cls10 = cls11;
                        }
                        Class<?>[] parameterTypes4 = strArr == null ? constructor2.getParameterTypes() : null;
                        if (strArr == null && parameterTypes4.length == strArr.length) {
                            Annotation[][] parameterAnnotations3 = constructor2.getParameterAnnotations();
                            int i21 = 0;
                            while (i21 < parameterTypes4.length) {
                                Annotation[] annotationArr4 = parameterAnnotations3[i21];
                                String str9 = strArr[i21];
                                int length6 = annotationArr4.length;
                                int i22 = 0;
                                while (true) {
                                    if (i22 >= length6) {
                                        jSONField3 = null;
                                        break;
                                    }
                                    int i23 = length6;
                                    Annotation annotation3 = annotationArr4[i22];
                                    Annotation[] annotationArr5 = annotationArr4;
                                    if (annotation3 instanceof JSONField) {
                                        jSONField3 = (JSONField) annotation3;
                                        break;
                                    }
                                    i22++;
                                    length6 = i23;
                                    annotationArr4 = annotationArr5;
                                }
                                Class<?> cls16 = parameterTypes4[i21];
                                Type type2 = constructor2.getGenericParameterTypes()[i21];
                                Field field2 = TypeUtils.getField(cls, str9, fieldArr);
                                if (field2 != null && jSONField3 == null) {
                                    jSONField3 = (JSONField) field2.getAnnotation(JSONField.class);
                                }
                                if (jSONField3 == null) {
                                    if ("org.springframework.security.core.userdetails.User".equals(name) && "password".equals(str9)) {
                                        of2 = Feature.InitStringFieldAsEmpty.mask;
                                        ordinal = 0;
                                        of = 0;
                                    } else {
                                        ordinal = 0;
                                        of = 0;
                                        of2 = 0;
                                    }
                                } else {
                                    String name2 = jSONField3.name();
                                    if (name2.length() != 0) {
                                        str9 = name2;
                                    }
                                    ordinal = jSONField3.ordinal();
                                    of = SerializerFeature.of(jSONField3.serialzeFeatures());
                                    of2 = Feature.of(jSONField3.parseFeatures());
                                }
                                add(arrayList, new FieldInfo(str9, cls, cls16, type2, field2, ordinal, of, of2));
                                i21++;
                                strArr = strArr;
                                parameterTypes4 = parameterTypes4;
                                name = name;
                                cls11 = cls11;
                                cls12 = cls12;
                            }
                            cls3 = cls11;
                            cls2 = cls12;
                            if (!isKotlin && !cls.getName().equals("javax.servlet.http.Cookie")) {
                                return new JavaBeanInfo(cls, builderClass, null, constructor2, null, null, jSONType, arrayList);
                            }
                        } else {
                            throw new JSONException("default constructor not found. " + cls);
                        }
                    }
                    if (strArr == null) {
                    }
                    if (strArr == null) {
                    }
                    throw new JSONException("default constructor not found. " + cls);
                }
            }
            cls3 = cls10;
            cls2 = cls9;
        } else {
            arrayList = arrayList2;
            propertyNamingStrategy2 = propertyNamingStrategy6;
            jSONType = jSONType2;
            cls2 = cls13;
            cls3 = cls14;
            methodArr = methods;
            fieldArr = declaredFields;
            constructor2 = null;
            method = null;
        }
        if (constructor != null) {
            TypeUtils.setAccessible(constructor);
        }
        String str10 = "set";
        if (builderClass != null) {
            JSONPOJOBuilder jSONPOJOBuilder = (JSONPOJOBuilder) builderClass.getAnnotation(JSONPOJOBuilder.class);
            String withPrefix = jSONPOJOBuilder != null ? jSONPOJOBuilder.withPrefix() : null;
            String str11 = (withPrefix == null || withPrefix.length() == 0) ? "with" : "with";
            Method[] methods2 = builderClass.getMethods();
            int length7 = methods2.length;
            int i24 = 0;
            while (i24 < length7) {
                Method method5 = methods2[i24];
                if (!Modifier.isStatic(method5.getModifiers()) && method5.getReturnType().equals(builderClass)) {
                    JSONField jSONField6 = (JSONField) method5.getAnnotation(JSONField.class);
                    if (jSONField6 == null) {
                        jSONField6 = TypeUtils.getSuperMethodAnnotation(cls, method5);
                    }
                    JSONField jSONField7 = jSONField6;
                    if (jSONField7 == null) {
                        propertyNamingStrategy5 = propertyNamingStrategy2;
                        i10 = i24;
                        i11 = length7;
                        methodArr4 = methods2;
                        str4 = str11;
                        cls8 = builderClass;
                        str5 = str10;
                        method3 = method;
                        fieldArr7 = fieldArr;
                        i12 = 0;
                        i13 = 0;
                        i14 = 0;
                    } else if (jSONField7.deserialize()) {
                        int ordinal2 = jSONField7.ordinal();
                        int of3 = SerializerFeature.of(jSONField7.serialzeFeatures());
                        int of4 = Feature.of(jSONField7.parseFeatures());
                        if (jSONField7.name().length() != 0) {
                            i10 = i24;
                            i11 = length7;
                            methodArr4 = methods2;
                            cls8 = builderClass;
                            propertyNamingStrategy5 = propertyNamingStrategy2;
                            method3 = method;
                            add(arrayList, new FieldInfo(jSONField7.name(), method5, null, cls, type, ordinal2, of3, of4, jSONField7, null, null));
                            fieldArr8 = fieldArr;
                            str7 = str11;
                            str8 = str10;
                            i24 = i10 + 1;
                            str10 = str8;
                            str11 = str7;
                            fieldArr = fieldArr8;
                            length7 = i11;
                            methods2 = methodArr4;
                            builderClass = cls8;
                            method = method3;
                            propertyNamingStrategy2 = propertyNamingStrategy5;
                        } else {
                            propertyNamingStrategy5 = propertyNamingStrategy2;
                            i10 = i24;
                            i11 = length7;
                            methodArr4 = methods2;
                            str4 = str11;
                            cls8 = builderClass;
                            str5 = str10;
                            method3 = method;
                            fieldArr7 = fieldArr;
                            i12 = ordinal2;
                            i13 = of3;
                            i14 = of4;
                        }
                    }
                    String name3 = method5.getName();
                    String str12 = str5;
                    if (name3.startsWith(str12) && name3.length() > 3) {
                        sb = new StringBuilder(name3.substring(3));
                        str6 = str4;
                    } else {
                        str6 = str4;
                        if (name3.startsWith(str6) && name3.length() > str6.length()) {
                            sb = new StringBuilder(name3.substring(str6.length()));
                        }
                        str7 = str6;
                        fieldArr8 = fieldArr7;
                        str8 = str12;
                        i24 = i10 + 1;
                        str10 = str8;
                        str11 = str7;
                        fieldArr = fieldArr8;
                        length7 = i11;
                        methods2 = methodArr4;
                        builderClass = cls8;
                        method = method3;
                        propertyNamingStrategy2 = propertyNamingStrategy5;
                    }
                    char charAt = sb.charAt(0);
                    if (Character.isUpperCase(charAt)) {
                        sb.setCharAt(0, Character.toLowerCase(charAt));
                        str7 = str6;
                        fieldArr8 = fieldArr7;
                        str8 = str12;
                        add(arrayList, new FieldInfo(sb.toString(), method5, null, cls, type, i12, i13, i14, jSONField7, null, null));
                        i24 = i10 + 1;
                        str10 = str8;
                        str11 = str7;
                        fieldArr = fieldArr8;
                        length7 = i11;
                        methods2 = methodArr4;
                        builderClass = cls8;
                        method = method3;
                        propertyNamingStrategy2 = propertyNamingStrategy5;
                    }
                    str7 = str6;
                    fieldArr8 = fieldArr7;
                    str8 = str12;
                    i24 = i10 + 1;
                    str10 = str8;
                    str11 = str7;
                    fieldArr = fieldArr8;
                    length7 = i11;
                    methods2 = methodArr4;
                    builderClass = cls8;
                    method = method3;
                    propertyNamingStrategy2 = propertyNamingStrategy5;
                }
                propertyNamingStrategy5 = propertyNamingStrategy2;
                i10 = i24;
                i11 = length7;
                methodArr4 = methods2;
                str7 = str11;
                cls8 = builderClass;
                fieldArr8 = fieldArr;
                method3 = method;
                str8 = str10;
                i24 = i10 + 1;
                str10 = str8;
                str11 = str7;
                fieldArr = fieldArr8;
                length7 = i11;
                methods2 = methodArr4;
                builderClass = cls8;
                method = method3;
                propertyNamingStrategy2 = propertyNamingStrategy5;
            }
            propertyNamingStrategy3 = propertyNamingStrategy2;
            fieldArr2 = fieldArr;
            method2 = method;
            cls4 = builderClass;
            str = str10;
            if (cls4 != null) {
                JSONPOJOBuilder jSONPOJOBuilder2 = (JSONPOJOBuilder) cls4.getAnnotation(JSONPOJOBuilder.class);
                String buildMethod = jSONPOJOBuilder2 != null ? jSONPOJOBuilder2.buildMethod() : null;
                c2 = 0;
                try {
                    method4 = cls4.getMethod((buildMethod == null || buildMethod.length() == 0) ? "build" : "build", new Class[0]);
                } catch (NoSuchMethodException | SecurityException unused) {
                }
                if (method4 == null) {
                    try {
                        method4 = cls4.getMethod("create", new Class[0]);
                    } catch (NoSuchMethodException | SecurityException unused2) {
                    }
                }
                if (method4 != null) {
                    TypeUtils.setAccessible(method4);
                    length = methodArr.length;
                    i = 0;
                    while (true) {
                        i2 = 4;
                        if (i < length) {
                            break;
                        }
                        Method method6 = methodArr[i];
                        int i25 = 0;
                        int i26 = 0;
                        int i27 = 0;
                        String name4 = method6.getName();
                        if (!Modifier.isStatic(method6.getModifiers())) {
                            Class<?> returnType = method6.getReturnType();
                            if (returnType.equals(Void.TYPE) || returnType.equals(method6.getDeclaringClass())) {
                                Class<?> cls17 = cls3;
                                if (method6.getDeclaringClass() != cls17) {
                                    Class<?>[] parameterTypes5 = method6.getParameterTypes();
                                    if (parameterTypes5.length != 0 && parameterTypes5.length <= 2) {
                                        JSONField jSONField8 = (JSONField) method6.getAnnotation(JSONField.class);
                                        if (jSONField8 == null || parameterTypes5.length != 2) {
                                            cls5 = cls17;
                                            i6 = i;
                                            i7 = length;
                                            cls6 = cls4;
                                            cls7 = cls2;
                                        } else {
                                            Class<?> cls18 = cls4;
                                            Class<String> cls19 = cls2;
                                            if (parameterTypes5[c2] == cls19 && parameterTypes5[1] == cls17) {
                                                cls5 = cls17;
                                                i6 = i;
                                                i7 = length;
                                                cls7 = cls19;
                                                cls6 = cls18;
                                                add(arrayList, new FieldInfo("", method6, null, cls, type, 0, 0, 0, jSONField8, null, null));
                                                methodArr3 = methodArr;
                                                str3 = str;
                                                propertyNamingStrategy4 = propertyNamingStrategy3;
                                                i = i6 + 1;
                                                propertyNamingStrategy3 = propertyNamingStrategy4;
                                                methodArr = methodArr3;
                                                cls4 = cls6;
                                                length = i7;
                                                cls2 = cls7;
                                                str = str3;
                                                c2 = 0;
                                                cls3 = cls5;
                                            } else {
                                                cls5 = cls17;
                                                i6 = i;
                                                i7 = length;
                                                cls7 = cls19;
                                                cls6 = cls18;
                                            }
                                        }
                                        if (parameterTypes5.length == 1) {
                                            JSONField superMethodAnnotation = jSONField8 == null ? TypeUtils.getSuperMethodAnnotation(cls, method6) : jSONField8;
                                            if (superMethodAnnotation != null || name4.length() >= 4) {
                                                if (superMethodAnnotation == null) {
                                                    methodArr3 = methodArr;
                                                } else if (superMethodAnnotation.deserialize()) {
                                                    i25 = superMethodAnnotation.ordinal();
                                                    int of5 = SerializerFeature.of(superMethodAnnotation.serialzeFeatures());
                                                    int of6 = Feature.of(superMethodAnnotation.parseFeatures());
                                                    if (superMethodAnnotation.name().length() != 0) {
                                                        methodArr3 = methodArr;
                                                        add(arrayList, new FieldInfo(superMethodAnnotation.name(), method6, null, cls, type, i25, of5, of6, superMethodAnnotation, null, null));
                                                        str3 = str;
                                                        propertyNamingStrategy4 = propertyNamingStrategy3;
                                                        i = i6 + 1;
                                                        propertyNamingStrategy3 = propertyNamingStrategy4;
                                                        methodArr = methodArr3;
                                                        cls4 = cls6;
                                                        length = i7;
                                                        cls2 = cls7;
                                                        str = str3;
                                                        c2 = 0;
                                                        cls3 = cls5;
                                                    } else {
                                                        methodArr3 = methodArr;
                                                        i26 = of5;
                                                        i27 = of6;
                                                    }
                                                }
                                                if (superMethodAnnotation != null || name4.startsWith(str)) {
                                                    char charAt2 = name4.charAt(3);
                                                    if (Character.isUpperCase(charAt2) || charAt2 > 512) {
                                                        decapitalize = TypeUtils.compatibleWithJavaBean ? TypeUtils.decapitalize(name4.substring(3)) : Character.toLowerCase(name4.charAt(3)) + name4.substring(4);
                                                    } else if (charAt2 == '_') {
                                                        decapitalize = name4.substring(4);
                                                        fieldArr5 = fieldArr2;
                                                        field = TypeUtils.getField(cls, decapitalize, fieldArr5);
                                                        if (field == null && parameterTypes5[0] == Boolean.TYPE) {
                                                            field = TypeUtils.getField(cls, "is" + Character.toUpperCase(decapitalize.charAt(0)) + decapitalize.substring(1), fieldArr5);
                                                        }
                                                        if (field == null) {
                                                            JSONField jSONField9 = (JSONField) field.getAnnotation(JSONField.class);
                                                            if (jSONField9 == null) {
                                                                str3 = str;
                                                                fieldArr6 = fieldArr5;
                                                                i8 = i26;
                                                                jSONField2 = jSONField9;
                                                            } else if (jSONField9.deserialize()) {
                                                                i25 = jSONField9.ordinal();
                                                                i8 = SerializerFeature.of(jSONField9.serialzeFeatures());
                                                                int of7 = Feature.of(jSONField9.parseFeatures());
                                                                if (jSONField9.name().length() != 0) {
                                                                    str3 = str;
                                                                    add(arrayList, new FieldInfo(jSONField9.name(), method6, field, cls, type, i25, i8, of7, superMethodAnnotation, jSONField9, null));
                                                                    fieldArr2 = fieldArr5;
                                                                    propertyNamingStrategy4 = propertyNamingStrategy3;
                                                                    i = i6 + 1;
                                                                    propertyNamingStrategy3 = propertyNamingStrategy4;
                                                                    methodArr = methodArr3;
                                                                    cls4 = cls6;
                                                                    length = i7;
                                                                    cls2 = cls7;
                                                                    str = str3;
                                                                    c2 = 0;
                                                                    cls3 = cls5;
                                                                } else {
                                                                    str3 = str;
                                                                    fieldArr6 = fieldArr5;
                                                                    i9 = of7;
                                                                    jSONField2 = jSONField9;
                                                                    propertyNamingStrategy4 = propertyNamingStrategy3;
                                                                    if (propertyNamingStrategy4 != null) {
                                                                        decapitalize = propertyNamingStrategy4.translate(decapitalize);
                                                                    }
                                                                    fieldArr2 = fieldArr6;
                                                                    add(arrayList, new FieldInfo(decapitalize, method6, field, cls, type, i25, i8, i9, superMethodAnnotation, jSONField2, null));
                                                                    i = i6 + 1;
                                                                    propertyNamingStrategy3 = propertyNamingStrategy4;
                                                                    methodArr = methodArr3;
                                                                    cls4 = cls6;
                                                                    length = i7;
                                                                    cls2 = cls7;
                                                                    str = str3;
                                                                    c2 = 0;
                                                                    cls3 = cls5;
                                                                }
                                                            } else {
                                                                fieldArr2 = fieldArr5;
                                                            }
                                                        } else {
                                                            str3 = str;
                                                            fieldArr6 = fieldArr5;
                                                            i8 = i26;
                                                            jSONField2 = null;
                                                        }
                                                        i9 = i27;
                                                        propertyNamingStrategy4 = propertyNamingStrategy3;
                                                        if (propertyNamingStrategy4 != null) {
                                                        }
                                                        fieldArr2 = fieldArr6;
                                                        add(arrayList, new FieldInfo(decapitalize, method6, field, cls, type, i25, i8, i9, superMethodAnnotation, jSONField2, null));
                                                        i = i6 + 1;
                                                        propertyNamingStrategy3 = propertyNamingStrategy4;
                                                        methodArr = methodArr3;
                                                        cls4 = cls6;
                                                        length = i7;
                                                        cls2 = cls7;
                                                        str = str3;
                                                        c2 = 0;
                                                        cls3 = cls5;
                                                    } else if (charAt2 == 'f') {
                                                        decapitalize = name4.substring(3);
                                                    } else if (name4.length() >= 5 && Character.isUpperCase(name4.charAt(4))) {
                                                        decapitalize = TypeUtils.decapitalize(name4.substring(3));
                                                    }
                                                    fieldArr5 = fieldArr2;
                                                    field = TypeUtils.getField(cls, decapitalize, fieldArr5);
                                                    if (field == null) {
                                                        field = TypeUtils.getField(cls, "is" + Character.toUpperCase(decapitalize.charAt(0)) + decapitalize.substring(1), fieldArr5);
                                                    }
                                                    if (field == null) {
                                                    }
                                                    i9 = i27;
                                                    propertyNamingStrategy4 = propertyNamingStrategy3;
                                                    if (propertyNamingStrategy4 != null) {
                                                    }
                                                    fieldArr2 = fieldArr6;
                                                    add(arrayList, new FieldInfo(decapitalize, method6, field, cls, type, i25, i8, i9, superMethodAnnotation, jSONField2, null));
                                                    i = i6 + 1;
                                                    propertyNamingStrategy3 = propertyNamingStrategy4;
                                                    methodArr = methodArr3;
                                                    cls4 = cls6;
                                                    length = i7;
                                                    cls2 = cls7;
                                                    str = str3;
                                                    c2 = 0;
                                                    cls3 = cls5;
                                                }
                                                str3 = str;
                                                propertyNamingStrategy4 = propertyNamingStrategy3;
                                                i = i6 + 1;
                                                propertyNamingStrategy3 = propertyNamingStrategy4;
                                                methodArr = methodArr3;
                                                cls4 = cls6;
                                                length = i7;
                                                cls2 = cls7;
                                                str = str3;
                                                c2 = 0;
                                                cls3 = cls5;
                                            }
                                        }
                                        methodArr3 = methodArr;
                                        str3 = str;
                                        propertyNamingStrategy4 = propertyNamingStrategy3;
                                        i = i6 + 1;
                                        propertyNamingStrategy3 = propertyNamingStrategy4;
                                        methodArr = methodArr3;
                                        cls4 = cls6;
                                        length = i7;
                                        cls2 = cls7;
                                        str = str3;
                                        c2 = 0;
                                        cls3 = cls5;
                                    }
                                }
                                cls5 = cls17;
                                i6 = i;
                                i7 = length;
                                cls6 = cls4;
                                methodArr3 = methodArr;
                                str3 = str;
                                cls7 = cls2;
                                propertyNamingStrategy4 = propertyNamingStrategy3;
                                i = i6 + 1;
                                propertyNamingStrategy3 = propertyNamingStrategy4;
                                methodArr = methodArr3;
                                cls4 = cls6;
                                length = i7;
                                cls2 = cls7;
                                str = str3;
                                c2 = 0;
                                cls3 = cls5;
                            }
                        }
                        i6 = i;
                        i7 = length;
                        cls6 = cls4;
                        methodArr3 = methodArr;
                        str3 = str;
                        cls5 = cls3;
                        cls7 = cls2;
                        propertyNamingStrategy4 = propertyNamingStrategy3;
                        i = i6 + 1;
                        propertyNamingStrategy3 = propertyNamingStrategy4;
                        methodArr = methodArr3;
                        cls4 = cls6;
                        length = i7;
                        cls2 = cls7;
                        str = str3;
                        c2 = 0;
                        cls3 = cls5;
                    }
                    Class<?> cls20 = cls4;
                    PropertyNamingStrategy propertyNamingStrategy7 = propertyNamingStrategy3;
                    int i28 = 3;
                    computeFields(cls, type, propertyNamingStrategy7, arrayList, cls.getFields());
                    Method[] methods3 = cls.getMethods();
                    length2 = methods3.length;
                    i3 = 0;
                    while (i3 < length2) {
                        Method method7 = methods3[i3];
                        String name5 = method7.getName();
                        if (name5.length() >= i2 && !Modifier.isStatic(method7.getModifiers()) && cls20 == null && name5.startsWith("get") && Character.isUpperCase(name5.charAt(i28)) && method7.getParameterTypes().length == 0 && ((Collection.class.isAssignableFrom(method7.getReturnType()) || Map.class.isAssignableFrom(method7.getReturnType()) || AtomicBoolean.class == method7.getReturnType() || AtomicInteger.class == method7.getReturnType() || AtomicLong.class == method7.getReturnType()) && ((jSONField = (JSONField) method7.getAnnotation(JSONField.class)) == null || !jSONField.deserialize()))) {
                            if (jSONField != null && jSONField.name().length() > 0) {
                                str2 = jSONField.name();
                                fieldArr3 = fieldArr2;
                            } else {
                                str2 = Character.toLowerCase(name5.charAt(i28)) + name5.substring(i2);
                                fieldArr3 = fieldArr2;
                                Field field3 = TypeUtils.getField(cls, str2, fieldArr3);
                                if (field3 != null) {
                                    JSONField jSONField10 = (JSONField) field3.getAnnotation(JSONField.class);
                                    if (jSONField10 != null) {
                                    }
                                }
                            }
                            if (getField(arrayList, str2) == null) {
                                if (propertyNamingStrategy7 != null) {
                                    str2 = propertyNamingStrategy7.translate(str2);
                                }
                                fieldArr4 = fieldArr3;
                                i4 = i3;
                                i5 = length2;
                                methodArr2 = methods3;
                                add(arrayList, new FieldInfo(str2, method7, null, cls, type, 0, 0, 0, jSONField, null, null));
                            }
                            fieldArr4 = fieldArr3;
                            i4 = i3;
                            i5 = length2;
                            methodArr2 = methods3;
                        } else {
                            i5 = length2;
                            methodArr2 = methods3;
                            fieldArr4 = fieldArr2;
                            i4 = i3;
                        }
                        i3 = i4 + 1;
                        methods3 = methodArr2;
                        length2 = i5;
                        fieldArr2 = fieldArr4;
                        i2 = 4;
                        i28 = 3;
                    }
                    return new JavaBeanInfo(cls, cls20, constructor, constructor2, method2, method4, jSONType, arrayList);
                }
                throw new JSONException("buildMethod not found.");
            }
        } else {
            propertyNamingStrategy3 = propertyNamingStrategy2;
            fieldArr2 = fieldArr;
            method2 = method;
            cls4 = builderClass;
            str = "set";
        }
        c2 = 0;
        length = methodArr.length;
        i = 0;
        while (true) {
            i2 = 4;
            if (i < length) {
            }
            i = i6 + 1;
            propertyNamingStrategy3 = propertyNamingStrategy4;
            methodArr = methodArr3;
            cls4 = cls6;
            length = i7;
            cls2 = cls7;
            str = str3;
            c2 = 0;
            cls3 = cls5;
        }
        Class<?> cls202 = cls4;
        PropertyNamingStrategy propertyNamingStrategy72 = propertyNamingStrategy3;
        int i282 = 3;
        computeFields(cls, type, propertyNamingStrategy72, arrayList, cls.getFields());
        Method[] methods32 = cls.getMethods();
        length2 = methods32.length;
        i3 = 0;
        while (i3 < length2) {
        }
        return new JavaBeanInfo(cls, cls202, constructor, constructor2, method2, method4, jSONType, arrayList);
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
}
