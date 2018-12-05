package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.cache.e;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class m<T> implements l.c<T> {
    protected final String AI;
    private boolean Bb = false;
    protected final k<T> Bc;

    public m(String str, k<T> kVar) {
        this.AI = str;
        this.Bc = kVar;
    }

    @Override // com.baidu.adp.lib.cache.l
    public T get(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.lk()) {
            if (this.Bb) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.Bc.s(this.AI, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public l.b<T> aF(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.lk()) {
            if (this.Bb) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.Bc.t(this.AI, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.lk()) {
            if (this.Bb) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            remove(str);
        } else {
            this.Bc.a(this.AI, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.l
    public void e(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void remove(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.l.lk()) {
            if (this.Bb) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.Bc.u(this.AI, str);
    }

    @Override // com.baidu.adp.lib.cache.l
    public void a(final String str, final l.a<T> aVar) {
        com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.adp.lib.cache.m.1
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
        com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.adp.lib.cache.m.2
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
    public void aG(final String str) {
        com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.adp.lib.cache.m.3
            @Override // java.lang.Runnable
            public void run() {
                m.this.remove(str);
            }
        });
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public String iA() {
        return this.AI;
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public k<T> iB() {
        return this.Bc;
    }

    public void iD() {
        this.Bc.aE(this.AI);
    }

    protected void iE() {
        e iq = iB().iq();
        if (iq instanceof e.b) {
            ((e.b) iq).release();
        }
    }

    @Override // com.baidu.adp.lib.cache.l.c
    public void iC() {
        this.Bc.aD(this.AI);
        iE();
    }
}
