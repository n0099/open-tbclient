package com.baidu.b.a.f.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.b.a.h.b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.isDebug();
    private String ZV;
    private JSONObject ZW;
    private JSONObject ZX;
    private int mErrorCode;
    private String mErrorMessage;
    private long mTimestamp;

    public a() {
        this.mErrorCode = -1;
    }

    public a(int i, JSONObject jSONObject, JSONObject jSONObject2) {
        this.mErrorCode = -1;
        this.mErrorCode = i;
        this.ZW = jSONObject;
        this.ZX = jSONObject2;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public JSONObject rK() {
        return this.ZW;
    }

    public JSONObject rL() {
        return this.ZX;
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

    public void setRequestId(String str) {
        this.ZV = str;
    }

    public static a cV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return o(new JSONObject(str));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static a o(JSONObject jSONObject) {
        a aVar;
        JSONException e;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        try {
            int i = jSONObject.getInt("errno");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONObject != null) {
                jSONObject2 = optJSONObject;
            } else if (optJSONArray != null && optJSONArray.length() > 0) {
                jSONObject2 = optJSONArray.getJSONObject(0);
            } else {
                if (DEBUG) {
                    Log.d("BaseJsonData", "Invalid data field!");
                }
                jSONObject2 = null;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("filtered_data");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("filtered_data");
            if (optJSONObject2 != null) {
                jSONObject3 = optJSONObject2;
            } else if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                jSONObject3 = optJSONArray2.getJSONObject(0);
            } else {
                if (DEBUG) {
                    Log.d("BaseJsonData", "Invalid filtered_data field!");
                }
                jSONObject3 = null;
            }
            aVar = new a(i, jSONObject2, jSONObject3);
            try {
                if (jSONObject.has("errmsg") && !jSONObject.isNull("errmsg")) {
                    aVar.setErrorMessage(jSONObject.getString("errmsg"));
                }
                if (jSONObject.has(HttpConstants.TIMESTAMP) && !jSONObject.isNull(HttpConstants.TIMESTAMP)) {
                    try {
                        aVar.setTimestamp(Long.valueOf(jSONObject.getString(HttpConstants.TIMESTAMP)).longValue());
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                        aVar.setTimestamp(0L);
                    }
                }
                if (jSONObject.has("requestid") && !jSONObject.isNull("requestid")) {
                    aVar.setRequestId(jSONObject.getString("requestid"));
                }
            } catch (JSONException e3) {
                e = e3;
                if (DEBUG) {
                    e.printStackTrace();
                }
                return aVar;
            }
        } catch (JSONException e4) {
            aVar = null;
            e = e4;
        }
        return aVar;
    }
}
