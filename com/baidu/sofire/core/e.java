package com.baidu.sofire.core;

import dalvik.system.DexClassLoader;
/* loaded from: classes15.dex */
public final class e extends DexClassLoader {
    public e(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    @Override // java.lang.ClassLoader
    protected final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> cls;
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                cls = findClass(str);
            } catch (Throwable th) {
                cls = findLoadedClass;
            }
            if (cls == null) {
                try {
                    findLoadedClass = getParent() != null ? getParent().loadClass(str) : (Class) getClass().getDeclaredMethod("findBootstrapClassOrNull", String.class).invoke(this, str);
                } catch (Throwable th2) {
                    findLoadedClass = cls;
                    com.baidu.sofire.i.e.a();
                }
            } else {
                findLoadedClass = cls;
            }
        }
        if (z) {
            resolveClass(findLoadedClass);
        }
        if (findLoadedClass == null) {
            try {
                return super.loadClass(str, z);
            } catch (Throwable th3) {
                com.baidu.sofire.i.e.a();
                return findLoadedClass;
            }
        }
        return findLoadedClass;
    }

    public final Class<?> a(String str) throws ClassNotFoundException {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                return findClass(str);
            } catch (Throwable th) {
                com.baidu.sofire.i.e.a();
                return findLoadedClass;
            }
        }
        return findLoadedClass;
    }
}
