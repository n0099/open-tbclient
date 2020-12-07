package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String brq;
    private int dFt;
    private String dFu;
    private String dFv;
    private long dFw;
    private long dFx;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.dFt = i;
        this.brq = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dFt = i2;
        this.brq = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.dFt = i2;
        this.dFw = j;
        this.dFx = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.brq = "2";
        } else {
            this.brq = "1";
        }
    }

    public void tI(String str) {
        this.dFu = str;
    }

    public String getRequestUrl() {
        return this.mRequestUrl;
    }

    public String aMT() {
        return this.brq;
    }

    public void tJ(String str) {
        this.dFv = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.dFz == null) {
            this.dFz = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.brq, "1") || TextUtils.equals(this.brq, "2")) {
                this.dFz.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.tC(this.mRequestUrl);
            this.dFz.put("url", this.mRequestUrl);
            this.dFz.put("netStatus", this.dFt);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.dFz.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.dFu)) {
                this.dFz.put("pagetype", this.dFu);
            }
            if (!TextUtils.isEmpty(this.dFv)) {
                this.dFz.put("curpage", this.dFv);
            }
            if (!TextUtils.isEmpty(this.brq)) {
                this.dFz.put("requesttype", this.brq);
            }
            if (this.dFx - this.dFw > 0) {
                this.dFz.put("startTime", this.dFw);
                this.dFz.put("endTime", this.dFx);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
