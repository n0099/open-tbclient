package com.baidu.swan.pms.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.pms.e.DEBUG;
    private String bLq;
    private long bLr;
    private JSONObject bLs;
    private int mErrorCode = -1;

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public JSONObject abg() {
        return this.bLs;
    }

    public void ba(JSONObject jSONObject) {
        this.bLs = jSONObject;
    }

    public void setErrorMessage(String str) {
        this.bLq = str;
    }

    public void ax(long j) {
        this.bLr = j;
    }

    public static c kW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return bb(new JSONObject(str));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static c bb(JSONObject jSONObject) {
        c cVar = new c();
        cVar.setErrorCode(jSONObject.optInt("errno", -1));
        cVar.setErrorMessage(jSONObject.optString("errmsg"));
        cVar.ax(jSONObject.optLong("request_id"));
        cVar.ba(jSONObject.optJSONObject("data"));
        return cVar;
    }
}
