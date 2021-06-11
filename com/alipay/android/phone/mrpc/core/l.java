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
    public static l f1645b;

    /* renamed from: i  reason: collision with root package name */
    public static final ThreadFactory f1646i = new n();

    /* renamed from: a  reason: collision with root package name */
    public Context f1647a;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f1648c;

    /* renamed from: d  reason: collision with root package name */
    public b f1649d = b.a("android");

    /* renamed from: e  reason: collision with root package name */
    public long f1650e;

    /* renamed from: f  reason: collision with root package name */
    public long f1651f;

    /* renamed from: g  reason: collision with root package name */
    public long f1652g;

    /* renamed from: h  reason: collision with root package name */
    public int f1653h;

    public l(Context context) {
        this.f1647a = context;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 11, 3L, TimeUnit.SECONDS, new ArrayBlockingQueue(20), f1646i, new ThreadPoolExecutor.CallerRunsPolicy());
        this.f1648c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        CookieSyncManager.createInstance(this.f1647a);
        CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final l a(Context context) {
        l lVar = f1645b;
        return lVar != null ? lVar : b(context);
    }

    public static final synchronized l b(Context context) {
        synchronized (l.class) {
            if (f1645b != null) {
                return f1645b;
            }
            l lVar = new l(context);
            f1645b = lVar;
            return lVar;
        }
    }

    public final b a() {
        return this.f1649d;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final Future<u> a(t tVar) {
        if (s.a(this.f1647a)) {
            String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(this.f1648c.getActiveCount());
            objArr[1] = Long.valueOf(this.f1648c.getCompletedTaskCount());
            objArr[2] = Long.valueOf(this.f1648c.getTaskCount());
            long j = this.f1652g;
            objArr[3] = Long.valueOf(j == 0 ? 0L : ((this.f1650e * 1000) / j) >> 10);
            int i2 = this.f1653h;
            objArr[4] = Long.valueOf(i2 != 0 ? this.f1651f / i2 : 0L);
            objArr[5] = Long.valueOf(this.f1650e);
            objArr[6] = Long.valueOf(this.f1651f);
            objArr[7] = Long.valueOf(this.f1652g);
            objArr[8] = Integer.valueOf(this.f1653h);
            String.format(str, objArr);
        }
        q qVar = new q(this, (o) tVar);
        m mVar = new m(this, qVar, qVar);
        this.f1648c.execute(mVar);
        return mVar;
    }

    public final void a(long j) {
        this.f1650e += j;
    }

    public final void b(long j) {
        this.f1651f += j;
        this.f1653h++;
    }

    public final void c(long j) {
        this.f1652g += j;
    }
}
