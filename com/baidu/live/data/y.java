package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y {
    public int atK;
    public int atL;
    public int atM;

    public void parseJson(JSONObject jSONObject) {
        this.atK = jSONObject.optInt("watch_time");
        this.atL = jSONObject.optInt("up_to_level");
        this.atM = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean va() {
        return this.atM == 1;
    }
}
