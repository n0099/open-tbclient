package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ce {
    public String aHB;
    public int aOq;
    public int aPc;
    public int aPd;
    public String aPm;
    public String aPn;
    public String aPo;
    public String aPp;
    public boolean aPq;

    public ce(JSONObject jSONObject) {
        this.aPc = jSONObject.optInt("show_times_daily");
        this.aPd = jSONObject.optInt("continue_show_times");
        this.aOq = jSONObject.optInt("condition");
        this.aHB = jSONObject.optString("toast_text");
        this.aPm = jSONObject.optString("first_recharge_bg");
        this.aPn = jSONObject.optString("first_recharge_button");
        this.aPo = jSONObject.optString("first_recharge_h5");
        this.aPp = jSONObject.optString("first_recharge_h5_audio");
        this.aPq = jSONObject.optInt("audio_show_switch") == 1;
    }
}
