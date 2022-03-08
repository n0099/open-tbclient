package com.alibaba.fastjson.util;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import java.util.Map;
/* loaded from: classes3.dex */
public class FieldInfo implements Comparable<FieldInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String[] alternateNames;
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    public final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final boolean jsonDirect;
    public final String label;
    public final Method method;
    public final JSONField methodAnnotation;
    public final String name;
    public final long nameHashCode;
    public final char[] name_chars;
    public int ordinal;
    public final int parserFeatures;
    public final int serialzeFeatures;
    public final boolean unwrapped;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cls, cls2, type, field, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ordinal = 0;
        i2 = i2 < 0 ? 0 : i2;
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field;
        this.ordinal = i2;
        this.serialzeFeatures = i3;
        this.parserFeatures = i4;
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
        JSONField jSONField = field == null ? null : (JSONField) TypeUtils.getAnnotation(field, JSONField.class);
        this.fieldAnnotation = jSONField;
        this.methodAnnotation = null;
        this.getOnly = false;
        this.jsonDirect = false;
        this.unwrapped = false;
        this.format = null;
        this.alternateNames = new String[0];
        this.nameHashCode = nameHashCode64(str, jSONField);
    }

    public static boolean getArgument(Type[] typeArr, Map<TypeVariable, Type> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, typeArr, map)) == null) {
            if (map == null || map.size() == 0) {
                return false;
            }
            boolean z = false;
            for (int i2 = 0; i2 < typeArr.length; i2++) {
                Type type = typeArr[i2];
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    if (getArgument(actualTypeArguments, map)) {
                        typeArr[i2] = TypeReference.intern(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                        z = true;
                    }
                } else {
                    if ((type instanceof TypeVariable) && map.containsKey(type)) {
                        typeArr[i2] = map.get(type);
                        z = true;
                    }
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static Type getFieldType(Class<?> cls, Type type, Type type2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, cls, type, type2)) == null) ? getFieldType(cls, type, type2, null) : (Type) invokeLLL.objValue;
    }

    public static Type getInheritGenericType(Class<?> cls, Type type, TypeVariable<?> typeVariable) {
        InterceptResult invokeLLL;
        Type[] typeArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, cls, type, typeVariable)) == null) {
            Class<?> cls2 = typeVariable.getGenericDeclaration() instanceof Class ? (Class) typeVariable.getGenericDeclaration() : null;
            if (cls2 == cls) {
                typeArr = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
            } else {
                Type[] typeArr2 = null;
                while (cls != null && cls != Object.class && cls != cls2) {
                    Type genericSuperclass = cls.getGenericSuperclass();
                    if (genericSuperclass instanceof ParameterizedType) {
                        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                        getArgument(actualTypeArguments, cls.getTypeParameters(), typeArr2);
                        typeArr2 = actualTypeArguments;
                    }
                    cls = cls.getSuperclass();
                }
                typeArr = typeArr2;
            }
            if (typeArr == null || cls2 == null) {
                return null;
            }
            TypeVariable<Class<?>>[] typeParameters = cls2.getTypeParameters();
            for (int i2 = 0; i2 < typeParameters.length; i2++) {
                if (typeVariable.equals(typeParameters[i2])) {
                    return typeArr[i2];
                }
            }
            return null;
        }
        return (Type) invokeLLL.objValue;
    }

    private long nameHashCode64(String str, JSONField jSONField) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, jSONField)) == null) {
            if (jSONField != null && jSONField.name().length() != 0) {
                return TypeUtils.fnv1a_64_lower(str);
            }
            return TypeUtils.fnv1a_64_extract(str);
        }
        return invokeLL.longValue;
    }

    public char[] genFieldNameChars() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int length = this.name.length();
            char[] cArr = new char[length + 3];
            String str = this.name;
            str.getChars(0, str.length(), cArr, 1);
            cArr[0] = '\"';
            cArr[length + 1] = '\"';
            cArr[length + 2] = ':';
            return cArr;
        }
        return (char[]) invokeV.objValue;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            Method method = this.method;
            if (method != null) {
                return method.invoke(obj, new Object[0]);
            }
            return this.field.get(obj);
        }
        return invokeL.objValue;
    }

    public <T extends Annotation> T getAnnation(Class<T> cls) {
        InterceptResult invokeL;
        Field field;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) {
            if (cls == JSONField.class) {
                return getAnnotation();
            }
            T t = null;
            Method method = this.method;
            if (method != null) {
                t = (T) TypeUtils.getAnnotation(method, cls);
            }
            return (t != null || (field = this.field) == null) ? t : (T) TypeUtils.getAnnotation(field, cls);
        }
        return (T) invokeL.objValue;
    }

    public JSONField getAnnotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONField jSONField = this.fieldAnnotation;
            return jSONField != null ? jSONField : this.methodAnnotation;
        }
        return (JSONField) invokeV.objValue;
    }

    public Class<?> getDeclaredClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Method method = this.method;
            if (method != null) {
                return method.getDeclaringClass();
            }
            Field field = this.field;
            if (field != null) {
                return field.getDeclaringClass();
            }
            return null;
        }
        return (Class) invokeV.objValue;
    }

    public String getFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.format : (String) invokeV.objValue;
    }

    public Member getMember() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Method method = this.method;
            return method != null ? method : this.field;
        }
        return (Member) invokeV.objValue;
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, obj, obj2) == null) {
            Method method = this.method;
            if (method != null) {
                method.invoke(obj, obj2);
            } else {
                this.field.set(obj, obj2);
            }
        }
    }

    public void setAccessible() throws SecurityException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Method method = this.method;
            if (method != null) {
                TypeUtils.setAccessible(method);
            } else {
                TypeUtils.setAccessible(this.field);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public static Type getFieldType(Class<?> cls, Type type, Type type2, Map<TypeVariable, Type> map) {
        InterceptResult invokeLLLL;
        TypeVariable<Class<?>>[] typeParameters;
        ParameterizedType parameterizedType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, cls, type, type2, map)) == null) {
            if (cls != null && type != null) {
                if (type2 instanceof GenericArrayType) {
                    Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                    Type fieldType = getFieldType(cls, type, genericComponentType, map);
                    return genericComponentType != fieldType ? Array.newInstance(TypeUtils.getClass(fieldType), 0).getClass() : type2;
                } else if (!TypeUtils.isGenericParamType(type)) {
                    return type2;
                } else {
                    if (type2 instanceof TypeVariable) {
                        ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.getGenericParamType(type);
                        TypeVariable typeVariable = (TypeVariable) type2;
                        TypeVariable<Class<?>>[] typeParameters2 = TypeUtils.getClass(parameterizedType2).getTypeParameters();
                        for (int i2 = 0; i2 < typeParameters2.length; i2++) {
                            if (typeParameters2[i2].getName().equals(typeVariable.getName())) {
                                return parameterizedType2.getActualTypeArguments()[i2];
                            }
                        }
                    }
                    if (type2 instanceof ParameterizedType) {
                        ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                        Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                        boolean argument = getArgument(actualTypeArguments, map);
                        if (!argument) {
                            if (type instanceof ParameterizedType) {
                                parameterizedType = (ParameterizedType) type;
                                typeParameters = cls.getTypeParameters();
                            } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                                parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                                typeParameters = cls.getSuperclass().getTypeParameters();
                            } else {
                                typeParameters = type.getClass().getTypeParameters();
                                parameterizedType = parameterizedType3;
                            }
                            argument = getArgument(actualTypeArguments, typeParameters, parameterizedType.getActualTypeArguments());
                        }
                        if (argument) {
                            return TypeReference.intern(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType()));
                        }
                    }
                }
            }
            return type2;
        }
        return (Type) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(FieldInfo fieldInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fieldInfo)) == null) {
            Method method = fieldInfo.method;
            if (method == null || this.method == null || !method.isBridge() || this.method.isBridge() || !fieldInfo.method.getName().equals(this.method.getName())) {
                int i2 = this.ordinal;
                int i3 = fieldInfo.ordinal;
                if (i2 < i3) {
                    return -1;
                }
                if (i2 > i3) {
                    return 1;
                }
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
                Field field = this.field;
                boolean z = false;
                boolean z2 = field != null && field.getType() == this.fieldClass;
                Field field2 = fieldInfo.field;
                if (field2 != null && field2.getType() == fieldInfo.fieldClass) {
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
        return invokeL.intValue;
    }

    public static boolean getArgument(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, typeArr, typeVariableArr, typeArr2)) == null) {
            if (typeArr2 == null || typeVariableArr.length == 0) {
                return false;
            }
            boolean z = false;
            for (int i2 = 0; i2 < typeArr.length; i2++) {
                Type type = typeArr[i2];
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    if (getArgument(actualTypeArguments, typeVariableArr, typeArr2)) {
                        typeArr[i2] = TypeReference.intern(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType.getOwnerType(), parameterizedType.getRawType()));
                        z = true;
                    }
                } else if (type instanceof TypeVariable) {
                    for (int i3 = 0; i3 < typeVariableArr.length; i3++) {
                        if (type.equals(typeVariableArr[i3])) {
                            typeArr[i2] = typeArr2[i3];
                            z = true;
                        }
                    }
                }
            }
            return z;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FieldInfo(String str, Method method, Field field, Class<?> cls, Type type, int i2, int i3, int i4, JSONField jSONField, JSONField jSONField2, String str2) {
        this(str, method, field, cls, type, i2, i3, i4, jSONField, jSONField2, str2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, method, field, cls, type, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), jSONField, jSONField2, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Method) objArr2[1], (Field) objArr2[2], (Class) objArr2[3], (Type) objArr2[4], ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue(), ((Integer) objArr2[7]).intValue(), (JSONField) objArr2[8], (JSONField) objArr2[9], (String) objArr2[10], (Map) objArr2[11]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r9.equals(r14) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FieldInfo(String str, Method method, Field field, Class<?> cls, Type type, int i2, int i3, int i4, JSONField jSONField, JSONField jSONField2, String str2, Map<TypeVariable, Type> map) {
        String str3;
        String str4;
        boolean z;
        Type genericType;
        boolean isFinal;
        Class<?> cls2;
        Type inheritGenericType;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, method, field, cls, type, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), jSONField, jSONField2, str2, map};
            interceptable.invokeUnInit(65538, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Type type2 = type;
        boolean z2 = false;
        this.ordinal = 0;
        if (field != null) {
            str4 = field.getName();
            str3 = str;
        } else {
            str3 = str;
        }
        str4 = str3;
        int i7 = i2 < 0 ? 0 : i2;
        this.name = str4;
        this.method = method;
        this.field = field;
        this.ordinal = i7;
        this.serialzeFeatures = i3;
        this.parserFeatures = i4;
        this.fieldAnnotation = jSONField;
        this.methodAnnotation = jSONField2;
        if (field != null) {
            int modifiers = field.getModifiers();
            this.fieldAccess = (modifiers & 1) != 0 || method == null;
            this.fieldTransient = Modifier.isTransient(modifiers) || TypeUtils.isTransient(method);
        } else {
            this.fieldAccess = false;
            this.fieldTransient = TypeUtils.isTransient(method);
        }
        if (str2 != null && str2.length() > 0) {
            this.label = str2;
        } else {
            this.label = "";
        }
        JSONField annotation = getAnnotation();
        this.nameHashCode = nameHashCode64(str4, annotation);
        if (annotation != null) {
            String format = annotation.format();
            r9 = format.trim().length() != 0 ? format : null;
            z = annotation.jsonDirect();
            this.unwrapped = annotation.unwrapped();
            this.alternateNames = annotation.alternateNames();
        } else {
            this.unwrapped = false;
            this.alternateNames = new String[0];
            z = false;
        }
        this.format = r9;
        this.name_chars = genFieldNameChars();
        if (method != null) {
            TypeUtils.setAccessible(method);
        }
        if (field != null) {
            TypeUtils.setAccessible(field);
        }
        if (method != null) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1) {
                cls2 = parameterTypes[0];
                genericType = method.getGenericParameterTypes()[0];
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Object.class) {
                cls2 = parameterTypes[0];
                genericType = cls2;
            } else {
                cls2 = method.getReturnType();
                genericType = method.getGenericReturnType();
                isFinal = true;
                this.declaringClass = method.getDeclaringClass();
            }
            isFinal = false;
            this.declaringClass = method.getDeclaringClass();
        } else {
            Class<?> type3 = field.getType();
            genericType = field.getGenericType();
            this.declaringClass = field.getDeclaringClass();
            isFinal = Modifier.isFinal(field.getModifiers());
            cls2 = type3;
        }
        this.getOnly = isFinal;
        if (z && cls2 == String.class) {
            z2 = true;
        }
        this.jsonDirect = z2;
        if (cls != null && cls2 == Object.class && (genericType instanceof TypeVariable) && (inheritGenericType = getInheritGenericType(cls, type2, (TypeVariable) genericType)) != null) {
            this.fieldClass = TypeUtils.getClass(inheritGenericType);
            this.fieldType = inheritGenericType;
            this.isEnum = cls2.isEnum();
            return;
        }
        if (!(genericType instanceof Class)) {
            Type fieldType = getFieldType(cls, type2 == null ? cls : type2, genericType, map);
            if (fieldType != genericType) {
                if (fieldType instanceof ParameterizedType) {
                    cls2 = TypeUtils.getClass(fieldType);
                } else if (fieldType instanceof Class) {
                    cls2 = TypeUtils.getClass(fieldType);
                }
            }
            genericType = fieldType;
        }
        this.fieldType = genericType;
        this.fieldClass = cls2;
        this.isEnum = cls2.isEnum();
    }
}
