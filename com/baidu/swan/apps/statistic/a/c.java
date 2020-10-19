package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String blf;
    private int dlH;
    private String dlI;
    private String dlJ;
    private long dlK;
    private long dlL;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.dlH = i;
        this.blf = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dlH = i2;
        this.blf = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dlH = i2;
        this.dlK = j;
        this.dlL = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.blf = "2";
        } else {
            this.blf = "1";
        }
    }

    public void sz(String str) {
        this.dlI = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String aGa() {
        return this.blf;
    }

    public void sA(String str) {
        this.dlJ = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dlN == null) {
            this.dlN = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.blf, "1") || TextUtils.equals(this.blf, "2")) {
                this.dlN.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.st(this.mRequestUrl);
            this.dlN.put("url", this.mRequestUrl);
            this.dlN.put("netStatus", this.dlH);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.dlN.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.dlI)) {
                this.dlN.put("pagetype", this.dlI);
            }
            if (!TextUtils.isEmpty(this.dlJ)) {
                this.dlN.put("curpage", this.dlJ);
            }
            if (!TextUtils.isEmpty(this.blf)) {
                this.dlN.put("requesttype", this.blf);
            }
            if (this.dlL - this.dlK > 0) {
                this.dlN.put("startTime", this.dlK);
                this.dlN.put("endTime", this.dlL);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
