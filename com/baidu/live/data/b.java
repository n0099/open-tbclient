package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private int aJa;
    private String aJb;
    private String aJc;

    public void parseJson(JSONObject jSONObject) {
        this.aJa = jSONObject.optInt("tags_switch", 0);
        this.aJb = jSONObject.optString("anchor_category_info");
        this.aJc = jSONObject.optString("anchor_category_msg");
    }

    public String Ep() {
        return this.aJc;
    }

    public boolean Eq() {
        return this.aJa == 1;
    }
}
