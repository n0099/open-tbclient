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
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.j.p;
import com.baidu.android.pushservice.j.q;
import com.baidu.android.pushservice.message.PublicMsg;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
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
        notificationManager.notify(q.b(str), Build.VERSION.SDK_INT >= 16 ? autoCancel.build() : autoCancel.getNotification());
    }

    public static void a(Context context, PublicMsg publicMsg, String str, String str2) {
        if (publicMsg.mUrl != null) {
            b(context, publicMsg, str);
        }
    }

    public static void a(Context context, PublicMsg publicMsg, String str, String str2, int i, byte[] bArr, byte[] bArr2) {
        Intent intent = new Intent();
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("pushService_package_name", context.getPackageName());
        intent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
        intent.putExtra("notify_type", "private");
        intent.putExtra("message_id", str);
        intent.putExtra("app_id", str2);
        intent.putExtra("baidu_message_type", i);
        if (q.l(context, publicMsg.mPkgName) > 45) {
            intent.putExtra("baidu_message_body", bArr2);
            intent.putExtra("baidu_message_secur_info", bArr);
        }
        q.b(context, intent, "com.baidu.android.pushservice.action.notification.SHOW", publicMsg.mPkgName);
    }

    public static void a(Context context, String str) {
        try {
            Intent intent = new Intent(PushConstants.ACTION_METHOD);
            intent.putExtra(PushConstants.EXTRA_METHOD, "com.baidu.android.pushservice.action.UNBINDAPP");
            intent.putExtra("app_id", str);
            p.a(context, intent);
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.a("NotificationHandler", "unbind exception", e);
        }
    }

    public static void a(Context context, String str, PublicMsg publicMsg, String str2, int i, byte[] bArr, byte[] bArr2) {
        Intent intent = new Intent();
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("notify_type", "rich_media");
        intent.putExtra("app_id", str);
        intent.putExtra("message_id", str2);
        intent.putExtra("pushService_package_name", context.getPackageName());
        intent.putExtra("baidu_message_type", i);
        intent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
        if (q.l(context, publicMsg.mPkgName) > 45) {
            intent.putExtra("baidu_message_body", bArr2);
            intent.putExtra("baidu_message_secur_info", bArr);
        }
        com.baidu.android.pushservice.g.a.c("NotificationHandler", "richMedia Intent content： public_msg=" + publicMsg + ", notify_type=rich_media, appid=" + str + ", message_id=" + str2 + ", pushService_package_name=" + context.getPackageName() + ", service_name=com.baidu.android.pushservice.PushServicepMsg.mPkgName=" + publicMsg.mPkgName);
        q.b(context, intent, "com.baidu.android.pushservice.action.notification.SHOW", publicMsg.mPkgName);
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
        cVar.a(q.p(context, intent.getPackage()));
        cVar.a(context, activity, str5);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, PublicMsg publicMsg) {
        boolean z;
        boolean z2;
        if (publicMsg.mNetType == 1) {
            NetworkInfo c = com.baidu.android.pushservice.j.l.c(context);
            if (c != null) {
                com.baidu.android.pushservice.g.a.c("NotificationHandler", "network type : " + c.getTypeName().toLowerCase(Locale.getDefault()));
                if ("wifi".equals(c.getTypeName().toLowerCase(Locale.getDefault()))) {
                    z2 = true;
                    if (!z2) {
                        return false;
                    }
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
        if (TextUtils.isEmpty(publicMsg.mSupportAppname)) {
            com.baidu.android.pushservice.g.a.c("NotificationHandler", ">>> isNeedShowNotification supportapp = null");
            return true;
        }
        try {
        } catch (PackageManager.NameNotFoundException e) {
            com.baidu.android.pushservice.g.a.e("NotificationHandler", e.getMessage());
        }
        if (context.getPackageManager().getPackageInfo(publicMsg.mSupportAppname, 0) != null) {
            com.baidu.android.pushservice.g.a.c("NotificationHandler", ">>> isNeedShowNotification supportapp found \r\n pckname = " + publicMsg.mSupportAppname);
            z = true;
            return (!publicMsg.mIsSupportApp && z) || !(publicMsg.mIsSupportApp || z);
        }
        z = false;
        if (publicMsg.mIsSupportApp) {
        }
        return false;
    }

    private static void b(Context context, PublicMsg publicMsg, String str) {
        Intent intent = new Intent();
        intent.setData(Uri.parse(publicMsg.mUrl));
        if (q.n(context, "com.baidu.searchbox")) {
            intent.setAction("com.baidu.searchbox.action.VIEW");
            intent.setClassName("com.baidu.searchbox", "com.baidu.searchbox.MainActivity");
            intent.setAction("com.baidu.searchbox.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
            intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
        } else if (q.n(context, "com.baidu.browser.apps")) {
            intent.setAction("android.intent.action.VIEW");
            intent.setClassName("com.baidu.browser.apps", "com.baidu.browser.framework.BdBrowserActivity");
        } else {
            intent.setAction("android.intent.action.VIEW");
            intent.addFlags(268435456);
        }
        String str2 = "";
        if (publicMsg.mCustomContent != null) {
            try {
                str2 = new JSONObject(publicMsg.mCustomContent).getString("iconUrl");
            } catch (JSONException e) {
                com.baidu.android.pushservice.g.a.a("NotificationHandler", e);
            }
        }
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
        com.baidu.android.pushservice.c cVar = new com.baidu.android.pushservice.c(str2);
        cVar.b(16);
        cVar.c(3);
        cVar.a(publicMsg.mTitle);
        cVar.a(context.getApplicationInfo().icon);
        cVar.b(publicMsg.mDescription);
        cVar.a(q.p(context, intent.getPackage()));
        cVar.a(context, activity, str);
    }
}
