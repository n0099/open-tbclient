package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bx {
    public String aEQ;
    public int aLW;
    public int aLX;
    public int aLu;
    public String aMg;
    public String aMh;
    public String aMi;
    public String aMj;
    public boolean aMk;

    public bx(JSONObject jSONObject) {
        this.aLW = jSONObject.optInt("show_times_daily");
        this.aLX = jSONObject.optInt("continue_show_times");
        this.aLu = jSONObject.optInt("condition");
        this.aEQ = jSONObject.optString("toast_text");
        this.aMg = jSONObject.optString("first_recharge_bg");
        this.aMh = jSONObject.optString("first_recharge_button");
        this.aMi = jSONObject.optString("first_recharge_h5");
        this.aMj = jSONObject.optString("first_recharge_h5_audio");
        this.aMk = jSONObject.optInt("audio_show_switch") == 1;
    }
}
