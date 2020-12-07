package com.baidu.ar.plugin.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public class MethodUtils {
    private static Map<String, Method> sMethodCache = new HashMap();

    private static String getKey(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.toString()).append("#");
            }
        } else {
            sb.append(Void.class.toString());
        }
        return sb.toString();
    }

    private static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (Modifier.isPublic(superclass.getModifiers())) {
                try {
                    return superclass.getMethod(str, clsArr);
                } catch (NoSuchMethodException e) {
                    return null;
                }
            }
        }
        return null;
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                if (Modifier.isPublic(interfaces[i].getModifiers())) {
                    try {
                        return interfaces[i].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException e) {
                        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(interfaces[i], str, clsArr);
                        if (accessibleMethodFromInterfaceNest != null) {
                            return accessibleMethodFromInterfaceNest;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static Method getAccessibleMethod(Method method) {
        if (!MemberUtils.isAccessible(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (!Modifier.isPublic(declaringClass.getModifiers())) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(declaringClass, name, parameterTypes);
            if (accessibleMethodFromInterfaceNest == null) {
                accessibleMethodFromInterfaceNest = getAccessibleMethodFromSuperclass(declaringClass, name, parameterTypes);
            }
            return accessibleMethodFromInterfaceNest;
        }
        return method;
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method;
        String key = getKey(cls, str, clsArr);
        synchronized (sMethodCache) {
            method = sMethodCache.get(key);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
        } else {
            method = getAccessibleMethod(cls.getMethod(str, clsArr));
            synchronized (sMethodCache) {
                sMethodCache.put(key, method);
            }
        }
        return method;
    }

    private static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Method[] methods;
        Method accessibleMethod;
        String key = getKey(cls, str, clsArr);
        synchronized (sMethodCache) {
            method = sMethodCache.get(key);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
        } else {
            try {
                method = cls.getMethod(str, clsArr);
                MemberUtils.setAccessibleWorkaround(method);
                synchronized (sMethodCache) {
                    sMethodCache.put(key, method);
                }
            } catch (NoSuchMethodException e) {
                method = null;
                for (Method method2 : cls.getMethods()) {
                    if (method2.getName().equals(str) && MemberUtils.isAssignable(clsArr, method2.getParameterTypes(), true) && (accessibleMethod = getAccessibleMethod(method2)) != null && (method == null || MemberUtils.compareParameterTypes(accessibleMethod.getParameterTypes(), method.getParameterTypes(), clsArr) < 0)) {
                        method = accessibleMethod;
                    }
                }
                if (method != null) {
                    MemberUtils.setAccessibleWorkaround(method);
                }
                synchronized (sMethodCache) {
                    sMethodCache.put(key, method);
                }
            }
        }
        return method;
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] nullToEmpty = Utils.nullToEmpty(clsArr);
        Object[] nullToEmpty2 = Utils.nullToEmpty(objArr);
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, nullToEmpty);
        if (matchingAccessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
        }
        return matchingAccessibleMethod.invoke(obj, nullToEmpty2);
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = Utils.nullToEmpty(objArr);
        return invokeMethod(obj, str, nullToEmpty, Utils.toClass(nullToEmpty));
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] nullToEmpty = Utils.nullToEmpty(clsArr);
        Object[] nullToEmpty2 = Utils.nullToEmpty(objArr);
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, nullToEmpty);
        if (matchingAccessibleMethod == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + cls.getName());
        }
        return matchingAccessibleMethod.invoke(null, nullToEmpty2);
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = Utils.nullToEmpty(objArr);
        return invokeStaticMethod(cls, str, nullToEmpty, Utils.toClass(nullToEmpty));
    }

    public static <T> T invokeConstructor(Class<T> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] nullToEmpty = Utils.nullToEmpty(objArr);
        return (T) invokeConstructor(cls, nullToEmpty, Utils.toClass(nullToEmpty));
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] nullToEmpty = Utils.nullToEmpty(objArr);
        Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, Utils.nullToEmpty(clsArr));
        if (matchingAccessibleConstructor == null) {
            throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
        }
        return (T) matchingAccessibleConstructor.newInstance(nullToEmpty);
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        Constructor<?>[] constructors;
        Constructor<T> accessibleConstructor;
        Validate.isTrue(cls != null, "class cannot be null", new Object[0]);
        try {
            Constructor<T> constructor = cls.getConstructor(clsArr);
            MemberUtils.setAccessibleWorkaround(constructor);
            return constructor;
        } catch (NoSuchMethodException e) {
            Constructor<T> constructor2 = null;
            for (Constructor<?> constructor3 : cls.getConstructors()) {
                if (MemberUtils.isAssignable(clsArr, constructor3.getParameterTypes(), true) && (accessibleConstructor = getAccessibleConstructor(constructor3)) != null) {
                    MemberUtils.setAccessibleWorkaround(accessibleConstructor);
                    if (constructor2 == null || MemberUtils.compareParameterTypes(accessibleConstructor.getParameterTypes(), constructor2.getParameterTypes(), clsArr) < 0) {
                        constructor2 = accessibleConstructor;
                    }
                }
            }
            return constructor2;
        }
    }

    private static <T> Constructor<T> getAccessibleConstructor(Constructor<T> constructor) {
        Validate.isTrue(constructor != null, "constructor cannot be null", new Object[0]);
        if (MemberUtils.isAccessible(constructor) && isAccessible(constructor.getDeclaringClass())) {
            return constructor;
        }
        return null;
    }

    private static boolean isAccessible(Class<?> cls) {
        while (cls != null) {
            if (!Modifier.isPublic(cls.getModifiers())) {
                return false;
            }
            cls = cls.getEnclosingClass();
        }
        return true;
    }
}
