package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ax {
    public int abE;
    public int abF;
    public int abG;
    public String abO;
    public String abP;
    public String abQ;
    public String abR;

    public ax(JSONObject jSONObject) {
        this.abE = jSONObject.optInt("show_times_daily");
        this.abF = jSONObject.optInt("continue_show_times");
        this.abG = jSONObject.optInt("condition");
        this.abO = jSONObject.optString("toast_text");
        this.abP = jSONObject.optString("first_recharge_bg");
        this.abQ = jSONObject.optString("first_recharge_button");
        this.abR = jSONObject.optString("first_recharge_h5");
    }
}
