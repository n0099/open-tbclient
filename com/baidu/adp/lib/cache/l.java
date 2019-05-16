package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface l<T> {

    /* loaded from: classes.dex */
    public interface a<T> {
        void h(String str, T t);
    }

    /* loaded from: classes.dex */
    public static class b<T> {
        public String key;
        public T value;
        public long yH;
        public long yu;
    }

    /* loaded from: classes.dex */
    public interface c<T> extends l<T> {
        String hs();

        k<T> ht();

        void hu();
    }

    void a(String str, a<T> aVar);

    void a(String str, T t, long j);

    b<T> ap(String str);

    void aq(String str);

    void b(String str, T t, long j);

    void f(String str, T t);

    void g(String str, T t);

    T get(String str);

    void remove(String str);
}
