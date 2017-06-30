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
    public h<T> O(String str) {
        return this.tD.J(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.tD.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void P(String str) {
        this.tD.K(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void Q(String str) {
        this.tD.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void S(String str) {
        this.tD.L(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void T(String str) {
        if (this.ts instanceof f.b) {
            com.baidu.adp.lib.g.k.fS().f(new l(this, str));
        }
        if (this.ts instanceof f.a) {
            com.baidu.adp.lib.g.k.fS().f(new m(this, str));
        }
    }

    public c<T> eG() {
        return this.tD;
    }
}
