package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private int aCT;
    private String aCU;
    private String aCV;

    public void parseJson(JSONObject jSONObject) {
        this.aCT = jSONObject.optInt("tags_switch", 0);
        this.aCU = jSONObject.optString("anchor_category_info");
        this.aCV = jSONObject.optString("anchor_category_msg");
    }

    public String Cn() {
        return this.aCV;
    }

    public boolean Co() {
        return this.aCT == 1;
    }
}
