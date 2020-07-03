package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ad {
    public int aBk;
    public int aBl;
    public int aBm;

    public void parseJson(JSONObject jSONObject) {
        this.aBk = jSONObject.optInt("watch_time");
        this.aBl = jSONObject.optInt("up_to_level");
        this.aBm = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean wM() {
        return this.aBm == 1;
    }
}
