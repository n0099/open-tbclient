package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j extends BaseData {
    public AlaLiveUserInfoData aDE;
    public AlaLocationData aDF;
    public AlaRelationData aDG;
    public long aDH;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aDE = new AlaLiveUserInfoData();
                this.aDE.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aDF = new AlaLocationData();
                this.aDF.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aDG = new AlaRelationData();
                this.aDG.parserJson(optJSONObject3);
            }
            this.aDH = jSONObject.optLong("rank_num");
        }
    }
}
