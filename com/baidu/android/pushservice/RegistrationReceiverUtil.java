package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.t;
import com.baidu.android.pushservice.h.u;
/* loaded from: classes2.dex */
public class RegistrationReceiverUtil {
    private static final String TAG = "RegistrationReceiverUtil";

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRegisterSDKSync(Context context, Intent intent) {
        if (context.getPackageName().equals(intent.getStringExtra("r_sync_sdk_from"))) {
            return;
        }
        String stringExtra = intent.getStringExtra("r_sync_rdata_v2");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        com.baidu.android.pushservice.b.h.a(context).a("com.baidu.push.sdkr", stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRegisterSync(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("r_sync_from");
        if (context.getPackageName().equals(stringExtra)) {
            return;
        }
        String stringExtra2 = intent.getStringExtra("r_sync_rdata_v2");
        if (TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        com.baidu.android.pushservice.e.a.b(TAG, "handleRegisterSync rdataV2: " + stringExtra2 + " from: " + stringExtra);
        com.baidu.android.pushservice.b.b.a(context).a("r_v2", stringExtra2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRegisterWebSync(Context context, Intent intent) {
        if (context.getPackageName().equals(intent.getStringExtra("r_sync_from"))) {
            return;
        }
        String stringExtra = intent.getStringExtra("r_sync_rdata_v2");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        com.baidu.android.pushservice.b.j.a(context).a("com.baidu.push.webr", stringExtra);
    }

    public static void onReceive(final Context context, final Intent intent) {
        String action = intent.getAction();
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            if (!"android.intent.action.PACKAGE_REMOVED".equals(action)) {
                if ("com.baidu.android.pushservice.action.BIND_SYNC".equals(action)) {
                    com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("register_sync", (short) 99) { // from class: com.baidu.android.pushservice.RegistrationReceiverUtil.1
                        @Override // com.baidu.android.pushservice.g.c
                        public void a() {
                            if (!intent.hasExtra("r_sync_type")) {
                                RegistrationReceiverUtil.handleRegisterSync(context, intent);
                                return;
                            }
                            switch (intent.getIntExtra("r_sync_type", 0)) {
                                case 0:
                                    RegistrationReceiverUtil.handleRegisterSync(context, intent);
                                    return;
                                case 1:
                                    RegistrationReceiverUtil.handleRegisterWebSync(context, intent);
                                    return;
                                case 2:
                                default:
                                    return;
                                case 3:
                                    RegistrationReceiverUtil.handleRegisterSDKSync(context, intent);
                                    return;
                            }
                        }
                    });
                    return;
                } else {
                    t.b(context, intent);
                    return;
                }
            }
            try {
                String t = u.t(context);
                if (!TextUtils.isEmpty(t) && !context.getPackageName().equals(t)) {
                    com.baidu.android.pushservice.e.a.b(TAG, "not hightest package return");
                    return;
                }
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                com.baidu.android.pushservice.e.a.b(TAG, "start for ACTION_PACKAGE_REMOVED，replacing：" + booleanExtra + " ,packageName: " + schemeSpecificPart);
                if (!booleanExtra) {
                    PushSettings.c(context, schemeSpecificPart);
                }
                com.baidu.android.pushservice.b.f c = com.baidu.android.pushservice.b.b.a(context).c(schemeSpecificPart);
                if (booleanExtra || c == null || context.getPackageName().equals(c.c())) {
                    return;
                }
                com.baidu.android.pushservice.e.a.b(TAG, "unregister registered push client : " + schemeSpecificPart);
                packageUninstalled(context, c);
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.a(TAG, e);
            }
        } catch (Exception e2) {
            com.baidu.android.pushservice.e.a.c(TAG, "attack by null Serializable data and return");
        }
    }

    static void packageUninstalled(Context context, com.baidu.android.pushservice.b.f fVar) {
        Intent intent = new Intent();
        intent.setAction(PushConstants.ACTION_METHOD);
        intent.putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.UNBINDAPP");
        intent.putExtra("package_name", fVar.c());
        intent.putExtra("app_id", fVar.a());
        intent.putExtra("user_id", fVar.f);
        t.a(context, intent);
    }
}
