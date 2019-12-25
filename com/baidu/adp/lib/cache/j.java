package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> pS;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.pS = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> ab(String str) {
        return this.pS.aa(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.pS.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.pS.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.pS.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.pS.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.pR instanceof e.b) {
            com.baidu.adp.lib.f.h.gz().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.pS.performPump(str);
                }
            });
        }
        if (this.pR instanceof e.a) {
            com.baidu.adp.lib.f.h.gz().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.pS.performEvict(str);
                }
            });
        }
    }

    public c<T> fy() {
        return this.pS;
    }
}
