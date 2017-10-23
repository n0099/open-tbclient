package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> sX;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.sX = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> Q(String str) {
        return this.sX.L(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.sX.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void R(String str) {
        this.sX.M(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void S(String str) {
        this.sX.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void U(String str) {
        this.sX.N(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void V(final String str) {
        if (this.sM instanceof e.b) {
            com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.sX.P(str);
                }
            });
        }
        if (this.sM instanceof e.a) {
            com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.sX.O(str);
                }
            });
        }
    }

    public c<T> eD() {
        return this.sX;
    }
}
