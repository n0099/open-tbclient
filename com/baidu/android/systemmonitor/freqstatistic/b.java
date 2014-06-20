package com.baidu.android.systemmonitor.freqstatistic;

import android.app.ActivityManager;
import android.app.IActivityWatcher;
import android.app.IProcessObserver;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class b {
    private static b a = null;
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
    private IActivityWatcher.Stub o = null;
    private IProcessObserver.Stub p = null;
    private int q = 0;
    private int r = 0;
    private long s = 0;
    private Handler t = null;

    private b(Context context) {
        this.b = context;
        a();
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b(context);
            }
            bVar = a;
        }
        return bVar;
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
        if (c.a(j)) {
            return;
        }
        k a2 = c.a(this.b.getApplicationContext()).a(str2);
        if (a2 != null) {
            a2.i += i2;
            a2.m += j;
            c.a(this.b.getApplicationContext()).a(a2);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        k kVar = new k(str2, true);
        kVar.i = i2;
        kVar.m = j;
        c.a(this.b.getApplicationContext()).a(this.b.getContentResolver(), kVar);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j, long j2) {
        if (str == null || c.a(j2 - j)) {
            return;
        }
        String str2 = null;
        try {
            str2 = com.baidu.android.systemmonitor.security.a.a(str);
        } catch (Exception e) {
        }
        l lVar = new l(str2);
        if (lVar != null) {
            lVar.b = j;
            lVar.c = j2;
            String d = com.baidu.android.nebula.a.e.a(this.b).d();
            if (TextUtils.isEmpty(d)) {
                d = "";
            }
            lVar.d = d;
            lVar.g = this.r;
            lVar.e = this.q;
            lVar.f = com.baidu.android.systemmonitor.devicestatistic.h.a(this.b.getApplicationContext()).d();
            lVar.h = com.baidu.android.systemmonitor.devicestatistic.j.a(this.b.getApplicationContext()).a() - this.s;
            if (lVar.h < 0) {
                lVar.h = 0L;
            }
            c.a(this.b.getApplicationContext()).a(str2, lVar);
        }
    }

    public static ActivityManager.RunningTaskInfo b(Context context) {
        List<ActivityManager.RecentTaskInfo> list;
        List<ActivityManager.RecentTaskInfo> list2;
        List<ActivityManager.RunningTaskInfo> list3;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        try {
            list2 = activityManager.getRecentTasks(1, 1);
            try {
                list3 = activityManager.getRunningTasks(3);
            } catch (Exception e) {
                list = list2;
                list2 = list;
                list3 = null;
                return list2 == null ? null : null;
            }
        } catch (Exception e2) {
            list = null;
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

    public static synchronized void c() {
        synchronized (b.class) {
            if (a != null) {
                a.b();
                a = null;
            }
        }
    }

    private void g() {
        this.j = new d(this);
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

    private boolean h() {
        Class b = c.b("android.app.ActivityManagerNative");
        try {
            Object invoke = b.getDeclaredMethod("getDefault", new Class[0]).invoke(b, new Object[0]);
            if (invoke == null) {
                return false;
            }
            try {
                Method declaredMethod = invoke.getClass().getDeclaredMethod("registerActivityWatcher", IActivityWatcher.class);
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
    public void i() {
        if (n == 0) {
            try {
                this.o = new IActivityWatcher.Stub() { // from class: com.baidu.android.systemmonitor.freqstatistic.FreqStatisticManager$5
                    @Override // android.app.IActivityWatcher
                    public void activityResuming(int i2) {
                        boolean z;
                        Handler handler;
                        Runnable runnable;
                        Handler handler2;
                        Runnable runnable2;
                        z = b.h;
                        if (!z) {
                            boolean unused = b.h = true;
                            b.this.g = SystemClock.elapsedRealtime();
                        }
                        handler = b.this.t;
                        runnable = b.this.k;
                        handler.removeCallbacks(runnable);
                        handler2 = b.this.t;
                        runnable2 = b.this.k;
                        handler2.postDelayed(runnable2, 500L);
                    }

                    @Override // android.app.IActivityWatcher
                    public void closingSystemDialogs(String str) {
                    }
                };
                if (h()) {
                    return;
                }
                this.t.obtainMessage(1).sendToTarget();
            } catch (Error e) {
                n = 1;
                this.o = null;
                i();
            } catch (Exception e2) {
                n = 1;
                this.o = null;
                i();
            }
        } else if (n != 1) {
            if (n == 2) {
                this.m = new j(this);
                this.t.postDelayed(this.m, 10000L);
            }
        } else {
            try {
                this.p = new IProcessObserver.Stub() { // from class: com.baidu.android.systemmonitor.freqstatistic.FreqStatisticManager$6
                    @Override // android.app.IProcessObserver
                    public void onForegroundActivitiesChanged(int i2, int i3, boolean z) {
                        boolean z2;
                        Handler handler;
                        Runnable runnable;
                        Handler handler2;
                        Runnable runnable2;
                        z2 = b.h;
                        if (!z2) {
                            boolean unused = b.h = true;
                            b.this.g = SystemClock.elapsedRealtime();
                        }
                        handler = b.this.t;
                        runnable = b.this.k;
                        handler.removeCallbacks(runnable);
                        handler2 = b.this.t;
                        runnable2 = b.this.k;
                        handler2.postDelayed(runnable2, 500L);
                    }

                    @Override // android.app.IProcessObserver
                    public void onImportanceChanged(int i2, int i3, int i4) {
                    }

                    @Override // android.app.IProcessObserver
                    public void onProcessDied(int i2, int i3) {
                    }
                };
                if (j()) {
                    return;
                }
                this.t.obtainMessage(1).sendToTarget();
            } catch (Error e3) {
                n = 2;
                this.p = null;
                i();
            } catch (Exception e4) {
                n = 2;
                this.p = null;
                i();
            }
        }
    }

    private boolean j() {
        Class b = c.b("android.app.ActivityManagerNative");
        try {
            Object invoke = b.getDeclaredMethod("getDefault", new Class[0]).invoke(b, new Object[0]);
            if (invoke == null) {
                return false;
            }
            try {
                Method declaredMethod = invoke.getClass().getDeclaredMethod("registerProcessObserver", IProcessObserver.class);
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

    private void k() {
        Method method;
        Object obj = null;
        Class b = c.b("android.app.ActivityManagerNative");
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
            method = obj.getClass().getDeclaredMethod("unregisterProcessObserver", IProcessObserver.class);
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

    private void l() {
        Method method;
        Object obj = null;
        Class b = c.b("android.app.ActivityManagerNative");
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
            method = obj.getClass().getDeclaredMethod("unregisterActivityWatcher", IActivityWatcher.class);
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
    public void m() {
        String packageName;
        ActivityManager.RunningTaskInfo b = b(this.b);
        if (b == null) {
            return;
        }
        ComponentName componentName = b.baseActivity;
        ComponentName componentName2 = b.topActivity;
        if (componentName == null || componentName2 == null || (packageName = componentName2.getPackageName()) == null || packageName.length() == 0 || packageName.equals(this.c)) {
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
        this.q = com.baidu.android.systemmonitor.devicestatistic.h.a(this.b.getApplicationContext()).d();
        this.r = com.baidu.android.systemmonitor.util.b.b(this.b.getApplicationContext());
        this.s = com.baidu.android.systemmonitor.devicestatistic.j.a(this.b.getApplicationContext()).a();
        if (c.a(this.b.getApplicationContext()).b(this.f)) {
            if (com.baidu.android.systemmonitor.util.b.a(this.b.getApplicationContext())) {
                com.baidu.android.systemmonitor.a.a.a(this.b.getApplicationContext()).e();
                this.f = System.currentTimeMillis();
                com.baidu.android.systemmonitor.util.e.a(this.b.getApplicationContext(), this.f);
            }
            this.b.sendBroadcast(new Intent("com.baidu.freqstatistic.summaryresults"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        new Thread(new i(this), "SystemMonitor_SummaryFreqStatisticThread").start();
    }

    public void a() {
        this.t = new h(this);
        n = c.c(this.b.getApplicationContext());
        this.d = System.currentTimeMillis();
        this.e = SystemClock.elapsedRealtime();
        if (!com.baidu.android.systemmonitor.util.e.f(this.b.getApplicationContext()).booleanValue()) {
            com.baidu.android.systemmonitor.util.e.e(this.b.getApplicationContext());
            com.baidu.android.systemmonitor.util.e.g(this.b.getApplicationContext());
        }
        this.f = com.baidu.android.systemmonitor.util.e.h(this.b.getApplicationContext());
        g();
        this.k = new g(this);
        this.l = new f(this);
        i();
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
                l();
            }
        } else if (n == 1) {
            if (this.p != null) {
                k();
            }
        } else if (n == 2 && this.m != null && this.t != null) {
            this.t.removeCallbacks(this.m);
        }
        this.t = null;
        c.a();
    }
}
