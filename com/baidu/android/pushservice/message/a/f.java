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
import android.util.Log;
import android.widget.RemoteViews;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.CrossPushMessage;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Locale;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, CrossPushMessage crossPushMessage, String str, byte[] bArr, byte[] bArr2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{context, crossPushMessage, str, bArr, bArr2, Integer.valueOf(i2)}) == null) {
            com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c("showCrossAppNotification", (short) 99, context, crossPushMessage, str, bArr, bArr2, i2) { // from class: com.baidu.android.pushservice.message.a.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ CrossPushMessage f32816b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f32817c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ byte[] f32818d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ byte[] f32819e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ int f32820f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8, r9);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r8, Short.valueOf(r9), context, crossPushMessage, str, bArr, bArr2, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = context;
                    this.f32816b = crossPushMessage;
                    this.f32817c = str;
                    this.f32818d = bArr;
                    this.f32819e = bArr2;
                    this.f32820f = i2;
                }

                @Override // com.baidu.android.pushservice.h.c
                public void a() {
                    Bitmap q;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Intent parseUri = Intent.parseUri("baidupush://bdpush/cross?from=" + this.a.getPackageName() + "&to=" + this.f32816b.a, 0);
                            parseUri.setPackage(this.f32816b.a);
                            parseUri.addFlags(268435456);
                            parseUri.putExtra("msgid", this.f32816b.mMsgId);
                            parseUri.putExtra("notification_title", this.f32816b.mTitle);
                            parseUri.putExtra("notification_content", this.f32816b.mDescription);
                            parseUri.putExtra("open_type", this.f32816b.mOpenType);
                            parseUri.putExtra("message_pkg_content", this.f32816b.mPkgContent);
                            parseUri.putExtra("extra_extra_custom_content", this.f32816b.mCustomContent);
                            parseUri.putExtra("com.baidu.pushservice.app_id", this.f32817c);
                            parseUri.putExtra("baidu_message_secur_info", this.f32818d);
                            parseUri.putExtra("baidu_message_body", this.f32819e);
                            Notification.Builder autoCancel = new Notification.Builder(this.a).setContentIntent(PendingIntent.getActivity(this.a, (int) (System.currentTimeMillis() / 1000), parseUri, 0)).setAutoCancel(true);
                            if (m.p(this.a)) {
                                com.baidu.android.pushservice.j.h.a(this.a, "com.baidu.android.pushservice.push", "云推送");
                                autoCancel.setChannelId("com.baidu.android.pushservice.push");
                            }
                            String packageName = this.a.getPackageName();
                            autoCancel.setSmallIcon(this.a.getResources().getIdentifier("stat_sys_third_app_notify", "drawable", packageName));
                            RemoteViews remoteViews = new RemoteViews(packageName, this.a.getResources().getIdentifier("push_custom_notification", "layout", packageName));
                            remoteViews.setTextViewText(this.a.getResources().getIdentifier("push_custom_msg_title", "id", packageName), this.f32816b.mTitle);
                            remoteViews.setTextViewText(this.a.getResources().getIdentifier("push_custom_msg_content", "id", packageName), this.f32816b.mDescription);
                            if (!TextUtils.isEmpty(this.f32816b.f32811b) && (q = m.q(this.a, this.f32816b.f32811b)) != null) {
                                remoteViews.setImageViewBitmap(this.a.getResources().getIdentifier("push_custom_msg_icon", "id", packageName), q);
                            }
                            remoteViews.setTextViewText(this.a.getResources().getIdentifier("push_custom_msg_time", "id", packageName), DateUtils.formatDateTime(this.a, System.currentTimeMillis(), 1));
                            autoCancel.setContent(remoteViews);
                            Notification build = Build.VERSION.SDK_INT >= 16 ? autoCancel.build() : autoCancel.getNotification();
                            int i3 = Build.VERSION.SDK_INT;
                            if (i3 >= 24) {
                                autoCancel.setCustomBigContentView(remoteViews);
                            } else if (i3 >= 16) {
                                build.bigContentView = remoteViews;
                            }
                            NotificationManager notificationManager = (NotificationManager) this.a.getSystemService(ActionJsonData.TAG_NOTIFICATION);
                            if (notificationManager != null) {
                                notificationManager.notify(this.f32820f, build);
                            }
                        } catch (Exception e2) {
                            new b.c(this.a).a(Log.getStackTraceString(e2)).a();
                        }
                    }
                }
            });
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, PublicMsg publicMsg, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65537, null, context, publicMsg, str, i2) == null) {
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
            notificationManager.notify(i2, Build.VERSION.SDK_INT >= 16 ? autoCancel.build() : autoCancel.getNotification());
        }
    }

    public static void a(Context context, PublicMsg publicMsg, String str, String str2, int i2, byte[] bArr, byte[] bArr2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, publicMsg, str, str2, Integer.valueOf(i2), bArr, bArr2, Integer.valueOf(i3)}) == null) {
            Intent intent = new Intent();
            intent.putExtra("public_msg", publicMsg);
            intent.putExtra("pushService_package_name", context.getPackageName());
            intent.putExtra("service_name", m.m() ? "com.baidu.pushservice.PushService" : "com.baidu.android.pushservice.PushService");
            intent.putExtra("notify_type", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
            intent.putExtra("message_id", str);
            intent.putExtra("app_id", str2);
            intent.putExtra("notify_id", i3);
            intent.putExtra("baidu_message_type", i2);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, publicMsg)) == null) {
            if (publicMsg.mNetType == 1) {
                NetworkInfo c2 = com.baidu.android.pushservice.j.g.c(context);
                if (!(c2 != null && "wifi".equals(c2.getTypeName().toLowerCase(Locale.getDefault())))) {
                    return false;
                }
            }
            if (TextUtils.isEmpty(publicMsg.mSupportAppname)) {
                return true;
            }
            try {
            } catch (PackageManager.NameNotFoundException e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
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
