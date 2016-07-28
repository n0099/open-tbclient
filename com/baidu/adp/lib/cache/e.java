package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.o;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements n<T> {
    protected final boolean jH;
    protected final f jI;

    public abstract h<T> M(String str);

    public abstract void N(String str);

    protected abstract void O(String str);

    public abstract void c(h<T> hVar);

    public e(f fVar, boolean z) {
        this.jI = fVar;
        this.jH = z;
    }

    protected String h(String str, String str2) {
        if (this.jH) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected h<T> j(String str, String str2) {
        String h = h(str, str2);
        h<T> M = M(h);
        if (M == null) {
            BdLog.isDebugMode();
            return null;
        } else if (M.jP < System.currentTimeMillis()) {
            O(h);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.jI.cz()) {
                M.jO = System.currentTimeMillis();
                c(M);
            }
            BdLog.isDebugMode();
            return M;
        }
    }

    @Override // com.baidu.adp.lib.cache.n
    public T k(String str, String str2) {
        h<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        return j.iZ;
    }

    @Override // com.baidu.adp.lib.cache.n
    public o.c<T> l(String str, String str2) {
        h<T> j = j(str, str2);
        if (j == null) {
            return null;
        }
        o.c<T> cVar = new o.c<>();
        cVar.key = str2;
        cVar.iZ = j.iZ;
        cVar.jP = j.jP;
        cVar.kf = j.jN;
        return cVar;
    }

    @Override // com.baidu.adp.lib.cache.n
    public void a(String str, String str2, T t, long j) {
        h<T> hVar = new h<>();
        hVar.jL = h(str, str2);
        hVar.jM = str;
        hVar.jP = j;
        hVar.iZ = t;
        hVar.jO = System.currentTimeMillis();
        hVar.jN = System.currentTimeMillis();
        c(hVar);
    }

    @Override // com.baidu.adp.lib.cache.n
    public void m(String str, String str2) {
        N(h(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.n
    public f cy() {
        return this.jI;
    }
}
