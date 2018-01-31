package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> ahs;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.ahs = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> Y(String str) {
        return this.ahs.T(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.ahs.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void Z(String str) {
        this.ahs.U(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void aa(String str) {
        this.ahs.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void ac(String str) {
        this.ahs.V(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void ad(final String str) {
        if (this.ahh instanceof e.b) {
            com.baidu.adp.lib.g.h.nt().e(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.ahs.X(str);
                }
            });
        }
        if (this.ahh instanceof e.a) {
            com.baidu.adp.lib.g.h.nt().e(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.ahs.W(str);
                }
            });
        }
    }

    public c<T> mi() {
        return this.ahs;
    }
}
