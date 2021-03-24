package com.baidu.adp;

import java.io.Serializable;
/* loaded from: classes.dex */
public class BdUniqueId implements Serializable {
    public static final int MIN_ID = 1000000;
    public static volatile int sBaseId;
    public int mId = 0;

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
