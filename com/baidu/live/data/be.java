package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class be {
    public AlaLiveUserInfoData aQi;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aQi = new AlaLiveUserInfoData();
                this.aQi.parserJson(optJSONObject);
            }
        }
    }

    public boolean Cz() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(be beVar) {
        return beVar != null && beVar.type == this.type && beVar.rank == this.rank && this.aQi != null && beVar.aQi != null && beVar.aQi.userId == this.aQi.userId;
    }
}
