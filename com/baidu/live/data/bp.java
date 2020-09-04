package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bp {
    public String aDU;
    public String aKB;
    public String aKC;
    public String aKD;
    public int aKq;
    public int aKr;
    public int aKs;

    public bp(JSONObject jSONObject) {
        this.aKq = jSONObject.optInt("show_times_daily");
        this.aKr = jSONObject.optInt("continue_show_times");
        this.aKs = jSONObject.optInt("condition");
        this.aDU = jSONObject.optString("toast_text");
        this.aKB = jSONObject.optString("first_recharge_bg");
        this.aKC = jSONObject.optString("first_recharge_button");
        this.aKD = jSONObject.optString("first_recharge_h5");
    }
}
