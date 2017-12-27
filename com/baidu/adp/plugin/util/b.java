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
            Object a = a(classLoader, DexClassLoader.class, "mDexs");
            if (a == null) {
                return null;
            }
            try {
                return (DexFile) Array.get(a, 0);
            } catch (Exception e2) {
            }
        } else {
            Object aB = aB(aA(classLoader));
            if (aB == null) {
                return null;
            }
            try {
                return (DexFile) a(Array.get(aB, 0), Class.forName("dalvik.system.DexPathList$Element"), "dexFile");
            } catch (Exception e3) {
            }
        }
        return null;
    }

    private static Object aB(Object obj) {
        if (obj == null) {
            return null;
        }
        return a(obj, obj.getClass(), "dexElements");
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (NoSuchFieldException | SecurityException | Exception e) {
            return null;
        }
    }

    private static Object aA(Object obj) {
        try {
            return a(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
        } catch (ClassNotFoundException | Exception e) {
            return null;
        }
    }
}
