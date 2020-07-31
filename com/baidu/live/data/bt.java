package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bt {
    public int aGn;
    public String aGo;
    public String aGp;
    public String aGq;
    public int aGr;
    public String appKey;

    public bt(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aGn = jSONObject.optInt("goods_timeout", 10);
            this.aGr = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aGo = jSONObject.optString("live_goods_url");
            this.aGp = jSONObject.optString("add_goods_url");
            this.aGq = jSONObject.optString("kepler_id");
        }
    }
}
