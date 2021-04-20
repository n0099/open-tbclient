package com.baidu.mobads.sdk.internal;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes2.dex */
public class ReflectionUtils {
    public static final String TAG = "com.baidu.mobads.sdk.internal.ReflectionUtils";
    public static XAdLogger logger = XAdLogger.getInstance();

    public static Class<?> getClassForName(String str, ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                return classLoader.loadClass(str);
            } catch (Exception e2) {
                logger.d(TAG, Log.getStackTraceString(e2));
            }
        }
        return null;
    }

    public static Field getDeclaredField(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e2) {
                logger.i(TAG, Log.getStackTraceString(e2));
            }
        }
        return null;
    }

    public static Object getFieldValue(Object obj, String str) {
        Field declaredField = getDeclaredField(obj, str);
        if (declaredField != null) {
            declaredField.setAccessible(true);
            try {
                return declaredField.get(obj);
            } catch (Exception e2) {
                logger.i(TAG, Log.getStackTraceString(e2));
                return null;
            }
        }
        return null;
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod;
            }
            return null;
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object getNewInstance(String str, ClassLoader classLoader, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> classForName = getClassForName(str, classLoader);
            if (classForName != null) {
                return classForName.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Class<?>[] getParameterTypes(Object... objArr) {
        try {
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            return clsArr;
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object getProxyInstance(String str, ClassLoader classLoader, InvocationHandler invocationHandler) {
        Class<?> classForName = getClassForName(str, classLoader);
        if (classForName != null) {
            return Proxy.newProxyInstance(classForName.getClassLoader(), new Class[]{classForName}, invocationHandler);
        }
        return null;
    }

    public static Object invoke(Object obj, String str, Object... objArr) {
        try {
            return invoke(obj.getClass(), obj, str, getParameterTypes(objArr), objArr);
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object invokeMethod(String str, Object obj, ClassLoader classLoader, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> classForName = getClassForName(str, classLoader);
            if (classForName == null || (declaredMethod = classForName.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, ClassLoader classLoader, String str2, Class[] clsArr, Object[] objArr) {
        try {
            Class<?> classForName = getClassForName(str, classLoader);
            if (classForName != null) {
                Method declaredMethod = classForName.getDeclaredMethod(str2, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            }
            return null;
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static boolean isMethodExist(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr) != null;
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return false;
        }
    }

    public static Class<?> getClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object getProxyInstance(String str, InvocationHandler invocationHandler) {
        Class<?> classForName = getClassForName(str);
        if (classForName != null) {
            return Proxy.newProxyInstance(classForName.getClassLoader(), new Class[]{classForName}, invocationHandler);
        }
        return null;
    }

    public static Object invoke(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return invoke(obj.getClass(), obj, str, clsArr, objArr);
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object getFieldValue(Class cls, String str) {
        Field declaredField = getDeclaredField((Class<?>) cls, str);
        if (declaredField != null) {
            declaredField.setAccessible(true);
            try {
                return declaredField.get(cls);
            } catch (Exception e2) {
                logger.i(TAG, Log.getStackTraceString(e2));
                return null;
            }
        }
        return null;
    }

    public static Object getNewInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> classForName = getClassForName(str);
            if (classForName != null) {
                return classForName.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Field getDeclaredField(Class<?> cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e2) {
                logger.i(TAG, Log.getStackTraceString(e2));
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Object invoke(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (isMethodExist(cls, str, clsArr)) {
                return getMethod(cls, str, clsArr).invoke(obj, objArr);
            }
            return null;
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object invokeMethod(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> classForName = getClassForName(str);
            if (classForName == null || (declaredMethod = classForName.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object getFieldValue(ClassLoader classLoader, String str, String str2) {
        try {
            return getFieldValue((Class) Class.forName(str, true, classLoader), str2);
        } catch (Exception e2) {
            logger.i(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }
}
