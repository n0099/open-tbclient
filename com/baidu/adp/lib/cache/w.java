package com.baidu.adp.lib.cache;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class w<T> implements v<T> {
    protected final r<T> a;
    protected final String b;
    private boolean c = false;

    public w(String str, r<T> rVar) {
        this.b = str;
        this.a = rVar;
    }

    @Override // com.baidu.adp.lib.cache.s
    public T a(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.j.b()) {
            if (this.c) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.a.c(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public u<T> b(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.j.b()) {
            if (this.c) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        return this.a.d(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void a(String str, T t, long j) {
        if (str == null) {
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
        long currentTimeMillis = j <= 315532800000L ? j + System.currentTimeMillis() : j;
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.j.b()) {
            if (this.c) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        if (currentTimeMillis <= System.currentTimeMillis()) {
            c(str);
        } else {
            this.a.a(this.b, str, t, currentTimeMillis);
        }
    }

    @Override // com.baidu.adp.lib.cache.s
    public void a(String str, T t) {
        a(str, t, 315532800000L);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void c(String str) {
        if (BdBaseApplication.getInst().isDebugMode() && com.baidu.adp.lib.util.j.b()) {
            if (this.c) {
                throw new RuntimeException("access db in main thread!");
            }
            BdLog.detailException("access db in main thread!", new Exception());
        }
        this.a.e(this.b, str);
    }

    @Override // com.baidu.adp.lib.cache.s
    public void a(String str, t<T> tVar) {
        com.baidu.adp.lib.f.d.a().a(new x(this, str, tVar));
    }

    @Override // com.baidu.adp.lib.cache.s
    public void b(String str, T t, long j) {
        com.baidu.adp.lib.f.d.a().a(new y(this, str, t, j));
    }

    @Override // com.baidu.adp.lib.cache.s
    public void d(String str) {
        com.baidu.adp.lib.f.d.a().a(new z(this, str));
    }

    @Override // com.baidu.adp.lib.cache.v
    public String a() {
        return this.b;
    }

    @Override // com.baidu.adp.lib.cache.v
    public r<T> b() {
        return this.a;
    }

    public void d() {
        this.a.e(this.b);
    }

    protected void e() {
        f a = b().a();
        if (a instanceof h) {
            ((h) a).e();
        }
    }

    @Override // com.baidu.adp.lib.cache.v
    public void c() {
        this.a.d(this.b);
        e();
    }
}
