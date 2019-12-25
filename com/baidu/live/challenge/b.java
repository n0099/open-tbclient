package com.baidu.live.challenge;

import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public boolean hasMore;
    public int pn;
    public int ps;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.pn = jSONObject.optInt(Config.PACKAGE_NAME);
            this.ps = jSONObject.optInt("ps");
            this.hasMore = jSONObject.optInt("has_more") == 1;
        }
    }
}
