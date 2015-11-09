package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> ti;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.ti = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> U(String str) {
        return this.ti.P(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.ti.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void V(String str) {
        this.ti.Q(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void W(String str) {
        this.ti.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void Y(String str) {
        this.ti.R(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void Z(String str) {
        if (this.sW instanceof f.b) {
            com.baidu.adp.lib.g.k.hi().c(new l(this, str));
        }
        if (this.sW instanceof f.a) {
            com.baidu.adp.lib.g.k.hi().c(new m(this, str));
        }
    }

    public c<T> gk() {
        return this.ti;
    }
}
