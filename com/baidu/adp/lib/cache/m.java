package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.e;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m<T> implements l.c<T> {
    protected final String xC;
    private boolean xT = false;
    protected final k<T> xU;

    public m(String str, k<T> kVar) {
        this.xC = str;
        this.xU = kVar;
    }

    @Override // com.baidu.adp.lib.cache.l
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.jU()) {
            if (this.xT) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.xU.l(this.xC, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public l.b<T> ao(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.jU()) {
            if (this.xT) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.xU.m(this.xC, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.jU()) {
            if (this.xT) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.xU.a(this.xC, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.l
    public void e(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.jU()) {
            if (this.xT) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.xU.n(this.xC, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(final String str, final l.a<T> aVar) {
        com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.adp.lib.cache.m.1
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
        com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.adp.lib.cache.m.2
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
    public void ap(final String str) {
        com.baidu.adp.lib.g.h.io().d(new Runnable() { // from class: com.baidu.adp.lib.cache.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.remove(str);
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public String hf() {
        return this.xC;
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public k<T> hg() {
        return this.xU;
    }

    public void hi() {
        this.xU.an(this.xC);
    }

    protected void hj() {
        e gV = hg().gV();
        if (gV instanceof e.b) {
            ((e.b) gV).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public void hh() {
        this.xU.am(this.xC);
        hj();
    }
}
