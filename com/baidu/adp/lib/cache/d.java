package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean yr;
    protected final e ys;

    public abstract g<T> aj(String str);

    public abstract void ak(String str);

    protected abstract void al(String str);

    public abstract void c(g<T> gVar);

    public d(e eVar, boolean z) {
        this.ys = eVar;
        this.yr = z;
    }

    protected String j(String str, String str2) {
        if (this.yr) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected g<T> k(String str, String str2) {
        String j = j(str, str2);
        g<T> aj = aj(j);
        if (aj == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (aj.yz < System.currentTimeMillis()) {
            al(j);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.ys.ht()) {
                aj.yy = System.currentTimeMillis();
                c(aj);
            }
            if (BdLog.isDebugMode()) {
            }
            return aj;
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
        bVar.yz = k.yz;
        bVar.yM = k.yx;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void a(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.yv = j(str, str2);
        gVar.yw = str;
        gVar.yz = j;
        gVar.value = t;
        gVar.yy = System.currentTimeMillis();
        gVar.yx = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void n(String str, String str2) {
        ak(j(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e hr() {
        return this.ys;
    }
}
