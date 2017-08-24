package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface l<T> {

    /* loaded from: classes.dex */
    public interface a<T> {
        void m(String str, T t);
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        void a(String str, c<T> cVar);
    }

    /* loaded from: classes.dex */
    public static class c<T> {
        public String key;
        public T up;
        public long vg;
        public long vv;
    }

    /* loaded from: classes.dex */
    public interface d<T> extends l<T> {
        String eS();

        k<T> eT();

        void eU();
    }

    void a(String str, a<T> aVar);

    void a(String str, b<T> bVar);

    void a(String str, T t, long j);

    c<T> ad(String str);

    void ae(String str);

    void b(String str, T t, long j);

    T get(String str);

    void k(String str, T t);

    void l(String str, T t);

    void remove(String str);
}
