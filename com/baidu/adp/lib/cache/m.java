package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.e;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m<T> implements l.c<T> {
    protected final String sQ;
    private boolean tk = false;
    protected final k<T> tl;

    public m(String str, k<T> kVar) {
        this.sQ = str;
        this.tl = kVar;
    }

    @Override // com.baidu.adp.lib.cache.l
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.hx()) {
            if (this.tk) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tl.k(this.sQ, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public l.b<T> W(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.hx()) {
            if (this.tk) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tl.l(this.sQ, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.hx()) {
            if (this.tk) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.tl.a(this.sQ, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.l
    public void e(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.hx()) {
            if (this.tk) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.tl.m(this.sQ, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(final String str, final l.a<T> aVar) {
        com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.adp.lib.cache.m.1
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.adp.lib.cache.l$a */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                aVar.g(str, m.this.get(str));
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l
    public void b(final String str, final T t, final long j) {
        com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.adp.lib.cache.m.2
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.adp.lib.cache.m */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                m.this.a(str, t, j);
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l
    public void f(String str, T t) {
        b(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void X(final String str) {
        com.baidu.adp.lib.g.h.fQ().d(new Runnable() { // from class: com.baidu.adp.lib.cache.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.remove(str);
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public String eG() {
        return this.sQ;
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public k<T> eH() {
        return this.tl;
    }

    public void eJ() {
        this.tl.V(this.sQ);
    }

    protected void eK() {
        e ew = eH().ew();
        if (ew instanceof e.b) {
            ((e.b) ew).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public void eI() {
        this.tl.U(this.sQ);
        eK();
    }
}
