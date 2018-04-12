package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String xy = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> xz = new HashMap<>();

    static {
        xz.put("java.lang.String", "java.lang.String");
        xz.put("java.lang.Integer", "java.lang.Integer");
        xz.put("java.lang.Double", "java.lang.Double");
        xz.put("java.lang.Float", "java.lang.Float");
        xz.put("java.lang.Boolean", "java.lang.Boolean");
        xz.put("java.lang.Character", "java.lang.Character");
        xz.put("java.lang.Short", "java.lang.Short");
        xz.put("java.lang.Long", "java.lang.Long");
        xz.put("java.lang.Byte", "java.lang.Byte");
        xz.put("java.util.Date", "java.util.Date");
        xz.put("java.lang.Integer", "java.lang.Integer");
        xz.put("java.lang.Integer", "java.lang.Integer");
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
