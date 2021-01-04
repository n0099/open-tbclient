package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class co {
    public int aUo;
    public String aUp;
    public String aUq;
    public String aUr;
    public int aUs;
    public int aUt;
    public String appKey;

    public co(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aUo = jSONObject.optInt("goods_timeout", 10);
            this.aUs = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aUp = jSONObject.optString("live_goods_url");
            this.aUq = jSONObject.optString("add_goods_url");
            this.aUr = jSONObject.optString("kepler_id");
            this.aUt = jSONObject.optInt("pre_download");
        }
    }
}
