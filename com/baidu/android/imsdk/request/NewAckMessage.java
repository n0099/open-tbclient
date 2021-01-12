package com.baidu.android.imsdk.request;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NewAckMessage extends Message {
    private Context mContext;
    private JSONArray mJsonArray;
    private long mTriggerId;
    private List<Tripule> tripules;

    /* loaded from: classes3.dex */
    public static class Tripule {
        private String accountType;
        private String businessSource;
        private int contentType;
        private long fromUser;
        private long mcastId;
        private String msgCategory;
        private String msgPage;
        private long msgReceiveTime;
        private long msgid;
        private String msgkey;
        private int paClassType;
        private long paId;
        private int paType;
        private int subPaType;
        private String thirdId;
        private long ukFromUser;
        private long ukToUser;
        private JSONObject jack = null;
        private boolean isReliable = false;
        private String osName = HttpConstants.OS_TYPE_VALUE;

        public Tripule(long j, String str, long j2, String str2, int i, String str3, long j3, long j4, long j5, int i2, int i3, int i4, String str4, String str5, String str6) {
            this.msgid = j;
            this.msgkey = str;
            this.msgReceiveTime = j2;
            this.msgPage = str2;
            this.contentType = i;
            this.accountType = str3;
            this.ukFromUser = j3;
            this.ukToUser = j4;
            this.paId = j5;
            this.paType = i2;
            this.subPaType = i3;
            this.paClassType = i4;
            this.msgCategory = str4;
            this.businessSource = str5;
            this.thirdId = str6;
        }

        public void setFromUser(long j) {
            this.fromUser = j;
        }

        public void setAck(JSONObject jSONObject) {
            this.jack = jSONObject;
        }

        public void setStudioIsReliable(boolean z) {
            this.isReliable = z;
        }

        public void setMcastId(long j) {
            this.mcastId = j;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from_user", this.fromUser);
                jSONObject.put("msgid", this.msgid);
                jSONObject.put("msg_key", this.msgkey);
                jSONObject.put("time", this.msgReceiveTime);
                jSONObject.put("page", this.msgPage);
                jSONObject.put("os_name", this.osName);
                jSONObject.put("content_type", this.contentType);
                jSONObject.put("account_type", this.accountType);
                jSONObject.put("time", this.msgReceiveTime);
                jSONObject.put("uk", this.ukFromUser);
                jSONObject.put("to_uk", this.ukToUser);
                if ((this.paId & Constants.PAFLAG) != 0) {
                    jSONObject.put("paid", this.paId);
                    jSONObject.put("pa_type", this.paType);
                    jSONObject.put("sub_pa_type", this.subPaType);
                    jSONObject.put("pa_class_type", this.paClassType);
                    jSONObject.put("msg_category", this.msgCategory);
                    jSONObject.put("business_source", this.businessSource);
                    jSONObject.put("third_id", this.thirdId);
                }
                if (this.jack != null) {
                    jSONObject.put("ack", this.jack);
                }
                if (this.mcastId > 0) {
                    jSONObject.put("mcast_id", this.mcastId);
                }
                if (this.isReliable) {
                    jSONObject.put("is_reliable", this.isReliable);
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
        this.mJsonArray = null;
        this.mContext = null;
        initCommonParameter(context);
        this.mUk = j;
        this.mTriggerId = j2;
        this.mContext = context;
        this.tripules = new LinkedList();
        setNeedReplay(true);
        setType(95);
        this.mPriority = 16;
    }

    public NewAckMessage(Context context, long j, long j2, boolean z) {
        this(context, j, j2);
        if (!z) {
            saveCmdMessage(context, this, null, this.mPriority);
        }
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
            if (this.mAppid <= 0) {
                this.mAppid = AccountManager.getAppid(this.mContext);
            }
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("device_id", Utility.getIMDeviceId(this.mContext));
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

    public JSONArray getJsonArray() {
        return this.mJsonArray;
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
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        super.handleMessageResult(context, jSONObject, i, str);
        if (i == 0) {
            DBManager.getInstance(context).deleteCmdMsg(getUUID());
            AckHandlerThread.getInstance(context).mRetryCount.set(0);
        }
    }
}
