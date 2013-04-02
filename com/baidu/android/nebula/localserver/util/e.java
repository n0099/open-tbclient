package com.baidu.android.nebula.localserver.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class e {
    private static e d = null;
    private Context a;
    private HashMap b = new HashMap();
    private BroadcastReceiver c;

    private e(Context context) {
        this.c = null;
        this.a = context;
        for (PackageInfo packageInfo : this.a.getPackageManager().getInstalledPackages(0)) {
            this.b.put(packageInfo.packageName, packageInfo);
        }
        this.c = new f(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        this.a.registerReceiver(this.c, intentFilter);
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (d == null) {
                d = new e(context);
            }
            d.a = context.getApplicationContext();
            eVar = d;
        }
        return eVar;
    }

    public void a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return;
        }
        synchronized (this.b) {
            this.b.put(packageInfo.packageName, packageInfo);
        }
    }

    public void a(String str) {
        if (str == null) {
            return;
        }
        synchronized (this.b) {
            this.b.remove(str);
        }
    }

    public ArrayList b(String str) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.b) {
            for (PackageInfo packageInfo : this.b.values()) {
                if (packageInfo.packageName.startsWith(str)) {
                    arrayList.add(packageInfo);
                }
            }
        }
        return arrayList;
    }
}
