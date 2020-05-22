package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bm {
    public String webUrl;

    public bm(JSONObject jSONObject) {
        this.webUrl = jSONObject.optString("rotary_table_h5_url");
    }
}
