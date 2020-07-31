package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bh {
    public String azw;
    public int buttonStatus;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.buttonStatus = jSONObject.optInt("button_status");
            this.azw = jSONObject.optString("toast_text");
        }
    }
}
