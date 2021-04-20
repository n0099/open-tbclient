package com.baidu.mobads.container.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes2.dex */
public class ReflectionUtils {
    public static Class<?> getClass(String str, ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                return classLoader.loadClass(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Field getDeclaredField(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Object getFieldValue(ClassLoader classLoader, String str, String str2) {
        try {
            return getFieldValue((Class) Class.forName(str, true, classLoader), str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method getMethod(Object obj, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = getClass(obj).getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object getNewInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Class cls = getClass(str);
            if (cls != null) {
                return cls.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Class<?>[] getParameterTypes(Object... objArr) {
        try {
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            return clsArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object getProxyInstance(String str, InvocationHandler invocationHandler) {
        Class cls = getClass(str);
        if (cls != null) {
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler);
        }
        return null;
    }

    public static Object invoke(Object obj, String str, Object... objArr) {
        try {
            return invoke(obj.getClass(), obj, str, getParameterTypes(objArr), objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object invokeMethod(String str, Object obj, ClassLoader classLoader, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> cls = getClass(str, classLoader);
            if (cls != null && (declaredMethod = cls.getDeclaredMethod(str2, clsArr)) != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, objArr);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) {
        try {
            return invoke(cls, null, str, getParameterTypes(objArr), objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isMethodExist(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Class getClass(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> getClass(Object obj) {
        try {
            return Class.forName(obj.getClass().getName());
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2);
            return null;
        }
    }

    public static Object getFieldValue(Class cls, String str) {
        Field declaredField = getDeclaredField((Class<?>) cls, str);
        declaredField.setAccessible(true);
        try {
            return declaredField.get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static Object invoke(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return invoke(obj.getClass(), obj, str, clsArr, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Class[] clsArr, Object[] objArr) {
        if (cls != null) {
            try {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static Object invoke(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (isMethodExist(cls, str, clsArr)) {
                return getMethod(cls, str, clsArr).invoke(obj, objArr);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Field getDeclaredField(Class<?> cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Object invokeMethod(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class cls = getClass(str);
            if (cls != null && (declaredMethod = cls.getDeclaredMethod(str2, clsArr)) != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, objArr);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static Object getFieldValue(Object obj, String str) {
        Field declaredField = getDeclaredField(obj, str);
        if (declaredField != null) {
            declaredField.setAccessible(true);
            try {
                return declaredField.get(obj);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }
}
