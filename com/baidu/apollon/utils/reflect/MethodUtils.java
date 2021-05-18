package com.baidu.apollon.utils.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class MethodUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Method> f4087a = new HashMap();

    public static String a(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString());
        sb.append("#");
        sb.append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.toString());
                sb.append("#");
            }
        } else {
            sb.append(Void.class.toString());
        }
        return sb.toString();
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (Modifier.isPublic(superclass.getModifiers())) {
                try {
                    return superclass.getMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                    return null;
                }
            }
        }
        return null;
    }

    public static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            for (int i2 = 0; i2 < interfaces.length; i2++) {
                if (Modifier.isPublic(interfaces[i2].getModifiers())) {
                    try {
                        return interfaces[i2].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        Method c2 = c(interfaces[i2], str, clsArr);
                        if (c2 != null) {
                            return c2;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    public static Method d(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Method[] methods;
        Method a2;
        String a3 = a(cls, str, clsArr);
        synchronized (f4087a) {
            method = f4087a.get(a3);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method method2 = cls.getMethod(str, clsArr);
            a.a((AccessibleObject) method2);
            synchronized (f4087a) {
                f4087a.put(a3, method2);
            }
            return method2;
        } catch (NoSuchMethodException unused) {
            Method method3 = null;
            for (Method method4 : cls.getMethods()) {
                if (method4.getName().equals(str) && a.a(clsArr, method4.getParameterTypes(), true) && (a2 = a(method4)) != null && (method3 == null || a.a(a2.getParameterTypes(), method3.getParameterTypes(), clsArr) < 0)) {
                    method3 = a2;
                }
            }
            if (method3 != null) {
                a.a((AccessibleObject) method3);
            }
            synchronized (f4087a) {
                f4087a.put(a3, method3);
                return method3;
            }
        }
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method;
        String a2 = a(cls, str, clsArr);
        synchronized (f4087a) {
            method = f4087a.get(a2);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        Method a3 = a(cls.getMethod(str, clsArr));
        synchronized (f4087a) {
            f4087a.put(a2, a3);
        }
        return a3;
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        Constructor<?>[] constructors;
        Constructor<T> a2;
        b.a(cls != null, "class cannot be null", new Object[0]);
        try {
            Constructor<T> constructor = cls.getConstructor(clsArr);
            a.a((AccessibleObject) constructor);
            return constructor;
        } catch (NoSuchMethodException unused) {
            Constructor<T> constructor2 = null;
            for (Constructor<?> constructor3 : cls.getConstructors()) {
                if (a.a(clsArr, constructor3.getParameterTypes(), true) && (a2 = a(constructor3)) != null) {
                    a.a((AccessibleObject) a2);
                    if (constructor2 == null || a.a(a2.getParameterTypes(), constructor2.getParameterTypes(), clsArr) < 0) {
                        constructor2 = a2;
                    }
                }
            }
            return constructor2;
        }
    }

    public static <T> T invokeConstructor(Class<T> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] b2 = Utils.b(objArr);
        return (T) invokeConstructor(cls, b2, Utils.a(b2));
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] a2 = Utils.a(clsArr);
        Object[] b2 = Utils.b(objArr);
        Method d2 = d(obj.getClass(), str, a2);
        if (d2 != null) {
            return d2.invoke(obj, b2);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] a2 = Utils.a(clsArr);
        Object[] b2 = Utils.b(objArr);
        Method d2 = d(cls, str, a2);
        if (d2 != null) {
            return d2.invoke(null, b2);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + cls.getName());
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] b2 = Utils.b(objArr);
        Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, Utils.a(clsArr));
        if (matchingAccessibleConstructor != null) {
            return (T) matchingAccessibleConstructor.newInstance(b2);
        }
        throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] b2 = Utils.b(objArr);
        return invokeMethod(obj, str, b2, Utils.a(b2));
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] b2 = Utils.b(objArr);
        return invokeStaticMethod(cls, str, b2, Utils.a(b2));
    }

    public static Method a(Method method) {
        if (a.a((Member) method)) {
            Class<?> declaringClass = method.getDeclaringClass();
            if (Modifier.isPublic(declaringClass.getModifiers())) {
                return method;
            }
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            Method c2 = c(declaringClass, name, parameterTypes);
            return c2 == null ? b(declaringClass, name, parameterTypes) : c2;
        }
        return null;
    }

    public static <T> Constructor<T> a(Constructor<T> constructor) {
        b.a(constructor != null, "constructor cannot be null", new Object[0]);
        if (a.a((Member) constructor) && a((Class<?>) constructor.getDeclaringClass())) {
            return constructor;
        }
        return null;
    }

    public static boolean a(Class<?> cls) {
        while (cls != null) {
            if (!Modifier.isPublic(cls.getModifiers())) {
                return false;
            }
            cls = cls.getEnclosingClass();
        }
        return true;
    }
}
