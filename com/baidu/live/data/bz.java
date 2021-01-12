package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bz {
    public String aFY;
    public int buttonStatus;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.buttonStatus = jSONObject.optInt("button_status");
            this.aFY = jSONObject.optString("toast_text");
        }
    }
}
