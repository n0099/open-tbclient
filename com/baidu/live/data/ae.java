package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ae {
    public AlaLiveUserInfoData auk;
    public int rank;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.rank = jSONObject.optInt("rank");
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.auk = new AlaLiveUserInfoData();
                this.auk.parserJson(optJSONObject);
            }
        }
    }

    public boolean va() {
        return this.type == 1;
    }

    public boolean isFirst() {
        return this.rank == 1;
    }

    public boolean a(ae aeVar) {
        if (aeVar != null && aeVar.type == this.type && aeVar.rank == this.rank) {
            if (this.auk == null || aeVar.auk == null) {
                return true;
            }
            return aeVar.auk.userId == this.auk.userId;
        }
        return false;
    }
}
