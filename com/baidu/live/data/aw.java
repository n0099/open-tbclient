package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class aw {
    public long aPF;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPF = jSONObject.optLong("challenge_info_interval");
        }
    }
}
