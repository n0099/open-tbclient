package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ay {
    public long aLH;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aLH = jSONObject.optLong("challenge_info_interval");
        }
    }
}
