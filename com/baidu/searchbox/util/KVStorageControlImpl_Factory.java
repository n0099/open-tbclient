package com.baidu.searchbox.util;
/* loaded from: classes2.dex */
public class KVStorageControlImpl_Factory {
    public static volatile KVStorageControlImpl instance;

    public static synchronized KVStorageControlImpl get() {
        KVStorageControlImpl kVStorageControlImpl;
        synchronized (KVStorageControlImpl_Factory.class) {
            if (instance == null) {
                instance = new KVStorageControlImpl();
            }
            kVStorageControlImpl = instance;
        }
        return kVStorageControlImpl;
    }
}
