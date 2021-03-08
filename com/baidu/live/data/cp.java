package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cp {
    public String aJU;
    public int aRT;
    public int aSP;
    public int aSQ;
    public String aTb;
    public String aTc;
    public String aTd;
    public String aTe;
    public boolean aTf;

    public cp(JSONObject jSONObject) {
        this.aSP = jSONObject.optInt("show_times_daily");
        this.aSQ = jSONObject.optInt("continue_show_times");
        this.aRT = jSONObject.optInt("condition");
        this.aJU = jSONObject.optString("toast_text");
        this.aTb = jSONObject.optString("first_recharge_bg");
        this.aTc = jSONObject.optString("first_recharge_button");
        this.aTd = jSONObject.optString("first_recharge_h5");
        this.aTe = jSONObject.optString("first_recharge_h5_audio");
        this.aTf = jSONObject.optInt("audio_show_switch") == 1;
    }
}
