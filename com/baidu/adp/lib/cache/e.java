package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements s<T> {
    protected final boolean hs;
    protected final f ht;

    public abstract m<T> O(String str);

    public abstract void P(String str);

    protected abstract void Q(String str);

    public abstract void c(m<T> mVar);

    public e(f fVar, boolean z) {
        this.ht = fVar;
        this.hs = z;
    }

    protected String j(String str, String str2) {
        if (this.hs) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected m<T> k(String str, String str2) {
        String j = j(str, str2);
        m<T> O = O(j);
        if (O == null) {
            BdLog.isDebugMode();
            return null;
        } else if (O.hA < System.currentTimeMillis()) {
            Q(j);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.ht.cL()) {
                O.hz = System.currentTimeMillis();
                c(O);
            }
            BdLog.isDebugMode();
            return O;
        }
    }

    @Override // com.baidu.adp.lib.cache.s
    public T l(String str, String str2) {
        m<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.gJ;
    }

    @Override // com.baidu.adp.lib.cache.s
    public v<T> m(String str, String str2) {
        m<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        v<T> vVar = new v<>();
        vVar.key = str2;
        vVar.gJ = k.gJ;
        vVar.hA = k.hA;
        vVar.hP = k.hy;
        return vVar;
    }

    @Override // com.baidu.adp.lib.cache.s
    public void a(String str, String str2, T t, long j) {
        m<T> mVar = new m<>();
        mVar.hw = j(str, str2);
        mVar.hx = str;
        mVar.hA = j;
        mVar.gJ = t;
        mVar.hz = System.currentTimeMillis();
        mVar.hy = System.currentTimeMillis();
        c(mVar);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void n(String str, String str2) {
        P(j(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.s
    public f cJ() {
        return this.ht;
    }
}
