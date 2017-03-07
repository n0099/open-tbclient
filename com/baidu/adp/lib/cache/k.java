package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> ua;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.ua = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> M(String str) {
        return this.ua.H(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.ua.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void N(String str) {
        this.ua.I(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void O(String str) {
        this.ua.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void Q(String str) {
        this.ua.J(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void R(String str) {
        if (this.tP instanceof f.b) {
            com.baidu.adp.lib.g.k.fN().f(new l(this, str));
        }
        if (this.tP instanceof f.a) {
            com.baidu.adp.lib.g.k.fN().f(new m(this, str));
        }
    }

    public c<T> eH() {
        return this.ua;
    }
}
