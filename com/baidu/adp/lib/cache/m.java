package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.e;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m<T> implements l.d<T> {
    protected final String vb;
    private boolean vu = false;
    protected final k<T> vv;

    public m(String str, k<T> kVar) {
        this.vb = str;
        this.vv = kVar;
    }

    @Override // com.baidu.adp.lib.cache.l
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hH()) {
            if (this.vu) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.vv.k(this.vb, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public l.c<T> ac(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hH()) {
            if (this.vu) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.vv.l(this.vb, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hH()) {
            if (this.vu) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.vv.a(this.vb, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.l
    public void k(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hH()) {
            if (this.vu) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.vv.m(this.vb, str);
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
                bVar.a(str, m.this.ac(str));
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
    public void ad(final String str) {
        com.baidu.adp.lib.g.h.gb().f(new Runnable() { // from class: com.baidu.adp.lib.cache.m.4
            @Override // java.lang.Runnable
            public void run() {
                m.this.remove(str);
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l.d
    public String eS() {
        return this.vb;
    }

    @Override // com.baidu.adp.lib.cache.l.d
    public k<T> eT() {
        return this.vv;
    }

    public void eV() {
        this.vv.ab(this.vb);
    }

    protected void eW() {
        e eI = eT().eI();
        if (eI instanceof e.b) {
            ((e.b) eI).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.l.d
    public void eU() {
        this.vv.aa(this.vb);
        eW();
    }
}
