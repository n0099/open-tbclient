package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String awv;
    private int bVf;
    private String bVg;
    private String bVh;
    private long bVi;
    private long bVj;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.bVf = i;
        this.awv = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.bVf = i2;
        this.awv = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.bVf = i2;
        this.bVi = j;
        this.bVj = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.awv = "2";
        } else {
            this.awv = "1";
        }
    }

    public void lL(String str) {
        this.bVg = str;
    }

    public void lM(String str) {
        this.bVh = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bVl == null) {
            this.bVl = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.awv, "1") || TextUtils.equals(this.awv, "2")) {
                this.bVl.put("errorno", this.mErrCode);
            }
            this.bVl.put("url", this.mRequestUrl);
            this.bVl.put("netStatus", this.bVf);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.bVl.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.bVg)) {
                this.bVl.put("pagetype", this.bVg);
            }
            if (!TextUtils.isEmpty(this.bVh)) {
                this.bVl.put("curpage", this.bVh);
            }
            if (!TextUtils.isEmpty(this.awv)) {
                this.bVl.put("requesttype", this.awv);
            }
            if (this.bVj - this.bVi > 0) {
                this.bVl.put("startTime", this.bVi);
                this.bVl.put("endTime", this.bVj);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppReqeustEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
