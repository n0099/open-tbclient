package com.baidu.adp.plugin;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import dalvik.system.DexClassLoader;
/* loaded from: classes.dex */
public class a extends DexClassLoader {
    private ClassLoader tF;

    public a(String str, String str2, String str3, ClassLoader classLoader, ClassLoader classLoader2) {
        super(str, str2, str3, classLoader);
        this.tF = null;
        this.tF = classLoader2;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        try {
            return super.findClass(str);
        } catch (Exception e) {
            if (this.tF == null) {
                return null;
            }
            Class<?> loadClass = this.tF.loadClass(str);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("findClass from container. classname is " + str);
                return loadClass;
            }
            return loadClass;
        }
    }
}
