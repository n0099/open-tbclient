package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> Lc;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.Lc = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> bw(String str) {
        return this.Lc.bv(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.Lc.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.Lc.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.Lc.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.Lc.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.Lb instanceof e.b) {
            com.baidu.adp.lib.f.h.mC().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Lc.performPump(str);
                }
            });
        }
        if (this.Lb instanceof e.a) {
            com.baidu.adp.lib.f.h.mC().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Lc.performEvict(str);
                }
            });
        }
    }

    public c<T> lw() {
        return this.Lc;
    }
}
