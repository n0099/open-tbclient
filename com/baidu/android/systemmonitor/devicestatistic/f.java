package com.baidu.android.systemmonitor.devicestatistic;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public final class f {
    private static f b = null;

    /* renamed from: a  reason: collision with root package name */
    private boolean f821a;
    private Context d;
    private com.baidu.android.systemmonitor.devicestatistic.a.d c = null;
    private Handler e = new Handler();
    private int f = 0;
    private long g = 0;
    private long h = 0;
    private Runnable i = new g(this);

    public f(Context context) {
        this.f821a = false;
        this.d = null;
        if (Build.VERSION.SDK_INT < 8) {
            this.f821a = false;
            return;
        }
        this.f821a = TrafficStats.getTotalRxBytes() != -1;
        this.d = context.getApplicationContext();
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f(context);
            }
            fVar = b;
        }
        return fVar;
    }

    public static void c() {
        if (b != null) {
            b.d();
            b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f821a && a() > this.h) {
            this.h = a();
        }
    }

    public long a() {
        if (this.f821a) {
            return TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes();
        }
        return -1L;
    }

    public void b() {
        if (this.f821a) {
            int b2 = com.baidu.android.systemmonitor.d.c.b(this.d);
            if (b2 == 0) {
                this.e.removeCallbacks(this.i);
                if (this.c != null) {
                    this.c.f814a = System.currentTimeMillis();
                    this.c.c = this.h - this.g;
                    d.a(this.d).a(this.c);
                }
                this.c = null;
                this.g = 0L;
                this.f = 0;
                this.h = 0L;
            } else if (this.c == null) {
                this.f = b2;
                this.c = new com.baidu.android.systemmonitor.devicestatistic.a.d(System.currentTimeMillis());
                this.c.b = this.f;
                this.g = a();
                this.e.postDelayed(this.i, Util.MILLSECONDS_OF_MINUTE);
            } else if (b2 != this.f) {
                this.e.removeCallbacks(this.i);
                this.c.f814a = System.currentTimeMillis();
                this.c.c = this.h - this.g;
                d.a(this.d).a(this.c);
                this.c = null;
                this.g = 0L;
                this.f = 0;
                this.h = 0L;
                b();
            }
        }
    }

    public void d() {
        if (this.e != null) {
            this.e.removeCallbacks(this.i);
        }
        this.e = null;
    }
}
