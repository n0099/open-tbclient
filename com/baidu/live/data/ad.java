package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ad {
    public int aLM;
    public long aLN;
    public long aLO;
    public String division;
    public String iconUrl;
    public int maxStar;
    public String name;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.division = jSONObject.optString("division");
            this.aLM = jSONObject.optInt("cur_star");
            this.maxStar = jSONObject.optInt("max_star", 5);
            this.aLN = jSONObject.optInt("min_score");
            this.aLO = jSONObject.optInt("max_score");
            this.name = jSONObject.optString("name");
            this.iconUrl = jSONObject.optString("icon_url");
        }
    }
}
