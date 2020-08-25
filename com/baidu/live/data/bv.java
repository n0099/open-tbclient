package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bv {
    public String aLA;
    public int aLB;
    public int aLx;
    public String aLy;
    public String aLz;
    public String appKey;

    public bv(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLx = jSONObject.optInt("goods_timeout", 10);
            this.aLB = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aLy = jSONObject.optString("live_goods_url");
            this.aLz = jSONObject.optString("add_goods_url");
            this.aLA = jSONObject.optString("kepler_id");
        }
    }
}
