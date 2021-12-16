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
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.a.l;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
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
/* loaded from: classes9.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PushMessageReceiver";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final WeakReference<Context> f32498d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32498d = new WeakReference<>(context);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f32499b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f32500c;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ b[] f32501e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public int f32502d;

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
            f32499b = new b("MSG_ARRIVED", 1, 2);
            b bVar = new b("MSG_CLICKED", 2, 3);
            f32500c = bVar;
            f32501e = new b[]{a, f32499b, bVar};
        }

        public b(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f32502d = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f32502d : invokeV.intValue;
        }
    }

    public PushMessageReceiver() {
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

    private void handleCrossMessageCallBack(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, context, intent) == null) {
            String stringExtra = intent.getStringExtra("msgid");
            String stringExtra2 = intent.getStringExtra("notification_title");
            String stringExtra3 = intent.getStringExtra("notification_content");
            int intExtra = intent.getIntExtra("open_type", 0);
            String stringExtra4 = intent.getStringExtra("message_pkg_content");
            String stringExtra5 = intent.getStringExtra("extra_extra_custom_content");
            if (m.a(context, intent.getByteArrayExtra("baidu_message_secur_info"), intent.getStringExtra("com.baidu.pushservice.app_id"), stringExtra, intent.getByteArrayExtra("baidu_message_body")) && !m.l(context, stringExtra)) {
                if (intExtra == 2 && !TextUtils.isEmpty(stringExtra4)) {
                    try {
                        Intent parseUri = Intent.parseUri(stringExtra4, 0);
                        parseUri.setPackage(context.getPackageName());
                        parseUri.addFlags(268435456);
                        if (!TextUtils.isEmpty(stringExtra5)) {
                            JSONObject jSONObject = new JSONObject(stringExtra5);
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                parseUri.putExtra(next, jSONObject.optString(next));
                            }
                        }
                        if (context.getPackageManager().queryIntentActivities(parseUri, 0).size() > 0) {
                            context.startActivity(parseUri);
                        }
                    } catch (Exception e2) {
                        new b.c(context).a(Log.getStackTraceString(e2)).a();
                        return;
                    }
                }
                try {
                    onNotificationClicked(context, stringExtra2, stringExtra3, stringExtra5);
                } catch (Exception e3) {
                    new b.c(context).a(Log.getStackTraceString(e3)).a();
                }
            }
        }
    }

    private void handleMeizuMessageCallBack(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, intent) == null) {
            com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
            int intExtra = intent.getIntExtra("mz_push_msg_type", 0);
            String c2 = iVar.c(context, intent.getStringExtra("mz_notification_self_define_content"));
            if (m.l(context, iVar.f33224j)) {
                return;
            }
            String str = iVar.m;
            if (f.a(context, str, (iVar.f33224j + c2).replaceAll("\\\\", "")) && intExtra == b.f32500c.a()) {
                onNotificationClicked(context, intent.getStringExtra("mz_notification_title"), intent.getStringExtra("mz_notification_content"), c2);
                new b.a(context).a("3").b(iVar.f33224j).a(System.currentTimeMillis()).b(601010L).a();
            }
        }
    }

    private void handleOppoMessageCallBack(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, intent) == null) {
            String stringExtra = intent.getStringExtra("op_notification_sign");
            String stringExtra2 = intent.getStringExtra("op_notification_msg_id");
            String stringExtra3 = intent.getStringExtra("op_notification_pkg_content");
            String stringExtra4 = intent.getStringExtra("extra_extra_custom_content");
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || m.l(context, stringExtra2)) {
                return;
            }
            if (f.a(context, stringExtra, stringExtra2 + stringExtra4)) {
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
                    parseUri.addFlags(268435456);
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
        if (interceptable == null || interceptable.invokeLL(65541, this, context, intent) == null) {
            String stringExtra = intent.getStringExtra("vi_notification_title");
            String stringExtra2 = intent.getStringExtra("vi_notification_content");
            String stringExtra3 = intent.getStringExtra("vi_notification_sign");
            String stringExtra4 = intent.getStringExtra("vi_notification_msg_id");
            String stringExtra5 = intent.getStringExtra("vi_notification_pkg_content");
            String stringExtra6 = intent.getStringExtra("extra_extra_custom_content");
            if (TextUtils.isEmpty(stringExtra3) || TextUtils.isEmpty(stringExtra4) || m.l(context, stringExtra4)) {
                return;
            }
            if (f.a(context, stringExtra3, stringExtra4 + stringExtra6)) {
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
                    parseUri.addFlags(268435456);
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

    private void handleXiaomiMessageCallBack(Context context, MiPushMessage miPushMessage, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65542, this, context, miPushMessage, i2) == null) {
            try {
                String content = miPushMessage.getContent();
                com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
                boolean msgFromXMConsole = msgFromXMConsole(context, content);
                if (msgFromXMConsole) {
                    iVar.f33225k = l.f33191b.b();
                } else {
                    content = iVar.b(context, content);
                }
                if (i2 == b.f32500c.a() || !m.l(context, iVar.f33224j)) {
                    if (iVar.f33225k == l.l.b()) {
                        m.k(context);
                    } else if (iVar.f33225k == l.f33196g.b() || iVar.f33225k == l.f33192c.b() || iVar.f33225k == l.f33191b.b() || iVar.f33225k == l.f33195f.b() || iVar.f33225k == l.f33193d.b() || iVar.f33225k == l.f33194e.b()) {
                        if (i2 == b.a.a()) {
                            onMessage(context, content, null, 0);
                        } else if (i2 == b.f32499b.a()) {
                            onNotificationArrived(context, miPushMessage.getTitle(), miPushMessage.getDescription(), content);
                        } else if (i2 == b.f32500c.a()) {
                            onNotificationClicked(context, miPushMessage.getTitle(), miPushMessage.getDescription(), content);
                        }
                    }
                }
                if (msgFromXMConsole || i2 != b.f32500c.a()) {
                    return;
                }
                new b.a(context).a("2").b(iVar.f33224j).a(System.currentTimeMillis()).b(601010L).a();
            } catch (Throwable th) {
                new b.c(context).a(Log.getStackTraceString(th)).a();
            }
        }
    }

    public static boolean msgFromXMConsole(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
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

    public static void sendCallback(Context context, Intent intent, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, intent, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            int intExtra = intent.getIntExtra("baidu_message_type", -1);
            intent.getAction();
            if (intExtra == l.f33199j.b()) {
                if (z) {
                    m.a(context, intent.getStringExtra("message_id"), i2);
                }
            } else if (!intent.getBooleanExtra("bdpush_deliver_NO_CALLBACK", false) && TextUtils.equals(context.getPackageName(), intent.getStringExtra("bd.cross.request.SOURCE_PACKAGE"))) {
                intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.MESSAGE_ACK");
                intent.putExtra("bd.cross.request.RESULT_CODE", i2);
                com.baidu.android.pushservice.j.b.a(intent);
            }
        }
    }

    public abstract void onBind(Context context, int i2, String str, String str2, String str3, String str4);

    public abstract void onDelTags(Context context, int i2, List<String> list, List<String> list2, String str);

    public abstract void onListTags(Context context, int i2, List<String> list, String str);

    public abstract void onMessage(Context context, String str, String str2, int i2);

    public abstract void onNotificationArrived(Context context, String str, String str2, String str3);

    public abstract void onNotificationClicked(Context context, String str, String str2, String str3);

    /* JADX WARN: Removed duplicated region for block: B:91:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x030e  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceive(Context context, Intent intent) {
        String stringExtra;
        b.c cVar;
        com.baidu.android.pushservice.message.i a2;
        PublicMsg a3;
        b.a b2;
        PushMessageReceiver pushMessageReceiver;
        JSONArray jSONArray;
        ArrayList arrayList;
        ArrayList arrayList2;
        JSONArray jSONArray2;
        String str;
        String str2;
        String str3;
        String string;
        String string2;
        String string3;
        String optString;
        String string4;
        String str4;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, intent) == null) {
            if (context == null || intent == null) {
                return;
            }
            try {
                intent.getByteArrayExtra("baidu_message_secur_info");
                String action = intent.getAction();
                if (!TextUtils.equals(action, "com.baidu.android.pushservice.action.MESSAGE")) {
                    String str5 = null;
                    if (TextUtils.equals(action, "com.baidu.android.pushservice.action.RECEIVE")) {
                        String stringExtra2 = intent.getStringExtra("method");
                        if (TextUtils.isEmpty(stringExtra2)) {
                            return;
                        }
                        int intExtra = intent.getIntExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, 0);
                        String str6 = intent.getByteArrayExtra("content") != null ? new String(intent.getByteArrayExtra("content")) : "";
                        if (stringExtra2.equals("com.baidu.android.pushservice.action.notification.ARRIVED")) {
                            String stringExtra3 = intent.getStringExtra("msgid");
                            String stringExtra4 = intent.getStringExtra("notification_title");
                            String stringExtra5 = intent.getStringExtra("notification_content");
                            String stringExtra6 = intent.getStringExtra("extra_extra_custom_content");
                            if (m.a(context, intent.getByteArrayExtra("baidu_message_secur_info"), stringExtra3, intent.getByteArrayExtra("baidu_message_body"))) {
                                onNotificationArrived(context, stringExtra4, stringExtra5, stringExtra6);
                            }
                        } else if (stringExtra2.equals("method_bind")) {
                            if (intExtra != 0 || TextUtils.isEmpty(str6)) {
                                onBind(context, intExtra, null, null, null, null);
                                m.a("onBind from " + context.getPackageName() + " errorCode " + intExtra + " errorMsg = " + str6 + " at time of " + System.currentTimeMillis(), context);
                            } else {
                                try {
                                    JSONObject jSONObject = new JSONObject(str6);
                                    string = jSONObject.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                                    JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                                    string2 = jSONObject2.getString("appid");
                                    PushSettings.b(context, string2);
                                    string3 = jSONObject2.getString("channel_id");
                                    optString = jSONObject2.optString("new_channel_id");
                                    string4 = jSONObject2.getString("user_id");
                                    if (intent.hasExtra("real_bind")) {
                                        long currentTimeMillis = System.currentTimeMillis();
                                        str5 = intent.getStringExtra("access_token");
                                        j2 = currentTimeMillis;
                                        str4 = intent.getStringExtra("secret_key");
                                    } else {
                                        str4 = null;
                                        j2 = 0;
                                    }
                                    str = " errorCode ";
                                    str2 = "onBind from ";
                                    str3 = " at time of ";
                                } catch (Exception e2) {
                                    e = e2;
                                    str = " errorCode ";
                                    str2 = "onBind from ";
                                    str3 = " at time of ";
                                }
                                try {
                                    com.baidu.android.pushservice.j.i.a(context, string2, string3, optString, string, string4, j2, str5, str4);
                                    onBind(context, intExtra, string2, string4, TextUtils.isEmpty(optString) ? string3 : optString, string);
                                    m.a("PushMessageReceiver#onBind from " + context.getPackageName() + ", errorCode= " + intExtra + ", appid=  " + string2 + ", userId=" + string4 + ", channelId=" + string3 + ", newChannelId=" + optString + ", requestId=" + string + ", at time of " + System.currentTimeMillis(), context);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(context.getPackageName());
                                    sb.append(",");
                                    sb.append(string2);
                                    sb.append(",");
                                    sb.append(string4);
                                    sb.append(",");
                                    sb.append("false");
                                    sb.append(",");
                                    sb.append((int) com.baidu.android.pushservice.a.a());
                                    com.baidu.android.pushservice.c.c.c(context, m.c(sb.toString()));
                                } catch (Exception e3) {
                                    e = e3;
                                    onBind(context, intExtra, null, null, null, null);
                                    m.a(str2 + context.getPackageName() + str + intExtra + " exception " + e.getMessage() + str3 + System.currentTimeMillis(), context);
                                    new b.c(context).a(Log.getStackTraceString(e)).a();
                                    return;
                                }
                            }
                            return;
                        } else if (stringExtra2.equals("method_unbind")) {
                            try {
                                pushMessageReceiver = this;
                                try {
                                    pushMessageReceiver.onUnbind(context, intExtra, new JSONObject(str6).getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID));
                                } catch (JSONException e4) {
                                    e = e4;
                                    pushMessageReceiver.onUnbind(context, intExtra, null);
                                    new b.c(context).a(Log.getStackTraceString(e)).a();
                                    m.a(context, false);
                                    if (com.baidu.android.pushservice.b.d.k(context)) {
                                    }
                                    if (com.baidu.android.pushservice.b.d.j(context)) {
                                    }
                                    m.a("unbind from" + context.getPackageName() + " errorCode " + intExtra + " at time of " + System.currentTimeMillis(), context);
                                    return;
                                }
                            } catch (JSONException e5) {
                                e = e5;
                                pushMessageReceiver = this;
                            }
                            m.a(context, false);
                            if (com.baidu.android.pushservice.b.d.k(context)) {
                                MiPushClient.unregisterPush(context);
                            }
                            if (com.baidu.android.pushservice.b.d.j(context)) {
                                String a4 = com.baidu.android.pushservice.j.i.a(context, "BD_MEIZU_PROXY_APPID_KEY");
                                String a5 = com.baidu.android.pushservice.j.i.a(context, "BD_MEIZU_PROXY_APPKEY_KEY");
                                if (!TextUtils.isEmpty(a4) && !TextUtils.isEmpty(a5)) {
                                    com.meizu.cloud.pushsdk.PushManager.unRegister(context, a4, a5);
                                }
                            }
                            m.a("unbind from" + context.getPackageName() + " errorCode " + intExtra + " at time of " + System.currentTimeMillis(), context);
                            return;
                        } else if (stringExtra2.equals("method_set_tags")) {
                            try {
                                JSONObject jSONObject3 = new JSONObject(str6);
                                String string5 = jSONObject3.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                                if (TextUtils.isEmpty(jSONObject3.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG))) {
                                    JSONObject optJSONObject = jSONObject3.optJSONObject("response_params");
                                    if (optJSONObject == null || (jSONArray = optJSONObject.getJSONArray("details")) == null) {
                                        return;
                                    }
                                    arrayList = new ArrayList();
                                    arrayList2 = new ArrayList();
                                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                        JSONObject jSONObject4 = jSONArray.getJSONObject(i2);
                                        String string6 = jSONObject4.getString("tag");
                                        if (jSONObject4.getInt("result") == 0) {
                                            arrayList.add(string6);
                                        } else {
                                            arrayList2.add(string6);
                                        }
                                    }
                                } else {
                                    arrayList = new ArrayList();
                                    arrayList2 = new ArrayList();
                                }
                                onSetTags(context, intExtra, arrayList, arrayList2, string5);
                                return;
                            } catch (JSONException e6) {
                                e = e6;
                                onSetTags(context, intExtra, null, null, null);
                                cVar = new b.c(context);
                            }
                        } else if (stringExtra2.equals("method_del_tags")) {
                            try {
                                JSONObject jSONObject5 = new JSONObject(str6);
                                String string7 = jSONObject5.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                                JSONObject jSONObject6 = jSONObject5.getJSONObject("response_params");
                                if (jSONObject6 == null || (jSONArray2 = jSONObject6.getJSONArray("details")) == null) {
                                    return;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                ArrayList arrayList4 = new ArrayList();
                                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                    JSONObject jSONObject7 = jSONArray2.getJSONObject(i3);
                                    String string8 = jSONObject7.getString("tag");
                                    if (jSONObject7.getInt("result") == 0) {
                                        arrayList3.add(string8);
                                    } else {
                                        arrayList4.add(string8);
                                    }
                                }
                                onDelTags(context, intExtra, arrayList3, arrayList4, string7);
                                return;
                            } catch (JSONException e7) {
                                e = e7;
                                onDelTags(context, intExtra, null, null, null);
                                cVar = new b.c(context);
                            }
                        } else if (!stringExtra2.equals("method_listtags")) {
                            return;
                        } else {
                            try {
                                onListTags(context, intExtra, intent.getStringArrayListExtra("tags_list"), new JSONObject(str6).getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID));
                                return;
                            } catch (JSONException e8) {
                                e = e8;
                                onListTags(context, intExtra, null, null);
                                cVar = new b.c(context);
                            }
                        }
                    } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.notification.CLICK")) {
                        String stringExtra7 = intent.getStringExtra("msgid");
                        String stringExtra8 = intent.getStringExtra("notification_title");
                        String stringExtra9 = intent.getStringExtra("notification_content");
                        String stringExtra10 = intent.getStringExtra("extra_extra_custom_content");
                        String stringExtra11 = intent.getStringExtra("com.baidu.pushservice.app_id");
                        int intExtra2 = intent.getIntExtra("proxy_mode", 0);
                        byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_secur_info");
                        byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_body");
                        if (intExtra2 == 5) {
                            if (!f.a(context.getApplicationContext(), intent.getStringExtra("proxy_sign_info"), intent.getStringExtra("proxy_check_info"))) {
                                return;
                            }
                            onNotificationClicked(context, stringExtra8, stringExtra9, stringExtra10);
                            b2 = new b.a(context).a("1").b(stringExtra7).a(System.currentTimeMillis()).b(601010L);
                        } else if (!m.a(context, stringExtra7, stringExtra11, stringExtra8, stringExtra9, stringExtra10) && !m.a(context, byteArrayExtra, stringExtra7, byteArrayExtra2)) {
                            return;
                        } else {
                            onNotificationClicked(context, stringExtra8, stringExtra9, stringExtra10);
                            b2 = new b.a(context).a("0").b(stringExtra7).a(System.currentTimeMillis()).b(601010L);
                        }
                        b2.a();
                        return;
                    } else if (TextUtils.equals(action, "com.huawei.android.push.intent.REGISTRATION")) {
                        if (!com.baidu.android.pushservice.b.d.l(context)) {
                            return;
                        }
                        try {
                            String str7 = new String(intent.getByteArrayExtra("device_token"), "UTF-8");
                            if (TextUtils.isEmpty(str7)) {
                                return;
                            }
                            f.a(context, str7);
                            return;
                        } catch (Exception e9) {
                            e = e9;
                            cVar = new b.c(context);
                        }
                    } else if (TextUtils.equals(action, "com.huawei.intent.action.PUSH")) {
                        if (!com.baidu.android.pushservice.b.d.l(context)) {
                            return;
                        }
                        try {
                            String str8 = new String(intent.getByteArrayExtra("selfshow_info"), "UTF-8");
                            if (!TextUtils.isEmpty(str8) && (a3 = (a2 = com.baidu.android.pushservice.message.a.j.a(context, str8)).a(context)) != null && m.i(context) && !m.l(context, a2.f33224j)) {
                                PushServiceReceiver.a(context, a3);
                                return;
                            }
                            return;
                        } catch (Exception e10) {
                            e = e10;
                            cVar = new b.c(context);
                        }
                    } else if (!TextUtils.equals(action, "com.huawei.android.push.intent.RECEIVE")) {
                        if (TextUtils.equals(action, "com.xiaomi.mipush.REGISTER")) {
                            if (!com.baidu.android.pushservice.b.d.k(context) || !intent.hasExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE)) {
                                return;
                            }
                            if (intent.getLongExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE, 0L) != 0) {
                                f.i(context);
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
                                if (m.e() || m.f() || m.g()) {
                                    handleOppoMessageCallBack(context, intent);
                                    return;
                                }
                                return;
                            } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.VIVO_CLICK")) {
                                if (m.h()) {
                                    handleVivoMessageCallBack(context, intent);
                                    return;
                                }
                                return;
                            } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.CROSS_CLICK")) {
                                handleCrossMessageCallBack(context, intent);
                                return;
                            } else {
                                return;
                            }
                        } else if (!com.baidu.android.pushservice.b.d.j(context) || !intent.hasExtra("mz_register_errorcode")) {
                            return;
                        } else {
                            String stringExtra12 = intent.getStringExtra("mz_register_errorcode");
                            if (TextUtils.isEmpty(stringExtra12) || !stringExtra12.equals(BasicPushStatus.SUCCESS_CODE)) {
                                f.j(context);
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
                        f.a(context, stringExtra);
                        return;
                    } else if (!com.baidu.android.pushservice.b.d.l(context)) {
                        return;
                    } else {
                        byte[] byteArrayExtra3 = intent.getByteArrayExtra("msg_data");
                        byte[] byteArrayExtra4 = intent.getByteArrayExtra("device_token");
                        try {
                            String str9 = new String(byteArrayExtra3, "utf-8");
                            new String(byteArrayExtra4, "utf-8");
                            com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
                            String a6 = iVar.a(context, str9);
                            if (m.i(context) && !m.l(context, iVar.f33224j)) {
                                if (f.a(context, iVar.m, iVar.f33224j + a6)) {
                                    if (iVar.f33225k == l.l.b()) {
                                        m.k(context);
                                    } else if (iVar.f33225k == l.f33196g.b() || iVar.f33225k == l.f33191b.b()) {
                                        onMessage(context, a6, null, 0);
                                    }
                                }
                            }
                            return;
                        } catch (Exception e11) {
                            e = e11;
                            cVar = new b.c(context);
                        }
                    }
                    cVar.a(Log.getStackTraceString(e)).a();
                } else if ((!com.baidu.android.pushservice.b.d.q(context) || com.baidu.android.pushservice.b.d.c(context)) && intent.getExtras() != null) {
                    byte[] byteArrayExtra5 = intent.getByteArrayExtra("baidu_message_secur_info");
                    byte[] byteArrayExtra6 = intent.getByteArrayExtra("baidu_message_body");
                    String stringExtra13 = intent.getStringExtra("message_id");
                    int intExtra3 = intent.getIntExtra("baidu_message_type", -1);
                    String stringExtra14 = intent.getStringExtra("app_id");
                    int intExtra4 = intent.getIntExtra("notify_id", 0);
                    if (byteArrayExtra5 == null || byteArrayExtra6 == null || TextUtils.isEmpty(stringExtra13) || TextUtils.isEmpty(stringExtra14) || intExtra3 == -1) {
                        sendCallback(context, intent, 2, true);
                    } else if (intExtra3 == l.f33199j.b() || (!m.j(context, stringExtra13) && com.baidu.android.pushservice.c.a.a(context, stringExtra13))) {
                        new Thread(this, context, intExtra3, stringExtra14, stringExtra13, byteArrayExtra5, byteArrayExtra6, intent, intExtra4, new a(this, context, context, intent) { // from class: com.baidu.android.pushservice.PushMessageReceiver.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Context a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ Intent f32487b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ PushMessageReceiver f32488c;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(context);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, context, context, intent};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        super((Context) newInitContext.callArgs[0]);
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f32488c = this;
                                this.a = context;
                                this.f32487b = intent;
                            }

                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                Interceptable interceptable2 = $ic;
                                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) || this.f32498d.get() == null) {
                                    return;
                                }
                                this.f32488c.onMessage(this.f32498d.get(), message.getData().getString("message"), message.getData().getString("custom_content"), message.getData().getInt("notify_id"));
                                PushMessageReceiver.sendCallback(this.a, this.f32487b, 10, false);
                            }
                        }) { // from class: com.baidu.android.pushservice.PushMessageReceiver.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Context a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ int f32489b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ String f32490c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ String f32491d;

                            /* renamed from: e  reason: collision with root package name */
                            public final /* synthetic */ byte[] f32492e;

                            /* renamed from: f  reason: collision with root package name */
                            public final /* synthetic */ byte[] f32493f;

                            /* renamed from: g  reason: collision with root package name */
                            public final /* synthetic */ Intent f32494g;

                            /* renamed from: h  reason: collision with root package name */
                            public final /* synthetic */ int f32495h;

                            /* renamed from: i  reason: collision with root package name */
                            public final /* synthetic */ a f32496i;

                            /* renamed from: j  reason: collision with root package name */
                            public final /* synthetic */ PushMessageReceiver f32497j;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, context, Integer.valueOf(intExtra3), stringExtra14, stringExtra13, byteArrayExtra5, byteArrayExtra6, intent, Integer.valueOf(intExtra4), r15};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f32497j = this;
                                this.a = context;
                                this.f32489b = intExtra3;
                                this.f32490c = stringExtra14;
                                this.f32491d = stringExtra13;
                                this.f32492e = byteArrayExtra5;
                                this.f32493f = byteArrayExtra6;
                                this.f32494g = intent;
                                this.f32495h = intExtra4;
                                this.f32496i = r15;
                            }

                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    String[] a7 = com.baidu.android.pushservice.message.a.h.a(this.a, this.f32489b, this.f32490c, this.f32491d, this.f32492e, this.f32493f);
                                    if (a7 == null || a7.length != 2) {
                                        PushMessageReceiver.sendCallback(this.a, this.f32494g, 9, true);
                                        return;
                                    }
                                    Message message = new Message();
                                    Bundle bundle = new Bundle();
                                    bundle.putString("message", a7[0]);
                                    bundle.putString("custom_content", a7[1]);
                                    bundle.putInt("notify_id", this.f32495h);
                                    message.setData(bundle);
                                    this.f32496i.sendMessage(message);
                                    m.a("message " + a7[0] + " at time of " + System.currentTimeMillis(), this.a);
                                }
                            }
                        }.start();
                    } else {
                        sendCallback(context, intent, 4, true);
                    }
                }
            } catch (Exception e12) {
                new b.c(context).a(Log.getStackTraceString(e12)).a();
            }
        }
    }

    public abstract void onSetTags(Context context, int i2, List<String> list, List<String> list2, String str);

    public abstract void onUnbind(Context context, int i2, String str);
}
