package com.baidu.adp;
/* loaded from: classes.dex */
public class BdUniqueId {
    private static final int MIN_ID = 1000000;
    private static volatile int sBaseId = 0;
    private int mId = 0;

    private BdUniqueId() {
    }

    public static synchronized BdUniqueId gen() {
        BdUniqueId bdUniqueId;
        synchronized (BdUniqueId.class) {
            if (sBaseId < 1000000) {
                sBaseId = 1000000;
            }
            bdUniqueId = new BdUniqueId();
            bdUniqueId.mId = sBaseId;
            sBaseId++;
        }
        return bdUniqueId;
    }

    public int getId() {
        return this.mId;
    }
}
