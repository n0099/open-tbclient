package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aQj;
    private int cuh;
    private String cui;
    private String cuj;
    private long cuk;
    private long cul;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.cuh = i;
        this.aQj = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cuh = i2;
        this.aQj = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cuh = i2;
        this.cuk = j;
        this.cul = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.aQj = "2";
        } else {
            this.aQj = "1";
        }
    }

    public void mX(String str) {
        this.cui = str;
    }

    public void mY(String str) {
        this.cuj = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cun == null) {
            this.cun = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.aQj, "1") || TextUtils.equals(this.aQj, "2")) {
                this.cun.put("errorno", this.mErrCode);
            }
            this.cun.put("url", this.mRequestUrl);
            this.cun.put("netStatus", this.cuh);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.cun.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.cui)) {
                this.cun.put("pagetype", this.cui);
            }
            if (!TextUtils.isEmpty(this.cuj)) {
                this.cun.put("curpage", this.cuj);
            }
            if (!TextUtils.isEmpty(this.aQj)) {
                this.cun.put("requesttype", this.aQj);
            }
            if (this.cul - this.cuk > 0) {
                this.cun.put("startTime", this.cuk);
                this.cun.put("endTime", this.cul);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppReqeustEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
