package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cg {
    public String aIu;
    public int buttonStatus;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.buttonStatus = jSONObject.optInt("button_status");
            this.aIu = jSONObject.optString("toast_text");
        }
    }
}
