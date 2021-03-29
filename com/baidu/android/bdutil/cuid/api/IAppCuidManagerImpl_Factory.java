package com.baidu.android.bdutil.cuid.api;
/* loaded from: classes.dex */
public class IAppCuidManagerImpl_Factory {
    public static volatile IAppCuidManagerImpl instance;

    public static synchronized IAppCuidManagerImpl get() {
        IAppCuidManagerImpl iAppCuidManagerImpl;
        synchronized (IAppCuidManagerImpl_Factory.class) {
            if (instance == null) {
                instance = new IAppCuidManagerImpl();
            }
            iAppCuidManagerImpl = instance;
        }
        return iAppCuidManagerImpl;
    }
}
