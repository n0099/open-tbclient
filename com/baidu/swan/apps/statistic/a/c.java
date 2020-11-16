package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bmj;
    private int dyu;
    private String dyv;
    private String dyw;
    private long dyx;
    private long dyy;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.dyu = i;
        this.bmj = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dyu = i2;
        this.bmj = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dyu = i2;
        this.dyx = j;
        this.dyy = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.bmj = "2";
        } else {
            this.bmj = "1";
        }
    }

    public void tb(String str) {
        this.dyv = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String aJM() {
        return this.bmj;
    }

    public void tc(String str) {
        this.dyw = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dyA == null) {
            this.dyA = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.bmj, "1") || TextUtils.equals(this.bmj, "2")) {
                this.dyA.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.sV(this.mRequestUrl);
            this.dyA.put("url", this.mRequestUrl);
            this.dyA.put("netStatus", this.dyu);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.dyA.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.dyv)) {
                this.dyA.put("pagetype", this.dyv);
            }
            if (!TextUtils.isEmpty(this.dyw)) {
                this.dyA.put("curpage", this.dyw);
            }
            if (!TextUtils.isEmpty(this.bmj)) {
                this.dyA.put("requesttype", this.bmj);
            }
            if (this.dyy - this.dyx > 0) {
                this.dyA.put("startTime", this.dyx);
                this.dyA.put("endTime", this.dyy);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
