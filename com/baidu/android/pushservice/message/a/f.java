package com.baidu.android.pushservice.message.a;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.j.o;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.ar.util.Constants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Locale;
/* loaded from: classes2.dex */
public class f {
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
        notificationManager.notify(p.b(str), Build.VERSION.SDK_INT >= 16 ? autoCancel.build() : autoCancel.getNotification());
    }

    public static void a(Context context, PublicMsg publicMsg, String str, String str2, int i, byte[] bArr, byte[] bArr2) {
        Intent intent = new Intent();
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("pushService_package_name", context.getPackageName());
        intent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
        intent.putExtra("notify_type", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        intent.putExtra("message_id", str);
        intent.putExtra(Constants.HTTP_APP_ID, str2);
        intent.putExtra("baidu_message_type", i);
        if (p.m(context, publicMsg.mPkgName) > 45) {
            intent.putExtra("baidu_message_body", bArr2);
            intent.putExtra("baidu_message_secur_info", bArr);
        }
        p.b(context, intent, "com.baidu.android.pushservice.action.notification.SHOW", publicMsg.mPkgName);
    }

    public static void a(Context context, String str) {
        try {
            Intent intent = new Intent(com.baidu.android.pushservice.PushConstants.ACTION_METHOD);
            intent.putExtra("method", "com.baidu.android.pushservice.action.UNBINDAPP");
            intent.putExtra(Constants.HTTP_APP_ID, str);
            o.a(context, intent);
        } catch (Exception e) {
        }
    }

    public static void a(Context context, String str, PublicMsg publicMsg, String str2, int i, byte[] bArr, byte[] bArr2) {
        Intent intent = new Intent();
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("notify_type", "rich_media");
        intent.putExtra(Constants.HTTP_APP_ID, str);
        intent.putExtra("message_id", str2);
        intent.putExtra("pushService_package_name", context.getPackageName());
        intent.putExtra("baidu_message_type", i);
        intent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
        if (p.m(context, publicMsg.mPkgName) > 45) {
            intent.putExtra("baidu_message_body", bArr2);
            intent.putExtra("baidu_message_secur_info", bArr);
        }
        p.b(context, intent, "com.baidu.android.pushservice.action.notification.SHOW", publicMsg.mPkgName);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent();
        intent.setData(Uri.parse(str4));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(268435456);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
        com.baidu.android.pushservice.c cVar = new com.baidu.android.pushservice.c(str3);
        cVar.b(16);
        cVar.c(3);
        cVar.a(str);
        cVar.b(str2);
        cVar.a(p.q(context, intent.getPackage()));
        cVar.a(context, activity, str5);
    }

    public static boolean a(Context context, PublicMsg publicMsg) {
        boolean z;
        if (publicMsg.mNetType == 1) {
            NetworkInfo c = com.baidu.android.pushservice.j.k.c(context);
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
