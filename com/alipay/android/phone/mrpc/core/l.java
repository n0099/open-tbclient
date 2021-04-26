package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class l implements ab {

    /* renamed from: b  reason: collision with root package name */
    public static l f1632b;

    /* renamed from: i  reason: collision with root package name */
    public static final ThreadFactory f1633i = new n();

    /* renamed from: a  reason: collision with root package name */
    public Context f1634a;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f1635c;

    /* renamed from: d  reason: collision with root package name */
    public b f1636d = b.a("android");

    /* renamed from: e  reason: collision with root package name */
    public long f1637e;

    /* renamed from: f  reason: collision with root package name */
    public long f1638f;

    /* renamed from: g  reason: collision with root package name */
    public long f1639g;

    /* renamed from: h  reason: collision with root package name */
    public int f1640h;

    public l(Context context) {
        this.f1634a = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f1633i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.f1635c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.f1634a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final l a(Context context) {
        l lVar = f1632b;
        return lVar != null ? lVar : b(context);
    }

    public static final synchronized l b(Context context) {
        synchronized (l.class) {
            if (f1632b != null) {
                return f1632b;
            }
            l lVar = new l(context);
            f1632b = lVar;
            return lVar;
        }
    }

    public final b a() {
        return this.f1636d;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final Future<u> a(t tVar) {
        if (s.a(this.f1634a)) {
            String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.f1635c.getActiveCount());
            objArr[1] = Long.valueOf(this.f1635c.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.f1635c.getTaskCount());
            long j = this.f1639g;
            objArr[3] = Long.valueOf(j == 0 ? 0L : ((this.f1637e * 1000) / j) >> 10);
            int i2 = this.f1640h;
            objArr[4] = Long.valueOf(i2 != 0 ? this.f1638f / i2 : 0L);
            objArr[5] = Long.valueOf(this.f1637e);
            objArr[6] = Long.valueOf(this.f1638f);
            objArr[7] = Long.valueOf(this.f1639g);
            objArr[8] = Integer.valueOf(this.f1640h);
            String.format(str, objArr);
        }
        q qVar = new q(this, (o) tVar);
        m mVar = new m(this, qVar, qVar);
        this.f1635c.execute(mVar);
        return mVar;
    }

    public final void a(long j) {
        this.f1637e += j;
    }

    public final void b(long j) {
        this.f1638f += j;
        this.f1640h++;
    }

    public final void c(long j) {
        this.f1639g += j;
    }
}
