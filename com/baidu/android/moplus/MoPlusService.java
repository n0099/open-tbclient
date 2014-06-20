package com.baidu.android.moplus;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import com.baidu.android.a.s;
import com.baidu.android.nebula.c.i;
import com.baidu.android.nebula.cmd.k;
import com.baidu.android.systemmonitor.StatisticManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class MoPlusService extends Service {
    MoPlusReceiver a;
    private Handler b = new Handler();
    private boolean c = true;
    private Runnable d = new d(this);
    private Runnable e = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        this.b.removeCallbacks(this.d);
        this.b.removeCallbacks(this.e);
        if (intent != null && "service_sing_restart".equals(intent.getStringExtra("type")) && (intent.getBooleanExtra("restartflag", false) || !getPackageName().equals(com.baidu.android.moplus.util.a.d(getApplicationContext())))) {
            a(true);
            com.baidu.android.moplus.util.a.a(getApplicationContext(), 1000L);
            return;
        }
        if (!s.a(getApplicationContext()).e() || com.baidu.android.moplus.util.a.g(getApplicationContext(), getPackageName())) {
            com.baidu.android.nebula.d.b.b();
        } else {
            com.baidu.android.nebula.d.b.a(getApplicationContext(), intent);
        }
        if (!s.a(getApplicationContext()).f() || com.baidu.android.moplus.util.a.f(getApplicationContext(), getPackageName())) {
            i.a();
        } else {
            i.a(getApplicationContext(), intent);
        }
        if (!s.a(getApplicationContext()).a() || com.baidu.android.moplus.util.a.h(getApplicationContext())) {
            StatisticManager.destroy();
        } else {
            StatisticManager.handleOnStart(getApplicationContext(), intent);
        }
        com.baidu.android.defense.c.a(getApplicationContext(), intent);
        com.baidu.android.nebula.d.a.a(getApplicationContext()).b(getApplicationContext());
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
        return com.baidu.android.moplus.util.a.a((String) null, getApplicationContext());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        g.a();
        com.baidu.android.moplus.util.a.f(getApplicationContext());
        if (!s.a(getApplicationContext()).g() && com.baidu.android.moplus.util.a.a(getApplicationContext())) {
            a(true);
        } else if (!com.baidu.android.moplus.util.d.a(getApplicationContext()).a() && a()) {
            a(true);
            com.baidu.android.moplus.util.a.a(getApplicationContext(), 1000L);
        } else {
            this.a = new MoPlusReceiver();
            registerReceiver(this.a, new IntentFilter("com.baidu.android.moplus.action.RESTART"));
            com.baidu.android.moplus.util.d.a(getApplicationContext()).b(getApplicationContext());
            if (!com.baidu.android.moplus.util.d.a(getApplicationContext()).a()) {
                a(true);
                return;
            }
            if (s.a(getApplicationContext()).f() && !com.baidu.android.moplus.util.a.f(getApplicationContext(), getPackageName())) {
                i.c(getApplicationContext());
            }
            Intent intent = new Intent("com.baidu.moplus.action.start.SERVICEINFO");
            intent.putExtra("version", 20);
            intent.putExtra("priority", com.baidu.android.moplus.util.a.e(getApplicationContext()));
            intent.putExtra("packagename", getPackageName());
            intent.putExtra("method_version", "V2");
            intent.putExtra(StatisticManager.class.getSimpleName() + "_version", StatisticManager.getVersion(getApplicationContext()));
            intent.putExtra(StatisticManager.class.getSimpleName() + "_priority", StatisticManager.getPriority(getApplicationContext()));
            sendStickyBroadcast(intent);
            this.b.removeCallbacks(this.d);
            this.b.postDelayed(this.d, 500L);
            this.b.postDelayed(new c(this), 30000L);
            this.b.postDelayed(new e(this), TbConfig.USE_TIME_INTERVAL);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        com.baidu.android.nebula.d.b.b();
        i.a();
        StatisticManager.destroy();
        com.baidu.android.defense.c.a();
        if (this.a != null) {
            unregisterReceiver(this.a);
        }
        com.baidu.android.moplus.util.d.a(getApplicationContext()).b();
        k.d();
        if (com.baidu.android.nebula.a.f.a(getApplicationContext(), getClass().getName())) {
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
        if (com.baidu.android.moplus.util.d.a(getApplicationContext()).a()) {
            a(intent);
        } else {
            a(true);
        }
    }
}
