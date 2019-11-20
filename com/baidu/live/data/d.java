package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends BaseData {
    public AlaLiveUserInfoData OR;
    public AlaLocationData OT;
    public AlaRelationData OU;
    public long OV;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.OR = new AlaLiveUserInfoData();
                this.OR.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.OT = new AlaLocationData();
                this.OT.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.OU = new AlaRelationData();
                this.OU.parserJson(optJSONObject3);
            }
            this.OV = jSONObject.optLong("rank_num");
        }
    }
}
