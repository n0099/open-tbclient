package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bt {
    public long aOW = 2000;
    public float aOX = 1.0f;
    public long aOY = 2000;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOW = jSONObject.optLong("player_cache_duration", 2000L);
            this.aOX = (float) jSONObject.optDouble("player_speed", 1.0d);
            this.aOY = jSONObject.optLong("change_speed_cache_duration", 2000L);
        }
    }
}
