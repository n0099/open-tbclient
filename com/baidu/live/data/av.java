package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class av {
    public int aPA;
    public int aPB;
    public int aPz;

    public void parseJson(JSONObject jSONObject) {
        this.aPz = jSONObject.optInt("watch_time");
        this.aPA = jSONObject.optInt("up_to_level");
        this.aPB = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean Cw() {
        return this.aPB == 1;
    }
}
