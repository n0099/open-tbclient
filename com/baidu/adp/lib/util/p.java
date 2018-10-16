package com.baidu.adp.lib.util;

import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String GF = AiAppDateTimeUtil.TIME_FORMAT;
    public static HashMap<String, String> GG = new HashMap<>();

    static {
        GG.put("java.lang.String", "java.lang.String");
        GG.put("java.lang.Integer", "java.lang.Integer");
        GG.put("java.lang.Double", "java.lang.Double");
        GG.put("java.lang.Float", "java.lang.Float");
        GG.put("java.lang.Boolean", "java.lang.Boolean");
        GG.put("java.lang.Character", "java.lang.Character");
        GG.put("java.lang.Short", "java.lang.Short");
        GG.put("java.lang.Long", "java.lang.Long");
        GG.put("java.lang.Byte", "java.lang.Byte");
        GG.put("java.util.Date", "java.util.Date");
        GG.put("java.lang.Integer", "java.lang.Integer");
        GG.put("java.lang.Integer", "java.lang.Integer");
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
