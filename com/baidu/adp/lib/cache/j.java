package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> Ac;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.Ac = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> az(String str) {
        return this.Ac.au(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.Ac.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void aA(String str) {
        this.Ac.av(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void aB(String str) {
        this.Ac.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void aD(String str) {
        this.Ac.aw(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void aE(final String str) {
        if (this.zR instanceof e.b) {
            com.baidu.adp.lib.g.h.ju().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Ac.ay(str);
                }
            });
        }
        if (this.zR instanceof e.a) {
            com.baidu.adp.lib.g.h.ju().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Ac.ax(str);
                }
            });
        }
    }

    public c<T> ii() {
        return this.Ac;
    }
}
