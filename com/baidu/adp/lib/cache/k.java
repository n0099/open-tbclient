package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> tj;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.tj = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> U(String str) {
        return this.tj.P(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.tj.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void V(String str) {
        this.tj.Q(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void W(String str) {
        this.tj.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void Y(String str) {
        this.tj.R(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void Z(String str) {
        if (this.sX instanceof f.b) {
            com.baidu.adp.lib.h.k.hk().c(new l(this, str));
        }
        if (this.sX instanceof f.a) {
            com.baidu.adp.lib.h.k.hk().c(new m(this, str));
        }
    }

    public c<T> gj() {
        return this.tj;
    }
}
