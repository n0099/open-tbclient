package com.baidu.searchbox.util;
/* loaded from: classes4.dex */
public class KVStorageProxyImpl_Factory {
    public static volatile KVStorageProxyImpl instance;

    public static synchronized KVStorageProxyImpl get() {
        KVStorageProxyImpl kVStorageProxyImpl;
        synchronized (KVStorageProxyImpl_Factory.class) {
            if (instance == null) {
                instance = new KVStorageProxyImpl();
            }
            kVStorageProxyImpl = instance;
        }
        return kVStorageProxyImpl;
    }
}
