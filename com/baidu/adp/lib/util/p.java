package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String DG = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> DH = new HashMap<>();

    static {
        DH.put("java.lang.String", "java.lang.String");
        DH.put("java.lang.Integer", "java.lang.Integer");
        DH.put("java.lang.Double", "java.lang.Double");
        DH.put("java.lang.Float", "java.lang.Float");
        DH.put("java.lang.Boolean", "java.lang.Boolean");
        DH.put("java.lang.Character", "java.lang.Character");
        DH.put("java.lang.Short", "java.lang.Short");
        DH.put("java.lang.Long", "java.lang.Long");
        DH.put("java.lang.Byte", "java.lang.Byte");
        DH.put("java.util.Date", "java.util.Date");
        DH.put("java.lang.Integer", "java.lang.Integer");
        DH.put("java.lang.Integer", "java.lang.Integer");
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
