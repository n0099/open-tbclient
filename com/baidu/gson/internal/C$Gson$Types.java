package com.baidu.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
/* renamed from: com.baidu.gson.internal.$Gson$Types  reason: invalid class name */
/* loaded from: classes.dex */
public final class C$Gson$Types {
    static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    private C$Gson$Types() {
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        return new ParameterizedTypeImpl(type, type2, typeArr);
    }

    public static GenericArrayType arrayOf(Type type) {
        return new GenericArrayTypeImpl(type);
    }

    public static WildcardType subtypeOf(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, EMPTY_TYPE_ARRAY);
    }

    public static WildcardType supertypeOf(Type type) {
        return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{type});
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new GenericArrayTypeImpl(canonicalize(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
            }
            return type;
        }
    }

    public static Class<?> getRawType(Type type) {
        Type type2 = type;
        while (!(type2 instanceof Class)) {
            if (type2 instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type2).getRawType();
                C$Gson$Preconditions.checkArgument(rawType instanceof Class);
                return (Class) rawType;
            } else if (type2 instanceof GenericArrayType) {
                return Array.newInstance(getRawType(((GenericArrayType) type2).getGenericComponentType()), 0).getClass();
            } else {
                if (type2 instanceof TypeVariable) {
                    return Object.class;
                }
                if (type2 instanceof WildcardType) {
                    type2 = ((WildcardType) type2).getUpperBounds()[0];
                } else {
                    throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type2 + "> is of type " + (type2 == null ? "null" : type2.getClass().getName()));
                }
            }
        }
        return (Class) type2;
    }

    static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean equals(Type type, Type type2) {
        Type type3 = type;
        for (Type type4 = type2; type3 != type4; type4 = ((GenericArrayType) type4).getGenericComponentType()) {
            if (type3 instanceof Class) {
                return type3.equals(type4);
            }
            if (type3 instanceof ParameterizedType) {
                if (type4 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type3;
                    ParameterizedType parameterizedType2 = (ParameterizedType) type4;
                    return equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
                }
                return false;
            } else if (type3 instanceof GenericArrayType) {
                if (!(type4 instanceof GenericArrayType)) {
                    return false;
                }
                type3 = ((GenericArrayType) type3).getGenericComponentType();
            } else if (type3 instanceof WildcardType) {
                if (type4 instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type3;
                    WildcardType wildcardType2 = (WildcardType) type4;
                    return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
                }
                return false;
            } else {
                if ((type3 instanceof TypeVariable) && (type4 instanceof TypeVariable)) {
                    TypeVariable typeVariable = (TypeVariable) type3;
                    TypeVariable typeVariable2 = (TypeVariable) type4;
                    return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashCodeOrZero(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
        Class<? super Object> cls3 = cls;
        Type type2 = type;
        while (cls2 != cls3) {
            if (cls2.isInterface()) {
                Class<?>[] interfaces = cls3.getInterfaces();
                int length = interfaces.length;
                for (int i = 0; i < length; i++) {
                    if (interfaces[i] == cls2) {
                        return cls3.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(interfaces[i])) {
                        Type type3 = cls3.getGenericInterfaces()[i];
                        cls3 = interfaces[i];
                        type2 = type3;
                        break;
                    }
                }
            }
            if (!cls3.isInterface()) {
                while (cls3 != Object.class) {
                    Class<? super Object> superclass = cls3.getSuperclass();
                    if (superclass == cls2) {
                        return cls3.getGenericSuperclass();
                    }
                    if (cls2.isAssignableFrom(superclass)) {
                        Type genericSuperclass = cls3.getGenericSuperclass();
                        cls3 = superclass;
                        type2 = genericSuperclass;
                    } else {
                        cls3 = superclass;
                    }
                }
                return cls2;
            }
            return cls2;
        }
        return type2;
    }

    static Type getSupertype(Type type, Class<?> cls, Class<?> cls2) {
        C$Gson$Preconditions.checkArgument(cls2.isAssignableFrom(cls));
        return resolve(type, cls, getGenericSupertype(type, cls, cls2));
    }

    public static Type getArrayComponentType(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type getCollectionElementType(Type type, Class<?> cls) {
        Type supertype = getSupertype(type, cls, Collection.class);
        if (supertype instanceof WildcardType) {
            supertype = ((WildcardType) supertype).getUpperBounds()[0];
        }
        return supertype instanceof ParameterizedType ? ((ParameterizedType) supertype).getActualTypeArguments()[0] : Object.class;
    }

    public static Type[] getMapKeyAndValueTypes(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type supertype = getSupertype(type, cls, Map.class);
        return supertype instanceof ParameterizedType ? ((ParameterizedType) supertype).getActualTypeArguments() : new Type[]{Object.class, Object.class};
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        Type resolve;
        while (true) {
            Type type3 = type2;
            if (type3 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type3;
                type2 = resolveTypeVariable(type, cls, typeVariable);
                if (type2 == typeVariable) {
                    return type2;
                }
            } else if ((type3 instanceof Class) && ((Class) type3).isArray()) {
                Class cls2 = (Class) type3;
                Class<?> componentType = cls2.getComponentType();
                Type resolve2 = resolve(type, cls, componentType);
                if (componentType != resolve2) {
                    return arrayOf(resolve2);
                }
                return cls2;
            } else if (type3 instanceof GenericArrayType) {
                GenericArrayType genericArrayType = (GenericArrayType) type3;
                Type genericComponentType = genericArrayType.getGenericComponentType();
                Type resolve3 = resolve(type, cls, genericComponentType);
                if (genericComponentType != resolve3) {
                    return arrayOf(resolve3);
                }
                return genericArrayType;
            } else if (type3 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type3;
                Type ownerType = parameterizedType.getOwnerType();
                Type resolve4 = resolve(type, cls, ownerType);
                boolean z = resolve4 != ownerType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments.length;
                Type[] typeArr = actualTypeArguments;
                for (int i = 0; i < length; i++) {
                    Type resolve5 = resolve(type, cls, typeArr[i]);
                    if (resolve5 != typeArr[i]) {
                        if (!z) {
                            typeArr = (Type[]) typeArr.clone();
                            z = true;
                        }
                        typeArr[i] = resolve5;
                    }
                }
                if (z) {
                    return newParameterizedTypeWithOwner(resolve4, parameterizedType.getRawType(), typeArr);
                }
                return parameterizedType;
            } else if (type3 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type3;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] upperBounds = wildcardType.getUpperBounds();
                if (lowerBounds.length == 1) {
                    Type resolve6 = resolve(type, cls, lowerBounds[0]);
                    if (resolve6 != lowerBounds[0]) {
                        return supertypeOf(resolve6);
                    }
                    return wildcardType;
                } else if (upperBounds.length == 1 && (resolve = resolve(type, cls, upperBounds[0])) != upperBounds[0]) {
                    return subtypeOf(resolve);
                } else {
                    return wildcardType;
                }
            } else {
                return type3;
            }
        }
    }

    static Type resolveTypeVariable(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> declaringClassOf = declaringClassOf(typeVariable);
        if (declaringClassOf != null) {
            Type genericSupertype = getGenericSupertype(type, cls, declaringClassOf);
            if (genericSupertype instanceof ParameterizedType) {
                return ((ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(declaringClassOf.getTypeParameters(), typeVariable)];
            }
            return typeVariable;
        }
        return typeVariable;
    }

    private static int indexOf(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkNotPrimitive(Type type) {
        C$Gson$Preconditions.checkArgument(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    /* loaded from: classes.dex */
    public final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            boolean z = true;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                C$Gson$Preconditions.checkArgument(type != null || cls.getEnclosingClass() == null);
                if (type != null && cls.getEnclosingClass() == null) {
                    z = false;
                }
                C$Gson$Preconditions.checkArgument(z);
            }
            this.ownerType = type == null ? null : C$Gson$Types.canonicalize(type);
            this.rawType = C$Gson$Types.canonicalize(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            for (int i = 0; i < this.typeArguments.length; i++) {
                C$Gson$Preconditions.checkNotNull(this.typeArguments[i]);
                C$Gson$Types.checkNotPrimitive(this.typeArguments[i]);
                this.typeArguments[i] = C$Gson$Types.canonicalize(this.typeArguments[i]);
            }
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.rawType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return this.ownerType;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C$Gson$Types.equals(this, (ParameterizedType) obj);
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ C$Gson$Types.hashCodeOrZero(this.ownerType);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder((this.typeArguments.length + 1) * 30);
            sb.append(C$Gson$Types.typeToString(this.rawType));
            if (this.typeArguments.length == 0) {
                return sb.toString();
            }
            sb.append("<").append(C$Gson$Types.typeToString(this.typeArguments[0]));
            for (int i = 1; i < this.typeArguments.length; i++) {
                sb.append(", ").append(C$Gson$Types.typeToString(this.typeArguments[i]));
            }
            return sb.append(">").toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    /* loaded from: classes.dex */
    public final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = C$Gson$Types.canonicalize(type);
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return this.componentType;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C$Gson$Types.equals(this, (GenericArrayType) obj);
        }

        public final int hashCode() {
            return this.componentType.hashCode();
        }

        public final String toString() {
            return String.valueOf(C$Gson$Types.typeToString(this.componentType)) + "[]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.gson.internal.$Gson$Types$WildcardTypeImpl */
    /* loaded from: classes.dex */
    public final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            C$Gson$Preconditions.checkArgument(typeArr2.length <= 1);
            C$Gson$Preconditions.checkArgument(typeArr.length == 1);
            if (typeArr2.length == 1) {
                C$Gson$Preconditions.checkNotNull(typeArr2[0]);
                C$Gson$Types.checkNotPrimitive(typeArr2[0]);
                C$Gson$Preconditions.checkArgument(typeArr[0] == Object.class);
                this.lowerBound = C$Gson$Types.canonicalize(typeArr2[0]);
                this.upperBound = Object.class;
                return;
            }
            C$Gson$Preconditions.checkNotNull(typeArr[0]);
            C$Gson$Types.checkNotPrimitive(typeArr[0]);
            this.lowerBound = null;
            this.upperBound = C$Gson$Types.canonicalize(typeArr[0]);
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            return this.lowerBound != null ? new Type[]{this.lowerBound} : C$Gson$Types.EMPTY_TYPE_ARRAY;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C$Gson$Types.equals(this, (WildcardType) obj);
        }

        public final int hashCode() {
            return (this.lowerBound != null ? this.lowerBound.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
        }

        public final String toString() {
            if (this.lowerBound != null) {
                return "? super " + C$Gson$Types.typeToString(this.lowerBound);
            }
            if (this.upperBound == Object.class) {
                return "?";
            }
            return "? extends " + C$Gson$Types.typeToString(this.upperBound);
        }
    }
}
