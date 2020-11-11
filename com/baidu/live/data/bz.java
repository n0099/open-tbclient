package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bz {
    public long aQC = 2000;
    public float aQD = 1.0f;
    public long aQE = 2000;
    public long aQF = 500;
    public ca aQG;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQC = jSONObject.optLong("player_cache_duration", 2000L);
            this.aQD = (float) jSONObject.optDouble("player_speed", 1.0d);
            this.aQE = jSONObject.optLong("change_speed_cache_duration", 2000L);
            this.aQF = jSONObject.optLong("player_max_analyze_duration", 500L);
            this.aQG = new ca();
            this.aQG.parse(jSONObject.optJSONObject("dating_anim"));
        }
    }
}
