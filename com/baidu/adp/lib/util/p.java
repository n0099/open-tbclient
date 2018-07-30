package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String DC = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> DD = new HashMap<>();

    static {
        DD.put("java.lang.String", "java.lang.String");
        DD.put("java.lang.Integer", "java.lang.Integer");
        DD.put("java.lang.Double", "java.lang.Double");
        DD.put("java.lang.Float", "java.lang.Float");
        DD.put("java.lang.Boolean", "java.lang.Boolean");
        DD.put("java.lang.Character", "java.lang.Character");
        DD.put("java.lang.Short", "java.lang.Short");
        DD.put("java.lang.Long", "java.lang.Long");
        DD.put("java.lang.Byte", "java.lang.Byte");
        DD.put("java.util.Date", "java.util.Date");
        DD.put("java.lang.Integer", "java.lang.Integer");
        DD.put("java.lang.Integer", "java.lang.Integer");
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
