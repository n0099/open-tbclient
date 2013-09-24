package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class t<T> implements s<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final p<T> f389a;
    protected final String b;

    public t(String str, p<T> pVar) {
        this.b = str;
        this.f389a = pVar;
    }

    @Override // com.baidu.adp.lib.cache.q
    public T a(String str) {
        return this.f389a.c(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.q
    public r<T> b(String str) {
        return this.f389a.d(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.q
    public void a(String str, T t, long j) {
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (currentTimeMillis <= System.currentTimeMillis()) {
            c(str);
        } else {
            this.f389a.a(this.b, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.q
    public void c(String str) {
        this.f389a.e(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.q
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.d.b.a().a(new u(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.s
    public p<T> a() {
        return this.f389a;
    }

    public void b() {
        this.f389a.d(this.b);
    }
}
