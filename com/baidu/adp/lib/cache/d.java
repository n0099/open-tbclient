package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean ts;
    protected final e tt;

    public abstract g<T> Q(String str);

    public abstract void R(String str);

    protected abstract void S(String str);

    public abstract void c(g<T> gVar);

    public d(e eVar, boolean z) {
        this.tt = eVar;
        this.ts = z;
    }

    protected String h(String str, String str2) {
        if (this.ts) {
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
        } else if (Q.tA < System.currentTimeMillis()) {
            S(h);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.tt.ey()) {
                Q.tz = System.currentTimeMillis();
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
        return j.sG;
    }

    @Override // com.baidu.adp.lib.cache.k
    public l.c<T> l(String str, String str2) {
        g<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        l.c<T> cVar = new l.c<>();
        cVar.key = str2;
        cVar.sG = j.sG;
        cVar.tA = j.tA;
        cVar.tP = j.ty;
        return cVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void a(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.tw = h(str, str2);
        gVar.tx = str;
        gVar.tA = j;
        gVar.sG = t;
        gVar.tz = System.currentTimeMillis();
        gVar.ty = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void m(String str, String str2) {
        R(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e ex() {
        return this.tt;
    }
}
