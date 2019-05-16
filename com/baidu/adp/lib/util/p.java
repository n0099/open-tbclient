package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String Eu = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> Ev = new HashMap<>();

    static {
        Ev.put("java.lang.String", "java.lang.String");
        Ev.put("java.lang.Integer", "java.lang.Integer");
        Ev.put("java.lang.Double", "java.lang.Double");
        Ev.put("java.lang.Float", "java.lang.Float");
        Ev.put("java.lang.Boolean", "java.lang.Boolean");
        Ev.put("java.lang.Character", "java.lang.Character");
        Ev.put("java.lang.Short", "java.lang.Short");
        Ev.put("java.lang.Long", "java.lang.Long");
        Ev.put("java.lang.Byte", "java.lang.Byte");
        Ev.put("java.util.Date", "java.util.Date");
        Ev.put("java.lang.Integer", "java.lang.Integer");
        Ev.put("java.lang.Integer", "java.lang.Integer");
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
