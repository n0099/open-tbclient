package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> pQ;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.pQ = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> ab(String str) {
        return this.pQ.aa(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.pQ.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.pQ.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.pQ.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.pQ.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.pP instanceof e.b) {
            com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.pQ.performPump(str);
                }
            });
        }
        if (this.pP instanceof e.a) {
            com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.pQ.performEvict(str);
                }
            });
        }
    }

    public c<T> fy() {
        return this.pQ;
    }
}
