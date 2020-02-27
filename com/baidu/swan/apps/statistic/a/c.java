package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String awu;
    private int bVe;
    private String bVf;
    private String bVg;
    private long bVh;
    private long bVi;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.bVe = i;
        this.awu = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.bVe = i2;
        this.awu = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.bVe = i2;
        this.bVh = j;
        this.bVi = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.awu = "2";
        } else {
            this.awu = "1";
        }
    }

    public void lL(String str) {
        this.bVf = str;
    }

    public void lM(String str) {
        this.bVg = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bVk == null) {
            this.bVk = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.awu, "1") || TextUtils.equals(this.awu, "2")) {
                this.bVk.put("errorno", this.mErrCode);
            }
            this.bVk.put("url", this.mRequestUrl);
            this.bVk.put("netStatus", this.bVe);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.bVk.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.bVf)) {
                this.bVk.put("pagetype", this.bVf);
            }
            if (!TextUtils.isEmpty(this.bVg)) {
                this.bVk.put("curpage", this.bVg);
            }
            if (!TextUtils.isEmpty(this.awu)) {
                this.bVk.put("requesttype", this.awu);
            }
            if (this.bVi - this.bVh > 0) {
                this.bVk.put("startTime", this.bVh);
                this.bVk.put("endTime", this.bVi);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppReqeustEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
