package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String sC = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> sD = new HashMap<>();

    static {
        sD.put("java.lang.String", "java.lang.String");
        sD.put("java.lang.Integer", "java.lang.Integer");
        sD.put("java.lang.Double", "java.lang.Double");
        sD.put("java.lang.Float", "java.lang.Float");
        sD.put("java.lang.Boolean", "java.lang.Boolean");
        sD.put("java.lang.Character", "java.lang.Character");
        sD.put("java.lang.Short", "java.lang.Short");
        sD.put("java.lang.Long", "java.lang.Long");
        sD.put("java.lang.Byte", "java.lang.Byte");
        sD.put("java.util.Date", "java.util.Date");
        sD.put("java.lang.Integer", "java.lang.Integer");
        sD.put("java.lang.Integer", "java.lang.Integer");
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
