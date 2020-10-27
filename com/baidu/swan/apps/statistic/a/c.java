package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bmA;
    private int duj;
    private String duk;
    private String dul;
    private long dum;
    private long dun;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.duj = i;
        this.bmA = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.duj = i2;
        this.bmA = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.duj = i2;
        this.dum = j;
        this.dun = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.bmA = "2";
        } else {
            this.bmA = "1";
        }
    }

    public void sS(String str) {
        this.duk = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String aHU() {
        return this.bmA;
    }

    public void sT(String str) {
        this.dul = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dup == null) {
            this.dup = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.bmA, "1") || TextUtils.equals(this.bmA, "2")) {
                this.dup.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.sM(this.mRequestUrl);
            this.dup.put("url", this.mRequestUrl);
            this.dup.put("netStatus", this.duj);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.dup.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.duk)) {
                this.dup.put("pagetype", this.duk);
            }
            if (!TextUtils.isEmpty(this.dul)) {
                this.dup.put("curpage", this.dul);
            }
            if (!TextUtils.isEmpty(this.bmA)) {
                this.dup.put("requesttype", this.bmA);
            }
            if (this.dun - this.dum > 0) {
                this.dup.put("startTime", this.dum);
                this.dup.put("endTime", this.dun);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
