package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> vk;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.vk = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> W(String str) {
        return this.vk.R(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.vk.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void X(String str) {
        this.vk.S(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void Y(String str) {
        this.vk.c(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void aa(String str) {
        this.vk.T(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void ab(final String str) {
        if (this.uZ instanceof e.b) {
            com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.vk.V(str);
                }
            });
        }
        if (this.uZ instanceof e.a) {
            com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.vk.U(str);
                }
            });
        }
    }

    public c<T> eP() {
        return this.vk;
    }
}
