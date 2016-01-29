package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String zg = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> zh = new HashMap<>();

    static {
        zh.put("java.lang.String", "java.lang.String");
        zh.put("java.lang.Integer", "java.lang.Integer");
        zh.put("java.lang.Double", "java.lang.Double");
        zh.put("java.lang.Float", "java.lang.Float");
        zh.put("java.lang.Boolean", "java.lang.Boolean");
        zh.put("java.lang.Character", "java.lang.Character");
        zh.put("java.lang.Short", "java.lang.Short");
        zh.put("java.lang.Long", "java.lang.Long");
        zh.put("java.lang.Byte", "java.lang.Byte");
        zh.put("java.util.Date", "java.util.Date");
        zh.put("java.lang.Integer", "java.lang.Integer");
        zh.put("java.lang.Integer", "java.lang.Integer");
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
