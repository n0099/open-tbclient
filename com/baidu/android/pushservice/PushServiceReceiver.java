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
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.util.io.ActionJsonData;
import java.net.URISyntaxException;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    private static Intent a(Context context, String str) {
        Intent intent;
        Exception e;
        try {
            intent = new Intent();
            try {
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(268435456);
            } catch (Exception e2) {
                e = e2;
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return intent;
            }
        } catch (Exception e3) {
            intent = null;
            e = e3;
        }
        return intent;
    }

    public static void a(Context context, PublicMsg publicMsg) {
        Intent intent;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (TextUtils.isEmpty(publicMsg.mPkgContent)) {
                intent = !TextUtils.isEmpty(publicMsg.mUrl) ? a(context, publicMsg.mUrl) : b(context, publicMsg);
            } else {
                try {
                    intent = Intent.parseUri(publicMsg.mPkgContent, 1);
                    intent.setPackage(context.getPackageName());
                } catch (URISyntaxException e) {
                    Intent b = b(context, publicMsg);
                    new b.c(context).a(Log.getStackTraceString(e)).a();
                    intent = b;
                }
            }
            if (intent != null) {
                PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
                Notification a = d.a(context, 0, 7, publicMsg.mTitle, publicMsg.mDescription, false);
                if (a != null) {
                    a.contentIntent = activity;
                    notificationManager.notify(System.currentTimeMillis() + "", 0, a);
                }
            }
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
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
        m.b(context, intent, "com.baidu.android.pushservice.action.RECEIVE", publicMsg.mPkgName);
    }

    private static Intent b(Context context, PublicMsg publicMsg) {
        Intent intent;
        Exception e;
        try {
            intent = new Intent();
            try {
                intent.setClassName(context.getPackageName(), publicMsg.getLauncherActivityName(context, context.getPackageName()));
                intent.setFlags(268435456);
            } catch (Exception e2) {
                e = e2;
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return intent;
            }
        } catch (Exception e3) {
            intent = null;
            e = e3;
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2, PublicMsg publicMsg, byte[] bArr, byte[] bArr2) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.setAction("com.baidu.android.pushservice.action.privatenotification.CLICK");
        intent.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("app_id", publicMsg.mAppId);
        intent.putExtra("msg_id", publicMsg.mMsgId);
        intent.putExtra("baidu_message_secur_info", bArr);
        intent.putExtra("baidu_message_body", bArr2);
        PendingIntent service = PendingIntent.getService(context, 0, intent, 0);
        Intent intent2 = new Intent();
        intent2.setClassName(str, str2);
        intent2.setAction("com.baidu.android.pushservice.action.privatenotification.DELETE");
        intent2.setData(Uri.parse("content://" + publicMsg.mMsgId));
        intent2.putExtra("public_msg", publicMsg);
        intent2.putExtra("app_id", publicMsg.mAppId);
        intent2.putExtra("msg_id", publicMsg.mMsgId);
        PendingIntent service2 = PendingIntent.getService(context, 0, intent2, 0);
        boolean h = m.h(context, publicMsg.mPkgName);
        Notification a = publicMsg.mNotificationBuilder == 0 ? d.a(context, publicMsg.mNotificationBuilder, publicMsg.mNotificationBasicStyle, publicMsg.mTitle, publicMsg.mDescription, h) : d.a(context, publicMsg.mNotificationBuilder, publicMsg.mTitle, publicMsg.mDescription, h);
        a.contentIntent = service;
        a.deleteIntent = service2;
        notificationManager.notify(publicMsg.mMsgId, 0, a);
        m.a(publicMsg.mMsgId + " notified!", context.getApplicationContext());
        a(context, publicMsg, bArr, bArr2);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        String action = intent.getAction();
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            if ("com.baidu.android.pushservice.action.receiver.ALARM".equals(action)) {
                com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("PushServiceReceiver - keep alive", (short) 99) { // from class: com.baidu.android.pushservice.PushServiceReceiver.1
                    @Override // com.baidu.android.pushservice.g.c
                    public void a() {
                        if (m.p(context) || !l.a(context, null)) {
                            try {
                                g.a(context).a(intent);
                            } catch (Exception e) {
                            }
                        }
                    }
                });
            } else if ("android.intent.action.BOOT_COMPLETED".equals(action) || "android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.USER_PRESENT".equals(action) || "android.intent.action.MEDIA_CHECKING".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                if (g.a(context).e() || !com.baidu.android.pushservice.i.g.a(context)) {
                    return;
                }
                l.b(context);
            } else if (!"com.baidu.android.pushservice.action.notification.SHOW".equals(action)) {
                if ("com.baidu.android.pushservice.action.receiver.CANCEL_ALARM".equals(action)) {
                    g.a(context).d();
                }
            } else if (!com.baidu.android.pushservice.b.d.q(context) || com.baidu.android.pushservice.b.d.c(context)) {
                final String stringExtra = intent.getStringExtra("pushService_package_name");
                final String stringExtra2 = intent.getStringExtra("service_name");
                final String stringExtra3 = intent.getStringExtra("notify_type");
                final String stringExtra4 = intent.getStringExtra("app_id");
                final byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_body");
                final byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_secur_info");
                int intExtra = intent.getIntExtra("baidu_message_type", -1);
                final String stringExtra5 = intent.getStringExtra("message_id");
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || byteArrayExtra == null || byteArrayExtra2 == null || intExtra == -1) {
                    return;
                }
                if (m.j(context, stringExtra5) || !com.baidu.android.pushservice.c.a.a(context, stringExtra5)) {
                    com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("RecordDuplicatedMsg", (short) 99) { // from class: com.baidu.android.pushservice.PushServiceReceiver.2
                        @Override // com.baidu.android.pushservice.g.c
                        public void a() {
                            m.a(stringExtra5 + " is duplicated!", context.getApplicationContext());
                        }
                    });
                } else {
                    com.baidu.android.pushservice.g.d.a().a(new com.baidu.android.pushservice.g.c("showPrivateNotification", (short) 99) { // from class: com.baidu.android.pushservice.PushServiceReceiver.3
                        @Override // com.baidu.android.pushservice.g.c
                        public void a() {
                            PublicMsg a = com.baidu.android.pushservice.message.a.c.a(context, stringExtra4, stringExtra5, byteArrayExtra2, byteArrayExtra);
                            if (a == null) {
                                m.a(stringExtra5 + " check fail!, type=" + stringExtra3, context.getApplicationContext());
                            } else if (com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(stringExtra3)) {
                                PushServiceReceiver.b(context, stringExtra, stringExtra2, a, byteArrayExtra2, byteArrayExtra);
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
        }
    }
}
