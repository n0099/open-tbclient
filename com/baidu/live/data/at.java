package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class at {
    public String abD;
    public String abE;
    public String abF;
    public String abG;
    public int abt;
    public int abu;
    public int abv;

    public at(JSONObject jSONObject) {
        this.abt = jSONObject.optInt("show_times_daily");
        this.abu = jSONObject.optInt("continue_show_times");
        this.abv = jSONObject.optInt("condition");
        this.abD = jSONObject.optString("toast_text");
        this.abE = jSONObject.optString("first_recharge_bg");
        this.abF = jSONObject.optString("first_recharge_button");
        this.abG = jSONObject.optString("first_recharge_h5");
    }
}
