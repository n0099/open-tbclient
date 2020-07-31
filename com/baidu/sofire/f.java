package com.baidu.sofire;

import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public final class f {
    public static boolean a(Class<?> cls, Object obj, Object obj2) {
        Field[] declaredFields;
        if (obj == null || obj2 == null) {
            return false;
        }
        while (cls != null && cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    field.set(obj2, field.get(obj));
                } catch (Throwable th) {
                    com.baidu.sofire.i.d.a();
                }
            }
            cls = cls.getSuperclass();
        }
        return true;
    }
}
