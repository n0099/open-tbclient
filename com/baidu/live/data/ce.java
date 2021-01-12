package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ce {
    public long aOb = 2000;
    public float aOc = 1.0f;
    public long aOd = 2000;
    public long aOe = 500;
    public cd aOf;
    public String aOg;
    public long aOh;
    public long aOi;
    public long aOj;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOb = jSONObject.optLong("player_cache_duration", 2000L);
            this.aOc = (float) jSONObject.optDouble("player_speed", 1.0d);
            this.aOd = jSONObject.optLong("change_speed_cache_duration", 2000L);
            this.aOe = jSONObject.optLong("player_max_analyze_duration", 500L);
            this.aOf = new cd();
            this.aOf.parse(jSONObject.optJSONObject("dating_anim"));
            this.aOg = jSONObject.optString("live_notice");
            this.aOh = jSONObject.optLong("im_num_p1", 10L);
            this.aOi = jSONObject.optLong("im_num_p2", 30L);
            this.aOj = jSONObject.optLong("im_num_p3", 5000L);
        }
    }
}
