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
import com.baidu.tieba.service.TiebaUpdateService;
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
        this.c.removeCallbacks(this.f);
        this.c.removeCallbacks(this.g);
        if (intent != null && "pushservice_restart".equals(intent.getStringExtra(PushConstants.EXTRA_METHOD))) {
            a(true, true);
            com.baidu.android.pushservice.util.d.a(getApplicationContext(), 1000L);
        } else if (this.e.a(intent)) {
        } else {
            d();
        }
    }

    private void a(boolean z, boolean z2) {
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
            a(true, false);
            return;
        }
        if (!a.a(this).a()) {
            l lVar = new l(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.pushservice.action.connect.STAMP");
            Intent registerReceiver = registerReceiver(lVar, intentFilter);
            long longExtra = registerReceiver != null ? registerReceiver.getLongExtra("last_connect_stamp", 0L) : 0L;
            unregisterReceiver(lVar);
            if (System.currentTimeMillis() - longExtra < w.d) {
                a(true, false);
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
        List<ResolveInfo> queryBroadcastReceivers = getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.android.pushservice.action.BIND_SYNC"), 0);
        if (queryBroadcastReceivers.size() <= 1) {
            return false;
        }
        long j = getSharedPreferences(getPackageName() + ".push_sync", 1).getLong("priority", 0L);
        Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            String str = it.next().activityInfo.packageName;
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
        SharedPreferences sharedPreferences = getSharedPreferences("pushservice.mysetting", 0);
        int c = com.baidu.android.pushservice.util.d.c(getApplicationContext(), getPackageName());
        if (sharedPreferences.getInt("priority_vcode", 0) < c) {
            SharedPreferences.Editor edit = getSharedPreferences(getPackageName() + ".push_sync", 1).edit();
            edit.putLong("priority", com.baidu.android.pushservice.util.d.e(getApplicationContext()));
            edit.putInt(TiebaUpdateService.TAG_VERSION, 3);
            edit.commit();
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putInt("priority_vcode", c);
            edit2.commit();
        }
        if (!b.a(getApplicationContext()) || g()) {
            a(true, true);
            return;
        }
        if (b == null) {
            try {
                b = new LocalServerSocket(b());
            } catch (Exception e) {
            }
        }
        if (b == null) {
            a(true, true);
            return;
        }
        c();
        this.e = new x(this);
        registerReceiver(this.j, new IntentFilter("android.intent.action.SCREEN_ON"));
        this.c.postDelayed(this.f, 500L);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            if (b != null) {
                b.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (a != null) {
            a.c();
        }
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
        if (b == null) {
            a(true, true);
        } else {
            a(intent);
        }
    }
}
