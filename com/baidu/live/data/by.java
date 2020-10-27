package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class by {
    public long aPF = 2000;
    public float aPG = 1.0f;
    public long aPH = 2000;
    public long aPI = 500;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPF = jSONObject.optLong("player_cache_duration", 2000L);
            this.aPG = (float) jSONObject.optDouble("player_speed", 1.0d);
            this.aPH = jSONObject.optLong("change_speed_cache_duration", 2000L);
            this.aPI = jSONObject.optLong("player_max_analyze_duration", 500L);
        }
    }
}
