package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cm {
    public int aTq;
    public String aTr;
    public String aTs;
    public String aTt;
    public int aTu;
    public int aTv;
    public String appKey;

    public cm(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aTq = jSONObject.optInt("goods_timeout", 10);
            this.aTu = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aTr = jSONObject.optString("live_goods_url");
            this.aTs = jSONObject.optString("add_goods_url");
            this.aTt = jSONObject.optString("kepler_id");
            this.aTv = jSONObject.optInt("pre_download");
        }
    }
}
