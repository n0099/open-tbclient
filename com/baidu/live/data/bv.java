package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bv {
    public String aHB;
    public int buttonStatus;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.buttonStatus = jSONObject.optInt("button_status");
            this.aHB = jSONObject.optString("toast_text");
        }
    }
}
