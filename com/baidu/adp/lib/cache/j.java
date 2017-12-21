package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> sV;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.sV = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> Q(String str) {
        return this.sV.L(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.sV.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void R(String str) {
        this.sV.M(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void S(String str) {
        this.sV.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void U(String str) {
        this.sV.N(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void V(final String str) {
        if (this.sK instanceof e.b) {
            com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.sV.P(str);
                }
            });
        }
        if (this.sK instanceof e.a) {
            com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.sV.O(str);
                }
            });
        }
    }

    public c<T> eD() {
        return this.sV;
    }
}
