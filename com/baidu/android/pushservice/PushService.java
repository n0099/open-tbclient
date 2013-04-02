package com.baidu.android.pushservice;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.common.util.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PushService extends Service {
    public static d a;
    static LocalServerSocket b;
    private x e;
    private Handler c = new Handler();
    private boolean d = false;
    private Runnable f = new j(this);
    private Runnable g = new k(this);
    private Runnable h = new m(this);
    private Runnable i = new n(this);
    private final BroadcastReceiver j = new o(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (com.baidu.android.pushservice.util.d.g(getApplicationContext(), getPackageName())) {
            com.baidu.android.nebula.localserver.c.a().c();
        } else {
            com.baidu.android.nebula.localserver.c.a().a(getApplicationContext());
        }
        if (com.baidu.android.pushservice.util.d.f(getApplicationContext(), getPackageName())) {
            com.baidu.android.nebula.a.h.e();
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && ConnectManager.isNetworkConnected(getApplicationContext())) {
            com.baidu.android.nebula.a.h.c(getApplicationContext());
        }
        this.c.removeCallbacks(this.f);
        this.c.removeCallbacks(this.g);
        if (intent != null && "pushservice_restart".equals(intent.getStringExtra(PushConstants.EXTRA_METHOD))) {
            a(true, true, false);
            com.baidu.android.pushservice.util.d.a(getApplicationContext(), 1000L);
            return;
        }
        try {
            if (this.e.a(intent)) {
                return;
            }
        } catch (Exception e) {
        }
        d();
    }

    private void a(boolean z, boolean z2, boolean z3) {
        if (z3 && com.baidu.android.nebula.localserver.c.a().d()) {
            if (a == null || !a.a()) {
                return;
            }
            a.c();
            return;
        }
        this.d = z;
        if (z2) {
            this.g.run();
            return;
        }
        this.c.removeCallbacks(this.g);
        this.c.postDelayed(this.g, 1000L);
    }

    private String b() {
        return Util.toMd5(("com.baidu.pushservice.singelinstancev1" + DeviceId.getDeviceID(this)).getBytes(), false);
    }

    private void c() {
        a = d.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!ConnectManager.isNetworkConnected(this)) {
            a(true, false, true);
            return;
        }
        boolean a2 = a.a(this).a();
        if (!a2 && !b.b(getApplicationContext())) {
            a(true, false, true);
            return;
        }
        if (!a2) {
            l lVar = new l(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.pushservice.action.connect.STAMP");
            Intent registerReceiver = registerReceiver(lVar, intentFilter);
            long longExtra = registerReceiver != null ? registerReceiver.getLongExtra("last_connect_stamp", 0L) : 0L;
            unregisterReceiver(lVar);
            if (System.currentTimeMillis() - longExtra < w.e) {
                a(true, false, true);
                return;
            }
        }
        if (a != null) {
            if (a.a()) {
                a.d();
            } else if (y.a().d()) {
                e();
            } else {
                f();
            }
        }
    }

    private void e() {
        this.c.removeCallbacks(this.h);
        this.c.postDelayed(this.h, 1000L);
    }

    private void f() {
        this.c.removeCallbacks(this.i);
        this.c.postDelayed(this.i, 500L);
    }

    private boolean g() {
        boolean z;
        List k = com.baidu.android.pushservice.util.d.k(getApplicationContext());
        if (k.size() <= 1) {
            return false;
        }
        long j = getSharedPreferences(getPackageName() + ".push_sync", 1).getLong("priority", 0L);
        Iterator it = k.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            String str = ((ResolveInfo) it.next()).activityInfo.packageName;
            if (!getPackageName().equals(str)) {
                SharedPreferences sharedPreferences = null;
                try {
                    sharedPreferences = createPackageContext(str, 2).getSharedPreferences(str + ".push_sync", 1);
                } catch (PackageManager.NameNotFoundException e) {
                }
                if (sharedPreferences != null && sharedPreferences.getLong("priority", 0L) > j) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Intent intent = new Intent("com.baidu.pushservice.action.TOKEN");
        intent.setClass(this, PushService.class);
        startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.baidu.android.pushservice.util.d.j(getApplicationContext());
        if (com.baidu.android.pushservice.util.d.c(getApplicationContext()) || g()) {
            a(true, true, false);
            return;
        }
        if (b == null) {
            try {
                b = new LocalServerSocket(b());
            } catch (Exception e) {
            }
        }
        if (b == null) {
            a(true, true, false);
            return;
        }
        c();
        this.e = new x(this);
        registerReceiver(this.j, new IntentFilter("android.intent.action.SCREEN_ON"));
        if (!com.baidu.android.pushservice.util.d.f(getApplicationContext(), getPackageName())) {
            com.baidu.android.nebula.a.h.c(getApplicationContext());
        }
        Intent intent = new Intent("com.baidu.pushservice.action.start.SERVICEINFO");
        intent.putExtra("version", (short) 5);
        intent.putExtra("priority", com.baidu.android.pushservice.util.d.i(getApplicationContext()));
        intent.putExtra("packagename", getPackageName());
        intent.putExtra("method_version", "V1");
        sendStickyBroadcast(intent);
        this.c.postDelayed(this.f, 500L);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            if (b != null) {
                b.close();
                b = null;
            }
        } catch (IOException e) {
        }
        if (a != null) {
            a.c();
            a = null;
        }
        com.baidu.android.nebula.localserver.c.a().c();
        com.baidu.android.nebula.a.h.e();
        try {
            unregisterReceiver(this.j);
        } catch (IllegalArgumentException e2) {
        }
        if (this.d) {
            Process.killProcess(Process.myPid());
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (b != null) {
            a(intent);
            return;
        }
        if (getPackageName().equals(intent.getPackage())) {
            Intent intent2 = new Intent(intent.getAction());
            intent.putExtras(intent.getExtras());
            intent2.setPackage(null);
            com.baidu.android.pushservice.util.d.a(getApplicationContext(), intent2, 1000L);
        }
        a(true, true, false);
    }
}
