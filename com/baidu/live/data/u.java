package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class u extends BaseData {
    public AlaLiveUserInfoData aId;
    public AlaLocationData aIe;
    public AlaRelationData aIf;
    public long aIg;
    public int hadPoked;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aId = new AlaLiveUserInfoData();
                this.aId.parserJson(optJSONObject);
                this.hadPoked = optJSONObject.optInt("poke_flag", 0);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aIe = new AlaLocationData();
                this.aIe.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aIf = new AlaRelationData();
                this.aIf.parserJson(optJSONObject3);
            }
            this.aIg = jSONObject.optLong("rank_num");
            if (this.aId == null) {
                try {
                    this.aId = new AlaLiveUserInfoData();
                    this.aId.parserJson(jSONObject);
                } catch (Exception e) {
                }
            }
        }
    }
}
