package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a extends f {
        void cA();

        void cB();

        String d(h<?> hVar);
    }

    /* loaded from: classes.dex */
    public interface b extends f {
        void cC();

        void cD();

        String e(h<?> hVar);

        String f(h<?> hVar);

        void release();
    }

    boolean cz();

    int getMaxSize();
}
