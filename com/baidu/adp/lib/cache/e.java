package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface e {

    /* loaded from: classes.dex */
    public interface a extends e {
        String d(g<?> gVar);

        void id();

        void ie();
    }

    /* loaded from: classes.dex */
    public interface b extends e {
        String e(g<?> gVar);

        String f(g<?> gVar);

        /* renamed from: if  reason: not valid java name */
        void mo10if();

        void ig();

        void release();
    }

    int getMaxSize();

    boolean ic();
}
