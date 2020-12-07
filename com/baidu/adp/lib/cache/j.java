package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> LB;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.LB = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> bC(String str) {
        return this.LB.bB(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.LB.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.LB.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.LB.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.LB.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.LA instanceof e.b) {
            com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.LB.performPump(str);
                }
            });
        }
        if (this.LA instanceof e.a) {
            com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.LB.performEvict(str);
                }
            });
        }
    }

    public c<T> lY() {
        return this.LB;
    }
}
