package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> IW;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.IW = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> bq(String str) {
        return this.IW.bp(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.IW.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.IW.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.IW.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.IW.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.IU instanceof e.b) {
            com.baidu.adp.lib.f.h.lc().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.IW.performPump(str);
                }
            });
        }
        if (this.IU instanceof e.a) {
            com.baidu.adp.lib.f.h.lc().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.IW.performEvict(str);
                }
            });
        }
    }

    public c<T> kc() {
        return this.IW;
    }
}
