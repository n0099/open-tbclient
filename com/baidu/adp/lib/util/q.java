package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String yY = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> yZ = new HashMap<>();

    static {
        yZ.put("java.lang.String", "java.lang.String");
        yZ.put("java.lang.Integer", "java.lang.Integer");
        yZ.put("java.lang.Double", "java.lang.Double");
        yZ.put("java.lang.Float", "java.lang.Float");
        yZ.put("java.lang.Boolean", "java.lang.Boolean");
        yZ.put("java.lang.Character", "java.lang.Character");
        yZ.put("java.lang.Short", "java.lang.Short");
        yZ.put("java.lang.Long", "java.lang.Long");
        yZ.put("java.lang.Byte", "java.lang.Byte");
        yZ.put("java.util.Date", "java.util.Date");
        yZ.put("java.lang.Integer", "java.lang.Integer");
        yZ.put("java.lang.Integer", "java.lang.Integer");
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
