package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cl {
    public long aRe = 2000;
    public float aRf = 1.0f;
    public long aRg = 2000;
    public long aRh = 500;
    public ck aRi;
    public String aRj;
    public long aRk;
    public long aRl;
    public long aRm;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aRe = jSONObject.optLong("player_cache_duration", 2000L);
            this.aRf = (float) jSONObject.optDouble("player_speed", 1.0d);
            this.aRg = jSONObject.optLong("change_speed_cache_duration", 2000L);
            this.aRh = jSONObject.optLong("player_max_analyze_duration", 500L);
            this.aRi = new ck();
            this.aRi.parse(jSONObject.optJSONObject("dating_anim"));
            this.aRj = jSONObject.optString("live_notice");
            this.aRk = jSONObject.optLong("im_num_p1", 10L);
            this.aRl = jSONObject.optLong("im_num_p2", 30L);
            this.aRm = jSONObject.optLong("im_num_p3", 5000L);
        }
    }
}
