package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> xP;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.xP = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> ah(String str) {
        return this.xP.ac(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.xP.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void ai(String str) {
        this.xP.ad(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void aj(String str) {
        this.xP.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void al(String str) {
        this.xP.ae(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void am(final String str) {
        if (this.xE instanceof e.b) {
            com.baidu.adp.lib.g.h.in().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xP.ag(str);
                }
            });
        }
        if (this.xE instanceof e.a) {
            com.baidu.adp.lib.g.h.in().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xP.af(str);
                }
            });
        }
    }

    public c<T> hd() {
        return this.xP;
    }
}
