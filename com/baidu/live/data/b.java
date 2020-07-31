package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private int axR;
    private String axS;
    private String axT;

    public void parseJson(JSONObject jSONObject) {
        this.axR = jSONObject.optInt("tags_switch", 0);
        this.axS = jSONObject.optString("anchor_category_info");
        this.axT = jSONObject.optString("anchor_category_msg");
    }

    public String wP() {
        return this.axT;
    }

    public boolean wQ() {
        return this.axR == 1;
    }
}
