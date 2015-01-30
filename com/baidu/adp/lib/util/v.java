package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class v {
    public static String nF = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> nG = new HashMap<>();

    static {
        nG.put("java.lang.String", "java.lang.String");
        nG.put("java.lang.Integer", "java.lang.Integer");
        nG.put("java.lang.Double", "java.lang.Double");
        nG.put("java.lang.Float", "java.lang.Float");
        nG.put("java.lang.Boolean", "java.lang.Boolean");
        nG.put("java.lang.Character", "java.lang.Character");
        nG.put("java.lang.Short", "java.lang.Short");
        nG.put("java.lang.Long", "java.lang.Long");
        nG.put("java.lang.Byte", "java.lang.Byte");
        nG.put("java.util.Date", "java.util.Date");
        nG.put("java.lang.Integer", "java.lang.Integer");
        nG.put("java.lang.Integer", "java.lang.Integer");
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
