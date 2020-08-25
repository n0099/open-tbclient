package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class an {
    public AlaLiveUserInfoData aIl;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aIl = new AlaLiveUserInfoData();
                this.aIl.parserJson(optJSONObject);
            }
        }
    }

    public boolean CT() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(an anVar) {
        if (anVar != null && anVar.type == this.type && anVar.rank == this.rank) {
            if (this.aIl == null || anVar.aIl == null) {
                return true;
            }
            return anVar.aIl.userId == this.aIl.userId;
        }
        return false;
    }
}
