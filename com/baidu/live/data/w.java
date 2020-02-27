package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class w {
    public int abg;
    public int abh;
    public int abi;

    public void parseJson(JSONObject jSONObject) {
        this.abg = jSONObject.optInt("watch_time");
        this.abh = jSONObject.optInt("up_to_level");
        this.abi = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean qE() {
        return this.abi == 1;
    }
}
