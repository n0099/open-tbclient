package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String yW = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> yX = new HashMap<>();

    static {
        yX.put("java.lang.String", "java.lang.String");
        yX.put("java.lang.Integer", "java.lang.Integer");
        yX.put("java.lang.Double", "java.lang.Double");
        yX.put("java.lang.Float", "java.lang.Float");
        yX.put("java.lang.Boolean", "java.lang.Boolean");
        yX.put("java.lang.Character", "java.lang.Character");
        yX.put("java.lang.Short", "java.lang.Short");
        yX.put("java.lang.Long", "java.lang.Long");
        yX.put("java.lang.Byte", "java.lang.Byte");
        yX.put("java.util.Date", "java.util.Date");
        yX.put("java.lang.Integer", "java.lang.Integer");
        yX.put("java.lang.Integer", "java.lang.Integer");
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
