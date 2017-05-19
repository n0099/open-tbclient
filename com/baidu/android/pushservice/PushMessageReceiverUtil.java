package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.pushservice.config.ModeConfig;
import com.baidu.android.pushservice.f.k;
import com.baidu.android.pushservice.f.p;
import com.baidu.android.pushservice.h.m;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.h.u;
import com.baidu.android.pushservice.h.v;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.message.a.l;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class PushMessageReceiverUtil {
    public static final String TAG = PushMessageReceiverUtil.class.getSimpleName();
    private static String ACTION_LAPP_RECEIVE = "com.baidu.android.pushservice.action.lapp.RECEIVE";
    private static String RECEIVER_NAME = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Handler {
        protected final WeakReference<Context> c;

        public a(Context context) {
            this.c = new WeakReference<>(context);
        }
    }

    private static String getArrayString(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (String str : list) {
                jSONArray.put(str);
            }
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.e(TAG, "getArrayString Exception: " + e);
        }
        return jSONArray.toString();
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.android.pushservice.PushMessageReceiverUtil$2] */
    public static void onReceive(final Context context, final Intent intent) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i;
        com.baidu.android.pushservice.message.i a2;
        PublicMsg a3;
        int i2;
        RECEIVER_NAME = u.c(context, context.getPackageName(), intent.getAction());
        com.baidu.android.pushservice.e.a.c(TAG, " PPushMessageReceiverUtil get onreceive : " + intent.toUri(0));
        if (intent == null || intent.getAction() == null) {
            return;
        }
        try {
            intent.getByteArrayExtra("baidu_message_secur_info");
            String action = intent.getAction();
            if (action.equals(PushConstants.ACTION_MESSAGE) || action.equals("com.baidu.android.pushservice.action.LAPP_MESSAGE")) {
                if (ModeConfig.isProxyMode(context) || intent.getExtras() == null) {
                    return;
                }
                final byte[] byteArrayExtra = intent.getByteArrayExtra("baidu_message_secur_info");
                final byte[] byteArrayExtra2 = intent.getByteArrayExtra("baidu_message_body");
                final String stringExtra = intent.getStringExtra("message_id");
                final int intExtra = intent.getIntExtra("baidu_message_type", -1);
                final String stringExtra2 = intent.getStringExtra("app_id");
                if (byteArrayExtra == null || byteArrayExtra2 == null || TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || intExtra == -1) {
                    com.baidu.android.pushservice.e.a.e(TAG, " receive message error !");
                    sendCallback(context, intent, 2);
                } else if (u.r(context, stringExtra)) {
                    com.baidu.android.pushservice.e.a.e(TAG, " receive message duplicated !");
                    sendCallback(context, intent, 4);
                } else {
                    final a aVar = new a(context) { // from class: com.baidu.android.pushservice.PushMessageReceiverUtil.1
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            if (this.c.get() != null) {
                                PushMessageReceiverUtil.sendResult(context, "onMessage", new String[]{message.getData().getString(PushConstants.EXTRA_PUSH_MESSAGE), message.getData().getString("custom_content")});
                                PushMessageReceiverUtil.sendCallback(context, intent, 10);
                            }
                        }
                    };
                    new Thread() { // from class: com.baidu.android.pushservice.PushMessageReceiverUtil.2
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            String[] a4 = com.baidu.android.pushservice.message.a.h.a(context, intExtra, stringExtra2, stringExtra, byteArrayExtra, byteArrayExtra2);
                            if (a4 == null || a4.length != 2) {
                                com.baidu.android.pushservice.e.a.e(PushMessageReceiverUtil.TAG, " check message error !");
                                PushMessageReceiverUtil.sendCallback(context, intent, 9);
                                return;
                            }
                            Message message = new Message();
                            Bundle bundle = new Bundle();
                            bundle.putString(PushConstants.EXTRA_PUSH_MESSAGE, a4[0]);
                            bundle.putString("custom_content", a4[1]);
                            message.setData(bundle);
                            aVar.sendMessage(message);
                            u.b("message " + a4[0] + " at time of " + System.currentTimeMillis(), context);
                            if (com.baidu.android.pushservice.a.b() > 0) {
                                k.b(context, stringExtra2, stringExtra, intExtra, a4[0].getBytes(), 0, com.baidu.android.pushservice.f.i.a);
                            }
                        }
                    }.start();
                }
            } else if (action.equals(PushConstants.ACTION_RECEIVE) || action.equals(ACTION_LAPP_RECEIVE)) {
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
                    if (u.a(context, intent.getStringExtra("com.baidu.pushservice.app_id"), stringExtra4, stringExtra5, stringExtra6)) {
                        sendResult(context, "onNotificationArrived", new String[]{stringExtra4, stringExtra5, stringExtra6});
                    }
                } else if (stringExtra3.equals(PushConstants.METHOD_BIND) || stringExtra3.equals("method_deal_lapp_bind_intent")) {
                    if (com.baidu.android.pushservice.a.b() > 0) {
                        p.a(context, "039905", intExtra2, str);
                    }
                    if (intExtra2 != 0 || TextUtils.isEmpty(str)) {
                        sendResult(context, "onBind", new String[]{intExtra2 + "", "", "", "", ""});
                        if (com.baidu.android.pushservice.a.b() > 0) {
                            p.a(context, "039905", -1, String.valueOf(intExtra2));
                        }
                        u.b("onBind from" + context.getPackageName() + " errorCode " + intExtra2 + " at time of " + System.currentTimeMillis(), context);
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
                        m.a(context, string2, string3, string, string4, true, u.d(context, context.getPackageName()), j, str2, str3);
                        sendResult(context, "onBind", new String[]{intExtra2 + "", string2, string4, string3, string});
                        com.baidu.android.pushservice.e.a.c(TAG, "PushMessageReceiver#onBind from" + context.getPackageName() + ", errorCode= " + intExtra2 + ", appid=  " + string2 + ", userId=" + string4 + ", channelId=" + string3 + ", requestId=" + string + ", at time of " + System.currentTimeMillis());
                        u.b("PushMessageReceiver#onBind from" + context.getPackageName() + ", errorCode= " + intExtra2 + ", appid=  " + string2 + ", userId=" + string4 + ", channelId=" + string3 + ", requestId=" + string + ", at time of " + System.currentTimeMillis(), context);
                        String b = com.baidu.android.pushservice.b.b.a(context).b(context.getPackageName() + "," + string2 + "," + string4 + ",false," + ((int) com.baidu.android.pushservice.a.a()));
                        q.f(context, b);
                        if (u.D(context)) {
                            v.a(context, context.getPackageName() + ".self_push_sync", "bindinfo", b);
                        }
                    } catch (Exception e) {
                        sendResult(context, "onBind", new String[]{intExtra2 + "", "", "", "", ""});
                        if (com.baidu.android.pushservice.a.b() > 0) {
                            p.a(context, "039905", -1, u.a(e));
                        }
                        u.b("onBind from" + context.getPackageName() + " errorCode " + intExtra2 + " at time of " + System.currentTimeMillis() + " exception " + u.a(e), context);
                    }
                } else if (stringExtra3.equals("method_unbind") || stringExtra3.equals("method_lapp_unbind")) {
                    SharedPreferences.Editor edit = context.getSharedPreferences("bindcache", 0).edit();
                    try {
                        sendResult(context, "onUnbind", new String[]{intExtra2 + "", new JSONObject(str).getString("request_id")});
                        edit.putBoolean("bind_status", false);
                        edit.commit();
                    } catch (JSONException e2) {
                        sendResult(context, "onUnbind", new String[]{intExtra2 + "", ""});
                        edit.putBoolean("bind_status", false);
                        edit.commit();
                    }
                    u.b("unbind from" + context.getPackageName() + " errorCode " + intExtra2 + " at time of " + System.currentTimeMillis(), context);
                } else if (stringExtra3.equals("method_get_lapp_bind_state")) {
                    intent.getStringExtra("secret_key");
                    intent.getBooleanExtra("lapp_bind_state", false);
                } else if (stringExtra3.equals("method_set_tags") || stringExtra3.equals("method_set_lapp_tags")) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(str);
                        String string5 = jSONObject3.getString("request_id");
                        if (!TextUtils.isEmpty(jSONObject3.optString(PushConstants.EXTRA_ERROR_CODE))) {
                            sendResult(context, "onSetTags", new String[]{intExtra2 + "", "", "", string5});
                            return;
                        }
                        JSONObject optJSONObject = jSONObject3.optJSONObject("response_params");
                        if (optJSONObject == null || (jSONArray = optJSONObject.getJSONArray("details")) == null) {
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
                            String string6 = jSONObject4.getString("tag");
                            if (jSONObject4.getInt("result") == 0) {
                                arrayList.add(string6);
                            } else {
                                arrayList2.add(string6);
                            }
                        }
                        sendResult(context, "onSetTags", new String[]{intExtra2 + "", getArrayString(arrayList), getArrayString(arrayList2), string5});
                    } catch (JSONException e3) {
                        sendResult(context, "onSetTags", new String[]{intExtra2 + "", "", "", ""});
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
                        for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                            JSONObject jSONObject7 = jSONArray2.getJSONObject(i4);
                            String string8 = jSONObject7.getString("tag");
                            if (jSONObject7.getInt("result") == 0) {
                                arrayList3.add(string8);
                            } else {
                                arrayList4.add(string8);
                            }
                        }
                        sendResult(context, "onDelTags", new String[]{intExtra2 + "", getArrayString(arrayList3), getArrayString(arrayList4), string7});
                    } catch (JSONException e4) {
                        sendResult(context, "onDelTags", new String[]{intExtra2 + "", "", "", ""});
                    }
                } else {
                    if (stringExtra3.equals("method_listtags") || stringExtra3.equals("method_list_lapp_tags")) {
                        try {
                            sendResult(context, "onListTags", new String[]{intExtra2 + "", getArrayString(intent.getStringArrayListExtra("tags_list")), new JSONObject(str).getString("request_id")});
                        } catch (JSONException e5) {
                            sendResult(context, "onListTags", new String[]{intExtra2 + "", "", ""});
                        }
                    }
                }
            } else if (action.equals("com.baidu.android.pushservice.action.notification.CLICK")) {
                String stringExtra7 = intent.getStringExtra("notification_title");
                String stringExtra8 = intent.getStringExtra("notification_content");
                String stringExtra9 = intent.getStringExtra("extra_extra_custom_content");
                if (u.a(context, intent.getStringExtra("com.baidu.pushservice.app_id"), stringExtra7, stringExtra8, stringExtra9)) {
                    sendResult(context, "onNotificationClicked", new String[]{stringExtra7, stringExtra8, stringExtra9});
                }
            } else if (action.equals("com.huawei.android.push.intent.REGISTRATION")) {
                if (ModeConfig.isHuaweiProxyMode(context)) {
                    try {
                        String str4 = new String(intent.getByteArrayExtra("device_token"), "UTF-8");
                        com.baidu.android.pushservice.e.a.c(TAG, "huawei token arrive, value=" + str4);
                        if (TextUtils.isEmpty(str4)) {
                            return;
                        }
                        f.a(context, str4);
                    } catch (Exception e6) {
                        com.baidu.android.pushservice.e.a.a(TAG, e6);
                    }
                }
            } else if (action.equals("com.huawei.intent.action.PUSH")) {
                if (ModeConfig.isHuaweiProxyMode(context)) {
                    try {
                        String str5 = new String(intent.getByteArrayExtra("selfshow_info"), "UTF-8");
                        com.baidu.android.pushservice.e.a.c(TAG, "Receive Notify Message   = " + str5);
                        if (TextUtils.isEmpty(str5) || context == null || (a3 = (a2 = com.baidu.android.pushservice.message.a.j.a(context, str5)).a(context)) == null) {
                            return;
                        }
                        if (!u.x(context)) {
                            i2 = 0;
                        } else if (u.x(context, a2.a)) {
                            i2 = 4;
                        } else {
                            PushServiceReceiverUtil.showHWNotification(context, context.getPackageName(), "com.baidu.android.pushservice.CommandService", a3);
                            i2 = 1;
                            com.baidu.android.pushservice.e.a.c(TAG, "show HWNotify Message");
                        }
                        com.baidu.android.pushservice.h.f.a(context, a2.a, i2, a2.j, a2.k + "", 1);
                    } catch (Exception e7) {
                        com.baidu.android.pushservice.e.a.a(TAG, e7);
                    }
                }
            } else if (action.equals("com.huawei.android.push.intent.RECEIVE") && ModeConfig.isHuaweiProxyMode(context)) {
                byte[] byteArrayExtra3 = intent.getByteArrayExtra("msg_data");
                byte[] byteArrayExtra4 = intent.getByteArrayExtra("device_token");
                try {
                    String str6 = new String(byteArrayExtra3, "utf-8");
                    String str7 = new String(byteArrayExtra4, "utf-8");
                    com.baidu.android.pushservice.message.i iVar = new com.baidu.android.pushservice.message.i();
                    String a4 = iVar.a(context, str6);
                    if (m.b(context, "bdpush_hwsignresult", 1) != 0) {
                        if (!u.x(context)) {
                            i = 0;
                        } else if (u.x(context, iVar.m)) {
                            i = 4;
                        } else if (iVar.n == l.MSG_TYPE_APPSTAT_COMMAND.a()) {
                            u.z(context);
                            i = 0;
                        } else if (iVar.n == l.MSG_TYPE_LBS_APPLIST_COMMAND.a()) {
                            u.A(context);
                            i = 0;
                        } else if (iVar.n == l.MSG_TYPE_PRIVATE_MESSAGE.a() || iVar.n == l.MSG_TYPE_SINGLE_PRIVATE.a()) {
                            sendResult(context, "onMessage", new String[]{a4, ""});
                            i = 0;
                            com.baidu.android.pushservice.e.a.c(TAG, "receive HWPassthrough Message");
                        } else {
                            i = 6;
                        }
                        com.baidu.android.pushservice.h.f.a(context, iVar.m, i, iVar.j, iVar.k + "", 1);
                        com.baidu.android.pushservice.e.a.c(TAG, "receive huawei passthrough message  =  " + a4 + "   DeviceToken = " + str7);
                    }
                } catch (Exception e8) {
                    com.baidu.android.pushservice.e.a.a(TAG, e8);
                }
            }
        } catch (Exception e9) {
            com.baidu.android.pushservice.e.a.c(TAG, "attack by null Serializable data and return");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendCallback(Context context, Intent intent, int i) {
        try {
            intent.putExtra("bd.cross.request.RESULT_CODE", i);
            intent.setClassName(context, "com.baidu.android.pushservice.CommandService");
            intent.putExtra("bd.cross.request.COMMAND_TYPE", "bd.cross.command.MESSAGE_ACK");
            context.startService(intent);
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a(TAG, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendResult(Context context, String str, String[] strArr) {
        String str2 = "";
        for (int i = 0; i < strArr.length; i++) {
            str2 = str2 + "!@!" + strArr[i];
        }
        if (str2.length() > 3) {
            str2 = str2.substring(3);
        }
        Intent intent = new Intent("com.baidu.tieba.secret");
        intent.setClassName(context, RECEIVER_NAME);
        intent.putExtra(PushConstants.EXTRA_METHOD, str);
        intent.putExtra(LegoListActivityConfig.PARAMS, str2);
        context.sendBroadcast(intent);
    }
}
