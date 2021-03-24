package com.baidu.android.imsdk.request;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MessageExt {
    public static final String KEY_CAST_ID = "cast_id";
    public static final String KEY_LAST_CALLBACK_MSG_ID = "last_callback_msg_id";
    public static final String KEY_LATEST_MSG_ID = "latest_msg_id";
    public static final String KEY_TS = "local_ts";
    public Long castId;
    public Long dBLatestMsgId;
    public Long lastCallbackMsgId;
    public Long localTimestamp;
    public static final Long DEFAULT = 0L;
    public static Object mSyncLock = new Object();
    public static MessageExt mInstance = null;

    public MessageExt() {
        Long l = DEFAULT;
        this.lastCallbackMsgId = l;
        this.castId = l;
        this.localTimestamp = l;
        this.dBLatestMsgId = l;
    }

    public static MessageExt getInstance() {
        synchronized (mSyncLock) {
            if (mInstance == null) {
                mInstance = new MessageExt();
            }
        }
        return mInstance;
    }

    public void setCastId(Long l) {
        this.castId = l;
    }

    public void setLastCallbackMsgId(Long l) {
        this.lastCallbackMsgId = l;
    }

    public void setLocalTimestamp(Long l) {
        this.localTimestamp = l;
    }

    public void setdBLatestMsgId(Long l) {
        this.dBLatestMsgId = l;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_LAST_CALLBACK_MSG_ID, this.lastCallbackMsgId);
            jSONObject.put(KEY_CAST_ID, this.castId);
            jSONObject.put(KEY_TS, this.localTimestamp);
            jSONObject.put(KEY_LATEST_MSG_ID, this.dBLatestMsgId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
