package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private int aGK;
    private String aGL;
    private String aGM;

    public void parseJson(JSONObject jSONObject) {
        this.aGK = jSONObject.optInt("tags_switch", 0);
        this.aGL = jSONObject.optString("anchor_category_info");
        this.aGM = jSONObject.optString("anchor_category_msg");
    }

    public String Dz() {
        return this.aGM;
    }

    public boolean DA() {
        return this.aGK == 1;
    }
}
