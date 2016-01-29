package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.f;
/* loaded from: classes.dex */
public class k<T> extends e<T> {
    protected final c<T> tw;

    public k(c<T> cVar, f fVar, boolean z) {
        super(fVar, z);
        this.tw = cVar;
    }

    @Override // com.baidu.adp.lib.cache.e
    public h<T> T(String str) {
        return this.tw.O(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void c(h<T> hVar) {
        this.tw.b(hVar);
    }

    @Override // com.baidu.adp.lib.cache.e
    public void U(String str) {
        this.tw.P(str);
    }

    @Override // com.baidu.adp.lib.cache.e
    protected void V(String str) {
        this.tw.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void X(String str) {
        this.tw.Q(str);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void Y(String str) {
        if (this.tj instanceof f.b) {
            com.baidu.adp.lib.h.k.hs().c(new l(this, str));
        }
        if (this.tj instanceof f.a) {
            com.baidu.adp.lib.h.k.hs().c(new m(this, str));
        }
    }

    public c<T> gr() {
        return this.tw;
    }
}
