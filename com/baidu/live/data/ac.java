package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ac {
    public int ayT;
    public int ayU;
    public int ayV;

    public void parseJson(JSONObject jSONObject) {
        this.ayT = jSONObject.optInt("watch_time");
        this.ayU = jSONObject.optInt("up_to_level");
        this.ayV = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean wo() {
        return this.ayV == 1;
    }
}
