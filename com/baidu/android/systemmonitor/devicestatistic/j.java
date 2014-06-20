package com.baidu.android.systemmonitor.devicestatistic;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Handler;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public final class j {
    private static j b = null;
    private boolean a;
    private Context d;
    private com.baidu.android.systemmonitor.devicestatistic.a.c c = null;
    private Handler e = new Handler();
    private int f = 0;
    private long g = 0;
    private long h = 0;
    private Runnable i = new f(this);

    public j(Context context) {
        this.a = false;
        this.d = null;
        if (Build.VERSION.SDK_INT < 8) {
            this.a = false;
            return;
        }
        this.a = TrafficStats.getTotalRxBytes() != -1;
        this.d = context.getApplicationContext();
    }

    public static synchronized j a(Context context) {
        j jVar;
        synchronized (j.class) {
            if (b == null) {
                b = new j(context);
            }
            jVar = b;
        }
        return jVar;
    }

    public static void c() {
        if (b != null) {
            b.d();
            b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.a && a() > this.h) {
            this.h = a();
        }
    }

    public long a() {
        if (this.a) {
            return TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes();
        }
        return -1L;
    }

    public void b() {
        if (this.a) {
            int b2 = com.baidu.android.systemmonitor.util.b.b(this.d);
            if (b2 == 0) {
                this.e.removeCallbacks(this.i);
                if (this.c != null) {
                    this.c.a = System.currentTimeMillis();
                    this.c.c = this.h - this.g;
                    g.a(this.d).a(this.c);
                }
                this.c = null;
                this.g = 0L;
                this.f = 0;
                this.h = 0L;
            } else if (this.c == null) {
                this.f = b2;
                this.c = new com.baidu.android.systemmonitor.devicestatistic.a.c(System.currentTimeMillis());
                this.c.b = this.f;
                this.g = a();
                this.e.postDelayed(this.i, TbConfig.USE_TIME_INTERVAL);
            } else if (b2 != this.f) {
                this.e.removeCallbacks(this.i);
                this.c.a = System.currentTimeMillis();
                this.c.c = this.h - this.g;
                g.a(this.d).a(this.c);
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
