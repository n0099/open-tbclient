package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class w {
    public int abq;
    public int abr;
    public int abt;

    public void parseJson(JSONObject jSONObject) {
        this.abq = jSONObject.optInt("watch_time");
        this.abr = jSONObject.optInt("up_to_level");
        this.abt = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean qJ() {
        return this.abt == 1;
    }
}
