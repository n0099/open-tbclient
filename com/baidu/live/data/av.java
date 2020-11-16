package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class av {
    public long aMG;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aMG = jSONObject.optLong("challenge_info_interval");
        }
    }
}
