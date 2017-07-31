package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> vi;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.vi = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> W(String str) {
        return this.vi.R(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.vi.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void X(String str) {
        this.vi.S(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void Y(String str) {
        this.vi.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void aa(String str) {
        this.vi.T(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void ab(final String str) {
        if (this.uX instanceof e.b) {
            com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.vi.V(str);
                }
            });
        }
        if (this.uX instanceof e.a) {
            com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.vi.U(str);
                }
            });
        }
    }

    public c<T> eP() {
        return this.vi;
    }
}
