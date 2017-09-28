package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface e {

    /* loaded from: classes.dex */
    public interface a extends e {
        String d(g<?> gVar);

        void ey();

        void ez();
    }

    /* loaded from: classes.dex */
    public interface b extends e {
        String e(g<?> gVar);

        void eA();

        void eB();

        String f(g<?> gVar);

        void release();
    }

    boolean ex();

    int getMaxSize();
}
