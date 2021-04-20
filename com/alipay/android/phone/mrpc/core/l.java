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
    public static l f1692b;
    public static final ThreadFactory i = new n();

    /* renamed from: a  reason: collision with root package name */
    public Context f1693a;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f1694c;

    /* renamed from: d  reason: collision with root package name */
    public b f1695d = b.a("android");

    /* renamed from: e  reason: collision with root package name */
    public long f1696e;

    /* renamed from: f  reason: collision with root package name */
    public long f1697f;

    /* renamed from: g  reason: collision with root package name */
    public long f1698g;

    /* renamed from: h  reason: collision with root package name */
    public int f1699h;

    public l(Context context) {
        this.f1693a = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.f1694c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.f1693a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final l a(Context context) {
        l lVar = f1692b;
        return lVar != null ? lVar : b(context);
    }

    public static final synchronized l b(Context context) {
        synchronized (l.class) {
            if (f1692b != null) {
                return f1692b;
            }
            l lVar = new l(context);
            f1692b = lVar;
            return lVar;
        }
    }

    public final b a() {
        return this.f1695d;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final Future<u> a(t tVar) {
        if (s.a(this.f1693a)) {
            String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.f1694c.getActiveCount());
            objArr[1] = Long.valueOf(this.f1694c.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.f1694c.getTaskCount());
            long j = this.f1698g;
            objArr[3] = Long.valueOf(j == 0 ? 0L : ((this.f1696e * 1000) / j) >> 10);
            int i2 = this.f1699h;
            objArr[4] = Long.valueOf(i2 != 0 ? this.f1697f / i2 : 0L);
            objArr[5] = Long.valueOf(this.f1696e);
            objArr[6] = Long.valueOf(this.f1697f);
            objArr[7] = Long.valueOf(this.f1698g);
            objArr[8] = Integer.valueOf(this.f1699h);
            String.format(str, objArr);
        }
        q qVar = new q(this, (o) tVar);
        m mVar = new m(this, qVar, qVar);
        this.f1694c.execute(mVar);
        return mVar;
    }

    public final void a(long j) {
        this.f1696e += j;
    }

    public final void b(long j) {
        this.f1697f += j;
        this.f1699h++;
    }

    public final void c(long j) {
        this.f1698g += j;
    }
}
