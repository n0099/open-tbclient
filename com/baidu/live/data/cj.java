package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cj {
    public String webUrl;

    public cj(JSONObject jSONObject) {
        this.webUrl = jSONObject.optString("rotary_table_h5_url");
    }
}
