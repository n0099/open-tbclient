package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ay {
    public AlaLiveUserInfoData aPJ;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aPJ = new AlaLiveUserInfoData();
                this.aPJ.parserJson(optJSONObject);
            }
        }
    }

    public boolean FO() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(ay ayVar) {
        return ayVar != null && ayVar.type == this.type && ayVar.rank == this.rank && this.aPJ != null && ayVar.aPJ != null && ayVar.aPJ.userId == this.aPJ.userId;
    }
}
