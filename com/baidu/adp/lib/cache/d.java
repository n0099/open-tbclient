package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean sI;
    protected final e sJ;

    public abstract g<T> Q(String str);

    public abstract void R(String str);

    protected abstract void S(String str);

    public abstract void c(g<T> gVar);

    public d(e eVar, boolean z) {
        this.sJ = eVar;
        this.sI = z;
    }

    protected String h(String str, String str2) {
        if (this.sI) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected g<T> j(String str, String str2) {
        String h = h(str, str2);
        g<T> Q = Q(h);
        if (Q == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (Q.sQ < System.currentTimeMillis()) {
            S(h);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.sJ.ex()) {
                Q.sP = System.currentTimeMillis();
                c(Q);
            }
            if (BdLog.isDebugMode()) {
            }
            return Q;
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
        bVar.sQ = j.sQ;
        bVar.tg = j.sO;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void a(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.sM = h(str, str2);
        gVar.sN = str;
        gVar.sQ = j;
        gVar.value = t;
        gVar.sP = System.currentTimeMillis();
        gVar.sO = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void m(String str, String str2) {
        R(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e ew() {
        return this.sJ;
    }
}
