package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.e;
/* loaded from: classes.dex */
public class j<T> extends d<T> {
    protected final c<T> JH;

    public j(c<T> cVar, e eVar, boolean z) {
        super(eVar, z);
        this.JH = cVar;
    }

    @Override // com.baidu.adp.lib.cache.d
    public g<T> bs(String str) {
        return this.JH.br(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void c(g<T> gVar) {
        this.JH.b(gVar);
    }

    @Override // com.baidu.adp.lib.cache.d
    public void removeByUniqueKey(String str) {
        this.JH.deleteCacheItem(str);
    }

    @Override // com.baidu.adp.lib.cache.d
    protected void removeExpiredItem(String str) {
        this.JH.addItemIdToDeleteList(str, true);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void clearAndClose(String str) {
        this.JH.clearAllForNameSpace(str);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void startup(final String str) {
        if (this.JG instanceof e.b) {
            com.baidu.adp.lib.f.h.lu().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.JH.performPump(str);
                }
            });
        }
        if (this.JG instanceof e.a) {
            com.baidu.adp.lib.f.h.lu().submitTask(new Runnable() { // from class: com.baidu.adp.lib.cache.j.2
                @Override // java.lang.Runnable
                public void run() {
                    j.this.JH.performEvict(str);
                }
            });
        }
    }

    public c<T> ku() {
        return this.JH;
    }
}
