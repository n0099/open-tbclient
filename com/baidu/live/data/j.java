package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j extends BaseData {
    public AlaLiveUserInfoData aDG;
    public AlaLocationData aDH;
    public AlaRelationData aDI;
    public long aDJ;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aDG = new AlaLiveUserInfoData();
                this.aDG.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aDH = new AlaLocationData();
                this.aDH.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aDI = new AlaRelationData();
                this.aDI.parserJson(optJSONObject3);
            }
            this.aDJ = jSONObject.optLong("rank_num");
        }
    }
}
