package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private int aFX;
    private String aFY;
    private String aFZ;

    public void parseJson(JSONObject jSONObject) {
        this.aFX = jSONObject.optInt("tags_switch", 0);
        this.aFY = jSONObject.optString("anchor_category_info");
        this.aFZ = jSONObject.optString("anchor_category_msg");
    }

    public String Dq() {
        return this.aFZ;
    }

    public boolean Dr() {
        return this.aFX == 1;
    }
}
