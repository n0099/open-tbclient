package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ak {
    public AlaLiveUserInfoData aBG;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aBG = new AlaLiveUserInfoData();
                this.aBG.parserJson(optJSONObject);
            }
        }
    }

    public boolean wN() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(ak akVar) {
        if (akVar != null && akVar.type == this.type && akVar.rank == this.rank) {
            if (this.aBG == null || akVar.aBG == null) {
                return true;
            }
            return akVar.aBG.userId == this.aBG.userId;
        }
        return false;
    }
}
