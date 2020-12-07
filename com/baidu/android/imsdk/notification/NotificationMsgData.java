package com.baidu.android.imsdk.notification;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.pubaccount.PaInfo;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class NotificationMsgData {
    public static final String TAG = "NotificationMsgData";
    ChatMsg mMsg;
    PaInfo mPainfo;
    int mType = -1;
    List<Long> mUids = new ArrayList();

    public NotificationMsgData(ChatMsg chatMsg) {
        this.mMsg = chatMsg;
    }

    public ChatMsg getMsg() {
        return this.mMsg;
    }

    public PaInfo getPainfo() {
        return this.mPainfo;
    }

    public void setMsg(ChatMsg chatMsg) {
        this.mMsg = chatMsg;
    }

    public void setPainfo(PaInfo paInfo) {
        this.mPainfo = paInfo;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public int getType() {
        return this.mType;
    }

    public List<Long> getUids() {
        return this.mUids;
    }

    public List<Long> getInterActiveUserBduids() {
        JSONArray optJSONArray;
        if (this.mMsg != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.mMsg.getJsonContent());
                if (!jSONObject.optBoolean("is_merged", false) && (optJSONArray = jSONObject.optJSONArray("user_info")) != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null && jSONObject2.has("uk")) {
                            String transBDUK = Utility.transBDUK(jSONObject2.getString("uk"));
                            if (!TextUtils.isEmpty(transBDUK)) {
                                this.mUids.add(Long.valueOf(Long.parseLong(transBDUK)));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "parseJsonString JSONException", e);
            }
        }
        return this.mUids;
    }

    public void updateUserInfo(ChatUser chatUser) {
        JSONArray optJSONArray;
        if (chatUser != null && this.mMsg != null) {
            try {
                JSONObject jSONObject = new JSONObject(this.mMsg.getJsonContent());
                if (!jSONObject.optBoolean("is_merged", false) && (optJSONArray = jSONObject.optJSONArray("user_info")) != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null && jSONObject2.has("uk")) {
                            String transBDUK = Utility.transBDUK(jSONObject2.getString("uk"));
                            if (!TextUtils.isEmpty(transBDUK) && chatUser.getBuid() == Long.parseLong(transBDUK)) {
                                jSONObject2.put("nickname", chatUser.getUserName());
                                jSONObject2.put("portrait", chatUser.getIconUrl());
                                jSONObject2.put("v_portrait", chatUser.getVPortrait());
                                jSONObject2.put("relation_follow", chatUser.getSubscribe());
                                jSONObject2.put("relation_phone", chatUser.getPhoneRelation());
                                jSONObject2.put("identify", chatUser.getIdentity());
                                this.mMsg.setMsgContent(jSONObject.toString());
                                return;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                LogUtils.e(TAG, "updateUserInfo JSONException", e);
            }
        }
    }
}
