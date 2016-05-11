package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> jt;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.jt = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> K(String str) {
        return this.jt.F(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.jt.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void L(String str) {
        this.jt.G(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void M(String str) {
        this.jt.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void O(String str) {
        this.jt.H(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void P(String str) {
        if (this.ji instanceof f.b) {
            com.baidu.adp.lib.h.k.dM().c(new l(this, str));
        }
        if (this.ji instanceof f.a) {
            com.baidu.adp.lib.h.k.dM().c(new m(this, str));
        }
    }

    public c<T> cF() {
        return this.jt;
    }
}
