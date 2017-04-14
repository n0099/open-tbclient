package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String zo = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> zp = new HashMap<>();

    static {
        zp.put("java.lang.String", "java.lang.String");
        zp.put("java.lang.Integer", "java.lang.Integer");
        zp.put("java.lang.Double", "java.lang.Double");
        zp.put("java.lang.Float", "java.lang.Float");
        zp.put("java.lang.Boolean", "java.lang.Boolean");
        zp.put("java.lang.Character", "java.lang.Character");
        zp.put("java.lang.Short", "java.lang.Short");
        zp.put("java.lang.Long", "java.lang.Long");
        zp.put("java.lang.Byte", "java.lang.Byte");
        zp.put("java.util.Date", "java.util.Date");
        zp.put("java.lang.Integer", "java.lang.Integer");
        zp.put("java.lang.Integer", "java.lang.Integer");
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
