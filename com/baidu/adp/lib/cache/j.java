package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> xJ;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.xJ = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> ai(String str) {
        return this.xJ.ad(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.xJ.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void aj(String str) {
        this.xJ.ae(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void ak(String str) {
        this.xJ.b(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void am(String str) {
        this.xJ.af(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void an(final String str) {
        if (this.xy instanceof e.b) {
            com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xJ.ah(str);
                }
            });
        }
        if (this.xy instanceof e.a) {
            com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xJ.ag(str);
                }
            });
        }
    }

    public c<T> hc() {
        return this.xJ;
    }
}
