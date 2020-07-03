package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bg {
    public String ayj;
    public int buttonStatus;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.buttonStatus = jSONObject.optInt("button_status");
            this.ayj = jSONObject.optString("toast_text");
        }
    }
}
