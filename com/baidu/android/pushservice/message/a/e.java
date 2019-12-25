package com.baidu.android.pushservice.message.a;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.widget.RemoteViews;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.message.CrossPushMessage;
import com.baidu.android.pushservice.message.PublicMsg;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes5.dex */
public class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, final CrossPushMessage crossPushMessage, final String str, final byte[] bArr, final byte[] bArr2) {
        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("showCrossAppNotification", (short) 99) { // from class: com.baidu.android.pushservice.message.a.e.1
            @Override // com.baidu.android.pushservice.h.c
            public void a() {
                Bitmap c;
                try {
                    Intent parseUri = Intent.parseUri("baidupush://bdpush/cross?from=" + context.getPackageName() + "&to=" + crossPushMessage.a, 0);
                    parseUri.setPackage(crossPushMessage.a);
                    parseUri.addFlags(268435456);
                    parseUri.putExtra("msgid", crossPushMessage.mMsgId);
                    parseUri.putExtra("notification_title", crossPushMessage.mTitle);
                    parseUri.putExtra("notification_content", crossPushMessage.mDescription);
                    parseUri.putExtra("open_type", crossPushMessage.mOpenType);
                    parseUri.putExtra("message_pkg_content", crossPushMessage.mPkgContent);
                    parseUri.putExtra("extra_extra_custom_content", crossPushMessage.mCustomContent);
                    parseUri.putExtra("com.baidu.pushservice.app_id", str);
                    parseUri.putExtra("baidu_message_secur_info", bArr);
                    parseUri.putExtra("baidu_message_body", bArr2);
                    Notification.Builder autoCancel = new Notification.Builder(context).setContentIntent(PendingIntent.getActivity(context, (int) (System.currentTimeMillis() / 1000), parseUri, 0)).setAutoCancel(true);
                    if (l.E(context)) {
                        com.baidu.android.pushservice.i.h.a(context, "com.baidu.android.pushservice.push", "Push");
                        autoCancel.setChannelId("com.baidu.android.pushservice.push");
                    }
                    String packageName = context.getPackageName();
                    autoCancel.setSmallIcon(context.getResources().getIdentifier("stat_sys_third_app_notify", "drawable", packageName));
                    RemoteViews remoteViews = new RemoteViews(packageName, context.getResources().getIdentifier("push_custom_notification", "layout", packageName));
                    remoteViews.setTextViewText(context.getResources().getIdentifier("push_custom_msg_title", "id", packageName), crossPushMessage.mTitle);
                    remoteViews.setTextViewText(context.getResources().getIdentifier("push_custom_msg_content", "id", packageName), crossPushMessage.mDescription);
                    if (!TextUtils.isEmpty(crossPushMessage.b) && (c = l.c(crossPushMessage.b)) != null) {
                        remoteViews.setImageViewBitmap(context.getResources().getIdentifier("push_custom_msg_icon", "id", packageName), c);
                    }
                    remoteViews.setTextViewText(context.getResources().getIdentifier("push_custom_msg_time", "id", packageName), DateUtils.formatDateTime(context, System.currentTimeMillis(), 1));
                    autoCancel.setContent(remoteViews);
                    Notification build = Build.VERSION.SDK_INT >= 16 ? autoCancel.build() : autoCancel.getNotification();
                    if (Build.VERSION.SDK_INT >= 24) {
                        autoCancel.setCustomBigContentView(remoteViews);
                    } else if (Build.VERSION.SDK_INT >= 16) {
                        build.bigContentView = remoteViews;
                    }
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (notificationManager != null) {
                        notificationManager.notify(crossPushMessage.mMsgId, 0, build);
                    }
                } catch (Exception e) {
                }
            }
        });
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, PublicMsg publicMsg, String str) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Intent intent = new Intent(context, PushService.class);
        intent.setAction("com.baidu.pushservice.action.publicmsg.CLICK_V2");
        intent.setData(Uri.parse("content://" + str));
        intent.putExtra("public_msg", publicMsg);
        Intent intent2 = new Intent(context, PushService.class);
        intent2.setAction("com.baidu.pushservice.action.publicmsg.DELETE_V2");
        intent2.setData(Uri.parse("content://" + str));
        intent2.putExtra("public_msg", publicMsg);
        intent.setClass(context, PushService.class);
        intent2.setClass(context, PushService.class);
        Notification.Builder autoCancel = new Notification.Builder(context).setContentTitle(publicMsg.mTitle).setContentText(publicMsg.mDescription).setSmallIcon(17301569).setTicker(publicMsg.mTitle).setSound(RingtoneManager.getDefaultUri(2)).setDeleteIntent(PendingIntent.getService(context, 0, intent2, 0)).setContentIntent(PendingIntent.getService(context, 0, intent, 0)).setAutoCancel(true);
        notificationManager.notify(l.a(str), Build.VERSION.SDK_INT >= 16 ? autoCancel.build() : autoCancel.getNotification());
    }

    public static void a(Context context, PublicMsg publicMsg, String str, String str2, int i, byte[] bArr, byte[] bArr2) {
        Intent intent = new Intent();
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("pushService_package_name", context.getPackageName());
        intent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
        intent.putExtra("notify_type", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        intent.putExtra("message_id", str);
        intent.putExtra(Constants.APP_ID, str2);
        intent.putExtra("baidu_message_type", i);
        if (l.m(context, publicMsg.mPkgName) > 45) {
            intent.putExtra("baidu_message_body", bArr2);
            intent.putExtra("baidu_message_secur_info", bArr);
        }
        l.b(context, intent, "com.baidu.android.pushservice.action.notification.SHOW", publicMsg.mPkgName);
    }

    public static void a(Context context, String str) {
        try {
            Intent intent = new Intent(com.baidu.android.pushservice.PushConstants.ACTION_METHOD);
            intent.putExtra("method", "com.baidu.android.pushservice.action.UNBINDAPP");
            intent.putExtra(Constants.APP_ID, str);
            com.baidu.android.pushservice.i.k.a(context, intent);
        } catch (Exception e) {
        }
    }

    public static boolean a(Context context, PublicMsg publicMsg) {
        boolean z;
        if (publicMsg.mNetType == 1) {
            NetworkInfo c = com.baidu.android.pushservice.i.g.c(context);
            if (!(c != null && "wifi".equals(c.getTypeName().toLowerCase(Locale.getDefault())))) {
                return false;
            }
        }
        if (TextUtils.isEmpty(publicMsg.mSupportAppname)) {
            return true;
        }
        try {
            z = context.getPackageManager().getPackageInfo(publicMsg.mSupportAppname, 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            z = false;
        }
        return (publicMsg.mIsSupportApp && z) || !(publicMsg.mIsSupportApp || z);
    }
}
