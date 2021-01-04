package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ba {
    public AlaLiveUserInfoData aQy;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aQy = new AlaLiveUserInfoData();
                this.aQy.parserJson(optJSONObject);
            }
        }
    }

    public boolean Fe() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(ba baVar) {
        return baVar != null && baVar.type == this.type && baVar.rank == this.rank && this.aQy != null && baVar.aQy != null && baVar.aQy.userId == this.aQy.userId;
    }
}
