package com.baidu.adp.plugin;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import dalvik.system.DexClassLoader;
/* loaded from: classes.dex */
public class d extends DexClassLoader {
    private ClassLoader CN;

    public d(String str, String str2, String str3, ClassLoader classLoader, ClassLoader classLoader2) {
        super(str, str2, str3, classLoader);
        this.CN = null;
        this.CN = classLoader2;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str) {
        try {
            return super.findClass(str);
        } catch (Exception e) {
            if (this.CN == null) {
                return null;
            }
            Class<?> loadClass = this.CN.loadClass(str);
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("findClass from container. classname is " + str);
                return loadClass;
            }
            return loadClass;
        }
    }
}
