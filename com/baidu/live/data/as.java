package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class as {
    public AlaLiveUserInfoData aJI;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aJI = new AlaLiveUserInfoData();
                this.aJI.parserJson(optJSONObject);
            }
        }
    }

    public boolean Dj() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(as asVar) {
        return asVar != null && asVar.type == this.type && asVar.rank == this.rank && this.aJI != null && asVar.aJI != null && asVar.aJI.userId == this.aJI.userId;
    }
}
