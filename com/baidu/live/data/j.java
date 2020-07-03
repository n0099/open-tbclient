package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j extends BaseData {
    public AlaLiveUserInfoData axp;
    public AlaLocationData axq;
    public AlaRelationData axr;
    public long axs;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.axp = new AlaLiveUserInfoData();
                this.axp.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.axq = new AlaLocationData();
                this.axq.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.axr = new AlaRelationData();
                this.axr.parserJson(optJSONObject3);
            }
            this.axs = jSONObject.optLong("rank_num");
        }
    }
}
