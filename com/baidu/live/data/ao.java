package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ao {
    public int aMe;
    public int aMf;
    public int aMg;

    public void parseJson(JSONObject jSONObject) {
        this.aMe = jSONObject.optInt("watch_time");
        this.aMf = jSONObject.optInt("up_to_level");
        this.aMg = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean Ea() {
        return this.aMg == 1;
    }
}
