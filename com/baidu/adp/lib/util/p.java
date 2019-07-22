package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String Ez = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> EA = new HashMap<>();

    static {
        EA.put("java.lang.String", "java.lang.String");
        EA.put("java.lang.Integer", "java.lang.Integer");
        EA.put("java.lang.Double", "java.lang.Double");
        EA.put("java.lang.Float", "java.lang.Float");
        EA.put("java.lang.Boolean", "java.lang.Boolean");
        EA.put("java.lang.Character", "java.lang.Character");
        EA.put("java.lang.Short", "java.lang.Short");
        EA.put("java.lang.Long", "java.lang.Long");
        EA.put("java.lang.Byte", "java.lang.Byte");
        EA.put("java.util.Date", "java.util.Date");
        EA.put("java.lang.Integer", "java.lang.Integer");
        EA.put("java.lang.Integer", "java.lang.Integer");
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
