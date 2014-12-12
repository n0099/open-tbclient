package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class p<T> extends e<T> {
    protected final c<T> hE;

    public p(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.hE = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public m<T> O(String str) {
        return this.hE.J(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(m<T> mVar) {
        this.hE.b(mVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void P(String str) {
        this.hE.K(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void Q(String str) {
        this.hE.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void S(String str) {
        this.hE.L(str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void T(String str) {
        if (this.ht instanceof h) {
            com.baidu.adp.lib.g.l.em().c(new q(this, str));
        }
        if (this.ht instanceof g) {
            com.baidu.adp.lib.g.l.em().c(new r(this, str));
        }
    }

    public c<T> cR() {
        return this.hE;
    }
}
