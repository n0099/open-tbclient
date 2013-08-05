package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class s implements r {

    /* renamed from: a  reason: collision with root package name */
    protected final p f378a;
    protected final String b;

    public s(String str, p pVar) {
        this.b = str;
        this.f378a = pVar;
    }

    @Override // com.baidu.adp.lib.cache.q
    public Object a(String str) {
        return this.f378a.c(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.q
    public void a(String str, Object obj, long j) {
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (currentTimeMillis <= System.currentTimeMillis()) {
            b(str);
        } else {
            this.f378a.a(this.b, str, obj, currentTimeMillis);
        }
    }

    public void b(String str) {
        this.f378a.d(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.r
    public p a() {
        return this.f378a;
    }

    public void b() {
        this.f378a.d(this.b);
    }
}
