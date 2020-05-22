package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private String auA;
    private int auy;
    private String auz;

    public void parseJson(JSONObject jSONObject) {
        this.auy = jSONObject.optInt("tags_switch", 0);
        this.auz = jSONObject.optString("anchor_category_info");
        this.auA = jSONObject.optString("anchor_category_msg");
    }

    public String vP() {
        return this.auA;
    }

    public boolean vQ() {
        return this.auy == 1;
    }
}
