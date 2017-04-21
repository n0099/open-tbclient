package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String zr = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> zs = new HashMap<>();

    static {
        zs.put("java.lang.String", "java.lang.String");
        zs.put("java.lang.Integer", "java.lang.Integer");
        zs.put("java.lang.Double", "java.lang.Double");
        zs.put("java.lang.Float", "java.lang.Float");
        zs.put("java.lang.Boolean", "java.lang.Boolean");
        zs.put("java.lang.Character", "java.lang.Character");
        zs.put("java.lang.Short", "java.lang.Short");
        zs.put("java.lang.Long", "java.lang.Long");
        zs.put("java.lang.Byte", "java.lang.Byte");
        zs.put("java.util.Date", "java.util.Date");
        zs.put("java.lang.Integer", "java.lang.Integer");
        zs.put("java.lang.Integer", "java.lang.Integer");
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
