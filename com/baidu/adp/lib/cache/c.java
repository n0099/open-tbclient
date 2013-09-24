package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public abstract class c<T> implements p<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final boolean f381a;
    protected final d b;

    public abstract k<T> a(String str);

    public abstract void a(k<T> kVar);

    public abstract void b(String str);

    protected abstract void c(String str);

    public c(d dVar, boolean z) {
        this.b = dVar;
        this.f381a = z;
    }

    protected String a(String str, String str2) {
        if (this.f381a) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected k<T> b(String str, String str2) {
        String a2 = a(str, str2);
        k<T> a3 = a(a2);
        if (a3 == null) {
            if (com.baidu.adp.lib.f.d.a()) {
                com.baidu.adp.lib.f.d.e("cache", "get", "cache miss:" + a2);
                return null;
            }
            return null;
        } else if (a3.f < System.currentTimeMillis()) {
            c(a2);
            if (com.baidu.adp.lib.f.d.a()) {
                com.baidu.adp.lib.f.d.e("cache", "get", "cache miss on expired:" + a2);
                return null;
            }
            return null;
        } else {
            if (this.b.b()) {
                a3.e = System.currentTimeMillis();
                a(a3);
            }
            if (com.baidu.adp.lib.f.d.a()) {
                com.baidu.adp.lib.f.d.e("cache", "get", "cache hit:" + a2);
            }
            return a3;
        }
    }

    @Override // com.baidu.adp.lib.cache.p
    public T c(String str, String str2) {
        k<T> b = b(str, str2);
        if (b == null) {
            return null;
        }
        return b.b;
    }

    @Override // com.baidu.adp.lib.cache.p
    public r<T> d(String str, String str2) {
        k<T> b = b(str, str2);
        if (b == null) {
            return null;
        }
        r<T> rVar = new r<>();
        rVar.f388a = b.b;
        rVar.c = b.f;
        rVar.b = b.d;
        return rVar;
    }

    @Override // com.baidu.adp.lib.cache.p
    public void a(String str, String str2, T t, long j) {
        k<T> kVar = new k<>();
        kVar.f384a = a(str, str2);
        kVar.c = str;
        kVar.f = j;
        kVar.b = t;
        kVar.e = System.currentTimeMillis();
        kVar.d = System.currentTimeMillis();
        a(kVar);
    }

    @Override // com.baidu.adp.lib.cache.p
    public void e(String str, String str2) {
        b(a(str, str2));
    }
}
