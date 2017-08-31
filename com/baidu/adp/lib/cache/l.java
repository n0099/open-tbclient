package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface l<T> {

    /* loaded from: classes.dex */
    public interface a<T> {
        void g(String str, T t);
    }

    /* loaded from: classes.dex */
    public static class b<T> {
        public String key;
        public T rY;
        public long sS;
        public long ti;
    }

    /* loaded from: classes.dex */
    public interface c<T> extends l<T> {
        String eH();

        k<T> eI();

        void eJ();
    }

    b<T> W(String str);

    void X(String str);

    void a(String str, a<T> aVar);

    void a(String str, T t, long j);

    void b(String str, T t, long j);

    void e(String str, T t);

    void f(String str, T t);

    T get(String str);

    void remove(String str);
}
