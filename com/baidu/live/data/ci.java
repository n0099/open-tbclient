package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ci {
    public String aKL;
    public int aSZ;
    public int aSf;
    public int aTa;
    public String aTm;
    public String aTn;
    public String aTo;
    public String aTp;
    public boolean aTq;

    public ci(JSONObject jSONObject) {
        this.aSZ = jSONObject.optInt("show_times_daily");
        this.aTa = jSONObject.optInt("continue_show_times");
        this.aSf = jSONObject.optInt("condition");
        this.aKL = jSONObject.optString("toast_text");
        this.aTm = jSONObject.optString("first_recharge_bg");
        this.aTn = jSONObject.optString("first_recharge_button");
        this.aTo = jSONObject.optString("first_recharge_h5");
        this.aTp = jSONObject.optString("first_recharge_h5_audio");
        this.aTq = jSONObject.optInt("audio_show_switch") == 1;
    }
}
