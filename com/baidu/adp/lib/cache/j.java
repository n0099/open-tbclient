package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> nt;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.nt = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> W(String str) {
        return this.nt.V(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.nt.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.nt.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.nt.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.nt.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.ns instanceof e.b) {
            com.baidu.adp.lib.g.h.ga().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.nt.performPump(str);
                }
            });
        }
        if (this.ns instanceof e.a) {
            com.baidu.adp.lib.g.h.ga().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.nt.performEvict(str);
                }
            });
        }
    }

    public c<T> fd() {
        return this.nt;
    }
}
