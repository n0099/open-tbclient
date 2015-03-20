package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class x {
    public static String zc = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> zd = new HashMap<>();

    static {
        zd.put("java.lang.String", "java.lang.String");
        zd.put("java.lang.Integer", "java.lang.Integer");
        zd.put("java.lang.Double", "java.lang.Double");
        zd.put("java.lang.Float", "java.lang.Float");
        zd.put("java.lang.Boolean", "java.lang.Boolean");
        zd.put("java.lang.Character", "java.lang.Character");
        zd.put("java.lang.Short", "java.lang.Short");
        zd.put("java.lang.Long", "java.lang.Long");
        zd.put("java.lang.Byte", "java.lang.Byte");
        zd.put("java.util.Date", "java.util.Date");
        zd.put("java.lang.Integer", "java.lang.Integer");
        zd.put("java.lang.Integer", "java.lang.Integer");
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
