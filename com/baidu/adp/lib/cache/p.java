package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class p<T> extends e<T> {
    protected final c<T> hG;

    public p(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.hG = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public m<T> O(String str) {
        return this.hG.J(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(m<T> mVar) {
        this.hG.b(mVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void P(String str) {
        this.hG.K(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void Q(String str) {
        this.hG.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void S(String str) {
        this.hG.L(str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void T(String str) {
        if (this.hv instanceof h) {
            com.baidu.adp.lib.g.l.ek().c(new q(this, str));
        }
        if (this.hv instanceof g) {
            com.baidu.adp.lib.g.l.ek().c(new r(this, str));
        }
    }

    public c<T> cP() {
        return this.hG;
    }
}
