package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class az {
    public int acq;
    public String acr;
    public String acs;
    public String appKey;

    public az(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.acq = jSONObject.optInt("goods_timeout");
            this.appKey = jSONObject.optString("app_key");
            this.acr = jSONObject.optString("live_goods_url");
            this.acs = jSONObject.optString("add_goods_url");
        }
    }
}
