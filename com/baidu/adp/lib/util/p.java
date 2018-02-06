package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String anb = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> anc = new HashMap<>();

    static {
        anc.put("java.lang.String", "java.lang.String");
        anc.put("java.lang.Integer", "java.lang.Integer");
        anc.put("java.lang.Double", "java.lang.Double");
        anc.put("java.lang.Float", "java.lang.Float");
        anc.put("java.lang.Boolean", "java.lang.Boolean");
        anc.put("java.lang.Character", "java.lang.Character");
        anc.put("java.lang.Short", "java.lang.Short");
        anc.put("java.lang.Long", "java.lang.Long");
        anc.put("java.lang.Byte", "java.lang.Byte");
        anc.put("java.util.Date", "java.util.Date");
        anc.put("java.lang.Integer", "java.lang.Integer");
        anc.put("java.lang.Integer", "java.lang.Integer");
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
