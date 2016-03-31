package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface o<T> {

    /* loaded from: classes.dex */
    public interface a<T> {
        void g(String str, T t);
    }

    /* loaded from: classes.dex */
    public static class b<T> {
        public String key;
        public T sI;
        public long tB;
        public long tQ;
    }

    /* loaded from: classes.dex */
    public interface c<T> extends o<T> {
        String gu();

        n<T> gv();

        void gw();
    }

    b<T> Z(String str);

    void a(String str, a<T> aVar);

    void a(String str, T t, long j);

    void aa(String str);

    void b(String str, T t, long j);

    void e(String str, T t);

    void f(String str, T t);

    T get(String str);

    void remove(String str);
}
