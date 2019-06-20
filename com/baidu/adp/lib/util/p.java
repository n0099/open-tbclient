package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String Et = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> Eu = new HashMap<>();

    static {
        Eu.put("java.lang.String", "java.lang.String");
        Eu.put("java.lang.Integer", "java.lang.Integer");
        Eu.put("java.lang.Double", "java.lang.Double");
        Eu.put("java.lang.Float", "java.lang.Float");
        Eu.put("java.lang.Boolean", "java.lang.Boolean");
        Eu.put("java.lang.Character", "java.lang.Character");
        Eu.put("java.lang.Short", "java.lang.Short");
        Eu.put("java.lang.Long", "java.lang.Long");
        Eu.put("java.lang.Byte", "java.lang.Byte");
        Eu.put("java.util.Date", "java.util.Date");
        Eu.put("java.lang.Integer", "java.lang.Integer");
        Eu.put("java.lang.Integer", "java.lang.Integer");
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
