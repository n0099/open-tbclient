package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bhp;
    private long cZA;
    private long cZB;
    private int cZx;
    private String cZy;
    private String cZz;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.cZx = i;
        this.bhp = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cZx = i2;
        this.bhp = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cZx = i2;
        this.cZA = j;
        this.cZB = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.bhp = "2";
        } else {
            this.bhp = "1";
        }
    }

    public void rM(String str) {
        this.cZy = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String aDr() {
        return this.bhp;
    }

    public void rN(String str) {
        this.cZz = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cZD == null) {
            this.cZD = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.bhp, "1") || TextUtils.equals(this.bhp, "2")) {
                this.cZD.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.rG(this.mRequestUrl);
            this.cZD.put("url", this.mRequestUrl);
            this.cZD.put("netStatus", this.cZx);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.cZD.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.cZy)) {
                this.cZD.put("pagetype", this.cZy);
            }
            if (!TextUtils.isEmpty(this.cZz)) {
                this.cZD.put("curpage", this.cZz);
            }
            if (!TextUtils.isEmpty(this.bhp)) {
                this.cZD.put("requesttype", this.bhp);
            }
            if (this.cZB - this.cZA > 0) {
                this.cZD.put("startTime", this.cZA);
                this.cZD.put("endTime", this.cZB);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
