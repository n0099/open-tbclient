package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class p<T> extends e<T> {
    protected final c<T> fC;

    public p(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.fC = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public m<T> A(String str) {
        return this.fC.t(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(m<T> mVar) {
        this.fC.b(mVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void B(String str) {
        this.fC.u(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void C(String str) {
        this.fC.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void E(String str) {
        this.fC.x(str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void F(String str) {
        if (this.fr instanceof h) {
            com.baidu.adp.lib.g.k.el().b(new q(this, str));
        }
        if (this.fr instanceof g) {
            com.baidu.adp.lib.g.k.el().b(new r(this, str));
        }
    }

    public c<T> cq() {
        return this.fC;
    }
}
