package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ci {
    public String aFY;
    public int aNs;
    public String aOA;
    public String aOB;
    public String aOC;
    public boolean aOD;
    public int aOm;
    public int aOn;
    public String aOz;

    public ci(JSONObject jSONObject) {
        this.aOm = jSONObject.optInt("show_times_daily");
        this.aOn = jSONObject.optInt("continue_show_times");
        this.aNs = jSONObject.optInt("condition");
        this.aFY = jSONObject.optString("toast_text");
        this.aOz = jSONObject.optString("first_recharge_bg");
        this.aOA = jSONObject.optString("first_recharge_button");
        this.aOB = jSONObject.optString("first_recharge_h5");
        this.aOC = jSONObject.optString("first_recharge_h5_audio");
        this.aOD = jSONObject.optInt("audio_show_switch") == 1;
    }
}
