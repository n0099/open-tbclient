package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class q {
    public static String qm = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> qn = new HashMap<>();

    static {
        qn.put("java.lang.String", "java.lang.String");
        qn.put("java.lang.Integer", "java.lang.Integer");
        qn.put("java.lang.Double", "java.lang.Double");
        qn.put("java.lang.Float", "java.lang.Float");
        qn.put("java.lang.Boolean", "java.lang.Boolean");
        qn.put("java.lang.Character", "java.lang.Character");
        qn.put("java.lang.Short", "java.lang.Short");
        qn.put("java.lang.Long", "java.lang.Long");
        qn.put("java.lang.Byte", "java.lang.Byte");
        qn.put("java.util.Date", "java.util.Date");
        qn.put("java.lang.Integer", "java.lang.Integer");
        qn.put("java.lang.Integer", "java.lang.Integer");
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
