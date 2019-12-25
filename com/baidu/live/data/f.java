package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends BaseData {
    public AlaLiveUserInfoData VP;
    public AlaLocationData VQ;
    public AlaRelationData VR;
    public long VS;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.VP = new AlaLiveUserInfoData();
                this.VP.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.VQ = new AlaLocationData();
                this.VQ.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.VR = new AlaRelationData();
                this.VR.parserJson(optJSONObject3);
            }
            this.VS = jSONObject.optLong("rank_num");
        }
    }
}
