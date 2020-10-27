package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class av {
    public AlaLiveUserInfoData aNs;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aNs = new AlaLiveUserInfoData();
                this.aNs.parserJson(optJSONObject);
            }
        }
    }

    public boolean Ep() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(av avVar) {
        return avVar != null && avVar.type == this.type && avVar.rank == this.rank && this.aNs != null && avVar.aNs != null && avVar.aNs.userId == this.aNs.userId;
    }
}
