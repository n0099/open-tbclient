package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cl {
    public long aSE = 2000;
    public float aSF = 1.0f;
    public long aSG = 2000;
    public long aSH = 500;
    public ck aSI;
    public String aSJ;
    public long aSK;
    public long aSL;
    public long aSM;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSE = jSONObject.optLong("player_cache_duration", 2000L);
            this.aSF = (float) jSONObject.optDouble("player_speed", 1.0d);
            this.aSG = jSONObject.optLong("change_speed_cache_duration", 2000L);
            this.aSH = jSONObject.optLong("player_max_analyze_duration", 500L);
            this.aSI = new ck();
            this.aSI.parse(jSONObject.optJSONObject("dating_anim"));
            this.aSJ = jSONObject.optString("live_notice");
            this.aSK = jSONObject.optLong("im_num_p1", 10L);
            this.aSL = jSONObject.optLong("im_num_p2", 30L);
            this.aSM = jSONObject.optLong("im_num_p3", 5000L);
        }
    }
}
