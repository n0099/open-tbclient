package com.baidu.adp.plugin.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static final HashMap<Class<?>, Class<?>> Me = new HashMap<>();

    /* loaded from: classes.dex */
    public static class a<T> {
        public final Class<? extends T> clazz;
        public final T obj;
    }

    static {
        Me.put(Boolean.class, Boolean.TYPE);
        Me.put(Byte.class, Byte.TYPE);
        Me.put(Character.class, Character.TYPE);
        Me.put(Short.class, Short.TYPE);
        Me.put(Integer.class, Integer.TYPE);
        Me.put(Float.class, Float.TYPE);
        Me.put(Long.class, Long.TYPE);
        Me.put(Double.class, Double.TYPE);
        Me.put(Boolean.TYPE, Boolean.TYPE);
        Me.put(Byte.TYPE, Byte.TYPE);
        Me.put(Character.TYPE, Character.TYPE);
        Me.put(Short.TYPE, Short.TYPE);
        Me.put(Integer.TYPE, Integer.TYPE);
        Me.put(Float.TYPE, Float.TYPE);
        Me.put(Long.TYPE, Long.TYPE);
        Me.put(Double.TYPE, Double.TYPE);
    }

    public static <T> T c(Object obj, String str, Object[] objArr) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return (T) d(obj, str, objArr);
    }

    public static <T> T d(Object obj, String str, Object[] objArr) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return (T) e(obj.getClass(), str, h(objArr)).invoke(obj, j(objArr));
    }

    public static void a(Object obj, Class<?> cls, String str, Object obj2) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    private static Method e(Class<?> cls, String str, Class<?>[] clsArr) throws NoSuchMethodException, SecurityException {
        Method b = b(cls.getDeclaredMethods(), str, clsArr);
        if (b != null) {
            b.setAccessible(true);
        }
        return b;
    }

    private static Method b(Method[] methodArr, String str, Class<?>[] clsArr) throws NoSuchMethodException {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && b(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        throw new NoSuchMethodException(str);
    }

    private static boolean b(Class<?>[] clsArr, Class<?>[] clsArr2) {
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
                if (clsArr[i].isAssignableFrom(clsArr2[i])) {
                    return true;
                }
                if (Me.containsKey(clsArr[i]) && Me.get(clsArr[i]).equals(Me.get(clsArr2[i]))) {
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
            if (obj != null && (obj instanceof a)) {
                clsArr[i2] = ((a) obj).clazz;
            } else {
                clsArr[i2] = obj == null ? null : obj.getClass();
            }
            i = i2 + 1;
        }
    }

    private static Object[] j(Object[] objArr) {
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

    public static Method b(Object obj, String str, Class<?>[] clsArr) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static Object invokeMethod(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Method b = b(obj, str, clsArr);
        if (b != null) {
            try {
                b.setAccessible(true);
                return b.invoke(obj, objArr);
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

    public static Object getField(Object obj, Class<?> cls, String str) throws NoSuchFieldException, NoSuchFieldError, IllegalArgumentException, IllegalAccessException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }
}
