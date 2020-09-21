package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m extends BaseData {
    public AlaLocationData aEA;
    public AlaRelationData aEB;
    public long aEC;
    public AlaLiveUserInfoData aEz;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aEz = new AlaLiveUserInfoData();
                this.aEz.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aEA = new AlaLocationData();
                this.aEA.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aEB = new AlaRelationData();
                this.aEB.parserJson(optJSONObject3);
            }
            this.aEC = jSONObject.optLong("rank_num");
            if (this.aEz == null) {
                try {
                    this.aEz = new AlaLiveUserInfoData();
                    this.aEz.parserJson(jSONObject);
                } catch (Exception e) {
                }
            }
        }
    }
}
