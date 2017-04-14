package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a extends f {
        String d(h<?> hVar);

        void eB();

        void eC();
    }

    /* loaded from: classes.dex */
    public interface b extends f {
        String e(h<?> hVar);

        void eD();

        void eE();

        String f(h<?> hVar);

        void release();
    }

    boolean eA();

    int getMaxSize();
}
