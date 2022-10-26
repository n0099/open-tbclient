package com.baidu.android.pushservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URISyntaxException;
/* loaded from: classes.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PushServiceReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Intent a(Context context, String str) {
        InterceptResult invokeLL;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            Intent intent2 = null;
            try {
                intent = new Intent();
            } catch (Exception e) {
                e = e;
            }
            try {
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                return intent;
            } catch (Exception e2) {
                e = e2;
                intent2 = intent;
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return intent2;
            }
        }
        return (Intent) invokeLL.objValue;
    }

    public static void a(Context context, PublicMsg publicMsg) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, publicMsg) == null) {
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
                    Notification a = NotificationBuilderManager.a(context, 0, 7, publicMsg.mTitle, publicMsg.mDescription, false, null);
                    if (a != null) {
                        a.contentIntent = activity;
                        long currentTimeMillis = System.currentTimeMillis();
                        notificationManager.notify(currentTimeMillis + "", 0, a);
                    }
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public static void a(Context context, PublicMsg publicMsg, byte[] bArr, byte[] bArr2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, context, publicMsg, bArr, bArr2, str) == null) {
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
            intent.putExtra("widget_badge_info", str);
            m.b(context, intent, "com.baidu.android.pushservice.action.RECEIVE", publicMsg.mPkgName);
        }
    }

    public static Intent b(Context context, PublicMsg publicMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65541, null, context, publicMsg)) != null) {
            return (Intent) invokeLL.objValue;
        }
        Intent intent = null;
        try {
            Intent intent2 = new Intent();
            try {
                intent2.setClassName(context.getPackageName(), publicMsg.getLauncherActivityName(context, context.getPackageName()));
                intent2.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                return intent2;
            } catch (Exception e) {
                e = e;
                intent = intent2;
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return intent;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static void b(Context context, String str, String str2, PublicMsg publicMsg, byte[] bArr, byte[] bArr2, int i, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, str, str2, publicMsg, bArr, bArr2, Integer.valueOf(i), str3}) == null) {
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
            Bitmap a = !TextUtils.isEmpty(publicMsg.mImgUrl) ? com.baidu.android.pushservice.d.a.a().a(publicMsg.mImgUrl) : null;
            boolean h = m.h(context, publicMsg.mPkgName);
            int i2 = publicMsg.mNotificationBuilder;
            Notification a2 = i2 == 0 ? NotificationBuilderManager.a(context, i2, publicMsg.mNotificationBasicStyle, publicMsg.mTitle, publicMsg.mDescription, h, a) : NotificationBuilderManager.a(context, i2, publicMsg.mTitle, publicMsg.mDescription, h);
            a2.contentIntent = service;
            a2.deleteIntent = service2;
            notificationManager.notify(i, a2);
            String str4 = publicMsg.mMsgId + " notified!";
            a(context, publicMsg, bArr, bArr2, str3);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            String action = intent.getAction();
            try {
                intent.getByteArrayExtra("baidu_message_secur_info");
                if ("com.baidu.android.pushservice.action.receiver.ALARM".equals(action)) {
                    com.baidu.android.pushservice.g.e.a().a(new com.baidu.android.pushservice.g.c(this, "PushServiceReceiver - keep alive", (short) 99, context, intent) { // from class: com.baidu.android.pushservice.PushServiceReceiver.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Context a;
                        public final /* synthetic */ Intent b;
                        public final /* synthetic */ PushServiceReceiver c;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r9, r10);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r9, Short.valueOf(r10), context, intent};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.c = this;
                            this.a = context;
                            this.b = intent;
                        }

                        @Override // com.baidu.android.pushservice.g.c
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                if (m.B(this.a) || !l.a(this.a, (Intent) null, 0)) {
                                    try {
                                        f.a(this.a).a(this.b);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    });
                } else if (!"com.baidu.android.pushservice.action.notification.SHOW".equals(action)) {
                    if ("com.baidu.android.pushservice.action.receiver.CANCEL_ALARM".equals(action)) {
                        f.a(context).c();
                    }
                } else if (!com.baidu.android.pushservice.b.d.r(context) || com.baidu.android.pushservice.b.d.c(context)) {
                    String stringExtra = intent.getStringExtra("pushService_package_name");
                    String stringExtra2 = intent.getStringExtra("service_name");
                    String stringExtra3 = intent.getStringExtra("notify_type");
                    String stringExtra4 = intent.getStringExtra("app_id");
                    int intExtra = intent.getIntExtra("notify_id", 0);
                    String stringExtra5 = intent.getStringExtra("widget_badge_info");
                    byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_body");
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_secur_info");
                    int intExtra2 = intent.getIntExtra("baidu_message_type", -1);
                    String stringExtra6 = intent.getStringExtra("message_id");
                    if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || byteArrayExtra == null || byteArrayExtra2 == null || intExtra2 == -1 || m.j(context, stringExtra6) || !com.baidu.android.pushservice.c.a.a(context, stringExtra6)) {
                        return;
                    }
                    com.baidu.android.pushservice.g.e.a().a(new com.baidu.android.pushservice.g.c(this, "showPrivateNotification", (short) 99, context, stringExtra4, stringExtra6, byteArrayExtra2, byteArrayExtra, stringExtra3, stringExtra, stringExtra2, intExtra, stringExtra5) { // from class: com.baidu.android.pushservice.PushServiceReceiver.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Context a;
                        public final /* synthetic */ String b;
                        public final /* synthetic */ String c;
                        public final /* synthetic */ byte[] d;
                        public final /* synthetic */ byte[] e;
                        public final /* synthetic */ String f;
                        public final /* synthetic */ String g;
                        public final /* synthetic */ String h;
                        public final /* synthetic */ int i;
                        public final /* synthetic */ String j;
                        public final /* synthetic */ PushServiceReceiver k;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r10, r11);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r3;
                                Object[] objArr = {this, r10, Short.valueOf(r11), context, stringExtra4, stringExtra6, byteArrayExtra2, byteArrayExtra, stringExtra3, stringExtra, stringExtra2, Integer.valueOf(intExtra), stringExtra5};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.k = this;
                            this.a = context;
                            this.b = stringExtra4;
                            this.c = stringExtra6;
                            this.d = byteArrayExtra2;
                            this.e = byteArrayExtra;
                            this.f = stringExtra3;
                            this.g = stringExtra;
                            this.h = stringExtra2;
                            this.i = intExtra;
                            this.j = stringExtra5;
                        }

                        @Override // com.baidu.android.pushservice.g.c
                        public void a() {
                            PublicMsg a;
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (a = com.baidu.android.pushservice.message.a.d.a(this.a, this.b, this.c, this.d, this.e)) != null && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(this.f)) {
                                PushServiceReceiver.b(this.a, this.g, this.h, a, this.d, this.e, this.i, this.j);
                            }
                        }
                    });
                }
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
            }
        }
    }
}
