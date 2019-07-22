package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> yD;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.yD = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> aj(String str) {
        return this.yD.ae(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.yD.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void ak(String str) {
        this.yD.af(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void al(String str) {
        this.yD.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void an(String str) {
        this.yD.ag(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void ao(final String str) {
        if (this.ys instanceof e.b) {
            com.baidu.adp.lib.g.h.iL().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.yD.ai(str);
                }
            });
        }
        if (this.ys instanceof e.a) {
            com.baidu.adp.lib.g.h.iL().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.yD.ah(str);
                }
            });
        }
    }

    public c<T> hz() {
        return this.yD;
    }
}
