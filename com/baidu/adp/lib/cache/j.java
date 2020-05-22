package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> Jh;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.Jh = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> br(String str) {
        return this.Jh.bq(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.Jh.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.Jh.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.Jh.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.Jh.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.Jg instanceof e.b) {
            com.baidu.adp.lib.f.h.le().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Jh.performPump(str);
                }
            });
        }
        if (this.Jg instanceof e.a) {
            com.baidu.adp.lib.f.h.le().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Jh.performEvict(str);
                }
            });
        }
    }

    public c<T> ke() {
        return this.Jh;
    }
}
