package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class aa {
    public AlaLiveUserInfoData ZC;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.ZC = new AlaLiveUserInfoData();
                this.ZC.parserJson(optJSONObject);
            }
        }
    }

    public boolean pU() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(aa aaVar) {
        if (aaVar != null && aaVar.type == this.type && aaVar.rank == this.rank) {
            if (this.ZC == null || aaVar.ZC == null) {
                return true;
            }
            return aaVar.ZC.userId == this.ZC.userId;
        }
        return false;
    }
}
