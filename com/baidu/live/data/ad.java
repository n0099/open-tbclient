package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ad {
    public int aCx;
    public int aCy;
    public int aCz;

    public void parseJson(JSONObject jSONObject) {
        this.aCx = jSONObject.optInt("watch_time");
        this.aCy = jSONObject.optInt("up_to_level");
        this.aCz = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean xo() {
        return this.aCz == 1;
    }
}
