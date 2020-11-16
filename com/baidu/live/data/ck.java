package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ck {
    public int aQo;
    public String aQp;
    public String aQq;
    public String aQr;
    public int aQs;
    public int aQt;
    public String appKey;

    public ck(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQo = jSONObject.optInt("goods_timeout", 10);
            this.aQs = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aQp = jSONObject.optString("live_goods_url");
            this.aQq = jSONObject.optString("add_goods_url");
            this.aQr = jSONObject.optString("kepler_id");
            this.aQt = jSONObject.optInt("pre_download");
        }
    }
}
