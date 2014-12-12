package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class v {
    public static String nC = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> nD = new HashMap<>();

    static {
        nD.put("java.lang.String", "java.lang.String");
        nD.put("java.lang.Integer", "java.lang.Integer");
        nD.put("java.lang.Double", "java.lang.Double");
        nD.put("java.lang.Float", "java.lang.Float");
        nD.put("java.lang.Boolean", "java.lang.Boolean");
        nD.put("java.lang.Character", "java.lang.Character");
        nD.put("java.lang.Short", "java.lang.Short");
        nD.put("java.lang.Long", "java.lang.Long");
        nD.put("java.lang.Byte", "java.lang.Byte");
        nD.put("java.util.Date", "java.util.Date");
        nD.put("java.lang.Integer", "java.lang.Integer");
        nD.put("java.lang.Integer", "java.lang.Integer");
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
