package com.baidu.android.moplus;

import android.app.Service;
import android.content.Intent;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.common.util.Util;
import com.baidu.android.nebula.a.e;
import com.baidu.android.systemmonitor.StatisticManager;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class MoPlusService extends Service {

    /* renamed from: a  reason: collision with root package name */
    static LocalServerSocket f510a;
    static Set b = new HashSet();
    private Handler c = new Handler();
    private boolean d = false;
    private Runnable e = new c(this);
    private Runnable f = new d(this);

    private String a() {
        return Util.toMd5(("com.baidu.pushservice.singelinstancev1" + DeviceId.getDeviceID(this)).getBytes(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        this.c.removeCallbacks(this.e);
        this.c.removeCallbacks(this.f);
        if (intent != null && "service_sing_restart".equals(intent.getStringExtra("type"))) {
            a(true, true, false);
            com.baidu.android.moplus.util.b.a(getApplicationContext(), 1000L);
            return;
        }
        if (com.baidu.android.moplus.util.b.g(getApplicationContext(), getPackageName())) {
            com.baidu.android.nebula.c.c.b();
        } else {
            com.baidu.android.nebula.c.c.a(getApplicationContext(), intent);
        }
        if (com.baidu.android.moplus.util.b.f(getApplicationContext(), getPackageName())) {
            e.a();
        } else {
            e.a(getApplicationContext(), intent);
        }
        if (com.baidu.android.moplus.util.b.h(getApplicationContext())) {
            StatisticManager.destroy();
        } else {
            StatisticManager.handleOnStart(getApplicationContext(), intent);
        }
        if (com.baidu.android.moplus.util.b.j(getApplicationContext())) {
            com.baidu.android.defense.a.a(getApplicationContext(), intent);
        }
    }

    private void a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return;
        }
        this.d = z;
        if (z2) {
            this.f.run();
            return;
        }
        this.c.removeCallbacks(this.f);
        this.c.postDelayed(this.f, 1000L);
    }

    private boolean b() {
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
        if (com.baidu.android.moplus.util.b.a(getApplicationContext()) || b()) {
            a(true, true, false);
            return;
        }
        if (f510a == null) {
            try {
                f510a = new LocalServerSocket(a());
            } catch (Exception e) {
            }
        }
        if (f510a != null) {
            b.add(f510a);
        }
        if (b.size() <= 0) {
            a(true, true, false);
            return;
        }
        if (!com.baidu.android.moplus.util.b.f(getApplicationContext(), getPackageName())) {
            e.c(getApplicationContext());
        }
        Intent intent = new Intent("com.baidu.moplus.action.start.SERVICEINFO");
        intent.putExtra("version", (short) 12);
        intent.putExtra("priority", com.baidu.android.moplus.util.b.e(getApplicationContext()));
        intent.putExtra("packagename", getPackageName());
        intent.putExtra("method_version", "V2");
        intent.putExtra(StatisticManager.class.getSimpleName() + "_version", StatisticManager.getVersion(getApplicationContext()));
        intent.putExtra(StatisticManager.class.getSimpleName() + "_priority", StatisticManager.getPriority(getApplicationContext()));
        sendStickyBroadcast(intent);
        this.c.postDelayed(this.e, 500L);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            if (f510a != null) {
                f510a.close();
                f510a = null;
            }
        } catch (IOException e) {
        }
        com.baidu.android.nebula.c.c.b();
        e.a();
        StatisticManager.destroy();
        com.baidu.android.defense.a.a();
        b.clear();
        if (Util.hasOtherServiceRuninMyPid(getApplicationContext(), getClass().getName())) {
            this.d = false;
        }
        if (this.d) {
            Process.killProcess(Process.myPid());
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        if (intent == null) {
            intent = new Intent();
        }
        super.onStart(intent, i);
        if (b.size() == 0) {
            a(true, true, false);
        } else {
            a(intent);
        }
    }
}
