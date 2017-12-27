package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
/* loaded from: classes2.dex */
public class RegistrationReceiver extends BroadcastReceiver {
    static void a(Context context, com.baidu.android.pushservice.b.f fVar) {
        Intent intent = new Intent();
        intent.setAction(PushConstants.ACTION_METHOD);
        intent.putExtra("method", "com.baidu.android.pushservice.action.UNBINDAPP");
        intent.putExtra("package_name", fVar.c());
        intent.putExtra("app_id", fVar.a());
        intent.putExtra("user_id", fVar.f);
        o.a(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, Intent intent) {
        if (context.getPackageName().equals(intent.getStringExtra("r_sync_from"))) {
            return;
        }
        String stringExtra = intent.getStringExtra("r_sync_rdata_v2");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        com.baidu.android.pushservice.b.b.a(context).a("r_v2", stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, Intent intent) {
        if (context.getPackageName().equals(intent.getStringExtra("r_sync_sdk_from"))) {
            return;
        }
        String stringExtra = intent.getStringExtra("r_sync_rdata_v2");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        com.baidu.android.pushservice.b.h.a(context).a("com.baidu.push.sdkr", stringExtra);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        String action = intent.getAction();
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            if (!"android.intent.action.PACKAGE_REMOVED".equals(action)) {
                if ("com.baidu.android.pushservice.action.BIND_SYNC".equals(action)) {
                    com.baidu.android.pushservice.i.d.a().a(new com.baidu.android.pushservice.i.c("register_sync", (short) 99) { // from class: com.baidu.android.pushservice.RegistrationReceiver.1
                        @Override // com.baidu.android.pushservice.i.c
                        public void a() {
                            if (!intent.hasExtra("r_sync_type")) {
                                RegistrationReceiver.c(context, intent);
                                return;
                            }
                            switch (intent.getIntExtra("r_sync_type", 0)) {
                                case 0:
                                    RegistrationReceiver.c(context, intent);
                                    return;
                                case 1:
                                case 2:
                                default:
                                    return;
                                case 3:
                                    RegistrationReceiver.d(context, intent);
                                    return;
                            }
                        }
                    });
                    return;
                } else {
                    o.b(context, intent);
                    return;
                }
            }
            try {
                String u = p.u(context);
                if (TextUtils.isEmpty(u) || context.getPackageName().equals(u)) {
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                    if (!booleanExtra) {
                        PushSettings.c(context, schemeSpecificPart);
                    }
                    com.baidu.android.pushservice.b.f c = com.baidu.android.pushservice.b.b.a(context).c(schemeSpecificPart);
                    if (booleanExtra || c == null || context.getPackageName().equals(c.c())) {
                        return;
                    }
                    a(context, c);
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
        }
    }
}
