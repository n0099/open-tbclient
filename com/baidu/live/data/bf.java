package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bf {
    public int aeF;
    public String aeG;
    public String aeH;
    public String aeI;
    public String appKey;

    public bf(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aeF = jSONObject.optInt("goods_timeout");
            this.appKey = jSONObject.optString("app_key");
            this.aeG = jSONObject.optString("live_goods_url");
            this.aeH = jSONObject.optString("add_goods_url");
            this.aeI = jSONObject.optString("kepler_id");
        }
    }
}
