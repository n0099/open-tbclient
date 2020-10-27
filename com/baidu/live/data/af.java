package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class af {
    public String aJq;

    public void parser(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJq = jSONObject.optString("dynamic_gift_id");
        }
    }
}
