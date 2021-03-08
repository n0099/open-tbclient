package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cu {
    public int aUd;
    public String aUe;
    public String aUf;
    public String aUg;
    public int aUh;
    public int aUi;
    public String appKey;

    public cu(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aUd = jSONObject.optInt("goods_timeout", 10);
            this.aUh = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aUe = jSONObject.optString("live_goods_url");
            this.aUf = jSONObject.optString("add_goods_url");
            this.aUg = jSONObject.optString("kepler_id");
            this.aUi = jSONObject.optInt("pre_download");
        }
    }
}
