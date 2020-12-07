package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p extends BaseData {
    public AlaLiveUserInfoData aJV;
    public AlaLocationData aJW;
    public AlaRelationData aJX;
    public long aJY;
    public int hadPoked;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aJV = new AlaLiveUserInfoData();
                this.aJV.parserJson(optJSONObject);
                this.hadPoked = optJSONObject.optInt("poke_flag", 0);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aJW = new AlaLocationData();
                this.aJW.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aJX = new AlaRelationData();
                this.aJX.parserJson(optJSONObject3);
            }
            this.aJY = jSONObject.optLong("rank_num");
            if (this.aJV == null) {
                try {
                    this.aJV = new AlaLiveUserInfoData();
                    this.aJV.parserJson(jSONObject);
                } catch (Exception e) {
                }
            }
        }
    }
}
