package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class an {
    public int aMN;
    public int aMO;
    public int aMP;

    public void parseJson(JSONObject jSONObject) {
        this.aMN = jSONObject.optInt("watch_time");
        this.aMO = jSONObject.optInt("up_to_level");
        this.aMP = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean En() {
        return this.aMP == 1;
    }
}
