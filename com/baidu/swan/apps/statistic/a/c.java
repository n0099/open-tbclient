package com.baidu.swan.apps.statistic.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aSo;
    private int mErrCode;
    private String mMsg;

    public c(int i, String str, String str2) {
        this.mErrCode = i;
        this.aSo = str;
        this.mMsg = str2;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.aSq == null) {
            this.aSq = new JSONObject();
        }
        try {
            this.aSq.put("errorno", this.mErrCode);
            this.aSq.put("url", this.aSo);
            this.aSq.put("msg", this.mMsg);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppReqeustEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
