package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final e ns;
    protected final boolean prefixNameSpaceToKey;

    public abstract g<T> W(String str);

    public abstract void c(g<T> gVar);

    public abstract void removeByUniqueKey(String str);

    protected abstract void removeExpiredItem(String str);

    public d(e eVar, boolean z) {
        this.ns = eVar;
        this.prefixNameSpaceToKey = z;
    }

    protected String buildUniqueKey(String str, String str2) {
        if (this.prefixNameSpaceToKey) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected g<T> j(String str, String str2) {
        String buildUniqueKey = buildUniqueKey(str, str2);
        g<T> W = W(buildUniqueKey);
        if (W == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (W.timeToExpire < System.currentTimeMillis()) {
            removeExpiredItem(buildUniqueKey);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.ns.shouldUpdateLastHitTime()) {
                W.lastHitTime = System.currentTimeMillis();
                c(W);
            }
            if (BdLog.isDebugMode()) {
            }
            return W;
        }
    }

    @Override // com.baidu.adp.lib.cache.k
    public T get(String str, String str2) {
        g<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        return j.value;
    }

    @Override // com.baidu.adp.lib.cache.k
    public l.b<T> k(String str, String str2) {
        g<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        l.b<T> bVar = new l.b<>();
        bVar.key = str2;
        bVar.value = j.value;
        bVar.timeToExpire = j.timeToExpire;
        bVar.lastSaveTime = j.saveTime;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void set(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.uniqueKey = buildUniqueKey(str, str2);
        gVar.nameSpace = str;
        gVar.timeToExpire = j;
        gVar.value = t;
        gVar.lastHitTime = System.currentTimeMillis();
        gVar.saveTime = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void remove(String str, String str2) {
        removeByUniqueKey(buildUniqueKey(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e fb() {
        return this.ns;
    }
}
