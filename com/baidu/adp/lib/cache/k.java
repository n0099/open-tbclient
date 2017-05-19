package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> tE;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.tE = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> J(String str) {
        return this.tE.E(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.tE.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void K(String str) {
        this.tE.F(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void L(String str) {
        this.tE.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void N(String str) {
        this.tE.G(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void O(String str) {
        if (this.tt instanceof f.b) {
            com.baidu.adp.lib.g.k.fT().f(new l(this, str));
        }
        if (this.tt instanceof f.a) {
            com.baidu.adp.lib.g.k.fT().f(new m(this, str));
        }
    }

    public c<T> eH() {
        return this.tE;
    }
}
