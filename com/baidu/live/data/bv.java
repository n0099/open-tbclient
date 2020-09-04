package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bv {
    public String aLA;
    public String aLB;
    public String aLC;
    public int aLD;
    public int aLz;
    public String appKey;

    public bv(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLz = jSONObject.optInt("goods_timeout", 10);
            this.aLD = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aLA = jSONObject.optString("live_goods_url");
            this.aLB = jSONObject.optString("add_goods_url");
            this.aLC = jSONObject.optString("kepler_id");
        }
    }
}
