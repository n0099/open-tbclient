package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String amV = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> amW = new HashMap<>();

    static {
        amW.put("java.lang.String", "java.lang.String");
        amW.put("java.lang.Integer", "java.lang.Integer");
        amW.put("java.lang.Double", "java.lang.Double");
        amW.put("java.lang.Float", "java.lang.Float");
        amW.put("java.lang.Boolean", "java.lang.Boolean");
        amW.put("java.lang.Character", "java.lang.Character");
        amW.put("java.lang.Short", "java.lang.Short");
        amW.put("java.lang.Long", "java.lang.Long");
        amW.put("java.lang.Byte", "java.lang.Byte");
        amW.put("java.util.Date", "java.util.Date");
        amW.put("java.lang.Integer", "java.lang.Integer");
        amW.put("java.lang.Integer", "java.lang.Integer");
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
