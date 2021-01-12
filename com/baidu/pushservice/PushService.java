package com.baidu.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.f.a;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
/* loaded from: classes14.dex */
public class PushService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4500a = false;

    /* renamed from: b  reason: collision with root package name */
    private Handler f4501b = new Handler();
    private boolean c = false;
    private final Runnable d = new Runnable() { // from class: com.baidu.pushservice.PushService.1
        @Override // java.lang.Runnable
        public void run() {
            g.b();
            PushService.this.stopSelf();
        }
    };
    private final Runnable e = new Runnable() { // from class: com.baidu.pushservice.PushService.2
        @Override // java.lang.Runnable
        public void run() {
            Process.killProcess(Process.myPid());
        }
    };

    private void a(boolean z, boolean z2) {
        this.f4500a = z;
        a.a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
        if (z2) {
            this.d.run();
            return;
        }
        this.f4501b.removeCallbacks(this.d);
        this.f4501b.postDelayed(this.d, 1000L);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a.a("PushService", "onCreate from : " + getPackageName(), getApplicationContext());
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
        a.a("PushService", "onDestroy from : " + getPackageName(), getApplicationContext());
        m.a("PushService onDestroy from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
        g.b();
        if (this.f4500a) {
            this.f4501b.removeCallbacks(this.e);
            this.f4501b.postDelayed(this.e, 1000L);
        }
        if (this.c) {
            try {
                sendBroadcast(f.a(this));
            } catch (Exception e) {
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            intent = new Intent();
            a.c("PushService", "--- onStart by null intent!", getApplicationContext());
        } else {
            try {
                m.a("PushService onStartCommand from " + getPackageName() + " Intent " + intent.toUri(0) + " at Time " + System.currentTimeMillis(), getApplicationContext());
            } catch (Exception e) {
                new b.c(getApplicationContext()).a(Log.getStackTraceString(e)).a();
            }
        }
        this.f4501b.removeCallbacks(this.d);
        this.f4501b.removeCallbacks(this.e);
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
