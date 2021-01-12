package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private int aEn;
    private String aEo;
    private String aEp;

    public void parseJson(JSONObject jSONObject) {
        this.aEn = jSONObject.optInt("tags_switch", 0);
        this.aEo = jSONObject.optString("anchor_category_info");
        this.aEp = jSONObject.optString("anchor_category_msg");
    }

    public String Au() {
        return this.aEp;
    }

    public boolean Av() {
        return this.aEn == 1;
    }
}
