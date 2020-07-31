package com.baidu.swan.pms.c;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private String dwo;
    private long dwp;
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

    public String aLj() {
        return this.dwo;
    }

    public void setTipMessage(String str) {
        this.dwo = str;
    }

    public void cb(long j) {
        this.dwp = j;
    }

    public static c uv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return cm(new JSONObject(str));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static c cm(JSONObject jSONObject) {
        c cVar = new c();
        cVar.setErrorCode(jSONObject.optInt(BaseJsonData.TAG_ERRNO, -1));
        cVar.setErrorMessage(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
        cVar.setTipMessage(jSONObject.optString("tipmsg"));
        cVar.cb(jSONObject.optLong("request_id"));
        cVar.setData(jSONObject.optJSONObject("data"));
        return cVar;
    }
}
