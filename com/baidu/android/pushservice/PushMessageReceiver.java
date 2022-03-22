package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.a.k;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PushMessageReceiver";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final WeakReference<Context> f24145d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24145d = new WeakReference<>(context);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f24146b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f24147c;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ b[] f24148e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public int f24149d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-24606557, "Lcom/baidu/android/pushservice/PushMessageReceiver$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-24606557, "Lcom/baidu/android/pushservice/PushMessageReceiver$b;");
                    return;
                }
            }
            a = new b("MSG_PASS", 0, 1);
            f24146b = new b("MSG_ARRIVED", 1, 2);
            b bVar = new b("MSG_CLICKED", 2, 3);
            f24147c = bVar;
            f24148e = new b[]{a, f24146b, bVar};
        }

        public b(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f24149d = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f24149d : invokeV.intValue;
        }
    }

    public PushMessageReceiver() {
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

    private void handleHuaweiMessage(Context context, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, this, context, intent, str) == null) && com.baidu.android.pushservice.b.d.l(context)) {
            try {
                if (intent.getBooleanExtra("IS_HMS_PASS_MSG_KEY", false)) {
                    handleHuaweiMessageCallBack(context, intent.getStringExtra("HMS_PASS_MSG_VALUE_KEY"), null);
                } else {
                    handleHuaweiMessageCallBack(context, new String(intent.getByteArrayExtra("msg_data"), IMAudioTransRequest.CHARSET), new String(intent.getByteArrayExtra("device_token"), IMAudioTransRequest.CHARSET));
                }
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    private void handleHuaweiMessageCallBack(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, context, str, str2) == null) {
            com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
            String a2 = iVar.a(context, str);
            if (a2 == null) {
                try {
                    a2 = iVar.a(context, new JSONObject(str).getJSONObject("msgContent").getString("data"));
                } catch (JSONException unused) {
                }
            }
            if (m.i(context) && !m.l(context, iVar.j)) {
                String str3 = iVar.m;
                if (e.a(context, str3, iVar.j + a2)) {
                    if (iVar.k == k.k.b()) {
                        m.k(context);
                    } else if (iVar.k == k.f24766g.b() || iVar.k == k.f24761b.b()) {
                        onMessage(context, a2, null, 0);
                    }
                }
            }
        }
    }

    private void handleMeizuMessageCallBack(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, intent) == null) {
            com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
            int intExtra = intent.getIntExtra("mz_push_msg_type", 0);
            String c2 = iVar.c(context, intent.getStringExtra("mz_notification_self_define_content"));
            if (m.l(context, iVar.j)) {
                return;
            }
            String str = iVar.m;
            if (e.a(context, str, (iVar.j + c2).replaceAll("\\\\", "")) && intExtra == b.f24147c.a()) {
                onNotificationClicked(context, intent.getStringExtra("mz_notification_title"), intent.getStringExtra("mz_notification_content"), c2);
                new b.a(context).a("3").b(iVar.j).a(System.currentTimeMillis()).b(601010L).a();
            }
        }
    }

    private void handleOppoMessageCallBack(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, context, intent) == null) {
            String stringExtra = intent.getStringExtra("op_notification_sign");
            String stringExtra2 = intent.getStringExtra("op_notification_msg_id");
            String stringExtra3 = intent.getStringExtra("op_notification_pkg_content");
            String stringExtra4 = intent.getStringExtra("extra_extra_custom_content");
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || m.l(context, stringExtra2)) {
                return;
            }
            if (e.a(context, stringExtra, stringExtra2 + stringExtra4)) {
                if (TextUtils.isEmpty(stringExtra3)) {
                    try {
                        onNotificationClicked(context, null, null, new JSONObject("{\"extras\":" + stringExtra4 + "}").getString("extras"));
                        new b.a(context).a("4").b(stringExtra2).a(System.currentTimeMillis()).b(601010L).a();
                        return;
                    } catch (Exception e2) {
                        new b.c(context).a(Log.getStackTraceString(e2)).a();
                        return;
                    }
                }
                try {
                    Intent parseUri = Intent.parseUri(stringExtra3, 0);
                    parseUri.setPackage(context.getPackageName());
                    parseUri.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    if (!TextUtils.isEmpty(stringExtra4)) {
                        JSONObject jSONObject = new JSONObject(stringExtra4);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            parseUri.putExtra(next, jSONObject.optString(next));
                        }
                    }
                    if (context.getPackageManager().queryIntentActivities(parseUri, 0).size() > 0) {
                        context.startActivity(parseUri);
                    }
                } catch (Exception e3) {
                    new b.c(context).a(Log.getStackTraceString(e3)).a();
                }
            }
        }
    }

    private void handleVivoMessageCallBack(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, this, context, intent) == null) {
            String stringExtra = intent.getStringExtra("vi_notification_title");
            String stringExtra2 = intent.getStringExtra("vi_notification_content");
            String stringExtra3 = intent.getStringExtra("vi_notification_sign");
            String stringExtra4 = intent.getStringExtra("vi_notification_msg_id");
            String stringExtra5 = intent.getStringExtra("vi_notification_pkg_content");
            String stringExtra6 = intent.getStringExtra("extra_extra_custom_content");
            if (TextUtils.isEmpty(stringExtra3) || TextUtils.isEmpty(stringExtra4) || m.l(context, stringExtra4)) {
                return;
            }
            if (e.a(context, stringExtra3, stringExtra4 + stringExtra6)) {
                if (TextUtils.isEmpty(stringExtra5)) {
                    try {
                        onNotificationClicked(context, stringExtra, stringExtra2, stringExtra6);
                        new b.a(context).a("5").b(stringExtra4).a(System.currentTimeMillis()).b(601010L).a();
                        return;
                    } catch (Exception e2) {
                        new b.c(context).a(Log.getStackTraceString(e2)).a();
                        return;
                    }
                }
                try {
                    Intent parseUri = Intent.parseUri(stringExtra5, 0);
                    parseUri.setPackage(context.getPackageName());
                    parseUri.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    if (!TextUtils.isEmpty(stringExtra6)) {
                        JSONObject jSONObject = new JSONObject(stringExtra6);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            parseUri.putExtra(next, jSONObject.optString(next));
                        }
                    }
                    if (context.getPackageManager().queryIntentActivities(parseUri, 0).size() > 0) {
                        context.startActivity(parseUri);
                    }
                } catch (Exception e3) {
                    new b.c(context).a(Log.getStackTraceString(e3)).a();
                }
            }
        }
    }

    private void handleXiaomiMessageCallBack(Context context, MiPushMessage miPushMessage, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65543, this, context, miPushMessage, i) == null) {
            try {
                String content = miPushMessage.getContent();
                com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
                boolean msgFromXMConsole = msgFromXMConsole(context, content);
                if (msgFromXMConsole) {
                    iVar.k = k.f24761b.b();
                } else {
                    content = iVar.b(context, content);
                }
                if (i == b.f24147c.a() || !m.l(context, iVar.j)) {
                    if (iVar.k == k.k.b()) {
                        m.k(context);
                    } else if (iVar.k == k.f24766g.b() || iVar.k == k.f24762c.b() || iVar.k == k.f24761b.b() || iVar.k == k.f24765f.b() || iVar.k == k.f24763d.b() || iVar.k == k.f24764e.b()) {
                        if (i == b.a.a()) {
                            onMessage(context, content, null, 0);
                        } else if (i == b.f24146b.a()) {
                            onNotificationArrived(context, miPushMessage.getTitle(), miPushMessage.getDescription(), content);
                        } else if (i == b.f24147c.a()) {
                            onNotificationClicked(context, miPushMessage.getTitle(), miPushMessage.getDescription(), content);
                        }
                    }
                }
                if (msgFromXMConsole || i != b.f24147c.a()) {
                    return;
                }
                new b.a(context).a("2").b(iVar.j).a(System.currentTimeMillis()).b(601010L).a();
            } catch (Throwable th) {
                new b.c(context).a(Log.getStackTraceString(th)).a();
            }
        }
    }

    public static boolean msgFromXMConsole(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            try {
                new JSONObject(str);
                return false;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void sendCallback(Context context, Intent intent, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, intent, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            int intExtra = intent.getIntExtra("baidu_message_type", -1);
            intent.getAction();
            if (intExtra == k.i.b()) {
                if (z) {
                    m.a(context, intent.getStringExtra("message_id"), i);
                }
            } else if (!intent.getBooleanExtra("bdpush_deliver_NO_CALLBACK", false) && TextUtils.equals(context.getPackageName(), intent.getStringExtra("bd.cross.request.SOURCE_PACKAGE"))) {
                intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.MESSAGE_ACK");
                intent.putExtra("bd.cross.request.RESULT_CODE", i);
                com.baidu.android.pushservice.i.b.a(intent);
            }
        }
    }

    private void widgetInfoCallBack(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, context, intent) == null) {
            String stringExtra = intent.getStringExtra("widget_badge_info");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                onWidgetBadgeUpdate(context, jSONObject.getInt("widget_badge_num"), jSONObject.getInt("widget_badge_type"));
            } catch (Exception unused) {
            }
        }
    }

    public abstract void onBind(Context context, int i, String str, String str2, String str3, String str4);

    public abstract void onDelTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onListTags(Context context, int i, List<String> list, String str);

    public abstract void onMessage(Context context, String str, String str2, int i);

    public abstract void onNotificationArrived(Context context, String str, String str2, String str3);

    public abstract void onNotificationClicked(Context context, String str, String str2, String str3);

    public void onNotificationMessageClicked(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, context, str, str2, str3) == null) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String stringExtra;
        b.c cVar;
        com.baidu.android.pushservice.message.i a2;
        PublicMsg a3;
        b.a b2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        String str;
        String str2;
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, context, intent) == null) || context == null || intent == null) {
            return;
        }
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            String action = intent.getAction();
            int i = 0;
            if (!TextUtils.equals(action, "com.baidu.android.pushservice.action.MESSAGE")) {
                if (TextUtils.equals(action, "com.baidu.android.pushservice.action.RECEIVE")) {
                    String stringExtra2 = intent.getStringExtra("method");
                    if (TextUtils.isEmpty(stringExtra2)) {
                        return;
                    }
                    int intExtra = intent.getIntExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, 0);
                    String str3 = intent.getByteArrayExtra("content") != null ? new String(intent.getByteArrayExtra("content")) : "";
                    if (stringExtra2.equals("com.baidu.android.pushservice.action.notification.ARRIVED")) {
                        String stringExtra3 = intent.getStringExtra("msgid");
                        String stringExtra4 = intent.getStringExtra("notification_title");
                        String stringExtra5 = intent.getStringExtra("notification_content");
                        String stringExtra6 = intent.getStringExtra("extra_extra_custom_content");
                        if (m.a(context, intent.getByteArrayExtra("baidu_message_secur_info"), stringExtra3, intent.getByteArrayExtra("baidu_message_body"))) {
                            onNotificationArrived(context, stringExtra4, stringExtra5, stringExtra6);
                        }
                    } else if (stringExtra2.equals("method_bind")) {
                        if (intExtra != 0 || TextUtils.isEmpty(str3)) {
                            onBind(context, intExtra, null, null, null, null);
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            String string = jSONObject.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                            JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                            String string2 = jSONObject2.getString("appid");
                            PushSettings.b(context, string2);
                            String string3 = jSONObject2.getString("channel_id");
                            String optString = jSONObject2.optString("new_channel_id");
                            String string4 = jSONObject2.getString("user_id");
                            if (intent.hasExtra("real_bind")) {
                                long currentTimeMillis = System.currentTimeMillis();
                                String stringExtra7 = intent.getStringExtra("access_token");
                                str2 = intent.getStringExtra("secret_key");
                                j = currentTimeMillis;
                                str = stringExtra7;
                            } else {
                                str = null;
                                str2 = null;
                                j = 0;
                            }
                            com.baidu.android.pushservice.i.i.a(context, string2, string3, optString, string, string4, j, str, str2);
                            onBind(context, intExtra, string2, string4, TextUtils.isEmpty(optString) ? string3 : optString, string);
                            com.baidu.android.pushservice.c.c.c(context, m.c(context.getPackageName() + "," + string2 + "," + string4 + ",false," + ((int) com.baidu.android.pushservice.a.a())));
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            onBind(context, intExtra, null, null, null, null);
                            cVar = new b.c(context);
                        }
                    } else if (stringExtra2.equals("method_unbind")) {
                        try {
                            onUnbind(context, intExtra, new JSONObject(str3).getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID));
                        } catch (JSONException e3) {
                            onUnbind(context, intExtra, null);
                            new b.c(context).a(Log.getStackTraceString(e3)).a();
                        }
                        m.a(context, false);
                        if (com.baidu.android.pushservice.b.d.k(context)) {
                            MiPushClient.unregisterPush(context);
                        }
                        if (com.baidu.android.pushservice.b.d.j(context)) {
                            String a4 = com.baidu.android.pushservice.i.i.a(context, "BD_MEIZU_PROXY_APPID_KEY");
                            String a5 = com.baidu.android.pushservice.i.i.a(context, "BD_MEIZU_PROXY_APPKEY_KEY");
                            if (TextUtils.isEmpty(a4) || TextUtils.isEmpty(a5)) {
                                return;
                            }
                            com.meizu.cloud.pushsdk.PushManager.unRegister(context, a4, a5);
                            return;
                        }
                        return;
                    } else if (stringExtra2.equals("method_set_tags")) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(str3);
                            String string5 = jSONObject3.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                            if (!TextUtils.isEmpty(jSONObject3.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG))) {
                                onSetTags(context, intExtra, new ArrayList(), new ArrayList(), string5);
                                return;
                            }
                            JSONObject optJSONObject = jSONObject3.optJSONObject("response_params");
                            if (optJSONObject == null || (jSONArray = optJSONObject.getJSONArray("details")) == null) {
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            while (i < jSONArray.length()) {
                                JSONObject jSONObject4 = jSONArray.getJSONObject(i);
                                String string6 = jSONObject4.getString("tag");
                                if (jSONObject4.getInt("result") == 0) {
                                    arrayList.add(string6);
                                } else {
                                    arrayList2.add(string6);
                                }
                                i++;
                            }
                            onSetTags(context, intExtra, arrayList, arrayList2, string5);
                            return;
                        } catch (JSONException e4) {
                            e = e4;
                            onSetTags(context, intExtra, null, null, null);
                            cVar = new b.c(context);
                        }
                    } else if (stringExtra2.equals("method_del_tags")) {
                        try {
                            JSONObject jSONObject5 = new JSONObject(str3);
                            String string7 = jSONObject5.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                            JSONObject jSONObject6 = jSONObject5.getJSONObject("response_params");
                            if (jSONObject6 == null || (jSONArray2 = jSONObject6.getJSONArray("details")) == null) {
                                return;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            ArrayList arrayList4 = new ArrayList();
                            while (i < jSONArray2.length()) {
                                JSONObject jSONObject7 = jSONArray2.getJSONObject(i);
                                String string8 = jSONObject7.getString("tag");
                                if (jSONObject7.getInt("result") == 0) {
                                    arrayList3.add(string8);
                                } else {
                                    arrayList4.add(string8);
                                }
                                i++;
                            }
                            onDelTags(context, intExtra, arrayList3, arrayList4, string7);
                            return;
                        } catch (JSONException e5) {
                            e = e5;
                            onDelTags(context, intExtra, null, null, null);
                            cVar = new b.c(context);
                        }
                    } else if (!stringExtra2.equals("method_listtags")) {
                        return;
                    } else {
                        try {
                            onListTags(context, intExtra, intent.getStringArrayListExtra("tags_list"), new JSONObject(str3).getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID));
                            return;
                        } catch (JSONException e6) {
                            e = e6;
                            onListTags(context, intExtra, null, null);
                            cVar = new b.c(context);
                        }
                    }
                } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.notification.CLICK")) {
                    String stringExtra8 = intent.getStringExtra("msgid");
                    String stringExtra9 = intent.getStringExtra("notification_title");
                    String stringExtra10 = intent.getStringExtra("notification_content");
                    String stringExtra11 = intent.getStringExtra("extra_extra_custom_content");
                    String stringExtra12 = intent.getStringExtra("com.baidu.pushservice.app_id");
                    int intExtra2 = intent.getIntExtra("proxy_mode", 0);
                    byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_secur_info");
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_body");
                    if (intExtra2 == 5) {
                        if (!e.a(context.getApplicationContext(), intent.getStringExtra("proxy_sign_info"), intent.getStringExtra("proxy_check_info"))) {
                            return;
                        }
                        onNotificationClicked(context, stringExtra9, stringExtra10, stringExtra11);
                        b2 = new b.a(context).a("1").b(stringExtra8).a(System.currentTimeMillis()).b(601010L);
                    } else if (!m.a(context, stringExtra8, stringExtra12, stringExtra9, stringExtra10, stringExtra11) && !m.a(context, byteArrayExtra, stringExtra8, byteArrayExtra2)) {
                        return;
                    } else {
                        onNotificationClicked(context, stringExtra9, stringExtra10, stringExtra11);
                        b2 = new b.a(context).a("0").b(stringExtra8).a(System.currentTimeMillis()).b(601010L);
                    }
                    b2.a();
                    return;
                } else if (TextUtils.equals(action, "com.huawei.android.push.intent.REGISTRATION")) {
                    if (!com.baidu.android.pushservice.b.d.l(context) || !PushSettings.l(context)) {
                        return;
                    }
                    try {
                        String str4 = new String(intent.getByteArrayExtra("device_token"), "UTF-8");
                        if (TextUtils.isEmpty(str4)) {
                            return;
                        }
                        e.a(context, str4);
                        return;
                    } catch (Exception e7) {
                        e = e7;
                        cVar = new b.c(context);
                    }
                } else if (!TextUtils.equals(action, "com.huawei.intent.action.PUSH")) {
                    if (TextUtils.equals(action, "com.huawei.android.push.intent.RECEIVE")) {
                        handleHuaweiMessage(context, intent, action);
                        return;
                    }
                    if (TextUtils.equals(action, "com.xiaomi.mipush.REGISTER")) {
                        if (!com.baidu.android.pushservice.b.d.k(context) || !intent.hasExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE)) {
                            return;
                        }
                        if (intent.getLongExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE, 0L) != 0) {
                            e.i(context);
                            return;
                        } else if (!intent.hasExtra(PushPatchMessageReceiver.REGID)) {
                            return;
                        } else {
                            stringExtra = intent.getStringExtra(PushPatchMessageReceiver.REGID);
                            if (TextUtils.isEmpty(stringExtra)) {
                                return;
                            }
                        }
                    } else if (TextUtils.equals(action, "com.xiaomi.mipush.PUSH_MSG")) {
                        if (m.b() && intent.hasExtra(PushPatchMessageReceiver.PUSH_MSG)) {
                            MiPushMessage miPushMessage = (MiPushMessage) intent.getSerializableExtra(PushPatchMessageReceiver.PUSH_MSG);
                            if (intent.hasExtra(PushPatchMessageReceiver.PUSH_MSG_TYPE)) {
                                handleXiaomiMessageCallBack(context, miPushMessage, intent.getIntExtra(PushPatchMessageReceiver.PUSH_MSG_TYPE, 0));
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (!TextUtils.equals(action, "com.meizu.mzpush.REGISTER")) {
                        if (TextUtils.equals(action, "com.meizu.mzpush.PUSH_MSG")) {
                            if (m.c() && intent.hasExtra("mz_push_msg_type")) {
                                handleMeizuMessageCallBack(context, intent);
                                return;
                            }
                            return;
                        } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.OPPO_CLICK")) {
                            if (m.f() || m.g() || m.h()) {
                                handleOppoMessageCallBack(context, intent);
                                return;
                            }
                            return;
                        } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.VIVO_CLICK")) {
                            if (m.i()) {
                                handleVivoMessageCallBack(context, intent);
                                return;
                            }
                            return;
                        } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.pass_through_notify_CLICK")) {
                            onNotificationMessageClicked(context, intent.getStringExtra("notification_title"), intent.getStringExtra("notification_content"), intent.getStringExtra("extra_extra_custom_content"));
                            return;
                        } else {
                            return;
                        }
                    } else if (!com.baidu.android.pushservice.b.d.j(context) || !intent.hasExtra("mz_register_errorcode")) {
                        return;
                    } else {
                        String stringExtra13 = intent.getStringExtra("mz_register_errorcode");
                        if (TextUtils.isEmpty(stringExtra13) || !stringExtra13.equals(BasicPushStatus.SUCCESS_CODE)) {
                            e.j(context);
                            return;
                        } else if (!intent.hasExtra("mz_pushid")) {
                            return;
                        } else {
                            stringExtra = intent.getStringExtra("mz_pushid");
                            if (TextUtils.isEmpty(stringExtra)) {
                                return;
                            }
                        }
                    }
                    e.a(context, stringExtra);
                    return;
                } else if (!com.baidu.android.pushservice.b.d.l(context) || !PushSettings.l(context)) {
                    return;
                } else {
                    try {
                        String str5 = new String(intent.getByteArrayExtra("selfshow_info"), "UTF-8");
                        if (!TextUtils.isEmpty(str5) && (a3 = (a2 = com.baidu.android.pushservice.message.a.i.a(context, str5)).a(context)) != null && m.i(context) && !m.l(context, a2.j)) {
                            PushServiceReceiver.a(context, a3);
                            return;
                        }
                        return;
                    } catch (Exception e8) {
                        e = e8;
                        cVar = new b.c(context);
                    }
                }
                cVar.a(Log.getStackTraceString(e)).a();
                return;
            } else if ((com.baidu.android.pushservice.b.d.q(context) && !com.baidu.android.pushservice.b.d.c(context)) || intent.getExtras() == null) {
                return;
            } else {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("baidu_message_secur_info");
                byte[] byteArrayExtra4 = intent.getByteArrayExtra("baidu_message_body");
                String stringExtra14 = intent.getStringExtra("message_id");
                int intExtra3 = intent.getIntExtra("baidu_message_type", -1);
                String stringExtra15 = intent.getStringExtra("app_id");
                int intExtra4 = intent.getIntExtra("notify_id", 0);
                if (byteArrayExtra3 == null || byteArrayExtra4 == null || TextUtils.isEmpty(stringExtra14) || TextUtils.isEmpty(stringExtra15) || intExtra3 == -1) {
                    sendCallback(context, intent, 2, true);
                    return;
                } else if (intExtra3 == k.i.b() || (!m.j(context, stringExtra14) && com.baidu.android.pushservice.c.a.a(context, stringExtra14))) {
                    new Thread(this, context, intExtra3, stringExtra15, stringExtra14, byteArrayExtra3, byteArrayExtra4, intent, intExtra4, new a(this, context, context, intent) { // from class: com.baidu.android.pushservice.PushMessageReceiver.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Context a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Intent f24136b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ PushMessageReceiver f24137c;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(context);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context, context, intent};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    super((Context) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f24137c = this;
                            this.a = context;
                            this.f24136b = intent;
                        }

                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) || this.f24145d.get() == null) {
                                return;
                            }
                            this.f24137c.onMessage(this.f24145d.get(), message.getData().getString("message"), message.getData().getString("custom_content"), message.getData().getInt("notify_id"));
                            PushMessageReceiver.sendCallback(this.a, this.f24136b, 10, false);
                        }
                    }) { // from class: com.baidu.android.pushservice.PushMessageReceiver.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Context a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ int f24138b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f24139c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ String f24140d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ byte[] f24141e;

                        /* renamed from: f  reason: collision with root package name */
                        public final /* synthetic */ byte[] f24142f;

                        /* renamed from: g  reason: collision with root package name */
                        public final /* synthetic */ Intent f24143g;

                        /* renamed from: h  reason: collision with root package name */
                        public final /* synthetic */ int f24144h;
                        public final /* synthetic */ a i;
                        public final /* synthetic */ PushMessageReceiver j;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context, Integer.valueOf(intExtra3), stringExtra15, stringExtra14, byteArrayExtra3, byteArrayExtra4, intent, Integer.valueOf(intExtra4), r15};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.j = this;
                            this.a = context;
                            this.f24138b = intExtra3;
                            this.f24139c = stringExtra15;
                            this.f24140d = stringExtra14;
                            this.f24141e = byteArrayExtra3;
                            this.f24142f = byteArrayExtra4;
                            this.f24143g = intent;
                            this.f24144h = intExtra4;
                            this.i = r15;
                        }

                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                String[] a6 = com.baidu.android.pushservice.message.a.g.a(this.a, this.f24138b, this.f24139c, this.f24140d, this.f24141e, this.f24142f);
                                if (a6 == null || a6.length != 2) {
                                    PushMessageReceiver.sendCallback(this.a, this.f24143g, 9, true);
                                    return;
                                }
                                Message message = new Message();
                                Bundle bundle = new Bundle();
                                bundle.putString("message", a6[0]);
                                bundle.putString("custom_content", a6[1]);
                                bundle.putInt("notify_id", this.f24144h);
                                message.setData(bundle);
                                this.i.sendMessage(message);
                            }
                        }
                    }.start();
                } else {
                    sendCallback(context, intent, 4, true);
                }
            }
            widgetInfoCallBack(context, intent);
        } catch (Exception e9) {
            new b.c(context).a(Log.getStackTraceString(e9)).a();
        }
    }

    public abstract void onSetTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onUnbind(Context context, int i, String str);

    public void onWidgetBadgeUpdate(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, context, i, i2) == null) {
        }
    }
}
