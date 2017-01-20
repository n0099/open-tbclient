package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String sv = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> sw = new HashMap<>();

    static {
        sw.put("java.lang.String", "java.lang.String");
        sw.put("java.lang.Integer", "java.lang.Integer");
        sw.put("java.lang.Double", "java.lang.Double");
        sw.put("java.lang.Float", "java.lang.Float");
        sw.put("java.lang.Boolean", "java.lang.Boolean");
        sw.put("java.lang.Character", "java.lang.Character");
        sw.put("java.lang.Short", "java.lang.Short");
        sw.put("java.lang.Long", "java.lang.Long");
        sw.put("java.lang.Byte", "java.lang.Byte");
        sw.put("java.util.Date", "java.util.Date");
        sw.put("java.lang.Integer", "java.lang.Integer");
        sw.put("java.lang.Integer", "java.lang.Integer");
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
