package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class z {
    public int aFE;
    public long aFF;
    public long aFG;
    public String division;
    public String iconUrl;
    public int maxStar;
    public String name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.division = jSONObject.optString("division");
            this.aFE = jSONObject.optInt("cur_star");
            this.maxStar = jSONObject.optInt("max_star", 5);
            this.aFF = jSONObject.optInt("min_score");
            this.aFG = jSONObject.optInt("max_score");
            this.name = jSONObject.optString("name");
            this.iconUrl = jSONObject.optString("icon_url");
        }
    }
}
