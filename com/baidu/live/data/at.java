package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class at {
    public long aNo;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNo = jSONObject.optLong("challenge_info_interval");
        }
    }
}
