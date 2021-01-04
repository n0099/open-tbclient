package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bvX;
    private int dNX;
    private String dNY;
    private String dNZ;
    private long dOa;
    private long dOb;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.dNX = i;
        this.bvX = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dNX = i2;
        this.bvX = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dNX = i2;
        this.dOa = j;
        this.dOb = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.bvX = "2";
        } else {
            this.bvX = "1";
        }
    }

    public void tF(String str) {
        this.dNY = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String aPj() {
        return this.bvX;
    }

    public void tG(String str) {
        this.dNZ = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dOd == null) {
            this.dOd = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.bvX, "1") || TextUtils.equals(this.bvX, "2")) {
                this.dOd.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.tz(this.mRequestUrl);
            this.dOd.put("url", this.mRequestUrl);
            this.dOd.put("netStatus", this.dNX);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.dOd.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.dNY)) {
                this.dOd.put("pagetype", this.dNY);
            }
            if (!TextUtils.isEmpty(this.dNZ)) {
                this.dOd.put("curpage", this.dNZ);
            }
            if (!TextUtils.isEmpty(this.bvX)) {
                this.dOd.put("requesttype", this.bvX);
            }
            if (this.dOb - this.dOa > 0) {
                this.dOd.put("startTime", this.dOa);
                this.dOd.put("endTime", this.dOb);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
