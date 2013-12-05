package com.baidu.gson.internal;

import com.baidu.gson.InstanceCreator;
import com.baidu.gson.JsonIOException;
import com.baidu.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
/* loaded from: classes.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.instanceCreators = map;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        final Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        final InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>() { // from class: com.baidu.gson.internal.ConstructorConstructor.1
                /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
                @Override // com.baidu.gson.internal.ObjectConstructor
                public T construct() {
                    return instanceCreator.createInstance(type);
                }
            };
        }
        final InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new ObjectConstructor<T>() { // from class: com.baidu.gson.internal.ConstructorConstructor.2
                /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
                @Override // com.baidu.gson.internal.ObjectConstructor
                public T construct() {
                    return instanceCreator2.createInstance(type);
                }
            };
        }
        ObjectConstructor<T> newDefaultConstructor = newDefaultConstructor(rawType);
        if (newDefaultConstructor == null) {
            ObjectConstructor<T> newDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
            return newDefaultImplementationConstructor == null ? newUnsafeAllocator(type, rawType) : newDefaultImplementationConstructor;
        }
        return newDefaultConstructor;
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new ObjectConstructor<T>() { // from class: com.baidu.gson.internal.ConstructorConstructor.3
                /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
                @Override // com.baidu.gson.internal.ObjectConstructor
                public T construct() {
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.baidu.gson.internal.ConstructorConstructor.4
                    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.TreeSet] */
                    @Override // com.baidu.gson.internal.ObjectConstructor
                    public T construct() {
                        return new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.baidu.gson.internal.ConstructorConstructor.5
                    /* JADX WARN: Type inference failed for: r0v9, types: [T, java.util.EnumSet] */
                    @Override // com.baidu.gson.internal.ObjectConstructor
                    public T construct() {
                        if (type instanceof ParameterizedType) {
                            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (type2 instanceof Class) {
                                return EnumSet.noneOf((Class) type2);
                            }
                            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.baidu.gson.internal.ConstructorConstructor.6
                    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.LinkedHashSet] */
                    @Override // com.baidu.gson.internal.ObjectConstructor
                    public T construct() {
                        return new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.baidu.gson.internal.ConstructorConstructor.7
                    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.LinkedList] */
                    @Override // com.baidu.gson.internal.ObjectConstructor
                    public T construct() {
                        return new LinkedList();
                    }
                };
            }
            return new ObjectConstructor<T>() { // from class: com.baidu.gson.internal.ConstructorConstructor.8
                /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
                @Override // com.baidu.gson.internal.ObjectConstructor
                public T construct() {
                    return new ArrayList();
                }
            };
        } else if (Map.class.isAssignableFrom(cls)) {
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.baidu.gson.internal.ConstructorConstructor.9
                    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.TreeMap, T] */
                    @Override // com.baidu.gson.internal.ObjectConstructor
                    public T construct() {
                        return new TreeMap();
                    }
                };
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new ObjectConstructor<T>() { // from class: com.baidu.gson.internal.ConstructorConstructor.10
                    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, T] */
                    @Override // com.baidu.gson.internal.ObjectConstructor
                    public T construct() {
                        return new LinkedHashMap();
                    }
                };
            }
            return new ObjectConstructor<T>() { // from class: com.baidu.gson.internal.ConstructorConstructor.11
                /* JADX WARN: Type inference failed for: r0v0, types: [T, com.baidu.gson.internal.LinkedTreeMap] */
                @Override // com.baidu.gson.internal.ObjectConstructor
                public T construct() {
                    return new LinkedTreeMap();
                }
            };
        } else {
            return null;
        }
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(final Type type, final Class<? super T> cls) {
        return new ObjectConstructor<T>() { // from class: com.baidu.gson.internal.ConstructorConstructor.12
            private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();

            /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
            @Override // com.baidu.gson.internal.ObjectConstructor
            public T construct() {
                try {
                    return this.unsafeAllocator.newInstance(cls);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
