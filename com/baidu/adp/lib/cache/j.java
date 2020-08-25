package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> Kk;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.Kk = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> bx(String str) {
        return this.Kk.bw(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.Kk.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.Kk.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.Kk.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.Kk.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.Kj instanceof e.b) {
            com.baidu.adp.lib.f.h.mT().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Kk.performPump(str);
                }
            });
        }
        if (this.Kj instanceof e.a) {
            com.baidu.adp.lib.f.h.mT().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Kk.performEvict(str);
                }
            });
        }
    }

    public c<T> lT() {
        return this.Kk;
    }
}
