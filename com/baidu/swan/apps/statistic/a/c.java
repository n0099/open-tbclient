package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aZf;
    private int cOt;
    private String cOu;
    private String cOv;
    private long cOw;
    private long cOx;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.cOt = i;
        this.aZf = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cOt = i2;
        this.aZf = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cOt = i2;
        this.cOw = j;
        this.cOx = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.aZf = "2";
        } else {
            this.aZf = "1";
        }
    }

    public void ps(String str) {
        this.cOu = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String auy() {
        return this.aZf;
    }

    public void pt(String str) {
        this.cOv = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cOz == null) {
            this.cOz = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.aZf, "1") || TextUtils.equals(this.aZf, "2")) {
                this.cOz.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.pm(this.mRequestUrl);
            this.cOz.put("url", this.mRequestUrl);
            this.cOz.put("netStatus", this.cOt);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.cOz.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.cOu)) {
                this.cOz.put("pagetype", this.cOu);
            }
            if (!TextUtils.isEmpty(this.cOv)) {
                this.cOz.put("curpage", this.cOv);
            }
            if (!TextUtils.isEmpty(this.aZf)) {
                this.cOz.put("requesttype", this.aZf);
            }
            if (this.cOx - this.cOw > 0) {
                this.cOz.put("startTime", this.cOw);
                this.cOz.put("endTime", this.cOx);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
