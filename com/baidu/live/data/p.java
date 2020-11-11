package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p extends BaseData {
    public AlaLiveUserInfoData aIV;
    public AlaLocationData aIW;
    public AlaRelationData aIX;
    public long aIY;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aIV = new AlaLiveUserInfoData();
                this.aIV.parserJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aIW = new AlaLocationData();
                this.aIW.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aIX = new AlaRelationData();
                this.aIX.parserJson(optJSONObject3);
            }
            this.aIY = jSONObject.optLong("rank_num");
            if (this.aIV == null) {
                try {
                    this.aIV = new AlaLiveUserInfoData();
                    this.aIV.parserJson(jSONObject);
                } catch (Exception e) {
                }
            }
        }
    }
}
