package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m extends BaseData {
    public AlaLiveUserInfoData aHD;
    public AlaLocationData aHE;
    public AlaRelationData aHF;
    public long aHG;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aHD = new AlaLiveUserInfoData();
                this.aHD.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aHE = new AlaLocationData();
                this.aHE.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aHF = new AlaRelationData();
                this.aHF.parserJson(optJSONObject3);
            }
            this.aHG = jSONObject.optLong("rank_num");
            if (this.aHD == null) {
                try {
                    this.aHD = new AlaLiveUserInfoData();
                    this.aHD.parserJson(jSONObject);
                } catch (Exception e) {
                }
            }
        }
    }
}
