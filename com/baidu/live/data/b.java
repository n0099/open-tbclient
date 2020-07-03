package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private int awE;
    private String awF;
    private String awG;

    public void parseJson(JSONObject jSONObject) {
        this.awE = jSONObject.optInt("tags_switch", 0);
        this.awF = jSONObject.optString("anchor_category_info");
        this.awG = jSONObject.optString("anchor_category_msg");
    }

    public String wn() {
        return this.awG;
    }

    public boolean wo() {
        return this.awE == 1;
    }
}
