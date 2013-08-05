package com.baidu.android.systemmonitor.d;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.nebula.util.BDLocationManager;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f667a = null;
    private static boolean h = false;
    private static boolean i = false;
    private static int n = -1;
    private Context b;
    private long d;
    private long e;
    private long f;
    private volatile long g;
    private Runnable k;
    private Runnable l;
    private Runnable m;
    private String c = null;
    private BroadcastReceiver j = null;
    private a.a.d o = null;
    private a.a.a p = null;
    private int q = 0;
    private int r = 0;
    private long s = 0;
    private Handler t = null;

    private c(Context context) {
        this.b = context;
        a();
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f667a == null) {
                f667a = new c(context);
            }
            cVar = f667a;
        }
        return cVar;
    }

    private void a(String str, int i2, long j) {
        if (str == null) {
            return;
        }
        String str2 = null;
        try {
            str2 = com.baidu.android.systemmonitor.security.a.a(str);
        } catch (Exception e) {
        }
        if (e.a(j)) {
            return;
        }
        m a2 = e.a(this.b.getApplicationContext()).a(str2);
        if (a2 != null) {
            a2.i += i2;
            a2.m += j;
            e.a(this.b.getApplicationContext()).a(a2);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        m mVar = new m(str2, true);
        mVar.i = i2;
        mVar.m = j;
        e.a(this.b.getApplicationContext()).a(this.b.getContentResolver(), mVar);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, long j2) {
        if (str == null || e.a(j2 - j)) {
            return;
        }
        String str2 = null;
        try {
            str2 = com.baidu.android.systemmonitor.security.a.a(str);
        } catch (Exception e) {
        }
        n nVar = new n(str2);
        if (nVar != null) {
            nVar.b = j;
            nVar.c = j2;
            String d = BDLocationManager.d(this.b.getApplicationContext());
            if (TextUtils.isEmpty(d)) {
                d = "";
            }
            nVar.d = d;
            nVar.g = this.r;
            nVar.e = this.q;
            nVar.f = com.baidu.android.systemmonitor.devicestatistic.f.a(this.b.getApplicationContext()).d();
            nVar.h = com.baidu.android.systemmonitor.devicestatistic.i.a(this.b.getApplicationContext()).a() - this.s;
            if (nVar.h < 0) {
                nVar.h = 0L;
            }
            e.a(this.b.getApplicationContext()).a(str2, nVar);
        }
    }

    public static synchronized void d() {
        synchronized (c.class) {
            if (f667a != null) {
                f667a.b();
                f667a = null;
            }
        }
    }

    private void h() {
        this.j = new a(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        this.b.registerReceiver(this.j, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.SCREEN_OFF");
        intentFilter2.addAction("android.intent.action.SCREEN_ON");
        intentFilter2.addAction("android.intent.action.USER_PRESENT");
        this.b.registerReceiver(this.j, intentFilter2);
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction("com.baidu.freqstatistic.summaryresults");
        this.b.registerReceiver(this.j, intentFilter3);
    }

    private boolean i() {
        Class b = e.b("android.app.ActivityManagerNative");
        try {
            Object invoke = b.getDeclaredMethod("getDefault", new Class[0]).invoke(b, new Object[0]);
            if (invoke == null) {
                return false;
            }
            try {
                Method declaredMethod = invoke.getClass().getDeclaredMethod("registerActivityWatcher", a.a.c.class);
                declaredMethod.setAccessible(true);
                try {
                    if (this.o != null) {
                        declaredMethod.invoke(invoke, this.o);
                    }
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } catch (Exception e2) {
                return false;
            }
        } catch (Exception e3) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (n == 0) {
            this.o = new f(this);
            if (i()) {
                return;
            }
            this.t.obtainMessage(1).sendToTarget();
        } else if (n == 1) {
            this.p = new l(this);
            if (k()) {
                return;
            }
            this.t.obtainMessage(1).sendToTarget();
        } else if (n == 2) {
            this.m = new k(this);
            this.t.postDelayed(this.m, 30000L);
        }
    }

    private boolean k() {
        Class b = e.b("android.app.ActivityManagerNative");
        try {
            Object invoke = b.getDeclaredMethod("getDefault", new Class[0]).invoke(b, new Object[0]);
            if (invoke == null) {
                return false;
            }
            try {
                Method declaredMethod = invoke.getClass().getDeclaredMethod("registerProcessObserver", a.a.b.class);
                declaredMethod.setAccessible(true);
                try {
                    if (this.p != null) {
                        declaredMethod.invoke(invoke, this.p);
                    }
                    return true;
                } catch (Exception e) {
                    return false;
                }
            } catch (Exception e2) {
                return false;
            }
        } catch (Exception e3) {
            return false;
        }
    }

    private void l() {
        Method method;
        Object obj = null;
        Class b = e.b("android.app.ActivityManagerNative");
        try {
            method = b.getDeclaredMethod("getDefault", new Class[0]);
            try {
                obj = method.invoke(b, new Object[0]);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            method = null;
        }
        if (obj == null) {
            return;
        }
        try {
            method = obj.getClass().getDeclaredMethod("unregisterProcessObserver", a.a.b.class);
            method.setAccessible(true);
        } catch (Exception e3) {
        }
        try {
            if (this.p != null) {
                method.invoke(obj, this.p);
            }
        } catch (Exception e4) {
        }
    }

    private void m() {
        Method method;
        Object obj = null;
        Class b = e.b("android.app.ActivityManagerNative");
        try {
            method = b.getDeclaredMethod("getDefault", new Class[0]);
            try {
                obj = method.invoke(b, new Object[0]);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            method = null;
        }
        if (obj == null) {
            return;
        }
        try {
            method = obj.getClass().getDeclaredMethod("unregisterActivityWatcher", a.a.c.class);
            method.setAccessible(true);
        } catch (Exception e3) {
        }
        try {
            if (this.o != null) {
                method.invoke(obj, this.o);
            }
        } catch (Exception e4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        String packageName;
        ActivityManager.RunningTaskInfo c = c();
        if (c == null) {
            return;
        }
        ComponentName componentName = c.baseActivity;
        ComponentName componentName2 = c.topActivity;
        if (componentName == null || componentName2 == null || (packageName = componentName.getPackageName()) == null || packageName.length() == 0 || packageName.equals(this.c)) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.c != null && this.c.length() > 0) {
            a(this.c, 0, elapsedRealtime - this.g);
            a(this.c, (this.g - elapsedRealtime) + currentTimeMillis, currentTimeMillis);
        }
        a(packageName, 1, 0L);
        this.c = packageName;
        this.g = elapsedRealtime;
        this.q = com.baidu.android.systemmonitor.devicestatistic.f.a(this.b.getApplicationContext()).d();
        this.r = com.baidu.android.systemmonitor.a.d.b(this.b.getApplicationContext());
        this.s = com.baidu.android.systemmonitor.devicestatistic.i.a(this.b.getApplicationContext()).a();
        if (e.a(this.b.getApplicationContext()).b(this.f)) {
            if (com.baidu.android.systemmonitor.a.d.a(this.b.getApplicationContext())) {
                com.baidu.android.systemmonitor.b.a.a(this.b.getApplicationContext()).e();
                this.f = System.currentTimeMillis();
                com.baidu.android.systemmonitor.a.b.a(this.b.getApplicationContext(), this.f);
            }
            this.b.sendBroadcast(new Intent("com.baidu.freqstatistic.summaryresults"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        new Thread(new j(this), "SystemMonitor_SummaryFreqStatisticThread").start();
    }

    public void a() {
        this.t = new i(this);
        n = e.c(this.b.getApplicationContext());
        this.d = System.currentTimeMillis();
        this.e = SystemClock.elapsedRealtime();
        if (!com.baidu.android.systemmonitor.a.b.f(this.b.getApplicationContext()).booleanValue()) {
            com.baidu.android.systemmonitor.a.b.e(this.b.getApplicationContext());
            com.baidu.android.systemmonitor.a.b.g(this.b.getApplicationContext());
        }
        this.f = com.baidu.android.systemmonitor.a.b.h(this.b.getApplicationContext());
        h();
        this.k = new h(this);
        this.l = new g(this);
        j();
    }

    public void b() {
        if (this.j != null) {
            try {
                this.b.unregisterReceiver(this.j);
            } catch (Exception e) {
            }
        }
        if (n == 0) {
            if (this.o != null) {
                m();
            }
        } else if (n == 1) {
            if (this.p != null) {
                l();
            }
        } else if (n == 2 && this.m != null && this.t != null) {
            this.t.removeCallbacks(this.m);
        }
        this.t = null;
        e.a();
    }

    public ActivityManager.RunningTaskInfo c() {
        List<ActivityManager.RecentTaskInfo> list;
        List<ActivityManager.RecentTaskInfo> list2;
        List<ActivityManager.RunningTaskInfo> list3;
        ActivityManager activityManager = (ActivityManager) this.b.getSystemService("activity");
        try {
            list2 = activityManager.getRecentTasks(1, 1);
        } catch (Exception e) {
            list = null;
        }
        try {
            list3 = activityManager.getRunningTasks(3);
        } catch (Exception e2) {
            list = list2;
            list2 = list;
            list3 = null;
            return list2 == null ? null : null;
        }
        if (list2 == null && list3 != null) {
            Iterator<ActivityManager.RecentTaskInfo> it = list2.iterator();
            Iterator<ActivityManager.RunningTaskInfo> it2 = list3.iterator();
            ActivityManager.RecentTaskInfo next = it.hasNext() ? it.next() : null;
            if (next != null) {
                ActivityManager.RunningTaskInfo next2 = it2.hasNext() ? it2.next() : null;
                if (next2 != null) {
                    if (next.id == -1 || next2.id != next.id) {
                        String packageName = next.baseIntent.getComponent().getPackageName();
                        if (next2.baseActivity.getPackageName().equals(packageName)) {
                            while (true) {
                                if (!it2.hasNext()) {
                                    next2 = null;
                                    break;
                                }
                                next2 = it2.next();
                                if (!next2.baseActivity.getPackageName().equals(packageName)) {
                                    break;
                                }
                            }
                        }
                    }
                    return next2;
                }
                return null;
            }
            return null;
        }
    }
}
