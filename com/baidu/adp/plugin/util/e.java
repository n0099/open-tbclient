package com.baidu.adp.plugin.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<Class<?>, Class<?>> EQ = new HashMap<>();

    static {
        EQ.put(Boolean.class, Boolean.TYPE);
        EQ.put(Byte.class, Byte.TYPE);
        EQ.put(Character.class, Character.TYPE);
        EQ.put(Short.class, Short.TYPE);
        EQ.put(Integer.class, Integer.TYPE);
        EQ.put(Float.class, Float.TYPE);
        EQ.put(Long.class, Long.TYPE);
        EQ.put(Double.class, Double.TYPE);
        EQ.put(Boolean.TYPE, Boolean.TYPE);
        EQ.put(Byte.TYPE, Byte.TYPE);
        EQ.put(Character.TYPE, Character.TYPE);
        EQ.put(Short.TYPE, Short.TYPE);
        EQ.put(Integer.TYPE, Integer.TYPE);
        EQ.put(Float.TYPE, Float.TYPE);
        EQ.put(Long.TYPE, Long.TYPE);
        EQ.put(Double.TYPE, Double.TYPE);
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
