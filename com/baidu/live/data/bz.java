package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bz {
    public long aOR = 2000;
    public float aOS = 1.0f;
    public long aOT = 2000;
    public long aOU = 500;
    public ca aOV;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOR = jSONObject.optLong("player_cache_duration", 2000L);
            this.aOS = (float) jSONObject.optDouble("player_speed", 1.0d);
            this.aOT = jSONObject.optLong("change_speed_cache_duration", 2000L);
            this.aOU = jSONObject.optLong("player_max_analyze_duration", 500L);
            this.aOV = new ca();
            this.aOV.parse(jSONObject.optJSONObject("dating_anim"));
        }
    }
}
