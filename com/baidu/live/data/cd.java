package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cd {
    public int aNi;
    public String aNj;
    public String aNk;
    public String aNl;
    public int aNm;
    public String appKey;

    public cd(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNi = jSONObject.optInt("goods_timeout", 10);
            this.aNm = jSONObject.optInt("goods_stay_time", 7);
            this.appKey = jSONObject.optString("app_key");
            this.aNj = jSONObject.optString("live_goods_url");
            this.aNk = jSONObject.optString("add_goods_url");
            this.aNl = jSONObject.optString("kepler_id");
        }
    }
}
