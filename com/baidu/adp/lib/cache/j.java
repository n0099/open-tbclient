package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> KY;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.KY = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> bw(String str) {
        return this.KY.bv(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.KY.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.KY.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.KY.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.KY.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.KX instanceof e.b) {
            com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.KY.performPump(str);
                }
            });
        }
        if (this.KX instanceof e.a) {
            com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.KY.performEvict(str);
                }
            });
        }
    }

    public c<T> lv() {
        return this.KY;
    }
}
