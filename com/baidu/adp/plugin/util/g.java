package com.baidu.adp.plugin.util;

import dalvik.system.DexFile;
/* loaded from: classes.dex */
class g extends ClassLoader {
    private final /* synthetic */ DexFile Fo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ClassLoader classLoader, DexFile dexFile) {
        super(classLoader);
        this.Fo = dexFile;
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> loadClass = this.Fo.loadClass(str, this);
        if (loadClass == null && str.startsWith("com.baidu.adp.plugin.PluginPatchAnnotation")) {
            return Class.forName(str);
        }
        if (loadClass == null) {
            throw new ClassNotFoundException(str);
        }
        return loadClass;
    }
}
