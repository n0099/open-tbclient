package com.baidu.android.systemmonitor.devicestatistic;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.baidu.android.nebula.util.BDLocationManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public final class f {
    private static f a = null;
    private Context b;
    private Handler c = new Handler();
    private com.baidu.android.systemmonitor.devicestatistic.a.e d = null;
    private Runnable e = new e(this);

    private f(Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f(context);
            }
            fVar = a;
        }
        return fVar;
    }

    public static void f() {
        if (a != null) {
            a.e();
            a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.d == null || this.d.e == 0) {
            return;
        }
        d.a(this.b).a(this.d);
        this.d = null;
        this.c.removeCallbacks(this.e);
    }

    public void a() {
        this.d = new com.baidu.android.systemmonitor.devicestatistic.a.e(System.currentTimeMillis());
        this.d.a = BDLocationManager.d(this.b.getApplicationContext());
        this.d.d = com.baidu.android.systemmonitor.c.d.b(this.b);
        this.d.b = d();
        this.c.postDelayed(this.e, TbConfig.USE_TIME_INTERVAL);
    }

    public void b() {
        this.c.removeCallbacks(this.e);
        if (this.d != null) {
            if (this.d.c == 0) {
                this.d.c = d();
                this.d.e = System.currentTimeMillis();
            }
            g();
        }
    }

    public void c() {
        Intent registerReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver.getIntExtra("status", -1);
        boolean z = intExtra == 2;
        boolean z2 = intExtra == 5;
        boolean z3 = registerReceiver.getIntExtra("plugged", -1) == 2;
        int intExtra2 = registerReceiver.getIntExtra("level", 0);
        if (this.d == null) {
            this.c.removeCallbacks(this.e);
        } else if (z) {
            if (this.d.f == -1) {
                this.d.f = z3 ? 0 : 1;
            }
        } else if (!z2) {
            this.c.removeCallbacks(this.e);
            this.d = null;
        } else {
            if (this.d.f == -1) {
                this.d.f = z3 ? 0 : 1;
            }
            this.d.e = System.currentTimeMillis();
            this.d.c = intExtra2;
        }
    }

    public int d() {
        long currentTimeMillis = System.currentTimeMillis();
        int intExtra = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("level", 0);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        return intExtra;
    }

    public void e() {
        if (this.c != null) {
            this.c.removeCallbacks(this.e);
        }
        this.c = null;
    }
}
