package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.pushservice.util.Utility;
/* loaded from: classes.dex */
public class PushService extends Service {
    public boolean a = false;
    public Handler b = new Handler();
    public boolean c = false;
    public final Runnable d = new b();
    public final Runnable e = new c(this);

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ Intent c;

        public a(Intent intent) {
            this.c = intent;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            PushService pushService = PushService.this;
            pushService.c = f.a(pushService.getApplicationContext()).a(this.c);
            if (PushService.this.c) {
                return;
            }
            PushService.this.a(true, true);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.d();
            PushService.this.stopSelf();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c(PushService pushService) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.killProcess(Process.myPid());
        }
    }

    public final void a(boolean z, boolean z2) {
        this.a = z;
        com.baidu.android.pushservice.u.a.a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
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
        com.baidu.android.pushservice.u.a.a("PushService", "onCreate from : " + getPackageName(), getApplicationContext());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.baidu.android.pushservice.u.a.a("PushService", "onDestroy from : " + getPackageName(), getApplicationContext());
        f.d();
        if (this.a) {
            this.b.removeCallbacks(this.e);
            this.b.postDelayed(this.e, 1000L);
        }
        if (!this.c || f.a(this).j()) {
            return;
        }
        try {
            sendBroadcast(e.j(this));
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        com.baidu.android.pushservice.t.a.a(getApplicationContext()).a(intent);
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.u.a.c("PushService", "--- onStart by null intent!", getApplicationContext());
        } else {
            try {
                intent.toUri(0);
                String stringExtra = intent.getStringExtra("source");
                if (!TextUtils.isEmpty(stringExtra) && !stringExtra.equals(getPackageName()) && Build.VERSION.SDK_INT <= 23 && !Utility.b(this)) {
                    f.a(this).c();
                    a(true, true);
                    return 2;
                }
            } catch (Exception unused) {
            }
        }
        this.b.removeCallbacks(this.d);
        this.b.removeCallbacks(this.e);
        try {
            com.baidu.android.pushservice.z.e.a().a(new a(intent));
            return 1;
        } catch (Exception unused2) {
            a(true, true);
            return 2;
        }
    }
}
