package com.baidu.adp.lib.util;

import com.baidu.live.adp.lib.util.FieldUtil;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes.dex */
public class p {
    public static String dateFormat = "yyyy-MM-dd HH:mm:ss";
    public static HashMap<String, String> PrimitiveTypes = new HashMap<>();

    static {
        PrimitiveTypes.put(FieldUtil.TYPE_STRING, FieldUtil.TYPE_STRING);
        PrimitiveTypes.put(FieldUtil.TYPE_INTEGER, FieldUtil.TYPE_INTEGER);
        PrimitiveTypes.put(FieldUtil.TYPE_DOUBLE, FieldUtil.TYPE_DOUBLE);
        PrimitiveTypes.put(FieldUtil.TYPE_FLOAT, FieldUtil.TYPE_FLOAT);
        PrimitiveTypes.put(FieldUtil.TYPE_BOOLEAN, FieldUtil.TYPE_BOOLEAN);
        PrimitiveTypes.put(FieldUtil.TYPE_CHARACTER, FieldUtil.TYPE_CHARACTER);
        PrimitiveTypes.put(FieldUtil.TYPE_SHORT, FieldUtil.TYPE_SHORT);
        PrimitiveTypes.put(FieldUtil.TYPE_LONG, FieldUtil.TYPE_LONG);
        PrimitiveTypes.put(FieldUtil.TYPE_BYTE, FieldUtil.TYPE_BYTE);
        PrimitiveTypes.put(FieldUtil.TYPE_DATE, FieldUtil.TYPE_DATE);
        PrimitiveTypes.put(FieldUtil.TYPE_INTEGER, FieldUtil.TYPE_INTEGER);
        PrimitiveTypes.put(FieldUtil.TYPE_INTEGER, FieldUtil.TYPE_INTEGER);
    }

    public static Object forceGetProperty(Object obj, Field field) {
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
