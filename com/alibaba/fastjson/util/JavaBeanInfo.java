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
/* loaded from: classes19.dex */
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
        int i;
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
        this.fields = new FieldInfo[list.size()];
        list.toArray(this.fields);
        FieldInfo[] fieldInfoArr2 = new FieldInfo[this.fields.length];
        if (this.orders != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (FieldInfo fieldInfo : this.fields) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            int i2 = 0;
            String[] strArr = this.orders;
            int length = strArr.length;
            int i3 = 0;
            while (i3 < length) {
                String str = strArr[i3];
                FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    fieldInfoArr2[i2] = fieldInfo2;
                    linkedHashMap.remove(str);
                    i = i2 + 1;
                } else {
                    i = i2;
                }
                i3++;
                i2 = i;
            }
            for (FieldInfo fieldInfo3 : linkedHashMap.values()) {
                fieldInfoArr2[i2] = fieldInfo3;
                i2++;
            }
        } else {
            System.arraycopy(this.fields, 0, fieldInfoArr2, 0, this.fields.length);
            Arrays.sort(fieldInfoArr2);
        }
        this.sortedFields = Arrays.equals(this.fields, fieldInfoArr2) ? this.fields : fieldInfoArr2;
        if (constructor != null) {
            this.defaultConstructorParameterSize = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.defaultConstructorParameterSize = method.getParameterTypes().length;
        } else {
            this.defaultConstructorParameterSize = 0;
        }
        if (constructor2 != null) {
            this.creatorConstructorParameterTypes = constructor2.getParameterTypes();
            if (this.creatorConstructorParameterTypes.length != this.fields.length) {
                z = false;
            } else {
                int i4 = 0;
                while (true) {
                    if (i4 >= this.creatorConstructorParameterTypes.length) {
                        z = true;
                        break;
                    } else if (this.creatorConstructorParameterTypes[i4] == this.fields[i4].fieldClass) {
                        i4++;
                    } else {
                        z = false;
                        break;
                    }
                }
            }
            if (!z) {
                if (TypeUtils.isKotlin(cls)) {
                    this.creatorConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                    Annotation[][] parameterAnnotations = constructor2.getParameterAnnotations();
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < this.creatorConstructorParameters.length && i6 < parameterAnnotations.length) {
                            Annotation[] annotationArr = parameterAnnotations[i6];
                            int length2 = annotationArr.length;
                            int i7 = 0;
                            while (true) {
                                if (i7 >= length2) {
                                    jSONField = null;
                                    break;
                                }
                                Annotation annotation = annotationArr[i7];
                                if (!(annotation instanceof JSONField)) {
                                    i7++;
                                } else {
                                    jSONField = (JSONField) annotation;
                                    break;
                                }
                            }
                            if (jSONField != null) {
                                String name = jSONField.name();
                                if (name.length() > 0) {
                                    this.creatorConstructorParameters[i6] = name;
                                }
                            }
                            i5 = i6 + 1;
                        } else {
                            return;
                        }
                    }
                } else {
                    this.creatorConstructorParameters = ASMUtils.lookupParameterNames(constructor2);
                }
            }
        }
    }

    private static FieldInfo getField(List<FieldInfo> list, String str) {
        for (FieldInfo fieldInfo : list) {
            if (!fieldInfo.name.equals(str)) {
                Field field = fieldInfo.field;
                if (field != null && fieldInfo.getAnnotation() != null && field.getName().equals(str)) {
                    return fieldInfo;
                }
            } else {
                return fieldInfo;
            }
        }
        return null;
    }

    static boolean add(List<FieldInfo> list, FieldInfo fieldInfo) {
        for (int size = list.size() - 1; size >= 0; size--) {
            FieldInfo fieldInfo2 = list.get(size);
            if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
                    list.remove(size);
                } else if (fieldInfo2.compareTo(fieldInfo) < 0) {
                    list.remove(size);
                } else {
                    return false;
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

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2) {
        JSONField jSONField;
        String str;
        JSONField jSONField2;
        String str2;
        String str3;
        String str4;
        StringBuilder sb;
        String[] strArr;
        Constructor<?> constructor;
        Class<?>[] clsArr;
        JSONField jSONField3;
        int ordinal;
        int of;
        int of2;
        JSONField jSONField4;
        JSONField jSONField5;
        PropertyNamingStrategy naming;
        JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
        if (jSONType != null && (naming = jSONType.naming()) != null && naming != PropertyNamingStrategy.CamelCase) {
            propertyNamingStrategy = naming;
        }
        Class<?> builderClass = getBuilderClass(cls, jSONType);
        Field[] declaredFields = cls.getDeclaredFields();
        Method[] methods = cls.getMethods();
        boolean isKotlin = TypeUtils.isKotlin(cls);
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        Constructor<?> constructor2 = null;
        if (!isKotlin || declaredConstructors.length == 1) {
            if (builderClass == null) {
                constructor2 = getDefaultConstructor(cls, declaredConstructors);
            } else {
                constructor2 = getDefaultConstructor(builderClass, builderClass.getDeclaredConstructors());
            }
        }
        Constructor<?> constructor3 = null;
        Method method = null;
        Method method2 = null;
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                computeFields(cls, type, propertyNamingStrategy, arrayList, cls2.getDeclaredFields());
            }
            return new JavaBeanInfo(cls, builderClass, constructor2, null, null, null, jSONType, arrayList);
        }
        boolean z3 = cls.isInterface() || Modifier.isAbstract(cls.getModifiers());
        if ((constructor2 == null && builderClass == null) || z3) {
            constructor3 = getCreatorConstructor(declaredConstructors);
            if (constructor3 != null && !z3) {
                TypeUtils.setAccessible(constructor3);
                Class<?>[] parameterTypes = constructor3.getParameterTypes();
                if (parameterTypes.length > 0) {
                    Annotation[][] parameterAnnotations = constructor3.getParameterAnnotations();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= parameterTypes.length) {
                            break;
                        }
                        Annotation[] annotationArr = parameterAnnotations[i2];
                        int length = annotationArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                jSONField5 = null;
                                break;
                            }
                            Annotation annotation = annotationArr[i3];
                            if (!(annotation instanceof JSONField)) {
                                i3++;
                            } else {
                                jSONField5 = (JSONField) annotation;
                                break;
                            }
                        }
                        if (jSONField5 == null) {
                            throw new JSONException("illegal json creator");
                        }
                        add(arrayList, new FieldInfo(jSONField5.name(), cls, parameterTypes[i2], constructor3.getGenericParameterTypes()[i2], TypeUtils.getField(cls, jSONField5.name(), declaredFields), jSONField5.ordinal(), SerializerFeature.of(jSONField5.serialzeFeatures()), Feature.of(jSONField5.parseFeatures())));
                        i = i2 + 1;
                    }
                }
            } else {
                method2 = getFactoryMethod(cls, methods);
                if (method2 != null) {
                    TypeUtils.setAccessible(method2);
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length > 0) {
                        Annotation[][] parameterAnnotations2 = method2.getParameterAnnotations();
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 < parameterTypes2.length) {
                                Annotation[] annotationArr2 = parameterAnnotations2[i5];
                                int length2 = annotationArr2.length;
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= length2) {
                                        jSONField4 = null;
                                        break;
                                    }
                                    Annotation annotation2 = annotationArr2[i6];
                                    if (!(annotation2 instanceof JSONField)) {
                                        i6++;
                                    } else {
                                        jSONField4 = (JSONField) annotation2;
                                        break;
                                    }
                                }
                                if (jSONField4 == null) {
                                    throw new JSONException("illegal json creator");
                                }
                                add(arrayList, new FieldInfo(jSONField4.name(), cls, parameterTypes2[i5], method2.getGenericParameterTypes()[i5], TypeUtils.getField(cls, jSONField4.name(), declaredFields), jSONField4.ordinal(), SerializerFeature.of(jSONField4.serialzeFeatures()), Feature.of(jSONField4.parseFeatures())));
                                i4 = i5 + 1;
                            } else {
                                return new JavaBeanInfo(cls, builderClass, null, null, method2, null, jSONType, arrayList);
                            }
                        }
                    }
                } else if (!z3) {
                    String name = cls.getName();
                    if (isKotlin && declaredConstructors.length > 0) {
                        String[] koltinConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                        Constructor<?> koltinConstructor = TypeUtils.getKoltinConstructor(declaredConstructors);
                        TypeUtils.setAccessible(koltinConstructor);
                        strArr = koltinConstructorParameters;
                        constructor3 = koltinConstructor;
                    } else {
                        int length3 = declaredConstructors.length;
                        int i7 = 0;
                        String[] strArr2 = null;
                        while (true) {
                            if (i7 >= length3) {
                                strArr = strArr2;
                                break;
                            }
                            Constructor<?> constructor4 = declaredConstructors[i7];
                            Class<?>[] parameterTypes3 = constructor4.getParameterTypes();
                            if (name.equals("org.springframework.security.web.authentication.WebAuthenticationDetails") && parameterTypes3.length == 2 && parameterTypes3[0] == String.class && parameterTypes3[1] == String.class) {
                                constructor4.setAccessible(true);
                                strArr = ASMUtils.lookupParameterNames(constructor4);
                                constructor3 = constructor4;
                                break;
                            } else if (name.equals("org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken") && parameterTypes3.length == 3 && parameterTypes3[0] == Object.class && parameterTypes3[1] == Object.class && parameterTypes3[2] == Collection.class) {
                                constructor4.setAccessible(true);
                                strArr = new String[]{"principal", "credentials", "authorities"};
                                constructor3 = constructor4;
                                break;
                            } else if (name.equals("org.springframework.security.core.authority.SimpleGrantedAuthority") && parameterTypes3.length == 1 && parameterTypes3[0] == String.class) {
                                strArr = new String[]{"authority"};
                                constructor3 = constructor4;
                                break;
                            } else {
                                if ((constructor4.getModifiers() & 1) != 0) {
                                    String[] lookupParameterNames = ASMUtils.lookupParameterNames(constructor4);
                                    if (lookupParameterNames == null) {
                                        constructor = constructor3;
                                    } else if (lookupParameterNames.length == 0) {
                                        constructor = constructor3;
                                    } else if (constructor3 == null || strArr2 == null || lookupParameterNames.length > strArr2.length) {
                                        strArr2 = lookupParameterNames;
                                        constructor = constructor4;
                                    } else {
                                        constructor = constructor3;
                                    }
                                } else {
                                    constructor = constructor3;
                                }
                                i7++;
                                constructor3 = constructor;
                            }
                        }
                    }
                    if (strArr == null) {
                        clsArr = null;
                    } else {
                        clsArr = constructor3.getParameterTypes();
                    }
                    if (strArr != null && clsArr.length == strArr.length) {
                        Annotation[][] parameterAnnotations3 = constructor3.getParameterAnnotations();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= clsArr.length) {
                                break;
                            }
                            Annotation[] annotationArr3 = parameterAnnotations3[i9];
                            String str5 = strArr[i9];
                            int length4 = annotationArr3.length;
                            int i10 = 0;
                            while (true) {
                                int i11 = i10;
                                if (i11 >= length4) {
                                    jSONField3 = null;
                                    break;
                                }
                                Annotation annotation3 = annotationArr3[i11];
                                if (!(annotation3 instanceof JSONField)) {
                                    i10 = i11 + 1;
                                } else {
                                    jSONField3 = (JSONField) annotation3;
                                    break;
                                }
                            }
                            Class<?> cls3 = clsArr[i9];
                            Type type2 = constructor3.getGenericParameterTypes()[i9];
                            Field field = TypeUtils.getField(cls, str5, declaredFields);
                            JSONField jSONField6 = (field == null || jSONField3 != null) ? jSONField3 : (JSONField) field.getAnnotation(JSONField.class);
                            if (jSONField6 == null) {
                                ordinal = 0;
                                of = 0;
                                if ("org.springframework.security.core.userdetails.User".equals(name) && "password".equals(str5)) {
                                    of2 = Feature.InitStringFieldAsEmpty.mask;
                                } else {
                                    of2 = 0;
                                }
                            } else {
                                String name2 = jSONField6.name();
                                if (name2.length() == 0) {
                                    name2 = str5;
                                }
                                ordinal = jSONField6.ordinal();
                                of = SerializerFeature.of(jSONField6.serialzeFeatures());
                                of2 = Feature.of(jSONField6.parseFeatures());
                                str5 = name2;
                            }
                            add(arrayList, new FieldInfo(str5, cls, cls3, type2, field, ordinal, of, of2));
                            i8 = i9 + 1;
                        }
                        if (!isKotlin && !cls.getName().equals("javax.servlet.http.Cookie")) {
                            return new JavaBeanInfo(cls, builderClass, null, constructor3, null, null, jSONType, arrayList);
                        }
                    } else {
                        throw new JSONException("default constructor not found. " + cls);
                    }
                }
            }
        }
        if (constructor2 != null) {
            TypeUtils.setAccessible(constructor2);
        }
        if (builderClass != null) {
            JSONPOJOBuilder jSONPOJOBuilder = (JSONPOJOBuilder) builderClass.getAnnotation(JSONPOJOBuilder.class);
            if (jSONPOJOBuilder == null) {
                str3 = null;
            } else {
                str3 = jSONPOJOBuilder.withPrefix();
            }
            String str6 = (str3 == null || str3.length() == 0) ? "with" : str3;
            Method[] methods2 = builderClass.getMethods();
            int length5 = methods2.length;
            int i12 = 0;
            while (true) {
                int i13 = i12;
                if (i13 >= length5) {
                    break;
                }
                Method method3 = methods2[i13];
                if (!Modifier.isStatic(method3.getModifiers()) && method3.getReturnType().equals(builderClass)) {
                    int i14 = 0;
                    int i15 = 0;
                    int i16 = 0;
                    JSONField jSONField7 = (JSONField) method3.getAnnotation(JSONField.class);
                    JSONField superMethodAnnotation = jSONField7 == null ? TypeUtils.getSuperMethodAnnotation(cls, method3) : jSONField7;
                    if (superMethodAnnotation != null) {
                        if (superMethodAnnotation.deserialize()) {
                            i14 = superMethodAnnotation.ordinal();
                            i15 = SerializerFeature.of(superMethodAnnotation.serialzeFeatures());
                            i16 = Feature.of(superMethodAnnotation.parseFeatures());
                            if (superMethodAnnotation.name().length() != 0) {
                                add(arrayList, new FieldInfo(superMethodAnnotation.name(), method3, null, cls, type, i14, i15, i16, superMethodAnnotation, null, null));
                            }
                        }
                    }
                    String name3 = method3.getName();
                    if (name3.startsWith("set") && name3.length() > 3) {
                        sb = new StringBuilder(name3.substring(3));
                    } else if (name3.startsWith(str6) && name3.length() > str6.length()) {
                        sb = new StringBuilder(name3.substring(str6.length()));
                    }
                    char charAt = sb.charAt(0);
                    if (Character.isUpperCase(charAt)) {
                        sb.setCharAt(0, Character.toLowerCase(charAt));
                        add(arrayList, new FieldInfo(sb.toString(), method3, null, cls, type, i14, i15, i16, superMethodAnnotation, null, null));
                    }
                }
                i12 = i13 + 1;
            }
            if (builderClass != null) {
                JSONPOJOBuilder jSONPOJOBuilder2 = (JSONPOJOBuilder) builderClass.getAnnotation(JSONPOJOBuilder.class);
                if (jSONPOJOBuilder2 == null) {
                    str4 = null;
                } else {
                    str4 = jSONPOJOBuilder2.buildMethod();
                }
                try {
                    method = builderClass.getMethod((str4 == null || str4.length() == 0) ? "build" : "build", new Class[0]);
                } catch (NoSuchMethodException e) {
                } catch (SecurityException e2) {
                }
                if (method == null) {
                    try {
                        method = builderClass.getMethod("create", new Class[0]);
                    } catch (NoSuchMethodException e3) {
                    } catch (SecurityException e4) {
                    }
                }
                if (method == null) {
                    throw new JSONException("buildMethod not found.");
                }
                TypeUtils.setAccessible(method);
            }
        }
        int length6 = methods.length;
        int i17 = 0;
        while (true) {
            int i18 = i17;
            if (i18 >= length6) {
                break;
            }
            Method method4 = methods[i18];
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            String name4 = method4.getName();
            if (!Modifier.isStatic(method4.getModifiers())) {
                Class<?> returnType = method4.getReturnType();
                if ((returnType.equals(Void.TYPE) || returnType.equals(method4.getDeclaringClass())) && method4.getDeclaringClass() != Object.class) {
                    Class<?>[] parameterTypes4 = method4.getParameterTypes();
                    if (parameterTypes4.length != 0 && parameterTypes4.length <= 2) {
                        JSONField jSONField8 = (JSONField) method4.getAnnotation(JSONField.class);
                        if (jSONField8 != null && parameterTypes4.length == 2 && parameterTypes4[0] == String.class && parameterTypes4[1] == Object.class) {
                            add(arrayList, new FieldInfo("", method4, null, cls, type, 0, 0, 0, jSONField8, null, null));
                        } else if (parameterTypes4.length == 1) {
                            if (jSONField8 == null) {
                                jSONField8 = TypeUtils.getSuperMethodAnnotation(cls, method4);
                            }
                            if (jSONField8 != null || name4.length() >= 4) {
                                if (jSONField8 != null) {
                                    if (jSONField8.deserialize()) {
                                        i19 = jSONField8.ordinal();
                                        i20 = SerializerFeature.of(jSONField8.serialzeFeatures());
                                        i21 = Feature.of(jSONField8.parseFeatures());
                                        if (jSONField8.name().length() != 0) {
                                            add(arrayList, new FieldInfo(jSONField8.name(), method4, null, cls, type, i19, i20, i21, jSONField8, null, null));
                                        }
                                    }
                                }
                                if (jSONField8 != null || name4.startsWith("set")) {
                                    char charAt2 = name4.charAt(3);
                                    if (Character.isUpperCase(charAt2) || charAt2 > 512) {
                                        if (TypeUtils.compatibleWithJavaBean) {
                                            str2 = TypeUtils.decapitalize(name4.substring(3));
                                        } else {
                                            str2 = Character.toLowerCase(name4.charAt(3)) + name4.substring(4);
                                        }
                                    } else if (charAt2 == '_') {
                                        str2 = name4.substring(4);
                                    } else if (charAt2 == 'f') {
                                        str2 = name4.substring(3);
                                    } else if (name4.length() >= 5 && Character.isUpperCase(name4.charAt(4))) {
                                        str2 = TypeUtils.decapitalize(name4.substring(3));
                                    }
                                    Field field2 = TypeUtils.getField(cls, str2, declaredFields);
                                    if (field2 == null && parameterTypes4[0] == Boolean.TYPE) {
                                        field2 = TypeUtils.getField(cls, "is" + Character.toUpperCase(str2.charAt(0)) + str2.substring(1), declaredFields);
                                    }
                                    JSONField jSONField9 = null;
                                    if (field2 != null && (jSONField9 = (JSONField) field2.getAnnotation(JSONField.class)) != null) {
                                        if (jSONField9.deserialize()) {
                                            i19 = jSONField9.ordinal();
                                            i20 = SerializerFeature.of(jSONField9.serialzeFeatures());
                                            i21 = Feature.of(jSONField9.parseFeatures());
                                            if (jSONField9.name().length() != 0) {
                                                add(arrayList, new FieldInfo(jSONField9.name(), method4, field2, cls, type, i19, i20, i21, jSONField8, jSONField9, null));
                                            }
                                        }
                                    }
                                    add(arrayList, new FieldInfo(propertyNamingStrategy != null ? propertyNamingStrategy.translate(str2) : str2, method4, field2, cls, type, i19, i20, i21, jSONField8, jSONField9, null));
                                }
                            }
                        }
                    }
                }
            }
            i17 = i18 + 1;
        }
        computeFields(cls, type, propertyNamingStrategy, arrayList, cls.getFields());
        Method[] methods3 = cls.getMethods();
        int length7 = methods3.length;
        int i22 = 0;
        while (true) {
            int i23 = i22;
            if (i23 < length7) {
                Method method5 = methods3[i23];
                String name5 = method5.getName();
                if (name5.length() >= 4 && !Modifier.isStatic(method5.getModifiers()) && builderClass == null && name5.startsWith("get") && Character.isUpperCase(name5.charAt(3)) && method5.getParameterTypes().length == 0 && ((Collection.class.isAssignableFrom(method5.getReturnType()) || Map.class.isAssignableFrom(method5.getReturnType()) || AtomicBoolean.class == method5.getReturnType() || AtomicInteger.class == method5.getReturnType() || AtomicLong.class == method5.getReturnType()) && ((jSONField = (JSONField) method5.getAnnotation(JSONField.class)) == null || !jSONField.deserialize()))) {
                    if (jSONField != null && jSONField.name().length() > 0) {
                        str = jSONField.name();
                    } else {
                        String str7 = Character.toLowerCase(name5.charAt(3)) + name5.substring(4);
                        Field field3 = TypeUtils.getField(cls, str7, declaredFields);
                        if (field3 == null || (jSONField2 = (JSONField) field3.getAnnotation(JSONField.class)) == null || jSONField2.deserialize()) {
                            str = str7;
                        }
                    }
                    if (getField(arrayList, str) == null) {
                        add(arrayList, new FieldInfo(propertyNamingStrategy != null ? propertyNamingStrategy.translate(str) : str, method5, null, cls, type, 0, 0, 0, jSONField, null, null));
                    }
                }
                i22 = i23 + 1;
            } else {
                return new JavaBeanInfo(cls, builderClass, constructor2, constructor3, method2, method, jSONType, arrayList);
            }
        }
    }

    private static void computeFields(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, List<FieldInfo> list, Field[] fieldArr) {
        boolean z;
        for (Field field : fieldArr) {
            int modifiers = field.getModifiers();
            if ((modifiers & 8) == 0) {
                if ((modifiers & 16) != 0) {
                    Class<?> type2 = field.getType();
                    if (!(Map.class.isAssignableFrom(type2) || Collection.class.isAssignableFrom(type2) || AtomicLong.class.equals(type2) || AtomicInteger.class.equals(type2) || AtomicBoolean.class.equals(type2))) {
                    }
                }
                Iterator<FieldInfo> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next().name.equals(field.getName())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    String name = field.getName();
                    JSONField jSONField = (JSONField) field.getAnnotation(JSONField.class);
                    if (jSONField != null) {
                        if (jSONField.deserialize()) {
                            i = jSONField.ordinal();
                            i2 = SerializerFeature.of(jSONField.serialzeFeatures());
                            i3 = Feature.of(jSONField.parseFeatures());
                            if (jSONField.name().length() != 0) {
                                name = jSONField.name();
                            }
                        }
                    }
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    add(list, new FieldInfo(name, null, field, cls, type, i, i2, i3, null, jSONField, null));
                }
            }
        }
    }

    static Constructor<?> getDefaultConstructor(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        int length = constructorArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                constructor = null;
                break;
            }
            constructor = constructorArr[i];
            if (constructor.getParameterTypes().length == 0) {
                break;
            }
            i++;
        }
        if (constructor == null && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            for (Constructor<?> constructor2 : constructorArr) {
                Class<?>[] parameterTypes = constructor2.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                    return constructor2;
                }
            }
        }
        return constructor;
    }

    public static Constructor<?> getCreatorConstructor(Constructor[] constructorArr) {
        boolean z;
        boolean z2;
        Constructor constructor;
        Constructor constructor2 = null;
        int length = constructorArr.length;
        int i = 0;
        while (i < length) {
            Constructor constructor3 = constructorArr[i];
            if (((JSONCreator) constructor3.getAnnotation(JSONCreator.class)) == null) {
                constructor = constructor2;
            } else if (constructor2 != null) {
                throw new JSONException("multi-JSONCreator");
            } else {
                constructor = constructor3;
            }
            i++;
            constructor2 = constructor;
        }
        if (constructor2 != null) {
            return constructor2;
        }
        Constructor constructor4 = constructor2;
        for (Constructor constructor5 : constructorArr) {
            Annotation[][] parameterAnnotations = constructor5.getParameterAnnotations();
            if (parameterAnnotations.length != 0) {
                int length2 = parameterAnnotations.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        z = true;
                        break;
                    }
                    Annotation[] annotationArr = parameterAnnotations[i2];
                    int length3 = annotationArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length3) {
                            z2 = false;
                            break;
                        } else if (annotationArr[i3] instanceof JSONField) {
                            z2 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z2) {
                        z = false;
                        break;
                    }
                    i2++;
                }
                if (!z) {
                    continue;
                } else if (constructor4 != null) {
                    throw new JSONException("multi-JSONCreator");
                } else {
                    constructor4 = constructor5;
                }
            }
        }
        if (constructor4 != null) {
        }
        return constructor4;
    }

    private static Method getFactoryMethod(Class<?> cls, Method[] methodArr) {
        Method method;
        Method method2 = null;
        int length = methodArr.length;
        int i = 0;
        while (i < length) {
            Method method3 = methodArr[i];
            if (!Modifier.isStatic(method3.getModifiers())) {
                method = method2;
            } else if (!cls.isAssignableFrom(method3.getReturnType())) {
                method = method2;
            } else if (((JSONCreator) method3.getAnnotation(JSONCreator.class)) == null) {
                method = method2;
            } else if (method2 != null) {
                throw new JSONException("multi-JSONCreator");
            } else {
                method = method3;
            }
            i++;
            method2 = method;
        }
        return method2;
    }

    public static Class<?> getBuilderClass(JSONType jSONType) {
        return getBuilderClass(null, jSONType);
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
