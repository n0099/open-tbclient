package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class aq {
    public String webUrl;

    public aq(JSONObject jSONObject) {
        this.webUrl = jSONObject.optString("rotary_table_h5_url");
    }
}
