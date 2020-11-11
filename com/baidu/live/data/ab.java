package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ab {
    public int aKg;
    public long aKh;
    public long aKi;
    public String division;
    public String iconUrl;
    public int maxStar;
    public String name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.division = jSONObject.optString("division");
            this.aKg = jSONObject.optInt("cur_star");
            this.maxStar = jSONObject.optInt("max_star", 5);
            this.aKh = jSONObject.optInt("min_score");
            this.aKi = jSONObject.optInt("max_score");
            this.name = jSONObject.optString("name");
            this.iconUrl = jSONObject.optString("icon_url");
        }
    }
}
