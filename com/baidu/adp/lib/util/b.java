package com.baidu.adp.lib.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
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
}
