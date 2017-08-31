package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    public static String yO = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> yP = new HashMap<>();

    static {
        yP.put("java.lang.String", "java.lang.String");
        yP.put("java.lang.Integer", "java.lang.Integer");
        yP.put("java.lang.Double", "java.lang.Double");
        yP.put("java.lang.Float", "java.lang.Float");
        yP.put("java.lang.Boolean", "java.lang.Boolean");
        yP.put("java.lang.Character", "java.lang.Character");
        yP.put("java.lang.Short", "java.lang.Short");
        yP.put("java.lang.Long", "java.lang.Long");
        yP.put("java.lang.Byte", "java.lang.Byte");
        yP.put("java.util.Date", "java.util.Date");
        yP.put("java.lang.Integer", "java.lang.Integer");
        yP.put("java.lang.Integer", "java.lang.Integer");
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
