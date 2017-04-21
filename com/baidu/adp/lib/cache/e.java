package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements n<T> {
    protected final boolean tr;
    protected final f ts;

    public abstract h<T> J(String str);

    public abstract void K(String str);

    protected abstract void L(String str);

    public abstract void c(h<T> hVar);

    public e(f fVar, boolean z) {
        this.ts = fVar;
        this.tr = z;
    }

    protected String h(String str, String str2) {
        if (this.tr) {
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
        } else if (J.tz < System.currentTimeMillis()) {
            L(h);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.ts.eB()) {
                J.ty = System.currentTimeMillis();
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
        return j.sG;
    }

    @Override // com.baidu.adp.lib.cache.n
    public o.c<T> l(String str, String str2) {
        h<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        o.c<T> cVar = new o.c<>();
        cVar.key = str2;
        cVar.sG = j.sG;
        cVar.tz = j.tz;
        cVar.tO = j.tx;
        return cVar;
    }

    @Override // com.baidu.adp.lib.cache.n
    public void a(String str, String str2, T t, long j) {
        h<T> hVar = new h<>();
        hVar.f0tv = h(str, str2);
        hVar.tw = str;
        hVar.tz = j;
        hVar.sG = t;
        hVar.ty = System.currentTimeMillis();
        hVar.tx = System.currentTimeMillis();
        c(hVar);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void m(String str, String str2) {
        K(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.n
    public f eA() {
        return this.ts;
    }
}
