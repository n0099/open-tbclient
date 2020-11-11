package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ce {
    public String aJm;
    public int aQN;
    public int aQO;
    public String aQX;
    public String aQY;
    public String aQZ;
    public int aQb;
    public String aRa;
    public boolean aRb;

    public ce(JSONObject jSONObject) {
        this.aQN = jSONObject.optInt("show_times_daily");
        this.aQO = jSONObject.optInt("continue_show_times");
        this.aQb = jSONObject.optInt("condition");
        this.aJm = jSONObject.optString("toast_text");
        this.aQX = jSONObject.optString("first_recharge_bg");
        this.aQY = jSONObject.optString("first_recharge_button");
        this.aQZ = jSONObject.optString("first_recharge_h5");
        this.aRa = jSONObject.optString("first_recharge_h5_audio");
        this.aRb = jSONObject.optInt("audio_show_switch") == 1;
    }
}
