package com.baidu.android.nebula.c.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f662a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f662a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            try {
                this.f662a.a(context.getPackageManager().getPackageInfo(schemeSpecificPart, 0));
            } catch (PackageManager.NameNotFoundException e) {
            }
        } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
            this.f662a.a(schemeSpecificPart);
        }
    }
}
