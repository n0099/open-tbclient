package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.k;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.message.PublicMsg;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URISyntaxException;
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    private static Intent a(Context context, PublicMsg publicMsg) {
        try {
            Intent intent = new Intent();
            try {
                intent.setClassName(context.getPackageName(), publicMsg.getLauncherActivityName(context, context.getPackageName()));
                intent.setFlags(268435456);
                return intent;
            } catch (Exception e) {
                return intent;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    private static Intent a(String str) {
        try {
            Intent intent = new Intent();
            try {
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(268435456);
                return intent;
            } catch (Exception e) {
                return intent;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    private static void a(Context context, PublicMsg publicMsg, byte[] bArr, byte[] bArr2) {
        Intent intent = new Intent();
        intent.setPackage(publicMsg.mPkgName);
        intent.putExtra("method", "com.baidu.android.pushservice.action.notification.ARRIVED");
        intent.putExtra("msgid", publicMsg.mMsgId);
        intent.putExtra("notification_title", publicMsg.mTitle);
        intent.putExtra("notification_content", publicMsg.mDescription);
        intent.putExtra("extra_extra_custom_content", publicMsg.mCustomContent);
        intent.putExtra("com.baidu.pushservice.app_id", publicMsg.mAppId);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.putExtra("baidu_message_body", bArr2);
        l.b(context, intent, PushConstants.ACTION_RECEIVE, publicMsg.mPkgName);
    }

    public static void a(Context context, String str, String str2, PublicMsg publicMsg) {
        Intent a;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(com.coloros.mcssdk.PushManager.MESSAGE_TYPE_NOTI);
            if (TextUtils.isEmpty(publicMsg.mPkgContent)) {
                a = !TextUtils.isEmpty(publicMsg.mUrl) ? a(publicMsg.mUrl) : a(context, publicMsg);
            } else {
                try {
                    a = Intent.parseUri(publicMsg.mPkgContent, 1);
                    a.setPackage(context.getPackageName());
                } catch (URISyntaxException e) {
                    a = a(context, publicMsg);
                }
            }
            if (a != null) {
                PendingIntent activity = PendingIntent.getActivity(context, 0, a, 0);
                Notification a2 = c.a(context, 0, 7, publicMsg.mTitle, publicMsg.mDescription, false);
                if (a2 != null) {
                    a2.contentIntent = activity;
                    notificationManager.notify(System.currentTimeMillis() + "", 0, a2);
                }
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2, PublicMsg publicMsg, byte[] bArr, byte[] bArr2) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(com.coloros.mcssdk.PushManager.MESSAGE_TYPE_NOTI);
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.setAction("com.baidu.android.pushservice.action.privatenotification.CLICK");
        intent.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra(Constants.APP_ID, publicMsg.mAppId);
        intent.putExtra("msg_id", publicMsg.mMsgId);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.putExtra("baidu_message_body", bArr2);
        PendingIntent service = PendingIntent.getService(context, 0, intent, 0);
        Intent intent2 = new Intent();
        intent2.setClassName(str, str2);
        intent2.setAction("com.baidu.android.pushservice.action.privatenotification.DELETE");
        intent2.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent2.putExtra("public_msg", publicMsg);
        intent2.putExtra(Constants.APP_ID, publicMsg.mAppId);
        intent2.putExtra("msg_id", publicMsg.mMsgId);
        PendingIntent service2 = PendingIntent.getService(context, 0, intent2, 0);
        boolean q = l.q(context, publicMsg.mPkgName);
        Notification a = publicMsg.mNotificationBuilder == 0 ? c.a(context, publicMsg.mNotificationBuilder, publicMsg.mNotificationBasicStyle, publicMsg.mTitle, publicMsg.mDescription, q) : c.a(context, publicMsg.mNotificationBuilder, publicMsg.mTitle, publicMsg.mDescription, q);
        a.contentIntent = service;
        a.deleteIntent = service2;
        notificationManager.notify(publicMsg.mMsgId, 0, a);
        a(context, publicMsg, bArr, bArr2);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        String action = intent.getAction();
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            if ("android.intent.action.BOOT_COMPLETED".equals(action) || "android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.USER_PRESENT".equals(action) || "android.intent.action.MEDIA_CHECKING".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action) || "android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                if (com.baidu.android.pushservice.b.d.k(context) || l.h(context.getApplicationContext()) <= 0) {
                    return;
                }
                k.d(context);
            } else if ("com.baidu.android.pushservice.action.notification.SHOW".equals(action)) {
                if (!com.baidu.android.pushservice.b.d.k(context) || com.baidu.android.pushservice.b.d.c(context)) {
                    final String stringExtra = intent.getStringExtra("pushService_package_name");
                    final String stringExtra2 = intent.getStringExtra("service_name");
                    final String stringExtra3 = intent.getStringExtra("notify_type");
                    final String stringExtra4 = intent.getStringExtra(Constants.APP_ID);
                    final byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_body");
                    final byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_secur_info");
                    int intExtra = intent.getIntExtra("baidu_message_type", -1);
                    final String stringExtra5 = intent.getStringExtra("message_id");
                    if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || byteArrayExtra == null || byteArrayExtra2 == null || intExtra == -1 || l.t(context, stringExtra5) || !com.baidu.android.pushservice.c.a.a(context, stringExtra5)) {
                        return;
                    }
                    com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("showPrivateNotification", (short) 99) { // from class: com.baidu.android.pushservice.PushServiceReceiver.1
                        @Override // com.baidu.android.pushservice.h.c
                        public void a() {
                            PublicMsg a = com.baidu.android.pushservice.message.a.d.a(context, stringExtra4, stringExtra5, byteArrayExtra2, byteArrayExtra);
                            if (a != null && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(stringExtra3)) {
                                PushServiceReceiver.b(context, stringExtra, stringExtra2, a, byteArrayExtra2, byteArrayExtra);
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
        }
    }
}
