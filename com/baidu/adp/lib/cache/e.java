package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface e {

    /* loaded from: classes.dex */
    public interface a extends e {
        String d(g<?> gVar);

        void eK();

        void eL();
    }

    /* loaded from: classes.dex */
    public interface b extends e {
        String e(g<?> gVar);

        void eM();

        void eN();

        String f(g<?> gVar);

        void release();
    }

    boolean eJ();

    int getMaxSize();
}
