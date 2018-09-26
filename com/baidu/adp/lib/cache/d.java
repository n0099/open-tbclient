package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean zQ;
    protected final e zR;

    public abstract void aA(String str);

    protected abstract void aB(String str);

    public abstract g<T> az(String str);

    public abstract void c(g<T> gVar);

    public d(e eVar, boolean z) {
        this.zR = eVar;
        this.zQ = z;
    }

    protected String p(String str, String str2) {
        if (this.zQ) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected g<T> q(String str, String str2) {
        String p = p(str, str2);
        g<T> az = az(p);
        if (az == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (az.zY < System.currentTimeMillis()) {
            aB(p);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.zR.ic()) {
                az.zX = System.currentTimeMillis();
                c(az);
            }
            if (BdLog.isDebugMode()) {
            }
            return az;
        }
    }

    @Override // com.baidu.adp.lib.cache.k
    public T r(String str, String str2) {
        g<T> q = q(str, str2);
        if (q == null) {
            return null;
        }
        return q.value;
    }

    @Override // com.baidu.adp.lib.cache.k
    public l.b<T> s(String str, String str2) {
        g<T> q = q(str, str2);
        if (q == null) {
            return null;
        }
        l.b<T> bVar = new l.b<>();
        bVar.key = str2;
        bVar.value = q.value;
        bVar.zY = q.zY;
        bVar.Am = q.zW;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void a(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.zU = p(str, str2);
        gVar.zV = str;
        gVar.zY = j;
        gVar.value = t;
        gVar.zX = System.currentTimeMillis();
        gVar.zW = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void t(String str, String str2) {
        aA(p(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e ib() {
        return this.zR;
    }
}
