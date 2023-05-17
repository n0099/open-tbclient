package com.baidu.searchbox.wordscommand.data;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.searchbox.wordscommand.runtime.WordCommandRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommandBaseJsonData {
    public static final int ERROR_CODE_OK = 0;
    public static final String TAG = "BaseJsonData";
    public static final String TAG_DATA = "data";
    public static final String TAG_ERRMSG = "errmsg";
    public static final String TAG_REQUESTID = "requestid";
    public static final String TAG_TIMESTAMP = "timestamp";
    public JSONObject mData;
    public String mErrorMessage;
    public String mRequestId;
    public long mTimestamp;

    public CommandBaseJsonData(JSONObject jSONObject) {
        this.mData = jSONObject;
    }

    public static CommandBaseJsonData fromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return fromJson(new JSONObject(str));
        } catch (JSONException e) {
            if (WordCommandRuntime.DEBUG) {
                Log.i("BaseJsonData", e.toString());
            }
            return null;
        }
    }

    public void setData(JSONObject jSONObject) {
        this.mData = jSONObject;
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

    public static CommandBaseJsonData fromJson(JSONObject jSONObject) {
        CommandBaseJsonData commandBaseJsonData = null;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONObject == null) {
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    optJSONObject = optJSONArray.getJSONObject(0);
                } else {
                    if (WordCommandRuntime.DEBUG) {
                        Log.i("BaseJsonData", "data is error");
                    }
                    optJSONObject = null;
                }
            }
            CommandBaseJsonData commandBaseJsonData2 = new CommandBaseJsonData(optJSONObject);
            try {
                if (jSONObject.has("errmsg") && !jSONObject.isNull("errmsg")) {
                    commandBaseJsonData2.setErrorMessage(jSONObject.getString("errmsg"));
                }
                if (jSONObject.has("timestamp") && !jSONObject.isNull("timestamp")) {
                    try {
                        commandBaseJsonData2.setTimestamp(Long.parseLong(jSONObject.optString("timestamp")));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        commandBaseJsonData2.setTimestamp(0L);
                    }
                }
                if (jSONObject.has("requestid") && !jSONObject.isNull("requestid")) {
                    commandBaseJsonData2.setRequestId(jSONObject.optString("requestid"));
                    return commandBaseJsonData2;
                }
                return commandBaseJsonData2;
            } catch (JSONException e2) {
                e = e2;
                commandBaseJsonData = commandBaseJsonData2;
                if (WordCommandRuntime.DEBUG) {
                    Log.i("BaseJsonData", e.toString());
                }
                return commandBaseJsonData;
            }
        } catch (JSONException e3) {
            e = e3;
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

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }
}
