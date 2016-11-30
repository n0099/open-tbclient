package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface o<T> {

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
        public T lp;
        public long mi;
        public long my;
    }

    /* loaded from: classes.dex */
    public interface d<T> extends o<T> {
        String dD();

        n<T> dE();

        void dF();
    }

    c<T> T(String str);

    void U(String str);

    void a(String str, a<T> aVar);

    void a(String str, b<T> bVar);

    void a(String str, T t, long j);

    void b(String str, T t, long j);

    T get(String str);

    void k(String str, T t);

    void l(String str, T t);

    void remove(String str);
}
