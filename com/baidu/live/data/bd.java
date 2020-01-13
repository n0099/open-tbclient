package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bd {
    public int acD;
    public String acE;
    public String acF;
    public String acG;
    public String appKey;

    public bd(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.acD = jSONObject.optInt("goods_timeout");
            this.appKey = jSONObject.optString("app_key");
            this.acE = jSONObject.optString("live_goods_url");
            this.acF = jSONObject.optString("add_goods_url");
            this.acG = jSONObject.optString("kepler_id");
        }
    }
}
