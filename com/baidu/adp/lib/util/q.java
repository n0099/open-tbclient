package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String sD = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> sE = new HashMap<>();

    static {
        sE.put("java.lang.String", "java.lang.String");
        sE.put("java.lang.Integer", "java.lang.Integer");
        sE.put("java.lang.Double", "java.lang.Double");
        sE.put("java.lang.Float", "java.lang.Float");
        sE.put("java.lang.Boolean", "java.lang.Boolean");
        sE.put("java.lang.Character", "java.lang.Character");
        sE.put("java.lang.Short", "java.lang.Short");
        sE.put("java.lang.Long", "java.lang.Long");
        sE.put("java.lang.Byte", "java.lang.Byte");
        sE.put("java.util.Date", "java.util.Date");
        sE.put("java.lang.Integer", "java.lang.Integer");
        sE.put("java.lang.Integer", "java.lang.Integer");
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
