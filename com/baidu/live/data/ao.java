package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ao {
    public int aNP;
    public int aNQ;
    public int aNR;

    public void parseJson(JSONObject jSONObject) {
        this.aNP = jSONObject.optInt("watch_time");
        this.aNQ = jSONObject.optInt("up_to_level");
        this.aNR = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean EJ() {
        return this.aNR == 1;
    }
}
