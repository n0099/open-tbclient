package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> pP;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.pP = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> ab(String str) {
        return this.pP.aa(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.pP.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.pP.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.pP.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.pP.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.pO instanceof e.b) {
            com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.pP.performPump(str);
                }
            });
        }
        if (this.pO instanceof e.a) {
            com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.pP.performEvict(str);
                }
            });
        }
    }

    public c<T> fy() {
        return this.pP;
    }
}
