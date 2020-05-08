package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends BaseData {
    public AlaLiveUserInfoData aqk;
    public AlaLocationData aql;
    public AlaRelationData aqm;
    public long aqn;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aqk = new AlaLiveUserInfoData();
                this.aqk.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aql = new AlaLocationData();
                this.aql.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aqm = new AlaRelationData();
                this.aqm.parserJson(optJSONObject3);
            }
            this.aqn = jSONObject.optLong("rank_num");
        }
    }
}
