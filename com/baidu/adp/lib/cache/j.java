package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> KJ;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.KJ = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> bz(String str) {
        return this.KJ.by(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.KJ.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.KJ.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.KJ.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.KJ.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.KI instanceof e.b) {
            com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.KJ.performPump(str);
                }
            });
        }
        if (this.KI instanceof e.a) {
            com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.KJ.performEvict(str);
                }
            });
        }
    }

    public c<T> lY() {
        return this.KJ;
    }
}
