package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bu {
    public String aIv;
    public int buttonStatus;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.buttonStatus = jSONObject.optInt("button_status");
            this.aIv = jSONObject.optString("toast_text");
        }
    }
}
