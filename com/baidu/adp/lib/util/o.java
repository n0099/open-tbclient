package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    public static String AV = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> AW = new HashMap<>();

    static {
        AW.put("java.lang.String", "java.lang.String");
        AW.put("java.lang.Integer", "java.lang.Integer");
        AW.put("java.lang.Double", "java.lang.Double");
        AW.put("java.lang.Float", "java.lang.Float");
        AW.put("java.lang.Boolean", "java.lang.Boolean");
        AW.put("java.lang.Character", "java.lang.Character");
        AW.put("java.lang.Short", "java.lang.Short");
        AW.put("java.lang.Long", "java.lang.Long");
        AW.put("java.lang.Byte", "java.lang.Byte");
        AW.put("java.util.Date", "java.util.Date");
        AW.put("java.lang.Integer", "java.lang.Integer");
        AW.put("java.lang.Integer", "java.lang.Integer");
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
