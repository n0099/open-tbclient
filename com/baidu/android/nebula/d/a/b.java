package com.baidu.android.nebula.d.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BroadcastReceiver {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        HashMap hashMap;
        String action = intent.getAction();
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            try {
                this.a.a(context.getPackageManager().getPackageInfo(schemeSpecificPart, 0));
            } catch (PackageManager.NameNotFoundException e) {
            }
        } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
            this.a.a(schemeSpecificPart);
        } else if ("android.intent.action.PACKAGE_CHANGED".equals(action)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(schemeSpecificPart, 0);
                hashMap = this.a.b;
                hashMap.put(schemeSpecificPart, packageInfo);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }
}
