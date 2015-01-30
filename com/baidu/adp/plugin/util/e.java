package com.baidu.adp.plugin.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<Class<?>, Class<?>> tX = new HashMap<>();

    static {
        tX.put(Boolean.class, Boolean.TYPE);
        tX.put(Byte.class, Byte.TYPE);
        tX.put(Character.class, Character.TYPE);
        tX.put(Short.class, Short.TYPE);
        tX.put(Integer.class, Integer.TYPE);
        tX.put(Float.class, Float.TYPE);
        tX.put(Long.class, Long.TYPE);
        tX.put(Double.class, Double.TYPE);
        tX.put(Boolean.TYPE, Boolean.TYPE);
        tX.put(Byte.TYPE, Byte.TYPE);
        tX.put(Character.TYPE, Character.TYPE);
        tX.put(Short.TYPE, Short.TYPE);
        tX.put(Integer.TYPE, Integer.TYPE);
        tX.put(Float.TYPE, Float.TYPE);
        tX.put(Long.TYPE, Long.TYPE);
        tX.put(Double.TYPE, Double.TYPE);
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
