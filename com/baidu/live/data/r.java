package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r {
    public int Sk;
    public int Sl;
    public int Sm;

    public void parseJson(JSONObject jSONObject) {
        this.Sk = jSONObject.optInt("watch_time");
        this.Sl = jSONObject.optInt("up_to_level");
        this.Sm = jSONObject.optInt("first_unlock_effective", 0);
    }

    public boolean ou() {
        return this.Sm == 1;
    }
}
