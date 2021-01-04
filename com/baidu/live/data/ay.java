package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ay {
    public long aQu;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQu = jSONObject.optLong("challenge_info_interval");
        }
    }
}
