package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String xx = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> xy = new HashMap<>();

    static {
        xy.put("java.lang.String", "java.lang.String");
        xy.put("java.lang.Integer", "java.lang.Integer");
        xy.put("java.lang.Double", "java.lang.Double");
        xy.put("java.lang.Float", "java.lang.Float");
        xy.put("java.lang.Boolean", "java.lang.Boolean");
        xy.put("java.lang.Character", "java.lang.Character");
        xy.put("java.lang.Short", "java.lang.Short");
        xy.put("java.lang.Long", "java.lang.Long");
        xy.put("java.lang.Byte", "java.lang.Byte");
        xy.put("java.util.Date", "java.util.Date");
        xy.put("java.lang.Integer", "java.lang.Integer");
        xy.put("java.lang.Integer", "java.lang.Integer");
    }

    public static Object a(Object obj, Field field) {
        Object obj2 = null;
        if (obj != null && field != null) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            try {
                obj2 = field.get(obj);
            } catch (Throwable th) {
            }
            field.setAccessible(isAccessible);
        }
        return obj2;
    }
}
