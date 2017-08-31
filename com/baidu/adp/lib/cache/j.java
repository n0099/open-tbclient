package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> sW;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.sW = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> Q(String str) {
        return this.sW.L(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.sW.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void R(String str) {
        this.sW.M(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void S(String str) {
        this.sW.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void U(String str) {
        this.sW.N(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void V(final String str) {
        if (this.sL instanceof e.b) {
            com.baidu.adp.lib.g.h.fR().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.sW.P(str);
                }
            });
        }
        if (this.sL instanceof e.a) {
            com.baidu.adp.lib.g.h.fR().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.sW.O(str);
                }
            });
        }
    }

    public c<T> eE() {
        return this.sW;
    }
}
