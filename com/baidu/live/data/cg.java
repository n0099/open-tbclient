package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cg {
    public String aKm;
    public int aRq;
    public int aSe;
    public int aSf;
    public String aSo;
    public String aSp;
    public String aSq;
    public String aSr;
    public boolean aSs;

    public cg(JSONObject jSONObject) {
        this.aSe = jSONObject.optInt("show_times_daily");
        this.aSf = jSONObject.optInt("continue_show_times");
        this.aRq = jSONObject.optInt("condition");
        this.aKm = jSONObject.optString("toast_text");
        this.aSo = jSONObject.optString("first_recharge_bg");
        this.aSp = jSONObject.optString("first_recharge_button");
        this.aSq = jSONObject.optString("first_recharge_h5");
        this.aSr = jSONObject.optString("first_recharge_h5_audio");
        this.aSs = jSONObject.optInt("audio_show_switch") == 1;
    }
}
