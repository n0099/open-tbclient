package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cc {
    public String aIv;
    public int aPL;
    public int aPM;
    public String aPV;
    public String aPW;
    public String aPX;
    public String aPY;
    public boolean aPZ;
    public int aPe;

    public cc(JSONObject jSONObject) {
        this.aPL = jSONObject.optInt("show_times_daily");
        this.aPM = jSONObject.optInt("continue_show_times");
        this.aPe = jSONObject.optInt("condition");
        this.aIv = jSONObject.optString("toast_text");
        this.aPV = jSONObject.optString("first_recharge_bg");
        this.aPW = jSONObject.optString("first_recharge_button");
        this.aPX = jSONObject.optString("first_recharge_h5");
        this.aPY = jSONObject.optString("first_recharge_h5_audio");
        this.aPZ = jSONObject.optInt("audio_show_switch") == 1;
    }
}
