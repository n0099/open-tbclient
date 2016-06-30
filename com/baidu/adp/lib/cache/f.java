package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a extends f {
        void cB();

        void cC();

        String d(h<?> hVar);
    }

    /* loaded from: classes.dex */
    public interface b extends f {
        void cD();

        void cE();

        String e(h<?> hVar);

        String f(h<?> hVar);

        void release();
    }

    boolean cA();

    int getMaxSize();
}
