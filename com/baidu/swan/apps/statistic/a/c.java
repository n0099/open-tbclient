package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String ary;
    private int bQp;
    private String bQq;
    private String bQr;
    private long bQs;
    private long bQt;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.bQp = i;
        this.ary = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.bQp = i2;
        this.ary = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.bQp = i2;
        this.bQs = j;
        this.bQt = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.ary = "2";
        } else {
            this.ary = "1";
        }
    }

    public void lt(String str) {
        this.bQq = str;
    }

    public void lu(String str) {
        this.bQr = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.bQv == null) {
            this.bQv = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.ary, "1") || TextUtils.equals(this.ary, "2")) {
                this.bQv.put("errorno", this.mErrCode);
            }
            this.bQv.put("url", this.mRequestUrl);
            this.bQv.put("netStatus", this.bQp);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.bQv.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.bQq)) {
                this.bQv.put("pagetype", this.bQq);
            }
            if (!TextUtils.isEmpty(this.bQr)) {
                this.bQv.put("curpage", this.bQr);
            }
            if (!TextUtils.isEmpty(this.ary)) {
                this.bQv.put("requesttype", this.ary);
            }
            if (this.bQt - this.bQs > 0) {
                this.bQv.put("startTime", this.bQs);
                this.bQv.put("endTime", this.bQt);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppReqeustEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
