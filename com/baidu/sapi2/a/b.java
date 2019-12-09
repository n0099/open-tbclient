package com.baidu.sapi2.a;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.utils.Log;
import com.coloros.mcssdk.PushManager;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static final String a = "b";
    private static final String b = "pass_channel_id";
    private static final String c = "pass_channel";
    private static final long d = 86400;
    private static final long e = 432000;

    public void a(Context context) {
        List<String> phoneRisksList;
        Log.e(a, "thread id", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()));
        long pushInternalTime = SapiContext.getInstance(context).getPushInternalTime();
        long pushSucTime = SapiContext.getInstance(context).getPushSucTime();
        long lastPushCheckTime = SapiContext.getInstance(context).getLastPushCheckTime();
        if (System.currentTimeMillis() - pushSucTime >= pushInternalTime && System.currentTimeMillis() - lastPushCheckTime >= 86400 && (phoneRisksList = SapiContext.getInstance(context).getPhoneRisksList()) != null && phoneRisksList.contains(SapiAccountManager.getInstance().getConfignation().tpl)) {
            SapiContext.getInstance(context).setLastPushCheckTime(System.currentTimeMillis());
            SapiAccountManager.getInstance().getAccountService().checkPush(new a(this, context));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void a(Context context, String str, String str2, String str3, String str4) {
        Notification.Builder builder;
        if (Build.VERSION.SDK_INT >= 16) {
            ComponentName componentName = new ComponentName(context.getPackageName(), "com.baidu.sapi2.activity.LoadExternalWebViewActivity");
            Intent intent = new Intent();
            intent.putExtra("android.intent.extra.TEXT", str4);
            intent.setComponent(componentName);
            intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, str);
            intent.putExtra("extra_external_url", str4);
            intent.setFlags(268435456);
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI);
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel(b, c, 3));
                builder = new Notification.Builder(context, b);
            } else {
                builder = new Notification.Builder(context);
                builder.setPriority(0);
            }
            builder.setSmallIcon(context.getApplicationInfo().icon);
            builder.setContentIntent(activity);
            builder.setContentTitle(str2);
            builder.setContentText(str3);
            builder.setAutoCancel(true);
            notificationManager.notify(1, builder.build());
        }
    }
}
