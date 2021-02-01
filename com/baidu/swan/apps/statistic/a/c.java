package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String buM;
    private int dLp;
    private String dLq;
    private String dLr;
    private long dLs;
    private long dLt;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.dLp = i;
        this.buM = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dLp = i2;
        this.buM = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dLp = i2;
        this.dLs = j;
        this.dLt = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.buM = "2";
        } else {
            this.buM = "1";
        }
    }

    public void sN(String str) {
        this.dLq = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String aLJ() {
        return this.buM;
    }

    public void sO(String str) {
        this.dLr = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dLv == null) {
            this.dLv = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.buM, "1") || TextUtils.equals(this.buM, "2")) {
                this.dLv.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.sH(this.mRequestUrl);
            this.dLv.put("url", this.mRequestUrl);
            this.dLv.put("netStatus", this.dLp);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.dLv.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.dLq)) {
                this.dLv.put("pagetype", this.dLq);
            }
            if (!TextUtils.isEmpty(this.dLr)) {
                this.dLv.put("curpage", this.dLr);
            }
            if (!TextUtils.isEmpty(this.buM)) {
                this.dLv.put("requesttype", this.buM);
            }
            if (this.dLt - this.dLs > 0) {
                this.dLv.put("startTime", this.dLs);
                this.dLv.put("endTime", this.dLt);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
