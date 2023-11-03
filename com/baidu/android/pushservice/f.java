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
import androidx.core.content.pm.ShortcutManagerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.jni.PushSocket;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.searchbox.dns.stratege.DnsStrategy;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import java.io.IOException;
@SuppressLint({"WorldReadableFiles", "InlinedApi"})
/* loaded from: classes.dex */
public class f {
    public static volatile f k;
    public static LocalServerSocket m;
    public static boolean o;
    public d c;
    public Context e;
    public Handler f;
    public boolean g;
    public PushSystemNotifyReceiver h;
    public boolean i;
    public static final Object l = new Object();
    public static final Object n = new Object();
    public boolean b = false;
    public Boolean d = Boolean.FALSE;
    public Runnable j = new b();
    public int a = DnsStrategy.Factory.PRE_FETCH_INTERVAL;

    /* loaded from: classes.dex */
    public class a extends com.baidu.android.pushservice.z.c {
        public final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, short s, int i) {
            super(str, s);
            this.c = i;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            if (f.k != null && com.baidu.android.pushservice.a0.g.d(f.this.e)) {
                if (f.this.c != null && !f.this.c.f()) {
                    if (j.a(f.this.e).e()) {
                        f.this.c(this.c);
                    }
                } else if (f.this.c == null || !f.this.c.f()) {
                } else {
                    com.baidu.android.pushservice.u.a.a("PushSDK", "tryConnect heartbeat", f.this.e);
                    f.this.a(this.c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.a(new Intent());
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (f.l) {
                if (f.this.c != null) {
                    f.this.c.a(this.a);
                }
            }
        }
    }

    public f(Context context) {
        this.f = new Handler(context.getMainLooper());
        this.e = context.getApplicationContext();
    }

    public static f a(Context context) {
        if (k == null) {
            synchronized (f.class) {
                if (k == null) {
                    k = new f(context);
                }
            }
        }
        return k;
    }

    public static void d() {
        if (k != null) {
            k.e();
        }
        com.baidu.android.pushservice.z.e.a().b();
    }

    public void a(boolean z, int i) {
        if (com.baidu.android.pushservice.a0.i.a(this.e.getApplicationContext(), "key_push_launch_task_level", 0) == 1) {
            c();
            return;
        }
        this.b = z;
        AlarmManager alarmManager = (AlarmManager) this.e.getSystemService(NotificationCompat.CATEGORY_ALARM);
        try {
            long j = i * 1000;
            long currentTimeMillis = System.currentTimeMillis() + j;
            if (alarmManager != null) {
                alarmManager.cancel(f());
                if (z) {
                    alarmManager.setRepeating(0, currentTimeMillis, j, f());
                }
                o = false;
            }
        } catch (Exception unused) {
        }
    }

    public final boolean a(int i) {
        boolean d = com.baidu.android.pushservice.a0.g.d(this.e);
        com.baidu.android.pushservice.u.a.a("PushSDK", "heartbeat networkConnected :" + d, this.e);
        if (Utility.C(this.e)) {
            c();
            return false;
        } else if (!d) {
            d dVar = this.c;
            if (dVar != null) {
                dVar.a(true);
            }
            return true;
        } else {
            d dVar2 = this.c;
            if (dVar2 != null) {
                if (dVar2.f()) {
                    this.c.g(i);
                    if (!this.i) {
                        this.i = true;
                        Utility.Y(g());
                    }
                } else if (j.a(this.e).e()) {
                    c(i);
                }
            }
            return true;
        }
    }

    public boolean a(Intent intent) {
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.u.a.c("PushSDK", "--- handleOnStart by null intent!", this.e);
        }
        if (!com.baidu.android.pushservice.l.d.r(this.e) || com.baidu.android.pushservice.l.d.q(this.e)) {
            int intExtra = intent.getIntExtra("push_start_source", 0);
            if (!this.d.booleanValue()) {
                b(intExtra);
            }
            o = intent.getBooleanExtra("disable_alarm", false);
            synchronized (n) {
                this.f.removeCallbacks(this.j);
                if (m == null) {
                    String action = intent.getAction();
                    if (!"com.baidu.android.pushservice.action.METHOD".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.CLICK".equals(action) && !"com.baidu.android.pushservice.action.privatenotification.DELETE".equals(action)) {
                        return true;
                    }
                    return h().c(intent);
                } else if (intent.getStringExtra(Constants.EXTRA_ALARM_ALERT) != null) {
                    return a(intExtra);
                } else if (!"pushservice_quit".equals(intent.getStringExtra("method")) || m == null) {
                    if ("com.baidu.android.pushservice.action.SEND_ACK".equals(intent.getStringExtra("method")) && m != null) {
                        return b(intent);
                    } else if (h().c(intent)) {
                        com.baidu.android.pushservice.u.a.c("PushSDK", "-- handleOnStart -- intent handled  by mRegistrationService ", this.e);
                        return true;
                    } else {
                        e(intExtra);
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean b(int i) {
        c();
        this.d = Boolean.TRUE;
        com.baidu.android.pushservice.a0.i.a(this.e, "key_push_has_start", "push_service_has_start");
        if (Utility.C(this.e.getApplicationContext())) {
            com.baidu.android.pushservice.u.a.a("PushSDK", "onCreate shouldStopSelf", this.e);
            return false;
        }
        synchronized (n) {
            if (PushSocket.b) {
                if (m()) {
                    boolean E = Utility.E(this.e);
                    this.g = E;
                    if (E) {
                        l();
                    }
                    g.d(this.e);
                    Thread.setDefaultUncaughtExceptionHandler(new com.baidu.android.pushservice.b(this.e.getApplicationContext(), Thread.getDefaultUncaughtExceptionHandler()));
                    k();
                    h.a(this.e);
                    if (m != null) {
                        this.f.postDelayed(this.j, 500L);
                        e(i);
                    }
                    com.baidu.android.pushservice.v.c.a().c(this.e);
                    com.baidu.android.pushservice.v.c.a().g(this.e);
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public boolean b(Intent intent) {
        d dVar = this.c;
        if (dVar == null || !dVar.f()) {
            return true;
        }
        int intExtra = intent.getIntExtra("bd.cross.request.RESULT_CODE", 0);
        String stringExtra = intent.getStringExtra(ForbidActivityConfig.CHAT_MSG_ID);
        String stringExtra2 = intent.getStringExtra("bd.cross.request.RESULT_DATA");
        this.c.a(intExtra, stringExtra, TextUtils.isEmpty(stringExtra2) ? null : stringExtra2.getBytes());
        return true;
    }

    public void c() {
        AlarmManager alarmManager = (AlarmManager) this.e.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            try {
                alarmManager.cancel(f());
                o = true;
            } catch (Exception unused) {
            }
        }
    }

    public final void c(int i) {
        if (m != null || m()) {
            c cVar = new c(i);
            this.f.removeCallbacks(cVar);
            this.f.post(cVar);
        }
    }

    public void d(int i) {
        if (o) {
            return;
        }
        com.baidu.android.pushservice.u.a.a("PushSDK", "heartbeat set : " + i + " millisecs", this.e);
        if (i > 0) {
            this.a = i;
        }
        n();
    }

    public final void e() {
        com.baidu.android.pushservice.u.a.a("PushSDK", "destroy", this.e);
        synchronized (n) {
            try {
                if (m != null) {
                    m.close();
                    m = null;
                }
            } catch (IOException unused) {
            }
            if (this.c != null) {
                synchronized (l) {
                    if (this.c != null) {
                        this.c.i();
                        this.c = null;
                    }
                }
            }
            try {
                com.baidu.android.pushservice.m.b.a();
            } catch (Exception unused2) {
            }
            if (this.g) {
                o();
            }
            k = null;
        }
    }

    public final void e(int i) {
        com.baidu.android.pushservice.z.e.a().a(new a("tryConnect", (short) 98, i));
    }

    public final PendingIntent f() {
        return PendingIntent.getBroadcast(this.e.getApplicationContext(), 0, e.j(this.e), Utility.a((int) SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION));
    }

    public Context g() {
        return this.e;
    }

    public h h() {
        return h.a(this.e);
    }

    public boolean i() {
        return this.d.booleanValue() || "push_service_has_start".equals(com.baidu.android.pushservice.a0.i.a(this.e, "key_push_has_start"));
    }

    public boolean j() {
        return o;
    }

    public final void k() {
        synchronized (l) {
            this.c = d.a(this.e);
        }
    }

    public final void l() {
        if (this.h == null) {
            this.h = new PushSystemNotifyReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter.addAction(PackageChangedReceiver.ACTION_UNINSTALL);
            intentFilter.addAction("android.intent.action.INSTALL_PACKAGE");
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_CHECKING");
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addAction("com.oppo.intent.action.KEY_LOCK_MODE");
            intentFilter.addAction("com.oplus.intent.action.KEY_LOCK_MODE");
            intentFilter.addAction("com.xiaomi.push.service_started");
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("miui.intent.action.LOCATION_CHANGED");
            intentFilter.addAction("android.app.action.NEXT_ALARM_CLOCK_CHANGED");
            intentFilter.addAction("android.intent.category.DEFAULT");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.BATTERY_LOW");
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction("android.intent.action.BATTERY_OKAY");
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            intentFilter.addAction(ShortcutManagerCompat.ACTION_INSTALL_SHORTCUT);
            intentFilter.addAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
            intentFilter.addAction("android.appwidget.action.APPWIDGET_UPDATE");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
            intentFilter.addAction("com.insdio.aqicn.airwidget.intent.action.CLICK");
            intentFilter.addAction("android.intent.action.ANALOG_AUDIO_DOCK_PLUG");
            intentFilter.addAction("android.appwidget.action.APPWIDGET_PICK");
            intentFilter.addAction("com.android.systemui.fsgesture");
            intentFilter.addAction("vivo.intent.action.STATUS_BAR_STATE_CHANGED");
            intentFilter.addAction("com.huawei.systemmanager.action.REQUEST_TRIM_ALL");
            intentFilter.addAction("com.huawei.systemmanager.action.REQUEST_ONEKEYCLEAN");
            this.e.getApplicationContext().registerReceiver(this.h, intentFilter);
        }
        com.baidu.android.pushservice.v.c.a().e(this.e);
    }

    public final boolean m() {
        if (m == null) {
            try {
                m = new LocalServerSocket(Utility.w(this.e));
                return true;
            } catch (Exception unused) {
                com.baidu.android.pushservice.u.a.a("PushSDK", "--- Socket Adress (" + Utility.w(this.e) + ") in use --- @ " + this.e.getPackageName(), this.e);
                return false;
            }
        }
        return true;
    }

    public final void n() {
        int i;
        if (com.baidu.android.pushservice.a0.i.a(this.e.getApplicationContext(), "key_push_launch_task_level", 0) == 1) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() + this.a;
        int i2 = ((int) (currentTimeMillis / 1000)) % 60;
        if (((int) ((currentTimeMillis / 60000) % 5)) == 0 && i2 < 15) {
            currentTimeMillis += ((long) (Math.random() * (this.a - 20000))) + 15000;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (!this.b || com.baidu.android.pushservice.y.c.b(this.e) <= 0) {
                currentTimeMillis = System.currentTimeMillis() + 60000;
                i = 60000;
            } else {
                currentTimeMillis = System.currentTimeMillis() + (com.baidu.android.pushservice.y.c.b(this.e) * 1000);
                i = com.baidu.android.pushservice.y.c.b(this.e) * 1000;
            }
            this.a = i;
        }
        long j = currentTimeMillis;
        AlarmManager alarmManager = (AlarmManager) this.e.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            try {
                alarmManager.setRepeating(0, j, this.a, f());
                o = false;
            } catch (Exception unused) {
            }
        }
    }

    public final void o() {
        if (this.h != null) {
            try {
                this.e.getApplicationContext().unregisterReceiver(this.h);
                this.h = null;
            } catch (IllegalArgumentException unused) {
            }
        }
        com.baidu.android.pushservice.v.c.a().f(this.e);
    }
}
