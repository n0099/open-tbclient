package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ci {
    public int aQX;
    public String aQY;
    public String aQZ;
    public String aRa;
    public int aRb;
    public int aRc;
    public String appKey;

    public ci(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQX = jSONObject.optInt("goods_timeout", 10);
            this.aRb = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aQY = jSONObject.optString("live_goods_url");
            this.aQZ = jSONObject.optString("add_goods_url");
            this.aRa = jSONObject.optString("kepler_id");
            this.aRc = jSONObject.optInt("pre_download");
        }
    }
}
