package com.baidu.adp.lib.util;

import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String GJ = AiAppDateTimeUtil.TIME_FORMAT;
    public static HashMap<String, String> GK = new HashMap<>();

    static {
        GK.put("java.lang.String", "java.lang.String");
        GK.put("java.lang.Integer", "java.lang.Integer");
        GK.put("java.lang.Double", "java.lang.Double");
        GK.put("java.lang.Float", "java.lang.Float");
        GK.put("java.lang.Boolean", "java.lang.Boolean");
        GK.put("java.lang.Character", "java.lang.Character");
        GK.put("java.lang.Short", "java.lang.Short");
        GK.put("java.lang.Long", "java.lang.Long");
        GK.put("java.lang.Byte", "java.lang.Byte");
        GK.put("java.util.Date", "java.util.Date");
        GK.put("java.lang.Integer", "java.lang.Integer");
        GK.put("java.lang.Integer", "java.lang.Integer");
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
