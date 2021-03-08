package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cg {
    public String aJU;
    public int buttonStatus;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.buttonStatus = jSONObject.optInt("button_status");
            this.aJU = jSONObject.optString("toast_text");
        }
    }
}
