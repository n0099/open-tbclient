package com.baidu.swan.pms.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.pms.e.DEBUG;
    private long bmd;
    private JSONObject bme;
    private int mErrorCode = -1;
    private String mErrorMessage;

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public JSONObject RL() {
        return this.bme;
    }

    public void aw(JSONObject jSONObject) {
        this.bme = jSONObject;
    }

    public void setErrorMessage(String str) {
        this.mErrorMessage = str;
    }

    public void S(long j) {
        this.bmd = j;
    }

    public static c jl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return ax(new JSONObject(str));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static c ax(JSONObject jSONObject) {
        c cVar = new c();
        cVar.setErrorCode(jSONObject.optInt("errno", -1));
        cVar.setErrorMessage(jSONObject.optString("errmsg"));
        cVar.S(jSONObject.optLong("request_id"));
        cVar.aw(jSONObject.optJSONObject("data"));
        return cVar;
    }
}
