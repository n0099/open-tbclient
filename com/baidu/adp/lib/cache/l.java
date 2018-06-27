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
        public T value;
        public long xL;
        public long xY;
    }

    /* loaded from: classes.dex */
    public interface c<T> extends l<T> {
        String hg();

        k<T> hh();

        void hi();
    }

    void a(String str, a<T> aVar);

    void a(String str, T t, long j);

    b<T> an(String str);

    void ao(String str);

    void b(String str, T t, long j);

    void e(String str, T t);

    void f(String str, T t);

    T get(String str);

    void remove(String str);
}
