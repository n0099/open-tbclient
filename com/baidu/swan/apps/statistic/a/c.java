package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aww;
    private int bVg;
    private String bVh;
    private String bVi;
    private long bVj;
    private long bVk;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.bVg = i;
        this.aww = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.bVg = i2;
        this.aww = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.bVg = i2;
        this.bVj = j;
        this.bVk = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.aww = "2";
        } else {
            this.aww = "1";
        }
    }

    public void lL(String str) {
        this.bVh = str;
    }

    public void lM(String str) {
        this.bVi = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bVm == null) {
            this.bVm = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.aww, "1") || TextUtils.equals(this.aww, "2")) {
                this.bVm.put("errorno", this.mErrCode);
            }
            this.bVm.put("url", this.mRequestUrl);
            this.bVm.put("netStatus", this.bVg);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.bVm.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.bVh)) {
                this.bVm.put("pagetype", this.bVh);
            }
            if (!TextUtils.isEmpty(this.bVi)) {
                this.bVm.put("curpage", this.bVi);
            }
            if (!TextUtils.isEmpty(this.aww)) {
                this.bVm.put("requesttype", this.aww);
            }
            if (this.bVk - this.bVj > 0) {
                this.bVm.put("startTime", this.bVj);
                this.bVm.put("endTime", this.bVk);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppReqeustEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
