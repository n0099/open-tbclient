package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface e {

    /* loaded from: classes.dex */
    public interface a extends e {
        String d(g<?> gVar);

        void finishEvict();

        void startEvict();
    }

    /* loaded from: classes.dex */
    public interface b extends e {
        String e(g<?> gVar);

        String f(g<?> gVar);

        void finishInit();

        void release();

        void startInit();
    }

    int getMaxSize();

    boolean shouldUpdateLastHitTime();
}
