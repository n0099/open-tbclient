package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bc {
    public long aQe;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQe = jSONObject.optLong("challenge_info_interval");
        }
    }
}
