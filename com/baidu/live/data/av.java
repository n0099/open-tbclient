package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class av {
    public int aNZ;
    public int aOa;
    public int aOb;

    public void parseJson(JSONObject jSONObject) {
        this.aNZ = jSONObject.optInt("watch_time");
        this.aOa = jSONObject.optInt("up_to_level");
        this.aOb = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean Ct() {
        return this.aOb == 1;
    }
}
