package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p extends BaseData {
    public AlaLiveUserInfoData aHk;
    public AlaLocationData aHl;
    public AlaRelationData aHm;
    public long aHn;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aHk = new AlaLiveUserInfoData();
                this.aHk.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aHl = new AlaLocationData();
                this.aHl.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aHm = new AlaRelationData();
                this.aHm.parserJson(optJSONObject3);
            }
            this.aHn = jSONObject.optLong("rank_num");
            if (this.aHk == null) {
                try {
                    this.aHk = new AlaLiveUserInfoData();
                    this.aHk.parserJson(jSONObject);
                } catch (Exception e) {
                }
            }
        }
    }
}
