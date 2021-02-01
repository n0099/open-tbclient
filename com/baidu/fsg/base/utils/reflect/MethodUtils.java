package com.baidu.fsg.base.utils.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class MethodUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Method> f2004a = new HashMap();

    private static String a(Class<?> cls, String str, Class<?>... clsArr) {
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

    private static Method b(Class<?> cls, String str, Class<?>... clsArr) {
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

    private static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                if (Modifier.isPublic(interfaces[i].getModifiers())) {
                    try {
                        return interfaces[i].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException e) {
                        Method c = c(interfaces[i], str, clsArr);
                        if (c != null) {
                            return c;
                        }
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static Method a(Method method) {
        if (!MemberUtils.a((Member) method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (!Modifier.isPublic(declaringClass.getModifiers())) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            Method c = c(declaringClass, name, parameterTypes);
            if (c == null) {
                c = b(declaringClass, name, parameterTypes);
            }
            return c;
        }
        return method;
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method;
        String a2 = a(cls, str, clsArr);
        synchronized (f2004a) {
            method = f2004a.get(a2);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
        } else {
            method = a(cls.getMethod(str, clsArr));
            synchronized (f2004a) {
                f2004a.put(a2, method);
            }
        }
        return method;
    }

    private static Method d(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Method[] methods;
        Method a2;
        String a3 = a(cls, str, clsArr);
        synchronized (f2004a) {
            method = f2004a.get(a3);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
        } else {
            try {
                method = cls.getMethod(str, clsArr);
                MemberUtils.a((AccessibleObject) method);
                synchronized (f2004a) {
                    f2004a.put(a3, method);
                }
            } catch (NoSuchMethodException e) {
                method = null;
                for (Method method2 : cls.getMethods()) {
                    if (method2.getName().equals(str) && MemberUtils.a(clsArr, method2.getParameterTypes(), true) && (a2 = a(method2)) != null && (method == null || MemberUtils.a(a2.getParameterTypes(), method.getParameterTypes(), clsArr) < 0)) {
                        method = a2;
                    }
                }
                if (method != null) {
                    MemberUtils.a((AccessibleObject) method);
                }
                synchronized (f2004a) {
                    f2004a.put(a3, method);
                }
            }
        }
        return method;
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] a2 = Utils.a(clsArr);
        Object[] b2 = Utils.b(objArr);
        Method d = d(obj.getClass(), str, a2);
        if (d == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
        }
        return d.invoke(obj, b2);
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] a2 = Utils.a(clsArr);
        Object[] b2 = Utils.b(objArr);
        Method d = d(cls, str, a2);
        if (d == null) {
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + cls.getName());
        }
        return d.invoke(null, b2);
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] b2 = Utils.b(objArr);
        return invokeStaticMethod(cls, str, b2, Utils.a(b2));
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] b2 = Utils.b(objArr);
        return invokeMethod(obj, str, b2, Utils.a(b2));
    }

    public static <T> T invokeConstructor(Class<T> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] b2 = Utils.b(objArr);
        return (T) invokeConstructor(cls, b2, Utils.a(b2));
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] b2 = Utils.b(objArr);
        Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, Utils.a(clsArr));
        if (matchingAccessibleConstructor == null) {
            throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
        }
        return (T) matchingAccessibleConstructor.newInstance(b2);
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        Constructor<?>[] constructors;
        Constructor<T> a2;
        Validate.a(cls != null, "class cannot be null", new Object[0]);
        try {
            Constructor<T> constructor = cls.getConstructor(clsArr);
            MemberUtils.a((AccessibleObject) constructor);
            return constructor;
        } catch (NoSuchMethodException e) {
            Constructor<T> constructor2 = null;
            for (Constructor<?> constructor3 : cls.getConstructors()) {
                if (MemberUtils.a(clsArr, constructor3.getParameterTypes(), true) && (a2 = a(constructor3)) != null) {
                    MemberUtils.a((AccessibleObject) a2);
                    if (constructor2 == null || MemberUtils.a(a2.getParameterTypes(), constructor2.getParameterTypes(), clsArr) < 0) {
                        constructor2 = a2;
                    }
                }
            }
            return constructor2;
        }
    }

    private static <T> Constructor<T> a(Constructor<T> constructor) {
        Validate.a(constructor != null, "constructor cannot be null", new Object[0]);
        if (MemberUtils.a((Member) constructor) && a((Class<?>) constructor.getDeclaringClass())) {
            return constructor;
        }
        return null;
    }

    private static boolean a(Class<?> cls) {
        while (cls != null) {
            if (!Modifier.isPublic(cls.getModifiers())) {
                return false;
            }
            cls = cls.getEnclosingClass();
        }
        return true;
    }
}
