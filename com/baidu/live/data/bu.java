package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bu {
    public String webUrl;

    public bu(JSONObject jSONObject) {
        this.webUrl = jSONObject.optString("rotary_table_h5_url");
    }
}
