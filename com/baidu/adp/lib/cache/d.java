package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean ahe;
    protected final e ahf;

    public abstract g<T> Y(String str);

    public abstract void Z(String str);

    protected abstract void aa(String str);

    public abstract void c(g<T> gVar);

    public d(e eVar, boolean z) {
        this.ahf = eVar;
        this.ahe = z;
    }

    protected String h(String str, String str2) {
        if (this.ahe) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected g<T> j(String str, String str2) {
        String h = h(str, str2);
        g<T> Y = Y(h);
        if (Y == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (Y.ahm < System.currentTimeMillis()) {
            aa(h);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.ahf.mc()) {
                Y.ahl = System.currentTimeMillis();
                c(Y);
            }
            if (BdLog.isDebugMode()) {
            }
            return Y;
        }
    }

    @Override // com.baidu.adp.lib.cache.k
    public T k(String str, String str2) {
        g<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        return j.value;
    }

    @Override // com.baidu.adp.lib.cache.k
    public l.b<T> l(String str, String str2) {
        g<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        l.b<T> bVar = new l.b<>();
        bVar.key = str2;
        bVar.value = j.value;
        bVar.ahm = j.ahm;
        bVar.ahB = j.ahk;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void a(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.ahi = h(str, str2);
        gVar.ahj = str;
        gVar.ahm = j;
        gVar.value = t;
        gVar.ahl = System.currentTimeMillis();
        gVar.ahk = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void m(String str, String str2) {
        Z(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e mb() {
        return this.ahf;
    }
}
