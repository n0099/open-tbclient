package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public interface a extends f {
        String d(h<?> hVar);

        void ge();

        void gf();
    }

    /* loaded from: classes.dex */
    public interface b extends f {
        String e(h<?> hVar);

        String f(h<?> hVar);

        void gg();

        void gh();

        void release();
    }

    boolean gd();

    int getMaxSize();
}
