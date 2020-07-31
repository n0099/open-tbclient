package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bn {
    public int aFe;
    public int aFf;
    public int aFg;
    public String aFp;
    public String aFq;
    public String aFr;
    public String azw;

    public bn(JSONObject jSONObject) {
        this.aFe = jSONObject.optInt("show_times_daily");
        this.aFf = jSONObject.optInt("continue_show_times");
        this.aFg = jSONObject.optInt("condition");
        this.azw = jSONObject.optString("toast_text");
        this.aFp = jSONObject.optString("first_recharge_bg");
        this.aFq = jSONObject.optString("first_recharge_button");
        this.aFr = jSONObject.optString("first_recharge_h5");
    }
}
