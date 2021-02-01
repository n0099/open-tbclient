package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cp {
    public String aIu;
    public int aQt;
    public String aRB;
    public String aRC;
    public String aRD;
    public String aRE;
    public boolean aRF;
    public int aRp;
    public int aRq;

    public cp(JSONObject jSONObject) {
        this.aRp = jSONObject.optInt("show_times_daily");
        this.aRq = jSONObject.optInt("continue_show_times");
        this.aQt = jSONObject.optInt("condition");
        this.aIu = jSONObject.optString("toast_text");
        this.aRB = jSONObject.optString("first_recharge_bg");
        this.aRC = jSONObject.optString("first_recharge_button");
        this.aRD = jSONObject.optString("first_recharge_h5");
        this.aRE = jSONObject.optString("first_recharge_h5_audio");
        this.aRF = jSONObject.optInt("audio_show_switch") == 1;
    }
}
