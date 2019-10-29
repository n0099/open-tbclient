package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class am {
    public int UF;
    public int UG;
    public int UH;
    public String UO;
    public String UQ;
    public String UR;
    public String US;

    public am(JSONObject jSONObject) {
        this.UF = jSONObject.optInt("show_times_daily");
        this.UG = jSONObject.optInt("continue_show_times");
        this.UH = jSONObject.optInt("condition");
        this.UO = jSONObject.optString("toast_text");
        this.UQ = jSONObject.optString("first_recharge_bg");
        this.UR = jSONObject.optString("first_recharge_button");
        this.US = jSONObject.optString("first_recharge_h5");
    }
}
