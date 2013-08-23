package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class t implements s {

    /* renamed from: a  reason: collision with root package name */
    protected final p f385a;
    protected final String b;

    public t(String str, p pVar) {
        this.b = str;
        this.f385a = pVar;
    }

    @Override // com.baidu.adp.lib.cache.q
    public Object a(String str) {
        return this.f385a.c(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.q
    public r b(String str) {
        return this.f385a.d(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.q
    public void a(String str, Object obj, long j) {
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (currentTimeMillis <= System.currentTimeMillis()) {
            c(str);
        } else {
            this.f385a.a(this.b, str, obj, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.q
    public void c(String str) {
        this.f385a.e(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.q
    public void b(String str, Object obj, long j) {
        com.baidu.adp.lib.e.f.a().a(new u(this, str, obj, j));
    }

    @Override // com.baidu.adp.lib.cache.s
    public p a() {
        return this.f385a;
    }

    public void b() {
        this.f385a.d(this.b);
    }
}
