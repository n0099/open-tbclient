package com.baidu.cyberplayer.sdk.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ReflectUtils {
    public static Method getMethod(Class cls, String str, Class... clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            return method;
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return null;
        }
    }

    public static Field getField(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return null;
        }
    }

    public static void invoke(Method method, Object obj, Object... objArr) {
        try {
            method.invoke(obj, objArr);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
        }
    }

    public static void invoke(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            method.invoke(obj, objArr);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
        }
    }

    public static void invokeDeclared(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
        }
    }

    public static <T> T invokeWithResult(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr, T t) {
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            return (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return t;
        }
    }

    public static <T> T invokeWithResult(Method method, Object obj, T t, Object... objArr) {
        try {
            return (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return t;
        }
    }

    public static <T> T invokeStaticWithResult(Class cls, String str, Class[] clsArr, Object[] objArr, T t) {
        try {
            return (T) invokeWithResult(cls, null, str, clsArr, objArr, t);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return t;
        }
    }

    public static <T> T invokeDeclaredWithResult(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr, T t) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return (T) declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return t;
        }
    }

    public static <T> T invokeStaticWithResultE(Class cls, String str, Class[] clsArr, Object[] objArr, T t) {
        try {
            return (T) cls.getMethod(str, clsArr).invoke(null, objArr);
        } catch (IllegalAccessException e) {
            LogUtils.dumpException(e);
            return t;
        } catch (NoSuchMethodException e2) {
            LogUtils.dumpException(e2);
            return t;
        } catch (InvocationTargetException e3) {
            LogUtils.dumpException(e3);
            throw e3.getCause();
        }
    }

    public static int getFieldIntStatic(Class cls, String str, int i) {
        try {
            Field field = cls.getField(str);
            field.setAccessible(true);
            return field.getInt(null);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return i;
        }
    }

    public static boolean setDeclaredFieldBoolean(Class cls, Object obj, String str, boolean z) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.setBoolean(obj, z);
            return true;
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return false;
        }
    }

    public static boolean setDeclaredFieldInt(Class cls, Object obj, String str, int i) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.setInt(obj, i);
            return true;
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return false;
        }
    }

    public static boolean getDeclaredFieldBoolean(Class cls, Object obj, String str, boolean z) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getBoolean(obj);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return z;
        }
    }

    public static boolean getFieldValueBoolean(Field field, Object obj, boolean z) {
        try {
            return field.getBoolean(obj);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return z;
        }
    }

    public static int getDeclaredFieldInt(Class cls, Object obj, String str, int i) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return i;
        }
    }

    public static <T> T getDeclaredFieldObject(Class cls, Object obj, String str, T t) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return (T) declaredField.get(obj);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return t;
        }
    }

    public static Object newInstance(Class cls, Class[] clsArr, Object[] objArr) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Throwable th) {
            LogUtils.dumpException(th);
            return null;
        }
    }
}
