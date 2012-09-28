package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
/* loaded from: classes.dex */
public class RegistratonReceiver extends BroadcastReceiver {
    private void a(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("r_sync_rdata");
        if (context.getPackageName().equals(intent.getStringExtra("r_sync_from")) || stringExtra == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1).edit();
        edit.putString("r", stringExtra);
        edit.commit();
    }

    static void a(Context context, b bVar) {
        Intent intent = new Intent();
        intent.setAction(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.UNBINDAPP");
        intent.putExtra("package_name", bVar.a);
        intent.putExtra(PushConstants.EXTRA_APP_ID, bVar.b);
        intent.putExtra(PushConstants.EXTRA_USER_ID, bVar.c);
        intent.setClass(context, PushService.class);
        context.startService(intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!"android.intent.action.PACKAGE_REMOVED".equals(action)) {
            if ("com.baidu.android.pushservice.action.BIND_SYNC".equals(action)) {
                a(context, intent);
            }
            intent.setClass(context, PushService.class);
            context.startService(intent);
            return;
        }
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        b a = a.a(context).a(schemeSpecificPart);
        if (!booleanExtra && a != null && !context.getPackageName().equals(a.a)) {
            a(context, a);
            return;
        }
        intent.setClass(context, PushService.class);
        context.startService(intent);
    }
}
