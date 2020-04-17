package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bh {
    public String webUrl;

    public bh(JSONObject jSONObject) {
        this.webUrl = jSONObject.optString("rotary_table_h5_url");
    }
}
