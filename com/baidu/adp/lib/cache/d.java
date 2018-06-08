package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean xF;
    protected final e xG;

    public abstract g<T> ah(String str);

    public abstract void ai(String str);

    protected abstract void aj(String str);

    public abstract void c(g<T> gVar);

    public d(e eVar, boolean z) {
        this.xG = eVar;
        this.xF = z;
    }

    protected String j(String str, String str2) {
        if (this.xF) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected g<T> k(String str, String str2) {
        String j = j(str, str2);
        g<T> ah = ah(j);
        if (ah == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (ah.xN < System.currentTimeMillis()) {
            aj(j);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.xG.gX()) {
                ah.xM = System.currentTimeMillis();
                c(ah);
            }
            if (BdLog.isDebugMode()) {
            }
            return ah;
        }
    }

    @Override // com.baidu.adp.lib.cache.k
    public T l(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        return k.value;
    }

    @Override // com.baidu.adp.lib.cache.k
    public l.b<T> m(String str, String str2) {
        g<T> k = k(str, str2);
        if (k == null) {
            return null;
        }
        l.b<T> bVar = new l.b<>();
        bVar.key = str2;
        bVar.value = k.value;
        bVar.xN = k.xN;
        bVar.ya = k.xL;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void a(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.xJ = j(str, str2);
        gVar.xK = str;
        gVar.xN = j;
        gVar.value = t;
        gVar.xM = System.currentTimeMillis();
        gVar.xL = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void n(String str, String str2) {
        ai(j(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e gW() {
        return this.xG;
    }
}
