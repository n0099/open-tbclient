package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ugc.model.UgcConstant;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final e Jg;
    protected final boolean prefixNameSpaceToKey;

    public abstract g<T> br(String str);

    public abstract void c(g<T> gVar);

    public abstract void removeByUniqueKey(String str);

    protected abstract void removeExpiredItem(String str);

    public d(e eVar, boolean z) {
        this.Jg = eVar;
        this.prefixNameSpaceToKey = z;
    }

    protected String buildUniqueKey(String str, String str2) {
        if (this.prefixNameSpaceToKey) {
            return str + UgcConstant.AT_RULE_TAG + str2;
        }
        return str2;
    }

    protected g<T> q(String str, String str2) {
        String buildUniqueKey = buildUniqueKey(str, str2);
        g<T> br = br(buildUniqueKey);
        if (br == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (br.timeToExpire < System.currentTimeMillis()) {
            removeExpiredItem(buildUniqueKey);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.Jg.shouldUpdateLastHitTime()) {
                br.lastHitTime = System.currentTimeMillis();
                c(br);
            }
            if (BdLog.isDebugMode()) {
            }
            return br;
        }
    }

    @Override // com.baidu.adp.lib.cache.k
    public T get(String str, String str2) {
        g<T> q = q(str, str2);
        if (q == null) {
            return null;
        }
        return q.value;
    }

    @Override // com.baidu.adp.lib.cache.k
    public l.b<T> r(String str, String str2) {
        g<T> q = q(str, str2);
        if (q == null) {
            return null;
        }
        l.b<T> bVar = new l.b<>();
        bVar.key = str2;
        bVar.value = q.value;
        bVar.timeToExpire = q.timeToExpire;
        bVar.lastSaveTime = q.saveTime;
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
    public e kc() {
        return this.Jg;
    }
}
