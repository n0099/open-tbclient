package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
/* loaded from: classes3.dex */
public final class d {
    private static d a;

    private d() {
    }

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    public static void a(Context context, Intent intent) {
        boolean z = false;
        String stringExtra = intent.getStringExtra(JPushInterface.EXTRA_MSG_ID);
        if (!TextUtils.isEmpty(stringExtra)) {
            String stringExtra2 = intent.getStringExtra(JPushInterface.EXTRA_NOTI_TYPE);
            byte byteExtra = intent.getByteExtra("platform", (byte) 0);
            if (stringExtra2 != null && "1".equals(stringExtra2)) {
                z = true;
            }
            if (true != z) {
                if (byteExtra == 0) {
                    cn.jpush.android.a.e.a(stringExtra, 1000, null, context);
                } else {
                    JPushInterface.reportNotificationOpened(context, stringExtra, byteExtra);
                }
            }
        }
        if (!cn.jpush.android.d.a.a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, true)) {
            cn.jpush.android.d.f.a("PushReceiverCore", "No ACTION_NOTIFICATION_OPENED defined in manifest, open the default main activity");
            cn.jpush.android.d.a.b(context);
            return;
        }
        Intent intent2 = new Intent(JPushInterface.ACTION_NOTIFICATION_OPENED);
        String str = "";
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                intent2.putExtras(extras);
            }
            str = intent.getStringExtra("app");
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            intent2.addCategory(str);
            intent2.setPackage(context.getPackageName());
            cn.jpush.android.d.f.a("PushReceiverCore", "Send broadcast to app: " + str + " action=" + intent2.getAction());
            context.sendBroadcast(intent2, str + ".permission.JPUSH_MESSAGE");
        } catch (Throwable th) {
            cn.jpush.android.d.f.c("PushReceiverCore", "onNotificationOpen sendBrocat error:" + th.getMessage());
            cn.jpush.android.d.a.b(context, intent2, str + ".permission.JPUSH_MESSAGE");
        }
    }
}
