package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r {
    public int SD;
    public int SF;
    public int SG;

    public void parseJson(JSONObject jSONObject) {
        this.SD = jSONObject.optInt("watch_time");
        this.SF = jSONObject.optInt("up_to_level");
        this.SG = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean ou() {
        return this.SG == 1;
    }
}
