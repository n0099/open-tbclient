package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface e {

    /* loaded from: classes.dex */
    public interface a extends e {
        String d(g<?> gVar);

        void eh();

        void ei();
    }

    /* loaded from: classes.dex */
    public interface b extends e {
        String e(g<?> gVar);

        void ej();

        void ek();

        String f(g<?> gVar);

        void release();
    }

    boolean eg();

    int getMaxSize();
}
