package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String amZ = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> ana = new HashMap<>();

    static {
        ana.put("java.lang.String", "java.lang.String");
        ana.put("java.lang.Integer", "java.lang.Integer");
        ana.put("java.lang.Double", "java.lang.Double");
        ana.put("java.lang.Float", "java.lang.Float");
        ana.put("java.lang.Boolean", "java.lang.Boolean");
        ana.put("java.lang.Character", "java.lang.Character");
        ana.put("java.lang.Short", "java.lang.Short");
        ana.put("java.lang.Long", "java.lang.Long");
        ana.put("java.lang.Byte", "java.lang.Byte");
        ana.put("java.util.Date", "java.util.Date");
        ana.put("java.lang.Integer", "java.lang.Integer");
        ana.put("java.lang.Integer", "java.lang.Integer");
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
