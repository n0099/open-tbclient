package com.baidu.adp.lib.cache;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public abstract class e<T> implements r<T> {
    protected final boolean a;
    protected final f b;

    public abstract m<T> a(String str);

    public abstract void a(m<T> mVar);

    public abstract void b(String str);

    protected abstract void c(String str);

    public e(f fVar, boolean z) {
        this.b = fVar;
        this.a = z;
    }

    protected String a(String str, String str2) {
        if (this.a) {
            return String.valueOf(str) + "@" + str2;
        }
        return str2;
    }

    protected m<T> b(String str, String str2) {
        String a = a(str, str2);
        m<T> a2 = a(a);
        if (a2 == null) {
            BdLog.isDebugMode();
            return null;
        } else if (a2.f < System.currentTimeMillis()) {
            c(a);
            BdLog.isDebugMode();
            return null;
        } else {
            if (this.b.b()) {
                a2.e = System.currentTimeMillis();
                a(a2);
            }
            BdLog.isDebugMode();
            return a2;
        }
    }

    @Override // com.baidu.adp.lib.cache.r
    public T c(String str, String str2) {
        m<T> b = b(str, str2);
        if (b == null) {
            return null;
        }
        return b.b;
    }

    @Override // com.baidu.adp.lib.cache.r
    public u<T> d(String str, String str2) {
        m<T> b = b(str, str2);
        if (b == null) {
            return null;
        }
        u<T> uVar = new u<>();
        uVar.a = str2;
        uVar.b = b.b;
        uVar.d = b.f;
        uVar.c = b.d;
        return uVar;
    }

    @Override // com.baidu.adp.lib.cache.r
    public void a(String str, String str2, T t, long j) {
        m<T> mVar = new m<>();
        mVar.a = a(str, str2);
        mVar.c = str;
        mVar.f = j;
        mVar.b = t;
        mVar.e = System.currentTimeMillis();
        mVar.d = System.currentTimeMillis();
        a(mVar);
    }

    @Override // com.baidu.adp.lib.cache.r
    public void e(String str, String str2) {
        b(a(str, str2));
    }

    @Override // com.baidu.adp.lib.cache.r
    public f a() {
        return this.b;
    }
}
