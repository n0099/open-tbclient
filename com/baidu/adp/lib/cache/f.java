package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a extends f {
        String d(h<?> hVar);

        void dv();

        void dw();
    }

    /* loaded from: classes.dex */
    public interface b extends f {
        void dx();

        void dy();

        String e(h<?> hVar);

        String f(h<?> hVar);

        void release();
    }

    boolean du();

    int getMaxSize();
}
