package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* loaded from: classes4.dex */
public class FieldInfo implements Comparable<FieldInfo> {
    public final String[] alternateNames;
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    private final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final boolean jsonDirect;
    public final String label;
    public final Method method;
    private final JSONField methodAnnotation;
    public final String name;
    public final char[] name_chars;
    private int ordinal;
    public final int parserFeatures;
    public final int serialzeFeatures;
    public final boolean unwrapped;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i, int i2, int i3) {
        this.ordinal = 0;
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        this.parserFeatures = i3;
        this.isEnum = cls2.isEnum();
        if (field != null) {
            int modifiers = field.getModifiers();
            this.fieldAccess = (modifiers & 1) != 0 || this.method == null;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldTransient = false;
            this.fieldAccess = false;
        }
        this.name_chars = genFieldNameChars();
        if (field != null) {
            TypeUtils.setAccessible(field);
        }
        this.label = "";
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        this.getOnly = false;
        this.jsonDirect = false;
        this.unwrapped = false;
        this.format = null;
        this.alternateNames = new String[0];
    }

    public FieldInfo(String str, Method method, Field field, Class<?> cls, Type type, int i, int i2, int i3, JSONField jSONField, JSONField jSONField2, String str2) {
        boolean z;
        String str3;
        Type genericType;
        Class<?> cls2;
        Type inheritGenericType;
        Class<?> returnType;
        Type genericReturnType;
        this.ordinal = 0;
        if (field != null) {
            String name = field.getName();
            if (name.equals(str)) {
                str = name;
            }
        }
        this.name = str;
        this.method = method;
        this.field = field;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        this.parserFeatures = i3;
        this.fieldAnnotation = jSONField;
        this.methodAnnotation = jSONField2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.fieldAccess = (modifiers & 1) != 0 || method == null;
            this.fieldTransient = Modifier.isTransient(modifiers) || TypeUtils.isTransient(method);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = false;
        }
        if (str2 != null && str2.length() > 0) {
            this.label = str2;
        } else {
            this.label = "";
        }
        JSONField annotation = getAnnotation();
        if (annotation != null) {
            String format = annotation.format();
            format = format.trim().length() == 0 ? null : format;
            boolean jsonDirect = annotation.jsonDirect();
            this.unwrapped = annotation.unwrapped();
            this.alternateNames = annotation.alternateNames();
            z = jsonDirect;
            str3 = format;
        } else {
            this.unwrapped = false;
            this.alternateNames = new String[0];
            z = false;
            str3 = null;
        }
        this.format = str3;
        this.name_chars = genFieldNameChars();
        if (method != null) {
            TypeUtils.setAccessible(method);
        }
        if (field != null) {
            TypeUtils.setAccessible(field);
        }
        boolean z2 = false;
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                returnType = parameterTypes[0];
                genericReturnType = method.getGenericParameterTypes()[0];
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Object.class) {
                Class<?> cls3 = parameterTypes[0];
                returnType = cls3;
                genericReturnType = cls3;
            } else {
                returnType = method.getReturnType();
                z2 = true;
                genericReturnType = method.getGenericReturnType();
            }
            this.declaringClass = method.getDeclaringClass();
            cls2 = returnType;
            genericType = genericReturnType;
        } else {
            Class<?> type2 = field.getType();
            genericType = field.getGenericType();
            this.declaringClass = field.getDeclaringClass();
            z2 = Modifier.isFinal(field.getModifiers());
            cls2 = type2;
        }
        this.getOnly = z2;
        this.jsonDirect = z && cls2 == String.class;
        if (cls != null && cls2 == Object.class && (genericType instanceof TypeVariable) && (inheritGenericType = getInheritGenericType(cls, type, (TypeVariable) genericType)) != null) {
            this.fieldClass = TypeUtils.getClass(inheritGenericType);
            this.fieldType = inheritGenericType;
            this.isEnum = cls2.isEnum();
            return;
        }
        if (!(genericType instanceof Class)) {
            Type fieldType = getFieldType(cls, type == null ? cls : type, genericType);
            if (fieldType != genericType) {
                if (fieldType instanceof ParameterizedType) {
                    cls2 = TypeUtils.getClass(fieldType);
                    genericType = fieldType;
                } else if (fieldType instanceof Class) {
                    cls2 = TypeUtils.getClass(fieldType);
                    genericType = fieldType;
                }
            }
            genericType = fieldType;
        }
        this.fieldType = genericType;
        this.fieldClass = cls2;
        this.isEnum = cls2.isEnum();
    }

    protected char[] genFieldNameChars() {
        int length = this.name.length();
        char[] cArr = new char[length + 3];
        this.name.getChars(0, this.name.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    public <T extends Annotation> T getAnnation(Class<T> cls) {
        if (cls == JSONField.class) {
            return getAnnotation();
        }
        T t = null;
        if (this.method != null) {
            t = (T) this.method.getAnnotation(cls);
        }
        return (t != null || this.field == null) ? t : (T) this.field.getAnnotation(cls);
    }

    public static Type getFieldType(Class<?> cls, Type type, Type type2) {
        ParameterizedType parameterizedType;
        TypeVariable<Class<?>>[] typeParameters;
        if (cls != null && type != null) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type fieldType = getFieldType(cls, type, genericComponentType);
                if (genericComponentType != fieldType) {
                    return Array.newInstance(TypeUtils.getClass(fieldType), 0).getClass();
                }
                return type2;
            } else if (TypeUtils.isGenericParamType(type)) {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.getGenericParamType(type);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    TypeVariable<Class<?>>[] typeParameters2 = TypeUtils.getClass(parameterizedType2).getTypeParameters();
                    for (int i = 0; i < typeParameters2.length; i++) {
                        if (typeParameters2[i].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeParameters = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        typeParameters = cls.getSuperclass().getTypeParameters();
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                    } else {
                        parameterizedType = parameterizedType3;
                        typeParameters = type.getClass().getTypeParameters();
                    }
                    if (getArgument(actualTypeArguments, typeParameters, parameterizedType.getActualTypeArguments())) {
                        return new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                    }
                    return type2;
                }
                return type2;
            } else {
                return type2;
            }
        }
        return type2;
    }

    private static boolean getArgument(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            Type type = typeArr[i];
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (getArgument(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i] = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType());
                    z = true;
                }
            } else if (type instanceof TypeVariable) {
                boolean z2 = z;
                for (int i2 = 0; i2 < typeVariableArr.length; i2++) {
                    if (type.equals(typeVariableArr[i2])) {
                        typeArr[i] = typeArr2[i2];
                        z2 = true;
                    }
                }
                z = z2;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Type getInheritGenericType(Class<?> cls, Type type, TypeVariable<?> typeVariable) {
        Type[] typeArr;
        Type[] typeArr2;
        Type type2;
        Class<?> cls2 = typeVariable.getGenericDeclaration() instanceof Class ? (Class) typeVariable.getGenericDeclaration() : null;
        if (cls2 == cls) {
            typeArr = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
        } else {
            typeArr = null;
            while (cls != null && cls != Object.class && cls != cls2) {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    typeArr2 = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    getArgument(typeArr2, cls.getTypeParameters(), typeArr);
                } else {
                    typeArr2 = typeArr;
                }
                cls = cls.getSuperclass();
                typeArr = typeArr2;
            }
        }
        TypeVariable<Class<?>>[] typeParameters = cls2.getTypeParameters();
        int i = 0;
        while (true) {
            if (i >= typeParameters.length) {
                type2 = null;
                break;
            } else if (!typeVariable.equals(typeParameters[i])) {
                i++;
            } else {
                type2 = typeArr[i];
                break;
            }
        }
        return type2;
    }

    public String toString() {
        return this.name;
    }

    public Member getMember() {
        return this.method != null ? this.method : this.field;
    }

    protected Class<?> getDeclaredClass() {
        if (this.method != null) {
            return this.method.getDeclaringClass();
        }
        if (this.field != null) {
            return this.field.getDeclaringClass();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(FieldInfo fieldInfo) {
        boolean z = false;
        if (this.ordinal < fieldInfo.ordinal) {
            return -1;
        }
        if (this.ordinal <= fieldInfo.ordinal) {
            int compareTo = this.name.compareTo(fieldInfo.name);
            if (compareTo != 0) {
                return compareTo;
            }
            Class<?> declaredClass = getDeclaredClass();
            Class<?> declaredClass2 = fieldInfo.getDeclaredClass();
            if (declaredClass != null && declaredClass2 != null && declaredClass != declaredClass2) {
                if (declaredClass.isAssignableFrom(declaredClass2)) {
                    return -1;
                }
                if (declaredClass2.isAssignableFrom(declaredClass)) {
                    return 1;
                }
            }
            boolean z2 = this.field != null && this.field.getType() == this.fieldClass;
            if (fieldInfo.field != null && fieldInfo.field.getType() == fieldInfo.fieldClass) {
                z = true;
            }
            if (!z2 || z) {
                if (!z || z2) {
                    if (!fieldInfo.fieldClass.isPrimitive() || this.fieldClass.isPrimitive()) {
                        if (!this.fieldClass.isPrimitive() || fieldInfo.fieldClass.isPrimitive()) {
                            if (!fieldInfo.fieldClass.getName().startsWith("java.") || this.fieldClass.getName().startsWith("java.")) {
                                if (!this.fieldClass.getName().startsWith("java.") || fieldInfo.fieldClass.getName().startsWith("java.")) {
                                    return this.fieldClass.getName().compareTo(fieldInfo.fieldClass.getName());
                                }
                                return -1;
                            }
                            return 1;
                        }
                        return -1;
                    }
                    return 1;
                }
                return -1;
            }
            return 1;
        }
        return 1;
    }

    public JSONField getAnnotation() {
        return this.fieldAnnotation != null ? this.fieldAnnotation : this.methodAnnotation;
    }

    public String getFormat() {
        return this.format;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        if (this.method != null) {
            return this.method.invoke(obj, new Object[0]);
        }
        return this.field.get(obj);
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        if (this.method != null) {
            this.method.invoke(obj, obj2);
        } else {
            this.field.set(obj, obj2);
        }
    }

    public void setAccessible() throws SecurityException {
        if (this.method != null) {
            TypeUtils.setAccessible(this.method);
        } else {
            TypeUtils.setAccessible(this.field);
        }
    }
}
