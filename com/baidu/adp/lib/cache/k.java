package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> tk;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.tk = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> W(String str) {
        return this.tk.R(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.tk.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void X(String str) {
        this.tk.S(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void Y(String str) {
        this.tk.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void aa(String str) {
        this.tk.T(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void ab(String str) {
        if (this.sY instanceof f.b) {
            com.baidu.adp.lib.g.k.hj().c(new l(this, str));
        }
        if (this.sY instanceof f.a) {
            com.baidu.adp.lib.g.k.hj().c(new m(this, str));
        }
    }

    public c<T> gn() {
        return this.tk;
    }
}
