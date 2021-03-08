package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> Mw;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.Mw = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> bA(String str) {
        return this.Mw.bz(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.Mw.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.Mw.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.Mw.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.Mw.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.Mv instanceof e.b) {
            com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Mw.performPump(str);
                }
            });
        }
        if (this.Mv instanceof e.a) {
            com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.Mw.performEvict(str);
                }
            });
        }
    }

    public c<T> lv() {
        return this.Mw;
    }
}
