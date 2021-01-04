package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cg {
    public int aSZ;
    public int aSf;
    public int aTa;

    public cg(JSONObject jSONObject) {
        this.aSZ = jSONObject.optInt("show_times_daily");
        this.aTa = jSONObject.optInt("continue_show_times");
        this.aSf = jSONObject.optInt("condition");
    }
}
