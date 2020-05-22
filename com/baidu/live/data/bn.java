package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bn {
    public int aCB;
    public String aCC;
    public String aCD;
    public String aCE;
    public String appKey;

    public bn(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aCB = jSONObject.optInt("goods_timeout");
            this.appKey = jSONObject.optString("app_key");
            this.aCC = jSONObject.optString("live_goods_url");
            this.aCD = jSONObject.optString("add_goods_url");
            this.aCE = jSONObject.optString("kepler_id");
        }
    }
}
