package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> jr;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.jr = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> K(String str) {
        return this.jr.F(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.jr.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void L(String str) {
        this.jr.G(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void M(String str) {
        this.jr.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void O(String str) {
        this.jr.H(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void P(String str) {
        if (this.jg instanceof f.b) {
            com.baidu.adp.lib.h.k.dN().c(new l(this, str));
        }
        if (this.jg instanceof f.a) {
            com.baidu.adp.lib.h.k.dN().c(new m(this, str));
        }
    }

    public c<T> cG() {
        return this.jr;
    }
}
