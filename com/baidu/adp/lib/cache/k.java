package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> tF;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.tF = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> T(String str) {
        return this.tF.O(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.tF.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void U(String str) {
        this.tF.P(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void V(String str) {
        this.tF.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void X(String str) {
        this.tF.Q(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void Y(String str) {
        if (this.tu instanceof f.b) {
            com.baidu.adp.lib.h.k.hy().c(new l(this, str));
        }
        if (this.tu instanceof f.a) {
            com.baidu.adp.lib.h.k.hy().c(new m(this, str));
        }
    }

    public c<T> gr() {
        return this.tF;
    }
}
