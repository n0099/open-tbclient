package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class al {
    public long aIj;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIj = jSONObject.optLong("challenge_info_interval");
        }
    }
}
