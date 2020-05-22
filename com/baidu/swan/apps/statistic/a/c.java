package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aWy;
    private int cGo;
    private String cGp;
    private String cGq;
    private long cGr;
    private long cGs;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.cGo = i;
        this.aWy = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cGo = i2;
        this.aWy = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cGo = i2;
        this.cGr = j;
        this.cGs = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.aWy = "2";
        } else {
            this.aWy = "1";
        }
    }

    public void oA(String str) {
        this.cGp = str;
    }

    public void oB(String str) {
        this.cGq = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cGu == null) {
            this.cGu = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.aWy, "1") || TextUtils.equals(this.aWy, "2")) {
                this.cGu.put("errorno", this.mErrCode);
            }
            this.mRequestUrl = com.baidu.swan.apps.statistic.g.ov(this.mRequestUrl);
            this.cGu.put("url", this.mRequestUrl);
            this.cGu.put("netStatus", this.cGo);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.cGu.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.cGp)) {
                this.cGu.put("pagetype", this.cGp);
            }
            if (!TextUtils.isEmpty(this.cGq)) {
                this.cGu.put("curpage", this.cGq);
            }
            if (!TextUtils.isEmpty(this.aWy)) {
                this.cGu.put("requesttype", this.aWy);
            }
            if (this.cGs - this.cGr > 0) {
                this.cGu.put("startTime", this.cGr);
                this.cGu.put("endTime", this.cGs);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppReqeustEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
