package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bnU;
    private int dAb;
    private String dAc;
    private String dAd;
    private long dAe;
    private long dAf;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.dAb = i;
        this.bnU = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dAb = i2;
        this.bnU = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dAb = i2;
        this.dAe = j;
        this.dAf = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.bnU = "2";
        } else {
            this.bnU = "1";
        }
    }

    public void tg(String str) {
        this.dAc = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String aKu() {
        return this.bnU;
    }

    public void th(String str) {
        this.dAd = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dAh == null) {
            this.dAh = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.bnU, "1") || TextUtils.equals(this.bnU, "2")) {
                this.dAh.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.ta(this.mRequestUrl);
            this.dAh.put("url", this.mRequestUrl);
            this.dAh.put("netStatus", this.dAb);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.dAh.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.dAc)) {
                this.dAh.put("pagetype", this.dAc);
            }
            if (!TextUtils.isEmpty(this.dAd)) {
                this.dAh.put("curpage", this.dAd);
            }
            if (!TextUtils.isEmpty(this.bnU)) {
                this.dAh.put("requesttype", this.bnU);
            }
            if (this.dAf - this.dAe > 0) {
                this.dAh.put("startTime", this.dAe);
                this.dAh.put("endTime", this.dAf);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
