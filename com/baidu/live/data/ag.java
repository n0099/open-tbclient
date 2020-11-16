package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ag {
    public String aIF;

    public void parser(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIF = jSONObject.optString("dynamic_gift_id");
        }
    }
}
