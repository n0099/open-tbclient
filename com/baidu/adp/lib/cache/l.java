package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface l<T> {

    /* loaded from: classes.dex */
    public interface a<T> {
        void g(String str, T t);
    }

    /* loaded from: classes.dex */
    public static class b<T> {
        public long AM;
        public long Ba;
        public String key;
        public T value;
    }

    /* loaded from: classes.dex */
    public interface c<T> extends l<T> {
        String iA();

        k<T> iB();

        void iC();
    }

    void a(String str, a<T> aVar);

    void a(String str, T t, long j);

    b<T> aF(String str);

    void aG(String str);

    void b(String str, T t, long j);

    void e(String str, T t);

    void f(String str, T t);

    T get(String str);

    void remove(String str);
}
