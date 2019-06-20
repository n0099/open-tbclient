package com.baidu.swan.pms.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.pms.e.DEBUG;
    private long bsj;
    private JSONObject bsk;
    private int mErrorCode = -1;
    private String mErrorMessage;

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public JSONObject Vw() {
        return this.bsk;
    }

    public void aB(JSONObject jSONObject) {
        this.bsk = jSONObject;
    }

    public void setErrorMessage(String str) {
        this.mErrorMessage = str;
    }

    public void ae(long j) {
        this.bsj = j;
    }

    public static c kk(String str) {
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
        cVar.ae(jSONObject.optLong("request_id"));
        cVar.aB(jSONObject.optJSONObject("data"));
        return cVar;
    }
}
