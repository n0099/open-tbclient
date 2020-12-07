package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cl {
    public String webUrl;

    public cl(JSONObject jSONObject) {
        this.webUrl = jSONObject.optString("rotary_table_h5_url");
    }
}
