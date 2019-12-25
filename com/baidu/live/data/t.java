package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class t {
    public int YZ;
    public int Za;
    public int Zb;

    public void parseJson(JSONObject jSONObject) {
        this.YZ = jSONObject.optInt("watch_time");
        this.Za = jSONObject.optInt("up_to_level");
        this.Zb = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean pP() {
        return this.Zb == 1;
    }
}
