package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface o<T> {

    /* loaded from: classes.dex */
    public interface a<T> {
        void g(String str, T t);
    }

    /* loaded from: classes.dex */
    public static class b<T> {
        public T iz;
        public long jE;
        public long jp;
        public String key;
    }

    /* loaded from: classes.dex */
    public interface c<T> extends o<T> {
        String cI();

        n<T> cJ();

        void cK();
    }

    b<T> Q(String str);

    void R(String str);

    void a(String str, a<T> aVar);

    void a(String str, T t, long j);

    void b(String str, T t, long j);

    void e(String str, T t);

    void f(String str, T t);

    T get(String str);

    void remove(String str);
}
