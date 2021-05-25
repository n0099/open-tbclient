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
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.IOException;
@SuppressLint({"WorldReadableFiles", "InlinedApi"})
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f3110a;

    /* renamed from: e  reason: collision with root package name */
    public static LocalServerSocket f3112e;
    public static boolean m;

    /* renamed from: c  reason: collision with root package name */
    public e f3115c;

    /* renamed from: h  reason: collision with root package name */
    public Context f3117h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f3118i;
    public boolean j;
    public PushServiceReceiver k;
    public boolean l;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f3111d = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static final Object f3113g = new Object();

    /* renamed from: f  reason: collision with root package name */
    public Boolean f3116f = Boolean.FALSE;
    public Runnable n = new Runnable() { // from class: com.baidu.android.pushservice.g.2
        @Override // java.lang.Runnable
        public void run() {
            g.this.a(new Intent());
        }
    };
    public Runnable o = new Runnable() { // from class: com.baidu.android.pushservice.g.3
        @Override // java.lang.Runnable
        public void run() {
            synchronized (g.f3111d) {
                if (g.this.f3115c != null) {
                    g.this.f3115c.b();
                }
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public int f3114b = TiebaStatic.MAX_COST_VALUE;

    public g(Context context) {
        this.f3118i = new Handler(context.getMainLooper());
        this.f3117h = context.getApplicationContext();
    }

    public static g a(Context context) {
        if (f3110a == null) {
            synchronized (g.class) {
                if (f3110a == null) {
                    f3110a = new g(context);
                }
            }
        }
        return f3110a;
    }

    public static void b() {
        if (f3110a != null) {
            f3110a.l();
        }
        com.baidu.android.pushservice.h.d.a().b();
    }

    private void j() {
        if (this.k == null) {
            this.k = new PushServiceReceiver();
            this.f3117h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
            this.f3117h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
            this.f3117h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.f3117h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void k() {
        if (this.k != null) {
            this.f3117h.getApplicationContext().unregisterReceiver(this.k);
        }
    }

    private void l() {
        com.baidu.android.pushservice.g.a.a("PushSDK", "destroy", this.f3117h);
        synchronized (f3113g) {
            try {
                if (f3112e != null) {
                    f3112e.close();
                    f3112e = null;
                }
            } catch (IOException unused) {
            }
            if (this.f3115c != null) {
                synchronized (f3111d) {
                    if (this.f3115c != null) {
                        this.f3115c.c();
                        this.f3115c = null;
                    }
                }
            }
            try {
                com.baidu.android.pushservice.c.a.a();
            } catch (Exception unused2) {
            }
            if (this.j) {
                k();
            }
            f3110a = null;
        }
    }

    private void m() {
        synchronized (f3111d) {
            this.f3115c = e.a(this.f3117h);
        }
    }

    private void n() {
        long currentTimeMillis = System.currentTimeMillis() + this.f3114b;
        int i2 = ((int) (currentTimeMillis / 1000)) % 60;
        if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i2 < 15) {
            currentTimeMillis += ((long) (Math.random() * (this.f3114b - 20000))) + 15000;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            currentTimeMillis = System.currentTimeMillis() + 60000;
            this.f3114b = 60000;
        }
        long j = currentTimeMillis;
        AlarmManager alarmManager = (AlarmManager) this.f3117h.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            try {
                alarmManager.setRepeating(0, j, this.f3114b, s());
                m = false;
            } catch (Exception unused) {
            }
        }
    }

    private void o() {
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("tryConnect", (short) 98) { // from class: com.baidu.android.pushservice.g.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                if (g.f3110a == null) {
                    return;
                }
                boolean a2 = com.baidu.android.pushservice.j.g.a(g.this.f3117h);
                com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect networkConnected :" + a2, g.this.f3117h);
                if (a2) {
                    if (g.this.f3115c != null && !g.this.f3115c.a()) {
                        if (k.a(g.this.f3117h).e()) {
                            g.this.r();
                        }
                    } else if (g.this.f3115c == null || !g.this.f3115c.a()) {
                    } else {
                        com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect heartbeat", g.this.f3117h);
                        g.this.q();
                    }
                }
            }
        });
    }

    private boolean p() {
        if (f3112e == null) {
            try {
                f3112e = new LocalServerSocket(m.h(this.f3117h));
                return true;
            } catch (Exception unused) {
                com.baidu.android.pushservice.g.a.a("PushSDK", "--- Socket Adress (" + m.h(this.f3117h) + ") in use --- @ " + this.f3117h.getPackageName(), this.f3117h);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        boolean a2 = com.baidu.android.pushservice.j.g.a(this.f3117h);
        com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat networkConnected :" + a2, this.f3117h);
        if (m.b(this.f3117h)) {
            d();
            return false;
        } else if (!a2) {
            e eVar = this.f3115c;
            if (eVar != null) {
                eVar.a(true);
            }
            return true;
        } else {
            e eVar2 = this.f3115c;
            if (eVar2 != null) {
                if (eVar2.a()) {
                    this.f3115c.d();
                    if (!this.l) {
                        this.l = true;
                        m.k(f());
                    }
                } else if (k.a(this.f3117h).e()) {
                    r();
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (f3112e != null || p()) {
            this.f3118i.removeCallbacks(this.o);
            this.f3118i.post(this.o);
        }
    }

    private PendingIntent s() {
        return PendingIntent.getBroadcast(this.f3117h.getApplicationContext(), 0, f.a(this.f3117h), 134217728);
    }

    public void a(int i2) {
        if (m) {
            return;
        }
        com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat set : " + i2 + " millisecs", this.f3117h);
        if (i2 > 0) {
            this.f3114b = i2;
        }
        n();
    }

    public boolean a() {
        d();
        this.f3116f = Boolean.TRUE;
        com.baidu.android.pushservice.j.i.c(this.f3117h, "key_push_has_start", "push_service_has_start");
        if (m.b(this.f3117h.getApplicationContext())) {
            com.baidu.android.pushservice.g.a.a("PushSDK", "onCreate shouldStopSelf", this.f3117h);
            return false;
        }
        synchronized (f3113g) {
            if (PushSocket.f3476a) {
                if (p()) {
                    boolean p = m.p(this.f3117h);
                    this.j = p;
                    if (p) {
                        j();
                    }
                    h.b(this.f3117h);
                    Thread.setDefaultUncaughtExceptionHandler(new b(this.f3117h.getApplicationContext(), Thread.getDefaultUncaughtExceptionHandler()));
                    m();
                    i.a(this.f3117h);
                    if (f3112e != null) {
                        this.f3118i.postDelayed(this.n, 500L);
                        o();
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public boolean a(Intent intent) {
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.g.a.c("PushSDK", "--- handleOnStart by null intent!", this.f3117h);
        }
        if (!com.baidu.android.pushservice.b.d.q(this.f3117h) || com.baidu.android.pushservice.b.d.c(this.f3117h)) {
            if (!this.f3116f.booleanValue()) {
                a();
            }
            m = intent.getBooleanExtra("disable_alarm", false);
            synchronized (f3113g) {
                this.f3118i.removeCallbacks(this.n);
                if (f3112e == null) {
                    String action = intent.getAction();
                    if (!"com.baidu.android.pushservice.action.METHOD".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                        return true;
                    }
                    return c().a(intent);
                } else if (intent.getStringExtra(Constants.EXTRA_ALARM_ALERT) != null) {
                    return q();
                } else if (!"pushservice_quit".equals(intent.getStringExtra("method")) || f3112e == null) {
                    if ("com.baidu.android.pushservice.action.SEND_ACK".equals(intent.getStringExtra("method")) && f3112e != null) {
                        return b(intent);
                    } else if (c().a(intent)) {
                        com.baidu.android.pushservice.g.a.c("PushSDK", "-- handleOnStart -- intent handled  by mRegistrationService ", this.f3117h);
                        return true;
                    } else {
                        o();
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean b(Intent intent) {
        e eVar = this.f3115c;
        if (eVar == null || !eVar.a()) {
            return true;
        }
        int intExtra = intent.getIntExtra("bd.cross.request.RESULT_CODE", 0);
        String stringExtra = intent.getStringExtra("message_id");
        String stringExtra2 = intent.getStringExtra("bd.cross.request.RESULT_DATA");
        this.f3115c.a(intExtra, stringExtra, TextUtils.isEmpty(stringExtra2) ? null : stringExtra2.getBytes());
        return true;
    }

    public i c() {
        return i.a(this.f3117h);
    }

    public void d() {
        AlarmManager alarmManager = (AlarmManager) this.f3117h.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            try {
                alarmManager.cancel(s());
                m = true;
            } catch (Exception unused) {
            }
        }
    }

    public boolean e() {
        return m;
    }

    public Context f() {
        return this.f3117h;
    }

    public boolean g() {
        return this.f3116f.booleanValue() || "push_service_has_start".equals(com.baidu.android.pushservice.j.i.c(this.f3117h, "key_push_has_start"));
    }
}
