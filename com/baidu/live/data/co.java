package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class co {
    public int aPB;
    public String aPC;
    public String aPD;
    public String aPE;
    public int aPF;
    public int aPG;
    public String appKey;

    public co(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPB = jSONObject.optInt("goods_timeout", 10);
            this.aPF = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aPC = jSONObject.optString("live_goods_url");
            this.aPD = jSONObject.optString("add_goods_url");
            this.aPE = jSONObject.optString("kepler_id");
            this.aPG = jSONObject.optInt("pre_download");
        }
    }
}
