package com.baidu.android.systemmonitor.localapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import com.baidu.android.systemmonitor.b.d;
import com.baidu.zeus.bouncycastle.DERTags;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class AppManager {
    private static AppManager b = null;

    /* renamed from: a  reason: collision with root package name */
    private Context f695a;
    private ConcurrentHashMap c;
    private PackageReceiver d;

    /* loaded from: classes.dex */
    public class PackageReceiver extends BroadcastReceiver {
        public PackageReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            a aVar;
            a a2;
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            com.baidu.android.systemmonitor.b.a aVar2 = new com.baidu.android.systemmonitor.b.a(schemeSpecificPart);
            if (aVar2 == null) {
                return;
            }
            aVar2.b = System.currentTimeMillis();
            String action = intent.getAction();
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                if (intent.getBooleanExtra("android.intent.extra.REPLACING", false) || (a2 = com.baidu.android.systemmonitor.d.a.a(AppManager.this.f695a, schemeSpecificPart)) == null) {
                    return;
                }
                AppManager.this.c.put(a2.a(), a2);
                aVar2.c = 0;
                aVar2.e = a2.f;
                aVar2.d = a2.b;
                aVar2.h = a2.a(AppManager.this.f695a);
            } else if (action.equals("android.intent.action.PACKAGE_REPLACED")) {
                a aVar3 = (a) AppManager.this.c.remove(schemeSpecificPart);
                if (aVar3 == null) {
                    return;
                }
                aVar2.c = 1;
                aVar2.e = aVar3.f;
                aVar2.d = aVar3.b;
                aVar2.h = aVar3.a(AppManager.this.f695a);
                a a3 = com.baidu.android.systemmonitor.d.a.a(AppManager.this.f695a, schemeSpecificPart);
                if (a3 == null) {
                    return;
                }
                AppManager.this.c.put(a3.a(), a3);
                aVar2.g = a3.f;
                aVar2.f = a3.b;
            } else if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                if (intent.getBooleanExtra("android.intent.extra.REPLACING", false) || (aVar = (a) AppManager.this.c.remove(schemeSpecificPart)) == null) {
                    return;
                }
                aVar2.c = 2;
                aVar2.e = aVar.f;
                aVar2.d = aVar.b;
                aVar2.h = aVar.a(AppManager.this.f695a);
            }
            d.a(AppManager.this.f695a).a(AppManager.this.f695a.getContentResolver(), aVar2);
        }
    }

    private AppManager(Context context) {
        this.f695a = null;
        this.c = null;
        this.d = null;
        this.f695a = context.getApplicationContext();
        this.c = new ConcurrentHashMap();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        this.d = new PackageReceiver();
        this.f695a.registerReceiver(this.d, intentFilter);
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
        for (PackageInfo packageInfo : com.baidu.android.systemmonitor.d.a.a(this.f695a)) {
            a aVar = new a();
            aVar.c((String) packageInfo.applicationInfo.loadLabel(this.f695a.getPackageManager()));
            aVar.b = packageInfo.versionName;
            aVar.f = packageInfo.versionCode;
            aVar.h = (packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 262144) == 0) ? false : true;
            aVar.e(packageInfo.packageName);
            com.baidu.android.systemmonitor.d.a.a(this.f695a, packageInfo, aVar);
            try {
                int intValue = ((Integer) packageInfo.getClass().getField("installLocation").get(packageInfo)).intValue();
                if (intValue != 0 && intValue != 2) {
                    aVar.i = 1;
                } else if ((packageInfo.applicationInfo.flags & 262144) != 0) {
                    aVar.i = 3;
                } else {
                    aVar.i = 2;
                }
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e2) {
            } catch (NoSuchFieldException e3) {
            }
            if (packageInfo.applicationInfo != null) {
                if ((packageInfo.applicationInfo.flags & DERTags.TAGGED) == 128) {
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
        this.f695a.unregisterReceiver(this.d);
    }

    public ConcurrentHashMap a() {
        return this.c;
    }

    public void b() {
        if (this.c == null || this.c.size() == 0) {
            return;
        }
        for (a aVar : this.c.values()) {
            aVar.b(this.f695a);
            aVar.c(this.f695a);
        }
    }
}
