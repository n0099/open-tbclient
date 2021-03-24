package com.baidu.sofire.core;

import dalvik.system.DexClassLoader;
/* loaded from: classes3.dex */
public final class e extends DexClassLoader {
    public e(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    public final Class<?> a(String str) throws ClassNotFoundException {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                return findClass(str);
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
                return findLoadedClass;
            }
        }
        return findLoadedClass;
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                findLoadedClass = findClass(str);
            } catch (Throwable unused) {
            }
            if (findLoadedClass == null) {
                try {
                    if (getParent() != null) {
                        findLoadedClass = getParent().loadClass(str);
                    } else {
                        findLoadedClass = (Class) getClass().getDeclaredMethod("findBootstrapClassOrNull", String.class).invoke(this, str);
                    }
                } catch (Throwable unused2) {
                    com.baidu.sofire.g.d.a();
                }
            }
        }
        if (z) {
            resolveClass(findLoadedClass);
        }
        if (findLoadedClass == null) {
            try {
                return super.loadClass(str, z);
            } catch (Throwable unused3) {
                com.baidu.sofire.g.d.a();
            }
        }
        return findLoadedClass;
    }
}
