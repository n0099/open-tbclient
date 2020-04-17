package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> IS;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.IS = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> bq(String str) {
        return this.IS.bp(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.IS.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.IS.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.IS.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.IS.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.IR instanceof e.b) {
            com.baidu.adp.lib.f.h.lc().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.IS.performPump(str);
                }
            });
        }
        if (this.IR instanceof e.a) {
            com.baidu.adp.lib.f.h.lc().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.IS.performEvict(str);
                }
            });
        }
    }

    public c<T> kc() {
        return this.IS;
    }
}
