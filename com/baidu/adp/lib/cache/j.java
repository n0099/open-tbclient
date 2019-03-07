package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> AP;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.AP = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> az(String str) {
        return this.AP.au(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.AP.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void aA(String str) {
        this.AP.av(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void aB(String str) {
        this.AP.d(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void aD(String str) {
        this.AP.aw(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void aE(final String str) {
        if (this.AD instanceof e.b) {
            com.baidu.adp.lib.g.h.jI().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.AP.ay(str);
                }
            });
        }
        if (this.AD instanceof e.a) {
            com.baidu.adp.lib.g.h.jI().d(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.AP.ax(str);
                }
            });
        }
    }

    public c<T> ix() {
        return this.AP;
    }
}
