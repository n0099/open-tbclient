package com.baidu.android.systemmonitor.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
/* loaded from: classes.dex */
final class c extends Thread {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, Context context) {
        super(str);
        this.a = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        System.currentTimeMillis();
        PackageManager packageManager = this.a.getPackageManager();
        ComponentName componentName = new ComponentName(this.a.getPackageName(), "com.baidu.android.moplus.MoPlusService");
        ComponentName componentName2 = new ComponentName(this.a.getPackageName(), "com.baidu.android.moplus.MoPlusReceiver");
        ComponentName componentName3 = new ComponentName(this.a.getPackageName(), "com.baidu.android.defense.push.PushMsgReceiver");
        packageManager.setComponentEnabledSetting(componentName, 2, 1);
        packageManager.setComponentEnabledSetting(componentName2, 2, 1);
        packageManager.setComponentEnabledSetting(componentName3, 2, 1);
    }
}
