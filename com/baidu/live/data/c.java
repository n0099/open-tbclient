package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private int aHI;
    private String aHJ;
    private String aHK;

    public void parseJson(JSONObject jSONObject) {
        this.aHI = jSONObject.optInt("tags_switch", 0);
        this.aHJ = jSONObject.optString("anchor_category_info");
        this.aHK = jSONObject.optString("anchor_category_msg");
    }

    public String DZ() {
        return this.aHK;
    }

    public boolean Ea() {
        return this.aHI == 1;
    }
}
