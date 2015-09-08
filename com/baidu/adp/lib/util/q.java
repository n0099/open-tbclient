package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String yP = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> yQ = new HashMap<>();

    static {
        yQ.put("java.lang.String", "java.lang.String");
        yQ.put("java.lang.Integer", "java.lang.Integer");
        yQ.put("java.lang.Double", "java.lang.Double");
        yQ.put("java.lang.Float", "java.lang.Float");
        yQ.put("java.lang.Boolean", "java.lang.Boolean");
        yQ.put("java.lang.Character", "java.lang.Character");
        yQ.put("java.lang.Short", "java.lang.Short");
        yQ.put("java.lang.Long", "java.lang.Long");
        yQ.put("java.lang.Byte", "java.lang.Byte");
        yQ.put("java.util.Date", "java.util.Date");
        yQ.put("java.lang.Integer", "java.lang.Integer");
        yQ.put("java.lang.Integer", "java.lang.Integer");
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
