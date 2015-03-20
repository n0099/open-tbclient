package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements s<T> {
    protected final boolean sP;
    protected final f sQ;

    public abstract m<T> V(String str);

    public abstract void W(String str);

    protected abstract void X(String str);

    public abstract void c(m<T> mVar);

    public e(f fVar, boolean z) {
        this.sQ = fVar;
        this.sP = z;
    }

    protected String j(String str, String str2) {
        if (this.sP) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected m<T> k(String str, String str2) {
        String j = j(str, str2);
        m<T> V = V(j);
        if (V == null) {
            BdLog.isDebugMode();
            return null;
        } else if (V.sX < System.currentTimeMillis()) {
            X(j);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.sQ.gi()) {
                V.sW = System.currentTimeMillis();
                c(V);
            }
            BdLog.isDebugMode();
            return V;
        }
    }

    @Override // com.baidu.adp.lib.cache.s
    public T l(String str, String str2) {
        m<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.sf;
    }

    @Override // com.baidu.adp.lib.cache.s
    public v<T> m(String str, String str2) {
        m<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        v<T> vVar = new v<>();
        vVar.key = str2;
        vVar.sf = k.sf;
        vVar.sX = k.sX;
        vVar.tn = k.sV;
        return vVar;
    }

    @Override // com.baidu.adp.lib.cache.s
    public void a(String str, String str2, T t, long j) {
        m<T> mVar = new m<>();
        mVar.sT = j(str, str2);
        mVar.sU = str;
        mVar.sX = j;
        mVar.sf = t;
        mVar.sW = System.currentTimeMillis();
        mVar.sV = System.currentTimeMillis();
        c(mVar);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void n(String str, String str2) {
        W(j(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.s
    public f gg() {
        return this.sQ;
    }
}
