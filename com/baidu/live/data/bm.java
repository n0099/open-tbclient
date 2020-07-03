package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bm {
    public int aDK;
    public int aDL;
    public int aDM;
    public String aDV;
    public String aDW;
    public String aDX;
    public String ayj;

    public bm(JSONObject jSONObject) {
        this.aDK = jSONObject.optInt("show_times_daily");
        this.aDL = jSONObject.optInt("continue_show_times");
        this.aDM = jSONObject.optInt("condition");
        this.ayj = jSONObject.optString("toast_text");
        this.aDV = jSONObject.optString("first_recharge_bg");
        this.aDW = jSONObject.optString("first_recharge_button");
        this.aDX = jSONObject.optString("first_recharge_h5");
    }
}
