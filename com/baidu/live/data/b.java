package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private int aCV;
    private String aCW;
    private String aCX;

    public void parseJson(JSONObject jSONObject) {
        this.aCV = jSONObject.optInt("tags_switch", 0);
        this.aCW = jSONObject.optString("anchor_category_info");
        this.aCX = jSONObject.optString("anchor_category_msg");
    }

    public String Cn() {
        return this.aCX;
    }

    public boolean Co() {
        return this.aCV == 1;
    }
}
