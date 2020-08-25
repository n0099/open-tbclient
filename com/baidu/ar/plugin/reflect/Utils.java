package com.baidu.ar.plugin.reflect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
/* loaded from: classes20.dex */
public class Utils {
    static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        return (objArr != null || objArr2 == null || objArr2.length <= 0) && (objArr2 != null || objArr == null || objArr.length <= 0) && (objArr == null || objArr2 == null || objArr.length == objArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?>[] toClass(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return EMPTY_CLASS_ARRAY;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i] == null ? null : objArr[i].getClass();
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?>[] nullToEmpty(Class<?>[] clsArr) {
        if (clsArr == null || clsArr.length == 0) {
            return EMPTY_CLASS_ARRAY;
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] nullToEmpty(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return EMPTY_OBJECT_ARRAY;
        }
        return objArr;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        Class<?>[] interfaces;
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    getAllInterfaces(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }
}
