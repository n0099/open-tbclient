package com.baidu.android.imsdk.request;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class MessageExt {
    private static final String KEY_CAST_ID = "cast_id";
    private static final String KEY_LAST_CALLBACK_MSG_ID = "last_callback_msg_id";
    private static final String KEY_LATEST_MSG_ID = "latest_msg_id";
    private static final String KEY_TS = "local_ts";
    private static final Long DEFAULT = 0L;
    protected static Object mSyncLock = new Object();
    private static MessageExt mInstance = null;
    public Long lastCallbackMsgId = DEFAULT;
    public Long castId = DEFAULT;
    public Long localTimestamp = DEFAULT;
    public Long dBLatestMsgId = DEFAULT;

    public static MessageExt getInstance() {
        synchronized (mSyncLock) {
            if (mInstance == null) {
                mInstance = new MessageExt();
            }
        }
        return mInstance;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_LAST_CALLBACK_MSG_ID, this.lastCallbackMsgId);
            jSONObject.put(KEY_CAST_ID, this.castId);
            jSONObject.put(KEY_TS, this.localTimestamp);
            jSONObject.put(KEY_LATEST_MSG_ID, this.dBLatestMsgId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void setLastCallbackMsgId(Long l) {
        this.lastCallbackMsgId = l;
    }

    public void setCastId(Long l) {
        this.castId = l;
    }

    public void setLocalTimestamp(Long l) {
        this.localTimestamp = l;
    }

    public void setdBLatestMsgId(Long l) {
        this.dBLatestMsgId = l;
    }
}
