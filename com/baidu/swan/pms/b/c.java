package com.baidu.swan.pms.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.pms.e.DEBUG;
    private String bMh;
    private long bMi;
    private JSONObject bMj;
    private int mErrorCode = -1;

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public JSONObject abi() {
        return this.bMj;
    }

    public void aZ(JSONObject jSONObject) {
        this.bMj = jSONObject;
    }

    public void setErrorMessage(String str) {
        this.bMh = str;
    }

    public void ay(long j) {
        this.bMi = j;
    }

    public static c kW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return ba(new JSONObject(str));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static c ba(JSONObject jSONObject) {
        c cVar = new c();
        cVar.setErrorCode(jSONObject.optInt("errno", -1));
        cVar.setErrorMessage(jSONObject.optString("errmsg"));
        cVar.ay(jSONObject.optLong("request_id"));
        cVar.aZ(jSONObject.optJSONObject("data"));
        return cVar;
    }
}
