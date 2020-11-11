package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ax {
    public AlaLiveUserInfoData aOv;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aOv = new AlaLiveUserInfoData();
                this.aOv.parserJson(optJSONObject);
            }
        }
    }

    public boolean EM() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(ax axVar) {
        return axVar != null && axVar.type == this.type && axVar.rank == this.rank && this.aOv != null && axVar.aOv != null && axVar.aOv.userId == this.aOv.userId;
    }
}
