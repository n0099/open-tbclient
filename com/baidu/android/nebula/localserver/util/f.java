package com.baidu.android.nebula.localserver.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BroadcastReceiver {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            try {
                this.a.a(context.getPackageManager().getPackageInfo(schemeSpecificPart, 0));
            } catch (PackageManager.NameNotFoundException e) {
            }
        } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
            this.a.a(schemeSpecificPart);
        }
    }
}
