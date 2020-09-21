package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ak {
    public int aJd;
    public int aJe;
    public int aJf;

    public void parseJson(JSONObject jSONObject) {
        this.aJd = jSONObject.optInt("watch_time");
        this.aJe = jSONObject.optInt("up_to_level");
        this.aJf = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean Dh() {
        return this.aJf == 1;
    }
}
