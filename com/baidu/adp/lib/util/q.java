package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String yQ = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> yR = new HashMap<>();

    static {
        yR.put("java.lang.String", "java.lang.String");
        yR.put("java.lang.Integer", "java.lang.Integer");
        yR.put("java.lang.Double", "java.lang.Double");
        yR.put("java.lang.Float", "java.lang.Float");
        yR.put("java.lang.Boolean", "java.lang.Boolean");
        yR.put("java.lang.Character", "java.lang.Character");
        yR.put("java.lang.Short", "java.lang.Short");
        yR.put("java.lang.Long", "java.lang.Long");
        yR.put("java.lang.Byte", "java.lang.Byte");
        yR.put("java.util.Date", "java.util.Date");
        yR.put("java.lang.Integer", "java.lang.Integer");
        yR.put("java.lang.Integer", "java.lang.Integer");
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
