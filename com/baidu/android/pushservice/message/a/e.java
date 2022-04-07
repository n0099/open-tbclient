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
import android.util.Log;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Locale;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"NewApi"})
    public static void a(Context context, PublicMsg publicMsg, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65536, null, context, publicMsg, str, i) == null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
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
            notificationManager.notify(i, Build.VERSION.SDK_INT >= 16 ? autoCancel.build() : autoCancel.getNotification());
        }
    }

    public static void a(Context context, PublicMsg publicMsg, String str, String str2, int i, byte[] bArr, byte[] bArr2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, publicMsg, str, str2, Integer.valueOf(i), bArr, bArr2, Integer.valueOf(i2), str3}) == null) {
            Intent intent = new Intent();
            intent.putExtra("public_msg", publicMsg);
            intent.putExtra("pushService_package_name", context.getPackageName());
            intent.putExtra("service_name", m.m() ? "com.baidu.pushservice.PushService" : "com.baidu.android.pushservice.PushService");
            intent.putExtra("notify_type", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
            intent.putExtra("message_id", str);
            intent.putExtra("app_id", str2);
            intent.putExtra("notify_id", i2);
            intent.putExtra("widget_badge_info", str3);
            intent.putExtra("baidu_message_type", i);
            if (m.g(context, publicMsg.mPkgName) > 45) {
                intent.putExtra("baidu_message_body", bArr2);
                intent.putExtra("baidu_message_secur_info", bArr);
            }
            m.b(context, intent, "com.baidu.android.pushservice.action.notification.SHOW", publicMsg.mPkgName);
        }
    }

    public static boolean a(Context context, PublicMsg publicMsg) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, publicMsg)) == null) {
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
            } catch (PackageManager.NameNotFoundException e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
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
        return invokeLL.booleanValue;
    }
}
