package com.baidu.adp.plugin.util;

import dalvik.system.DexFile;
/* loaded from: classes.dex */
class g extends ClassLoader {
    private final /* synthetic */ DexFile vV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ClassLoader classLoader, DexFile dexFile) {
        super(classLoader);
        this.vV = dexFile;
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String str) {
        Class<?> loadClass = this.vV.loadClass(str, this);
        if (loadClass == null && str.startsWith("com.baidu.adp.plugin.PluginPatchAnnotation")) {
            return Class.forName(str);
        }
        if (loadClass == null) {
            throw new ClassNotFoundException(str);
        }
        return loadClass;
    }
}
