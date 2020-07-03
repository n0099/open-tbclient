package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aZh;
    private int cKY;
    private String cKZ;
    private String cLa;
    private long cLb;
    private long cLc;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.cKY = i;
        this.aZh = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cKY = i2;
        this.aZh = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cKY = i2;
        this.cLb = j;
        this.cLc = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.aZh = "2";
        } else {
            this.aZh = "1";
        }
    }

    public void oI(String str) {
        this.cKZ = str;
    }

    public void oJ(String str) {
        this.cLa = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cLe == null) {
            this.cLe = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.aZh, "1") || TextUtils.equals(this.aZh, "2")) {
                this.cLe.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.oD(this.mRequestUrl);
            this.cLe.put("url", this.mRequestUrl);
            this.cLe.put("netStatus", this.cKY);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.cLe.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.cKZ)) {
                this.cLe.put("pagetype", this.cKZ);
            }
            if (!TextUtils.isEmpty(this.cLa)) {
                this.cLe.put("curpage", this.cLa);
            }
            if (!TextUtils.isEmpty(this.aZh)) {
                this.cLe.put("requesttype", this.aZh);
            }
            if (this.cLc - this.cLb > 0) {
                this.cLe.put("startTime", this.cLb);
                this.cLe.put("endTime", this.cLc);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppReqeustEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
