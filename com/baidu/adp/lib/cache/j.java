package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> Ks;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.Ks = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> bz(String str) {
        return this.Ks.by(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.Ks.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.Ks.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.Ks.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.Ks.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.Kr instanceof e.b) {
            com.baidu.adp.lib.f.h.mY().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Ks.performPump(str);
                }
            });
        }
        if (this.Kr instanceof e.a) {
            com.baidu.adp.lib.f.h.mY().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Ks.performEvict(str);
                }
            });
        }
    }

    public c<T> lX() {
        return this.Ks;
    }
}
