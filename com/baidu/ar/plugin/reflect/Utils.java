package com.baidu.ar.plugin.reflect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
/* loaded from: classes.dex */
public class Utils {
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        if (objArr != null || objArr2 == null || objArr2.length <= 0) {
            if (objArr2 != null || objArr == null || objArr.length <= 0) {
                return objArr == null || objArr2 == null || objArr.length == objArr2.length;
            }
            return false;
        }
        return false;
    }

    public static Class<?>[] nullToEmpty(Class<?>[] clsArr) {
        return (clsArr == null || clsArr.length == 0) ? EMPTY_CLASS_ARRAY : clsArr;
    }

    public static Class<?>[] toClass(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return EMPTY_CLASS_ARRAY;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            clsArr[i2] = objArr[i2] == null ? null : objArr[i2].getClass();
        }
        return clsArr;
    }

    public static Object[] nullToEmpty(Object[] objArr) {
        return (objArr == null || objArr.length == 0) ? EMPTY_OBJECT_ARRAY : objArr;
    }

    public static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
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
