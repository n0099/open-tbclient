package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class av {
    public long aOr;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOr = jSONObject.optLong("challenge_info_interval");
        }
    }
}
