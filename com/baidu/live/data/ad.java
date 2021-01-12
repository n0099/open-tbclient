package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ad {
    public int aGZ;
    public long aHa;
    public long aHb;
    public String division;
    public String iconUrl;
    public int maxStar;
    public String name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.division = jSONObject.optString("division");
            this.aGZ = jSONObject.optInt("cur_star");
            this.maxStar = jSONObject.optInt("max_star", 5);
            this.aHa = jSONObject.optInt("min_score");
            this.aHb = jSONObject.optInt("max_score");
            this.name = jSONObject.optString("name");
            this.iconUrl = jSONObject.optString("icon_url");
        }
    }
}
