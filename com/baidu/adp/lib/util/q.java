package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String zN = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> zO = new HashMap<>();

    static {
        zO.put("java.lang.String", "java.lang.String");
        zO.put("java.lang.Integer", "java.lang.Integer");
        zO.put("java.lang.Double", "java.lang.Double");
        zO.put("java.lang.Float", "java.lang.Float");
        zO.put("java.lang.Boolean", "java.lang.Boolean");
        zO.put("java.lang.Character", "java.lang.Character");
        zO.put("java.lang.Short", "java.lang.Short");
        zO.put("java.lang.Long", "java.lang.Long");
        zO.put("java.lang.Byte", "java.lang.Byte");
        zO.put("java.util.Date", "java.util.Date");
        zO.put("java.lang.Integer", "java.lang.Integer");
        zO.put("java.lang.Integer", "java.lang.Integer");
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
