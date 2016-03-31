package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String zx = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> zy = new HashMap<>();

    static {
        zy.put("java.lang.String", "java.lang.String");
        zy.put("java.lang.Integer", "java.lang.Integer");
        zy.put("java.lang.Double", "java.lang.Double");
        zy.put("java.lang.Float", "java.lang.Float");
        zy.put("java.lang.Boolean", "java.lang.Boolean");
        zy.put("java.lang.Character", "java.lang.Character");
        zy.put("java.lang.Short", "java.lang.Short");
        zy.put("java.lang.Long", "java.lang.Long");
        zy.put("java.lang.Byte", "java.lang.Byte");
        zy.put("java.util.Date", "java.util.Date");
        zy.put("java.lang.Integer", "java.lang.Integer");
        zy.put("java.lang.Integer", "java.lang.Integer");
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
