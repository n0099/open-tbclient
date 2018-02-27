package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> ahk;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.ahk = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> Y(String str) {
        return this.ahk.T(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.ahk.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void Z(String str) {
        this.ahk.U(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void aa(String str) {
        this.ahk.b(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void ac(String str) {
        this.ahk.V(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void ad(final String str) {
        if (this.agZ instanceof e.b) {
            com.baidu.adp.lib.g.h.nt().e(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.ahk.X(str);
                }
            });
        }
        if (this.agZ instanceof e.a) {
            com.baidu.adp.lib.g.h.nt().e(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.ahk.W(str);
                }
            });
        }
    }

    public c<T> mi() {
        return this.ahk;
    }
}
