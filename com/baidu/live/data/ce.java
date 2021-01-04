package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ce {
    public long aSO = 2000;
    public float aSP = 1.0f;
    public long aSQ = 2000;
    public long aSR = 500;
    public cd aSS;
    public String aST;
    public long aSU;
    public long aSV;
    public long aSW;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aSO = jSONObject.optLong("player_cache_duration", 2000L);
            this.aSP = (float) jSONObject.optDouble("player_speed", 1.0d);
            this.aSQ = jSONObject.optLong("change_speed_cache_duration", 2000L);
            this.aSR = jSONObject.optLong("player_max_analyze_duration", 500L);
            this.aSS = new cd();
            this.aSS.parse(jSONObject.optJSONObject("dating_anim"));
            this.aST = jSONObject.optString("live_notice");
            this.aSU = jSONObject.optLong("im_num_p1", 10L);
            this.aSV = jSONObject.optLong("im_num_p2", 30L);
            this.aSW = jSONObject.optLong("im_num_p3", 5000L);
        }
    }
}
