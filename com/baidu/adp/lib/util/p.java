package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String yR = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> yS = new HashMap<>();

    static {
        yS.put("java.lang.String", "java.lang.String");
        yS.put("java.lang.Integer", "java.lang.Integer");
        yS.put("java.lang.Double", "java.lang.Double");
        yS.put("java.lang.Float", "java.lang.Float");
        yS.put("java.lang.Boolean", "java.lang.Boolean");
        yS.put("java.lang.Character", "java.lang.Character");
        yS.put("java.lang.Short", "java.lang.Short");
        yS.put("java.lang.Long", "java.lang.Long");
        yS.put("java.lang.Byte", "java.lang.Byte");
        yS.put("java.util.Date", "java.util.Date");
        yS.put("java.lang.Integer", "java.lang.Integer");
        yS.put("java.lang.Integer", "java.lang.Integer");
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
