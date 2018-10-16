package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> AN;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.AN = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> az(String str) {
        return this.AN.au(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.AN.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void aA(String str) {
        this.AN.av(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void aB(String str) {
        this.AN.f(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void aD(String str) {
        this.AN.aw(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void aE(final String str) {
        if (this.AB instanceof e.b) {
            com.baidu.adp.lib.g.h.jJ().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.AN.ay(str);
                }
            });
        }
        if (this.AB instanceof e.a) {
            com.baidu.adp.lib.g.h.jJ().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.AN.ax(str);
                }
            });
        }
    }

    public c<T> iy() {
        return this.AN;
    }
}
