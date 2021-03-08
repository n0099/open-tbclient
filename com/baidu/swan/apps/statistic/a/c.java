package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bwm;
    private int dMQ;
    private String dMR;
    private String dMS;
    private long dMT;
    private long dMU;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.dMQ = i;
        this.bwm = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dMQ = i2;
        this.bwm = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dMQ = i2;
        this.dMT = j;
        this.dMU = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.bwm = "2";
        } else {
            this.bwm = "1";
        }
    }

    public void sU(String str) {
        this.dMR = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String aLM() {
        return this.bwm;
    }

    public void sV(String str) {
        this.dMS = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dMW == null) {
            this.dMW = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.bwm, "1") || TextUtils.equals(this.bwm, "2")) {
                this.dMW.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.sO(this.mRequestUrl);
            this.dMW.put("url", this.mRequestUrl);
            this.dMW.put("netStatus", this.dMQ);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.dMW.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.dMR)) {
                this.dMW.put("pagetype", this.dMR);
            }
            if (!TextUtils.isEmpty(this.dMS)) {
                this.dMW.put("curpage", this.dMS);
            }
            if (!TextUtils.isEmpty(this.bwm)) {
                this.dMW.put("requesttype", this.bwm);
            }
            if (this.dMU - this.dMT > 0) {
                this.dMW.put("startTime", this.dMT);
                this.dMW.put("endTime", this.dMU);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
