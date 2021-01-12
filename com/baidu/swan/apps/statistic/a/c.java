package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String brj;
    private int dJl;
    private String dJm;
    private String dJn;
    private long dJo;
    private long dJp;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.dJl = i;
        this.brj = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dJl = i2;
        this.brj = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dJl = i2;
        this.dJo = j;
        this.dJp = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.brj = "2";
        } else {
            this.brj = "1";
        }
    }

    public void su(String str) {
        this.dJm = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String aLq() {
        return this.brj;
    }

    public void sv(String str) {
        this.dJn = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dJr == null) {
            this.dJr = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.brj, "1") || TextUtils.equals(this.brj, "2")) {
                this.dJr.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.sn(this.mRequestUrl);
            this.dJr.put("url", this.mRequestUrl);
            this.dJr.put("netStatus", this.dJl);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.dJr.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.dJm)) {
                this.dJr.put("pagetype", this.dJm);
            }
            if (!TextUtils.isEmpty(this.dJn)) {
                this.dJr.put("curpage", this.dJn);
            }
            if (!TextUtils.isEmpty(this.brj)) {
                this.dJr.put("requesttype", this.brj);
            }
            if (this.dJp - this.dJo > 0) {
                this.dJr.put("startTime", this.dJo);
                this.dJr.put("endTime", this.dJp);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
