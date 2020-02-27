package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ab {
    public AlaLiveUserInfoData abx;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.abx = new AlaLiveUserInfoData();
                this.abx.parserJson(optJSONObject);
            }
        }
    }

    public boolean qF() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(ab abVar) {
        if (abVar != null && abVar.type == this.type && abVar.rank == this.rank) {
            if (this.abx == null || abVar.abx == null) {
                return true;
            }
            return abVar.abx.userId == this.abx.userId;
        }
        return false;
    }
}
