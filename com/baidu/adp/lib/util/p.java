package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String DE = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> DF = new HashMap<>();

    static {
        DF.put("java.lang.String", "java.lang.String");
        DF.put("java.lang.Integer", "java.lang.Integer");
        DF.put("java.lang.Double", "java.lang.Double");
        DF.put("java.lang.Float", "java.lang.Float");
        DF.put("java.lang.Boolean", "java.lang.Boolean");
        DF.put("java.lang.Character", "java.lang.Character");
        DF.put("java.lang.Short", "java.lang.Short");
        DF.put("java.lang.Long", "java.lang.Long");
        DF.put("java.lang.Byte", "java.lang.Byte");
        DF.put("java.util.Date", "java.util.Date");
        DF.put("java.lang.Integer", "java.lang.Integer");
        DF.put("java.lang.Integer", "java.lang.Integer");
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
