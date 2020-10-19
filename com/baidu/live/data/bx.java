package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bx {
    public String aHU;
    public int aOz;
    public int aPb;
    public int aPc;
    public String aPl;
    public String aPm;
    public String aPn;
    public String aPo;
    public boolean aPp;

    public bx(JSONObject jSONObject) {
        this.aPb = jSONObject.optInt("show_times_daily");
        this.aPc = jSONObject.optInt("continue_show_times");
        this.aOz = jSONObject.optInt("condition");
        this.aHU = jSONObject.optString("toast_text");
        this.aPl = jSONObject.optString("first_recharge_bg");
        this.aPm = jSONObject.optString("first_recharge_button");
        this.aPn = jSONObject.optString("first_recharge_h5");
        this.aPo = jSONObject.optString("first_recharge_h5_audio");
        this.aPp = jSONObject.optInt("audio_show_switch") == 1;
    }
}
