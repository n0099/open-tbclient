package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ba {
    public AlaLiveUserInfoData aLL;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aLL = new AlaLiveUserInfoData();
                this.aLL.parserJson(optJSONObject);
            }
        }
    }

    public boolean Bj() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(ba baVar) {
        return baVar != null && baVar.type == this.type && baVar.rank == this.rank && this.aLL != null && baVar.aLL != null && baVar.aLL.userId == this.aLL.userId;
    }
}
