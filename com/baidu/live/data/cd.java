package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cd {
    public int aQn;
    public String aQo;
    public String aQp;
    public String aQq;
    public int aQr;
    public String appKey;

    public cd(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQn = jSONObject.optInt("goods_timeout", 10);
            this.aQr = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aQo = jSONObject.optString("live_goods_url");
            this.aQp = jSONObject.optString("add_goods_url");
            this.aQq = jSONObject.optString("kepler_id");
        }
    }
}
