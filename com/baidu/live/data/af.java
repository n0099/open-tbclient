package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class af {
    public int aHH;
    public int aHI;
    public int aHJ;

    public void parseJson(JSONObject jSONObject) {
        this.aHH = jSONObject.optInt("watch_time");
        this.aHI = jSONObject.optInt("up_to_level");
        this.aHJ = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean CR() {
        return this.aHJ == 1;
    }
}
