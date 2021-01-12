package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> La;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.La = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> bw(String str) {
        return this.La.bv(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.La.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.La.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.La.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.La.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.KZ instanceof e.b) {
            com.baidu.adp.lib.f.h.mC().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.La.performPump(str);
                }
            });
        }
        if (this.KZ instanceof e.a) {
            com.baidu.adp.lib.f.h.mC().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.La.performEvict(str);
                }
            });
        }
    }

    public c<T> lw() {
        return this.La;
    }
}
