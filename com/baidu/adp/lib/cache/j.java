package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> rE;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.rE = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> V(String str) {
        return this.rE.Q(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.rE.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void W(String str) {
        this.rE.R(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void X(String str) {
        this.rE.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void Z(String str) {
        this.rE.S(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void aa(final String str) {
        if (this.rt instanceof e.b) {
            com.baidu.adp.lib.g.h.fx().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.rE.U(str);
                }
            });
        }
        if (this.rt instanceof e.a) {
            com.baidu.adp.lib.g.h.fx().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.rE.T(str);
                }
            });
        }
    }

    public c<T> em() {
        return this.rE;
    }
}
