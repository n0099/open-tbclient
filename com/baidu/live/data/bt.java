package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bt {
    public long aLR = 2000;
    public float aLS = 1.0f;
    public long aLT = 2000;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLR = jSONObject.optLong("player_cache_duration", 2000L);
            this.aLS = (float) jSONObject.optDouble("player_speed", 1.0d);
            this.aLT = jSONObject.optLong("change_speed_cache_duration", 2000L);
        }
    }
}
