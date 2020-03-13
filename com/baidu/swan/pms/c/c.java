package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private long cBm;
    private JSONObject mData;
    private int mErrorCode = -1;
    private String mErrorMessage;

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

    public void setErrorMessage(String str) {
        this.mErrorMessage = str;
    }

    public void bi(long j) {
        this.cBm = j;
    }

    public static c qs(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return bN(new JSONObject(str));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static c bN(JSONObject jSONObject) {
        c cVar = new c();
        cVar.setErrorCode(jSONObject.optInt("errno", -1));
        cVar.setErrorMessage(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
        cVar.bi(jSONObject.optLong("request_id"));
        cVar.setData(jSONObject.optJSONObject("data"));
        return cVar;
    }
}
