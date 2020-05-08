package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y {
    public int atQ;
    public int atR;
    public int atS;

    public void parseJson(JSONObject jSONObject) {
        this.atQ = jSONObject.optInt("watch_time");
        this.atR = jSONObject.optInt("up_to_level");
        this.atS = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean uZ() {
        return this.atS == 1;
    }
}
