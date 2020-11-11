package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ck {
    public int aRZ;
    public String aSa;
    public String aSb;
    public String aSc;
    public int aSd;
    public int aSe;
    public String appKey;

    public ck(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aRZ = jSONObject.optInt("goods_timeout", 10);
            this.aSd = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aSa = jSONObject.optString("live_goods_url");
            this.aSb = jSONObject.optString("add_goods_url");
            this.aSc = jSONObject.optString("kepler_id");
            this.aSe = jSONObject.optInt("pre_download");
        }
    }
}
