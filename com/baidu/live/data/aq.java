package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aq {
    public long aMJ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aMJ = jSONObject.optLong("challenge_info_interval");
        }
    }
}
