package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String nz = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> nA = new HashMap<>();

    static {
        nA.put("java.lang.String", "java.lang.String");
        nA.put("java.lang.Integer", "java.lang.Integer");
        nA.put("java.lang.Double", "java.lang.Double");
        nA.put("java.lang.Float", "java.lang.Float");
        nA.put("java.lang.Boolean", "java.lang.Boolean");
        nA.put("java.lang.Character", "java.lang.Character");
        nA.put("java.lang.Short", "java.lang.Short");
        nA.put("java.lang.Long", "java.lang.Long");
        nA.put("java.lang.Byte", "java.lang.Byte");
        nA.put("java.util.Date", "java.util.Date");
        nA.put("java.lang.Integer", "java.lang.Integer");
        nA.put("java.lang.Integer", "java.lang.Integer");
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
