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
import com.kwai.video.player.NativeErrorCode;
import java.io.IOException;
@SuppressLint({"WorldReadableFiles", "InlinedApi"})
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f3053a;

    /* renamed from: e  reason: collision with root package name */
    public static LocalServerSocket f3055e;
    public static boolean m;

    /* renamed from: c  reason: collision with root package name */
    public e f3058c;

    /* renamed from: h  reason: collision with root package name */
    public Context f3060h;
    public Handler i;
    public boolean j;
    public PushServiceReceiver k;
    public boolean l;

    /* renamed from: d  reason: collision with root package name */
    public static final Object f3054d = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static final Object f3056g = new Object();

    /* renamed from: f  reason: collision with root package name */
    public Boolean f3059f = Boolean.FALSE;
    public Runnable n = new Runnable() { // from class: com.baidu.android.pushservice.g.2
        @Override // java.lang.Runnable
        public void run() {
            g.this.a(new Intent());
        }
    };
    public Runnable o = new Runnable() { // from class: com.baidu.android.pushservice.g.3
        @Override // java.lang.Runnable
        public void run() {
            synchronized (g.f3054d) {
                if (g.this.f3058c != null) {
                    g.this.f3058c.b();
                }
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public int f3057b = TiebaStatic.MAX_COST_VALUE;

    public g(Context context) {
        this.i = new Handler(context.getMainLooper());
        this.f3060h = context.getApplicationContext();
    }

    public static g a(Context context) {
        if (f3053a == null) {
            synchronized (g.class) {
                if (f3053a == null) {
                    f3053a = new g(context);
                }
            }
        }
        return f3053a;
    }

    public static void b() {
        if (f3053a != null) {
            f3053a.l();
        }
        com.baidu.android.pushservice.h.d.a().b();
    }

    private void j() {
        if (this.k == null) {
            this.k = new PushServiceReceiver();
            this.f3060h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED"));
            this.f3060h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
            this.f3060h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.intent.action.USER_PRESENT"));
            this.f3060h.getApplicationContext().registerReceiver(this.k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private void k() {
        if (this.k != null) {
            this.f3060h.getApplicationContext().unregisterReceiver(this.k);
        }
    }

    private void l() {
        com.baidu.android.pushservice.g.a.a("PushSDK", "destroy", this.f3060h);
        synchronized (f3056g) {
            try {
                if (f3055e != null) {
                    f3055e.close();
                    f3055e = null;
                }
            } catch (IOException unused) {
            }
            if (this.f3058c != null) {
                synchronized (f3054d) {
                    if (this.f3058c != null) {
                        this.f3058c.c();
                        this.f3058c = null;
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
            f3053a = null;
        }
    }

    private void m() {
        synchronized (f3054d) {
            this.f3058c = e.a(this.f3060h);
        }
    }

    private void n() {
        long currentTimeMillis = System.currentTimeMillis() + this.f3057b;
        int i = ((int) (currentTimeMillis / 1000)) % 60;
        if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i < 15) {
            double random = Math.random();
            double d2 = this.f3057b + NativeErrorCode.EKS_UNKNOWN_ERROR_BASE;
            Double.isNaN(d2);
            currentTimeMillis += ((long) (random * d2)) + 15000;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            currentTimeMillis = System.currentTimeMillis() + 60000;
            this.f3057b = 60000;
        }
        long j = currentTimeMillis;
        AlarmManager alarmManager = (AlarmManager) this.f3060h.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            try {
                alarmManager.setRepeating(0, j, this.f3057b, s());
                m = false;
            } catch (Exception unused) {
            }
        }
    }

    private void o() {
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("tryConnect", (short) 98) { // from class: com.baidu.android.pushservice.g.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                if (g.f3053a == null) {
                    return;
                }
                boolean a2 = com.baidu.android.pushservice.j.g.a(g.this.f3060h);
                com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect networkConnected :" + a2, g.this.f3060h);
                if (a2) {
                    if (g.this.f3058c != null && !g.this.f3058c.a()) {
                        if (k.a(g.this.f3060h).e()) {
                            g.this.r();
                        }
                    } else if (g.this.f3058c == null || !g.this.f3058c.a()) {
                    } else {
                        com.baidu.android.pushservice.g.a.a("PushSDK", "tryConnect heartbeat", g.this.f3060h);
                        g.this.q();
                    }
                }
            }
        });
    }

    private boolean p() {
        if (f3055e == null) {
            try {
                f3055e = new LocalServerSocket(m.h(this.f3060h));
                return true;
            } catch (Exception unused) {
                com.baidu.android.pushservice.g.a.a("PushSDK", "--- Socket Adress (" + m.h(this.f3060h) + ") in use --- @ " + this.f3060h.getPackageName(), this.f3060h);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        boolean a2 = com.baidu.android.pushservice.j.g.a(this.f3060h);
        com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat networkConnected :" + a2, this.f3060h);
        if (m.b(this.f3060h)) {
            d();
            return false;
        } else if (!a2) {
            e eVar = this.f3058c;
            if (eVar != null) {
                eVar.a(true);
            }
            return true;
        } else {
            e eVar2 = this.f3058c;
            if (eVar2 != null) {
                if (eVar2.a()) {
                    this.f3058c.d();
                    if (!this.l) {
                        this.l = true;
                        m.k(f());
                    }
                } else if (k.a(this.f3060h).e()) {
                    r();
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (f3055e != null || p()) {
            this.i.removeCallbacks(this.o);
            this.i.post(this.o);
        }
    }

    private PendingIntent s() {
        return PendingIntent.getBroadcast(this.f3060h.getApplicationContext(), 0, f.a(this.f3060h), 134217728);
    }

    public void a(int i) {
        if (m) {
            return;
        }
        com.baidu.android.pushservice.g.a.a("PushSDK", "heartbeat set : " + i + " millisecs", this.f3060h);
        if (i > 0) {
            this.f3057b = i;
        }
        n();
    }

    public boolean a() {
        d();
        this.f3059f = Boolean.TRUE;
        com.baidu.android.pushservice.j.i.c(this.f3060h, "key_push_has_start", "push_service_has_start");
        if (m.b(this.f3060h.getApplicationContext())) {
            com.baidu.android.pushservice.g.a.a("PushSDK", "onCreate shouldStopSelf", this.f3060h);
            return false;
        }
        synchronized (f3056g) {
            if (PushSocket.f3401a) {
                if (p()) {
                    boolean p = m.p(this.f3060h);
                    this.j = p;
                    if (p) {
                        j();
                    }
                    h.b(this.f3060h);
                    Thread.setDefaultUncaughtExceptionHandler(new b(this.f3060h.getApplicationContext(), Thread.getDefaultUncaughtExceptionHandler()));
                    m();
                    i.a(this.f3060h);
                    if (f3055e != null) {
                        this.i.postDelayed(this.n, 500L);
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
            com.baidu.android.pushservice.g.a.c("PushSDK", "--- handleOnStart by null intent!", this.f3060h);
        }
        if (!com.baidu.android.pushservice.b.d.q(this.f3060h) || com.baidu.android.pushservice.b.d.c(this.f3060h)) {
            if (!this.f3059f.booleanValue()) {
                a();
            }
            m = intent.getBooleanExtra("disable_alarm", false);
            synchronized (f3056g) {
                this.i.removeCallbacks(this.n);
                if (f3055e == null) {
                    String action = intent.getAction();
                    if (!"com.baidu.android.pushservice.action.METHOD".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                        return true;
                    }
                    return c().a(intent);
                } else if (intent.getStringExtra(Constants.EXTRA_ALARM_ALERT) != null) {
                    return q();
                } else if (!"pushservice_quit".equals(intent.getStringExtra("method")) || f3055e == null) {
                    if ("com.baidu.android.pushservice.action.SEND_ACK".equals(intent.getStringExtra("method")) && f3055e != null) {
                        return b(intent);
                    } else if (c().a(intent)) {
                        com.baidu.android.pushservice.g.a.c("PushSDK", "-- handleOnStart -- intent handled  by mRegistrationService ", this.f3060h);
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
        e eVar = this.f3058c;
        if (eVar == null || !eVar.a()) {
            return true;
        }
        int intExtra = intent.getIntExtra("bd.cross.request.RESULT_CODE", 0);
        String stringExtra = intent.getStringExtra("message_id");
        String stringExtra2 = intent.getStringExtra("bd.cross.request.RESULT_DATA");
        this.f3058c.a(intExtra, stringExtra, TextUtils.isEmpty(stringExtra2) ? null : stringExtra2.getBytes());
        return true;
    }

    public i c() {
        return i.a(this.f3060h);
    }

    public void d() {
        AlarmManager alarmManager = (AlarmManager) this.f3060h.getSystemService(NotificationCompat.CATEGORY_ALARM);
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
        return this.f3060h;
    }

    public boolean g() {
        return this.f3059f.booleanValue() || "push_service_has_start".equals(com.baidu.android.pushservice.j.i.c(this.f3060h, "key_push_has_start"));
    }
}
