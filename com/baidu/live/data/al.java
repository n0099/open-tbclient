package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class al {
    public long aIh;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIh = jSONObject.optLong("challenge_info_interval");
        }
    }
}
