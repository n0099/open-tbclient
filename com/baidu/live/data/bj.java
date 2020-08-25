package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bj {
    public String aDS;
    public int buttonStatus;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.buttonStatus = jSONObject.optInt("button_status");
            this.aDS = jSONObject.optString("toast_text");
        }
    }
}
