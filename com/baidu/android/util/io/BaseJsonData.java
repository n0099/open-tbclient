package com.baidu.android.util.io;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class BaseJsonData {
    private static final boolean DEBUG = false;
    public static final int ERROR_CODE_OK = 0;
    private static final String TAG = "BaseJsonData";
    public static final String TAG_DATA = "data";
    public static final String TAG_ERRMSG = "errmsg";
    public static final String TAG_ERRNO = "errno";
    public static final String TAG_PUBLICSRV = "publicsrv";
    public static final String TAG_REQUESTID = "requestid";
    public static final String TAG_TIMESTAMP = "timestamp";
    private JSONObject mData;
    private int mErrorCode;
    private String mErrorMessage;
    private String mRequestId;
    private long mTimestamp;

    public BaseJsonData() {
        this.mErrorCode = -1;
    }

    public BaseJsonData(int i, JSONObject jSONObject) {
        this.mErrorCode = -1;
        this.mErrorCode = i;
        this.mData = jSONObject;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public JSONObject getData() {
        return this.mData;
    }

    public void setData(JSONObject jSONObject) {
        this.mData = jSONObject;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public void setErrorMessage(String str) {
        this.mErrorMessage = str;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public void setRequestId(String str) {
        this.mRequestId = str;
    }

    public ActionJsonData getAction(String str, String str2) {
        JSONObject optJSONObject;
        if (this.mData == null || TextUtils.isEmpty(str) || !this.mData.has(str) || this.mData.isNull(str) || (optJSONObject = this.mData.optJSONObject(str)) == null) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            return ActionJsonData.fromJson(optJSONObject);
        }
        return ActionJsonData.fromJson(optJSONObject.optJSONObject(str2));
    }

    public static BaseJsonData fromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return fromJson(new JSONObject(str));
        } catch (JSONException e) {
            return null;
        }
    }

    public static BaseJsonData fromJson(JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            int i = jSONObject.getInt(TAG_ERRNO);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONObject != null) {
                jSONObject2 = optJSONObject;
            } else {
                jSONObject2 = (optJSONArray == null || optJSONArray.length() <= 0) ? null : optJSONArray.getJSONObject(0);
            }
            BaseJsonData baseJsonData = new BaseJsonData(i, jSONObject2);
            try {
                if (jSONObject.has(TAG_ERRMSG) && !jSONObject.isNull(TAG_ERRMSG)) {
                    baseJsonData.setErrorMessage(jSONObject.getString(TAG_ERRMSG));
                }
                if (jSONObject.has("timestamp") && !jSONObject.isNull("timestamp")) {
                    try {
                        baseJsonData.setTimestamp(Long.valueOf(jSONObject.getString("timestamp")).longValue());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        baseJsonData.setTimestamp(0L);
                    }
                }
                if (jSONObject.has(TAG_REQUESTID) && !jSONObject.isNull(TAG_REQUESTID)) {
                    baseJsonData.setRequestId(jSONObject.optString(TAG_REQUESTID));
                    return baseJsonData;
                }
                return baseJsonData;
            } catch (JSONException e2) {
                return baseJsonData;
            }
        } catch (JSONException e3) {
            return null;
        }
    }
}
