package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.k;
import com.baidu.android.pushservice.h.p;
import com.baidu.android.pushservice.j.n;
import com.baidu.android.pushservice.j.q;
import com.baidu.android.pushservice.j.r;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.a.l;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {
    public static final String TAG = PushMessageReceiver.class.getSimpleName();

    /* loaded from: classes2.dex */
    private static class a extends Handler {
        protected final WeakReference<Context> d;

        public a(Context context) {
            this.d = new WeakReference<>(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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

    private void handleXiaomiMessageCallBack(Context context, MiPushMessage miPushMessage, int i) {
        int i2 = 0;
        try {
            String content = miPushMessage.getContent();
            com.baidu.android.pushservice.g.a.b(TAG, "XM> " + content);
            com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
            boolean msgFromXMConsole = msgFromXMConsole(content);
            if (msgFromXMConsole) {
                com.baidu.android.pushservice.g.a.b(TAG, "XM> msgFromXmConsole=true-----------------");
                iVar.n = l.MSG_TYPE_SINGLE_PRIVATE.a();
            } else {
                content = iVar.b(context, content);
            }
            if (q.x(context)) {
                if (i != b.MSG_CLICKED.a() && q.y(context, iVar.m)) {
                    i2 = 4;
                    com.baidu.android.pushservice.g.a.d(TAG, "XM> msgid is duplicated!!! msgid=" + iVar.m);
                } else if (iVar.n == l.MSG_TYPE_APPSTAT_COMMAND.a()) {
                    q.z(context);
                } else if (iVar.n == l.MSG_TYPE_LBS_APPLIST_COMMAND.a()) {
                    q.A(context);
                } else if (iVar.n == l.MSG_TYPE_PRIVATE_MESSAGE.a() || iVar.n == l.MSG_TYPE_MULTI_PRIVATE.a() || iVar.n == l.MSG_TYPE_SINGLE_PRIVATE.a() || iVar.n == l.MSG_TYPE_MULTI_PRIVATE_NOTIFICATION.a() || iVar.n == l.MSG_TYPE_SINGLE_PUBLIC.a() || iVar.n == l.MSG_TYPE_MULTI_PUBLIC.a()) {
                    if (i == b.MSG_PASS.a()) {
                        onMessage(context, content, null);
                        com.baidu.android.pushservice.g.a.b(TAG, "XM> onMessage call back-----------------");
                    } else if (i == b.MSG_ARRIVED.a()) {
                        onNotificationArrived(context, miPushMessage.getTitle(), miPushMessage.getDescription(), content);
                        com.baidu.android.pushservice.g.a.b(TAG, "XM> onNotificationArrived call back-----------------");
                    } else if (i == b.MSG_CLICKED.a()) {
                        onNotificationClicked(context, miPushMessage.getTitle(), miPushMessage.getDescription(), content);
                        com.baidu.android.pushservice.g.a.b(TAG, "XM> onNotificationClicked call back-----------------");
                    }
                    if (i != b.MSG_PASS.a()) {
                        i2 = 1;
                    }
                } else {
                    com.baidu.android.pushservice.g.a.b(TAG, "XM> pXmMsg.exType is unknow-----------------");
                    i2 = 6;
                }
            }
            if (msgFromXMConsole) {
                return;
            }
            if (i == b.MSG_PASS.a()) {
                com.baidu.android.pushservice.j.f.a(context, iVar.m, i2, iVar.j, iVar.k + "", 2);
            } else if (i == b.MSG_ARRIVED.a()) {
                com.baidu.android.pushservice.j.f.a(context, iVar.m, i2, iVar.j, iVar.k + "", 2);
            } else if (i == b.MSG_CLICKED.a()) {
                com.baidu.android.pushservice.j.f.a(context, iVar.m, iVar.j, iVar.k + "", 2);
            }
        } catch (Throwable th) {
            com.baidu.android.pushservice.g.a.a(TAG, th);
        }
    }

    private static boolean msgFromXMConsole(String str) {
        try {
            if (new JSONObject(str) == null) {
                com.baidu.android.pushservice.g.a.d(TAG, "msg from xiaomi platform!!!!");
                return true;
            }
            return false;
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.d(TAG, "msg from xiaomi platform!!!!");
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
            com.baidu.android.pushservice.g.a.a(TAG, e);
        }
    }

    public abstract void onBind(Context context, int i, String str, String str2, String str3, String str4);

    public abstract void onDelTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onListTags(Context context, int i, List<String> list, String str);

    public abstract void onMessage(Context context, String str, String str2);

    public abstract void onNotificationArrived(Context context, String str, String str2, String str3);

    public abstract void onNotificationClicked(Context context, String str, String str2, String str3);

    /* JADX WARN: Type inference failed for: r4v187, types: [com.baidu.android.pushservice.PushMessageReceiver$2] */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        int i;
        com.baidu.android.pushservice.message.i a2;
        PublicMsg a3;
        int i2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            String action = intent.getAction();
            if (action.equals(PushConstants.ACTION_MESSAGE)) {
                if (com.baidu.android.pushservice.c.d.d(context)) {
                    return;
                }
                if (!q.x(context)) {
                    com.baidu.android.pushservice.g.a.c(TAG, "current unbind in client,unbind again");
                    f.f(context);
                } else if (intent.getExtras() != null) {
                    final byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_secur_info");
                    final byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_body");
                    final String stringExtra = intent.getStringExtra("message_id");
                    final int intExtra = intent.getIntExtra("baidu_message_type", -1);
                    final String stringExtra2 = intent.getStringExtra("app_id");
                    if (byteArrayExtra == null || byteArrayExtra2 == null || TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || intExtra == -1) {
                        com.baidu.android.pushservice.g.a.e(TAG, " receive message error !" + (byteArrayExtra == null) + " " + (byteArrayExtra2 == null) + "  msgId: " + stringExtra + " appId: " + stringExtra2 + " msgType: " + intExtra);
                        sendCallback(context, intent, 2);
                    } else if (q.s(context, stringExtra) || !com.baidu.android.pushservice.d.a.e(context, stringExtra)) {
                        com.baidu.android.pushservice.g.a.e(TAG, " receive message duplicated !");
                        sendCallback(context, intent, 4);
                    } else {
                        final a aVar = new a(context) { // from class: com.baidu.android.pushservice.PushMessageReceiver.1
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                if (this.d.get() != null) {
                                    PushMessageReceiver.this.onMessage(this.d.get(), message.getData().getString(PushConstants.EXTRA_PUSH_MESSAGE), message.getData().getString("custom_content"));
                                    PushMessageReceiver.this.sendCallback(context, intent, 10);
                                }
                            }
                        };
                        new Thread() { // from class: com.baidu.android.pushservice.PushMessageReceiver.2
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                String[] a4 = com.baidu.android.pushservice.message.a.h.a(context, intExtra, stringExtra2, stringExtra, byteArrayExtra, byteArrayExtra2);
                                if (a4 == null || a4.length != 2) {
                                    com.baidu.android.pushservice.g.a.e(PushMessageReceiver.TAG, " check message error !");
                                    PushMessageReceiver.this.sendCallback(context, intent, 9);
                                    return;
                                }
                                Message message = new Message();
                                Bundle bundle = new Bundle();
                                bundle.putString(PushConstants.EXTRA_PUSH_MESSAGE, a4[0]);
                                bundle.putString("custom_content", a4[1]);
                                message.setData(bundle);
                                aVar.sendMessage(message);
                                q.b("message " + a4[0] + " at time of " + System.currentTimeMillis(), context);
                                if (com.baidu.android.pushservice.a.b() > 0) {
                                    k.b(context, stringExtra2, stringExtra, intExtra, a4[0].getBytes(), 0, com.baidu.android.pushservice.h.i.a);
                                }
                            }
                        }.start();
                    }
                }
            } else if (action.equals(PushConstants.ACTION_RECEIVE)) {
                String stringExtra3 = intent.getStringExtra(PushConstants.EXTRA_METHOD);
                if (TextUtils.isEmpty(stringExtra3)) {
                    return;
                }
                int intExtra2 = intent.getIntExtra(PushConstants.EXTRA_ERROR_CODE, 0);
                String str = intent.getByteArrayExtra("content") != null ? new String(intent.getByteArrayExtra("content")) : "";
                if (stringExtra3.equals("com.baidu.android.pushservice.action.notification.ARRIVED")) {
                    String stringExtra4 = intent.getStringExtra("notification_title");
                    String stringExtra5 = intent.getStringExtra("notification_content");
                    String stringExtra6 = intent.getStringExtra("extra_extra_custom_content");
                    if (q.a(context, intent.getStringExtra("com.baidu.pushservice.app_id"), stringExtra4, stringExtra5, stringExtra6)) {
                        onNotificationArrived(context, stringExtra4, stringExtra5, stringExtra6);
                    }
                } else if (stringExtra3.equals(PushConstants.METHOD_BIND) || stringExtra3.equals("method_deal_lapp_bind_intent")) {
                    if (com.baidu.android.pushservice.a.b() > 0) {
                        p.a(context, "039905", intExtra2, str);
                    }
                    if (intExtra2 != 0 || TextUtils.isEmpty(str)) {
                        onBind(context, intExtra2, null, null, null, null);
                        if (com.baidu.android.pushservice.a.b() > 0) {
                            p.a(context, "039905", -1, String.valueOf(intExtra2));
                        }
                        q.b("onBind from" + context.getPackageName() + " errorCode " + intExtra2 + " at time of " + System.currentTimeMillis(), context);
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String string = jSONObject.getString("request_id");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("response_params");
                        String string2 = jSONObject2.getString("appid");
                        PushSettings.b(context, string2);
                        String string3 = jSONObject2.getString("channel_id");
                        String string4 = jSONObject2.getString("user_id");
                        long j = 0;
                        String str2 = null;
                        String str3 = null;
                        if (intent.hasExtra("real_bind")) {
                            j = System.currentTimeMillis();
                            str2 = intent.getStringExtra("access_token");
                            str3 = intent.getStringExtra("secret_key");
                        }
                        n.a(context, string2, string3, string, string4, true, q.d(context, context.getPackageName()), j, str2, str3);
                        onBind(context, intExtra2, string2, string4, string3, string);
                        com.baidu.android.pushservice.g.a.c(TAG, "PushMessageReceiver#onBind from" + context.getPackageName() + ", errorCode= " + intExtra2 + ", appid=  " + string2 + ", userId=" + string4 + ", channelId=" + string3 + ", requestId=" + string + ", at time of " + System.currentTimeMillis());
                        q.b("PushMessageReceiver#onBind from" + context.getPackageName() + ", errorCode= " + intExtra2 + ", appid=  " + string2 + ", userId=" + string4 + ", channelId=" + string3 + ", requestId=" + string + ", at time of " + System.currentTimeMillis(), context);
                        String b2 = com.baidu.android.pushservice.b.b.a(context).b(context.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SP + string2 + Constants.ACCEPT_TIME_SEPARATOR_SP + string4 + Constants.ACCEPT_TIME_SEPARATOR_SP + "false" + Constants.ACCEPT_TIME_SEPARATOR_SP + ((int) com.baidu.android.pushservice.a.a()));
                        com.baidu.android.pushservice.d.c.f(context, b2);
                        if (q.D(context)) {
                            r.a(context, context.getPackageName() + ".self_push_sync", "bindinfo", b2);
                        }
                    } catch (Exception e) {
                        onBind(context, intExtra2, null, null, null, null);
                        if (com.baidu.android.pushservice.a.b() > 0) {
                            p.a(context, "039905", -1, q.a(e));
                        }
                        q.b("onBind from" + context.getPackageName() + " errorCode " + intExtra2 + " at time of " + System.currentTimeMillis() + " exception " + q.a(e), context);
                    }
                } else if (stringExtra3.equals("method_unbind") || stringExtra3.equals("method_lapp_unbind")) {
                    SharedPreferences.Editor edit = context.getSharedPreferences("bindcache", 0).edit();
                    int i3 = !com.baidu.android.pushservice.c.d.d(context) ? 0 : intExtra2;
                    try {
                        onUnbind(context, i3, new JSONObject(str).getString("request_id"));
                        edit.putBoolean("bind_status", false);
                        edit.commit();
                    } catch (JSONException e2) {
                        onUnbind(context, i3, null);
                        edit.putBoolean("bind_status", false);
                        edit.commit();
                    }
                    com.baidu.android.pushservice.g.a.c(TAG, "set bind_status = false");
                    if (com.baidu.android.pushservice.c.d.b(context)) {
                        MiPushClient.unregisterPush(context);
                        com.baidu.android.pushservice.g.a.b(TAG, "XM> MiPushClient.unregisterPush is call!!!");
                    }
                    q.b("unbind from" + context.getPackageName() + " errorCode " + i3 + " at time of " + System.currentTimeMillis(), context);
                } else if (stringExtra3.equals("method_set_tags") || stringExtra3.equals("method_set_lapp_tags")) {
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
                        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                            JSONObject jSONObject4 = jSONArray.getJSONObject(i4);
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
                } else if (stringExtra3.equals("method_del_tags") || stringExtra3.equals("method_del_lapp_tags")) {
                    try {
                        JSONObject jSONObject5 = new JSONObject(str);
                        String string7 = jSONObject5.getString("request_id");
                        JSONObject jSONObject6 = jSONObject5.getJSONObject("response_params");
                        if (jSONObject6 == null || (jSONArray2 = jSONObject6.getJSONArray("details")) == null) {
                            return;
                        }
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                            JSONObject jSONObject7 = jSONArray2.getJSONObject(i5);
                            String string8 = jSONObject7.getString("tag");
                            if (jSONObject7.getInt("result") == 0) {
                                arrayList3.add(string8);
                            } else {
                                arrayList4.add(string8);
                            }
                        }
                        onDelTags(context, intExtra2, arrayList3, arrayList4, string7);
                    } catch (JSONException e4) {
                        onDelTags(context, intExtra2, null, null, null);
                    }
                } else {
                    if (stringExtra3.equals("method_listtags") || stringExtra3.equals("method_list_lapp_tags")) {
                        try {
                            onListTags(context, intExtra2, intent.getStringArrayListExtra("tags_list"), new JSONObject(str).getString("request_id"));
                        } catch (JSONException e5) {
                            onListTags(context, intExtra2, null, null);
                        }
                    }
                }
            } else if (action.equals("com.baidu.android.pushservice.action.notification.CLICK")) {
                String stringExtra7 = intent.getStringExtra("notification_title");
                String stringExtra8 = intent.getStringExtra("notification_content");
                String stringExtra9 = intent.getStringExtra("extra_extra_custom_content");
                if (q.a(context, intent.getStringExtra("com.baidu.pushservice.app_id"), stringExtra7, stringExtra8, stringExtra9)) {
                    onNotificationClicked(context, stringExtra7, stringExtra8, stringExtra9);
                }
            } else if (action.equals("com.huawei.android.push.intent.REGISTRATION")) {
                if (com.baidu.android.pushservice.c.d.c(context)) {
                    try {
                        String str4 = new String(intent.getByteArrayExtra("device_token"), "UTF-8");
                        com.baidu.android.pushservice.g.a.c(TAG, "huawei token arrive, value=" + str4);
                        if (TextUtils.isEmpty(str4)) {
                            return;
                        }
                        f.a(context, str4);
                    } catch (Exception e6) {
                        com.baidu.android.pushservice.g.a.a(TAG, e6);
                    }
                }
            } else if (action.equals("com.huawei.intent.action.PUSH")) {
                if (com.baidu.android.pushservice.c.d.c(context)) {
                    try {
                        String str5 = new String(intent.getByteArrayExtra("selfshow_info"), "UTF-8");
                        com.baidu.android.pushservice.g.a.c(TAG, "Receive Notify Message   = " + str5);
                        if (TextUtils.isEmpty(str5) || context == null || (a3 = (a2 = com.baidu.android.pushservice.message.a.j.a(context, str5)).a(context)) == null) {
                            return;
                        }
                        if (!q.x(context)) {
                            i2 = 0;
                        } else if (q.y(context, a2.a)) {
                            i2 = 4;
                        } else {
                            PushServiceReceiver.a(context, context.getPackageName(), "com.baidu.android.pushservice.CommandService", a3);
                            i2 = 1;
                            com.baidu.android.pushservice.g.a.c(TAG, "show HWNotify Message");
                        }
                        com.baidu.android.pushservice.j.f.a(context, a2.a, i2, a2.j, a2.k + "", 1);
                    } catch (Exception e7) {
                        com.baidu.android.pushservice.g.a.a(TAG, e7);
                    }
                }
            } else if (action.equals("com.huawei.android.push.intent.RECEIVE")) {
                if (com.baidu.android.pushservice.c.d.c(context)) {
                    byte[] byteArrayExtra3 = intent.getByteArrayExtra("msg_data");
                    byte[] byteArrayExtra4 = intent.getByteArrayExtra("device_token");
                    try {
                        String str6 = new String(byteArrayExtra3, "utf-8");
                        String str7 = new String(byteArrayExtra4, "utf-8");
                        com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
                        String a4 = iVar.a(context, str6);
                        if (n.b(context, "bdpush_hwsignresult", 1) != 0) {
                            if (!q.x(context)) {
                                i = 0;
                            } else if (q.y(context, iVar.m)) {
                                i = 4;
                            } else if (iVar.n == l.MSG_TYPE_APPSTAT_COMMAND.a()) {
                                q.z(context);
                                i = 0;
                            } else if (iVar.n == l.MSG_TYPE_LBS_APPLIST_COMMAND.a()) {
                                q.A(context);
                                i = 0;
                            } else if (iVar.n == l.MSG_TYPE_PRIVATE_MESSAGE.a() || iVar.n == l.MSG_TYPE_SINGLE_PRIVATE.a()) {
                                onMessage(context, a4, null);
                                i = 0;
                                com.baidu.android.pushservice.g.a.c(TAG, "receive HWPassthrough Message");
                            } else {
                                i = 6;
                            }
                            com.baidu.android.pushservice.j.f.a(context, iVar.m, i, iVar.j, iVar.k + "", 1);
                            com.baidu.android.pushservice.g.a.c(TAG, "receive huawei passthrough message  =  " + a4 + "   DeviceToken = " + str7);
                        }
                    } catch (Exception e8) {
                        com.baidu.android.pushservice.g.a.a(TAG, e8);
                    }
                }
            } else if (!action.equals(PushPatchMessageReceiver.XIAOMI_REGISTER)) {
                if (action.equals(PushPatchMessageReceiver.XIAOMI_PUSH_MSG)) {
                    if (!com.baidu.android.pushservice.c.d.b(context)) {
                        com.baidu.android.pushservice.g.a.d(TAG, "XM> not xiaomi proxy mode! ");
                    } else if (intent.hasExtra(PushPatchMessageReceiver.PUSH_MSG)) {
                        MiPushMessage miPushMessage = (MiPushMessage) intent.getSerializableExtra(PushPatchMessageReceiver.PUSH_MSG);
                        if (intent.hasExtra(PushPatchMessageReceiver.PUSH_MSG_TYPE)) {
                            handleXiaomiMessageCallBack(context, miPushMessage, intent.getIntExtra(PushPatchMessageReceiver.PUSH_MSG_TYPE, 0));
                        }
                    }
                }
            } else if (!com.baidu.android.pushservice.c.d.b(context)) {
                com.baidu.android.pushservice.g.a.d(TAG, "XM> not xiaomi proxy mode! ");
            } else if (intent.hasExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE)) {
                long longExtra = intent.getLongExtra(PushPatchMessageReceiver.REGISTER_ERRORCODE, 0L);
                if (longExtra != 0) {
                    f.h(context);
                    com.baidu.android.pushservice.g.a.c(TAG, "XIAOMI Register Failed, ErrorCode = " + longExtra);
                } else if (intent.hasExtra(PushPatchMessageReceiver.REGID)) {
                    String stringExtra10 = intent.getStringExtra(PushPatchMessageReceiver.REGID);
                    if (TextUtils.isEmpty(stringExtra10)) {
                        com.baidu.android.pushservice.g.a.c(TAG, "bindForProxy RegId =  NULL");
                        return;
                    }
                    com.baidu.android.pushservice.g.a.c(TAG, "bindForProxy RegId = " + stringExtra10);
                    f.a(context, stringExtra10);
                }
            }
        } catch (Exception e9) {
            com.baidu.android.pushservice.g.a.c(TAG, "attack by null Serializable data and return");
        }
    }

    public abstract void onSetTags(Context context, int i, List<String> list, List<String> list2, String str);

    public abstract void onUnbind(Context context, int i, String str);
}
