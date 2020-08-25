package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ugc.model.UgcConstant;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final e Kj;
    protected final boolean prefixNameSpaceToKey;

    public abstract g<T> bx(String str);

    public abstract void c(g<T> gVar);

    public abstract void removeByUniqueKey(String str);

    protected abstract void removeExpiredItem(String str);

    public d(e eVar, boolean z) {
        this.Kj = eVar;
        this.prefixNameSpaceToKey = z;
    }

    protected String buildUniqueKey(String str, String str2) {
        if (this.prefixNameSpaceToKey) {
            return str + UgcConstant.AT_RULE_TAG + str2;
        }
        return str2;
    }

    protected g<T> s(String str, String str2) {
        String buildUniqueKey = buildUniqueKey(str, str2);
        g<T> bx = bx(buildUniqueKey);
        if (bx == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (bx.timeToExpire < System.currentTimeMillis()) {
            removeExpiredItem(buildUniqueKey);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.Kj.shouldUpdateLastHitTime()) {
                bx.lastHitTime = System.currentTimeMillis();
                c(bx);
            }
            if (BdLog.isDebugMode()) {
            }
            return bx;
        }
    }

    @Override // com.baidu.adp.lib.cache.k
    public T get(String str, String str2) {
        g<T> s = s(str, str2);
        if (s == null) {
            return null;
        }
        return s.value;
    }

    @Override // com.baidu.adp.lib.cache.k
    public l.b<T> t(String str, String str2) {
        g<T> s = s(str, str2);
        if (s == null) {
            return null;
        }
        l.b<T> bVar = new l.b<>();
        bVar.key = str2;
        bVar.value = s.value;
        bVar.timeToExpire = s.timeToExpire;
        bVar.lastSaveTime = s.saveTime;
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
    public e lR() {
        return this.Kj;
    }
}
