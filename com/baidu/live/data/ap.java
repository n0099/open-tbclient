package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ap {
    public int aPb;
    public int aPc;
    public int aPd;

    public void parseJson(JSONObject jSONObject) {
        this.aPb = jSONObject.optInt("watch_time");
        this.aPc = jSONObject.optInt("up_to_level");
        this.aPd = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean FL() {
        return this.aPd == 1;
    }
}
