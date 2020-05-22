package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ai {
    public AlaLiveUserInfoData azo;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.azo = new AlaLiveUserInfoData();
                this.azo.parserJson(optJSONObject);
            }
        }
    }

    public boolean wp() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(ai aiVar) {
        if (aiVar != null && aiVar.type == this.type && aiVar.rank == this.rank) {
            if (this.azo == null || aiVar.azo == null) {
                return true;
            }
            return aiVar.azo.userId == this.azo.userId;
        }
        return false;
    }
}
