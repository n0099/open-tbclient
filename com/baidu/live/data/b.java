package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private int aHA;
    private String aHB;
    private String aHC;

    public void parseJson(JSONObject jSONObject) {
        this.aHA = jSONObject.optInt("tags_switch", 0);
        this.aHB = jSONObject.optString("anchor_category_info");
        this.aHC = jSONObject.optString("anchor_category_msg");
    }

    public String Bh() {
        return this.aHC;
    }

    public boolean Bi() {
        return this.aHA == 1;
    }
}
