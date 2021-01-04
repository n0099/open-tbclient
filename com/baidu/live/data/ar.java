package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ar {
    public int aPQ;
    public int aPR;
    public int aPS;

    public void parseJson(JSONObject jSONObject) {
        this.aPQ = jSONObject.optInt("watch_time");
        this.aPR = jSONObject.optInt("up_to_level");
        this.aPS = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean Fb() {
        return this.aPS == 1;
    }
}
