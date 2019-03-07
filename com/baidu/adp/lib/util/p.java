package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String GI = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> GJ = new HashMap<>();

    static {
        GJ.put("java.lang.String", "java.lang.String");
        GJ.put("java.lang.Integer", "java.lang.Integer");
        GJ.put("java.lang.Double", "java.lang.Double");
        GJ.put("java.lang.Float", "java.lang.Float");
        GJ.put("java.lang.Boolean", "java.lang.Boolean");
        GJ.put("java.lang.Character", "java.lang.Character");
        GJ.put("java.lang.Short", "java.lang.Short");
        GJ.put("java.lang.Long", "java.lang.Long");
        GJ.put("java.lang.Byte", "java.lang.Byte");
        GJ.put("java.util.Date", "java.util.Date");
        GJ.put("java.lang.Integer", "java.lang.Integer");
        GJ.put("java.lang.Integer", "java.lang.Integer");
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
