package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bc {
    public String webUrl;

    public bc(JSONObject jSONObject) {
        this.webUrl = jSONObject.optString("rotary_table_h5_url");
    }
}
