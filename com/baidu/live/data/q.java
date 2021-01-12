package com.baidu.live.data;

import com.baidu.live.tbadk.core.data.BaseData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class q extends BaseData {
    public AlaLiveUserInfoData aFH;
    public AlaLocationData aFI;
    public AlaRelationData aFJ;
    public long aFK;
    public int hadPoked;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.aFH = new AlaLiveUserInfoData();
                this.aFH.parserJson(optJSONObject);
                this.hadPoked = optJSONObject.optInt("poke_flag", 0);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("location_info");
            if (optJSONObject2 != null) {
                this.aFI = new AlaLocationData();
                this.aFI.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("relation_info");
            if (optJSONObject3 != null) {
                this.aFJ = new AlaRelationData();
                this.aFJ.parserJson(optJSONObject3);
            }
            this.aFK = jSONObject.optLong("rank_num");
            if (this.aFH == null) {
                try {
                    this.aFH = new AlaLiveUserInfoData();
                    this.aFH.parserJson(jSONObject);
                } catch (Exception e) {
                }
            }
        }
    }
}
