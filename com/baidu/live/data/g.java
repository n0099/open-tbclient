package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends BaseData {
    public AlaLiveUserInfoData Ya;
    public AlaLocationData Yb;
    public AlaRelationData Yc;
    public long Yd;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.Ya = new AlaLiveUserInfoData();
                this.Ya.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.Yb = new AlaLocationData();
                this.Yb.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.Yc = new AlaRelationData();
                this.Yc.parserJson(optJSONObject3);
            }
            this.Yd = jSONObject.optLong("rank_num");
        }
    }
}
