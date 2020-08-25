package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bp {
    public String aDS;
    public String aKA;
    public String aKB;
    public int aKo;
    public int aKp;
    public int aKq;
    public String aKz;

    public bp(JSONObject jSONObject) {
        this.aKo = jSONObject.optInt("show_times_daily");
        this.aKp = jSONObject.optInt("continue_show_times");
        this.aKq = jSONObject.optInt("condition");
        this.aDS = jSONObject.optString("toast_text");
        this.aKz = jSONObject.optString("first_recharge_bg");
        this.aKA = jSONObject.optString("first_recharge_button");
        this.aKB = jSONObject.optString("first_recharge_h5");
    }
}
