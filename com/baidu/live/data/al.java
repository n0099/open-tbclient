package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class al {
    public AlaLiveUserInfoData aDb;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aDb = new AlaLiveUserInfoData();
                this.aDb.parserJson(optJSONObject);
            }
        }
    }

    public boolean xq() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(al alVar) {
        if (alVar != null && alVar.type == this.type && alVar.rank == this.rank) {
            if (this.aDb == null || alVar.aDb == null) {
                return true;
            }
            return alVar.aDb.userId == this.aDb.userId;
        }
        return false;
    }
}
