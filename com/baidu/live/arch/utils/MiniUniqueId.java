package com.baidu.live.arch.utils;
/* loaded from: classes2.dex */
public class MiniUniqueId {
    public static final int MIN_ID = 1000000;
    public static volatile int sBaseId;
    public int mId = 0;

    public static synchronized MiniUniqueId gen() {
        MiniUniqueId miniUniqueId;
        synchronized (MiniUniqueId.class) {
            if (sBaseId < 1000000) {
                sBaseId = 1000000;
            }
            miniUniqueId = new MiniUniqueId();
            miniUniqueId.mId = sBaseId;
            sBaseId++;
        }
        return miniUniqueId;
    }

    public int getId() {
        return this.mId;
    }
}
