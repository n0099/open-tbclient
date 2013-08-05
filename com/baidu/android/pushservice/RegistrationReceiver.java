package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.baidu.android.common.logging.Log;
/* loaded from: classes.dex */
public class RegistrationReceiver extends BroadcastReceiver {
    private void a(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("r_sync_rdata");
        String stringExtra2 = intent.getStringExtra("r_sync_rdata_v2");
        String stringExtra3 = intent.getStringExtra("r_sync_from");
        if (context.getPackageName().equals(stringExtra3)) {
            return;
        }
        if (stringExtra != null) {
            if (b.a()) {
                Log.i("RegistrationReceiver", "handleRegisterSync rdata: " + stringExtra + " from: " + stringExtra3);
            }
            SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1).edit();
            edit.putString("r", stringExtra);
            edit.commit();
            a.b(context);
        }
        if (stringExtra2 != null) {
            if (b.a()) {
                Log.i("RegistrationReceiver", "handleRegisterSync rdata v2: " + stringExtra2 + " from: " + stringExtra3);
            }
            SharedPreferences.Editor edit2 = context.getSharedPreferences(context.getPackageName() + ".push_sync", 1).edit();
            edit2.putString("r_v2", stringExtra2);
            edit2.commit();
            a.b(context);
        }
    }

    static void a(Context context, d dVar) {
        Intent intent = new Intent();
        intent.setAction(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.UNBINDAPP");
        intent.putExtra("package_name", dVar.f579a);
        intent.putExtra(PushConstants.EXTRA_APP_ID, dVar.b);
        intent.putExtra(PushConstants.EXTRA_USER_ID, dVar.c);
        b.a(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!"android.intent.action.PACKAGE_REMOVED".equals(action)) {
            if ("com.baidu.android.pushservice.action.BIND_SYNC".equals(action)) {
                a(context, intent);
            }
            b.a(context, intent);
            return;
        }
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        Log.i("RegistrationReceiver", "start for ACTION_PACKAGE_REMOVED，replacing：" + booleanExtra + " ,packageName: " + schemeSpecificPart);
        d a2 = a.a(context).a(schemeSpecificPart);
        if (booleanExtra || a2 == null || context.getPackageName().equals(a2.f579a)) {
            Log.i("RegistrationReceiver", "replacing or not registered push client : " + schemeSpecificPart);
            b.a(context, intent);
            return;
        }
        Log.i("RegistrationReceiver", "unregister registered push client : " + schemeSpecificPart);
        a(context, a2);
    }
}
