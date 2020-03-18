package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class az {
    public int adT;
    public int adU;
    public int adV;
    public String aed;
    public String aee;
    public String aef;
    public String aeg;

    public az(JSONObject jSONObject) {
        this.adT = jSONObject.optInt("show_times_daily");
        this.adU = jSONObject.optInt("continue_show_times");
        this.adV = jSONObject.optInt("condition");
        this.aed = jSONObject.optString("toast_text");
        this.aee = jSONObject.optString("first_recharge_bg");
        this.aef = jSONObject.optString("first_recharge_button");
        this.aeg = jSONObject.optString("first_recharge_h5");
    }
}
