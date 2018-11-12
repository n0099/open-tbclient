package com.baidu.sofire.core;

import dalvik.system.DexClassLoader;
/* loaded from: classes.dex */
public class f extends DexClassLoader {
    public f(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z) {
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
                    com.baidu.sofire.b.e.a(th2);
                }
            }
            findLoadedClass = cls;
        }
        if (z) {
            resolveClass(findLoadedClass);
        }
        if (findLoadedClass == null) {
            try {
                return super.loadClass(str, z);
            } catch (Throwable th3) {
                com.baidu.sofire.b.e.a(th3);
                return findLoadedClass;
            }
        }
        return findLoadedClass;
    }

    public Class<?> a(String str) {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            try {
                return findClass(str);
            } catch (Throwable th) {
                com.baidu.sofire.b.e.a(th);
                return findLoadedClass;
            }
        }
        return findLoadedClass;
    }
}
