package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> tE;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.tE = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> Q(String str) {
        return this.tE.L(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.tE.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void R(String str) {
        this.tE.M(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void S(String str) {
        this.tE.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void U(String str) {
        this.tE.N(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void V(final String str) {
        if (this.tt instanceof e.b) {
            com.baidu.adp.lib.g.h.fQ().f(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.tE.P(str);
                }
            });
        }
        if (this.tt instanceof e.a) {
            com.baidu.adp.lib.g.h.fQ().f(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.tE.O(str);
                }
            });
        }
    }

    public c<T> eE() {
        return this.tE;
    }
}
