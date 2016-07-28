package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> jT;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.jT = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> M(String str) {
        return this.jT.H(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.jT.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void N(String str) {
        this.jT.I(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void O(String str) {
        this.jT.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void Q(String str) {
        this.jT.J(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void R(String str) {
        if (this.jI instanceof f.b) {
            com.baidu.adp.lib.h.k.dM().f(new l(this, str));
        }
        if (this.jI instanceof f.a) {
            com.baidu.adp.lib.h.k.dM().f(new m(this, str));
        }
    }

    public c<T> cF() {
        return this.jT;
    }
}
