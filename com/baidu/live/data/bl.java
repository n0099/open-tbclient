package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bl {
    public int aFe;
    public int aFf;
    public int aFg;

    public bl(JSONObject jSONObject) {
        this.aFe = jSONObject.optInt("show_times_daily");
        this.aFf = jSONObject.optInt("continue_show_times");
        this.aFg = jSONObject.optInt("condition");
    }
}
