package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class u extends BaseData {
    public AlaLiveUserInfoData aJD;
    public AlaLocationData aJE;
    public AlaRelationData aJF;
    public long aJG;
    public int hadPoked;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aJD = new AlaLiveUserInfoData();
                this.aJD.parserJson(optJSONObject);
                this.hadPoked = optJSONObject.optInt("poke_flag", 0);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aJE = new AlaLocationData();
                this.aJE.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aJF = new AlaRelationData();
                this.aJF.parserJson(optJSONObject3);
            }
            this.aJG = jSONObject.optLong("rank_num");
            if (this.aJD == null) {
                try {
                    this.aJD = new AlaLiveUserInfoData();
                    this.aJD.parserJson(jSONObject);
                } catch (Exception e) {
                }
            }
        }
    }
}
