package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j extends BaseData {
    public AlaLiveUserInfoData avj;
    public AlaLocationData avk;
    public AlaRelationData avl;
    public long avm;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.avj = new AlaLiveUserInfoData();
                this.avj.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.avk = new AlaLocationData();
                this.avk.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.avl = new AlaRelationData();
                this.avl.parserJson(optJSONObject3);
            }
            this.avm = jSONObject.optLong("rank_num");
        }
    }
}
