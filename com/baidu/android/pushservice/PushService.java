package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
/* loaded from: classes10.dex */
public class PushService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1000a = false;
    private Handler b = new Handler();
    private boolean c = false;
    private final Runnable d = new Runnable() { // from class: com.baidu.android.pushservice.PushService.1
        @Override // java.lang.Runnable
        public void run() {
            g.b();
            PushService.this.stopSelf();
        }
    };
    private final Runnable e = new Runnable() { // from class: com.baidu.android.pushservice.PushService.2
        @Override // java.lang.Runnable
        public void run() {
            Process.killProcess(Process.myPid());
        }
    };

    private void a(boolean z, boolean z2) {
        this.f1000a = z;
        com.baidu.android.pushservice.f.a.a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
        if (z2) {
            this.d.run();
            return;
        }
        this.b.removeCallbacks(this.d);
        this.b.postDelayed(this.d, 1000L);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.baidu.android.pushservice.f.a.a("PushService", "onCreate from : " + getPackageName(), getApplicationContext());
        m.a("PushService onCreate from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
        this.c = g.a(this).a();
        if (this.c) {
            return;
        }
        a(true, false);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.baidu.android.pushservice.f.a.a("PushService", "onDestroy from : " + getPackageName(), getApplicationContext());
        m.a("PushService onDestroy from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
        g.b();
        if (this.f1000a) {
            this.b.removeCallbacks(this.e);
            this.b.postDelayed(this.e, 1000L);
        }
        if (!this.c || g.a(this).e()) {
            return;
        }
        try {
            sendBroadcast(f.a(this));
        } catch (Exception e) {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.f.a.c("PushService", "--- onStart by null intent!", getApplicationContext());
        } else {
            try {
                m.a("PushService onStartCommand from " + getPackageName() + " Intent " + intent.toUri(0) + " at Time " + System.currentTimeMillis(), getApplicationContext());
                String stringExtra = intent.getStringExtra("source");
                if (!TextUtils.isEmpty(stringExtra) && !stringExtra.equals(getPackageName())) {
                    if (Build.VERSION.SDK_INT <= 23 && !m.j(this)) {
                        g.a(this).d();
                        a(true, true);
                        return 2;
                    }
                    new b.d(getApplicationContext()).d(501011L).a(System.currentTimeMillis()).c(stringExtra).a();
                }
            } catch (Exception e) {
                new b.c(getApplicationContext()).a(Log.getStackTraceString(e)).a();
            }
        }
        this.b.removeCallbacks(this.d);
        this.b.removeCallbacks(this.e);
        try {
            this.c = g.a(this).a(intent);
            if (this.c) {
                return 1;
            }
            a(true, true);
            return 2;
        } catch (Exception e2) {
            a(true, true);
            new b.c(getApplicationContext()).a(Log.getStackTraceString(e2)).a();
            return 2;
        }
    }
}
