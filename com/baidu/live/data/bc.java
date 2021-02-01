package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bc {
    public long aOE;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOE = jSONObject.optLong("challenge_info_interval");
        }
    }
}
