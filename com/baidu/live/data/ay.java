package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ay {
    public String webUrl;

    public ay(JSONObject jSONObject) {
        this.webUrl = jSONObject.optString("rotary_table_h5_url");
    }
}
