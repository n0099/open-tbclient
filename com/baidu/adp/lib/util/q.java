package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String zs = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> zt = new HashMap<>();

    static {
        zt.put("java.lang.String", "java.lang.String");
        zt.put("java.lang.Integer", "java.lang.Integer");
        zt.put("java.lang.Double", "java.lang.Double");
        zt.put("java.lang.Float", "java.lang.Float");
        zt.put("java.lang.Boolean", "java.lang.Boolean");
        zt.put("java.lang.Character", "java.lang.Character");
        zt.put("java.lang.Short", "java.lang.Short");
        zt.put("java.lang.Long", "java.lang.Long");
        zt.put("java.lang.Byte", "java.lang.Byte");
        zt.put("java.util.Date", "java.util.Date");
        zt.put("java.lang.Integer", "java.lang.Integer");
        zt.put("java.lang.Integer", "java.lang.Integer");
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
