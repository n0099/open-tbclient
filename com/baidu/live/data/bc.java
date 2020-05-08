package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bc {
    public String arc;
    public String awA;
    public String awB;
    public String awC;
    public int awq;
    public int awr;
    public int aws;

    public bc(JSONObject jSONObject) {
        this.awq = jSONObject.optInt("show_times_daily");
        this.awr = jSONObject.optInt("continue_show_times");
        this.aws = jSONObject.optInt("condition");
        this.arc = jSONObject.optString("toast_text");
        this.awA = jSONObject.optString("first_recharge_bg");
        this.awB = jSONObject.optString("first_recharge_button");
        this.awC = jSONObject.optString("first_recharge_h5");
    }
}
