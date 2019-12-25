package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.pushservice.g.m;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.a.k;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {
    public static final String TAG = "PushMessageReceiver";

    /* loaded from: classes5.dex */
    private static class a extends Handler {
        protected final WeakReference<Context> d;

        public a(Context context) {
            this.d = new WeakReference<>(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
        if (l.a(intent.getByteArrayExtra("baidu_message_secur_info"), intent.getStringExtra("com.baidu.pushservice.app_id"), stringExtra, intent.getByteArrayExtra("baidu_message_body")) && !l.y(context, stringExtra)) {
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
                    return;
                }
            }
            try {
                onNotificationClicked(context, stringExtra2, stringExtra3, stringExtra5);
            } catch (Exception e2) {
            }
        }
    }

    private void handleMeizuMessageCallBack(Context context, Intent intent) {
        com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
        int intExtra = intent.getIntExtra("mz_push_msg_type", 0);
        String a2 = iVar.a(intent.getStringExtra("mz_notification_self_define_content"));
        if (!l.y(context, iVar.l) && e.a(context, iVar.o, (iVar.l + a2).replaceAll("\\\\", "")) && intExtra == b.MSG_CLICKED.a()) {
            onNotificationClicked(context, intent.getStringExtra("mz_notification_title"), intent.getStringExtra("mz_notification_content"), a2);
            m.a(context, iVar.l, "010206");
        }
    }

    private void handleOppoMessageCallBack(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("op_notification_sign");
        String stringExtra2 = intent.getStringExtra("op_notification_msg_id");
        String stringExtra3 = intent.getStringExtra("op_notification_pkg_content");
        String stringExtra4 = intent.getStringExtra("extra_extra_custom_content");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || l.y(context, stringExtra2) || !e.a(context, stringExtra, stringExtra2 + stringExtra4)) {
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
                return;
            }
        }
        try {
            onNotificationClicked(context, null, null, new JSONObject("{\"extras\":" + stringExtra4 + "}").getString("extras"));
            m.a(context, stringExtra2, "010207");
        } catch (Exception e2) {
        }
    }

    private void handleVivoMessageCallBack(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("vi_notification_title");
        String stringExtra2 = intent.getStringExtra("vi_notification_content");
        String stringExtra3 = intent.getStringExtra("vi_notification_sign");
        String stringExtra4 = intent.getStringExtra("vi_notification_msg_id");
        String stringExtra5 = intent.getStringExtra("vi_notification_pkg_content");
        String stringExtra6 = intent.getStringExtra("extra_extra_custom_content");
        if (TextUtils.isEmpty(stringExtra3) || TextUtils.isEmpty(stringExtra4) || l.y(context, stringExtra4) || !e.a(context, stringExtra3, stringExtra4 + stringExtra6)) {
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
                return;
            }
        }
        try {
            onNotificationClicked(context, stringExtra, stringExtra2, stringExtra6);
            m.a(context, stringExtra4, "010208");
        } catch (Exception e2) {
        }
    }

    private void handleXiaomiMessageCallBack(Context context, MiPushMessage miPushMessage, int i) {
        try {
            String content = miPushMessage.getContent();
            com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
            boolean msgFromXMConsole = msgFromXMConsole(content);
            if (msgFromXMConsole) {
                iVar.m = k.MSG_TYPE_SINGLE_PRIVATE.a();
            } else {
                content = iVar.b(context, content);
            }
            if (i == b.MSG_CLICKED.a() || !l.y(context, iVar.l)) {
                if (iVar.m == k.MSG_TYPE_APPSTAT_COMMAND.a()) {
                    l.A(context);
                } else if (iVar.m == k.MSG_TYPE_PRIVATE_MESSAGE.a() || iVar.m == k.MSG_TYPE_MULTI_PRIVATE.a() || iVar.m == k.MSG_TYPE_SINGLE_PRIVATE.a() || iVar.m == k.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.a() || iVar.m == k.MSG_TYPE_SINGLE_PUBLIC.a() || iVar.m == k.MSG_TYPE_MULTI_PUBLIC.a()) {
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
            m.a(context, iVar.l, "010205");
        } catch (Throwable th) {
        }
    }

    private static boolean msgFromXMConsole(String str) {
        try {
            new JSONObject(str);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCallback(Context context, Intent intent, int i) {
        try {
            if (intent.getBooleanExtra("bdpush_deliver_NO_CALLBACK", false)) {
                return;
            }
            intent.putExtra("bd.cross.request.RESULT_CODE", i);
            intent.setClass(context, CommandService.class);
            intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.MESSAGE_ACK");
            context.startService(intent);
        } catch (Exception e) {
        }
    }

    public abstract void onBind(Context context, int i, String str, String str2, String str3, String str4);

    public abstract void onDelTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onListTags(Context context, int i, List<String> list, String str);

    public abstract void onMessage(Context context, String str, String str2);

    public abstract void onNotificationArrived(Context context, String str, String str2, String str3);

    public abstract void onNotificationClicked(Context context, String str, String str2, String str3);

    /* JADX WARN: Type inference failed for: r4v194, types: [com.baidu.android.pushservice.PushMessageReceiver$2] */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        com.baidu.android.pushservice.message.i a2;
        PublicMsg a3;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            String action = intent.getAction();
            if (action.equals(PushConstants.ACTION_MESSAGE)) {
                if ((!com.baidu.android.pushservice.b.d.k(context) || com.baidu.android.pushservice.b.d.c(context)) && intent.getExtras() != null) {
                    final byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_secur_info");
                    final byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_body");
                    final String stringExtra = intent.getStringExtra("message_id");
                    final int intExtra = intent.getIntExtra("baidu_message_type", -1);
                    final String stringExtra2 = intent.getStringExtra(Constants.APP_ID);
                    if (byteArrayExtra == null || byteArrayExtra2 == null || TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || intExtra == -1) {
                        sendCallback(context, intent, 2);
                    } else if (l.t(context, stringExtra) || !com.baidu.android.pushservice.c.a.a(context, stringExtra)) {
                        sendCallback(context, intent, 4);
                    } else {
                        final a aVar = new a(context) { // from class: com.baidu.android.pushservice.PushMessageReceiver.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (this.d.get() != null) {
                                    PushMessageReceiver.this.onMessage(this.d.get(), message.getData().getString("message"), message.getData().getString("custom_content"));
                                    PushMessageReceiver.this.sendCallback(context, intent, 10);
                                }
                            }
                        };
                        new Thread() { // from class: com.baidu.android.pushservice.PushMessageReceiver.2
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                String[] a4 = com.baidu.android.pushservice.message.a.g.a(context, intExtra, stringExtra2, stringExtra, byteArrayExtra, byteArrayExtra2);
                                if (a4 == null || a4.length != 2) {
                                    PushMessageReceiver.this.sendCallback(context, intent, 9);
                                    return;
                                }
                                Message message = new Message();
                                Bundle bundle = new Bundle();
                                bundle.putString("message", a4[0]);
                                bundle.putString("custom_content", a4[1]);
                                message.setData(bundle);
                                aVar.sendMessage(message);
                                l.b("message " + a4[0] + " at time of " + System.currentTimeMillis(), context);
                            }
                        }.start();
                    }
                }
            } else if (action.equals(PushConstants.ACTION_RECEIVE)) {
                String stringExtra3 = intent.getStringExtra("method");
                if (TextUtils.isEmpty(stringExtra3)) {
                    return;
                }
                int intExtra2 = intent.getIntExtra(PushConstants.EXTRA_ERROR_CODE, 0);
                String str = intent.getByteArrayExtra("content") != null ? new String(intent.getByteArrayExtra("content")) : "";
                if (stringExtra3.equals("com.baidu.android.pushservice.action.notification.ARRIVED")) {
                    String stringExtra4 = intent.getStringExtra("msgid");
                    String stringExtra5 = intent.getStringExtra("notification_title");
                    String stringExtra6 = intent.getStringExtra("notification_content");
                    String stringExtra7 = intent.getStringExtra("extra_extra_custom_content");
                    if (l.a(context, intent.getByteArrayExtra("baidu_message_secur_info"), intent.getStringExtra("com.baidu.pushservice.app_id"), stringExtra4, intent.getByteArrayExtra("baidu_message_body"))) {
                        onNotificationArrived(context, stringExtra5, stringExtra6, stringExtra7);
                    }
                } else if (stringExtra3.equals(PushConstants.METHOD_BIND)) {
                    if (intExtra2 != 0 || TextUtils.isEmpty(str)) {
                        onBind(context, intExtra2, null, null, null, null);
                        m.a(context, "020102", context.getPackageName(), intExtra2, str);
                        l.b("onBind from " + context.getPackageName() + " errorCode " + intExtra2 + " errorMsg = " + str + " at time of " + System.currentTimeMillis(), context);
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String string = jSONObject.getString("request_id");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                        String string2 = jSONObject2.getString("appid");
                        PushSettings.a(context, string2);
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
                        com.baidu.android.pushservice.i.i.a(context, string2, string3, optString, string, string4, true, l.d(context, context.getPackageName()), j, str2, str3);
                        onBind(context, intExtra2, string2, string4, TextUtils.isEmpty(optString) ? string3 : optString, string);
                        l.b("PushMessageReceiver#onBind from " + context.getPackageName() + ", errorCode= " + intExtra2 + ", appid=  " + string2 + ", userId=" + string4 + ", channelId=" + string3 + ", newChannelId=" + optString + ", requestId=" + string + ", at time of " + System.currentTimeMillis(), context);
                        String b2 = com.baidu.android.pushservice.a.b.a(context).b(context.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SP + string2 + Constants.ACCEPT_TIME_SEPARATOR_SP + string4 + Constants.ACCEPT_TIME_SEPARATOR_SP + "false" + Constants.ACCEPT_TIME_SEPARATOR_SP + ((int) com.baidu.android.pushservice.a.a()));
                        com.baidu.android.pushservice.c.c.c(context, b2);
                        if (l.C(context)) {
                            com.baidu.android.pushservice.i.m.a(context, context.getPackageName() + ".self_push_sync", "bindinfo", b2);
                        }
                    } catch (Exception e) {
                        onBind(context, intExtra2, null, null, null, null);
                        m.a(context, "020102", context.getPackageName(), intExtra2, e.getMessage());
                        l.b("onBind from " + context.getPackageName() + " errorCode " + intExtra2 + " exception " + e.getMessage() + " at time of " + System.currentTimeMillis(), context);
                    }
                } else if (stringExtra3.equals("method_unbind")) {
                    SharedPreferences.Editor edit = context.getSharedPreferences("bindcache", 0).edit();
                    try {
                        onUnbind(context, intExtra2, new JSONObject(str).getString("request_id"));
                        edit.putBoolean("bind_status", false);
                        edit.commit();
                    } catch (JSONException e2) {
                        onUnbind(context, intExtra2, null);
                        edit.putBoolean("bind_status", false);
                        edit.commit();
                    }
                    if (com.baidu.android.pushservice.b.d.e(context)) {
                        MiPushClient.unregisterPush(context);
                    }
                    if (com.baidu.android.pushservice.b.d.d(context)) {
                        String a4 = com.baidu.android.pushservice.i.i.a(context, "BD_MEIZU_PROXY_APPID_KEY");
                        String a5 = com.baidu.android.pushservice.i.i.a(context, "BD_MEIZU_PROXY_APPKEY_KEY");
                        if (!TextUtils.isEmpty(a4) && !TextUtils.isEmpty(a5)) {
                            com.meizu.cloud.pushsdk.PushManager.unRegister(context, a4, a5);
                        }
                    }
                    l.b("unbind from" + context.getPackageName() + " errorCode " + intExtra2 + " at time of " + System.currentTimeMillis(), context);
                } else if (stringExtra3.equals("method_set_tags")) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(str);
                        String string5 = jSONObject3.getString("request_id");
                        if (!TextUtils.isEmpty(jSONObject3.optString(PushConstants.EXTRA_ERROR_CODE))) {
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
                    }
                } else if (!stringExtra3.equals("method_del_tags")) {
                    if (stringExtra3.equals("method_listtags")) {
                        try {
                            onListTags(context, intExtra2, intent.getStringArrayListExtra("tags_list"), new JSONObject(str).getString("request_id"));
                        } catch (JSONException e4) {
                            onListTags(context, intExtra2, null, null);
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
                    }
                }
            } else if (action.equals("com.baidu.android.pushservice.action.notification.CLICK")) {
                String stringExtra8 = intent.getStringExtra("msgid");
                String stringExtra9 = intent.getStringExtra("notification_title");
                String stringExtra10 = intent.getStringExtra("notification_content");
                String stringExtra11 = intent.getStringExtra("extra_extra_custom_content");
                String stringExtra12 = intent.getStringExtra("com.baidu.pushservice.app_id");
                int intExtra3 = intent.getIntExtra("proxy_mode", 0);
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("baidu_message_secur_info");
                byte[] byteArrayExtra4 = intent.getByteArrayExtra("baidu_message_body");
                if (intExtra3 == 5) {
                    if (e.a(context.getApplicationContext(), intent.getStringExtra("proxy_sign_info"), intent.getStringExtra("proxy_check_info"))) {
                        onNotificationClicked(context, stringExtra9, stringExtra10, stringExtra11);
                        m.a(context, stringExtra8, "010203");
                    }
                } else if (l.a(context, stringExtra8, stringExtra12, stringExtra9, stringExtra10, stringExtra11) || l.a(context, byteArrayExtra3, stringExtra12, stringExtra8, byteArrayExtra4)) {
                    onNotificationClicked(context, stringExtra9, stringExtra10, stringExtra11);
                }
            } else if (action.equals("com.huawei.android.push.intent.REGISTRATION")) {
                if (com.baidu.android.pushservice.b.d.f(context)) {
                    try {
                        String str4 = new String(intent.getByteArrayExtra("device_token"), "UTF-8");
                        if (TextUtils.isEmpty(str4)) {
                            return;
                        }
                        e.a(context, str4);
                    } catch (Exception e6) {
                    }
                }
            } else if (action.equals("com.huawei.intent.action.PUSH")) {
                if (com.baidu.android.pushservice.b.d.f(context)) {
                    try {
                        String str5 = new String(intent.getByteArrayExtra("selfshow_info"), "UTF-8");
                        if (TextUtils.isEmpty(str5) || (a3 = (a2 = com.baidu.android.pushservice.message.a.i.a(context, str5)).a(context)) == null || !l.y(context) || l.y(context, a2.l)) {
                            return;
                        }
                        PushServiceReceiver.a(context, context.getPackageName(), "com.baidu.android.pushservice.CommandService", a3);
                    } catch (Exception e7) {
                    }
                }
            } else if (action.equals("com.huawei.android.push.intent.RECEIVE")) {
                if (com.baidu.android.pushservice.b.d.f(context)) {
                    byte[] byteArrayExtra5 = intent.getByteArrayExtra("msg_data");
                    byte[] byteArrayExtra6 = intent.getByteArrayExtra("device_token");
                    try {
                        String str6 = new String(byteArrayExtra5, "utf-8");
                        new String(byteArrayExtra6, "utf-8");
                        com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
                        String a6 = iVar.a(context, str6);
                        if (l.y(context) && !l.y(context, iVar.l) && e.a(context, iVar.o, iVar.l + a6)) {
                            if (iVar.m == k.MSG_TYPE_APPSTAT_COMMAND.a()) {
                                l.A(context);
                            } else if (iVar.m == k.MSG_TYPE_PRIVATE_MESSAGE.a() || iVar.m == k.MSG_TYPE_SINGLE_PRIVATE.a()) {
                                onMessage(context, a6, null);
                            }
                        }
                    } catch (Exception e8) {
                    }
                }
            } else if (action.equals("com.xiaomi.mipush.REGISTER")) {
                if (com.baidu.android.pushservice.b.d.e(context) && intent.hasExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE)) {
                    if (intent.getLongExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE, 0L) != 0) {
                        e.g(context);
                    } else if (intent.hasExtra(PushPatchMessageReceiver.REGID)) {
                        String stringExtra13 = intent.getStringExtra(PushPatchMessageReceiver.REGID);
                        if (TextUtils.isEmpty(stringExtra13)) {
                            return;
                        }
                        e.a(context, stringExtra13);
                    }
                }
            } else if (action.equals("com.xiaomi.mipush.PUSH_MSG")) {
                if (l.a() && intent.hasExtra(PushPatchMessageReceiver.PUSH_MSG)) {
                    MiPushMessage miPushMessage = (MiPushMessage) intent.getSerializableExtra(PushPatchMessageReceiver.PUSH_MSG);
                    if (intent.hasExtra(PushPatchMessageReceiver.PUSH_MSG_TYPE)) {
                        handleXiaomiMessageCallBack(context, miPushMessage, intent.getIntExtra(PushPatchMessageReceiver.PUSH_MSG_TYPE, 0));
                    }
                }
            } else if (action.equals("com.meizu.mzpush.REGISTER")) {
                if (com.baidu.android.pushservice.b.d.d(context) && intent.hasExtra("mz_register_errorcode")) {
                    String stringExtra14 = intent.getStringExtra("mz_register_errorcode");
                    if (TextUtils.isEmpty(stringExtra14) || !stringExtra14.equals(BasicPushStatus.SUCCESS_CODE)) {
                        e.h(context);
                    } else if (intent.hasExtra("mz_pushid")) {
                        String stringExtra15 = intent.getStringExtra("mz_pushid");
                        if (TextUtils.isEmpty(stringExtra15)) {
                            return;
                        }
                        e.a(context, stringExtra15);
                    }
                }
            } else if (action.equals("com.meizu.mzpush.PUSH_MSG")) {
                if (l.b() && intent.hasExtra("mz_push_msg_type")) {
                    handleMeizuMessageCallBack(context, intent);
                }
            } else if (action.equals("com.baidu.android.pushservice.action.OPPO_CLICK")) {
                if (l.d()) {
                    handleOppoMessageCallBack(context, intent);
                }
            } else if (action.equals("com.baidu.android.pushservice.action.VIVO_CLICK")) {
                if (l.e()) {
                    handleVivoMessageCallBack(context, intent);
                }
            } else if (action.equals("com.baidu.android.pushservice.action.CROSS_CLICK")) {
                handleCrossMessageCallBack(context, intent);
            }
        } catch (Exception e9) {
        }
    }

    public abstract void onSetTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onUnbind(Context context, int i, String str);
}
