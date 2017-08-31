package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.e;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m<T> implements l.c<T> {
    protected final String sP;
    private boolean tj = false;
    protected final k<T> tk;

    public m(String str, k<T> kVar) {
        this.sP = str;
        this.tk = kVar;
    }

    @Override // com.baidu.adp.lib.cache.l
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hy()) {
            if (this.tj) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tk.k(this.sP, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public l.b<T> W(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hy()) {
            if (this.tj) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.tk.l(this.sP, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hy()) {
            if (this.tj) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.tk.a(this.sP, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.l
    public void e(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.k.hy()) {
            if (this.tj) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.tk.m(this.sP, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(final String str, final l.a<T> aVar) {
        com.baidu.adp.lib.g.h.fR().d(new Runnable() { // from class: com.baidu.adp.lib.cache.m.1
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
        com.baidu.adp.lib.g.h.fR().d(new Runnable() { // from class: com.baidu.adp.lib.cache.m.2
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
        com.baidu.adp.lib.g.h.fR().d(new Runnable() { // from class: com.baidu.adp.lib.cache.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.remove(str);
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public String eH() {
        return this.sP;
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public k<T> eI() {
        return this.tk;
    }

    public void eK() {
        this.tk.V(this.sP);
    }

    protected void eL() {
        e ex = eI().ex();
        if (ex instanceof e.b) {
            ((e.b) ex).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public void eJ() {
        this.tk.U(this.sP);
        eL();
    }
}
