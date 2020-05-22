package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public interface l<T> {

    /* loaded from: classes.dex */
    public interface a<T> {
        void onItemGet(String str, T t);
    }

    /* loaded from: classes.dex */
    public static class b<T> {
        public String key;
        public long lastSaveTime;
        public long timeToExpire;
        public T value;
    }

    /* loaded from: classes.dex */
    public interface c<T> extends l<T> {
        void clearAndClose();

        String getNameSpace();

        k<T> kh();
    }

    void a(String str, a<T> aVar);

    void asyncRemove(String str);

    void asyncSet(String str, T t, long j);

    void asyncSetForever(String str, T t);

    b<T> bt(String str);

    T get(String str);

    void remove(String str);

    void set(String str, T t, long j);

    void setForever(String str, T t);
}
