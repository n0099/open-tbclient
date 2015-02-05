package com.baidu.adp.plugin.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<Class<?>, Class<?>> tU = new HashMap<>();

    static {
        tU.put(Boolean.class, Boolean.TYPE);
        tU.put(Byte.class, Byte.TYPE);
        tU.put(Character.class, Character.TYPE);
        tU.put(Short.class, Short.TYPE);
        tU.put(Integer.class, Integer.TYPE);
        tU.put(Float.class, Float.TYPE);
        tU.put(Long.class, Long.TYPE);
        tU.put(Double.class, Double.TYPE);
        tU.put(Boolean.TYPE, Boolean.TYPE);
        tU.put(Byte.TYPE, Byte.TYPE);
        tU.put(Character.TYPE, Character.TYPE);
        tU.put(Short.TYPE, Short.TYPE);
        tU.put(Integer.TYPE, Integer.TYPE);
        tU.put(Float.TYPE, Float.TYPE);
        tU.put(Long.TYPE, Long.TYPE);
        tU.put(Double.TYPE, Double.TYPE);
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
