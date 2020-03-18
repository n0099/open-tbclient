package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bf {
    public int aeP;
    public String aeQ;
    public String aeR;
    public String aeS;
    public String appKey;

    public bf(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aeP = jSONObject.optInt("goods_timeout");
            this.appKey = jSONObject.optString("app_key");
            this.aeQ = jSONObject.optString("live_goods_url");
            this.aeR = jSONObject.optString("add_goods_url");
            this.aeS = jSONObject.optString("kepler_id");
        }
    }
}
