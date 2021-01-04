package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
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
    public static final String TAG = "PushMessageReceiver";

    /* loaded from: classes3.dex */
    private static class a extends Handler {
        protected final WeakReference<Context> d;

        public a(Context context) {
            super(context.getMainLooper());
            this.d = new WeakReference<>(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum b {
        MSG_PASS(1),
        MSG_ARRIVED(2),
        MSG_CLICKED(3);
        
        private int d;

        b(int i) {
            this.d = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.d;
        }
    }

    private void handleCrossMessageCallBack(Context context, Intent intent) {
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
                } catch (Exception e) {
                    new b.c(context).a(Log.getStackTraceString(e)).a();
                    return;
                }
            }
            try {
                onNotificationClicked(context, stringExtra2, stringExtra3, stringExtra5);
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    private void handleMeizuMessageCallBack(Context context, Intent intent) {
        com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
        int intExtra = intent.getIntExtra("mz_push_msg_type", 0);
        String c = iVar.c(context, intent.getStringExtra("mz_notification_self_define_content"));
        if (!m.l(context, iVar.j) && f.a(context, iVar.m, (iVar.j + c).replaceAll("\\\\", "")) && intExtra == b.MSG_CLICKED.a()) {
            onNotificationClicked(context, intent.getStringExtra("mz_notification_title"), intent.getStringExtra("mz_notification_content"), c);
            new b.a(context).a("3").b(iVar.j).a(System.currentTimeMillis()).b(601010L).a();
        }
    }

    private void handleOppoMessageCallBack(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("op_notification_sign");
        String stringExtra2 = intent.getStringExtra("op_notification_msg_id");
        String stringExtra3 = intent.getStringExtra("op_notification_pkg_content");
        String stringExtra4 = intent.getStringExtra("extra_extra_custom_content");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || m.l(context, stringExtra2) || !f.a(context, stringExtra, stringExtra2 + stringExtra4)) {
            return;
        }
        if (!TextUtils.isEmpty(stringExtra3)) {
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
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return;
            }
        }
        try {
            onNotificationClicked(context, null, null, new JSONObject("{\"extras\":" + stringExtra4 + "}").getString("extras"));
            new b.a(context).a("4").b(stringExtra2).a(System.currentTimeMillis()).b(601010L).a();
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
    }

    private void handleVivoMessageCallBack(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("vi_notification_title");
        String stringExtra2 = intent.getStringExtra("vi_notification_content");
        String stringExtra3 = intent.getStringExtra("vi_notification_sign");
        String stringExtra4 = intent.getStringExtra("vi_notification_msg_id");
        String stringExtra5 = intent.getStringExtra("vi_notification_pkg_content");
        String stringExtra6 = intent.getStringExtra("extra_extra_custom_content");
        if (TextUtils.isEmpty(stringExtra3) || TextUtils.isEmpty(stringExtra4) || m.l(context, stringExtra4) || !f.a(context, stringExtra3, stringExtra4 + stringExtra6)) {
            return;
        }
        if (!TextUtils.isEmpty(stringExtra5)) {
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
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return;
            }
        }
        try {
            onNotificationClicked(context, stringExtra, stringExtra2, stringExtra6);
            new b.a(context).a("5").b(stringExtra4).a(System.currentTimeMillis()).b(601010L).a();
        } catch (Exception e2) {
            new b.c(context).a(Log.getStackTraceString(e2)).a();
        }
    }

    private void handleXiaomiMessageCallBack(Context context, MiPushMessage miPushMessage, int i) {
        try {
            String content = miPushMessage.getContent();
            com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
            boolean msgFromXMConsole = msgFromXMConsole(context, content);
            if (msgFromXMConsole) {
                iVar.k = com.baidu.android.pushservice.message.a.j.MSG_TYPE_SINGLE_PRIVATE.b();
            } else {
                content = iVar.b(context, content);
            }
            if (i == b.MSG_CLICKED.a() || !m.l(context, iVar.j)) {
                if (iVar.k == com.baidu.android.pushservice.message.a.j.MSG_TYPE_APPSTAT_COMMAND.b()) {
                    m.l(context);
                } else if (iVar.k == com.baidu.android.pushservice.message.a.j.MSG_TYPE_PRIVATE_MESSAGE.b() || iVar.k == com.baidu.android.pushservice.message.a.j.MSG_TYPE_MULTI_PRIVATE.b() || iVar.k == com.baidu.android.pushservice.message.a.j.MSG_TYPE_SINGLE_PRIVATE.b() || iVar.k == com.baidu.android.pushservice.message.a.j.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.b() || iVar.k == com.baidu.android.pushservice.message.a.j.MSG_TYPE_SINGLE_PUBLIC.b() || iVar.k == com.baidu.android.pushservice.message.a.j.MSG_TYPE_MULTI_PUBLIC.b()) {
                    if (i == b.MSG_PASS.a()) {
                        onMessage(context, content, null);
                    } else if (i == b.MSG_ARRIVED.a()) {
                        onNotificationArrived(context, miPushMessage.getTitle(), miPushMessage.getDescription(), content);
                    } else if (i == b.MSG_CLICKED.a()) {
                        onNotificationClicked(context, miPushMessage.getTitle(), miPushMessage.getDescription(), content);
                    }
                }
            }
            if (msgFromXMConsole || i != b.MSG_CLICKED.a()) {
                return;
            }
            new b.a(context).a("2").b(iVar.j).a(System.currentTimeMillis()).b(601010L).a();
        } catch (Throwable th) {
            new b.c(context).a(Log.getStackTraceString(th)).a();
        }
    }

    private static boolean msgFromXMConsole(Context context, String str) {
        try {
            new JSONObject(str);
            return false;
        } catch (Exception e) {
            new b.c(context).a(Log.getStackTraceString(e)).a();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendCallback(Context context, Intent intent, int i) {
        if (intent.getBooleanExtra("bdpush_deliver_NO_CALLBACK", false)) {
            return;
        }
        if (TextUtils.equals(context.getPackageName(), intent.getStringExtra("bd.cross.request.SOURCE_PACKAGE"))) {
            intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.MESSAGE_ACK");
            intent.putExtra("bd.cross.request.RESULT_CODE", i);
            com.baidu.android.pushservice.i.b.a(intent);
        }
    }

    public abstract void onBind(Context context, int i, String str, String str2, String str3, String str4);

    public abstract void onDelTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onListTags(Context context, int i, List<String> list, String str);

    public abstract void onMessage(Context context, String str, String str2);

    public abstract void onNotificationArrived(Context context, String str, String str2, String str3);

    public abstract void onNotificationClicked(Context context, String str, String str2, String str3);

    /* JADX WARN: Type inference failed for: r4v218, types: [com.baidu.android.pushservice.PushMessageReceiver$2] */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        com.baidu.android.pushservice.message.i a2;
        PublicMsg a3;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (context == null || intent == null) {
            return;
        }
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            String action = intent.getAction();
            if (TextUtils.equals(action, "com.baidu.android.pushservice.action.MESSAGE")) {
                if ((!com.baidu.android.pushservice.b.d.q(context) || com.baidu.android.pushservice.b.d.c(context)) && intent.getExtras() != null) {
                    final byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_secur_info");
                    final byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_body");
                    final String stringExtra = intent.getStringExtra("message_id");
                    final int intExtra = intent.getIntExtra("baidu_message_type", -1);
                    final String stringExtra2 = intent.getStringExtra("app_id");
                    if (byteArrayExtra == null || byteArrayExtra2 == null || TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || intExtra == -1) {
                        sendCallback(context, intent, 2);
                    } else if (m.j(context, stringExtra) || !com.baidu.android.pushservice.c.a.a(context, stringExtra)) {
                        sendCallback(context, intent, 4);
                    } else {
                        final a aVar = new a(context) { // from class: com.baidu.android.pushservice.PushMessageReceiver.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (this.d.get() != null) {
                                    PushMessageReceiver.this.onMessage(this.d.get(), message.getData().getString("message"), message.getData().getString("custom_content"));
                                    PushMessageReceiver.sendCallback(context, intent, 10);
                                }
                            }
                        };
                        new Thread() { // from class: com.baidu.android.pushservice.PushMessageReceiver.2
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                String[] a4 = com.baidu.android.pushservice.message.a.f.a(context, intExtra, stringExtra2, stringExtra, byteArrayExtra, byteArrayExtra2);
                                if (a4 == null || a4.length != 2) {
                                    PushMessageReceiver.sendCallback(context, intent, 9);
                                    return;
                                }
                                Message message = new Message();
                                Bundle bundle = new Bundle();
                                bundle.putString("message", a4[0]);
                                bundle.putString("custom_content", a4[1]);
                                message.setData(bundle);
                                aVar.sendMessage(message);
                                m.a("message " + a4[0] + " at time of " + System.currentTimeMillis(), context);
                            }
                        }.start();
                    }
                }
            } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.RECEIVE")) {
                String stringExtra3 = intent.getStringExtra("method");
                if (TextUtils.isEmpty(stringExtra3)) {
                    return;
                }
                int intExtra2 = intent.getIntExtra("error_msg", 0);
                String str = intent.getByteArrayExtra("content") != null ? new String(intent.getByteArrayExtra("content")) : "";
                if (stringExtra3.equals("com.baidu.android.pushservice.action.notification.ARRIVED")) {
                    String stringExtra4 = intent.getStringExtra("msgid");
                    String stringExtra5 = intent.getStringExtra("notification_title");
                    String stringExtra6 = intent.getStringExtra("notification_content");
                    String stringExtra7 = intent.getStringExtra("extra_extra_custom_content");
                    if (m.a(context, intent.getByteArrayExtra("baidu_message_secur_info"), stringExtra4, intent.getByteArrayExtra("baidu_message_body"))) {
                        onNotificationArrived(context, stringExtra5, stringExtra6, stringExtra7);
                    }
                } else if (stringExtra3.equals("method_bind")) {
                    if (intExtra2 != 0 || TextUtils.isEmpty(str)) {
                        onBind(context, intExtra2, null, null, null, null);
                        m.a("onBind from " + context.getPackageName() + " errorCode " + intExtra2 + " errorMsg = " + str + " at time of " + System.currentTimeMillis(), context);
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String string = jSONObject.getString("request_id");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                        String string2 = jSONObject2.getString("appid");
                        PushSettings.b(context, string2);
                        String string3 = jSONObject2.getString(SharedPrefConfig.CHANNEL_ID);
                        String optString = jSONObject2.optString("new_channel_id");
                        String string4 = jSONObject2.getString("user_id");
                        long j = 0;
                        String str2 = null;
                        String str3 = null;
                        if (intent.hasExtra("real_bind")) {
                            j = System.currentTimeMillis();
                            str2 = intent.getStringExtra("access_token");
                            str3 = intent.getStringExtra("secret_key");
                        }
                        com.baidu.android.pushservice.i.i.a(context, string2, string3, optString, string, string4, j, str2, str3);
                        onBind(context, intExtra2, string2, string4, TextUtils.isEmpty(optString) ? string3 : optString, string);
                        m.a("PushMessageReceiver#onBind from " + context.getPackageName() + ", errorCode= " + intExtra2 + ", appid=  " + string2 + ", userId=" + string4 + ", channelId=" + string3 + ", newChannelId=" + optString + ", requestId=" + string + ", at time of " + System.currentTimeMillis(), context);
                        com.baidu.android.pushservice.c.c.c(context, m.c(context.getPackageName() + "," + string2 + "," + string4 + ",false," + ((int) com.baidu.android.pushservice.a.a())));
                    } catch (Exception e) {
                        onBind(context, intExtra2, null, null, null, null);
                        m.a("onBind from " + context.getPackageName() + " errorCode " + intExtra2 + " exception " + e.getMessage() + " at time of " + System.currentTimeMillis(), context);
                        new b.c(context).a(Log.getStackTraceString(e)).a();
                    }
                } else if (stringExtra3.equals("method_unbind")) {
                    try {
                        onUnbind(context, intExtra2, new JSONObject(str).getString("request_id"));
                    } catch (JSONException e2) {
                        onUnbind(context, intExtra2, null);
                        new b.c(context).a(Log.getStackTraceString(e2)).a();
                    }
                    m.a(context, false);
                    if (com.baidu.android.pushservice.b.d.k(context)) {
                        MiPushClient.unregisterPush(context);
                    }
                    if (com.baidu.android.pushservice.b.d.j(context)) {
                        String a4 = com.baidu.android.pushservice.i.i.a(context, "BD_MEIZU_PROXY_APPID_KEY");
                        String a5 = com.baidu.android.pushservice.i.i.a(context, "BD_MEIZU_PROXY_APPKEY_KEY");
                        if (!TextUtils.isEmpty(a4) && !TextUtils.isEmpty(a5)) {
                            com.meizu.cloud.pushsdk.PushManager.unRegister(context, a4, a5);
                        }
                    }
                    m.a("unbind from" + context.getPackageName() + " errorCode " + intExtra2 + " at time of " + System.currentTimeMillis(), context);
                } else if (stringExtra3.equals("method_set_tags")) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(str);
                        String string5 = jSONObject3.getString("request_id");
                        if (!TextUtils.isEmpty(jSONObject3.optString("error_msg"))) {
                            onSetTags(context, intExtra2, new ArrayList(), new ArrayList(), string5);
                            return;
                        }
                        JSONObject optJSONObject = jSONObject3.optJSONObject("response_params");
                        if (optJSONObject == null || (jSONArray = optJSONObject.getJSONArray("details")) == null) {
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject4 = jSONArray.getJSONObject(i);
                            String string6 = jSONObject4.getString("tag");
                            if (jSONObject4.getInt("result") == 0) {
                                arrayList.add(string6);
                            } else {
                                arrayList2.add(string6);
                            }
                        }
                        onSetTags(context, intExtra2, arrayList, arrayList2, string5);
                    } catch (JSONException e3) {
                        onSetTags(context, intExtra2, null, null, null);
                        new b.c(context).a(Log.getStackTraceString(e3)).a();
                    }
                } else if (!stringExtra3.equals("method_del_tags")) {
                    if (stringExtra3.equals("method_listtags")) {
                        try {
                            onListTags(context, intExtra2, intent.getStringArrayListExtra("tags_list"), new JSONObject(str).getString("request_id"));
                        } catch (JSONException e4) {
                            onListTags(context, intExtra2, null, null);
                            new b.c(context).a(Log.getStackTraceString(e4)).a();
                        }
                    }
                } else {
                    try {
                        JSONObject jSONObject5 = new JSONObject(str);
                        String string7 = jSONObject5.getString("request_id");
                        JSONObject jSONObject6 = jSONObject5.getJSONObject("response_params");
                        if (jSONObject6 == null || (jSONArray2 = jSONObject6.getJSONArray("details")) == null) {
                            return;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            JSONObject jSONObject7 = jSONArray2.getJSONObject(i2);
                            String string8 = jSONObject7.getString("tag");
                            if (jSONObject7.getInt("result") == 0) {
                                arrayList3.add(string8);
                            } else {
                                arrayList4.add(string8);
                            }
                        }
                        onDelTags(context, intExtra2, arrayList3, arrayList4, string7);
                    } catch (JSONException e5) {
                        onDelTags(context, intExtra2, null, null, null);
                        new b.c(context).a(Log.getStackTraceString(e5)).a();
                    }
                }
            } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.notification.CLICK")) {
                String stringExtra8 = intent.getStringExtra("msgid");
                String stringExtra9 = intent.getStringExtra("notification_title");
                String stringExtra10 = intent.getStringExtra("notification_content");
                String stringExtra11 = intent.getStringExtra("extra_extra_custom_content");
                String stringExtra12 = intent.getStringExtra("com.baidu.pushservice.app_id");
                int intExtra3 = intent.getIntExtra("proxy_mode", 0);
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("baidu_message_secur_info");
                byte[] byteArrayExtra4 = intent.getByteArrayExtra("baidu_message_body");
                if (intExtra3 == 5) {
                    if (f.a(context.getApplicationContext(), intent.getStringExtra("proxy_sign_info"), intent.getStringExtra("proxy_check_info"))) {
                        onNotificationClicked(context, stringExtra9, stringExtra10, stringExtra11);
                        new b.a(context).a("1").b(stringExtra8).a(System.currentTimeMillis()).b(601010L).a();
                    }
                } else if (m.a(context, stringExtra8, stringExtra12, stringExtra9, stringExtra10, stringExtra11) || m.a(context, byteArrayExtra3, stringExtra8, byteArrayExtra4)) {
                    onNotificationClicked(context, stringExtra9, stringExtra10, stringExtra11);
                    new b.a(context).a("0").b(stringExtra8).a(System.currentTimeMillis()).b(601010L).a();
                }
            } else if (TextUtils.equals(action, "com.huawei.android.push.intent.REGISTRATION")) {
                if (com.baidu.android.pushservice.b.d.l(context)) {
                    try {
                        String str4 = new String(intent.getByteArrayExtra("device_token"), "UTF-8");
                        if (TextUtils.isEmpty(str4)) {
                            return;
                        }
                        f.a(context, str4);
                    } catch (Exception e6) {
                        new b.c(context).a(Log.getStackTraceString(e6)).a();
                    }
                }
            } else if (TextUtils.equals(action, "com.huawei.intent.action.PUSH")) {
                if (com.baidu.android.pushservice.b.d.l(context)) {
                    try {
                        String str5 = new String(intent.getByteArrayExtra("selfshow_info"), "UTF-8");
                        if (TextUtils.isEmpty(str5) || (a3 = (a2 = com.baidu.android.pushservice.message.a.h.a(context, str5)).a(context)) == null || !m.j(context) || m.l(context, a2.j)) {
                            return;
                        }
                        PushServiceReceiver.a(context, a3);
                    } catch (Exception e7) {
                        new b.c(context).a(Log.getStackTraceString(e7)).a();
                    }
                }
            } else if (TextUtils.equals(action, "com.huawei.android.push.intent.RECEIVE")) {
                if (com.baidu.android.pushservice.b.d.l(context)) {
                    byte[] byteArrayExtra5 = intent.getByteArrayExtra("msg_data");
                    byte[] byteArrayExtra6 = intent.getByteArrayExtra("device_token");
                    try {
                        String str6 = new String(byteArrayExtra5, "utf-8");
                        new String(byteArrayExtra6, "utf-8");
                        com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
                        String a6 = iVar.a(context, str6);
                        if (m.j(context) && !m.l(context, iVar.j) && f.a(context, iVar.m, iVar.j + a6)) {
                            if (iVar.k == com.baidu.android.pushservice.message.a.j.MSG_TYPE_APPSTAT_COMMAND.b()) {
                                m.l(context);
                            } else if (iVar.k == com.baidu.android.pushservice.message.a.j.MSG_TYPE_PRIVATE_MESSAGE.b() || iVar.k == com.baidu.android.pushservice.message.a.j.MSG_TYPE_SINGLE_PRIVATE.b()) {
                                onMessage(context, a6, null);
                            }
                        }
                    } catch (Exception e8) {
                        new b.c(context).a(Log.getStackTraceString(e8)).a();
                    }
                }
            } else if (TextUtils.equals(action, "com.xiaomi.mipush.REGISTER")) {
                if (com.baidu.android.pushservice.b.d.k(context) && intent.hasExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE)) {
                    if (intent.getLongExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE, 0L) != 0) {
                        f.i(context);
                    } else if (intent.hasExtra(PushPatchMessageReceiver.REGID)) {
                        String stringExtra13 = intent.getStringExtra(PushPatchMessageReceiver.REGID);
                        if (TextUtils.isEmpty(stringExtra13)) {
                            return;
                        }
                        f.a(context, stringExtra13);
                    }
                }
            } else if (TextUtils.equals(action, "com.xiaomi.mipush.PUSH_MSG")) {
                if (m.b() && intent.hasExtra(PushPatchMessageReceiver.PUSH_MSG)) {
                    MiPushMessage miPushMessage = (MiPushMessage) intent.getSerializableExtra(PushPatchMessageReceiver.PUSH_MSG);
                    if (intent.hasExtra(PushPatchMessageReceiver.PUSH_MSG_TYPE)) {
                        handleXiaomiMessageCallBack(context, miPushMessage, intent.getIntExtra(PushPatchMessageReceiver.PUSH_MSG_TYPE, 0));
                    }
                }
            } else if (TextUtils.equals(action, "com.meizu.mzpush.REGISTER")) {
                if (com.baidu.android.pushservice.b.d.j(context) && intent.hasExtra("mz_register_errorcode")) {
                    String stringExtra14 = intent.getStringExtra("mz_register_errorcode");
                    if (TextUtils.isEmpty(stringExtra14) || !stringExtra14.equals(BasicPushStatus.SUCCESS_CODE)) {
                        f.j(context);
                    } else if (intent.hasExtra("mz_pushid")) {
                        String stringExtra15 = intent.getStringExtra("mz_pushid");
                        if (TextUtils.isEmpty(stringExtra15)) {
                            return;
                        }
                        f.a(context, stringExtra15);
                    }
                }
            } else if (TextUtils.equals(action, "com.meizu.mzpush.PUSH_MSG")) {
                if (m.c() && intent.hasExtra("mz_push_msg_type")) {
                    handleMeizuMessageCallBack(context, intent);
                }
            } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.OPPO_CLICK")) {
                if (m.e() || m.f() || m.g()) {
                    handleOppoMessageCallBack(context, intent);
                }
            } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.VIVO_CLICK")) {
                if (m.h()) {
                    handleVivoMessageCallBack(context, intent);
                }
            } else if (TextUtils.equals(action, "com.baidu.android.pushservice.action.CROSS_CLICK")) {
                handleCrossMessageCallBack(context, intent);
            }
        } catch (Exception e9) {
            new b.c(context).a(Log.getStackTraceString(e9)).a();
        }
    }

    public abstract void onSetTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onUnbind(Context context, int i, String str);
}
