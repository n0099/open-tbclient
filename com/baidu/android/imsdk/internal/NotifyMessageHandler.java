package com.baidu.android.imsdk.internal;

import android.content.Context;
import androidx.core.app.NotificationCompat;
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
/* loaded from: classes.dex */
public abstract class NotifyMessageHandler {
    public static final String TAG = "NotifyMessageHandler";

    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Long] */
    public static void handleConfigMessage(Context context, JSONObject jSONObject) throws JSONException {
        ArrayList<ChatMsg> arrayList;
        LogUtils.i(TAG, "handleMessage Config:" + jSONObject.toString());
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = jSONObject.getJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                jSONArray.put(jSONArray2.getJSONObject(i2));
            }
        } catch (JSONException e2) {
            LogUtils.e(TAG, "Exception ", e2);
            arrayList = null;
        }
        if (jSONArray.length() == 0) {
            return;
        }
        Type type = new Type();
        type.t = 0L;
        arrayList = MessageParser.parserMessage(context, jSONArray, type, true, true);
        ChatMsgManagerImpl.getInstance(context).persisConfigMsgIds(arrayList);
        ChatMsgManagerImpl.getInstance(context).deliverConfigMessage(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void handleDeliverMessage(Context context, JSONObject jSONObject) throws JSONException {
        long j;
        SyncStrategy generate;
        LogUtils.i(TAG, "handleMessage Deliver:" + jSONObject.toString());
        int i2 = jSONObject.getInt("category");
        if (i2 == 0 && jSONObject.has("msgid")) {
            try {
                j = jSONObject.getLong("msgid");
            } catch (JSONException e2) {
                LogUtils.i(TAG, "JSONException:" + e2.getMessage());
            }
            if (i2 != 0 || i2 == 2) {
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
            } else if (i2 == 1) {
                long j2 = jSONObject.getLong("contacter");
                long j3 = jSONObject.getLong("msgid");
                LogUtils.i(TAG, "msgid : " + j3);
                SyncGroupMessageService.getInstance().execute(context, i2, j2, j3, 2);
                return;
            } else {
                LogUtils.e(TAG, "handleDeliverMessage category error!!");
                return;
            }
        }
        j = -1;
        if (i2 != 0) {
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

    public static void handleMediaNotifyMessage(Context context, JSONObject jSONObject) {
        ChatMsgManagerImpl.getInstance(context).handleMediaNotifyMessage(jSONObject);
    }

    public static void handleRtcNotifyMessage(Context context, JSONObject jSONObject) {
        if (context != null && jSONObject != null) {
            try {
                LogUtils.i(TAG, "handleRtcNotifyMessage context ！= null && msgobj ！= null ");
                Class<?> cls = Class.forName("com.baidu.android.imrtc.BIMRtcManager");
                cls.getMethod("notifyParse", JSONObject.class).invoke(cls, jSONObject);
                return;
            } catch (Throwable th) {
                LogUtils.e(TAG, "handleRtcNotifyMessage ClassNotFoundException BIMRtcManager...", th);
                return;
            }
        }
        LogUtils.i(TAG, "handleRtcNotifyMessage context == null || msgobj == null ");
    }
}
