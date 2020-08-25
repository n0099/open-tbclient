package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bez;
    private int cXt;
    private String cXu;
    private String cXv;
    private long cXw;
    private long cXx;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.cXt = i;
        this.bez = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cXt = i2;
        this.bez = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cXt = i2;
        this.cXw = j;
        this.cXx = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.bez = "2";
        } else {
            this.bez = "1";
        }
    }

    public void rs(String str) {
        this.cXu = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String aCH() {
        return this.bez;
    }

    public void rt(String str) {
        this.cXv = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cXz == null) {
            this.cXz = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.bez, "1") || TextUtils.equals(this.bez, "2")) {
                this.cXz.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.rm(this.mRequestUrl);
            this.cXz.put("url", this.mRequestUrl);
            this.cXz.put("netStatus", this.cXt);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.cXz.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.cXu)) {
                this.cXz.put("pagetype", this.cXu);
            }
            if (!TextUtils.isEmpty(this.cXv)) {
                this.cXz.put("curpage", this.cXv);
            }
            if (!TextUtils.isEmpty(this.bez)) {
                this.cXz.put("requesttype", this.bez);
            }
            if (this.cXx - this.cXw > 0) {
                this.cXz.put("startTime", this.cXw);
                this.cXz.put("endTime", this.cXx);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
