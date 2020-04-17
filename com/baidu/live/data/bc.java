package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bc {
    public String aqW;
    public int awk;
    public int awl;
    public int awm;
    public String awu;
    public String awv;
    public String aww;

    public bc(JSONObject jSONObject) {
        this.awk = jSONObject.optInt("show_times_daily");
        this.awl = jSONObject.optInt("continue_show_times");
        this.awm = jSONObject.optInt("condition");
        this.aqW = jSONObject.optString("toast_text");
        this.awu = jSONObject.optString("first_recharge_bg");
        this.awv = jSONObject.optString("first_recharge_button");
        this.aww = jSONObject.optString("first_recharge_h5");
    }
}
