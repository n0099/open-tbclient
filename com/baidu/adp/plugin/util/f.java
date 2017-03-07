package com.baidu.adp.plugin.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static final HashMap<Class<?>, Class<?>> FM = new HashMap<>();

    /* loaded from: classes.dex */
    public static class a<T> {
        public final Class<? extends T> clazz;
        public final T obj;
    }

    static {
        FM.put(Boolean.class, Boolean.TYPE);
        FM.put(Byte.class, Byte.TYPE);
        FM.put(Character.class, Character.TYPE);
        FM.put(Short.class, Short.TYPE);
        FM.put(Integer.class, Integer.TYPE);
        FM.put(Float.class, Float.TYPE);
        FM.put(Long.class, Long.TYPE);
        FM.put(Double.class, Double.TYPE);
        FM.put(Boolean.TYPE, Boolean.TYPE);
        FM.put(Byte.TYPE, Byte.TYPE);
        FM.put(Character.TYPE, Character.TYPE);
        FM.put(Short.TYPE, Short.TYPE);
        FM.put(Integer.TYPE, Integer.TYPE);
        FM.put(Float.TYPE, Float.TYPE);
        FM.put(Long.TYPE, Long.TYPE);
        FM.put(Double.TYPE, Double.TYPE);
    }

    public static <T> T a(Object obj, String str, Object[] objArr) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return (T) b(obj, str, objArr);
    }

    public static <T> T b(Object obj, String str, Object[] objArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return (T) b(obj.getClass(), str, f(objArr)).invoke(obj, g(objArr));
    }

    public static void a(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    private static Method b(Class<?> cls, String str, Class<?>[] clsArr) throws NoSuchMethodException, SecurityException {
        Method a2 = a(cls.getDeclaredMethods(), str, clsArr);
        if (a2 != null) {
            a2.setAccessible(true);
        }
        return a2;
    }

    private static Method a(Method[] methodArr, String str, Class<?>[] clsArr) throws NoSuchMethodException {
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
                if (clsArr[i].isAssignableFrom(clsArr2[i]) || (FM.containsKey(clsArr[i]) && FM.get(clsArr[i]).equals(FM.get(clsArr2[i])))) {
                    return true;
                }
            }
            return false;
        }
    }

    public static Object d(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj2 != null) {
            if (obj.getClass().isArray() && obj2.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                int length = Array.getLength(obj);
                int length2 = length + Array.getLength(obj2);
                Object newInstance = Array.newInstance(componentType, length2);
                for (int i = 0; i < length2; i++) {
                    if (i < length) {
                        Array.set(newInstance, i, Array.get(obj, i));
                    } else {
                        Array.set(newInstance, i, Array.get(obj2, i - length));
                    }
                }
                return newInstance;
            } else if ((obj instanceof List) && (obj2 instanceof List)) {
                List list = (List) obj;
                List list2 = (List) obj2;
                ArrayList arrayList = new ArrayList(list.size() + list2.size());
                arrayList.addAll(list);
                arrayList.addAll(list2);
                return arrayList;
            } else {
                return obj;
            }
        }
        return obj;
    }

    private static Class<?>[] f(Object[] objArr) {
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

    private static Object[] g(Object[] objArr) {
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

    public static Object a(Object obj, Class<?> cls, String str) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }
}
