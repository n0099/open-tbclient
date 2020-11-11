package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.LocalServerSocket;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.jni.PushSocket;
import java.io.IOException;
@SuppressLint({"WorldReadableFiles", "InlinedApi"})
/* loaded from: classes10.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f1084a;
    private static LocalServerSocket e;
    private static boolean m;
    private e c;
    private Context h;
    private Handler i;
    private boolean j;
    private PushServiceReceiver k;
    private boolean l;
    private static final Object d = new Object();
    private static final Object g = new Object();
    private Boolean f = false;
    private Runnable n = new Runnable() { // from class: com.baidu.android.pushservice.g.2
        @Override // java.lang.Runnable
        public void run() {
            g.this.a(new Intent());
        }
    };
    private Runnable o = new Runnable() { // from class: com.baidu.android.pushservice.g.3
        @Override // java.lang.Runnable
        public void run() {
            synchronized (g.d) {
                if (g.this.c != null) {
                    g.this.c.b();
                }
            }
        }
    };
    private int b = 180000;

    private g(Context context) {
        this.i = new Handler(context.getMainLooper());
        this.h = context.getApplicationContext();
    }

    public static g a(Context context) {
        if (f1084a == null) {
            synchronized (g.class) {
                if (f1084a == null) {
                    f1084a = new g(context);
                }
            }
        }
        return f1084a;
    }

    public static void b() {
        if (f1084a != null) {
            f1084a.k();
        }
        com.baidu.android.pushservice.g.d.a().b();
    }

    private void i() {
        if (this.k == null) {
            this.k = new PushServiceReceiver();
            this.h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
            this.h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
            this.h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void j() {
        if (this.k != null) {
            this.h.getApplicationContext().unregisterReceiver(this.k);
        }
    }

    private void k() {
        com.baidu.android.pushservice.f.a.a("PushSDK", "destroy", this.h);
        synchronized (g) {
            try {
                if (e != null) {
                    e.close();
                    e = null;
                }
            } catch (IOException e2) {
            }
            if (this.c != null) {
                synchronized (d) {
                    if (this.c != null) {
                        this.c.c();
                        this.c = null;
                    }
                }
            }
            try {
                com.baidu.android.pushservice.c.a.a();
            } catch (Exception e3) {
            }
            if (this.j) {
                j();
            }
            f1084a = null;
        }
    }

    private void l() {
        synchronized (d) {
            this.c = e.a(this.h);
        }
    }

    private void m() {
        long j;
        long currentTimeMillis = System.currentTimeMillis() + this.b;
        int i = ((int) (currentTimeMillis / 1000)) % 60;
        if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i < 15) {
            currentTimeMillis += ((long) (Math.random() * (this.b - 20000))) + 15000;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            j = System.currentTimeMillis() + 60000;
            this.b = 60000;
        } else {
            j = currentTimeMillis;
        }
        AlarmManager alarmManager = (AlarmManager) this.h.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            try {
                alarmManager.setRepeating(0, j, this.b, r());
                m = false;
            } catch (Exception e2) {
            }
        }
    }

    private void n() {
        com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("tryConnect", (short) 98) { // from class: com.baidu.android.pushservice.g.1
            @Override // com.baidu.android.pushservice.g.c
            public void a() {
                if (g.f1084a == null) {
                    return;
                }
                boolean a2 = com.baidu.android.pushservice.i.g.a(g.this.h);
                com.baidu.android.pushservice.f.a.a("PushSDK", "tryConnect networkConnected :" + a2, g.this.h);
                if (a2) {
                    if (g.this.c != null && !g.this.c.a()) {
                        if (j.a(g.this.h).e()) {
                            g.this.q();
                        }
                    } else if (g.this.c == null || !g.this.c.a()) {
                    } else {
                        com.baidu.android.pushservice.f.a.a("PushSDK", "tryConnect heartbeat", g.this.h);
                        g.this.p();
                    }
                }
            }
        });
    }

    private boolean o() {
        if (e == null) {
            try {
                e = new LocalServerSocket(m.h(this.h));
            } catch (Exception e2) {
                com.baidu.android.pushservice.f.a.a("PushSDK", "--- Socket Adress (" + m.h(this.h) + ") in use --- @ " + this.h.getPackageName(), this.h);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        boolean a2 = com.baidu.android.pushservice.i.g.a(this.h);
        com.baidu.android.pushservice.f.a.a("PushSDK", "heartbeat networkConnected :" + a2, this.h);
        if (m.b(this.h)) {
            d();
            return false;
        } else if (!a2) {
            if (this.c != null) {
                this.c.a(true);
                return true;
            }
            return true;
        } else if (this.c != null) {
            if (!this.c.a()) {
                if (j.a(this.h).e()) {
                    q();
                    return true;
                }
                return true;
            }
            this.c.d();
            if (this.l) {
                return true;
            }
            this.l = true;
            m.l(f());
            return true;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (e != null || o()) {
            this.i.removeCallbacks(this.o);
            this.i.post(this.o);
        }
    }

    private PendingIntent r() {
        return PendingIntent.getBroadcast(this.h.getApplicationContext(), 0, f.a(this.h), 134217728);
    }

    public void a(int i) {
        if (m) {
            return;
        }
        com.baidu.android.pushservice.f.a.a("PushSDK", "heartbeat set : " + i + " millisecs", this.h);
        if (i > 0) {
            this.b = i;
        }
        m();
    }

    public boolean a() {
        d();
        this.f = true;
        if (m.b(this.h.getApplicationContext())) {
            com.baidu.android.pushservice.f.a.a("PushSDK", "onCreate shouldStopSelf", this.h);
            return false;
        }
        synchronized (g) {
            if (PushSocket.f1158a) {
                if (o()) {
                    this.j = m.p(this.h);
                    if (this.j) {
                        i();
                    }
                    h.b(this.h);
                    Thread.setDefaultUncaughtExceptionHandler(new b(this.h.getApplicationContext(), Thread.getDefaultUncaughtExceptionHandler()));
                    l();
                    i.a(this.h);
                    if (e != null) {
                        this.i.postDelayed(this.n, 500L);
                        n();
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public boolean a(Intent intent) {
        boolean z = false;
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.f.a.c("PushSDK", "--- handleOnStart by null intent!", this.h);
        }
        if (!com.baidu.android.pushservice.b.d.q(this.h) || com.baidu.android.pushservice.b.d.c(this.h)) {
            if (!this.f.booleanValue()) {
                a();
            }
            m = intent.getBooleanExtra("disable_alarm", false);
            synchronized (g) {
                this.i.removeCallbacks(this.n);
                if (e == null) {
                    String action = intent.getAction();
                    z = ("com.baidu.android.pushservice.action.METHOD".equals(action) || "com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) || "com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) ? c().a(intent) : true;
                } else if (intent.getStringExtra(Constants.EXTRA_ALARM_ALERT) != null) {
                    z = p();
                } else if (!"pushservice_quit".equals(intent.getStringExtra("method")) || e == null) {
                    if (c().a(intent)) {
                        com.baidu.android.pushservice.f.a.c("PushSDK", "-- handleOnStart -- intent handled  by mRegistrationService ", this.h);
                        z = true;
                    } else {
                        n();
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public i c() {
        return i.a(this.h);
    }

    public void d() {
        AlarmManager alarmManager = (AlarmManager) this.h.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            try {
                alarmManager.cancel(r());
                m = true;
            } catch (Exception e2) {
            }
        }
    }

    public boolean e() {
        return m;
    }

    public Context f() {
        return this.h;
    }
}
