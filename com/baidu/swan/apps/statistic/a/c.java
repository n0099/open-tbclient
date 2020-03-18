package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String awG;
    private int bVr;
    private String bVs;
    private String bVt;
    private long bVu;
    private long bVv;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.bVr = i;
        this.awG = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.bVr = i2;
        this.awG = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.bVr = i2;
        this.bVu = j;
        this.bVv = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.awG = "2";
        } else {
            this.awG = "1";
        }
    }

    public void lK(String str) {
        this.bVs = str;
    }

    public void lL(String str) {
        this.bVt = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bVx == null) {
            this.bVx = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.awG, "1") || TextUtils.equals(this.awG, "2")) {
                this.bVx.put("errorno", this.mErrCode);
            }
            this.bVx.put("url", this.mRequestUrl);
            this.bVx.put("netStatus", this.bVr);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.bVx.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.bVs)) {
                this.bVx.put("pagetype", this.bVs);
            }
            if (!TextUtils.isEmpty(this.bVt)) {
                this.bVx.put("curpage", this.bVt);
            }
            if (!TextUtils.isEmpty(this.awG)) {
                this.bVx.put("requesttype", this.awG);
            }
            if (this.bVv - this.bVu > 0) {
                this.bVx.put("startTime", this.bVu);
                this.bVx.put("endTime", this.bVv);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppReqeustEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
