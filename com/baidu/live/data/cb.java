package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cb {
    public long aRT = 2000;
    public float aRU = 1.0f;
    public long aRV = 2000;
    public long aRW = 500;
    public cc aRX;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aRT = jSONObject.optLong("player_cache_duration", 2000L);
            this.aRU = (float) jSONObject.optDouble("player_speed", 1.0d);
            this.aRV = jSONObject.optLong("change_speed_cache_duration", 2000L);
            this.aRW = jSONObject.optLong("player_max_analyze_duration", 500L);
            this.aRX = new cc();
            this.aRX.parse(jSONObject.optJSONObject("dating_anim"));
        }
    }
}
