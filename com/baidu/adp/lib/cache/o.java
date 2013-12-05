package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class o<T> extends e<T> {
    protected final c<T> c;

    public o(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.c = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public m<T> a(String str) {
        return this.c.c(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void a(m<T> mVar) {
        this.c.b(mVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void b(String str) {
        this.c.d(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void c(String str) {
        this.c.a(str, true);
    }

    @Override // com.baidu.adp.lib.cache.r
    public void d(String str) {
        this.c.e(str);
    }

    @Override // com.baidu.adp.lib.cache.r
    public void e(String str) {
        if (this.b instanceof h) {
            com.baidu.adp.lib.f.c.a().a(new p(this, str));
        }
        if (this.b instanceof g) {
            com.baidu.adp.lib.f.c.a().a(new q(this, str));
        }
    }

    public c<T> b() {
        return this.c;
    }
}
