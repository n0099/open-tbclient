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
        public T sG;
        public long tO;
        public long tz;
    }

    /* loaded from: classes.dex */
    public interface d<T> extends o<T> {
        String eJ();

        n<T> eK();

        void eL();
    }

    c<T> U(String str);

    void V(String str);

    void a(String str, a<T> aVar);

    void a(String str, b<T> bVar);

    void a(String str, T t, long j);

    void b(String str, T t, long j);

    T get(String str);

    void k(String str, T t);

    void l(String str, T t);

    void remove(String str);
}
