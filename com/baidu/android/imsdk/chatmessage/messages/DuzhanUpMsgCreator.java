package com.baidu.android.imsdk.chatmessage.messages;

import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DuzhanUpMsgCreator {
    private static final String TAG = "DuzhanUpMsgCreateor";
    private static int REQ_TYPE_BOX = 0;
    private static int REQ_TYPE_PA = 1;
    private static int REQ_TYPE_CLUE = 3;
    private static int REQ_TYPE_LEMON = 4;

    public static int getReqType(int i) {
        if (i == 7) {
            return REQ_TYPE_PA;
        }
        if (i == 16) {
            return REQ_TYPE_CLUE;
        }
        if (i == 25) {
            return REQ_TYPE_LEMON;
        }
        return REQ_TYPE_BOX;
    }

    public static ChatMsg reCreateChatMsg(int i, ChatMsg chatMsg) {
        chatMsg.setChatType(i);
        chatMsg.setExtraContent(generateExtJson(chatMsg));
        return chatMsg;
    }

    private static JSONObject getImageContent(ChatMsg chatMsg) {
        try {
            String optString = new JSONObject(chatMsg.getJsonContent()).optString("json");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", optString);
            jSONObject.put("url", ((ImageMsg) chatMsg).getRemoteUrl());
            jSONObject.put("thumbnail", ((ImageMsg) chatMsg).getThumbUrl());
            jSONObject.put("w", ((ImageMsg) chatMsg).getWidth());
            jSONObject.put("h", ((ImageMsg) chatMsg).getHeight());
            return jSONObject;
        } catch (Exception e) {
            LogUtils.e(TAG, "create json excepiton " + e.getMessage());
            return new JSONObject();
        }
    }

    private static String generateExtJson(ChatMsg chatMsg) {
        String str;
        Exception e;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("type", chatMsg.getMsgType());
            jSONObject4.put("content", getMsgExtContent(chatMsg));
            jSONObject3.put("description", "");
            jSONObject3.put("ext", jSONObject4);
            jSONObject2.put("time", System.currentTimeMillis() / 1000);
            jSONObject2.put("msg", jSONObject3);
            jSONObject.put("text", jSONObject2.toString());
            str = jSONObject.toString();
        } catch (Exception e2) {
            str = "";
            e = e2;
        }
        try {
            LogUtils.d(TAG, "generateExtJson :" + str);
        } catch (Exception e3) {
            e = e3;
            LogUtils.e(TAG, "generateExtJson :" + e);
            return str;
        }
        return str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0026 -> B:7:0x0015). Please submit an issue!!! */
    private static JSONObject getMsgExtContent(ChatMsg chatMsg) {
        try {
            String jsonContent = chatMsg.getJsonContent();
            if (!TextUtils.isEmpty(jsonContent)) {
                if (chatMsg.getMsgType() == 1) {
                    return getImageContent(chatMsg);
                }
                return new JSONObject(jsonContent);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "getMsgExtContent :", e);
        }
        return new JSONObject();
    }
}
