package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private int aIE;
    private String aIF;
    private String aIG;

    public void parseJson(JSONObject jSONObject) {
        this.aIE = jSONObject.optInt("tags_switch", 0);
        this.aIF = jSONObject.optString("anchor_category_info");
        this.aIG = jSONObject.optString("anchor_category_msg");
    }

    public String Fa() {
        return this.aIG;
    }

    public boolean Fb() {
        return this.aIE == 1;
    }
}
