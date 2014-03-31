package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public final class y<T> extends v<T> {
    public y(String str, r<T> rVar) {
        super(str, rVar);
    }

    @Override // com.baidu.adp.lib.cache.v, com.baidu.adp.lib.cache.s
    public final T a(String str) {
        try {
            return (T) super.a(str);
        } catch (Throwable th) {
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.a(getClass(), "failed to get cache:" + str, th);
            }
            return null;
        }
    }

    @Override // com.baidu.adp.lib.cache.v, com.baidu.adp.lib.cache.s
    public final t<T> b(String str) {
        try {
            return super.b(str);
        } catch (Throwable th) {
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.a(getClass(), "failed to get cache:" + str, th);
            }
            return null;
        }
    }

    @Override // com.baidu.adp.lib.cache.v, com.baidu.adp.lib.cache.s
    public final void a(String str, T t, long j) {
        try {
            super.a(str, t, j);
        } catch (Throwable th) {
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.a(getClass(), "failed to store cache key:" + str + ", value:" + t, th);
            }
        }
    }

    @Override // com.baidu.adp.lib.cache.v, com.baidu.adp.lib.cache.s
    public final void c(String str) {
        try {
            super.c(str);
        } catch (Throwable th) {
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.a(getClass(), "failed to remove cache:" + str, th);
            }
        }
    }
}
