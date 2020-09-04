package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String beB;
    private long cXA;
    private long cXB;
    private int cXx;
    private String cXy;
    private String cXz;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.cXx = i;
        this.beB = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cXx = i2;
        this.beB = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cXx = i2;
        this.cXA = j;
        this.cXB = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.beB = "2";
        } else {
            this.beB = "1";
        }
    }

    public void rt(String str) {
        this.cXy = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String aCH() {
        return this.beB;
    }

    public void ru(String str) {
        this.cXz = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cXD == null) {
            this.cXD = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.beB, "1") || TextUtils.equals(this.beB, "2")) {
                this.cXD.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.rn(this.mRequestUrl);
            this.cXD.put("url", this.mRequestUrl);
            this.cXD.put("netStatus", this.cXx);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.cXD.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.cXy)) {
                this.cXD.put("pagetype", this.cXy);
            }
            if (!TextUtils.isEmpty(this.cXz)) {
                this.cXD.put("curpage", this.cXz);
            }
            if (!TextUtils.isEmpty(this.beB)) {
                this.cXD.put("requesttype", this.beB);
            }
            if (this.cXB - this.cXA > 0) {
                this.cXD.put("startTime", this.cXA);
                this.cXD.put("endTime", this.cXB);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
