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
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URISyntaxException;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class PushServiceReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PushServiceReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            } catch (Exception e2) {
                e = e2;
            }
            try {
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                return intent;
            } catch (Exception e3) {
                e = e3;
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
                    } catch (URISyntaxException e2) {
                        Intent b2 = b(context, publicMsg);
                        new b.c(context).a(Log.getStackTraceString(e2)).a();
                        intent = b2;
                    }
                }
                if (intent != null) {
                    PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
                    Notification a2 = d.a(context, 0, 7, publicMsg.mTitle, publicMsg.mDescription, false);
                    if (a2 != null) {
                        a2.contentIntent = activity;
                        long currentTimeMillis = System.currentTimeMillis();
                        notificationManager.notify(currentTimeMillis + "", 0, a2);
                    }
                }
            } catch (Exception e3) {
                new b.c(context).a(Log.getStackTraceString(e3)).a();
            }
        }
    }

    public static void a(Context context, PublicMsg publicMsg, byte[] bArr, byte[] bArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, context, publicMsg, bArr, bArr2) == null) {
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
    }

    public static Intent b(Context context, PublicMsg publicMsg) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, publicMsg)) != null) {
            return (Intent) invokeLL.objValue;
        }
        Intent intent = null;
        try {
            Intent intent2 = new Intent();
            try {
                intent2.setClassName(context.getPackageName(), publicMsg.getLauncherActivityName(context, context.getPackageName()));
                intent2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                return intent2;
            } catch (Exception e2) {
                e = e2;
                intent = intent2;
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return intent;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static void b(Context context, String str, String str2, PublicMsg publicMsg, byte[] bArr, byte[] bArr2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, str2, publicMsg, bArr, bArr2, Integer.valueOf(i2)}) == null) {
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
            boolean h2 = m.h(context, publicMsg.mPkgName);
            int i3 = publicMsg.mNotificationBuilder;
            Notification a2 = i3 == 0 ? d.a(context, i3, publicMsg.mNotificationBasicStyle, publicMsg.mTitle, publicMsg.mDescription, h2) : d.a(context, i3, publicMsg.mTitle, publicMsg.mDescription, h2);
            a2.contentIntent = service;
            a2.deleteIntent = service2;
            notificationManager.notify(i2, a2);
            m.a(publicMsg.mMsgId + " notified!", context.getApplicationContext());
            a(context, publicMsg, bArr, bArr2);
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
                    com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c(this, "PushServiceReceiver - keep alive", (short) 99, context, intent) { // from class: com.baidu.android.pushservice.PushServiceReceiver.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Context f2715a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Intent f2716b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ PushServiceReceiver f2717c;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(r9, r10);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r9, Short.valueOf(r10), context, intent};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    Object[] objArr2 = newInitContext.callArgs;
                                    super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f2717c = this;
                            this.f2715a = context;
                            this.f2716b = intent;
                        }

                        @Override // com.baidu.android.pushservice.h.c
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                if (m.p(this.f2715a) || !l.a(this.f2715a, null)) {
                                    try {
                                        g.a(this.f2715a).a(this.f2716b);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    });
                } else if ("android.intent.action.BOOT_COMPLETED".equals(action) || "android.net.conn.CONNECTIVITY_CHANGE".equals(action) || "android.intent.action.USER_PRESENT".equals(action) || "android.intent.action.MEDIA_CHECKING".equals(action) || "android.intent.action.ACTION_POWER_CONNECTED".equals(action) || "android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                    if (g.a(context).g() && !g.a(context).e() && com.baidu.android.pushservice.j.g.a(context)) {
                        l.b(context);
                    }
                } else if (!"com.baidu.android.pushservice.action.notification.SHOW".equals(action)) {
                    if ("com.baidu.android.pushservice.action.receiver.CANCEL_ALARM".equals(action)) {
                        g.a(context).d();
                    }
                } else if (!com.baidu.android.pushservice.b.d.q(context) || com.baidu.android.pushservice.b.d.c(context)) {
                    String stringExtra = intent.getStringExtra("pushService_package_name");
                    String stringExtra2 = intent.getStringExtra("service_name");
                    String stringExtra3 = intent.getStringExtra("notify_type");
                    String stringExtra4 = intent.getStringExtra("app_id");
                    int intExtra = intent.getIntExtra("notify_id", 0);
                    byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_body");
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_secur_info");
                    int intExtra2 = intent.getIntExtra("baidu_message_type", -1);
                    String stringExtra5 = intent.getStringExtra("message_id");
                    if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || byteArrayExtra == null || byteArrayExtra2 == null || intExtra2 == -1) {
                        return;
                    }
                    if (m.j(context, stringExtra5) || !com.baidu.android.pushservice.c.a.a(context, stringExtra5)) {
                        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c(this, "RecordDuplicatedMsg", (short) 99, stringExtra5, context) { // from class: com.baidu.android.pushservice.PushServiceReceiver.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ String f2718a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ Context f2719b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ PushServiceReceiver f2720c;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r9, r10);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r9, Short.valueOf(r10), stringExtra5, context};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        Object[] objArr2 = newInitContext.callArgs;
                                        super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f2720c = this;
                                this.f2718a = stringExtra5;
                                this.f2719b = context;
                            }

                            @Override // com.baidu.android.pushservice.h.c
                            public void a() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    m.a(this.f2718a + " is duplicated!", this.f2719b.getApplicationContext());
                                }
                            }
                        });
                    } else {
                        com.baidu.android.pushservice.h.d.a().a(new com.baidu.android.pushservice.h.c(this, "showPrivateNotification", (short) 99, context, stringExtra4, stringExtra5, byteArrayExtra2, byteArrayExtra, stringExtra3, stringExtra, stringExtra2, intExtra) { // from class: com.baidu.android.pushservice.PushServiceReceiver.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Context f2721a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f2722b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ String f2723c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ byte[] f2724d;

                            /* renamed from: e  reason: collision with root package name */
                            public final /* synthetic */ byte[] f2725e;

                            /* renamed from: f  reason: collision with root package name */
                            public final /* synthetic */ String f2726f;

                            /* renamed from: g  reason: collision with root package name */
                            public final /* synthetic */ String f2727g;

                            /* renamed from: h  reason: collision with root package name */
                            public final /* synthetic */ String f2728h;

                            /* renamed from: i  reason: collision with root package name */
                            public final /* synthetic */ int f2729i;
                            public final /* synthetic */ PushServiceReceiver j;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r10, r11);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r3;
                                    Object[] objArr = {this, r10, Short.valueOf(r11), context, stringExtra4, stringExtra5, byteArrayExtra2, byteArrayExtra, stringExtra3, stringExtra, stringExtra2, Integer.valueOf(intExtra)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        Object[] objArr2 = newInitContext.callArgs;
                                        super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.j = this;
                                this.f2721a = context;
                                this.f2722b = stringExtra4;
                                this.f2723c = stringExtra5;
                                this.f2724d = byteArrayExtra2;
                                this.f2725e = byteArrayExtra;
                                this.f2726f = stringExtra3;
                                this.f2727g = stringExtra;
                                this.f2728h = stringExtra2;
                                this.f2729i = intExtra;
                            }

                            @Override // com.baidu.android.pushservice.h.c
                            public void a() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    PublicMsg a2 = com.baidu.android.pushservice.message.a.e.a(this.f2721a, this.f2722b, this.f2723c, this.f2724d, this.f2725e);
                                    if (a2 != null) {
                                        if (com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(this.f2726f)) {
                                            PushServiceReceiver.b(this.f2721a, this.f2727g, this.f2728h, a2, this.f2724d, this.f2725e, this.f2729i);
                                            return;
                                        }
                                        return;
                                    }
                                    m.a(this.f2723c + " check fail!, type=" + this.f2726f, this.f2721a.getApplicationContext());
                                }
                            }
                        });
                    }
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }
}
