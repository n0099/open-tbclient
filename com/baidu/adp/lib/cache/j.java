package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> xK;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.xK = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> ai(String str) {
        return this.xK.ad(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.xK.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void aj(String str) {
        this.xK.ae(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void ak(String str) {
        this.xK.b(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void am(String str) {
        this.xK.af(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void an(final String str) {
        if (this.xz instanceof e.b) {
            com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xK.ah(str);
                }
            });
        }
        if (this.xz instanceof e.a) {
            com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.xK.ag(str);
                }
            });
        }
    }

    public c<T> hc() {
        return this.xK;
    }
}
