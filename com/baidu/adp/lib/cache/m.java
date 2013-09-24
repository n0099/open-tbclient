package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class m<T> extends c<T> {
    protected final a<T> c;

    public m(a<T> aVar, d dVar, boolean z) {
        super(dVar, z);
        this.c = aVar;
    }

    @Override // com.baidu.adp.lib.cache.c
    public k<T> a(String str) {
        return this.c.b(str);
    }

    @Override // com.baidu.adp.lib.cache.c
    public void a(k<T> kVar) {
        this.c.b(kVar);
    }

    @Override // com.baidu.adp.lib.cache.c
    public void b(String str) {
        this.c.c(str);
    }

    @Override // com.baidu.adp.lib.cache.c
    protected void c(String str) {
        this.c.a(str, true);
    }

    @Override // com.baidu.adp.lib.cache.p
    public void d(String str) {
        if (this.b instanceof f) {
            com.baidu.adp.lib.d.b.a().a(new n(this, str));
        }
        if (this.b instanceof e) {
            com.baidu.adp.lib.d.b.a().a(new o(this, str));
        }
    }
}
