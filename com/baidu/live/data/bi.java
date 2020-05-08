package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bi {
    public String appKey;
    public int axl;
    public String axm;
    public String axn;
    public String axo;

    public bi(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axl = jSONObject.optInt("goods_timeout");
            this.appKey = jSONObject.optString("app_key");
            this.axm = jSONObject.optString("live_goods_url");
            this.axn = jSONObject.optString("add_goods_url");
            this.axo = jSONObject.optString("kepler_id");
        }
    }
}
