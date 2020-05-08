package com.baidu.adp.plugin.util;

import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class b {
    public static DexFile a(ClassLoader classLoader) {
        if (classLoader == null) {
            return null;
        }
        boolean z = true;
        try {
            Class.forName("dalvik.system.BaseDexClassLoader");
        } catch (ClassNotFoundException e) {
            z = false;
        }
        if (!z) {
            Object field = getField(classLoader, DexClassLoader.class, "mDexs");
            if (field == null) {
                return null;
            }
            try {
                return (DexFile) Array.get(field, 0);
            } catch (Exception e2) {
            }
        } else {
            Object z2 = z(getPathList(classLoader));
            if (z2 == null) {
                return null;
            }
            try {
                return (DexFile) getField(Array.get(z2, 0), Class.forName("dalvik.system.DexPathList$Element"), "dexFile");
            } catch (Exception e3) {
            }
        }
        return null;
    }

    private static Object z(Object obj) {
        if (obj == null) {
            return null;
        }
        return getField(obj, obj.getClass(), "dexElements");
    }

    private static Object getField(Object obj, Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (NoSuchFieldException | SecurityException | Exception e) {
            return null;
        }
    }

    private static Object getPathList(Object obj) {
        try {
            return getField(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
        } catch (ClassNotFoundException | Exception e) {
            return null;
        }
    }
}
