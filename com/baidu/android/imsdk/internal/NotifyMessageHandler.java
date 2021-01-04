package com.baidu.android.imsdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.Type;
import com.baidu.android.imsdk.chatmessage.sync.Generator;
import com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class NotifyMessageHandler {
    private static final String TAG = "NotifyMessageHandler";

    /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void handleDeliverMessage(Context context, JSONObject jSONObject) throws JSONException {
        long j;
        SyncStrategy generate;
        LogUtils.i(TAG, "handleMessage Deliver:" + jSONObject.toString());
        int i = jSONObject.getInt("category");
        if (i == 0 && jSONObject.has("msgid")) {
            try {
                j = jSONObject.getLong("msgid");
            } catch (JSONException e) {
                LogUtils.i(TAG, "JSONException:" + e.getMessage());
            }
            if (i != 0 || i == 2) {
                generate = Generator.generate(context, 5);
                if (generate == null) {
                    if (j != -1) {
                        generate.start(2, j);
                        return;
                    } else {
                        generate.start(2);
                        return;
                    }
                }
                return;
            } else if (i == 1) {
                long j2 = jSONObject.getLong("contacter");
                long j3 = jSONObject.getLong("msgid");
                LogUtils.i(TAG, "msgid : " + j3);
                SyncGroupMessageService.getInstance().execute(context, i, j2, j3, 2);
                return;
            } else {
                LogUtils.e(TAG, "handleDeliverMessage category error!!");
                return;
            }
        }
        j = -1;
        if (i != 0) {
        }
        generate = Generator.generate(context, 5);
        if (generate == null) {
        }
    }

    public static void handleMcastMessage(final Context context, final JSONObject jSONObject) throws JSONException {
        LogUtils.i(TAG, "handleMessage mcast:" + jSONObject.toString());
        if (jSONObject.has("mcast_id")) {
            jSONObject.getLong("mcast_id");
        } else {
            LogUtils.e(TAG, "handleMcastMessage cast error!!");
        }
        TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.internal.NotifyMessageHandler.1
            @Override // java.lang.Runnable
            public void run() {
                ConversationStudioManImpl.getInstance(context).handleMessage(jSONObject);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Long] */
    public static void handleConfigMessage(Context context, JSONObject jSONObject) throws JSONException {
        LogUtils.i(TAG, "handleMessage Config:" + jSONObject.toString());
        JSONArray jSONArray = new JSONArray();
        ArrayList<ChatMsg> arrayList = null;
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray("messages");
            for (int i = 0; i < jSONArray2.length(); i++) {
                jSONArray.put(jSONArray2.getJSONObject(i));
            }
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
        }
        if (jSONArray.length() != 0) {
            Type type = new Type();
            type.t = 0L;
            arrayList = MessageParser.parserMessage(context, jSONArray, type, true, true);
            ChatMsgManagerImpl.getInstance(context).persisConfigMsgIds(arrayList);
            ChatMsgManagerImpl.getInstance(context).deliverConfigMessage(arrayList);
        }
    }

    public static void handleMediaNotifyMessage(Context context, JSONObject jSONObject) {
        ChatMsgManagerImpl.getInstance(context).handleMediaNotifyMessage(jSONObject);
    }

    public static void handleRtcNotifyMessage(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            LogUtils.i(TAG, "handleRtcNotifyMessage context == null || msgobj == null ");
            return;
        }
        try {
            LogUtils.i(TAG, "handleRtcNotifyMessage context ！= null && msgobj ！= null ");
            Class<?> cls = Class.forName("com.baidu.android.imrtc.BIMRtcManager");
            cls.getMethod("notifyParse", JSONObject.class).invoke(cls, jSONObject);
        } catch (Throwable th) {
            LogUtils.e(TAG, "handleRtcNotifyMessage ClassNotFoundException BIMRtcManager...", th);
        }
    }
}
