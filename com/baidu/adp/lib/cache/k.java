package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> tD;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.tD = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> J(String str) {
        return this.tD.E(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.tD.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void K(String str) {
        this.tD.F(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void L(String str) {
        this.tD.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void N(String str) {
        this.tD.G(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void O(String str) {
        if (this.ts instanceof f.b) {
            com.baidu.adp.lib.g.k.fT().f(new l(this, str));
        }
        if (this.ts instanceof f.a) {
            com.baidu.adp.lib.g.k.fT().f(new m(this, str));
        }
    }

    public c<T> eH() {
        return this.tD;
    }
}
