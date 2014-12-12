package com.baidu.adp.plugin.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private static final HashMap<Class<?>, Class<?>> tO = new HashMap<>();

    static {
        tO.put(Boolean.class, Boolean.TYPE);
        tO.put(Byte.class, Byte.TYPE);
        tO.put(Character.class, Character.TYPE);
        tO.put(Short.class, Short.TYPE);
        tO.put(Integer.class, Integer.TYPE);
        tO.put(Float.class, Float.TYPE);
        tO.put(Long.class, Long.TYPE);
        tO.put(Double.class, Double.TYPE);
        tO.put(Boolean.TYPE, Boolean.TYPE);
        tO.put(Byte.TYPE, Byte.TYPE);
        tO.put(Character.TYPE, Character.TYPE);
        tO.put(Short.TYPE, Short.TYPE);
        tO.put(Integer.TYPE, Integer.TYPE);
        tO.put(Float.TYPE, Float.TYPE);
        tO.put(Long.TYPE, Long.TYPE);
        tO.put(Double.TYPE, Double.TYPE);
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
