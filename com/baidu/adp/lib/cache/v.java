package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class v<T> implements u<T> {
    protected final r<T> a;
    protected final String b;

    public v(String str, r<T> rVar) {
        this.b = str;
        this.a = rVar;
    }

    @Override // com.baidu.adp.lib.cache.s
    public T a(String str) {
        return this.a.c(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public t<T> b(String str) {
        return this.a.d(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void a(String str, T t, long j) {
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (currentTimeMillis <= System.currentTimeMillis()) {
            c(str);
        } else {
            this.a.a(this.b, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.s
    public void a(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void c(String str) {
        this.a.e(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.f.d.a().a(new w(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.s
    public void d(String str) {
        com.baidu.adp.lib.f.d.a().a(new x(this, str));
    }

    @Override // com.baidu.adp.lib.cache.u
    public String a() {
        return this.b;
    }

    @Override // com.baidu.adp.lib.cache.u
    public r<T> b() {
        return this.a;
    }

    public void d() {
        this.a.e(this.b);
    }

    protected void e() {
        f a = b().a();
        if (a instanceof h) {
            ((h) a).e();
        }
    }

    @Override // com.baidu.adp.lib.cache.u
    public void c() {
        this.a.d(this.b);
        e();
    }
}
