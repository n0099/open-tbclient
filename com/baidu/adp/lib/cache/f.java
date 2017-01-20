package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a extends f {
        String d(h<?> hVar);

        void dt();

        void du();
    }

    /* loaded from: classes.dex */
    public interface b extends f {
        void dv();

        void dw();

        String e(h<?> hVar);

        String f(h<?> hVar);

        void release();
    }

    boolean ds();

    int getMaxSize();
}
