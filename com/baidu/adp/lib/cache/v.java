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
        return this.a.a(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public t<T> b(String str) {
        return this.a.b(this.b, str);
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
    public final void a(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void c(String str) {
        this.a.c(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public final void b(String str, T t, long j) {
        com.baidu.adp.lib.f.d.a();
        com.baidu.adp.lib.f.d.a(new w(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.s
    public final void d(String str) {
        com.baidu.adp.lib.f.d.a();
        com.baidu.adp.lib.f.d.a(new x(this, str));
    }

    @Override // com.baidu.adp.lib.cache.u
    public final String a() {
        return this.b;
    }

    @Override // com.baidu.adp.lib.cache.u
    public final r<T> b() {
        return this.a;
    }

    public final void d() {
        this.a.e(this.b);
    }

    @Override // com.baidu.adp.lib.cache.u
    public final void c() {
        this.a.d(this.b);
        f a = this.a.a();
        if (a instanceof h) {
            ((h) a).c();
        }
    }
}
