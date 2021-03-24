package com.baidu.android.util.io;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes2.dex */
public class BaseJsonData {
    public static final boolean DEBUG = false;
    public static final int ERROR_CODE_OK = 0;
    public static final String TAG = "BaseJsonData";
    public static final String TAG_DATA = "data";
    public static final String TAG_ERRMSG = "errmsg";
    public static final String TAG_ERRNO = "errno";
    public static final String TAG_PUBLICSRV = "publicsrv";
    public static final String TAG_REQUESTID = "requestid";
    public static final String TAG_TIMESTAMP = "timestamp";
    public JSONObject mData;
    public int mErrorCode;
    public String mErrorMessage;
    public String mRequestId;
    public long mTimestamp;

    public BaseJsonData() {
        this.mErrorCode = -1;
    }

    public static BaseJsonData fromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return fromJson(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
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

    public JSONObject getData() {
        return this.mData;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setData(JSONObject jSONObject) {
        this.mData = jSONObject;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public void setErrorMessage(String str) {
        this.mErrorMessage = str;
    }

    public void setRequestId(String str) {
        this.mRequestId = str;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    public BaseJsonData(int i, JSONObject jSONObject) {
        this.mErrorCode = -1;
        this.mErrorCode = i;
        this.mData = jSONObject;
    }

    public static BaseJsonData fromJson(JSONObject jSONObject) {
        BaseJsonData baseJsonData = null;
        try {
            int i = jSONObject.getInt("errno");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONObject == null) {
                optJSONObject = (optJSONArray == null || optJSONArray.length() <= 0) ? null : optJSONArray.getJSONObject(0);
            }
            BaseJsonData baseJsonData2 = new BaseJsonData(i, optJSONObject);
            try {
                if (jSONObject.has("errmsg") && !jSONObject.isNull("errmsg")) {
                    baseJsonData2.setErrorMessage(jSONObject.getString("errmsg"));
                }
                if (jSONObject.has("timestamp") && !jSONObject.isNull("timestamp")) {
                    try {
                        baseJsonData2.setTimestamp(Long.valueOf(jSONObject.getString("timestamp")).longValue());
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                        baseJsonData2.setTimestamp(0L);
                    }
                }
                if (!jSONObject.has(TAG_REQUESTID) || jSONObject.isNull(TAG_REQUESTID)) {
                    return baseJsonData2;
                }
                baseJsonData2.setRequestId(jSONObject.optString(TAG_REQUESTID));
                return baseJsonData2;
            } catch (JSONException unused) {
                baseJsonData = baseJsonData2;
                return baseJsonData;
            }
        } catch (JSONException unused2) {
        }
    }
}
