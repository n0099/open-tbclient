package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public abstract class e<T> implements r<T> {
    protected final boolean a;
    protected final f b;

    public abstract m<T> a(String str);

    public abstract void a(m<T> mVar);

    public abstract void b(String str);

    protected abstract void c(String str);

    public e(f fVar, boolean z) {
        this.b = fVar;
        this.a = z;
    }

    private String d(String str, String str2) {
        if (this.a) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    private m<T> e(String str, String str2) {
        String d = d(str, str2);
        m<T> a = a(d);
        if (a == null) {
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.e("cache", "get", "cache miss:" + d);
                return null;
            }
            return null;
        } else if (a.f < System.currentTimeMillis()) {
            c(d);
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.e("cache", "get", "cache miss on expired:" + d);
                return null;
            }
            return null;
        } else {
            if (this.b.b()) {
                a.e = System.currentTimeMillis();
                a(a);
            }
            if (com.baidu.adp.lib.util.f.a()) {
                com.baidu.adp.lib.util.f.e("cache", "get", "cache hit:" + d);
            }
            return a;
        }
    }

    @Override // com.baidu.adp.lib.cache.r
    public final T a(String str, String str2) {
        m<T> e = e(str, str2);
        if (e == null) {
            return null;
        }
        return e.b;
    }

    @Override // com.baidu.adp.lib.cache.r
    public final t<T> b(String str, String str2) {
        m<T> e = e(str, str2);
        if (e == null) {
            return null;
        }
        t<T> tVar = new t<>();
        tVar.a = str2;
        tVar.b = e.b;
        tVar.d = e.f;
        tVar.c = e.d;
        return tVar;
    }

    @Override // com.baidu.adp.lib.cache.r
    public final void a(String str, String str2, T t, long j) {
        m<T> mVar = new m<>();
        mVar.a = d(str, str2);
        mVar.c = str;
        mVar.f = j;
        mVar.b = t;
        mVar.e = System.currentTimeMillis();
        mVar.d = System.currentTimeMillis();
        a(mVar);
    }

    @Override // com.baidu.adp.lib.cache.r
    public final void c(String str, String str2) {
        b(d(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.r
    public final f a() {
        return this.b;
    }
}
