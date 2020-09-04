package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class af {
    public int aHJ;
    public int aHK;
    public int aHL;

    public void parseJson(JSONObject jSONObject) {
        this.aHJ = jSONObject.optInt("watch_time");
        this.aHK = jSONObject.optInt("up_to_level");
        this.aHL = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean CR() {
        return this.aHL == 1;
    }
}
