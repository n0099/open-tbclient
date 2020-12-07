package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bx {
    public String aKm;
    public int buttonStatus;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.buttonStatus = jSONObject.optInt("button_status");
            this.aKm = jSONObject.optString("toast_text");
        }
    }
}
