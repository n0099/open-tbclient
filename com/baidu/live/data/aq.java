package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aq {
    public long aJE;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aJE = jSONObject.optLong("challenge_info_interval");
        }
    }
}
