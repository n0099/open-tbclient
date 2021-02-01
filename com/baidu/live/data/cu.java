package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cu {
    public int aSD;
    public String aSE;
    public String aSF;
    public String aSG;
    public int aSH;
    public int aSI;
    public String appKey;

    public cu(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSD = jSONObject.optInt("goods_timeout", 10);
            this.aSH = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aSE = jSONObject.optString("live_goods_url");
            this.aSF = jSONObject.optString("add_goods_url");
            this.aSG = jSONObject.optString("kepler_id");
            this.aSI = jSONObject.optInt("pre_download");
        }
    }
}
