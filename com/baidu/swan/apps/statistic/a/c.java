package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String ask;
    private int bQZ;
    private String bRa;
    private String bRb;
    private long bRc;
    private long bRd;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.bQZ = i;
        this.ask = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.bQZ = i2;
        this.ask = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.bQZ = i2;
        this.bRc = j;
        this.bRd = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.ask = "2";
        } else {
            this.ask = "1";
        }
    }

    public void lw(String str) {
        this.bRa = str;
    }

    public void lx(String str) {
        this.bRb = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bRf == null) {
            this.bRf = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.ask, "1") || TextUtils.equals(this.ask, "2")) {
                this.bRf.put("errorno", this.mErrCode);
            }
            this.bRf.put("url", this.mRequestUrl);
            this.bRf.put("netStatus", this.bQZ);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.bRf.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.bRa)) {
                this.bRf.put("pagetype", this.bRa);
            }
            if (!TextUtils.isEmpty(this.bRb)) {
                this.bRf.put("curpage", this.bRb);
            }
            if (!TextUtils.isEmpty(this.ask)) {
                this.bRf.put("requesttype", this.ask);
            }
            if (this.bRd - this.bRc > 0) {
                this.bRf.put("startTime", this.bRc);
                this.bRf.put("endTime", this.bRd);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppReqeustEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
