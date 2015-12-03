package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface o<T> {

    /* loaded from: classes.dex */
    public interface a<T> {
        void onItemGet(String str, T t);
    }

    /* loaded from: classes.dex */
    public static class b<T> {
        public String key;
        public T sm;
        public long tf;
        public long tw;
    }

    /* loaded from: classes.dex */
    public interface c<T> extends o<T> {
        String gm();

        n<T> gn();

        void go();
    }

    void a(String str, a<T> aVar);

    void a(String str, T t, long j);

    b<T> aa(String str);

    void ab(String str);

    void b(String str, T t, long j);

    void f(String str, T t);

    void g(String str, T t);

    T get(String str);

    void remove(String str);
}
