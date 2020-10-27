package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private int aGS;
    private String aGT;
    private String aGU;

    public void parseJson(JSONObject jSONObject) {
        this.aGS = jSONObject.optInt("tags_switch", 0);
        this.aGT = jSONObject.optString("anchor_category_info");
        this.aGU = jSONObject.optString("anchor_category_msg");
    }

    public String DG() {
        return this.aGU;
    }

    public boolean DH() {
        return this.aGS == 1;
    }
}
