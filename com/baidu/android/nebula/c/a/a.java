package com.baidu.android.nebula.c.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class a {
    private static a d = null;

    /* renamed from: a  reason: collision with root package name */
    private Context f662a;
    private HashMap b = new HashMap();
    private BroadcastReceiver c;

    private a(Context context) {
        this.c = null;
        this.f662a = context;
        for (PackageInfo packageInfo : this.f662a.getPackageManager().getInstalledPackages(0)) {
            this.b.put(packageInfo.packageName, packageInfo);
        }
        this.c = new b(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        this.f662a.registerReceiver(this.c, intentFilter);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (d == null) {
                d = new a(context);
            }
            d.f662a = context.getApplicationContext();
            aVar = d;
        }
        return aVar;
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
