package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class be {
    public String webUrl;

    public be(JSONObject jSONObject) {
        this.webUrl = jSONObject.optString("rotary_table_h5_url");
    }
}
