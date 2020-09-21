package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private String dHA;
    private long dHB;
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

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public void setErrorMessage(String str) {
        this.mErrorMessage = str;
    }

    public String aUt() {
        return this.dHA;
    }

    public void setTipMessage(String str) {
        this.dHA = str;
    }

    public void ci(long j) {
        this.dHB = j;
    }

    public static c wY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return ct(new JSONObject(str));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static c ct(JSONObject jSONObject) {
        c cVar = new c();
        cVar.setErrorCode(jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1));
        cVar.setErrorMessage(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
        cVar.setTipMessage(jSONObject.optString("tipmsg"));
        cVar.ci(jSONObject.optLong("request_id"));
        cVar.setData(jSONObject.optJSONObject("data"));
        return cVar;
    }
}
