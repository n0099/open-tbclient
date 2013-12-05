package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public abstract class e<T> implements r<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final boolean f430a;
    protected final f b;

    public abstract m<T> a(String str);

    public abstract void a(m<T> mVar);

    public abstract void b(String str);

    protected abstract void c(String str);

    public e(f fVar, boolean z) {
        this.b = fVar;
        this.f430a = z;
    }

    protected String a(String str, String str2) {
        if (this.f430a) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected m<T> b(String str, String str2) {
        String a2 = a(str, str2);
        m<T> a3 = a(a2);
        if (a3 == null) {
            if (com.baidu.adp.lib.h.e.a()) {
                com.baidu.adp.lib.h.e.e("cache", "get", "cache miss:" + a2);
                return null;
            }
            return null;
        } else if (a3.f < System.currentTimeMillis()) {
            c(a2);
            if (com.baidu.adp.lib.h.e.a()) {
                com.baidu.adp.lib.h.e.e("cache", "get", "cache miss on expired:" + a2);
                return null;
            }
            return null;
        } else {
            if (this.b.b()) {
                a3.e = System.currentTimeMillis();
                a(a3);
            }
            if (com.baidu.adp.lib.h.e.a()) {
                com.baidu.adp.lib.h.e.e("cache", "get", "cache hit:" + a2);
            }
            return a3;
        }
    }

    @Override // com.baidu.adp.lib.cache.r
    public T c(String str, String str2) {
        m<T> b = b(str, str2);
        if (b == null) {
            return null;
        }
        return b.b;
    }

    @Override // com.baidu.adp.lib.cache.r
    public t<T> d(String str, String str2) {
        m<T> b = b(str, str2);
        if (b == null) {
            return null;
        }
        t<T> tVar = new t<>();
        tVar.f437a = str2;
        tVar.b = b.b;
        tVar.d = b.f;
        tVar.c = b.d;
        return tVar;
    }

    @Override // com.baidu.adp.lib.cache.r
    public void a(String str, String str2, T t, long j) {
        m<T> mVar = new m<>();
        mVar.f433a = a(str, str2);
        mVar.c = str;
        mVar.f = j;
        mVar.b = t;
        mVar.e = System.currentTimeMillis();
        mVar.d = System.currentTimeMillis();
        a(mVar);
    }

    @Override // com.baidu.adp.lib.cache.r
    public void e(String str, String str2) {
        b(a(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.r
    public f a() {
        return this.b;
    }
}
