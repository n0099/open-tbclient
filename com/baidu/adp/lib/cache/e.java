package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface e {

    /* loaded from: classes.dex */
    public interface a extends e {
        String d(g<?> gVar);

        void it();

        void iu();
    }

    /* loaded from: classes.dex */
    public interface b extends e {
        String e(g<?> gVar);

        String f(g<?> gVar);

        void iv();

        void iw();

        void release();
    }

    int getMaxSize();

    boolean is();
}
