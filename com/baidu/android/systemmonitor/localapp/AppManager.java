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

    /* JADX WARN: Can't wrap try/catch for region: R(13:4|(1:6)(2:41|(1:46)(8:45|8|9|10|(2:28|(1:30)(2:31|(1:33)(1:34)))(1:13)|14|(1:27)(2:16|(2:18|19)(2:21|(2:23|24)(2:25|26)))|20))|7|8|9|10|(0)|28|(0)(0)|14|(0)(0)|20|2) */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e A[Catch: NoSuchFieldException -> 0x00a7, IllegalArgumentException -> 0x00ad, IllegalAccessException -> 0x00b3, TRY_LEAVE, TryCatch #2 {IllegalAccessException -> 0x00b3, IllegalArgumentException -> 0x00ad, NoSuchFieldException -> 0x00a7, blocks: (B:10:0x0052, B:35:0x00af, B:13:0x006a, B:15:0x006e, B:27:0x009c, B:29:0x00a3, B:32:0x00a9), top: B:45:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c A[Catch: NoSuchFieldException -> 0x00a7, IllegalArgumentException -> 0x00ad, IllegalAccessException -> 0x00b3, TRY_ENTER, TryCatch #2 {IllegalAccessException -> 0x00b3, IllegalArgumentException -> 0x00ad, NoSuchFieldException -> 0x00a7, blocks: (B:10:0x0052, B:35:0x00af, B:13:0x006a, B:15:0x006e, B:27:0x009c, B:29:0x00a3, B:32:0x00a9), top: B:45:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        a aVar;
        boolean z;
        a aVar2;
        int intValue;
        System.currentTimeMillis();
        for (PackageInfo packageInfo : c.a(this.a)) {
            a aVar3 = new a();
            aVar3.c((String) packageInfo.applicationInfo.loadLabel(this.a.getPackageManager()));
            aVar3.b = packageInfo.versionName;
            aVar3.f = packageInfo.versionCode;
            if (Build.VERSION.SDK_INT < 8) {
                aVar = aVar3;
            } else if (packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) == 0) {
                aVar = aVar3;
            } else {
                z = true;
                aVar2 = aVar3;
                aVar2.h = z;
                aVar3.e(packageInfo.packageName);
                c.a(this.a, packageInfo, aVar3);
                intValue = ((Integer) packageInfo.getClass().getField("installLocation").get(packageInfo)).intValue();
                if (intValue == 0 && intValue != 2) {
                    aVar3.i = 1;
                } else if (Build.VERSION.SDK_INT >= 8) {
                    aVar3.i = 2;
                } else if ((packageInfo.applicationInfo.flags & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0) {
                    aVar3.i = 3;
                } else {
                    aVar3.i = 2;
                }
                if (packageInfo.applicationInfo != null) {
                    if ((packageInfo.applicationInfo.flags & 128) == 128) {
                        aVar3.g = true;
                        aVar3.a(true);
                    } else if ((packageInfo.applicationInfo.flags & 1) == 1) {
                        aVar3.g = true;
                    } else {
                        aVar3.g = false;
                    }
                }
                this.c.put(aVar3.a(), aVar3);
            }
            aVar2 = aVar;
            z = false;
            aVar2.h = z;
            aVar3.e(packageInfo.packageName);
            c.a(this.a, packageInfo, aVar3);
            intValue = ((Integer) packageInfo.getClass().getField("installLocation").get(packageInfo)).intValue();
            if (intValue == 0) {
            }
            if (Build.VERSION.SDK_INT >= 8) {
            }
            if (packageInfo.applicationInfo != null) {
            }
            this.c.put(aVar3.a(), aVar3);
        }
    }

    private void e() {
        this.a.unregisterReceiver(this.d);
    }

    public final ConcurrentHashMap a() {
        return this.c;
    }

    public final void b() {
        if (this.c == null || this.c.size() == 0) {
            return;
        }
        for (a aVar : this.c.values()) {
            aVar.b(this.a);
            aVar.c(this.a);
        }
    }
}
