package com.baidu.android.bdutil.cuid.api;
/* loaded from: classes20.dex */
public class IAppCuidManagerImpl_Factory {
    private static volatile IAppCuidManagerImpl instance;

    private IAppCuidManagerImpl_Factory() {
    }

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
