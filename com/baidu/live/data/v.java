package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class v {
    public int Zn;
    public int Zo;
    public int Zp;

    public void parseJson(JSONObject jSONObject) {
        this.Zn = jSONObject.optInt("watch_time");
        this.Zo = jSONObject.optInt("up_to_level");
        this.Zp = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean pT() {
        return this.Zp == 1;
    }
}
