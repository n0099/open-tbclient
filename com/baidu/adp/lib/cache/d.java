package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    protected final boolean ym;
    protected final e yn;

    public abstract g<T> ai(String str);

    public abstract void aj(String str);

    protected abstract void ak(String str);

    public abstract void c(g<T> gVar);

    public d(e eVar, boolean z) {
        this.yn = eVar;
        this.ym = z;
    }

    protected String j(String str, String str2) {
        if (this.ym) {
            return str + "@" + str2;
        }
        return str2;
    }

    protected g<T> k(String str, String str2) {
        String j = j(str, str2);
        g<T> ai = ai(j);
        if (ai == null) {
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else if (ai.yu < System.currentTimeMillis()) {
            ak(j);
            if (BdLog.isDebugMode()) {
            }
            return null;
        } else {
            if (this.yn.hj()) {
                ai.yt = System.currentTimeMillis();
                c(ai);
            }
            if (BdLog.isDebugMode()) {
            }
            return ai;
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
        bVar.yu = k.yu;
        bVar.yH = k.ys;
        return bVar;
    }

    @Override // com.baidu.adp.lib.cache.k
    public void a(String str, String str2, T t, long j) {
        g<T> gVar = new g<>();
        gVar.yq = j(str, str2);
        gVar.yr = str;
        gVar.yu = j;
        gVar.value = t;
        gVar.yt = System.currentTimeMillis();
        gVar.ys = System.currentTimeMillis();
        c(gVar);
    }

    @Override // com.baidu.adp.lib.cache.k
    public void n(String str, String str2) {
        aj(j(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.k
    public e hi() {
        return this.yn;
    }
}
