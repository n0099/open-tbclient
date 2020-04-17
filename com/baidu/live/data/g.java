package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends BaseData {
    public AlaLiveUserInfoData aqe;
    public AlaLocationData aqf;
    public AlaRelationData aqg;
    public long aqh;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aqe = new AlaLiveUserInfoData();
                this.aqe.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aqf = new AlaLocationData();
                this.aqf.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aqg = new AlaRelationData();
                this.aqg.parserJson(optJSONObject3);
            }
            this.aqh = jSONObject.optLong("rank_num");
        }
    }
}
