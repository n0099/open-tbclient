package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements s<T> {
    protected final boolean tb;
    protected final f tc;

    public abstract m<T> X(String str);

    public abstract void Y(String str);

    protected abstract void Z(String str);

    public abstract void c(m<T> mVar);

    public e(f fVar, boolean z) {
        this.tc = fVar;
        this.tb = z;
    }

    protected String j(String str, String str2) {
        if (this.tb) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected m<T> k(String str, String str2) {
        String j = j(str, str2);
        m<T> X = X(j);
        if (X == null) {
            BdLog.isDebugMode();
            return null;
        } else if (X.tj < System.currentTimeMillis()) {
            Z(j);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.tc.gm()) {
                X.ti = System.currentTimeMillis();
                c(X);
            }
            BdLog.isDebugMode();
            return X;
        }
    }

    @Override // com.baidu.adp.lib.cache.s
    public T l(String str, String str2) {
        m<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.ss;
    }

    @Override // com.baidu.adp.lib.cache.s
    public v<T> m(String str, String str2) {
        m<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        v<T> vVar = new v<>();
        vVar.key = str2;
        vVar.ss = k.ss;
        vVar.tj = k.tj;
        vVar.tz = k.th;
        return vVar;
    }

    @Override // com.baidu.adp.lib.cache.s
    public void a(String str, String str2, T t, long j) {
        m<T> mVar = new m<>();
        mVar.tf = j(str, str2);
        mVar.tg = str;
        mVar.tj = j;
        mVar.ss = t;
        mVar.ti = System.currentTimeMillis();
        mVar.th = System.currentTimeMillis();
        c(mVar);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void n(String str, String str2) {
        Y(j(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.s
    public f gk() {
        return this.tc;
    }
}
