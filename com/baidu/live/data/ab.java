package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ab {
    public int aJj;
    public long aJk;
    public long aJl;
    public String division;
    public String iconUrl;
    public int maxStar;
    public String name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.division = jSONObject.optString("division");
            this.aJj = jSONObject.optInt("cur_star");
            this.maxStar = jSONObject.optInt("max_star", 5);
            this.aJk = jSONObject.optInt("min_score");
            this.aJl = jSONObject.optInt("max_score");
            this.name = jSONObject.optString("name");
            this.iconUrl = jSONObject.optString("icon_url");
        }
    }
}
