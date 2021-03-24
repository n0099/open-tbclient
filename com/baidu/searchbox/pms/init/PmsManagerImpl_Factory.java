package com.baidu.searchbox.pms.init;
/* loaded from: classes3.dex */
public class PmsManagerImpl_Factory {
    public static volatile PmsManagerImpl instance;

    public static synchronized PmsManagerImpl get() {
        PmsManagerImpl pmsManagerImpl;
        synchronized (PmsManagerImpl_Factory.class) {
            if (instance == null) {
                instance = new PmsManagerImpl();
            }
            pmsManagerImpl = instance;
        }
        return pmsManagerImpl;
    }
}
