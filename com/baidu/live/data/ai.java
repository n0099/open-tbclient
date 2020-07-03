package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ai {
    public long aBC;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aBC = jSONObject.optLong("challenge_info_interval");
        }
    }
}
