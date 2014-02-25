package com.baidu.android.systemmonitor.localapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.android.systemmonitor.c.c;
import com.baidu.android.systemmonitor.freqstatistic.d;
import com.baidu.android.systemmonitor.freqstatistic.e;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class AppManager {
    private static AppManager b = null;
    private Context a;
    private ConcurrentHashMap c;
    private PackageReceiver d;

    /* loaded from: classes.dex */
    public class PackageReceiver extends BroadcastReceiver {
        public PackageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a aVar;
            a a;
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            d dVar = new d(schemeSpecificPart);
            if (dVar == null) {
                return;
            }
            dVar.b = System.currentTimeMillis();
            String action = intent.getAction();
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                if (intent.getBooleanExtra("android.intent.extra.REPLACING", false) || (a = c.a(AppManager.this.a, schemeSpecificPart)) == null) {
                    return;
                }
                AppManager.this.c.put(a.a(), a);
                dVar.c = 0;
                dVar.e = a.f;
                dVar.d = a.b;
                dVar.h = a.a(AppManager.this.a);
            } else if (action.equals("android.intent.action.PACKAGE_REPLACED")) {
                a aVar2 = (a) AppManager.this.c.remove(schemeSpecificPart);
                if (aVar2 == null) {
                    return;
                }
                dVar.c = 1;
                dVar.e = aVar2.f;
                dVar.d = aVar2.b;
                dVar.h = aVar2.a(AppManager.this.a);
                a a2 = c.a(AppManager.this.a, schemeSpecificPart);
                if (a2 == null) {
                    return;
                }
                AppManager.this.c.put(a2.a(), a2);
                dVar.g = a2.f;
                dVar.f = a2.b;
            } else if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                if (intent.getBooleanExtra("android.intent.extra.REPLACING", false) || (aVar = (a) AppManager.this.c.remove(schemeSpecificPart)) == null) {
                    return;
                }
                dVar.c = 2;
                dVar.e = aVar.f;
                dVar.d = aVar.b;
                dVar.h = aVar.a(AppManager.this.a);
            }
            e.a(AppManager.this.a).a(AppManager.this.a.getContentResolver(), dVar);
        }
    }

    private AppManager(Context context) {
        this.a = null;
        this.c = null;
        this.d = null;
        this.a = context.getApplicationContext();
        this.c = new ConcurrentHashMap();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        this.d = new PackageReceiver();
        this.a.registerReceiver(this.d, intentFilter);
        d();
    }

    public static synchronized AppManager a(Context context) {
        AppManager appManager;
        synchronized (AppManager.class) {
            if (b == null) {
                b = new AppManager(context);
            }
            appManager = b;
        }
        return appManager;
    }

    public static void c() {
        if (b != null) {
            b.e();
            b = null;
        }
    }

    private void d() {
        System.currentTimeMillis();
        for (PackageInfo packageInfo : c.a(this.a)) {
            a aVar = new a();
            aVar.c((String) packageInfo.applicationInfo.loadLabel(this.a.getPackageManager()));
            aVar.b = packageInfo.versionName;
            aVar.f = packageInfo.versionCode;
            if (Build.VERSION.SDK_INT < 8) {
                aVar.h = false;
            } else {
                aVar.h = (packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) == 0) ? false : true;
            }
            aVar.e(packageInfo.packageName);
            c.a(this.a, packageInfo, aVar);
            try {
                int intValue = ((Integer) packageInfo.getClass().getField("installLocation").get(packageInfo)).intValue();
                if (intValue != 0 && intValue != 2) {
                    aVar.i = 1;
                } else if (Build.VERSION.SDK_INT < 8) {
                    aVar.i = 2;
                } else if ((packageInfo.applicationInfo.flags & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0) {
                    aVar.i = 3;
                } else {
                    aVar.i = 2;
                }
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e2) {
            } catch (NoSuchFieldException e3) {
            }
            if (packageInfo.applicationInfo != null) {
                if ((packageInfo.applicationInfo.flags & 128) == 128) {
                    aVar.g = true;
                    aVar.a(true);
                } else if ((packageInfo.applicationInfo.flags & 1) == 1) {
                    aVar.g = true;
                } else {
                    aVar.g = false;
                }
            }
            this.c.put(aVar.a(), aVar);
        }
    }

    private void e() {
        this.a.unregisterReceiver(this.d);
    }

    public ConcurrentHashMap a() {
        return this.c;
    }

    public void b() {
        if (this.c == null || this.c.size() == 0) {
            return;
        }
        for (a aVar : this.c.values()) {
            aVar.b(this.a);
            aVar.c(this.a);
        }
    }
}
