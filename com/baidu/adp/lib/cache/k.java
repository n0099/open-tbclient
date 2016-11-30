package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> mm;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.mm = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> N(String str) {
        return this.mm.I(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.mm.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void O(String str) {
        this.mm.J(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void P(String str) {
        this.mm.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void R(String str) {
        this.mm.K(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void S(String str) {
        if (this.ma instanceof f.b) {
            com.baidu.adp.lib.h.k.eH().f(new l(this, str));
        }
        if (this.ma instanceof f.a) {
            com.baidu.adp.lib.h.k.eH().f(new m(this, str));
        }
    }

    public c<T> dA() {
        return this.mm;
    }
}
