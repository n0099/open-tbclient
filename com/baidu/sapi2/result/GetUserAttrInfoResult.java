package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetUserAttrInfoResult extends SapiResult implements NoProguard {
    public static final int CODE_JSON_EXCEPTION = -101;
    public static final int CODE_NOT_LOGIN = -102;
    public static final int CODE_PARAMS_ERROR = -103;
    public static final String KEY_DATA = "data";
    public static final String KEY_DATA_CACHE_TIME = "cacheTime";
    public static final String KEY_DATA_EXT_FIELDS = "ext_fields";
    public static final String KEY_DATA_FIELDS = "fields";
    public static final String KEY_DATA_IS_LOCAL_DATA = "isLocalData";
    public static final String KEY_ERRMSG = "errmsg";
    public static final String KEY_ERRNO = "errno";
    public static final String MSG_JSON_EXCEPTION = "JSON解析失败";
    public static final String MSG_NOT_LOGIN = "请您先登录帐号";
    public static final String MSG_PARAMS_ERROR = "请核对入参";
    public long mCacheTime;
    public JSONObject mExtFields;
    public JSONObject mFields;
    public boolean mIsLocalData;

    public JSONObject getExtFields() {
        return this.mExtFields;
    }

    public JSONObject getFields() {
        return this.mFields;
    }

    public boolean isIsLocalData() {
        return this.mIsLocalData;
    }

    public static GetUserAttrInfoResult parseFromJSONObject(String str) {
        JSONObject optJSONObject;
        GetUserAttrInfoResult getUserAttrInfoResult = new GetUserAttrInfoResult();
        if (TextUtils.isEmpty(str)) {
            return getUserAttrInfoResult;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            getUserAttrInfoResult.setResultCode(jSONObject.optInt("errno"));
            getUserAttrInfoResult.setResultMsg(jSONObject.optString("errmsg"));
            optJSONObject = jSONObject.optJSONObject("data");
        } catch (JSONException e) {
            e.printStackTrace();
            getUserAttrInfoResult.setResultCode(-101);
            getUserAttrInfoResult.setResultMsg("JSON解析失败");
        }
        if (optJSONObject == null) {
            return getUserAttrInfoResult;
        }
        getUserAttrInfoResult.setFields(optJSONObject.optJSONObject(KEY_DATA_FIELDS));
        getUserAttrInfoResult.setExtFields(optJSONObject.optJSONObject(KEY_DATA_EXT_FIELDS));
        getUserAttrInfoResult.setCacheTime(optJSONObject.optLong(KEY_DATA_CACHE_TIME));
        getUserAttrInfoResult.setIsLocalData(optJSONObject.optBoolean(KEY_DATA_IS_LOCAL_DATA));
        return getUserAttrInfoResult;
    }

    public boolean isAvailable(long j) {
        if (this.mCacheTime + j > System.currentTimeMillis() / 1000 && this.resultCode == 0) {
            return true;
        }
        return false;
    }

    public void setCacheTime(long j) {
        this.mCacheTime = j;
    }

    public void setExtFields(JSONObject jSONObject) {
        this.mExtFields = jSONObject;
    }

    public void setFields(JSONObject jSONObject) {
        this.mFields = jSONObject;
    }

    public void setIsLocalData(boolean z) {
        this.mIsLocalData = z;
    }

    public String toJsonStr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errno", this.resultCode);
            jSONObject.put("errmsg", this.resultMsg);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(KEY_DATA_FIELDS, this.mFields);
            jSONObject2.put(KEY_DATA_EXT_FIELDS, this.mExtFields);
            jSONObject2.put(KEY_DATA_CACHE_TIME, this.mCacheTime);
            jSONObject2.put(KEY_DATA_IS_LOCAL_DATA, this.mIsLocalData);
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "GetUserAttrInfoResult{resultCode=" + this.resultCode + ", resultMsg='" + this.resultMsg + "', mFields=" + this.mFields + ", mExtFields=" + this.mExtFields + ", mCacheTime=" + this.mCacheTime + ", mIsLocalData=" + this.mIsLocalData + '}';
    }
}
