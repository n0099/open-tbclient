package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bs {
    public int aES;
    public String aET;
    public String aEU;
    public String aEV;
    public int aEW;
    public String appKey;

    public bs(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aES = jSONObject.optInt("goods_timeout", 10);
            this.aEW = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aET = jSONObject.optString("live_goods_url");
            this.aEU = jSONObject.optString("add_goods_url");
            this.aEV = jSONObject.optString("kepler_id");
        }
    }
}
