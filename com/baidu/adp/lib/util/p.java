package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String anc = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> and = new HashMap<>();

    static {
        and.put("java.lang.String", "java.lang.String");
        and.put("java.lang.Integer", "java.lang.Integer");
        and.put("java.lang.Double", "java.lang.Double");
        and.put("java.lang.Float", "java.lang.Float");
        and.put("java.lang.Boolean", "java.lang.Boolean");
        and.put("java.lang.Character", "java.lang.Character");
        and.put("java.lang.Short", "java.lang.Short");
        and.put("java.lang.Long", "java.lang.Long");
        and.put("java.lang.Byte", "java.lang.Byte");
        and.put("java.util.Date", "java.util.Date");
        and.put("java.lang.Integer", "java.lang.Integer");
        and.put("java.lang.Integer", "java.lang.Integer");
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
