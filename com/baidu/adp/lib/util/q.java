package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String pK = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> pL = new HashMap<>();

    static {
        pL.put("java.lang.String", "java.lang.String");
        pL.put("java.lang.Integer", "java.lang.Integer");
        pL.put("java.lang.Double", "java.lang.Double");
        pL.put("java.lang.Float", "java.lang.Float");
        pL.put("java.lang.Boolean", "java.lang.Boolean");
        pL.put("java.lang.Character", "java.lang.Character");
        pL.put("java.lang.Short", "java.lang.Short");
        pL.put("java.lang.Long", "java.lang.Long");
        pL.put("java.lang.Byte", "java.lang.Byte");
        pL.put("java.util.Date", "java.util.Date");
        pL.put("java.lang.Integer", "java.lang.Integer");
        pL.put("java.lang.Integer", "java.lang.Integer");
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
