package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ar {
    public int aLd;
    public int aLe;
    public int aLf;

    public void parseJson(JSONObject jSONObject) {
        this.aLd = jSONObject.optInt("watch_time");
        this.aLe = jSONObject.optInt("up_to_level");
        this.aLf = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean Bg() {
        return this.aLf == 1;
    }
}
