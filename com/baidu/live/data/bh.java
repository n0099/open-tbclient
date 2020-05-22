package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bh {
    public int aBA;
    public int aBB;
    public String aBK;
    public String aBL;
    public String aBM;
    public int aBz;
    public String awb;

    public bh(JSONObject jSONObject) {
        this.aBz = jSONObject.optInt("show_times_daily");
        this.aBA = jSONObject.optInt("continue_show_times");
        this.aBB = jSONObject.optInt("condition");
        this.awb = jSONObject.optString("toast_text");
        this.aBK = jSONObject.optString("first_recharge_bg");
        this.aBL = jSONObject.optString("first_recharge_button");
        this.aBM = jSONObject.optString("first_recharge_h5");
    }
}
