package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends BaseData {
    public AlaLiveUserInfoData Wf;
    public AlaLocationData Wg;
    public AlaRelationData Wh;
    public long Wi;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.Wf = new AlaLiveUserInfoData();
                this.Wf.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.Wg = new AlaLocationData();
                this.Wg.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.Wh = new AlaRelationData();
                this.Wh.parserJson(optJSONObject3);
            }
            this.Wi = jSONObject.optLong("rank_num");
        }
    }
}
