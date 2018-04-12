package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> rF;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.rF = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> V(String str) {
        return this.rF.Q(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.rF.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void W(String str) {
        this.rF.R(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void X(String str) {
        this.rF.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void Z(String str) {
        this.rF.S(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void aa(final String str) {
        if (this.ru instanceof e.b) {
            com.baidu.adp.lib.g.h.fx().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.rF.U(str);
                }
            });
        }
        if (this.ru instanceof e.a) {
            com.baidu.adp.lib.g.h.fx().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.rF.T(str);
                }
            });
        }
    }

    public c<T> em() {
        return this.rF;
    }
}
