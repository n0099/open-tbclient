package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class az {
    public int adJ;
    public int adK;
    public int adL;
    public String adT;
    public String adU;
    public String adV;
    public String adW;

    public az(JSONObject jSONObject) {
        this.adJ = jSONObject.optInt("show_times_daily");
        this.adK = jSONObject.optInt("continue_show_times");
        this.adL = jSONObject.optInt("condition");
        this.adT = jSONObject.optString("toast_text");
        this.adU = jSONObject.optString("first_recharge_bg");
        this.adV = jSONObject.optString("first_recharge_button");
        this.adW = jSONObject.optString("first_recharge_h5");
    }
}
