package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends BaseData {
    public AlaLiveUserInfoData Ps;
    public AlaLocationData Pt;
    public AlaRelationData Pu;
    public long Pv;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.Ps = new AlaLiveUserInfoData();
                this.Ps.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.Pt = new AlaLocationData();
                this.Pt.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.Pu = new AlaRelationData();
                this.Pu.parserJson(optJSONObject3);
            }
            this.Pv = jSONObject.optLong("rank_num");
        }
    }
}
