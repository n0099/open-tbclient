package com.baidu.swan.apps.statistic.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bps;
    private int mErrCode;
    private String mMsg;

    public c(int i, String str, String str2) {
        this.mErrCode = i;
        this.bps = str;
        this.mMsg = str2;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bpu == null) {
            this.bpu = new JSONObject();
        }
        try {
            this.bpu.put("errorno", this.mErrCode);
            this.bpu.put("url", this.bps);
            this.bpu.put("msg", this.mMsg);
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppReqeustEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
