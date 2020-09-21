package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private int aDG;
    private String aDH;
    private String aDI;

    public void parseJson(JSONObject jSONObject) {
        this.aDG = jSONObject.optInt("tags_switch", 0);
        this.aDH = jSONObject.optString("anchor_category_info");
        this.aDI = jSONObject.optString("anchor_category_msg");
    }

    public String CC() {
        return this.aDI;
    }

    public boolean CD() {
        return this.aDG == 1;
    }
}
