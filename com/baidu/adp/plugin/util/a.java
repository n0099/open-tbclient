package com.baidu.adp.plugin.util;

import com.baidu.adp.lib.util.BdLog;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    public static b a(ClassLoader classLoader, ClassLoader classLoader2, String str) {
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        boolean z = true;
        try {
            Class.forName("dalvik.system.BaseDexClassLoader");
        } catch (ClassNotFoundException e) {
            z = false;
        }
        if (!z) {
            return b(classLoader, classLoader2, str);
        }
        return c(classLoader, classLoader2, str);
    }

    private static b b(ClassLoader classLoader, ClassLoader classLoader2, String str) {
        b bVar;
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        try {
            PathClassLoader pathClassLoader = (PathClassLoader) classLoader;
            DexClassLoader dexClassLoader = (DexClassLoader) classLoader2;
            dexClassLoader.loadClass(str);
            a(pathClassLoader, PathClassLoader.class, "mPaths", d(a(pathClassLoader, PathClassLoader.class, "mPaths"), a(dexClassLoader, DexClassLoader.class, "mRawDexPath")));
            a(pathClassLoader, PathClassLoader.class, "mDexs", c(a(pathClassLoader, PathClassLoader.class, "mDexs"), a(dexClassLoader, DexClassLoader.class, "mDexs")));
            a(pathClassLoader, PathClassLoader.class, "mFiles", c(a(pathClassLoader, PathClassLoader.class, "mFiles"), a(dexClassLoader, DexClassLoader.class, "mFiles")));
            a(pathClassLoader, PathClassLoader.class, "mZips", c(a(pathClassLoader, PathClassLoader.class, "mZips"), a(dexClassLoader, DexClassLoader.class, "mZips")));
            try {
                ArrayList arrayList = (ArrayList) a(pathClassLoader, PathClassLoader.class, "libraryPathElements");
                for (String str2 : (String[]) a(dexClassLoader, DexClassLoader.class, "mLibPaths")) {
                    arrayList.add(str2);
                }
                bVar = null;
            } catch (Exception e) {
                a(pathClassLoader, PathClassLoader.class, "mLibPaths", c(a(pathClassLoader, PathClassLoader.class, "mLibPaths"), a(dexClassLoader, DexClassLoader.class, "mLibPaths")));
                bVar = null;
            }
        } catch (IllegalAccessException e2) {
            b a = a(false, e2);
            BdLog.e(e2);
            bVar = a;
        } catch (NoSuchFieldException e3) {
            b a2 = a(false, e3);
            BdLog.e(e3);
            bVar = a2;
        } catch (Exception e4) {
            b a3 = a(false, e4);
            BdLog.e(e4);
            bVar = a3;
        }
        if (bVar == null) {
            return a(true, null);
        }
        return bVar;
    }

    private static b c(ClassLoader classLoader, ClassLoader classLoader2, String str) {
        b bVar;
        if (classLoader == null || classLoader2 == null) {
            return null;
        }
        try {
            DexClassLoader dexClassLoader = (DexClassLoader) classLoader2;
            dexClassLoader.loadClass(str);
            Object s = s((PathClassLoader) classLoader);
            Object s2 = s(dexClassLoader);
            a(s, s.getClass(), "dexElements", c(t(s), t(s2)));
            a(s, s.getClass(), "nativeLibraryDirectories", c(u(s), u(s2)));
            bVar = null;
        } catch (ClassNotFoundException e) {
            b a = a(false, e);
            BdLog.e(e);
            bVar = a;
        } catch (IllegalAccessException e2) {
            b a2 = a(false, e2);
            BdLog.e(e2);
            bVar = a2;
        } catch (IllegalArgumentException e3) {
            b a3 = a(false, e3);
            BdLog.e(e3);
            bVar = a3;
        } catch (NoSuchFieldException e4) {
            b a4 = a(false, e4);
            BdLog.e(e4);
            bVar = a4;
        }
        if (bVar == null) {
            return a(true, null);
        }
        return bVar;
    }

    private static void a(Object obj, Class<?> cls, String str, Object obj2) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static Object c(Object obj, Object obj2) {
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2) + length;
        Object newInstance = Array.newInstance(componentType, length2);
        for (int i = 0; i < length2; i++) {
            if (i < length) {
                Array.set(newInstance, i, Array.get(obj, i));
            } else {
                Array.set(newInstance, i, Array.get(obj2, i - length));
            }
        }
        return newInstance;
    }

    private static Object d(Object obj, Object obj2) {
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        int i = length + 1;
        Object newInstance = Array.newInstance(componentType, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < length) {
                Array.set(newInstance, i2, Array.get(obj, i2));
            } else {
                Array.set(newInstance, i2, obj2);
            }
        }
        return newInstance;
    }

    private static b a(boolean z, Throwable th) {
        b bVar = new b();
        bVar.tN = z;
        bVar.mErrMsg = th != null ? th.getLocalizedMessage() : null;
        return bVar;
    }

    private static Object s(Object obj) {
        return a(obj, Class.forName("dalvik.system.BaseDexClassLoader"), "pathList");
    }

    private static Object t(Object obj) {
        return a(obj, obj.getClass(), "dexElements");
    }

    private static Object u(Object obj) {
        return a(obj, obj.getClass(), "nativeLibraryDirectories");
    }
}
