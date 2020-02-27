package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends BaseData {
    public AlaLiveUserInfoData XQ;
    public AlaLocationData XR;
    public AlaRelationData XS;
    public long XT;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.XQ = new AlaLiveUserInfoData();
                this.XQ.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.XR = new AlaLocationData();
                this.XR.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.XS = new AlaRelationData();
                this.XS.parserJson(optJSONObject3);
            }
            this.XT = jSONObject.optLong("rank_num");
        }
    }
}
