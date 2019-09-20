package com.baidu.swan.pms.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.pms.e.DEBUG;
    private String btw;
    private long btx;
    private JSONObject bty;
    private int mErrorCode = -1;

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public JSONObject Wt() {
        return this.bty;
    }

    public void aB(JSONObject jSONObject) {
        this.bty = jSONObject;
    }

    public void setErrorMessage(String str) {
        this.btw = str;
    }

    public void af(long j) {
        this.btx = j;
    }

    public static c ku(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return aC(new JSONObject(str));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static c aC(JSONObject jSONObject) {
        c cVar = new c();
        cVar.setErrorCode(jSONObject.optInt("errno", -1));
        cVar.setErrorMessage(jSONObject.optString("errmsg"));
        cVar.af(jSONObject.optLong("request_id"));
        cVar.aB(jSONObject.optJSONObject("data"));
        return cVar;
    }
}
