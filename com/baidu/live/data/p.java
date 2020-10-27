package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p extends BaseData {
    public AlaLiveUserInfoData aIe;
    public AlaLocationData aIf;
    public AlaRelationData aIg;
    public long aIh;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aIe = new AlaLiveUserInfoData();
                this.aIe.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aIf = new AlaLocationData();
                this.aIf.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aIg = new AlaRelationData();
                this.aIg.parserJson(optJSONObject3);
            }
            this.aIh = jSONObject.optLong("rank_num");
            if (this.aIe == null) {
                try {
                    this.aIe = new AlaLiveUserInfoData();
                    this.aIe.parserJson(jSONObject);
                } catch (Exception e) {
                }
            }
        }
    }
}
