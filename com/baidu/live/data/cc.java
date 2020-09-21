package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cc {
    public String webUrl;

    public cc(JSONObject jSONObject) {
        this.webUrl = jSONObject.optString("rotary_table_h5_url");
    }
}
