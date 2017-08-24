package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.e;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m<T> implements l.d<T> {
    protected final String vd;
    private boolean vw = false;
    protected final k<T> vx;

    public m(String str, k<T> kVar) {
        this.vd = str;
        this.vx = kVar;
    }

    @Override // com.baidu.adp.lib.cache.l
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hH()) {
            if (this.vw) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.vx.k(this.vd, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public l.c<T> ad(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hH()) {
            if (this.vw) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.vx.l(this.vd, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hH()) {
            if (this.vw) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.vx.a(this.vd, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.l
    public void k(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hH()) {
            if (this.vw) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.vx.m(this.vd, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(final String str, final l.a<T> aVar) {
        com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.adp.lib.cache.m.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.adp.lib.cache.l$a */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                aVar.m(str, m.this.get(str));
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(final String str, final l.b<T> bVar) {
        com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.adp.lib.cache.m.2
            @Override // java.lang.Runnable
            public void run() {
                bVar.a(str, m.this.ad(str));
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l
    public void b(final String str, final T t, final long j) {
        com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.adp.lib.cache.m.3
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.adp.lib.cache.m */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                m.this.a(str, t, j);
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l
    public void l(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void ae(final String str) {
        com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.adp.lib.cache.m.4
            @Override // java.lang.Runnable
            public void run() {
                m.this.remove(str);
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l.d
    public String eS() {
        return this.vd;
    }

    @Override // com.baidu.adp.lib.cache.l.d
    public k<T> eT() {
        return this.vx;
    }

    public void eV() {
        this.vx.ac(this.vd);
    }

    protected void eW() {
        e eI = eT().eI();
        if (eI instanceof e.b) {
            ((e.b) eI).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.l.d
    public void eU() {
        this.vx.ab(this.vd);
        eW();
    }
}
