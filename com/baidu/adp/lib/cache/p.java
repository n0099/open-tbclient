package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
public class p<T> extends e<T> {
    protected final c<T> tc;

    public p(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.tc = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public m<T> V(String str) {
        return this.tc.Q(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(m<T> mVar) {
        this.tc.b(mVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void W(String str) {
        this.tc.R(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void X(String str) {
        this.tc.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void Z(String str) {
        this.tc.S(str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void aa(String str) {
        if (this.sQ instanceof h) {
            com.baidu.adp.lib.g.l.hJ().c(new q(this, str));
        }
        if (this.sQ instanceof g) {
            com.baidu.adp.lib.g.l.hJ().c(new r(this, str));
        }
    }

    public c<T> go() {
        return this.tc;
    }
}
