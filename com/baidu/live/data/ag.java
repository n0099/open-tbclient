package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ag {
    public String aKq;

    public void parser(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKq = jSONObject.optString("dynamic_gift_id");
        }
    }
}
