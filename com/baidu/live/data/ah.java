package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ah {
    public int aJD;
    public long aJE;
    public long aJF;
    public String division;
    public String iconUrl;
    public int maxStar;
    public String name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.division = jSONObject.optString("division");
            this.aJD = jSONObject.optInt("cur_star");
            this.maxStar = jSONObject.optInt("max_star", 5);
            this.aJE = jSONObject.optInt("min_score");
            this.aJF = jSONObject.optInt("max_score");
            this.name = jSONObject.optString("name");
            this.iconUrl = jSONObject.optString("icon_url");
        }
    }
}
