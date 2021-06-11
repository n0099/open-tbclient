package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
/* loaded from: classes.dex */
public class PushService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2707a = false;

    /* renamed from: b  reason: collision with root package name */
    public Handler f2708b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public boolean f2709c = false;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f2710d = new Runnable() { // from class: com.baidu.android.pushservice.PushService.1
        @Override // java.lang.Runnable
        public void run() {
            g.b();
            PushService.this.stopSelf();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f2711e = new Runnable() { // from class: com.baidu.android.pushservice.PushService.2
        @Override // java.lang.Runnable
        public void run() {
            Process.killProcess(Process.myPid());
        }
    };

    private void a(boolean z, boolean z2) {
        this.f2707a = z;
        com.baidu.android.pushservice.g.a.a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
        if (z2) {
            this.f2710d.run();
            return;
        }
        this.f2708b.removeCallbacks(this.f2710d);
        this.f2708b.postDelayed(this.f2710d, 1000L);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.baidu.android.pushservice.g.a.a("PushService", "onCreate from : " + getPackageName(), getApplicationContext());
        m.a("PushService onCreate from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
        boolean a2 = g.a(this).a();
        this.f2709c = a2;
        if (a2) {
            return;
        }
        a(true, false);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.baidu.android.pushservice.g.a.a("PushService", "onDestroy from : " + getPackageName(), getApplicationContext());
        m.a("PushService onDestroy from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
        g.b();
        if (this.f2707a) {
            this.f2708b.removeCallbacks(this.f2711e);
            this.f2708b.postDelayed(this.f2711e, 1000L);
        }
        if (!this.f2709c || g.a(this).e()) {
            return;
        }
        try {
            sendBroadcast(f.a(this));
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.g.a.c("PushService", "--- onStart by null intent!", getApplicationContext());
        } else {
            try {
                String uri = intent.toUri(0);
                m.a("PushService onStartCommand from " + getPackageName() + " Intent " + uri + " at Time " + System.currentTimeMillis(), getApplicationContext());
                String stringExtra = intent.getStringExtra("source");
                if (!TextUtils.isEmpty(stringExtra) && !stringExtra.equals(getPackageName())) {
                    if (Build.VERSION.SDK_INT <= 23 && !m.i(this)) {
                        g.a(this).d();
                        a(true, true);
                        return 2;
                    }
                    new b.d(getApplicationContext()).d(501011L).a(System.currentTimeMillis()).c(stringExtra).a();
                }
            } catch (Exception e2) {
                new b.c(getApplicationContext()).a(Log.getStackTraceString(e2)).a();
            }
        }
        this.f2708b.removeCallbacks(this.f2710d);
        this.f2708b.removeCallbacks(this.f2711e);
        try {
            boolean a2 = g.a(this).a(intent);
            this.f2709c = a2;
            if (a2) {
                return 1;
            }
            a(true, true);
            return 2;
        } catch (Exception e3) {
            a(true, true);
            new b.c(getApplicationContext()).a(Log.getStackTraceString(e3)).a();
            return 2;
        }
    }
}
