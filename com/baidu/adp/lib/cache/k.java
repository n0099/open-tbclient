package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> mg;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.mg = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> N(String str) {
        return this.mg.I(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.mg.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void O(String str) {
        this.mg.J(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void P(String str) {
        this.mg.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void R(String str) {
        this.mg.K(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void S(String str) {
        if (this.lU instanceof f.b) {
            com.baidu.adp.lib.g.k.eF().f(new l(this, str));
        }
        if (this.lU instanceof f.a) {
            com.baidu.adp.lib.g.k.eF().f(new m(this, str));
        }
    }

    public c<T> dy() {
        return this.mg;
    }
}
