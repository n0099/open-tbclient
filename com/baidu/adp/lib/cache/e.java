package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements n<T> {
    protected final boolean ts;
    protected final f tt;

    public abstract h<T> J(String str);

    public abstract void K(String str);

    protected abstract void L(String str);

    public abstract void c(h<T> hVar);

    public e(f fVar, boolean z) {
        this.tt = fVar;
        this.ts = z;
    }

    protected String h(String str, String str2) {
        if (this.ts) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected h<T> j(String str, String str2) {
        String h = h(str, str2);
        h<T> J = J(h);
        if (J == null) {
            BdLog.isDebugMode();
            return null;
        } else if (J.tA < System.currentTimeMillis()) {
            L(h);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.tt.eB()) {
                J.tz = System.currentTimeMillis();
                c(J);
            }
            BdLog.isDebugMode();
            return J;
        }
    }

    @Override // com.baidu.adp.lib.cache.n
    public T k(String str, String str2) {
        h<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        return j.sH;
    }

    @Override // com.baidu.adp.lib.cache.n
    public o.c<T> l(String str, String str2) {
        h<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        o.c<T> cVar = new o.c<>();
        cVar.key = str2;
        cVar.sH = j.sH;
        cVar.tA = j.tA;
        cVar.tP = j.ty;
        return cVar;
    }

    @Override // com.baidu.adp.lib.cache.n
    public void a(String str, String str2, T t, long j) {
        h<T> hVar = new h<>();
        hVar.tw = h(str, str2);
        hVar.tx = str;
        hVar.tA = j;
        hVar.sH = t;
        hVar.tz = System.currentTimeMillis();
        hVar.ty = System.currentTimeMillis();
        c(hVar);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void m(String str, String str2) {
        K(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.n
    public f eA() {
        return this.tt;
    }
}
