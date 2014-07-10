package com.baidu.android.moplus;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import com.baidu.android.a.j;
import com.baidu.android.common.util.Util;
import com.baidu.android.nebula.cmd.m;
import com.baidu.android.systemmonitor.StatisticManager;
/* loaded from: classes.dex */
public class MoPlusService extends Service {
    MoPlusReceiver a;
    private Handler b = new Handler();
    private boolean c = true;
    private Runnable d = new a(this);
    private Runnable e = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        this.b.removeCallbacks(this.d);
        this.b.removeCallbacks(this.e);
        if (intent != null && "service_sing_restart".equals(intent.getStringExtra("type")) && (intent.getBooleanExtra("restartflag", false) || !getPackageName().equals(com.baidu.android.moplus.util.b.d(getApplicationContext())))) {
            a(true);
            com.baidu.android.moplus.util.b.a(getApplicationContext(), 1000L);
            return;
        }
        if (!j.a(getApplicationContext()).e() || com.baidu.android.moplus.util.b.g(getApplicationContext(), getPackageName())) {
            com.baidu.android.nebula.d.c.b();
        } else {
            com.baidu.android.nebula.d.c.a(getApplicationContext(), intent);
        }
        if (!j.a(getApplicationContext()).f() || com.baidu.android.moplus.util.b.f(getApplicationContext(), getPackageName())) {
            com.baidu.android.nebula.b.c.a();
        } else {
            com.baidu.android.nebula.b.c.a(getApplicationContext(), intent);
        }
        if (!j.a(getApplicationContext()).a() || com.baidu.android.moplus.util.b.h(getApplicationContext())) {
            StatisticManager.destroy();
        } else {
            StatisticManager.handleOnStart(getApplicationContext(), intent);
        }
        if (j.a(getApplicationContext()).h() && com.baidu.android.moplus.util.b.j(getApplicationContext())) {
            com.baidu.android.defense.c.a(getApplicationContext(), intent);
        }
        this.b.postDelayed(new c(this), 30000L);
    }

    private void a(boolean z) {
        if (z) {
            this.e.run();
            return;
        }
        this.b.removeCallbacks(this.e);
        this.b.postDelayed(this.e, 1000L);
    }

    private boolean a() {
        return com.baidu.android.moplus.util.b.a((String) null, getApplicationContext());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.baidu.android.moplus.util.b.f(getApplicationContext());
        if (!j.a(getApplicationContext()).g() && com.baidu.android.moplus.util.b.a(getApplicationContext())) {
            a(true);
        } else if (!com.baidu.android.moplus.util.c.a(getApplicationContext()).a() && a()) {
            a(true);
            com.baidu.android.moplus.util.b.a(getApplicationContext(), 1000L);
        } else {
            this.a = new MoPlusReceiver();
            registerReceiver(this.a, new IntentFilter("com.baidu.android.moplus.action.RESTART"));
            com.baidu.android.moplus.util.c.a(getApplicationContext()).b(getApplicationContext());
            if (!com.baidu.android.moplus.util.c.a(getApplicationContext()).a()) {
                a(true);
                return;
            }
            if (j.a(getApplicationContext()).f() && !com.baidu.android.moplus.util.b.f(getApplicationContext(), getPackageName())) {
                com.baidu.android.nebula.b.c.c(getApplicationContext());
            }
            Intent intent = new Intent("com.baidu.moplus.action.start.SERVICEINFO");
            intent.putExtra("version", (short) 16);
            intent.putExtra("priority", com.baidu.android.moplus.util.b.e(getApplicationContext()));
            intent.putExtra("packagename", getPackageName());
            intent.putExtra("method_version", "V2");
            intent.putExtra(StatisticManager.class.getSimpleName() + "_version", StatisticManager.getVersion(getApplicationContext()));
            intent.putExtra(StatisticManager.class.getSimpleName() + "_priority", StatisticManager.getPriority(getApplicationContext()));
            sendStickyBroadcast(intent);
            this.b.postDelayed(this.d, 500L);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.baidu.android.nebula.d.c.b();
        com.baidu.android.nebula.b.c.a();
        StatisticManager.destroy();
        com.baidu.android.defense.c.a();
        if (this.a != null) {
            unregisterReceiver(this.a);
        }
        com.baidu.android.moplus.util.c.a(getApplicationContext()).b();
        m.d();
        if (Util.hasOtherServiceRuninMyPid(getApplicationContext(), getClass().getName())) {
            this.c = false;
        }
        if (this.c) {
            Process.killProcess(Process.myPid());
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        if (intent == null) {
            intent = new Intent();
        }
        super.onStart(intent, i);
        if (com.baidu.android.moplus.util.c.a(getApplicationContext()).a()) {
            a(intent);
        } else {
            a(true);
        }
    }
}
