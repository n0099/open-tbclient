package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j extends BaseData {
    public AlaLiveUserInfoData ayC;
    public AlaLocationData ayD;
    public AlaRelationData ayE;
    public long ayF;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.ayC = new AlaLiveUserInfoData();
                this.ayC.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.ayD = new AlaLocationData();
                this.ayD.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.ayE = new AlaRelationData();
                this.ayE.parserJson(optJSONObject3);
            }
            this.ayF = jSONObject.optLong("rank_num");
        }
    }
}
