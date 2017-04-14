package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> ty;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.ty = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> J(String str) {
        return this.ty.E(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.ty.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void K(String str) {
        this.ty.F(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void L(String str) {
        this.ty.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void N(String str) {
        this.ty.G(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void O(String str) {
        if (this.tl instanceof f.b) {
            com.baidu.adp.lib.g.k.fS().f(new l(this, str));
        }
        if (this.tl instanceof f.a) {
            com.baidu.adp.lib.g.k.fS().f(new m(this, str));
        }
    }

    public c<T> eG() {
        return this.ty;
    }
}
