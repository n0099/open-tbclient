package com.baidu.android.pushservice.w.m;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.NotificationBuilderManager;
import com.baidu.android.pushservice.PushNotifyDispatchActivity;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Locale;
/* loaded from: classes.dex */
public class f {
    public static int a(int i) {
        return (i & 48) >> 4;
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, PublicMsg publicMsg, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Intent intent = new Intent(context, PushService.class);
        intent.setAction("com.baidu.pushservice.action.publicmsg.CLICK_V2");
        intent.setData(Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + str));
        intent.putExtra("public_msg", publicMsg);
        Intent intent2 = new Intent(context, PushService.class);
        intent2.setAction("com.baidu.pushservice.action.publicmsg.DELETE_V2");
        intent2.setData(Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + str));
        intent2.putExtra("public_msg", publicMsg);
        intent.setClass(context, PushNotifyDispatchActivity.class);
        intent2.setClass(context, PushService.class);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, Utility.a(0));
        PendingIntent service = PendingIntent.getService(context, 0, intent2, Utility.a(0));
        Bitmap a = !TextUtils.isEmpty(publicMsg.mImgUrl) ? com.baidu.android.pushservice.q.a.a().a(publicMsg.mImgUrl) : null;
        boolean o = Utility.o(context, publicMsg.mPkgName);
        int i2 = publicMsg.mNotificationBuilder;
        Notification a2 = i2 == 0 ? NotificationBuilderManager.a(context, i2, publicMsg.mNotificationBasicStyle, publicMsg.mTitle, publicMsg.mDescription, o, a, publicMsg.mGroup, "") : NotificationBuilderManager.a(context, i2, publicMsg.mTitle, publicMsg.mDescription, o, publicMsg.mBuilderRes, publicMsg.mImgUrl, publicMsg.mSummary, publicMsg.mGroup);
        a2.contentIntent = activity;
        a2.deleteIntent = service;
        notificationManager.notify(i, a2);
        NotificationBuilderManager.a(context, publicMsg, a2);
    }

    public static void a(Context context, PublicMsg publicMsg, String str, String str2, int i, byte[] bArr, byte[] bArr2, int i2, com.baidu.android.pushservice.w.k kVar) {
        Intent intent = new Intent();
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("pushService_package_name", context.getPackageName());
        intent.putExtra("service_name", Utility.U(context) ? "com.baidu.pushservice.PushService" : "com.baidu.android.pushservice.PushService");
        intent.putExtra("notify_type", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        intent.putExtra(ForbidActivityConfig.CHAT_MSG_ID, str);
        intent.putExtra("app_id", str2);
        intent.putExtra(Constants.EXTRA_NOTIFY_ID, i2);
        intent.putExtra("baidu_message_type", i);
        if (Utility.g(context, publicMsg.mPkgName) > 45) {
            intent.putExtra("baidu_message_body", bArr2);
            intent.putExtra("baidu_message_secur_info", bArr);
        }
        if (kVar != null) {
            intent.putExtra("widget_badge_info", kVar.r());
            intent.putExtra("extra_push_show_switch", kVar.m());
            intent.putExtra("extra_push_show_params", kVar.l());
            intent.putExtra("extra_float_window_duration", kVar.s());
            intent.putExtra("notification_log_ext", kVar.f());
        }
        Utility.c(context, intent, "com.baidu.android.pushservice.action.notification.SHOW", publicMsg.mPkgName);
    }

    public static boolean a(Context context, PublicMsg publicMsg) {
        boolean z;
        if (publicMsg.mNetType == 1) {
            NetworkInfo b = com.baidu.android.pushservice.a0.g.b(context);
            if (!(b != null && "wifi".equals(b.getTypeName().toLowerCase(Locale.getDefault())))) {
                return false;
            }
        }
        if (TextUtils.isEmpty(publicMsg.mSupportAppname)) {
            return true;
        }
        if (context.getPackageManager().getPackageInfo(publicMsg.mSupportAppname, 0) != null) {
            z = true;
            return (!publicMsg.mIsSupportApp && z) || !(publicMsg.mIsSupportApp || z);
        }
        z = false;
        if (publicMsg.mIsSupportApp) {
        }
        return false;
    }

    public static boolean b(int i) {
        return i != -1 && (i & 1073741824) > 0;
    }
}
