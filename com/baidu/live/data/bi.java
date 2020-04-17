package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bi {
    public String appKey;
    public int axf;
    public String axg;
    public String axh;
    public String axi;

    public bi(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axf = jSONObject.optInt("goods_timeout");
            this.appKey = jSONObject.optString("app_key");
            this.axg = jSONObject.optString("live_goods_url");
            this.axh = jSONObject.optString("add_goods_url");
            this.axi = jSONObject.optString("kepler_id");
        }
    }
}
