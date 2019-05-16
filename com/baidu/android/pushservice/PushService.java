package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import com.baidu.android.pushservice.i.l;
/* loaded from: classes3.dex */
public class PushService extends Service {
    private SDcardRemovedReceiver c;
    private boolean a = false;
    private Handler b = new Handler();
    private boolean d = false;
    private final Runnable e = new Runnable() { // from class: com.baidu.android.pushservice.PushService.1
        @Override // java.lang.Runnable
        public void run() {
            PushService.this.stopSelf();
            f.b();
            if (PushService.this.getPackageName().equals(l.v(PushService.this.getApplicationContext()))) {
                return;
            }
            PushService.this.onDestroy();
        }
    };

    private void a(boolean z, boolean z2) {
        this.a = z;
        com.baidu.android.pushservice.f.a.a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
        if (z2) {
            this.e.run();
            return;
        }
        this.b.removeCallbacks(this.e);
        this.b.postDelayed(this.e, 1000L);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.baidu.android.pushservice.f.a.a("PushService", "onCreate from : " + getPackageName(), getApplicationContext());
        l.b("PushService onCreate from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
        this.d = f.a(this).a();
        if (!this.d) {
            a(true, false);
            return;
        }
        try {
            this.c = new SDcardRemovedReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
            intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
            registerReceiver(this.c, intentFilter);
        } catch (Exception e) {
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.baidu.android.pushservice.f.a.a("PushService", "onDestroy from : " + getPackageName(), getApplicationContext());
        l.b("PushService onDestroy from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
        if (this.c != null) {
            try {
                unregisterReceiver(this.c);
            } catch (Exception e) {
            }
        }
        f.b();
        if (this.a) {
            Process.killProcess(Process.myPid());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.f.a.c("PushService", "--- onStart by null intent!", getApplicationContext());
        } else {
            try {
                l.b("PushService onStartCommand from " + getPackageName() + " Intent " + intent.toUri(0) + " at Time " + System.currentTimeMillis(), getApplicationContext());
            } catch (Exception e) {
            }
        }
        this.b.removeCallbacks(this.e);
        if ("com.baidu.android.pushservice.action.CROSS_REQUEST".equals(intent.getAction())) {
            com.baidu.android.pushservice.i.c.a(getApplicationContext(), intent);
        }
        try {
            this.d = f.a(this).a(intent);
            if (this.d) {
                return 1;
            }
            a(true, true);
            return 2;
        } catch (Exception e2) {
            a(true, true);
            return 2;
        }
    }
}
