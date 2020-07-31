package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aj {
    public long aCX;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aCX = jSONObject.optLong("challenge_info_interval");
        }
    }
}
