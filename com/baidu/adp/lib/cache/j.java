package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> yx;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.yx = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> ai(String str) {
        return this.yx.ad(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.yx.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void aj(String str) {
        this.yx.ae(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void ak(String str) {
        this.yx.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void am(String str) {
        this.yx.af(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void an(final String str) {
        if (this.ym instanceof e.b) {
            com.baidu.adp.lib.g.h.iC().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.yx.ah(str);
                }
            });
        }
        if (this.ym instanceof e.a) {
            com.baidu.adp.lib.g.h.iC().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.yx.ag(str);
                }
            });
        }
    }

    public c<T> hp() {
        return this.yx;
    }
}
