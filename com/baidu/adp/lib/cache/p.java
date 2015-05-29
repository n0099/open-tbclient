package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class p<T> extends e<T> {
    protected final c<T> tn;

    public p(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.tn = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public m<T> X(String str) {
        return this.tn.S(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(m<T> mVar) {
        this.tn.b(mVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void Y(String str) {
        this.tn.T(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void Z(String str) {
        this.tn.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void ab(String str) {
        this.tn.U(str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void ac(String str) {
        if (this.tc instanceof h) {
            com.baidu.adp.lib.g.l.ht().c(new q(this, str));
        }
        if (this.tc instanceof g) {
            com.baidu.adp.lib.g.l.ht().c(new r(this, str));
        }
    }

    public c<T> gs() {
        return this.tn;
    }
}
