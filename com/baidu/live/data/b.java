package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private int aGa;
    private String aGb;
    private String aGc;

    public void parseJson(JSONObject jSONObject) {
        this.aGa = jSONObject.optInt("tags_switch", 0);
        this.aGb = jSONObject.optString("anchor_category_info");
        this.aGc = jSONObject.optString("anchor_category_msg");
    }

    public String Be() {
        return this.aGc;
    }

    public boolean Bf() {
        return this.aGa == 1;
    }
}
