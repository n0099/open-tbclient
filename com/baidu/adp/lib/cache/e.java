package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements n<T> {
    protected final boolean lZ;
    protected final f ma;

    public abstract h<T> N(String str);

    public abstract void O(String str);

    protected abstract void P(String str);

    public abstract void c(h<T> hVar);

    public e(f fVar, boolean z) {
        this.ma = fVar;
        this.lZ = z;
    }

    protected String h(String str, String str2) {
        if (this.lZ) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected h<T> j(String str, String str2) {
        String h = h(str, str2);
        h<T> N = N(h);
        if (N == null) {
            BdLog.isDebugMode();
            return null;
        } else if (N.mi < System.currentTimeMillis()) {
            P(h);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.ma.du()) {
                N.mh = System.currentTimeMillis();
                c(N);
            }
            BdLog.isDebugMode();
            return N;
        }
    }

    @Override // com.baidu.adp.lib.cache.n
    public T k(String str, String str2) {
        h<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        return j.lp;
    }

    @Override // com.baidu.adp.lib.cache.n
    public o.c<T> l(String str, String str2) {
        h<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        o.c<T> cVar = new o.c<>();
        cVar.key = str2;
        cVar.lp = j.lp;
        cVar.mi = j.mi;
        cVar.my = j.mg;
        return cVar;
    }

    @Override // com.baidu.adp.lib.cache.n
    public void a(String str, String str2, T t, long j) {
        h<T> hVar = new h<>();
        hVar.md = h(str, str2);
        hVar.mf = str;
        hVar.mi = j;
        hVar.lp = t;
        hVar.mh = System.currentTimeMillis();
        hVar.mg = System.currentTimeMillis();
        c(hVar);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void m(String str, String str2) {
        O(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.n
    public f dt() {
        return this.ma;
    }
}
