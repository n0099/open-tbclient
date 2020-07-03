package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class br {
    public String webUrl;

    public br(JSONObject jSONObject) {
        this.webUrl = jSONObject.optString("rotary_table_h5_url");
    }
}
