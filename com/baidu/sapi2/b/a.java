package com.baidu.sapi2.b;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.utils.Log;
import com.coloros.mcssdk.PushManager;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final String a = a.class.getSimpleName();
    private static final String b = "pass_channel_id";
    private static final String c = "pass_channel";
    private static final long d = 86400;
    private static final long e = 432000;

    public void a(final Context context) {
        List<String> phoneRisksList;
        Log.e(a, "thread id", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()));
        long pushInternalTime = SapiContext.getInstance(context).getPushInternalTime();
        long pushSucTime = SapiContext.getInstance(context).getPushSucTime();
        long lastPushCheckTime = SapiContext.getInstance(context).getLastPushCheckTime();
        if (System.currentTimeMillis() - pushSucTime >= pushInternalTime && System.currentTimeMillis() - lastPushCheckTime >= 86400 && (phoneRisksList = SapiContext.getInstance(context).getPhoneRisksList()) != null && phoneRisksList.contains(SapiAccountManager.getInstance().getConfignation().tpl)) {
            SapiContext.getInstance(context).setLastPushCheckTime(System.currentTimeMillis());
            SapiAccountManager.getInstance().getAccountService().checkPush(new com.baidu.sapi2.callback.a.a() { // from class: com.baidu.sapi2.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: a */
                public void onSuccess(com.baidu.sapi2.result.a.a aVar) {
                    Log.e(a.a, "thread id", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()));
                    if (aVar.a && !TextUtils.isEmpty(aVar.d) && !TextUtils.isEmpty(aVar.c) && !TextUtils.isEmpty(aVar.b)) {
                        a.this.a(context, aVar.c, aVar.c, aVar.d, aVar.b);
                        SapiContext.getInstance(context).setPushInternalTime(aVar.e == 0 ? a.e : aVar.e);
                        SapiContext.getInstance(context).setPushSucTime(System.currentTimeMillis());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: b */
                public void onFailure(com.baidu.sapi2.result.a.a aVar) {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }
            });
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
            intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_URL, str4);
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
