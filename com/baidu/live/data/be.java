package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class be {
    public AlaLiveUserInfoData aOI;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aOI = new AlaLiveUserInfoData();
                this.aOI.parserJson(optJSONObject);
            }
        }
    }

    public boolean Cw() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(be beVar) {
        return beVar != null && beVar.type == this.type && beVar.rank == this.rank && this.aOI != null && beVar.aOI != null && beVar.aOI.userId == this.aOI.userId;
    }
}
