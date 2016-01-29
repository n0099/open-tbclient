package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a extends f {
        String d(h<?> hVar);

        void gm();

        void gn();
    }

    /* loaded from: classes.dex */
    public interface b extends f {
        String e(h<?> hVar);

        String f(h<?> hVar);

        void go();

        void gp();

        void release();
    }

    int getMaxSize();

    boolean gl();
}
