package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class z {
    public int aII;
    public long aIJ;
    public long aIK;
    public String division;
    public String iconUrl;
    public int maxStar;
    public String name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.division = jSONObject.optString("division");
            this.aII = jSONObject.optInt("cur_star");
            this.maxStar = jSONObject.optInt("max_star", 5);
            this.aIJ = jSONObject.optInt("min_score");
            this.aIK = jSONObject.optInt("max_score");
            this.name = jSONObject.optString("name");
            this.iconUrl = jSONObject.optString("icon_url");
        }
    }
}
