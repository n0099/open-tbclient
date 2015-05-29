package com.baidu.adp.plugin.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class g {
    private static final HashMap<Class<?>, Class<?>> EE = new HashMap<>();

    static {
        EE.put(Boolean.class, Boolean.TYPE);
        EE.put(Byte.class, Byte.TYPE);
        EE.put(Character.class, Character.TYPE);
        EE.put(Short.class, Short.TYPE);
        EE.put(Integer.class, Integer.TYPE);
        EE.put(Float.class, Float.TYPE);
        EE.put(Long.class, Long.TYPE);
        EE.put(Double.class, Double.TYPE);
        EE.put(Boolean.TYPE, Boolean.TYPE);
        EE.put(Byte.TYPE, Byte.TYPE);
        EE.put(Character.TYPE, Character.TYPE);
        EE.put(Short.TYPE, Short.TYPE);
        EE.put(Integer.TYPE, Integer.TYPE);
        EE.put(Float.TYPE, Float.TYPE);
        EE.put(Long.TYPE, Long.TYPE);
        EE.put(Double.TYPE, Double.TYPE);
    }

    public static <T> T a(Object obj, String str, Object[] objArr) {
        return (T) b(obj, str, objArr);
    }

    public static <T> T b(Object obj, String str, Object[] objArr) {
        return (T) a(obj.getClass(), str, h(objArr)).invoke(obj, i(objArr));
    }

    private static Method a(Class<?> cls, String str, Class<?>[] clsArr) {
        return a(cls.getDeclaredMethods(), str, clsArr);
    }

    private static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        throw new NoSuchMethodException(str);
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        int length = clsArr.length;
        if (clsArr2 == null) {
            return length == 0;
        } else if (length != clsArr2.length) {
            return false;
        } else {
            for (int i = length - 1; i >= 0; i--) {
                if (clsArr[i].isAssignableFrom(clsArr2[i]) || (EE.containsKey(clsArr[i]) && EE.get(clsArr[i]).equals(EE.get(clsArr2[i])))) {
                    return true;
                }
            }
            return false;
        }
    }

    private static Class<?>[] h(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return clsArr;
            }
            Object obj = objArr[i2];
            if (obj != null && (obj instanceof h)) {
                clsArr[i2] = ((h) obj).EF;
            } else {
                clsArr[i2] = obj == null ? null : obj.getClass();
            }
            i = i2 + 1;
        }
    }

    private static Object[] i(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return objArr2;
            }
            Object obj = objArr[i2];
            if (obj != null && (obj instanceof h)) {
                objArr2[i2] = ((h) obj).obj;
            } else {
                objArr2[i2] = obj;
            }
            i = i2 + 1;
        }
    }

    public static Method a(Object obj, String str, Class<?>[] clsArr) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Method a = a(obj, str, clsArr);
        if (a != null) {
            try {
                a.setAccessible(true);
                return a.invoke(obj, objArr);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }
}
