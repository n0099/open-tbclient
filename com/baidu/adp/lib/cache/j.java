package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> AQ;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.AQ = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> az(String str) {
        return this.AQ.au(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.AQ.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void aA(String str) {
        this.AQ.av(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void aB(String str) {
        this.AQ.f(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void aD(String str) {
        this.AQ.aw(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void aE(final String str) {
        if (this.AE instanceof e.b) {
            com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.AQ.ay(str);
                }
            });
        }
        if (this.AE instanceof e.a) {
            com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.AQ.ax(str);
                }
            });
        }
    }

    public c<T> ix() {
        return this.AQ;
    }
}
