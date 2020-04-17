package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ae {
    public AlaLiveUserInfoData aue;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aue = new AlaLiveUserInfoData();
                this.aue.parserJson(optJSONObject);
            }
        }
    }

    public boolean vb() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(ae aeVar) {
        if (aeVar != null && aeVar.type == this.type && aeVar.rank == this.rank) {
            if (this.aue == null || aeVar.aue == null) {
                return true;
            }
            return aeVar.aue.userId == this.aue.userId;
        }
        return false;
    }
}
