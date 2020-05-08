package com.baidu.swan.apps.statistic.a;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aQp;
    private int cun;
    private String cuo;
    private String cup;
    private long cuq;
    private long cus;
    private int mErrCode;
    private String mMsg;
    private String mRequestUrl;

    public c(String str, int i) {
        this.mRequestUrl = str;
        this.cun = i;
        this.aQp = "0";
    }

    public c(int i, String str, String str2, int i2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cun = i2;
        this.aQp = "1";
    }

    public c(int i, String str, String str2, int i2, long j, long j2) {
        this.mErrCode = i;
        this.mRequestUrl = str;
        this.mMsg = str2;
        this.cun = i2;
        this.cuq = j;
        this.cus = j2;
        if (i == 200 && j2 - j >= 5000) {
            this.aQp = "2";
        } else {
            this.aQp = "1";
        }
    }

    public void mX(String str) {
        this.cuo = str;
    }

    public void mY(String str) {
        this.cup = str;
    }

    @Override // com.baidu.swan.apps.statistic.a.f, com.baidu.swan.apps.statistic.a.e
    public JSONObject toJSONObject() {
        if (this.cuv == null) {
            this.cuv = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.aQp, "1") || TextUtils.equals(this.aQp, "2")) {
                this.cuv.put("errorno", this.mErrCode);
            }
            this.cuv.put("url", this.mRequestUrl);
            this.cuv.put("netStatus", this.cun);
            if (!TextUtils.isEmpty(this.mMsg)) {
                this.cuv.put("msg", this.mMsg);
            }
            if (!TextUtils.isEmpty(this.cuo)) {
                this.cuv.put("pagetype", this.cuo);
            }
            if (!TextUtils.isEmpty(this.cup)) {
                this.cuv.put("curpage", this.cup);
            }
            if (!TextUtils.isEmpty(this.aQp)) {
                this.cuv.put("requesttype", this.aQp);
            }
            if (this.cus - this.cuq > 0) {
                this.cuv.put("startTime", this.cuq);
                this.cuv.put("endTime", this.cus);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("SwanAppReqeustEvent", Log.getStackTraceString(e));
            }
        }
        return super.toJSONObject();
    }
}
