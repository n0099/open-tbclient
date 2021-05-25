package com.baidu.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
/* loaded from: classes2.dex */
public class PushService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9393a = false;

    /* renamed from: b  reason: collision with root package name */
    public Handler f9394b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public boolean f9395c = false;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f9396d = new a();

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f9397e = new b();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.b();
            PushService.this.stopSelf();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.killProcess(Process.myPid());
        }
    }

    private void a(boolean z, boolean z2) {
        this.f9393a = z;
        com.baidu.android.pushservice.g.a.a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
        if (z2) {
            this.f9396d.run();
            return;
        }
        this.f9394b.removeCallbacks(this.f9396d);
        this.f9394b.postDelayed(this.f9396d, 1000L);
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
        this.f9395c = a2;
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
        if (this.f9393a) {
            this.f9394b.removeCallbacks(this.f9397e);
            this.f9394b.postDelayed(this.f9397e, 1000L);
        }
        if (this.f9395c) {
            try {
                sendBroadcast(f.a(this));
            } catch (Exception unused) {
            }
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
            } catch (Exception e2) {
                new b.c(getApplicationContext()).a(Log.getStackTraceString(e2)).a();
            }
        }
        this.f9394b.removeCallbacks(this.f9396d);
        this.f9394b.removeCallbacks(this.f9397e);
        try {
            boolean a2 = g.a(this).a(intent);
            this.f9395c = a2;
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
