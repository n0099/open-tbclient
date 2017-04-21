package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a extends f {
        String d(h<?> hVar);

        void eC();

        void eD();
    }

    /* loaded from: classes.dex */
    public interface b extends f {
        String e(h<?> hVar);

        void eE();

        void eF();

        String f(h<?> hVar);

        void release();
    }

    boolean eB();

    int getMaxSize();
}
