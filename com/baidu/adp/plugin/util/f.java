package com.baidu.adp.plugin.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    private static final HashMap<Class<?>, Class<?>> EG = new HashMap<>();

    /* loaded from: classes.dex */
    public static class a<T> {
        public final Class<? extends T> clazz;
        public final T obj;
    }

    static {
        EG.put(Boolean.class, Boolean.TYPE);
        EG.put(Byte.class, Byte.TYPE);
        EG.put(Character.class, Character.TYPE);
        EG.put(Short.class, Short.TYPE);
        EG.put(Integer.class, Integer.TYPE);
        EG.put(Float.class, Float.TYPE);
        EG.put(Long.class, Long.TYPE);
        EG.put(Double.class, Double.TYPE);
        EG.put(Boolean.TYPE, Boolean.TYPE);
        EG.put(Byte.TYPE, Byte.TYPE);
        EG.put(Character.TYPE, Character.TYPE);
        EG.put(Short.TYPE, Short.TYPE);
        EG.put(Integer.TYPE, Integer.TYPE);
        EG.put(Float.TYPE, Float.TYPE);
        EG.put(Long.TYPE, Long.TYPE);
        EG.put(Double.TYPE, Double.TYPE);
    }

    public static <T> T a(Object obj, String str, Object[] objArr) {
        return (T) b(obj, str, objArr);
    }

    public static <T> T b(Object obj, String str, Object[] objArr) {
        return (T) a(obj.getClass(), str, g(objArr)).invoke(obj, h(objArr));
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
                if (clsArr[i].isAssignableFrom(clsArr2[i]) || (EG.containsKey(clsArr[i]) && EG.get(clsArr[i]).equals(EG.get(clsArr2[i])))) {
                    return true;
                }
            }
            return false;
        }
    }

    private static Class<?>[] g(Object[] objArr) {
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
            if (obj != null && (obj instanceof a)) {
                clsArr[i2] = ((a) obj).clazz;
            } else {
                clsArr[i2] = obj == null ? null : obj.getClass();
            }
            i = i2 + 1;
        }
    }

    private static Object[] h(Object[] objArr) {
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
            if (obj != null && (obj instanceof a)) {
                objArr2[i2] = ((a) obj).obj;
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
        Method a2 = a(obj, str, clsArr);
        if (a2 != null) {
            try {
                a2.setAccessible(true);
                return a2.invoke(obj, objArr);
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
