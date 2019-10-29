package com.baidu.android.imsdk.request;

import android.content.Context;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class NewAckMessage extends Message {
    private Context mContext;
    private JSONArray mJsonArray = null;
    private long mTriggerId;
    private List<Tripule> tripules;

    /* loaded from: classes6.dex */
    public static class Tripule {
        private long fromUser;
        private JSONObject jack = null;
        private long msgReceiveTime;
        private long msgid;
        private String msgkey;

        public Tripule(long j, String str, long j2) {
            this.msgid = j;
            this.msgkey = str;
            this.msgReceiveTime = j2;
        }

        public void setFromUser(long j) {
            this.fromUser = j;
        }

        public void setAck(JSONObject jSONObject) {
            this.jack = jSONObject;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from_user", this.fromUser);
                jSONObject.put("msgid", this.msgid);
                jSONObject.put("msg_key", this.msgkey);
                jSONObject.put("time", this.msgReceiveTime);
                if (this.jack != null) {
                    jSONObject.put("ack", this.jack);
                    return jSONObject;
                }
                return jSONObject;
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "toJsonObject", e);
                return null;
            }
        }
    }

    public NewAckMessage(Context context, long j, long j2) {
        this.mContext = null;
        this.mUk = j;
        this.mTriggerId = j2;
        this.mContext = context;
        this.tripules = new LinkedList();
        setNeedReplay(true);
        setType(95);
        this.mPriority = 16;
        saveCmdMessage(context, this, null, this.mPriority);
    }

    public static NewAckMessage parseBody(Context context, String str, String str2, String str3) throws Exception {
        JSONObject jSONObject = new JSONObject(str2);
        long optLong = jSONObject.optLong(Constants.KEY_TRIGGER_ID, 0L);
        long optLong2 = jSONObject.optLong("uk", 0L);
        JSONArray optJSONArray = jSONObject.optJSONArray("msgs");
        NewAckMessage newAckMessage = new NewAckMessage(context, optLong2, optLong);
        newAckMessage.setUUID(str);
        newAckMessage.setJsonArray(optJSONArray);
        return newAckMessage;
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 95);
            jSONObject.put(Constants.KEY_TRIGGER_ID, this.mTriggerId);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put(Constants.KEY_DEVICE_ID, Utility.getIMDeviceId(this.mContext));
            jSONObject.put("msgs", this.mJsonArray);
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "buildBody", e);
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        setSendingState(context);
    }

    public void setJsonArray(JSONArray jSONArray) {
        this.mJsonArray = jSONArray;
    }

    public boolean addTriples(List<Tripule> list) {
        this.tripules.addAll(list);
        return toJsonArray(list);
    }

    public boolean toJsonArray(List<Tripule> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        for (Tripule tripule : list) {
            JSONObject jsonObject = tripule.toJsonObject();
            if (jsonObject != null) {
                jSONArray.put(jsonObject);
            }
        }
        this.mJsonArray = jSONArray;
        return this.mJsonArray.length() != 0;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) throws JSONException {
        if (i == 0) {
            DBManager.getInstance(context).deleteCmdMsg(getUUID());
        }
    }
}
