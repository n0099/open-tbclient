package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> tl;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.tl = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> U(String str) {
        return this.tl.P(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.tl.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void V(String str) {
        this.tl.Q(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void W(String str) {
        this.tl.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void Y(String str) {
        this.tl.R(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void Z(String str) {
        if (this.sZ instanceof f.b) {
            com.baidu.adp.lib.h.k.hk().c(new l(this, str));
        }
        if (this.sZ instanceof f.a) {
            com.baidu.adp.lib.h.k.hk().c(new m(this, str));
        }
    }

    public c<T> gj() {
        return this.tl;
    }
}
