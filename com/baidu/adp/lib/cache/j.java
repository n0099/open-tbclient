package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> xR;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.xR = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> ah(String str) {
        return this.xR.ac(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.xR.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void ai(String str) {
        this.xR.ad(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void aj(String str) {
        this.xR.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void al(String str) {
        this.xR.ae(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void am(final String str) {
        if (this.xG instanceof e.b) {
            com.baidu.adp.lib.g.h.in().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xR.ag(str);
                }
            });
        }
        if (this.xG instanceof e.a) {
            com.baidu.adp.lib.g.h.in().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xR.af(str);
                }
            });
        }
    }

    public c<T> hd() {
        return this.xR;
    }
}
