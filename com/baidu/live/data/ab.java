package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ab {
    public AlaLiveUserInfoData abH;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.abH = new AlaLiveUserInfoData();
                this.abH.parserJson(optJSONObject);
            }
        }
    }

    public boolean qK() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(ab abVar) {
        if (abVar != null && abVar.type == this.type && abVar.rank == this.rank) {
            if (this.abH == null || abVar.abH == null) {
                return true;
            }
            return abVar.abH.userId == this.abH.userId;
        }
        return false;
    }
}
