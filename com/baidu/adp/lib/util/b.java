package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    public static Object a(Object obj, Field field) {
        Object obj2 = null;
        if (obj == null || field == null) {
            return null;
        }
        boolean isAccessible = field.isAccessible();
        try {
            field.setAccessible(true);
            obj2 = field.get(obj);
            field.setAccessible(isAccessible);
            return obj2;
        } catch (Throwable th) {
            return obj2;
        }
    }

    public static List<Field> a(Object obj, Class<?> cls) {
        Field[] declaredFields;
        ArrayList arrayList = new ArrayList();
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.getType().isAssignableFrom(cls)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    public static Field e(Class<?> cls, Class<?> cls2) {
        Field[] declaredFields;
        if (cls == null) {
            return null;
        }
        while (cls != Object.class) {
            try {
                for (Field field : cls.getDeclaredFields()) {
                    if (cls2.isAssignableFrom(field.getType())) {
                        return field;
                    }
                }
                continue;
            } catch (Throwable th) {
            }
            cls = cls.getSuperclass();
        }
        return null;
    }
}
