package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class v<T> implements u<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final r<T> f438a;
    protected final String b;

    public v(String str, r<T> rVar) {
        this.b = str;
        this.f438a = rVar;
    }

    @Override // com.baidu.adp.lib.cache.s
    public T a(String str) {
        return this.f438a.c(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public t<T> b(String str) {
        return this.f438a.d(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void a(String str, T t, long j) {
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (currentTimeMillis <= System.currentTimeMillis()) {
            c(str);
        } else {
            this.f438a.a(this.b, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.s
    public void a(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void c(String str) {
        this.f438a.e(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.f.c.a().a(new w(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.u
    public r<T> a() {
        return this.f438a;
    }

    public void b() {
        this.f438a.d(this.b);
    }
}
