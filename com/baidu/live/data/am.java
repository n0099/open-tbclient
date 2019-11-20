package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class am {
    public int Ul;
    public int Um;
    public int Un;
    public String Ut;
    public String Uu;
    public String Uv;
    public String Uw;

    public am(JSONObject jSONObject) {
        this.Ul = jSONObject.optInt("show_times_daily");
        this.Um = jSONObject.optInt("continue_show_times");
        this.Un = jSONObject.optInt("condition");
        this.Ut = jSONObject.optString("toast_text");
        this.Uu = jSONObject.optString("first_recharge_bg");
        this.Uv = jSONObject.optString("first_recharge_button");
        this.Uw = jSONObject.optString("first_recharge_h5");
    }
}
