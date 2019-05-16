package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> yy;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.yy = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> ai(String str) {
        return this.yy.ad(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.yy.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void aj(String str) {
        this.yy.ae(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void ak(String str) {
        this.yy.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void am(String str) {
        this.yy.af(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void an(final String str) {
        if (this.yn instanceof e.b) {
            com.baidu.adp.lib.g.h.iC().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.yy.ah(str);
                }
            });
        }
        if (this.yn instanceof e.a) {
            com.baidu.adp.lib.g.h.iC().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.yy.ag(str);
                }
            });
        }
    }

    public c<T> hp() {
        return this.yy;
    }
}
