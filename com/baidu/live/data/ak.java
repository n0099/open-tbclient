package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ak {
    public int aMi;
    public int aMj;
    public int aMk;

    public void parseJson(JSONObject jSONObject) {
        this.aMi = jSONObject.optInt("watch_time");
        this.aMj = jSONObject.optInt("up_to_level");
        this.aMk = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean Ee() {
        return this.aMk == 1;
    }
}
