package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements s<T> {
    protected final boolean fq;
    protected final f fr;

    public abstract m<T> A(String str);

    public abstract void B(String str);

    protected abstract void C(String str);

    public abstract void c(m<T> mVar);

    public e(f fVar, boolean z) {
        this.fr = fVar;
        this.fq = z;
    }

    protected String c(String str, String str2) {
        if (this.fq) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected m<T> f(String str, String str2) {
        String c = c(str, str2);
        m<T> A = A(c);
        if (A == null) {
            BdLog.isDebugMode();
            return null;
        } else if (A.fy < System.currentTimeMillis()) {
            C(c);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.fr.ck()) {
                A.fx = System.currentTimeMillis();
                c(A);
            }
            BdLog.isDebugMode();
            return A;
        }
    }

    @Override // com.baidu.adp.lib.cache.s
    public T g(String str, String str2) {
        m<T> f = f(str, str2);
        if (f == null) {
            return null;
        }
        return f.value;
    }

    @Override // com.baidu.adp.lib.cache.s
    public v<T> h(String str, String str2) {
        m<T> f = f(str, str2);
        if (f == null) {
            return null;
        }
        v<T> vVar = new v<>();
        vVar.key = str2;
        vVar.value = f.value;
        vVar.fy = f.fy;
        vVar.fN = f.fw;
        return vVar;
    }

    @Override // com.baidu.adp.lib.cache.s
    public void a(String str, String str2, T t, long j) {
        m<T> mVar = new m<>();
        mVar.fu = c(str, str2);
        mVar.fv = str;
        mVar.fy = j;
        mVar.value = t;
        mVar.fx = System.currentTimeMillis();
        mVar.fw = System.currentTimeMillis();
        c(mVar);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void j(String str, String str2) {
        B(c(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.s
    public f ci() {
        return this.fr;
    }
}
