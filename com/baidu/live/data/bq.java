package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bq {
    public String aHU;
    public int buttonStatus;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.buttonStatus = jSONObject.optInt("button_status");
            this.aHU = jSONObject.optString("toast_text");
        }
    }
}
