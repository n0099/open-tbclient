package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class v<T> extends t<T> {
    public v(String str, p<T> pVar) {
        super(str, pVar);
    }

    @Override // com.baidu.adp.lib.cache.t, com.baidu.adp.lib.cache.q
    public T a(String str) {
        try {
            return (T) super.a(str);
        } catch (Throwable th) {
            if (com.baidu.adp.lib.f.d.a()) {
                com.baidu.adp.lib.f.d.a(getClass(), "failed to get cache:" + str, th);
            }
            return null;
        }
    }

    @Override // com.baidu.adp.lib.cache.t, com.baidu.adp.lib.cache.q
    public r<T> b(String str) {
        try {
            return super.b(str);
        } catch (Throwable th) {
            if (com.baidu.adp.lib.f.d.a()) {
                com.baidu.adp.lib.f.d.a(getClass(), "failed to get cache:" + str, th);
            }
            return null;
        }
    }

    @Override // com.baidu.adp.lib.cache.t, com.baidu.adp.lib.cache.q
    public void a(String str, T t, long j) {
        try {
            super.a(str, t, j);
        } catch (Throwable th) {
            if (com.baidu.adp.lib.f.d.a()) {
                com.baidu.adp.lib.f.d.a(getClass(), "failed to store cache key:" + str + ", value:" + t, th);
            }
        }
    }

    @Override // com.baidu.adp.lib.cache.t, com.baidu.adp.lib.cache.q
    public void c(String str) {
        try {
            super.c(str);
        } catch (Throwable th) {
            if (com.baidu.adp.lib.f.d.a()) {
                com.baidu.adp.lib.f.d.a(getClass(), "failed to remove cache:" + str, th);
            }
        }
    }
}
