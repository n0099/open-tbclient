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
    public h<T> W(String str) {
        return this.ti.R(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.ti.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void X(String str) {
        this.ti.S(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void Y(String str) {
        this.ti.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void aa(String str) {
        this.ti.T(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void ab(String str) {
        if (this.sW instanceof f.b) {
            com.baidu.adp.lib.g.k.hh().c(new l(this, str));
        }
        if (this.sW instanceof f.a) {
            com.baidu.adp.lib.g.k.hh().c(new m(this, str));
        }
    }

    public c<T> gk() {
        return this.ti;
    }
}
