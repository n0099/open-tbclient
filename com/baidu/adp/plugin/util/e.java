package com.baidu.adp.plugin.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<Class<?>, Class<?>> EO = new HashMap<>();

    static {
        EO.put(Boolean.class, Boolean.TYPE);
        EO.put(Byte.class, Byte.TYPE);
        EO.put(Character.class, Character.TYPE);
        EO.put(Short.class, Short.TYPE);
        EO.put(Integer.class, Integer.TYPE);
        EO.put(Float.class, Float.TYPE);
        EO.put(Long.class, Long.TYPE);
        EO.put(Double.class, Double.TYPE);
        EO.put(Boolean.TYPE, Boolean.TYPE);
        EO.put(Byte.TYPE, Byte.TYPE);
        EO.put(Character.TYPE, Character.TYPE);
        EO.put(Short.TYPE, Short.TYPE);
        EO.put(Integer.TYPE, Integer.TYPE);
        EO.put(Float.TYPE, Float.TYPE);
        EO.put(Long.TYPE, Long.TYPE);
        EO.put(Double.TYPE, Double.TYPE);
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
